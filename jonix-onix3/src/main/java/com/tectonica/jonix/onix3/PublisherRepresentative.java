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
import com.tectonica.jonix.ListOfOnixDataComposite;
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SupplierIdentifierTypes;
import com.tectonica.jonix.struct.JonixAgentIdentifier;
import com.tectonica.jonix.struct.JonixWebsite;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Publisher representative composite</h1>
 * <p>
 * A repeatable group of data elements which together identify a publisher representative in a specified market.
 * Optional, and repeated only if the publisher has two or more representatives.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;PublisherRepresentative&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;publisherrepresentative&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class PublisherRepresentative implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "PublisherRepresentative";
	public static final String shortname = "publisherrepresentative";

	/////////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	/////////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	/////////////////////////////////////////////////////////////////////////////////
	// CONSTRUCTION
	/////////////////////////////////////////////////////////////////////////////////

	private boolean initialized;
	private final boolean exists;
	private final org.w3c.dom.Element element;
	public static final PublisherRepresentative EMPTY = new PublisherRepresentative();

	public PublisherRepresentative()
	{
		exists = false;
		element = null;
		initialized = true; // so that no further processing will be done on this intentionally-empty object
	}

	public PublisherRepresentative(org.w3c.dom.Element element)
	{
		exists = true;
		initialized = false;
		this.element = element;
	}

	private void initialize()
	{
		if (initialized)
			return;
		initialized = true;

		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, e -> {
			final String name = e.getNodeName();
			if (name.equals(AgentRole.refname) || name.equals(AgentRole.shortname))
				agentRole = new AgentRole(e);
			else if (name.equals(AgentIdentifier.refname) || name.equals(AgentIdentifier.shortname))
				agentIdentifiers = JPU.addToList(agentIdentifiers, new AgentIdentifier(e));
			else if (name.equals(AgentName.refname) || name.equals(AgentName.shortname))
				agentName = new AgentName(e);
			else if (name.equals(TelephoneNumber.refname) || name.equals(TelephoneNumber.shortname))
				telephoneNumbers = JPU.addToList(telephoneNumbers, new TelephoneNumber(e));
			else if (name.equals(FaxNumber.refname) || name.equals(FaxNumber.shortname))
				faxNumbers = JPU.addToList(faxNumbers, new FaxNumber(e));
			else if (name.equals(EmailAddress.refname) || name.equals(EmailAddress.shortname))
				emailAddresss = JPU.addToList(emailAddresss, new EmailAddress(e));
			else if (name.equals(Website.refname) || name.equals(Website.shortname))
				websites = JPU.addToList(websites, new Website(e));
		});
	}

	@Override
	public boolean exists()
	{
		return exists;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	/////////////////////////////////////////////////////////////////////////////////

	private AgentRole agentRole = AgentRole.EMPTY;

	/**
	 * (this field is required)
	 */
	public AgentRole agentRole()
	{
		initialize();
		return agentRole;
	}

	private ListOfOnixDataCompositeWithKey<AgentIdentifier, JonixAgentIdentifier, SupplierIdentifierTypes> agentIdentifiers = ListOfOnixDataCompositeWithKey
			.emptyKeyed();

	/**
	 * (this list is required to contain at least one item)
	 */
	public ListOfOnixDataCompositeWithKey<AgentIdentifier, JonixAgentIdentifier, SupplierIdentifierTypes> agentIdentifiers()
	{
		initialize();
		return agentIdentifiers;
	}

	private AgentName agentName = AgentName.EMPTY;

	/**
	 * (this field is optional)
	 */
	public AgentName agentName()
	{
		initialize();
		return agentName;
	}

	private ListOfOnixElement<TelephoneNumber, String> telephoneNumbers = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<TelephoneNumber, String> telephoneNumbers()
	{
		initialize();
		return telephoneNumbers;
	}

	private ListOfOnixElement<FaxNumber, String> faxNumbers = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<FaxNumber, String> faxNumbers()
	{
		initialize();
		return faxNumbers;
	}

	private ListOfOnixElement<EmailAddress, String> emailAddresss = ListOfOnixElement.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixElement<EmailAddress, String> emailAddresss()
	{
		initialize();
		return emailAddresss;
	}

	private ListOfOnixDataComposite<Website, JonixWebsite> websites = ListOfOnixDataComposite.empty();

	/**
	 * (this list may be empty)
	 */
	public ListOfOnixDataComposite<Website, JonixWebsite> websites()
	{
		initialize();
		return websites;
	}
}
