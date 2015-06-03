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

import com.tectonica.jonix.basic.BasicProduct;
import com.tectonica.jonix.export.JonixDumpExporter;
import com.tectonica.jonix.export.JonixInMemExporter;
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

			createBasicTabDelimitedExporter(out, null).scanFolder(inputFile, ".xml");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static JonixTabDelimitedExporter createBasicTabDelimitedExporter(PrintStream out, PrintStream log)
	{
		return new JonixTabDelimitedExporter(out, log);
	}

	public static JonixUniqueExporter createBasicUniqueExporter(PrintStream out, PrintStream log)
	{
		return new JonixUniqueExporter(out, log);
	}

	public static JonixInMemExporter createBasicInMemExporter(List<BasicProduct> out, PrintStream log)
	{
		return new JonixInMemExporter(out, log);
	}

	public static JonixDumpExporter createBasicDumpExporter(PrintStream out, PrintStream log)
	{
		return new JonixDumpExporter(out, log);
	}
}