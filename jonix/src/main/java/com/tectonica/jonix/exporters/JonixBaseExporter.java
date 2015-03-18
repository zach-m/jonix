package com.tectonica.jonix.exporters;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.tectonica.jonix.JonixPackages;
import com.tectonica.jonix.JonixParser;

public abstract class JonixBaseExporter
{
	protected JonixPackages jonixPackage;

	public JonixBaseExporter(JonixPackages jonixPackage)
	{
		this.jonixPackage = jonixPackage;
	}

	public abstract void export(List<String> files);

	public void export(String fileName)
	{
		export(Arrays.asList(new String[]
			{ fileName }));
	}

	public void export(String rootLocation, String extension, boolean recursive)
	{
		if (!recursive)
			export(rootLocation);
		else
			export(fileExplorer.getFilesRootedAt(rootLocation, extension));
	}
	
	protected JonixParser parser;
	
	protected void initializeParser()
	{
		try
		{
			parser = new JonixParser(jonixPackage);
		}
		catch (Exception e)
		{
			throw new RuntimeException("Severe internal error - Couldn't initialize the parser", e);
		}
	}

	private FileExplorer fileExplorer = new FileExplorer();

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
