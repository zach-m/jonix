package com.tectonica.jonix.composites;

import com.tectonica.jonix.codelists.TitleTypes;

@SuppressWarnings("serial")
public class Titles extends JonixComposite<Titles.Title>
{
	public Titles()
	{
		super(Title.class);
	}
	
	public static class Title
	{
		public TitleTypes titleType;
		public String titleText;
		public String titleWithoutPrefix;
		public String subtitle;

		@Override
		public String toString()
		{
			String titleTypeStr = (titleType == null) ? null : titleType.name();
			String titleTestStr = titleText + ((titleWithoutPrefix != null) ? "*" : "");
			String subtitleStr = subtitle == null ? "" : ": " + subtitle;
			return String.format("Title [%s]: %s%s", titleTypeStr, titleTestStr, subtitleStr);
		}
	}
}