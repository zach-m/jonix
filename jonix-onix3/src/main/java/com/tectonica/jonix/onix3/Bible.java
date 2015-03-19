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

import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.BibleContentss;
import com.tectonica.jonix.codelist.BiblePurposes;
import com.tectonica.jonix.codelist.BibleReferenceLocations;
import com.tectonica.jonix.codelist.BibleTextFeatures;
import com.tectonica.jonix.codelist.BibleTextOrganizations;
import com.tectonica.jonix.codelist.BibleVersions;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.StudyBibleTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Bible
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

	public static Bible fromDoc(org.w3c.dom.Element element)
	{
		final Bible x = new Bible();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(BibleContents.refname) || name.equals(BibleContents.shortname))
					x.bibleContentss = DU.addToList(x.bibleContentss, BibleContents.fromDoc(element));
				else if (name.equals(BibleVersion.refname) || name.equals(BibleVersion.shortname))
					x.bibleVersions = DU.addToList(x.bibleVersions, BibleVersion.fromDoc(element));
				else if (name.equals(StudyBibleType.refname) || name.equals(StudyBibleType.shortname))
					x.studyBibleType = StudyBibleType.fromDoc(element);
				else if (name.equals(BiblePurpose.refname) || name.equals(BiblePurpose.shortname))
					x.biblePurposes = DU.addToList(x.biblePurposes, BiblePurpose.fromDoc(element));
				else if (name.equals(BibleTextOrganization.refname) || name.equals(BibleTextOrganization.shortname))
					x.bibleTextOrganization = BibleTextOrganization.fromDoc(element);
				else if (name.equals(BibleReferenceLocation.refname) || name.equals(BibleReferenceLocation.shortname))
					x.bibleReferenceLocation = BibleReferenceLocation.fromDoc(element);
				else if (name.equals(BibleTextFeature.refname) || name.equals(BibleTextFeature.shortname))
					x.bibleTextFeatures = DU.addToList(x.bibleTextFeatures, BibleTextFeature.fromDoc(element));
			}
		});

		return x;
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
}
