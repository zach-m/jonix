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
import java.io.PrintStream;
import java.util.List;

import com.tectonica.jonix.basic.BasicColumn;
import com.tectonica.jonix.basic.BasicHeader;
import com.tectonica.jonix.basic.BasicProduct;
import com.tectonica.jonix.export.JonixJsonExporter;
import com.tectonica.jonix.export.JonixTabDelimitedExporter;
import com.tectonica.jonix.export.JonixUniqueExporter;
import com.tectonica.jonix.extract.JonixInMemExtractor;
import com.tectonica.jonix.stream.JonixFilesStreamer;

public class Jonix
{
	private static void usage()
	{
		p("Usage:");
		p("        java -jar jonix.jar OUTPUT [DIRECTORY] [PATTERN]");
		p("or:     java -jar jonix.jar OUTPUT INPUT");
		p("");
		p("Creates a tab-delimited file named OUTPUT, listing all the ONIX records found in either:");
		p("- any file in or below DIRECTORY (default is current) whose name matches PATTERN (default is *.xml)");
		p("- the single file INPUT");
		p("");
	}

	public static void main(String[] args)
	{
		if (args.length < 1 || args.length > 3)
		{
			usage();
			return;
		}

		try
		{
			final String outputFile = args[0];

			final String input = (args.length < 2) ? "." : args[1];
			final File inputFile = new File(input);
			if (!inputFile.exists())
			{
				System.err.println("couldn't find " + input);
				return;
			}

			final String pattern;
			if (!inputFile.isDirectory())
				pattern = "*";
			else
				pattern = (args.length < 3) ? "*.xml" : args[2];

			PrintStream out = new PrintStream(outputFile);

			createBasicTabDelimitedStreamer(out).readFolder(input, pattern);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void p(String s)
	{
		System.out.println(s);
	}

	// /////////////////////////////////////////////////////////////////////////////////////////

	public static final JonixUnifier<BasicHeader, BasicProduct> BASIC_CONTEXT = new JonixUnifier<BasicHeader, BasicProduct>()
	{
		@Override
		public BasicHeader createFrom(com.tectonica.jonix.onix2.Header header)
		{
			return new BasicHeader(header);
		}

		@Override
		public BasicHeader createFrom(com.tectonica.jonix.onix3.Header header)
		{
			return new BasicHeader(header);
		}

		@Override
		public BasicProduct createFrom(com.tectonica.jonix.onix2.Product product)
		{
			return new BasicProduct(product);
		}

		@Override
		public BasicProduct createFrom(com.tectonica.jonix.onix3.Product product)
		{
			return new BasicProduct(product);
		}

		@Override
		public String labelOf(BasicProduct product)
		{
			return product.getLabel();
		}

		@Override
		public JonixColumn<BasicProduct>[] getDefaultColumns()
		{
			return BasicColumn.ALL_COLUMNS;
		}

		@Override
		public JonixColumn<BasicProduct> getDefaultIdColumn()
		{
			return BasicColumn.ISBN13;
		}
	};

	// /////////////////////////////////////////////////////////////////////////////////////////

	public static JonixFilesStreamer createBasicTabDelimitedStreamer(PrintStream out)
	{
		return new JonixFilesStreamer(new JonixTabDelimitedExporter<BasicHeader, BasicProduct>(BASIC_CONTEXT).setOut(out));
	}

	public static JonixFilesStreamer createJsonStreamer(PrintStream out, boolean exportRaw)
	{
		return new JonixFilesStreamer(new JonixJsonExporter<BasicHeader, BasicProduct>(BASIC_CONTEXT, exportRaw).setOut(out));
	}

	public static JonixFilesStreamer createBasicUniqueStreamer(PrintStream out)
	{
		return new JonixFilesStreamer(new JonixUniqueExporter<BasicHeader, BasicProduct>(BASIC_CONTEXT).setOut(out));
	}

	public static JonixFilesStreamer createBasicInMemStreamer(List<BasicProduct> out)
	{
		return new JonixFilesStreamer(new JonixInMemExtractor<BasicHeader, BasicProduct>(BASIC_CONTEXT, out));
	}
}
