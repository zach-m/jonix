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
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 148</b>
 * <p>
 * Description: Collection type
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum CollectionTypes
{
	/**
	 * Collection type is not determined.
	 */
	Unspecified_default("00"), //

	/**
	 * The collection is a bibliographic collection (eg a series or set (Fr. s&#233;rie)) defined and identified by a
	 * publisher, either on the product itself or in product information supplied by the publisher. The books in the
	 * collection generally share a subject, narrative, design style or authorship. They may may have a specific order,
	 * or the collection may be unordered.
	 */
	Publisher_collection("10"), //

	/**
	 * The collection is a bibliographic collection defined and identified by a publisher, either on the product itself
	 * or in product information supplied by the publisher, where the books in the collection have no specific order,
	 * shared subject, narrative, style or shared authorship, and are grouped by the publisher largely for marketing
	 * purposes. The collection has many of the characteristics of an imprint or marque. Used only in French book
	 * publishing, to distinguish between &#8216;s&#233;rie&#8217; (using the normal code 10) and
	 * &#8216;collection&#8217; (code 11), and where the collection &#233;ditoriale is not an imprint.
	 */
	Collection_ditoriale("11"), //

	Ascribed_collection("20");

	public final String value;

	private CollectionTypes(String value)
	{
		this.value = value;
	}

	public static CollectionTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (CollectionTypes e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
