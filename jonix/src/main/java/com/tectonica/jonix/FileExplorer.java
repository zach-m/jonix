package com.tectonica.jonix;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple class for scanning the file system from a given root and finding all the files with a given extension. The
 * root may also be a file, in which case no further traversal is done.
 */
public class FileExplorer
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