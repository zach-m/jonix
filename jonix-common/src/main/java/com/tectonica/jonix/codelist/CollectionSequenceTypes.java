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

package com.tectonica.jonix.codelist;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Enum that corresponds to ONIX's CodeList197
 * <p>
 * Collection sequence type
 * 
 * @see http://www.editeur.org/14/code-lists/
 */
public enum CollectionSequenceTypes
{
	/**
	 * A short explanatory label for the sequence should be provided in <CollectionSequenceTypeName>.
	 */
	Proprietary("01"), //

	/**
	 * Order as specified by the title, eg by volume or part number sequence, provided for confirmation.
	 */
	Title_order("02"), //

	/**
	 * Order of publication of products within the collection.
	 */
	Publication_order("03"), //

	/**
	 * Order defined by a continuing narrative or temporal sequence within products in the collection. Applicable to either fiction or to
	 * non-fiction (eg within a collection of history textbooks).
	 */
	Temporal_narrative_order("04"), //

	/**
	 * Original publication order, for a republished collection or collected works originally published outside a collection.
	 */
	Original_publication_order("05");

	public final String value;

	private CollectionSequenceTypes(String value)
	{
		this.value = value;
	}

	public static CollectionSequenceTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (CollectionSequenceTypes e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
