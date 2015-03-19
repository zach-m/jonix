package com.tectonica.xmlchunk;

import java.util.List;
import java.util.ListIterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

public class XmlChunkerReader implements XMLEventReader
{
	private final ListIterator<XMLEvent> iter;
	private final XMLEventReader reader;

	public XmlChunkerReader(List<XMLEvent> events, XMLEventReader reader)
	{
		this.iter = events.listIterator();
		this.reader = reader;
	}

	@Override
	public XMLEvent nextEvent() throws XMLStreamException
	{
		return iter.next();
	}

	@Override
	public boolean hasNext()
	{
		return iter.hasNext();
	}

	@Override
	public Object next()
	{
		return iter.next();
	}

	@Override
	public void remove()
	{
		iter.remove();
	}

	@Override
	public XMLEvent peek() throws XMLStreamException
	{
		XMLEvent event = iter.next();
		iter.previous();
		return event;
	}

	@Override
	public String getElementText() throws XMLStreamException
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public XMLEvent nextTag() throws XMLStreamException
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public Object getProperty(String name) throws IllegalArgumentException
	{
		return reader.getProperty(name);
	}

	@Override
	public void close() throws XMLStreamException
	{}
}
