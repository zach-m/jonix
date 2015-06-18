package com.tectonica.jonix.stream;

import java.util.List;

public abstract class JonixAbstractFilesExtractor extends JonixAbstractExtractor
{
	protected boolean onBeforeFileList(List<String> fileNames, JonixStreamer streamer)
	{
		return true;
	}

	/**
	 * return false here to skip this particular file
	 * 
	 * @param fileName
	 * @return
	 */
	protected boolean onBeforeFile(String fileName, JonixStreamer streamer)
	{
		return true;
	}

	protected void onAfterFileList(List<String> processedFileNames, JonixStreamer streamer)
	{}

	public String onGetFileEncoding(String fileName, JonixStreamer streamer)
	{
		return "UTF-8";
	}
}