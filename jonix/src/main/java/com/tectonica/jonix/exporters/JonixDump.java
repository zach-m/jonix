package com.tectonica.jonix.exporters;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import com.tectonica.jonix.JonixHeader;
import com.tectonica.jonix.JonixPackages;
import com.tectonica.jonix.JonixParser.OnJonixItemListener;
import com.tectonica.jonix.JonixProduct;
import org.xml.sax.SAXException;

public class JonixDump extends JonixBaseExporter
{
	private PrintStream output;
	private PrintStream log;

	public JonixDump(JonixPackages jonixPackage, PrintStream output, PrintStream log)
	{
		super(jonixPackage);
		this.output = (output == null) ? System.out : output;
		this.log = (log == null) ? System.err : log;

		log.println("Initializing..");
		initializeParser();
	}

	@Override
	public void export(List<String> files)
	{
		log.println("Parsing " + files.size() + " files");

		for (String fileName : files)
		{
			try
			{
				log.println("opening " + fileName + ".. ");
				parser.parse(fileName, onJonixItemListener);
			}
			catch (IOException e)
			{
				e.printStackTrace(log);
				// we move on to the next file
			}
			catch (SAXException e)
			{
				log.println("aborting");
				e.printStackTrace(log);
				break;
			}
		}
		
		output.flush();
	}

	private OnJonixItemListener onJonixItemListener = new OnJonixItemListener()
	{
		@Override
		public void onHeader(JonixHeader header)
		{
			output.println("-----------------------------------------------------------\n");
			output.println(header.toString());
			output.println("-----------------------------------------------------------\n");
		}

		@Override
		public void onProduct(JonixProduct product, int index)
		{
			// show a log message about the product being successfully parsed
			String productLabel = product.recordReference;
			if (product.titles.size() > 0)
				productLabel = product.titles.get(0).titleText;
			log.println("parsed product #" + index + " - " + productLabel);

			// export the product as a plain string
			output.println(product.toString());
			output.println("**********************************************************************************\n");
		}
	};
}
