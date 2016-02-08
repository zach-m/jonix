package com.tectonica.jonix;

import java.util.List;

public interface JonixEssentials
{
	public static enum TextFields
	{
		Isbn13, //
		Isbn10, //
		UPC, //
		Title, //
		Subtitle, //
		TitleInOriginalLanguage, //
		SubtitleInOriginalLanguage, //
		TitleOfSeries, //
		NumberWithinSeries, //
		Language,
		Audience
		// NumOfPages, Publisher, PublicationDate, Dewey, Keywords

		// TBD: prices and descriptions
	}

	public static enum ListFields
	{
		Contributors, //
		Authors, //
		Editors, //
		AudienceAgeRange
//		BISACs, //
//		BICs
	}

	String get(TextFields fieldType);

	List<String> get(ListFields fieldType);
}
