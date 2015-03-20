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

package com.tectonica.jonix;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class JonixFilesScanner extends JonixScanner
{
	protected PrintStream out = System.out;

	public JonixFilesScanner()
	{
		super();
	}

	/**
	 * @param out
	 *            A stream into which the output of the scanning is intended
	 * @param log
	 *            A stream into which status and error messages will be sent
	 */
	public JonixFilesScanner(PrintStream out, PrintStream log)
	{
		super(log);
		setOut(out);
	}

	public void setOut(PrintStream out)
	{
		this.out = (out == null) ? System.out : out;
	}

	public void setOut(String fileName) throws UnsupportedEncodingException, FileNotFoundException
	{
		this.out = new PrintStream(fileName, "UTF8");
	}

	public PrintStream getOut()
	{
		return out;
	}

	public void scanFile(String onixFileName)
	{
		scanFileList(Collections.singletonList(onixFileName));
	}

	public void scanFolder(String rootLocation, String extension)
	{
		scanFileList(fileExplorer.getFilesRootedAt(rootLocation, extension));
	}

	public void scanFileList(List<String> onixFileNames)
	{
		if (onBeforeFiles(onixFileNames))
		{
			for (String onixFileName : onixFileNames)
			{
				try
				{
					if (!onBeforeFile(onixFileName))
						continue;
					scan(new FileInputStream(onixFileName));
				}
				catch (IOException e)
				{
					e.printStackTrace(log);
					// we move on to the next file
				}
			}
			onAfterFiles();
		}
	}

	protected boolean onBeforeFiles(List<String> onixFileNames)
	{
		return true;
	}

	@Override
	protected void onAfterSource()
	{
		super.onAfterSource();
		out.flush();
	}

	protected void onAfterFiles()
	{}

	protected boolean onBeforeFile(String fileName)
	{
		return true;
	}

	private FileExplorer fileExplorer = new FileExplorer();

	/**
	 * Simple class for scanning the file system from a given root and finding all the files with a given extension. The root may also be a
	 * file, in which case
	 * no further traversal is done.
	 */
	public static class FileExplorer
	{
		private List<String> files;
		private String extension;

		public List<String> getFilesRootedAt(String rootLocation, String extension)
		{
			files = new ArrayList<String>();
			this.extension = extension;
			File base = new File(rootLocation);
			if (base.exists())
				getFilesFromDir(base, base.isFile());
			return files;
		}

		private void getFilesFromDir(File base, boolean isFile)
		{
			if (isFile)
				files.add(base.getPath());
			else if (base.isDirectory())
			{
				File[] allDirFiles = base.listFiles();
				if (allDirFiles == null)
					return;
				for (File f : allDirFiles)
				{
					boolean isDirectory = f.isDirectory();
					if (isDirectory || (extension == null) || f.getName().toLowerCase().endsWith(extension))
						getFilesFromDir(f, !isDirectory);
				}
			}
		}
	}
}
