/*
 * Copyright (C) 2012 Zach Melamed
 * 
 * Latest version available online at https://github.com/zach-m/jonix
 * Contact me at zach@tectonica.co.il
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tectonica.jonix.stream;

import java.util.List;

/**
 * Simple extension of {@link JonixExtractor} adding events related for file-processing, fired by a
 * {@link JonixFilesStreamer}. Doesn't add any new abstract methods, hence puts no additional burden compared to
 * sub-classing from {@link JonixExtractor}.
 * 
 * @author Zach Melamed
 */
public abstract class JonixFilesExtractor extends JonixExtractor
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