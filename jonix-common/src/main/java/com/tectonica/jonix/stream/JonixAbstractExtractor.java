package com.tectonica.jonix.stream;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.w3c.dom.Element;

public abstract class JonixAbstractExtractor
{
	protected abstract void onHeaderElement(Element header, JonixAbstractStreamer streamer);

	protected abstract void onProductElement(Element product, JonixAbstractStreamer streamer);

	// /////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * return false here to skip this particular source
	 * 
	 * @param source
	 * @return
	 */
	protected boolean onBeforeSource(InputStream source, JonixAbstractStreamer streamer)
	{
		return true;
	}

	protected void onAfterSource(JonixAbstractStreamer streamer)
	{}

	// /////////////////////////////////////////////////////////////////////////////////////////

	protected PrintStream logger = System.err;

	public JonixAbstractExtractor setLogger(String fileName) throws UnsupportedEncodingException, FileNotFoundException
	{
		return setLogger(new PrintStream(fileName, "UTF-8"));
	}

	public JonixAbstractExtractor setLogger(PrintStream logger)
	{
		this.logger = (logger == null) ? System.err : logger;
		return this;
	}

	public PrintStream getLogger()
	{
		return logger; // never a null
	}

	public void log(String x)
	{
		logger.println(x);
	}

	public void logf(String format, Object... args)
	{
		logger.printf(format, args);
	}

	public void logStackTrace(Throwable e)
	{
		e.printStackTrace(logger);
	}
}
