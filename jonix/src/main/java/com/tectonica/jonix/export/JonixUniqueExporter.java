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
import com.tectonica.jonix.JonixParser.JonixFactory;
import com.tectonica.jonix.JonixTagColumnable;
import com.tectonica.jonix.JonixTag;

/**
 * An ONIX-2-TEXT exporter with one major addition: it filter out records with the same user-defined ID field (for example, ISBN), in such a
 * way that only the newest record (the one with the latest time-stamp) gets to be output. Extracting the time-stamp of an ONIX file is also
 * tricky: the naive approach is to take the time-stamp from the file-system, which is also the fall back in the implementation here, but
 * the more industry-inspired approach is to look for a time-stamp embedded in the file-name, as done in the method
 * {@link #extractTimstampFromOnixFileName(String)}.
 * <p>
 * This class accumulates the ONIX records in memory, then sorts them by the ID field and timestamp, following by eliminating the non-latest
 * records of each ID. Then, it calls {@link #onExportUniqueList(List)} which does the actual outputting into the stream in a tab-delimited
 * format. Subclasses may override only this specific method to benefit from all the filtering logic, without being committed to a
 * particular output format.
 * <p>
 * In addition to that, this class allows augmenting the tab-delimited output with constant column(s) (such as "processing-time", etc.) by
 * calling {@link #setExtraConstColumns(String, String)}.
 * 
 * @author Zach Melamed
 * 
 * @param <H>
 *            the {@link JonixTag} representing the HEADER tag of each ONIX record
 * @param <P>
 *            the {@link JonixTag} representing the PRODUCT tag of each ONIX record
 */
public class JonixUniqueExporter<H extends JonixTag, P extends JonixTagColumnable> extends JonixFilesExport<H, P>
{
	public JonixUniqueExporter(JonixFactory<H, P> jonixFactory)
	{
		super(jonixFactory);
	}

	/**
	 * Creates a files exporter, capable of going over files and folders, filter duplicates, and output their ONIX content as a table
	 * 
	 * @param jonixFactory
	 *            Factory for generating a new, empty, HEADER or PRODUCT class, that will later process the raw data and retain the results
	 * @param out
	 *            A stream into which the output of the scanning is intended
	 * @param log
	 *            A stream into which status and error messages will be sent
	 */
	public JonixUniqueExporter(JonixFactory<H, P> jonixFactory, PrintStream out, PrintStream log)
	{
		super(jonixFactory, out, log);
	}

	protected JonixColumn<P>[] columns;
	protected JonixColumn<P> idColumn;

	public JonixColumn<P>[] getColumns()
	{
		return columns;
	}

	public void setColumns(JonixColumn<P>[] columns)
	{
		this.columns = columns;
	}

	public JonixColumn<P> getIdColumn()
	{
		return idColumn;
	}

	public void setIdColumn(JonixColumn<P> idColumn)
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
	 * a wrapper for {@link P} with some exxtra information needed for sorting and filtering
	 */
	protected static class ProductEx<P> implements Comparable<ProductEx<P>>
	{
		public final String _id;
		public final Calendar _timestamp;
		public final P _product;

		public ProductEx(String id, Calendar timestamp, P product)
		{
			this._id = id;
			this._timestamp = timestamp;
			this._product = product;
		}

		/**
		 * sort the records by ascending order of ID, and then by descending order of timestamp
		 */
		@Override
		public int compareTo(ProductEx<P> o)
		{
			int result = _id.compareTo(o._id);
			return (result == 0) ? (-_timestamp.compareTo(o._timestamp)) : result;
		}
	}

	protected List<ProductEx<P>> productsEx;

	@Override
	protected boolean onBeforeFiles(List<String> onixFileNames)
	{
		productsEx = new ArrayList<ProductEx<P>>();
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
	protected void logHeaderParseSummary(H header)
	{
		// in this particular exporter, we prefer not printing header information to the log
	}

	@Override
	protected void onProduct(P product, int index)
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
			productsEx.add(new ProductEx<P>(idData[0], lastFileTimestamp, product));
	}

	@Override
	protected void onAfterFiles()
	{
		log.println("Sorting " + productsEx.size() + " products..");
		Collections.sort(productsEx);

		log.println("Cleaning up..");
		List<ProductEx<P>> filteredProductsEx = new ArrayList<ProductEx<P>>();
		String lastId = null;
		for (ProductEx<P> productEx : productsEx)
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
	protected void onExportUniqueList(List<ProductEx<P>> productsEx)
	{
		out.println(JonixFormatter.headerAsTabDelimitedString(columns) + extraConstColumnNames);
		for (ProductEx<P> productEx : productsEx)
			out.println(JonixFormatter.productAsTabDelimitedString(productEx._product, columns) + extraConstColumnValues);
	}

	private static final Pattern timestampPattern = Pattern.compile("[^0-9]([0-9]{4,14})(?=[_\\.])");

	private static final String[] FORMATS =
		{ "hhmm", "hhmmss", "yyyyMMdd", "yyyyMMddhhmm", "yyyyMMddhhmmss" };

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
