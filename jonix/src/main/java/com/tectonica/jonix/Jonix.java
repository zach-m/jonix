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

import java.io.PrintStream;
import java.util.List;

import com.tectonica.jonix.basic.BasicColumn;
import com.tectonica.jonix.basic.BasicHeader;
import com.tectonica.jonix.basic.BasicProduct;
import com.tectonica.jonix.export.JonixInMemExporter;
import com.tectonica.jonix.export.JonixJsonExporter;
import com.tectonica.jonix.export.JonixTabDelimitedExporter;
import com.tectonica.jonix.export.JonixUniqueExporter;

public class Jonix
{
	public static void main(String[] args)
	{
		if (args.length != 2)
		{
			System.out.println("Usage:");
			System.out.println("    java -jar jonix.jar <input-location> <output-file>");
			System.out.println("");
			System.out.println("<input-location> is an ONIX file-name, "
					+ "or a folder containing ONIX files with xml extension");
			System.out.println("<output-file> is the name of the tab-delimited output file");
			System.out.println("");
			return;
		}

		try
		{
			String inputFile = args[0];
			String outputFile = args[1];

			PrintStream out = new PrintStream(outputFile);

			createBasicTabDelimitedExporter(out).readFolder(inputFile, ".xml");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static final JonixContext<BasicHeader, BasicProduct> BASIC_CONTEXT = new JonixContext<BasicHeader, BasicProduct>()
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

	public static JonixTabDelimitedExporter<BasicHeader, BasicProduct> createBasicTabDelimitedExporter(PrintStream out)
	{
		JonixTabDelimitedExporter<BasicHeader, BasicProduct> exporter = new JonixTabDelimitedExporter<BasicHeader, BasicProduct>(
				BASIC_CONTEXT);
		exporter.setOut(out);
		return exporter;
	}

	public static JonixUniqueExporter<BasicHeader, BasicProduct> createBasicUniqueExporter(PrintStream out)
	{
		JonixUniqueExporter<BasicHeader, BasicProduct> exporter = new JonixUniqueExporter<BasicHeader, BasicProduct>(
				BASIC_CONTEXT);
		exporter.setOut(out);
		return exporter;
	}

	public static JonixInMemExporter<BasicHeader, BasicProduct> createBasicInMemExporter(List<BasicProduct> out)
	{
		JonixInMemExporter<BasicHeader, BasicProduct> exporter = new JonixInMemExporter<BasicHeader, BasicProduct>(
				BASIC_CONTEXT, out);
		return exporter;
	}

	public static JonixJsonExporter<BasicHeader, BasicProduct> createJsonExporter(PrintStream out,
			boolean writeRawProduct)
	{
		JonixJsonExporter<BasicHeader, BasicProduct> exporter = new JonixJsonExporter<BasicHeader, BasicProduct>(
				BASIC_CONTEXT, writeRawProduct);
		exporter.setOut(out);
		return exporter;
	}
}