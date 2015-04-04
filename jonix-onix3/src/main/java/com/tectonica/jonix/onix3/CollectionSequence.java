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
import com.tectonica.jonix.OnixComposite;
import com.tectonica.jonix.codelist.CollectionSequenceTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixCollectionSequence;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class CollectionSequence implements OnixComposite, Serializable
{
	public static final String refname = "CollectionSequence";
	public static final String shortname = "collectionsequence";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public CollectionSequenceType collectionSequenceType; // Required
	public CollectionSequenceTypeName collectionSequenceTypeName; // Optional
	public CollectionSequenceNumber collectionSequenceNumber; // Required

	public CollectionSequence()
	{}

	public CollectionSequence(org.w3c.dom.Element element)
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
				if (name.equals(CollectionSequenceType.refname) || name.equals(CollectionSequenceType.shortname))
					collectionSequenceType = new CollectionSequenceType(element);
				else if (name.equals(CollectionSequenceTypeName.refname) || name.equals(CollectionSequenceTypeName.shortname))
					collectionSequenceTypeName = new CollectionSequenceTypeName(element);
				else if (name.equals(CollectionSequenceNumber.refname) || name.equals(CollectionSequenceNumber.shortname))
					collectionSequenceNumber = new CollectionSequenceNumber(element);
			}
		});
	}

	public CollectionSequenceTypes getCollectionSequenceTypeValue()
	{
		return (collectionSequenceType == null) ? null : collectionSequenceType.value;
	}

	public String getCollectionSequenceTypeNameValue()
	{
		return (collectionSequenceTypeName == null) ? null : collectionSequenceTypeName.value;
	}

	public String getCollectionSequenceNumberValue()
	{
		return (collectionSequenceNumber == null) ? null : collectionSequenceNumber.value;
	}

	public JonixCollectionSequence asJonixCollectionSequence()
	{
		JonixCollectionSequence x = new JonixCollectionSequence();
		x.collectionSequenceTypeName = getCollectionSequenceTypeNameValue();
		x.collectionSequenceNumber = getCollectionSequenceNumberValue();
		return x;
	}
}
