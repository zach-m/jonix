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

import java.util.List;

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.WorkRelations;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class RelatedWork
{
	public static final String refname = "RelatedWork";
	public static final String shortname = "relatedwork";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public WorkRelationCode workRelationCode; // Required
	public List<WorkIdentifier> workIdentifiers; // OneOrMore

	public static RelatedWork fromDoc(org.w3c.dom.Element element)
	{
		final RelatedWork x = new RelatedWork();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(WorkRelationCode.refname) || name.equals(WorkRelationCode.shortname))
					x.workRelationCode = WorkRelationCode.fromDoc(element);
				else if (name.equals(WorkIdentifier.refname) || name.equals(WorkIdentifier.shortname))
					x.workIdentifiers = DU.addToList(x.workIdentifiers, WorkIdentifier.fromDoc(element));
			}
		});

		return x;
	}

	public WorkRelations getWorkRelationCodeValue()
	{
		return (workRelationCode == null) ? null : workRelationCode.value;
	}
}
