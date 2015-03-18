package com.tectonica.jonix.export;

import java.io.PrintStream;
import java.util.List;

import com.tectonica.jonix.JonixParser.JonixFactory;
import com.tectonica.jonix.JonixTag;

/**
 * An all-in-memory base-class exporter. Fills a user-provided {@link List} with all ONIX products scanned. This List effectively replaces the {@code out}
 * parameter from the base class. Subclass if you need some post-processing before outputting.
 * 
 * @author Zach Melamed
 * 
 * @param <H>
 *            the {@link JonixTag} representing the HEADER tag of each ONIX record
 * @param <P>
 *            the {@link JonixTag} representing the PRODUCT tag of each ONIX record
 */
public class JonixInMemExporter<H extends JonixTag, P extends JonixTag> extends JonixFilesExport<H, P>
{
	protected List<P> output;

	public JonixInMemExporter(JonixFactory<H, P> jonixFactory, List<P> output, PrintStream log)
	{
		super(jonixFactory, null, log);
		if (output == null)
			throw new NullPointerException();
		this.output = output;
	}

	@Override
	public void onProduct(P product, int index)
	{
		super.onProduct(product, index);

		output.add(product);
	}
}
