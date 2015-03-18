package com.tectonica.jonix.export;

import java.io.PrintStream;

import com.tectonica.jonix.JonixColumn;
import com.tectonica.jonix.JonixFormatter;
import com.tectonica.jonix.JonixParser.JonixFactory;
import com.tectonica.jonix.JonixTag;
import com.tectonica.jonix.JonixTagColumnable;

/**
 * An ONIX-2-TEXT exporter. Returns a tab-delimited grid, where each row represents one ONIX record, and each column an item of interest.
 * Clearly, not all records have all fields, yet the output of this process is always tabular, with possible blank values. The records are
 * formatted in accordance with the internal <code>columns</code> array, which defines both the order and the types of the resulting
 * table's columns.
 * 
 * @author Zach Melamed
 * 
 * @param <H>
 *            the {@link JonixTag} representing the HEADER tag of each ONIX record
 * @param <P>
 *            the {@link JonixTag} representing the PRODUCT tag of each ONIX record
 */
public class JonixTabDelimitedExporter<H extends JonixTag, P extends JonixTagColumnable> extends JonixFilesExport<H, P>
{
	protected JonixColumn<P>[] columns;

	public JonixTabDelimitedExporter(JonixFactory<H, P> jonixFactory)
	{
		super(jonixFactory);
	}

	/**
	 * Creates a files exporter, capable of going over files and folders and output their ONIX content as a table
	 * 
	 * @param jonixFactory
	 *            Factory for generating a new, empty, HEADER or PRODUCT class, that will later process the raw data and retain the results
	 * @param out
	 *            A stream into which the output of the scanning is intended
	 * @param log
	 *            A stream into which status and error messages will be sent
	 */
	public JonixTabDelimitedExporter(JonixFactory<H, P> jonixFactory, PrintStream out, PrintStream log)
	{
		super(jonixFactory, out, log);
	}

	public JonixColumn<P>[] getColumns()
	{
		return columns;
	}

	/**
	 * Sets which columns to output. If not provided, the product itself may provide a default set array.
	 * 
	 * @param columns
	 */
	public void setColumns(JonixColumn<P>[] columns)
	{
		this.columns = columns;
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

		onExportProduct(product);
	}

	/**
	 * Override this method to generate your own needed output. By default generates tab-delimited output.
	 */
	protected void onExportProduct(P product)
	{
		out.println(JonixFormatter.productAsTabDelimitedString(product, columns));
	}
}
