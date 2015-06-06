package com.tectonica.jonix.basic;

import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.onix3.BiographicalNote;
import com.tectonica.jonix.onix3.Contributor;
import com.tectonica.jonix.onix3.Subject;
import com.tectonica.jonix.onix3.SubjectHeadingText;
import com.tectonica.jonix.onix3.Text;
import com.tectonica.jonix.onix3.TextContent;

public class BasicPicker
{
	public static String pickBiographicalNote(Contributor contributor)
	{
		if (contributor.biographicalNotes != null)
		{
			for (BiographicalNote bio : contributor.biographicalNotes)
			{
				if (bio.language == null || bio.language == LanguageCodeIso6392Bs.English)
					return bio.value;
			}
			return contributor.biographicalNotes.get(0).value; // return whatever language we have
		}
		return null;
	}

	public static String pickSubjectHeadingText(Subject subject)
	{
		if (subject.subjectHeadingTexts != null)
		{
			for (SubjectHeadingText sht : subject.subjectHeadingTexts)
			{
				if (sht.language == null || sht.language == LanguageCodeIso6392Bs.English)
					return sht.value;
			}
			return subject.subjectHeadingTexts.get(0).value; // return whatever language we have
		}
		return null;
	}

	public static Text pickTextObject(TextContent textContent)
	{
		if (textContent.texts != null)
		{
			for (Text text : textContent.texts)
			{
				if (text.language == null || text.language == LanguageCodeIso6392Bs.English)
					return text;
			}
			return textContent.texts.get(0); // return whatever language we have
		}
		return null;
	}
}
