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
import com.tectonica.jonix.codelist.LicenseExpressionTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixEpubLicenseExpression;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Digital product license expression</h1>
 * <p>
 * An optional and repeatable composite that carries details of a link to an expression of the license terms, which may
 * be in human-readable or machine-readable form. Repeatable when there is more than one expression of the license.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;EpubLicenseExpression&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;epublicenseexpression&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class EpubLicenseExpression implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "EpubLicenseExpression";
	public static final String shortname = "epublicenseexpression";

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
	public EpubLicenseExpressionType epubLicenseExpressionType;

	/**
	 * (this field is optional)
	 */
	public EpubLicenseExpressionTypeName epubLicenseExpressionTypeName;

	/**
	 * (this field is required)
	 */
	public EpubLicenseExpressionLink epubLicenseExpressionLink;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public EpubLicenseExpression()
	{}

	public EpubLicenseExpression(org.w3c.dom.Element element)
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
				if (name.equals(EpubLicenseExpressionType.refname) || name.equals(EpubLicenseExpressionType.shortname))
					epubLicenseExpressionType = new EpubLicenseExpressionType(element);
				else if (name.equals(EpubLicenseExpressionTypeName.refname)
						|| name.equals(EpubLicenseExpressionTypeName.shortname))
					epubLicenseExpressionTypeName = new EpubLicenseExpressionTypeName(element);
				else if (name.equals(EpubLicenseExpressionLink.refname)
						|| name.equals(EpubLicenseExpressionLink.shortname))
					epubLicenseExpressionLink = new EpubLicenseExpressionLink(element);
			}
		});
	}

	public LicenseExpressionTypes getEpubLicenseExpressionTypeValue()
	{
		return (epubLicenseExpressionType == null) ? null : epubLicenseExpressionType.value;
	}

	/**
	 * Format: Variable-length text, suggested maximum length 50 characters
	 */
	public String getEpubLicenseExpressionTypeNameValue()
	{
		return (epubLicenseExpressionTypeName == null) ? null : epubLicenseExpressionTypeName.value;
	}

	/**
	 * Format: Variable-length text, suggested maximum length 300 characters
	 */
	public String getEpubLicenseExpressionLinkValue()
	{
		return (epubLicenseExpressionLink == null) ? null : epubLicenseExpressionLink.value;
	}

	public JonixEpubLicenseExpression asJonixEpubLicenseExpression()
	{
		JonixEpubLicenseExpression x = new JonixEpubLicenseExpression();
		x.epubLicenseExpressionType = getEpubLicenseExpressionTypeValue();
		x.epubLicenseExpressionTypeName = getEpubLicenseExpressionTypeNameValue();
		x.epubLicenseExpressionLink = getEpubLicenseExpressionLinkValue();
		return x;
	}
}
