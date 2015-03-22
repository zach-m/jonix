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
 * Enum that corresponds to ONIX's CodeList57
 * <p>
 * Unpriced item type code
 * 
 * @see http://www.editeur.org/14/code-lists/
 */
public enum UnpricedItemTypes
{
	Free_of_charge("01"), //

	Price_to_be_announced("02"), //

	/**
	 * Not sold separately at retail.
	 */
	Not_sold_separately("03"), //

	/**
	 * May be used for books that do not carry a recommended retail price; when goods can only be ordered ‘in person’ from a sales
	 * representative; when an ONIX file is “broadcast” rather than sent one-to-one to a single trading partner; or for digital products
	 * offered on subscription or with pricing which is too complex to specify in ONIX.
	 */
	Contact_supplier("04"), //

	/**
	 * When a collection that is not sold as a set nevertheless has its own ONIX record.
	 */
	Not_sold_as_set("05");

	public final String value;

	private UnpricedItemTypes(String value)
	{
		this.value = value;
	}

	public static UnpricedItemTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (UnpricedItemTypes e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
