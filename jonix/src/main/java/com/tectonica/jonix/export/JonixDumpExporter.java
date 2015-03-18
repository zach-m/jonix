package com.tectonica.jonix.export;

import java.io.PrintStream;

import com.tectonica.jonix.JonixParser.JonixFactory;
import com.tectonica.jonix.JonixTag;

/**
 * A raw-data exporter. For each ONIX source scanned, it outputs the entire Product object that resulted in from it. This gives us a glimpse into
 * what the parser extracted from the file, without concerning ourselves with formatting issues.
 * 
 * @author Zach Melamed
 * 
 * @param <H>
 *            the {@link JonixTag} representing the HEADER tag of each ONIX record
 * @param <P>
 *            the {@link JonixTag} representing the PRODUCT tag of each ONIX record
 */
public class JonixDumpExporter<H extends JonixTag, P extends JonixTag> extends JonixFilesExport<H, P>
{
	public JonixDumpExporter(JonixFactory<H, P> jonixFactory)
	{
		super(jonixFactory);
	}

	public JonixDumpExporter(JonixFactory<H, P> jonixFactory, PrintStream out, PrintStream log)
	{
		super(jonixFactory, out, log);
	}

	@Override
	protected void onProduct(P product, int index)
	{
		super.onProduct(product, index);

		out.println(product.toString());
		out.println("**********************************************************************************\n");
	}
}
