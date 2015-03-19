package com.tectonica.xmlchunk;

import java.io.Writer;

import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndDocument;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;

public class XmlChunkerEndDocument implements EndDocument
{
	@Override
	public int getEventType()
	{
		return END_DOCUMENT;
	}

	@Override
	public Location getLocation()
	{
		return null;
	}

	@Override
	public boolean isStartElement()
	{
		return false;
	}

	@Override
	public boolean isAttribute()
	{
		return false;
	}

	@Override
	public boolean isNamespace()
	{
		return false;
	}

	@Override
	public boolean isEndElement()
	{
		return true;
	}

	@Override
	public boolean isEntityReference()
	{
		return false;
	}

	@Override
	public boolean isProcessingInstruction()
	{
		return false;
	}

	@Override
	public boolean isCharacters()
	{
		return false;
	}

	@Override
	public boolean isStartDocument()
	{
		return false;
	}

	@Override
	public boolean isEndDocument()
	{
		return true;
	}

	@Override
	public StartElement asStartElement()
	{
		return null;
	}

	@Override
	public EndElement asEndElement()
	{
		return null; // not necessary for our purposes
	}

	@Override
	public Characters asCharacters()
	{
		return null;
	}

	@Override
	public QName getSchemaType()
	{
		return null;
	}

	@Override
	public void writeAsEncodedUnicode(Writer writer) throws XMLStreamException
	{}
}
