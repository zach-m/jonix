package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 45
 * 
 * @author Zach Melamed
 * 
 */
public enum PublishingRoles
{
	Publisher("01"),

	/**
	 * Use where two or more publishers co-publish the exact same product, either under a single ISBN (in which case both publishers are co-publishers), or under different ISBNs (in which case the publisher of THIS ISBN is the publisher and the publishers of OTHER ISBNs are co-publishers. Note this is different from publication of 'co-editions'.
	 */
	Copublisher("02"),

	Sponsor("03"),

	/**
	 * Of a translated work.
	 */
	Publisher_of_originallanguage_version("04"),

	Host_distributor_of_electronic_content("05"),

	Published_for_on_behalf_of("06"),

	/**
	 * Use also for “Published in cooperation with”.
	 */
	Published_in_association_with("07"),

	/**
	 * DEPRECATED: use code 06.
	 */
	Published_on_behalf_of("08"),

	/**
	 * When ownership of a product or title is transferred from one publisher to another.
	 */
	New_or_acquiring_publisher("09"),

	/**
	 * The group to which a publisher (publishing role 01) belongs: use only if a publisher has been identified with role code 01.
	 */
	Publishing_group("10"),

	/**
	 * The publisher of the edition of which a product is a facsimile.
	 */
	Publisher_of_facsimile_original("11"),

	/**
	 * The repackager of a prebound edition that has been assigned its own identifier. (In the US, a ‘prebound edition’ is a book that was previously bound, normally as a paperback, and has been rebound with a library-quality hardcover binding by a supplier other than the original publisher.) Required when the <EditionType> is coded PRB. The original publisher should be named as the ‘publisher’.
	 */
	Repackager_of_prebound_edition("12"),

	/**
	 * When ownership of a product or title is transferred from one publisher to another (complement of code 09).
	 */
	Former_publisher("13");

	public final String code;

	private PublishingRoles(String code)
	{
		this.code = code;
	}

	private static PublishingRoles[] values = PublishingRoles.values();
	public static PublishingRoles fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (PublishingRoles item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

