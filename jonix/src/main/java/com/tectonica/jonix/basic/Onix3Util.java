package com.tectonica.jonix.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.onix3.BiographicalNote;
import com.tectonica.jonix.onix3.Contributor;
import com.tectonica.jonix.onix3.Product;
import com.tectonica.jonix.onix3.Subject;
import com.tectonica.jonix.onix3.SubjectHeadingText;
import com.tectonica.jonix.onix3.TitleDetail;
import com.tectonica.jonix.onix3.TitleElement;
import com.tectonica.jonix.struct.JonixTitle;

public class Onix3Util
{
	public static JonixTitle findTitle(List<TitleDetail> titleDetails, TitleTypes titleType)
	{
		if (titleDetails != null)
		{
			for (TitleDetail title : titleDetails)
			{
				if (title.getTitleTypeValue() == titleType)
					return asJonixTitle(title);
			}
		}
		return null;
	}

	public static List<JonixTitle> findTitles(List<TitleDetail> titleDetails, Set<TitleTypes> titleTypes)
	{
		List<JonixTitle> matches = new ArrayList<>();
		if (titleDetails != null)
		{
			for (TitleDetail title : titleDetails)
			{
				if (titleTypes == null || titleTypes.contains(title.getTitleTypeValue()))
					matches.add(asJonixTitle(title));
			}
		}
		return matches;
	}

	private static JonixTitle asJonixTitle(TitleDetail title)
	{
		TitleElement titleElement = title.titleElements.get(0); // at least 1 is mandatory
		JonixTitle x = new JonixTitle();
		x.titleType = title.getTitleTypeValue();
		x.titleText = titleElement.getTitleTextValue();
		x.titlePrefix = titleElement.getTitlePrefixValue();
		x.titleWithoutPrefix = titleElement.getTitleWithoutPrefixValue();
		x.subtitle = titleElement.getSubtitleValue();
		return x;
	}

	public static String findBiographicalNote(Contributor contributor, LanguageCodeIso6392Bs preferredLanguage)
	{
		if (contributor.biographicalNotes != null)
		{
			for (BiographicalNote bio : contributor.biographicalNotes)
			{
				if (bio.language == null || bio.language == preferredLanguage)
					return bio.value;
			}
			return contributor.biographicalNotes.get(0).value; // return whatever language we have
		}
		return null;
	}

	public static String findSubjectHeadingText(Subject subject, LanguageCodeIso6392Bs preferredLanguage)
	{
		if (subject.subjectHeadingTexts != null)
		{
			for (SubjectHeadingText sht : subject.subjectHeadingTexts)
			{
				if (sht.language == null || sht.language == preferredLanguage)
					return sht.value;
			}
			return subject.subjectHeadingTexts.get(0).value; // return whatever language we have
		}
		return null;
	}
}
