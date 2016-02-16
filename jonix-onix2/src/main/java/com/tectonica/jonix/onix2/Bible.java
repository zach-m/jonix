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
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.BibleContentss;
import com.tectonica.jonix.codelist.BiblePurposes;
import com.tectonica.jonix.codelist.BibleReferenceLocations;
import com.tectonica.jonix.codelist.BibleTextFeatures;
import com.tectonica.jonix.codelist.BibleTextOrganizations;
import com.tectonica.jonix.codelist.BibleVersions;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.StudyBibleTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixBible;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Bible composite</h1>
 * <p>
 * A group of data elements which together describe features of an edition of the Bible or of a selected Biblical text.
 * Mandatory in each occurrence of the &lt;ReligiousText&gt; composite that does not include a &lt;ReligiousTextID&gt;
 * element, and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;Bible&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;bible&gt;</td>
 * </tr>
 * </table>
 */
public class Bible implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "Bible";
	public static final String shortname = "bible";

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
	 * (this list is required to contain at least one item)
	 */
	public List<BibleContents> bibleContentss;

	/**
	 * (this list is required to contain at least one item)
	 */
	public List<BibleVersion> bibleVersions;

	/**
	 * (this field is optional)
	 */
	public StudyBibleType studyBibleType;

	/**
	 * (this list may be empty)
	 */
	public List<BiblePurpose> biblePurposes;

	/**
	 * (this field is optional)
	 */
	public BibleTextOrganization bibleTextOrganization;

	/**
	 * (this field is optional)
	 */
	public BibleReferenceLocation bibleReferenceLocation;

	/**
	 * (this list may be empty)
	 */
	public List<BibleTextFeature> bibleTextFeatures;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public Bible()
	{}

	public Bible(org.w3c.dom.Element element)
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
				if (name.equals(BibleContents.refname) || name.equals(BibleContents.shortname))
					bibleContentss = JPU.addToList(bibleContentss, new BibleContents(element));
				else if (name.equals(BibleVersion.refname) || name.equals(BibleVersion.shortname))
					bibleVersions = JPU.addToList(bibleVersions, new BibleVersion(element));
				else if (name.equals(StudyBibleType.refname) || name.equals(StudyBibleType.shortname))
					studyBibleType = new StudyBibleType(element);
				else if (name.equals(BiblePurpose.refname) || name.equals(BiblePurpose.shortname))
					biblePurposes = JPU.addToList(biblePurposes, new BiblePurpose(element));
				else if (name.equals(BibleTextOrganization.refname) || name.equals(BibleTextOrganization.shortname))
					bibleTextOrganization = new BibleTextOrganization(element);
				else if (name.equals(BibleReferenceLocation.refname) || name.equals(BibleReferenceLocation.shortname))
					bibleReferenceLocation = new BibleReferenceLocation(element);
				else if (name.equals(BibleTextFeature.refname) || name.equals(BibleTextFeature.shortname))
					bibleTextFeatures = JPU.addToList(bibleTextFeatures, new BibleTextFeature(element));
			}
		});
	}

	public List<BibleContentss> getBibleContentsValues()
	{
		if (bibleContentss != null)
		{
			List<BibleContentss> list = new ArrayList<>();
			for (BibleContents i : bibleContentss)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public List<BibleVersions> getBibleVersionValues()
	{
		if (bibleVersions != null)
		{
			List<BibleVersions> list = new ArrayList<>();
			for (BibleVersion i : bibleVersions)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public StudyBibleTypes getStudyBibleTypeValue()
	{
		return (studyBibleType == null) ? null : studyBibleType.value;
	}

	public List<BiblePurposes> getBiblePurposeValues()
	{
		if (biblePurposes != null)
		{
			List<BiblePurposes> list = new ArrayList<>();
			for (BiblePurpose i : biblePurposes)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public BibleTextOrganizations getBibleTextOrganizationValue()
	{
		return (bibleTextOrganization == null) ? null : bibleTextOrganization.value;
	}

	public BibleReferenceLocations getBibleReferenceLocationValue()
	{
		return (bibleReferenceLocation == null) ? null : bibleReferenceLocation.value;
	}

	public List<BibleTextFeatures> getBibleTextFeatureValues()
	{
		if (bibleTextFeatures != null)
		{
			List<BibleTextFeatures> list = new ArrayList<>();
			for (BibleTextFeature i : bibleTextFeatures)
				list.add(i.value);
			return list;
		}
		return null;
	}

	public JonixBible asJonixBible()
	{
		JonixBible x = new JonixBible();
		x.bibleContentss = getBibleContentsValues();
		x.biblePurposes = getBiblePurposeValues();
		x.bibleReferenceLocation = getBibleReferenceLocationValue();
		x.bibleTextFeatures = getBibleTextFeatureValues();
		x.bibleTextOrganization = getBibleTextOrganizationValue();
		x.bibleVersions = getBibleVersionValues();
		x.studyBibleType = getStudyBibleTypeValue();
		return x;
	}
}
