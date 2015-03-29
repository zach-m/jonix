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
import com.tectonica.jonix.codelist.CollectionSequenceTypes;
import com.tectonica.jonix.codelist.CollectionTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.SeriesIdentifierTypes;
import com.tectonica.jonix.struct.JonixCollectionIdentifier;
import com.tectonica.jonix.struct.JonixCollectionSequence;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class Collection implements Serializable
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

	public Collection()
	{}

	public Collection(org.w3c.dom.Element element)
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
				if (name.equals(CollectionType.refname) || name.equals(CollectionType.shortname))
					collectionType = new CollectionType(element);
				else if (name.equals(SourceName.refname) || name.equals(SourceName.shortname))
					sourceName = new SourceName(element);
				else if (name.equals(CollectionIdentifier.refname) || name.equals(CollectionIdentifier.shortname))
					collectionIdentifiers = JPU.addToList(collectionIdentifiers, new CollectionIdentifier(element));
				else if (name.equals(CollectionSequence.refname) || name.equals(CollectionSequence.shortname))
					collectionSequences = JPU.addToList(collectionSequences, new CollectionSequence(element));
				else if (name.equals(TitleDetail.refname) || name.equals(TitleDetail.shortname))
					titleDetails = JPU.addToList(titleDetails, new TitleDetail(element));
				else if (name.equals(Contributor.refname) || name.equals(Contributor.shortname))
					contributors = JPU.addToList(contributors, new Contributor(element));
				else if (name.equals(ContributorStatement.refname) || name.equals(ContributorStatement.shortname))
					contributorStatements = JPU.addToList(contributorStatements, new ContributorStatement(element));
			}
		});
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

	public JonixCollectionIdentifier findCollectionIdentifier(SeriesIdentifierTypes collectionIDType)
	{
		if (collectionIdentifiers != null)
		{
			for (CollectionIdentifier x : collectionIdentifiers)
			{
				if (x.getCollectionIDTypeValue() == collectionIDType)
					return x.asJonixCollectionIdentifier();
			}
		}
		return null;
	}

	public List<JonixCollectionIdentifier> findCollectionIdentifiers(java.util.Set<SeriesIdentifierTypes> collectionIDTypes)
	{
		if (collectionIdentifiers != null)
		{
			List<JonixCollectionIdentifier> matches = new ArrayList<>();
			for (CollectionIdentifier x : collectionIdentifiers)
			{
				if (collectionIDTypes == null || collectionIDTypes.contains(x.getCollectionIDTypeValue()))
					matches.add(x.asJonixCollectionIdentifier());
			}
			return matches;
		}
		return null;
	}

	public JonixCollectionSequence findCollectionSequence(CollectionSequenceTypes collectionSequenceType)
	{
		if (collectionSequences != null)
		{
			for (CollectionSequence x : collectionSequences)
			{
				if (x.getCollectionSequenceTypeValue() == collectionSequenceType)
					return x.asJonixCollectionSequence();
			}
		}
		return null;
	}

	public List<JonixCollectionSequence> findCollectionSequences(java.util.Set<CollectionSequenceTypes> collectionSequenceTypes)
	{
		if (collectionSequences != null)
		{
			List<JonixCollectionSequence> matches = new ArrayList<>();
			for (CollectionSequence x : collectionSequences)
			{
				if (collectionSequenceTypes == null || collectionSequenceTypes.contains(x.getCollectionSequenceTypeValue()))
					matches.add(x.asJonixCollectionSequence());
			}
			return matches;
		}
		return null;
	}
}
