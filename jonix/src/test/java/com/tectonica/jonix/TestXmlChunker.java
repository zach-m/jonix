package com.tectonica.jonix;

import java.io.InputStream;

import javax.xml.stream.events.StartElement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Element;

import com.tectonica.xmlchunk.XmlChunker;

public class TestXmlChunker
{
	@Before
	public void setUp() throws Exception
	{}

	@After
	public void tearDown() throws Exception
	{}

	@Test
	public void test()
	{
		InputStream stream = TestXmlChunker.class.getResourceAsStream("/single-book-onix2.xml");
		XmlChunker.parse(stream, 2, new XmlChunker.Listener()
		{
			@Override
			public void onTarget(Element element)
			{
				System.out.println(XmlChunker.elementToString(element, false));
				System.out.println("------------------------------------------------------------------------------");
			}

			@Override
			public void onPreTargetStart(int depth, StartElement element)
			{
				final String localPart = element.getName().getLocalPart();
				System.out.println("FOUND TAG: " + localPart + " @ " + depth);
				System.out.println("------------------------------------------------------------------------------");
			}
		});
	}
}
