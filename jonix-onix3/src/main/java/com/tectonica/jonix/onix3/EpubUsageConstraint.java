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
import java.util.List;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.UsageStatuss;
import com.tectonica.jonix.codelist.UsageTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Usage constraint composite (digital products)</h1>
 * <p>
 * An optional and repeatable group of data elements which together describe a usage constraint on a digital product (or
 * the absence of such a constraint), whether enforced by DRM technical protection, inherent in the platform used, or
 * specified by license agreement.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;EpubUsageConstraint&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;epubusageconstraint&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class EpubUsageConstraint implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "EpubUsageConstraint";
	public static final String shortname = "epubusageconstraint";

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
	 * (this field is required)
	 */
	public EpubUsageType epubUsageType;

	/**
	 * (this field is required)
	 */
	public EpubUsageStatus epubUsageStatus;

	/**
	 * (this list may be empty)
	 */
	public List<EpubUsageLimit> epubUsageLimits;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public EpubUsageConstraint()
	{}

	public EpubUsageConstraint(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(EpubUsageType.refname) || name.equals(EpubUsageType.shortname))
					epubUsageType = new EpubUsageType(element);
				else if (name.equals(EpubUsageStatus.refname) || name.equals(EpubUsageStatus.shortname))
					epubUsageStatus = new EpubUsageStatus(element);
				else if (name.equals(EpubUsageLimit.refname) || name.equals(EpubUsageLimit.shortname))
					epubUsageLimits = JPU.addToList(epubUsageLimits, new EpubUsageLimit(element));
			}
		});
	}

	public UsageTypes getEpubUsageTypeValue()
	{
		return (epubUsageType == null) ? null : epubUsageType.value;
	}

	public UsageStatuss getEpubUsageStatusValue()
	{
		return (epubUsageStatus == null) ? null : epubUsageStatus.value;
	}
}
