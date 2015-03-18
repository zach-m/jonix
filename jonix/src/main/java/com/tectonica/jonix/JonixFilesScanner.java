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

import com.tectonica.jonix.JonixParser.JonixFactory;

/**
 * Specific type of {@link JonixScanner}, specializing in traversing files stored in the file system (in addition to all the service it
 * derives from its base class). Like its super class, this is an abstract class, requiring custom implementation of at least
 * {@link #onHeader(JonixTag)} and {@link #onProduct(JonixTag, int}.
 * <p>
 * The mechanism is to read the sources, process them, and send the output into two streams, provided by the user: {@code log} and
 * {@code out}. The log is meant to describe the process, and the out is for the actual exported data (which this particular class doesn't
 * generate, only its subclasses).
 * 
 * @author Zach Melamed
 * 
 * @param <H>
 *            the {@link JonixTag} representing the HEADER tag of each ONIX record
 * @param <P>
 *            the {@link JonixTag} representing the PRODUCT tag of each ONIX record
 */
public abstract class JonixFilesScanner<H extends JonixTag, P extends JonixTag> extends JonixScanner<H, P>
{
	protected PrintStream out = System.out;

	public JonixFilesScanner(JonixFactory<H, P> factory)
	{
		super(factory);
	}

	/**
	 * Creates a files scanner, capable of going over files and folders and fire events whenever a HEADER or PRODUCT are processed
	 * 
	 * @param jonixFactory
	 *            Factory for generating a new, empty, HEADER or PRODUCT class, that will later process the raw data and retain the results
	 * @param out
	 *            A stream into which the output of the scanning is intended
	 * @param log
	 *            A stream into which status and error messages will be sent
	 */
	public JonixFilesScanner(JonixFactory<H, P> factory, PrintStream out, PrintStream log)
	{
		super(factory, log);
		setOut(out);
	}

	public void setOut(PrintStream out)
	{
		this.out = (out == null) ? System.out : out;
	}

	public void setOut(String fileName) throws UnsupportedEncodingException, FileNotFoundException
	{
		this.out = new PrintStream(fileName, DEFAULT_OUTPUT_CHARSET);
	}

	public PrintStream getOut()
	{
		return out;
	}

	public void scanFile(JonixPackages jonixPackage, String onixFileName, String charsetName)
	{
		scanFileList(jonixPackage, Collections.singletonList(onixFileName), charsetName);
	}

	public void scanFile(JonixPackages jonixPackage, String onixFileName)
	{
		scanFile(jonixPackage, onixFileName, JonixParser.DEFAULT_INPUT_CHARSET);
	}

	/**
	 * recursively scans an entire directory tree, taking into account only files ending with a particular <code>extension</code>.
	 * 
	 * @param jonixPackage
	 *            the expected ONIX package of the files
	 * @param rootLocation
	 *            the directory path. If a file is provided, this will still work, and the <code>extension</code> parameter will be ignored
	 * @param extension
	 *            an suffix of the files to participate in the export (not necessarily a file-system extension)
	 * 
	 */
	public void scanFolder(JonixPackages jonixPackage, String rootLocation, String extension, String charsetName)
	{
		scanFileList(jonixPackage, fileExplorer.getFilesRootedAt(rootLocation, extension), charsetName);
	}

	public void scanFolder(JonixPackages jonixPackage, String rootLocation, String extension)
	{
		scanFolder(jonixPackage, rootLocation, extension, JonixParser.DEFAULT_INPUT_CHARSET);
	}

	public void scanFileList(JonixPackages jonixPackage, List<String> onixFileNames, String charsetName)
	{
		if (onBeforeFiles(onixFileNames))
		{
			for (String onixFileName : onixFileNames)
			{
				try
				{
					if (!onBeforeFile(onixFileName))
						continue;
					scan(jonixPackage, new FileInputStream(onixFileName), charsetName);
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
