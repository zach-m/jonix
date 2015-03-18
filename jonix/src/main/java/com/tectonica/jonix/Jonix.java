package com.tectonica.jonix;

import java.io.PrintStream;
import java.util.List;

import com.tectonica.jonix.basic.BasicFactory;
import com.tectonica.jonix.basic.BasicHeader;
import com.tectonica.jonix.basic.BasicProduct;
import com.tectonica.jonix.export.JonixDumpExporter;
import com.tectonica.jonix.export.JonixInMemExporter;
import com.tectonica.jonix.export.JonixTabDelimitedExporter;
import com.tectonica.jonix.export.JonixUniqueExporter;

public class Jonix
{
	public static void main(String[] args)
	{
		if (args.length < 2 || args.length > 3)
		{
			System.out.println("Usage:");
			System.out.println("    java -jar jonix-2.0.jar <input-location> <output-file> <onix-version>");
			System.out.println("");
			System.out.println("<input-location> is an ONIX file-name, or a folder containing ONIX files with xml extension");
			System.out.println("<output-file> is the name of the tab-delimited output file");
			System.out.println("<onix-version> optional. can be: v21r (default), v21s, v30r, v30s");
			System.out.println("");
			return;
		}

		try
		{
			String inputFile = args[0];
			String outputFile = args[1];
			
			JonixPackages onixVersion = JonixPackages.v21_Reference;
			if (args.length == 3)
			{
				String onixVersionArg = args[2];
				if (onixVersionArg.equalsIgnoreCase("v21r"))
					onixVersion = JonixPackages.v21_Reference;
				else if (onixVersionArg.equalsIgnoreCase("v21s"))
					onixVersion = JonixPackages.v21_Short;
				else if (onixVersionArg.equalsIgnoreCase("v30r"))
					onixVersion = JonixPackages.v30_Reference;
				else if (onixVersionArg.equalsIgnoreCase("v30s"))
					onixVersion = JonixPackages.v30_Short;
				else
				{
					System.out.println("Illegal onix version: " + onixVersionArg);
					return;
				}
			}

			PrintStream out = new PrintStream(outputFile);

			createBasicTabDelimitedExporter(out, null).scanFolder(onixVersion, inputFile, ".xml");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static JonixTabDelimitedExporter<BasicHeader, BasicProduct> createBasicTabDelimitedExporter(PrintStream out, PrintStream log)
	{
		return new JonixTabDelimitedExporter<BasicHeader, BasicProduct>(new BasicFactory(), out, log);
	}

	public static JonixUniqueExporter<BasicHeader, BasicProduct> createBasicUniqueExporter(PrintStream out, PrintStream log)
	{
		return new JonixUniqueExporter<BasicHeader, BasicProduct>(new BasicFactory(), out, log);
	}

	public static JonixInMemExporter<BasicHeader, BasicProduct> createBasicInMemExporter(List<BasicProduct> out, PrintStream log)
	{
		return new JonixInMemExporter<BasicHeader, BasicProduct>(new BasicFactory(), out, log);
	}

	public static JonixDumpExporter<BasicHeader, BasicProduct> createBasicDumpExporter(PrintStream out, PrintStream log)
	{
		return new JonixDumpExporter<BasicHeader, BasicProduct>(new BasicFactory(), out, log);
	}
}