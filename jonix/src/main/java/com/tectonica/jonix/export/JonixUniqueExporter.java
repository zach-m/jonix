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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import com.tectonica.jonix.JonixColumn;
import com.tectonica.jonix.JonixFormatter;
import com.tectonica.jonix.JonixUtils;
import com.tectonica.jonix.basic.BasicHeader;
import com.tectonica.jonix.basic.BasicProduct3;

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
	 * a wrapper for {@link BasicProduct3} with some exxtra information needed for sorting and filtering
	 */
	protected static class ProductEx implements Comparable<ProductEx>
	{
		public final String _id;
		public final Calendar _timestamp;
		public final BasicProduct3 _product;

		public ProductEx(String id, Calendar timestamp, BasicProduct3 product)
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
		lastFileTimestamp = JonixUtils.extractTimstampFromOnixFileName(fileName);

		if (lastFileTimestamp == null)
		{
			lastFileTimestamp = new GregorianCalendar();
			lastFileTimestamp.setTimeInMillis((new File(fileName)).lastModified());
		}

		// if no columns-set was explicitly set, ask for the default one
		if (columns == null)
			columns = BasicProduct3.getDefaultColumns();
		if (idColumn == null)
			idColumn = BasicProduct3.getDefaultIdColumn();

		return super.onBeforeFile(fileName);
	}

	@Override
	protected void logHeaderParseSummary(BasicHeader header)
	{
		// in this particular exporter, we prefer not printing header information to the log
	}

	@Override
	protected void onProduct(BasicProduct3 product, int index)
	{
		super.onProduct(product, index);

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
			out.println(JonixFormatter.productAsTabDelimitedString(productEx._product, columns)
					+ extraConstColumnValues);
	}

}
