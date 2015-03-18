package com.tectonica.jonix;

import java.io.PrintStream;

import com.tectonica.jonix.exporters.JonixDelimited;

public class Jonix
{
	public static void main(String[] args)
	{
		if (args.length != 2)
		{
			System.out.println("Usage:");
			System.out.println("    java -jar jonix-1.0.jar <input-locaion> <output-file>");
			System.out.println("");
			System.out.println("<input-locaion> is an ONIX file-name, or a folder containing ONIX files with xml extension");
			System.out.println("<output-file> is the name of the tab-delimited output file");
			System.out.println("");
			return;
		}

		try
		{
			String inputFile = args[0];
			String outputFile = args[1];

			JonixDelimited jonixExporter = new JonixDelimited(JonixPackages.v21_Reference, new PrintStream(outputFile), System.err);
			jonixExporter.export(inputFile, ".xml", true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}