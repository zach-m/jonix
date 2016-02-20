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

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.codelist.WebsiteRoles;
import com.tectonica.jonix.struct.JonixProductWebsite;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Product website composite</h1>
 * <p>
 * An optional and repeatable group of data elements which together identify and provide pointers to a website which is
 * related to the product.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;ProductWebsite&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;productwebsite&gt;</td>
 * </tr>
 * </table>
 */
public class ProductWebsite implements OnixDataComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "ProductWebsite";
	public static final String shortname = "productwebsite";

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
	 * (this field is optional)
	 */
	public WebsiteRole websiteRole;

	/**
	 * (this field is optional)
	 */
	public ProductWebsiteDescription productWebsiteDescription;

	/**
	 * (this field is required)
	 */
	public ProductWebsiteLink productWebsiteLink;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public ProductWebsite()
	{}

	public ProductWebsite(org.w3c.dom.Element element)
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
				if (name.equals(WebsiteRole.refname) || name.equals(WebsiteRole.shortname))
					websiteRole = new WebsiteRole(element);
				else if (name.equals(ProductWebsiteDescription.refname)
						|| name.equals(ProductWebsiteDescription.shortname))
					productWebsiteDescription = new ProductWebsiteDescription(element);
				else if (name.equals(ProductWebsiteLink.refname) || name.equals(ProductWebsiteLink.shortname))
					productWebsiteLink = new ProductWebsiteLink(element);
			}
		});
	}

	public WebsiteRoles getWebsiteRoleValue()
	{
		return (websiteRole == null) ? null : websiteRole.value;
	}

	/**
	 * Format: Variable-length text, suggested maximum length 300 characters (XHTML is enabled in this element - see
	 * ONIX for Books - Product Information Message - XML Message Specification, Section 7)
	 */
	public String getProductWebsiteDescriptionValue()
	{
		return (productWebsiteDescription == null) ? null : productWebsiteDescription.value;
	}

	/**
	 * Format: Variable-length text, suggested maximum length 300 characters
	 */
	public String getProductWebsiteLinkValue()
	{
		return (productWebsiteLink == null) ? null : productWebsiteLink.value;
	}

	public JonixProductWebsite asJonixProductWebsite()
	{
		JonixProductWebsite x = new JonixProductWebsite();
		x.websiteRole = getWebsiteRoleValue();
		x.productWebsiteDescription = getProductWebsiteDescriptionValue();
		x.productWebsiteLink = getProductWebsiteLinkValue();
		return x;
	}
}
