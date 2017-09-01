package com.tectonica.jonix.codegen.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import javax.xml.parsers.ParserConfigurationException;

import org.jsoup.Jsoup;
import org.xml.sax.SAXException;

import com.tectonica.jonix.codegen.metadata.OnixDocs;

public class OnixDocsParser
{
	public static OnixDocs parse(String specHtml) throws IOException
	{
		return new OnixDocs(Jsoup.parse(OnixDocsParser.class.getResourceAsStream(specHtml), "UTF-8", "file://"));
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
	{
		parseAndSave("/xsd/onix2/ONIX_for_Books_Format_Specification_2.1.4.html", new File("parsed","Onix2.html"));
		parseAndSave("/xsd/onix3/ONIX_for_Books_Format_Specification_3.0.2.html", new File("parsed","Onix3.html"));
	}

	private static void parseAndSave(final String specHtml, File targetHtml) throws IOException, FileNotFoundException
	{
		System.out.println("Parsing " + specHtml + " into " + targetHtml.getAbsolutePath());
		OnixDocs onixDocs = parse(specHtml);

//		JSON.saveAsJson(new File(targetHtml + ".json"), onixDocs);

		try (final PrintStream out = new PrintStream(targetHtml, "UTF-8"))
		{
			out.println(onixDocs.toHtml());
		}

		System.out.println(onixDocs.allTags);
	}
}
