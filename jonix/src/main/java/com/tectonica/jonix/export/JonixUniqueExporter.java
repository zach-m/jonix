/*
 * Copyright (C) 2012 Zach Melamed
 * 
 * Latest version available online at https://github.com/zach-m/jonix
 * Contact me at zach@tectonica.co.il
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tectonica.jonix.export;

import java.io.File;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.tectonica.jonix.JonixColumn;
import com.tectonica.jonix.JonixFormatter;
import com.tectonica.jonix.basic.BasicHeader;
import com.tectonica.jonix.basic.BasicProduct;

public class JonixUniqueExporter extends JonixFilesExport
{
	public JonixUniqueExporter()
	{
		super();
	}

	public JonixUniqueExporter(PrintStream out, PrintStream log)
	{
		super(out, log);
	}

	protected JonixColumn[] columns;
	protected JonixColumn idColumn;

	public JonixColumn[] getColumns()
	{
		return columns;
	}

	public void setColumns(JonixColumn[] columns)
	{
		this.columns = columns;
	}

	public JonixColumn getIdColumn()
	{
		return idColumn;
	}

	public void setIdColumn(JonixColumn idColumn)
	{
		this.idColumn = idColumn;
	}

	protected String extraConstColumnNames;
	protected String extraConstColumnValues;

	public void setExtraConstColumns(String columnName, String columnValue)
	{
		this.extraConstColumnNames = columnName;
		this.extraConstColumnValues = columnValue;
	}

	/**
	 * a wrapper for {@link BasicProduct} with some exxtra information needed for sorting and filtering
	 */
	protected static class ProductEx implements Comparable<ProductEx>
	{
		public final String _id;
		public final Calendar _timestamp;
		public final BasicProduct _product;

		public ProductEx(String id, Calendar timestamp, BasicProduct product)
		{
			this._id = id;
			this._timestamp = timestamp;
			this._product = product;
		}

		/**
		 * sort the records by ascending order of ID, and then by descending order of timestamp
		 */
		@Override
		public int compareTo(ProductEx o)
		{
			int result = _id.compareTo(o._id);
			return (result == 0) ? (-_timestamp.compareTo(o._timestamp)) : result;
		}
	}

	protected List<ProductEx> productsEx;

	@Override
	protected boolean onBeforeFiles(List<String> onixFileNames)
	{
		productsEx = new ArrayList<ProductEx>();
		return true;
	}

	private Calendar lastFileTimestamp;

	@Override
	protected boolean onBeforeFile(String fileName)
	{
		lastFileTimestamp = extractTimstampFromOnixFileName(fileName);

		if (lastFileTimestamp == null)
		{
			lastFileTimestamp = new GregorianCalendar();
			lastFileTimestamp.setTimeInMillis((new File(fileName)).lastModified());
		}

		return super.onBeforeFile(fileName);
	}

	@Override
	protected void logHeaderParseSummary(BasicHeader header)
	{
		// in this particular exporter, we prefer not printing header information to the log
	}

	@Override
	protected void onProduct(BasicProduct product, int index)
	{
		super.onProduct(product, index);

		// on first product, if no columns-set was explicitly set, ask for the default one
		if (this.columns == null)
			columns = product.getDefaultColumns();
		if (columns == null)
			throw new NullPointerException("No columns are set for output");

		if (idColumn == null)
			idColumn = product.getDefaultIdColumn();
		if (idColumn == null)
			throw new NullPointerException("Id column is not specified");

		String[] idData = JonixFormatter.allocateMem(idColumn);

		if (idColumn.extractTo(idData, product))
			productsEx.add(new ProductEx(idData[0], lastFileTimestamp, product));
	}

	@Override
	protected void onAfterFiles()
	{
		log.println("Sorting " + productsEx.size() + " products..");
		Collections.sort(productsEx);

		log.println("Cleaning up..");
		List<ProductEx> filteredProductsEx = new ArrayList<ProductEx>();
		String lastId = null;
		for (ProductEx productEx : productsEx)
		{
			if (productEx._id.equals(lastId))
				continue;
			filteredProductsEx.add(productEx);
			lastId = productEx._id;
		}
		productsEx = null;

		log.println("Exporting " + filteredProductsEx.size() + " products..");
		onExportUniqueList(filteredProductsEx);

		log.println("** DONE **");
	}

	/**
	 * Override this method to generate your own needed output. By default generates tab-delimited output.
	 */
	protected void onExportUniqueList(List<ProductEx> productsEx)
	{
		out.println(JonixFormatter.headerAsTabDelimitedString(columns) + extraConstColumnNames);
		for (ProductEx productEx : productsEx)
			out.println(JonixFormatter.productAsTabDelimitedString(productEx._product, columns) + extraConstColumnValues);
	}

	private static final Pattern timestampPattern = Pattern.compile("[^0-9]([0-9]{4,14})(?=[_\\.])");

	private static final String[] FORMATS = { "hhmm", "hhmmss", "yyyyMMdd", "yyyyMMddhhmm", "yyyyMMddhhmmss" };

	private static boolean[] FORMAT_HAS_DATE;
	private static boolean[] FORMAT_HAS_TIME;
	private static DateFormat[] PARSERS;
	static
	{
		PARSERS = new DateFormat[FORMATS.length];
		FORMAT_HAS_DATE = new boolean[FORMATS.length];
		FORMAT_HAS_TIME = new boolean[FORMATS.length];
		for (int i = 0; i < FORMATS.length; i++)
		{
			PARSERS[i] = new SimpleDateFormat(FORMATS[i]);
			FORMAT_HAS_DATE[i] = FORMATS[i].contains("yyyy");
			FORMAT_HAS_TIME[i] = FORMATS[i].contains("hh");
		}
	}

	/**
	 * Attempts to retrieve a time-stamp from a given file-name. Looks for the following constructs in the filename:
	 * <ul>
	 * <li> <code>hhmm</code>
	 * <li> <code>hhmmss</code>
	 * <li> <code>yyyyMMdd</code>
	 * <li> <code>yyyyMMddhhmm</code>
	 * <li> <code>yyyyMMddhhmmss</code>
	 * </ul>
	 * 
	 * @param fileName
	 *            the file-name from which to extract the time-stamp
	 * @return
	 *         the extracted time-stamp, or null if such time-stamp couldn't be extracted
	 */
	private Calendar extractTimstampFromOnixFileName(String fileName)
	{
		Matcher matcher = timestampPattern.matcher(fileName);
		Calendar aux = new GregorianCalendar();
		int yyyy = 0, MM = 0, dd = 0, hh = 0, mm = 0, ss = 0;
		while (matcher.find())
		{
			String value = matcher.group(1);
			for (int i = 0; i < FORMATS.length; i++)
			{
				if (value.length() == FORMATS[i].length())
				{
					Date timestamp = null;
					try
					{
						timestamp = PARSERS[i].parse(value);
					}
					catch (ParseException e)
					{
						continue;
					}
					aux.setTime(timestamp);
					if (FORMAT_HAS_DATE[i])
					{
						yyyy = aux.get(Calendar.YEAR);
						MM = aux.get(Calendar.MONTH);
						dd = aux.get(Calendar.DAY_OF_MONTH);
					}
					if (FORMAT_HAS_TIME[i])
					{
						hh = aux.get(Calendar.HOUR);
						mm = aux.get(Calendar.MINUTE);
						ss = aux.get(Calendar.SECOND);
					}
				}
			}
		}
		if (yyyy > 0)
			return new GregorianCalendar(yyyy, MM, dd, hh, mm, ss);
		return null;
	}
}
