/*
 * Copyright (C) 2012 Zach Melamed
 * 
 * Latest version available online at https://github.com/zach-m/jonix
 * Contact me at zach@tectonica.co.il
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tectonica.jonix.composite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tectonica.jonix.basic.Onix3Util;
import com.tectonica.jonix.codelist.OtherTextTypes;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TextTypes;

@SuppressWarnings("serial")
public class OtherText implements Serializable
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
		return String.format("OtherText [%s/%s]: %s", (textType == null) ? null : textType.name(),
				(textFormat == null) ? null : textFormat.name(), text);
	}

	public static List<OtherText> listFrom(com.tectonica.jonix.onix2.Product product)
	{
		if (product.otherTexts != null)
		{
			List<OtherText> result = new ArrayList<>();
			for (com.tectonica.jonix.onix2.OtherText ot : product.otherTexts)
			{
				TextTypes type = translate33to153(ot.getTextTypeCodeValue());
				TextFormats format = ot.getTextFormatValue();
				String text = null;
				if (ot.text != null)
				{
					text = ot.text.value;
					if (format == null)
						format = ot.text.textformat;
				}
				result.add(new OtherText(type, format, text));
			}
			return result;
		}
		return Collections.emptyList();
	}

	public static List<OtherText> listFrom(com.tectonica.jonix.onix3.Product product)
	{
		if (product.collateralDetail.textContents != null)
		{
			List<OtherText> result = new ArrayList<>();
			for (com.tectonica.jonix.onix3.TextContent tc : product.collateralDetail.textContents)
			{
				TextTypes type = tc.getTextTypeValue();
				com.tectonica.jonix.onix3.Text textObject = Onix3Util.pickTextObject(tc);
				TextFormats format = textObject.textformat;
				String text = textObject.value;
				result.add(new OtherText(type, format, text));
			}
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * translation table from Onix2's Code-List-33 to Onix3's Code-List-153, based on <a href=
	 * "http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_10_Changes_for_3.0.pdf"
	 * >this document from Editeur</a>
	 */
	private static TextTypes translate33to153(OtherTextTypes o)
	{
		switch (o)
		{
		case Main_description:
			return TextTypes.Description;
		case Short_description_annotation:
			return TextTypes.Short_description_annotation;
		case Long_description:
			return TextTypes.Description;
		case Table_of_contents:
			return TextTypes.Table_of_contents;
		case Quote_from_review_of_previous_edition:
			return TextTypes.Review_quote_previous_edition;
		case Review_quote:
			return TextTypes.Review_quote;
		case Promotional_headline_:
			return TextTypes.Promotional_headline;
		case Previous_review_quote:
			return TextTypes.Review_quote_previous_work;
		case Description_for_reader:
			return TextTypes.Description;
		case Biographical_note:
			return TextTypes.Biographical_note;
		case Competing_titles:
			return TextTypes.Description;
		case Flap_copy:
			return TextTypes.Flap_cover_copy;
		case Back_cover_copy:
			return TextTypes.Flap_cover_copy;
		case Feature:
			return TextTypes.Feature;
		case New_feature:
			return TextTypes.Feature;
		case Publisher_s_notice:
			return TextTypes.Publisher_s_notice;
		case Index:
			return TextTypes.Index;
		case Excerpt_from_book:
			return TextTypes.Excerpt;
		case Description_for_sales_people:
			return TextTypes.Description;
		case Description_for_press_or_other_media:
			return TextTypes.Description;
		case Description_for_teachers_educators:
			return TextTypes.Description;
		case Unpublished_endorsement:
			return TextTypes.Endorsement;
		case Description_for_bookstore:
			return TextTypes.Description;
		case Description_for_library:
			return TextTypes.Description;
		default:
			return null;
		}
	}
}