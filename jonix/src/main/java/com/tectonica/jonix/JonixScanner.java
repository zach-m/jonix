package com.tectonica.jonix;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.tectonica.jonix.JonixParser.JonixFactory;
import com.tectonica.jonix.JonixParser.JonixParserListener;
import org.xml.sax.SAXException;

/**
 * Convenience abstract base class for iterating through ONIX records in various ONIX sources (implemented as {@link InputStream}), one at
 * the time. What makes it abstract is that there's no default implementation for {@link #onHeader(JonixTag)} and
 * {@link #onProduct(JonixTag, int)} which get invoked when a processing of an ONIX record has been completed. There are other events in
 * addition to these two, but they don't require custom implementation.
 * <p>
 * This class prints log messages and status updates into a log stream. The user may override the default (which is <code>System.err</code>)
 * if needed.
 * <p>
 * The main method provided by this class is {@link #scan(JonixPackages, InputStream, String)}.
 * <p>
 * The class provides two basic services:
 * <ul>
 * <li>Parser caching - one instance of parser is lazily created per each ONIX package when an ONIX source of that package is actually used
 * <li>Output management - setters/getters for the outputting text and log messages
 * </ul>
 * An instance of this class (or subclasses) can be reused to scan more and more sources in repeated invocations of
 * {@link #scan(JonixPackages, InputStream, String)}.
 * 
 * @author Zach Melamed
 * 
 * @param <H>
 *            the {@link JonixTag} representing the HEADER tag of each ONIX record
 * @param <P>
 *            the {@link JonixTag} representing the PRODUCT tag of each ONIX record
 */
public abstract class JonixScanner<H extends JonixTag, P extends JonixTag>
{
	public static final String DEFAULT_OUTPUT_CHARSET = "UTF8";

	protected Map<JonixPackages, JonixParser<H, P>> parsersMap = new HashMap<JonixPackages, JonixParser<H, P>>();

	protected PrintStream log = System.err;
	protected JonixFactory<H, P> factory;

	public JonixScanner(JonixFactory<H, P> factory)
	{
		this.factory = factory;
	}

	/**
	 * Creates a Scanner, capable of going over an {@link InputStream} and fire events whenever a HEADER or PRODUCT are processed
	 * 
	 * @param jonixFactory
	 *            Factory for generating a new, empty, HEADER or PRODUCT class, that will later process the raw data and retain the results
	 * @param log
	 *            A stream into which status and error messages will be sent
	 */
	public JonixScanner(JonixFactory<H, P> jonixFactory, PrintStream log)
	{
		this(jonixFactory);
		setLog(log);
	}

	public void setLog(PrintStream log)
	{
		this.log = (log == null) ? System.err : log;
	}

	public void setLog(String fileName) throws UnsupportedEncodingException, FileNotFoundException
	{
		this.log = new PrintStream(fileName, DEFAULT_OUTPUT_CHARSET);
	}

	public PrintStream getLog()
	{
		return log;
	}

	/**
	 * Given an ONIX source and its expected package, this method parses its records and fire events for the caller to use
	 */
	public void scan(JonixPackages jonixPackage, InputStream source, String charsetName)
	{
		if (onBeforeSource(jonixPackage, source))
		{
			JonixParser<H, P> parser = getParser(jonixPackage);
			try
			{
				doScan(parser, source, charsetName);
			}
			catch (Exception e)
			{
				throw new RuntimeException(e);
			}
			onAfterSource();
		}
	}

	private JonixParser<H, P> getParser(JonixPackages jonixPackage)
	{
		JonixParser<H, P> parser = parsersMap.get(jonixPackage);
		if (parser == null)
			parsersMap.put(jonixPackage, parser = initializeParser(jonixPackage, false));
		return parser;
	}

	/**
	 * initializes the parser (to be called by a subclass before performing the actual exporting)
	 */
	protected JonixParser<H, P> initializeParser(JonixPackages jonixPackage, boolean quiet)
	{
		if (!quiet)
			log.println("Initializing Parser for " + jonixPackage.name() + "..");

		try
		{
			JonixParser<H, P> parser = new JonixParser<H, P>(jonixPackage, factory);
			parser.setJonixParserListener(new JonixParserListener<H, P>()
			{
				@Override
				public void onHeader(H header)
				{
					JonixScanner.this.onHeader(header);
				}

				@Override
				public void onProduct(P product, int index)
				{
					JonixScanner.this.onProduct(product, index);
				}
			});
			return parser;
		}
		catch (Exception e)
		{
			throw new RuntimeException("Severe internal error - Couldn't initialize the parser", e);
		}
	}

	// OVERRIDE CANDIDATES:

	protected boolean onBeforeSource(JonixPackages jonixPackage, InputStream source)
	{
		return true;
	}

	protected void doScan(JonixParser<H, P> parser, InputStream source, String charsetName) throws IOException, SAXException
	{
		parser.parse(source, charsetName);
	}

	protected abstract void onHeader(H header);

	protected abstract void onProduct(P product, int index);

	protected void onAfterSource()
	{
		log.flush();
	}
}
