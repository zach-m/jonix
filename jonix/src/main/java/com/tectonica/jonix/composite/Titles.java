package com.tectonica.jonix.composite;

import java.io.Serializable;

import com.tectonica.jonix.JonixComposite;
import com.tectonica.jonix.JonixConsumer;
import com.tectonica.jonix.JonixUtils;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.resolve.JonixResolver;
import com.tectonica.jonix.resolve.ONIX;

public class Titles extends JonixComposite<Titles.Title>
{
	private static final long serialVersionUID = 8955865419418948290L;

	public static class Title implements Serializable
	{
		private static final long serialVersionUID = 2679255542443962900L;

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

	private transient Title activeItem;

	@Override
	public JonixConsumer consume(Object o, Object parent, Object grandParent, JonixResolver resolver)
	{
		if (resolver.onixTypeOf(o) == ONIX.Title)
		{
			add(activeItem = new Title());
			return this;
		}

		if (resolver.onixTypeOf(parent) == ONIX.Title)
		{
			switch (resolver.onixTypeOf(o))
			{
				case TitleType:
					activeItem.titleType = TitleTypes.fromCode(JonixUtils.getValueAsStr(o));
					break;
					
				case TitleText:
					activeItem.titleText = JonixUtils.noBreaks(JonixUtils.getValueAsStr(o));
					break;
					
				case TitleWithoutPrefix:
					activeItem.titleWithoutPrefix = JonixUtils.noBreaks(JonixUtils.getValueAsStr(o));
					break;
					
				case Subtitle:
					activeItem.subtitle = JonixUtils.noBreaks(JonixUtils.getValueAsStr(o));
					break;
					
				default:
					break;
			}
		}
		
		return null;
	}
}