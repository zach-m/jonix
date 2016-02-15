package com.tectonica.jonix.codegen.generator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import javax.xml.parsers.ParserConfigurationException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.xml.sax.SAXException;

import com.tectonica.jonix.codegen.metadata.OnixDocs;

public class OnixDocsParser
{
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
	{
		parse("/xsd/onix2/ONIX_for_Books_Format_Specification_2.1.4.html", "C:\\Users\\zach\\Desktop\\Onix2.html");
		parse("/xsd/onix3/ONIX_for_Books_Format_Specification_3.0.2.html", "C:\\Users\\zach\\Desktop\\Onix3.html");
	}

	private static void parse(final String specHtml, String targetHtml) throws IOException, FileNotFoundException
	{
		System.out.println("Parsing " + specHtml + " into " + targetHtml);
		final Document doc = Jsoup.parse(OnixDocsParser.class.getResourceAsStream(specHtml), "UTF-8", "file://");

		OnixDocs onixDocs = new OnixDocs(doc);

		try (final PrintStream out = new PrintStream(targetHtml, "UTF-8"))
		{
			out.println(onixDocs.toHtml());
		}

		System.out.println(onixDocs.allTags);
	}
}
