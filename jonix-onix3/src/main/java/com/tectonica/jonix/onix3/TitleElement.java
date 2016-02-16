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

package com.tectonica.jonix.onix3;

import java.io.Serializable;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TitleElementLevels;
import com.tectonica.jonix.struct.JonixTitleElement;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Title element composite</h1>
 * <p>
 * A repeatable group of data elements which together represent an element of a title. At least one title element is
 * mandatory in each occurrence of the &lt;TitleDetail&gt; composite. An instance of the &lt;TitleElement&gt; composite
 * must include at least one of: &lt;PartNumber&gt;; &lt;YearOfAnnual&gt;; &lt;TitleText&gt;, &lt;NoPrefix/&gt; together
 * with &lt;TitleWithoutPrefix&gt;, or &lt;TitlePrefix&gt; together with &lt;TitleWithoutPrefix&gt;. In other words it
 * <em>must</em> carry <em>either</em> the text of a title <em>or</em> a part or year designation, and it <em>may</em>
 * carry both.
 * </p>
 * <p>
 * A title element must be designated as belonging to product level, collection level, or subcollection level (the
 * last-named only in the case of a multi-level collection).
 * </p>
 * <p>
 * In the simplest case, a product title will consist of a single title element, at product level. However, the
 * composite structure in ONIX 3.0 allows complex titles to be correctly represented, in the sequence in which the
 * publisher wishes the elements to be displayed.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;TitleElement&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;titleelement&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1&#8230;n</td>
 * </tr>
 * </table>
 */
public class TitleElement implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "TitleElement";
	public static final String shortname = "titleelement";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	// ///////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (this field is optional)
	 */
	public SequenceNumber sequenceNumber;

	/**
	 * (this field is required)
	 */
	public TitleElementLevel titleElementLevel;

	/**
	 * (this field is required)
	 */
	public PartNumber partNumber;

	/**
	 * (this field is optional)
	 */
	public YearOfAnnual yearOfAnnual;

	/**
	 * (this field is optional)
	 */
	public TitlePrefix titlePrefix;

	/**
	 * (this field is optional)
	 */
	public NoPrefix noPrefix;

	/**
	 * (this field is required)
	 */
	public TitleWithoutPrefix titleWithoutPrefix;

	/**
	 * (this field is optional)
	 */
	public TitleText titleText;

	/**
	 * (this field is optional)
	 */
	public Subtitle subtitle;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public TitleElement()
	{}

	public TitleElement(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(SequenceNumber.refname) || name.equals(SequenceNumber.shortname))
					sequenceNumber = new SequenceNumber(element);
				else if (name.equals(TitleElementLevel.refname) || name.equals(TitleElementLevel.shortname))
					titleElementLevel = new TitleElementLevel(element);
				else if (name.equals(PartNumber.refname) || name.equals(PartNumber.shortname))
					partNumber = new PartNumber(element);
				else if (name.equals(YearOfAnnual.refname) || name.equals(YearOfAnnual.shortname))
					yearOfAnnual = new YearOfAnnual(element);
				else if (name.equals(TitlePrefix.refname) || name.equals(TitlePrefix.shortname))
					titlePrefix = new TitlePrefix(element);
				else if (name.equals(NoPrefix.refname) || name.equals(NoPrefix.shortname))
					noPrefix = new NoPrefix(element);
				else if (name.equals(TitleWithoutPrefix.refname) || name.equals(TitleWithoutPrefix.shortname))
					titleWithoutPrefix = new TitleWithoutPrefix(element);
				else if (name.equals(TitleText.refname) || name.equals(TitleText.shortname))
					titleText = new TitleText(element);
				else if (name.equals(Subtitle.refname) || name.equals(Subtitle.shortname))
					subtitle = new Subtitle(element);
			}
		});
	}

	public Integer getSequenceNumberValue()
	{
		return (sequenceNumber == null) ? null : sequenceNumber.value;
	}

	public TitleElementLevels getTitleElementLevelValue()
	{
		return (titleElementLevel == null) ? null : titleElementLevel.value;
	}

	public String getPartNumberValue()
	{
		return (partNumber == null) ? null : partNumber.value;
	}

	public String getYearOfAnnualValue()
	{
		return (yearOfAnnual == null) ? null : yearOfAnnual.value;
	}

	public String getTitlePrefixValue()
	{
		return (titlePrefix == null) ? null : titlePrefix.value;
	}

	public boolean isNoPrefix()
	{
		return (noPrefix != null);
	}

	public String getTitleWithoutPrefixValue()
	{
		return (titleWithoutPrefix == null) ? null : titleWithoutPrefix.value;
	}

	public String getTitleTextValue()
	{
		return (titleText == null) ? null : titleText.value;
	}

	public String getSubtitleValue()
	{
		return (subtitle == null) ? null : subtitle.value;
	}

	public JonixTitleElement asJonixTitleElement()
	{
		JonixTitleElement x = new JonixTitleElement();
		x.sequenceNumber = getSequenceNumberValue();
		x.titleElementLevel = getTitleElementLevelValue();
		x.partNumber = getPartNumberValue();
		x.yearOfAnnual = getYearOfAnnualValue();
		x.titlePrefix = getTitlePrefixValue();
		x.isNoPrefix = isNoPrefix();
		x.titleWithoutPrefix = getTitleWithoutPrefixValue();
		x.titleText = getTitleTextValue();
		x.subtitle = getSubtitleValue();
		return x;
	}
}
