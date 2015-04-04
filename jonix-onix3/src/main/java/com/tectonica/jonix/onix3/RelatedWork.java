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
import com.tectonica.jonix.OnixComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.WorkIdentifierTypes;
import com.tectonica.jonix.codelist.WorkRelations;
import com.tectonica.jonix.struct.JonixWorkIdentifier;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class RelatedWork implements OnixComposite, Serializable
{
	public static final String refname = "RelatedWork";
	public static final String shortname = "relatedwork";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public WorkRelationCode workRelationCode; // Required
	public List<WorkIdentifier> workIdentifiers; // OneOrMore

	public RelatedWork()
	{}

	public RelatedWork(org.w3c.dom.Element element)
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
				if (name.equals(WorkRelationCode.refname) || name.equals(WorkRelationCode.shortname))
					workRelationCode = new WorkRelationCode(element);
				else if (name.equals(WorkIdentifier.refname) || name.equals(WorkIdentifier.shortname))
					workIdentifiers = JPU.addToList(workIdentifiers, new WorkIdentifier(element));
			}
		});
	}

	public WorkRelations getWorkRelationCodeValue()
	{
		return (workRelationCode == null) ? null : workRelationCode.value;
	}

	public JonixWorkIdentifier findWorkIdentifier(WorkIdentifierTypes workIDType)
	{
		if (workIdentifiers != null)
		{
			for (WorkIdentifier x : workIdentifiers)
			{
				if (x.getWorkIDTypeValue() == workIDType)
					return x.asJonixWorkIdentifier();
			}
		}
		return null;
	}

	public List<JonixWorkIdentifier> findWorkIdentifiers(java.util.Set<WorkIdentifierTypes> workIDTypes)
	{
		if (workIdentifiers != null)
		{
			List<JonixWorkIdentifier> matches = new ArrayList<>();
			for (WorkIdentifier x : workIdentifiers)
			{
				if (workIDTypes == null || workIDTypes.contains(x.getWorkIDTypeValue()))
					matches.add(x.asJonixWorkIdentifier());
			}
			return matches;
		}
		return null;
	}
}
