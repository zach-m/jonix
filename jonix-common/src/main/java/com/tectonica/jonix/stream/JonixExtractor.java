package com.tectonica.jonix.stream;

import java.util.List;

public abstract class JonixExtractor extends JonixAbstractExtractor
{
	protected boolean onBeforeFileList(List<String> fileNames, JonixAbstractStreamer streamer)
	{
		return true;
	}

	/**
	 * return false here to skip this particular file
	 * 
	 * @param fileName
	 * @return
	 */
	protected boolean onBeforeFile(String fileName, JonixAbstractStreamer streamer)
	{
		return true;
	}

	protected void onAfterFileList(List<String> processedFileNames, JonixAbstractStreamer streamer)
	{}

	public String onGetFileEncoding(String fileName, JonixAbstractStreamer streamer)
	{
		return "UTF-8";
	}
}