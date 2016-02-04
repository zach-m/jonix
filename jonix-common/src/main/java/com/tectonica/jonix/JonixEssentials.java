package com.tectonica.jonix;

public interface JonixEssentials
{
	public static enum TextFields
	{
		Isbn13, //
		Isbn10, //
		Title, //
	}

	String get(TextFields fieldType);
}
