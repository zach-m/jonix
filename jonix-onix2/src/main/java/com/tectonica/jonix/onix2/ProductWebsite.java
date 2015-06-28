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

@SuppressWarnings("serial")
public class ProductWebsite implements OnixDataComposite, Serializable
{
	public static final String refname = "ProductWebsite";
	public static final String shortname = "productwebsite";

	public TextFormats textformat;
	public TextCaseFlags textcase;
	public LanguageCodes language;
	public TransliterationSchemes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

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

	public ProductWebsite()
	{}

	public ProductWebsite(org.w3c.dom.Element element)
	{
		this.textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));
		this.textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));
		this.language = LanguageCodes.byValue(JPU.getAttribute(element, "language"));
		this.transliteration = TransliterationSchemes.byValue(JPU.getAttribute(element, "transliteration"));
		this.datestamp = JPU.getAttribute(element, "datestamp");
		this.sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		this.sourcename = JPU.getAttribute(element, "sourcename");

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

	public String getProductWebsiteDescriptionValue()
	{
		return (productWebsiteDescription == null) ? null : productWebsiteDescription.value;
	}

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
