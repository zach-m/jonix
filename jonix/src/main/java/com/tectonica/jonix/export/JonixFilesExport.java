package com.tectonica.jonix.export;

import java.io.PrintStream;
import java.util.List;

import com.tectonica.jonix.JonixFilesScanner;
import com.tectonica.jonix.JonixParser.JonixFactory;
import com.tectonica.jonix.JonixTag;

/**
 * An all-purpose abstract base-class for exporting ONIX sources included in files and folders.
 * 
 * @author Zach Melamed
 * 
 * @param <H>
 *            the {@link JonixTag} representing the HEADER tag of each ONIX record
 * @param <P>
 *            the {@link JonixTag} representing the PRODUCT tag of each ONIX record
 */
public abstract class JonixFilesExport<H extends JonixTag, P extends JonixTag> extends JonixFilesScanner<H, P>
{
	public JonixFilesExport(JonixFactory<H, P> jonixFactory)
	{
		super(jonixFactory);
	}

	/**
	 * Creates a files exporter, capable of going over files and folders and fire events whenever a HEADER or PRODUCT are processed
	 * 
	 * @param jonixFactory
	 *            Factory for generating a new, empty, HEADER or PRODUCT class, that will later process the raw data and retain the results
	 * @param out
	 *            A stream into which the output of the scanning is intended
	 * @param log
	 *            A stream into which status and error messages will be sent
	 */
	public JonixFilesExport(JonixFactory<H, P> jonixFactory, PrintStream out, PrintStream log)
	{
		super(jonixFactory, out, log);
	}

	@Override
	protected boolean onBeforeFiles(List<String> onixFileNames)
	{
		log.println("Parsing " + onixFileNames.size() + " files");
		return true;
	}

	@Override
	protected void onAfterFiles()
	{
		log.println("** DONE **");
	}

	@Override
	protected boolean onBeforeFile(String fileName)
	{
		log.println("opening " + fileName + ".. ");
		return true;
	}

	@Override
	protected void onHeader(H header)
	{
		logHeaderParseSummary(header);
	}

	@Override
	protected void onProduct(P product, int index)
	{
		logProductParseSummary(product, index);
	}

	protected void logHeaderParseSummary(H header)
	{
		log.println("-----------------------------------------------------------\n");
		log.println(header.toString());
		log.println("-----------------------------------------------------------\n");
	}

	protected void logProductParseSummary(P product, int index)
	{
		// show a log message about the product being successfully parsed
		log.println("parsed product #" + index + " - " + product.getLabel());
	}
}
