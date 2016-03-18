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

import com.tectonica.jonix.OnixCodelist;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 148 (Collection type)
 */
interface CodeList148
{}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 148</b>
 * <p>
 * Description: Collection type
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist148">ONIX
 *      Codelist 148 in Reference Guide</a>
 */
public enum CollectionTypes implements OnixCodelist, CodeList148
{
	/**
	 * Collection type is not determined
	 */
	Unspecified_default("00", "Unspecified (default)"), //

	/**
	 * The collection is a bibliographic collection (eg a series or set (Fr. s&#233;rie)) defined and identified by a
	 * publisher, either on the product itself or in product information supplied by the publisher. The books in the
	 * collection generally share a subject, narrative, design style or authorship. They may may have a specific order,
	 * or the collection may be unordered
	 */
	Publisher_collection("10", "Publisher collection"), //

	/**
	 * The collection is a bibliographic collection defined and identified by a publisher, either on the product itself
	 * or in product information supplied by the publisher, where the books in the collection have no specific order,
	 * shared subject, narrative, style or shared authorship, and are grouped by the publisher largely for marketing
	 * purposes. The collection has many of the characteristics of an imprint or marque. Used primarily in French book
	 * publishing, to distinguish between 's&#233;rie' (using the normal code 10) and 'collection' (code 11), and where
	 * the collection &#233;ditoriale is not an imprint
	 */
	Collection_ditoriale("11", "Collection éditoriale"), //

	/**
	 * The collection has been defined and identified by a party in the metadata supply chain other than the publisher,
	 * typically an aggregator.
	 */
	Ascribed_collection("20", "Ascribed collection");

	public final String code;
	public final String description;

	private CollectionTypes(String code, String description)
	{
		this.code = code;
		this.description = description;
	}

	@Override
	public String getCode()
	{
		return code;
	}

	@Override
	public String getDescription()
	{
		return description;
	}

	public static CollectionTypes byCode(String code)
	{
		if (code == null || code.isEmpty())
			return null;
		for (CollectionTypes e : values())
			if (e.code.equals(code))
				return e;
		return null;
	}
}
