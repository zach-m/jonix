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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 149</b>
 * <p>
 * Description: Title element level
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist149">ONIX
 *      Codelist 149 in Reference Guide</a>
 */
public enum TitleElementLevels
{
	/**
	 * The title element refers to an individual product
	 */
	Product("01", "Product"), //

	/**
	 * The title element refers to the top level of a bibliographic collection
	 */
	Collection_level("02", "Collection level"), //

	/**
	 * The title element refers to an intermediate level of a bibliographic collection that comprises two or more
	 * 'sub-collections'
	 */
	Subcollection("03", "Subcollection"), //

	/**
	 * The title element refers to a content item within a product, eg a work included in a combined or 'omnibus'
	 * edition, or a chapter in a book
	 */
	Content_item("04", "Content item"), //

	/**
	 * The title element names a master brand where the use of the brand spans multiple collections and product forms,
	 * and possibly multiple imprints and publishers. Used only for branded media properties carrying, for example, a
	 * children's character brand
	 */
	Master_brand("05", "Master brand"), //

	/**
	 * The title element refers to an intermediate level of a bibliographic collection that is a subdivision of a
	 * sub-collection (a third level of collective identity)
	 */
	Sub_subcollection("06", "Sub-subcollection");

	public final String value;
	public final String label;

	private TitleElementLevels(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	public static TitleElementLevels byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (TitleElementLevels e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
