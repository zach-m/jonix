package com.tectonica.jonix.composites;

import com.tectonica.jonix.codelists.TextFormats;
import com.tectonica.jonix.codelists.TextTypes;

@SuppressWarnings("serial")
public class OtherTexts extends JonixBaseComposite<OtherTexts.OtherText>
{
	public static class OtherText
	{
		public final TextTypes textType;
		public final TextFormats textFormat;
		public final String text;

		public OtherText(TextTypes textType, TextFormats textFormat, String text)
		{
			this.textType = textType;
			this.textFormat = textFormat;
			this.text = text;
		}

		@Override
		public String toString()
		{
			return String.format("OtherText [%s/%s]: %s", (textType == null) ? null : textType.name(), (textFormat == null) ? null : textFormat.name(), text);
		}

	}

	public void setNewItem(String textTypeCode, String textFormatCode, String text)
	{
		add(new OtherText(TextTypes.fromCode(textTypeCode), TextFormats.fromCode(textFormatCode), text));
	}
}
