package com.tectonica.jonix.stream;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import org.w3c.dom.Element;

public abstract class JonixListener
{
	// TODO: should we prevent access to these 4 fields from the subclasses as well
	protected JonixReader reader;
	protected PrintStream log = System.err;
	protected int productNo = 0;
	protected boolean onix2 = false;
	protected boolean onix3 = false;

	public int getProductNo()
	{
		return productNo;
	}

	public boolean isOnix2()
	{
		return onix2;
	}

	public boolean isOnix3()
	{
		return onix3;
	}

	protected boolean onBeforeSource(InputStream source)
	{
		return true;
	}

	protected void onAfterSource()
	{}

	protected boolean onBeforeFileList(List<String> fileNames)
	{
		return true;
	}

	protected boolean onBeforeFile(String fileName)
	{
		return true;
	}

	protected void onAfterFileList(List<String> processedFileNames)
	{}

	public String getFileEncoding(String fileName)
	{
		return "UTF-8";
	}

	protected abstract void onHeaderElement(Element header);

	protected abstract void onProductElement(Element product);
}