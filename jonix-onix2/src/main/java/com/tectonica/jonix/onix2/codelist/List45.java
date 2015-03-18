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

package com.tectonica.jonix.onix2.codelist;

import java.util.Map;
import java.util.HashMap;

/**
 * Publishing role code
 */
public enum List45
{
	Publisher("01"), //

	/**
	 * Use where two or more publishers co-publish the exact same product, either under a single ISBN (in which case both publishers are
	 * co-publishers), or under different ISBNs (in which case the publisher of THIS ISBN is the publisher and the publishers of OTHER ISBNs
	 * are co-publishers. Note this is different from publication of ‘co-editions’.
	 */
	Co_publisher("02"), //

	Sponsor("03"), //

	/**
	 * Of a translated work.
	 */
	Publisher_of_original_language_version("04"), //

	Host_distributor_of_electronic_content("05"), //

	Published_for_on_behalf_of("06"), //

	/**
	 * Use also for “Published in cooperation with”.
	 */
	Published_in_association_with("07"), //

	/**
	 * DEPRECATED: use code 06.
	 */
	Published_on_behalf_of("08"), //

	/**
	 * When ownership of a product or title is transferred from one publisher to another.
	 */
	New_or_acquiring_publisher("09"), //

	/**
	 * The group to which a publisher (publishing role 01) belongs: use only if a publisher has been identified with role code 01.
	 */
	Publishing_group("10"), //

	/**
	 * The publisher of the edition of which a product is a facsimile.
	 */
	Publisher_of_facsimile_original("11"), //

	/**
	 * The repackager of a prebound edition that has been assigned its own identifier. (In the US, a ‘prebound edition’ is a book that was
	 * previously bound, normally as a paperback, and has been rebound with a library-quality hardcover binding by a supplier other than the
	 * original publisher.) Required when the <EditionType> is coded PRB. The original publisher should be named as the ‘publisher’.
	 */
	Repackager_of_prebound_edition("12"), //

	/**
	 * When ownership of a product or title is transferred from one publisher to another (complement of code 09).
	 */
	Former_publisher("13"), //

	/**
	 * Body funding publication fees, if different from the body funding the underlying research. For use with open access publications.
	 */
	Publication_funder("14"), //

	/**
	 * Body funding the research on which publication is based, if different from the body funding the publication. For use with open access
	 * publications.
	 */
	Research_funder("15"), //

	/**
	 * Body funding research and publication. For use with open access publications.
	 */
	Funding_body("16"), //

	/**
	 * Organisation responsible for printing a printed product. Supplied primarily to meet legal deposit requirements, and may apply only to
	 * the first impression. The organisation may also be responsible for binding, when a separate binder is not specified.
	 */
	Printer("17"), //

	/**
	 * Organisation responsible for binding a printed product (where distinct from the printer). Supplied primarily to meet legal deposit
	 * requirements, and may apply only to the first impression.
	 */
	Binder("18");

	public final String value;

	private List45(String value)
	{
		this.value = value;
	}

	private static Map<String, List45> map;

	private static Map<String, List45> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List45 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List45 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
