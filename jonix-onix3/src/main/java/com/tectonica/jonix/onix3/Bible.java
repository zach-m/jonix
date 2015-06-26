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
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.StudyBibleTypes;
import com.tectonica.jonix.struct.JonixBible;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class Bible implements OnixDataComposite, Serializable
{
	public static final String refname = "Bible";
	public static final String shortname = "bible";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public List<BibleContents> bibleContentss; // OneOrMore
	public List<BibleVersion> bibleVersions; // OneOrMore
	public StudyBibleType studyBibleType; // Optional
	public List<BiblePurpose> biblePurposes; // ZeroOrMore
	public BibleTextOrganization bibleTextOrganization; // Optional
	public BibleReferenceLocation bibleReferenceLocation; // Optional
	public List<BibleTextFeature> bibleTextFeatures; // ZeroOrMore

	public Bible()
	{}

	public Bible(org.w3c.dom.Element element)
	{
		this.datestamp = JPU.getAttribute(element, "datestamp");
		this.sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		this.sourcename = JPU.getAttribute(element, "sourcename");

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
