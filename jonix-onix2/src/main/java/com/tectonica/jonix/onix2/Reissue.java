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

package com.tectonica.jonix.onix2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.ImageAudioVideoFileTypes;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixMediaFile;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Reissue composite</h1>
 * <p>
 * A group of data elements which together specify that a product is to be reissued within the market to which the
 * &lt;SupplyDetail&gt; composite applies. Optional and non-repeating. The &lt;Reissue&gt; composite is used only when
 * the publisher intends to re-launch the product under the same ISBN. There are two possible cases:
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li>When the product is unavailable during the period immediately before reissue. In this case, the
 * &lt;AvailabilityCode&gt; should carry the value UR for “unavailable, awaiting reissue”, and the ONIX record can be
 * updated to describe the reissued product as soon as details can be made available</li>
 * <li>When the product is still available during the period up to the reissue date. In this case, the ONIX record
 * should continue to describe the existing product and the &lt;AvailabilityCode&gt; value should remain IP right up to
 * the reissue date. At that date, the record should be updated to describe the reissued product, with the
 * &lt;AvailabilityCode&gt; value remaining IP.</li>
 * </ol>
 * <p>
 * After reissue, it is recommended that the &lt;Reissue&gt; composite should be retained as a permanent element of the
 * ONIX record, carrying only the &lt;ReissueDate&gt; element, which will then indicate “date last reissued”.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Reissue&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;reissue&gt;</td>
 * </tr>
 * </table>
 */
public class Reissue implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Reissue";
	public static final String shortname = "reissue";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	public TextFormats textformat;

	public TextCaseFlags textcase;

	public LanguageCodes language;

	public TransliterationSchemes transliteration;

	/**
	 * (type: DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	// ///////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (this field is required)
	 */
	public ReissueDate reissueDate;

	/**
	 * (this field is optional)
	 */
	public ReissueDescription reissueDescription;

	/**
	 * (this list may be empty)
	 */
	public List<Price> prices;

	/**
	 * (this list may be empty)
	 */
	public List<MediaFile> mediaFiles;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Reissue()
	{}

	public Reissue(org.w3c.dom.Element element)
	{
		textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byValue(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byValue(JPU.getAttribute(element, "transliteration"));
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(ReissueDate.refname) || name.equals(ReissueDate.shortname))
					reissueDate = new ReissueDate(element);
				else if (name.equals(ReissueDescription.refname) || name.equals(ReissueDescription.shortname))
					reissueDescription = new ReissueDescription(element);
				else if (name.equals(Price.refname) || name.equals(Price.shortname))
					prices = JPU.addToList(prices, new Price(element));
				else if (name.equals(MediaFile.refname) || name.equals(MediaFile.shortname))
					mediaFiles = JPU.addToList(mediaFiles, new MediaFile(element));
			}
		});
	}

	public String getReissueDateValue()
	{
		return (reissueDate == null) ? null : reissueDate.value;
	}

	public String getReissueDescriptionValue()
	{
		return (reissueDescription == null) ? null : reissueDescription.value;
	}

	public JonixMediaFile findMediaFile(ImageAudioVideoFileTypes mediaFileTypeCode)
	{
		if (mediaFiles != null)
		{
			for (MediaFile x : mediaFiles)
			{
				if (x.getMediaFileTypeCodeValue() == mediaFileTypeCode)
					return x.asJonixMediaFile();
			}
		}
		return null;
	}

	public List<JonixMediaFile> findMediaFiles(java.util.Set<ImageAudioVideoFileTypes> mediaFileTypeCodes)
	{
		if (mediaFiles != null)
		{
			List<JonixMediaFile> matches = new ArrayList<>();
			for (MediaFile x : mediaFiles)
			{
				if (mediaFileTypeCodes == null || mediaFileTypeCodes.contains(x.getMediaFileTypeCodeValue()))
					matches.add(x.asJonixMediaFile());
			}
			return matches;
		}
		return null;
	}
}
