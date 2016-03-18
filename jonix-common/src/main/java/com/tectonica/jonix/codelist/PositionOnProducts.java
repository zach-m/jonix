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

import java.util.HashMap;
import java.util.Map;

import com.tectonica.jonix.OnixCodelist;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 142 (Position on product)
 */
interface CodeList142
{}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 142</b>
 * <p>
 * Description: Position on product
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist142">ONIX
 *      Codelist 142 in Reference Guide</a>
 */
public enum PositionOnProducts implements OnixCodelist, CodeList142
{
	/**
	 * Position unknown or unspecified
	 */
	Unknown_unspecified("00", "Unknown / unspecified"), //

	/**
	 * The back cover of a book
	 */
	Cover_4("01", "Cover 4"), //

	/**
	 * The inside back cover of a book
	 */
	Cover_3("02", "Cover 3"), //

	/**
	 * The inside front cover of a book
	 */
	Cover_2("03", "Cover 2"), //

	/**
	 * The front cover of a book
	 */
	Cover_1("04", "Cover 1"), //

	/**
	 * The spine of a book
	 */
	On_spine("05", "On spine"), //

	/**
	 * Used only for boxed products
	 */
	On_box("06", "On box"), //

	/**
	 * Used only for products fitted with hanging tags
	 */
	On_tag("07", "On tag"), //

	/**
	 * Not be used for books unless they are contained within outer packaging
	 */
	On_bottom("08", "On bottom"), //

	/**
	 * Not be used for books unless they are contained within outer packaging
	 */
	On_back("09", "On back"), //

	/**
	 * Used only for products packaged in outer sleeves
	 */
	On_outer_sleeve_back("10", "On outer sleeve / back"), //

	/**
	 * Used only for products packaged in shrink-wrap or other removable wrapping
	 */
	On_removable_wrapping("11", "On removable wrapping");

	public final String code;
	public final String description;

	private PositionOnProducts(String code, String description)
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

	private static volatile Map<String, PositionOnProducts> map;

	private static Map<String, PositionOnProducts> map()
	{
		Map<String, PositionOnProducts> result = map;
		if (result == null)
		{
			synchronized (PositionOnProducts.class)
			{
				result = map;
				if (result == null)
				{
					result = new HashMap<>();
					for (PositionOnProducts e : values())
						result.put(e.code, e);
					map = result;
				}
			}
		}
		return result;
	}

	public static PositionOnProducts byCode(String code)
	{
		if (code == null || code.isEmpty())
			return null;
		return map().get(code);
	}
}
