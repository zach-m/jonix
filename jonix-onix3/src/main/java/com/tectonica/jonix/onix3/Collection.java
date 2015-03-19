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
import com.tectonica.jonix.codelist.CollectionTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class Collection
{
	public static final String refname = "Collection";
	public static final String shortname = "collection";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public CollectionType collectionType; // Required
	public SourceName sourceName; // Optional
	public List<CollectionIdentifier> collectionIdentifiers; // ZeroOrMore
	public List<CollectionSequence> collectionSequences; // ZeroOrMore
	public List<TitleDetail> titleDetails; // ZeroOrMore
	public List<Contributor> contributors; // ZeroOrMore
	public List<ContributorStatement> contributorStatements; // ZeroOrMore

	public static Collection fromDoc(org.w3c.dom.Element element)
	{
		final Collection x = new Collection();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(CollectionType.refname) || name.equals(CollectionType.shortname))
					x.collectionType = CollectionType.fromDoc(element);
				else if (name.equals(SourceName.refname) || name.equals(SourceName.shortname))
					x.sourceName = SourceName.fromDoc(element);
				else if (name.equals(CollectionIdentifier.refname) || name.equals(CollectionIdentifier.shortname))
					x.collectionIdentifiers = DU.addToList(x.collectionIdentifiers, CollectionIdentifier.fromDoc(element));
				else if (name.equals(CollectionSequence.refname) || name.equals(CollectionSequence.shortname))
					x.collectionSequences = DU.addToList(x.collectionSequences, CollectionSequence.fromDoc(element));
				else if (name.equals(TitleDetail.refname) || name.equals(TitleDetail.shortname))
					x.titleDetails = DU.addToList(x.titleDetails, TitleDetail.fromDoc(element));
				else if (name.equals(Contributor.refname) || name.equals(Contributor.shortname))
					x.contributors = DU.addToList(x.contributors, Contributor.fromDoc(element));
				else if (name.equals(ContributorStatement.refname) || name.equals(ContributorStatement.shortname))
					x.contributorStatements = DU.addToList(x.contributorStatements, ContributorStatement.fromDoc(element));
			}
		});

		return x;
	}

	public CollectionTypes getCollectionTypeValue()
	{
		return (collectionType == null) ? null : collectionType.value;
	}

	public String getSourceNameValue()
	{
		return (sourceName == null) ? null : sourceName.value;
	}

	public List<String> getContributorStatementValues()
	{
		if (contributorStatements != null)
		{
			List<String> list = new ArrayList<>();
			for (ContributorStatement i : contributorStatements)
				list.add(i.value);
			return list;
		}
		return null;
	}
}
