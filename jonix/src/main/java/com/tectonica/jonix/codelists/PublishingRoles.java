package com.tectonica.jonix.codelists;

/**
 * List 45
 * 
 * @author Zach Melamed
 *
 */
public enum PublishingRoles
{
	Publisher("01"),

	Co_publisher("02"),

	Sponsor("03"),

	Publisher_of_original_language_version("04"),

	Host_or_distributor_of_electronic_content("05"),

	Published_for_or_on_behalf_of("06"),

	Published_in_association_with("07"),

	Published_on_behalf_of("08"),

	New_or_acquiring_publisher("09"),

	Publishing_group("10"),

	Publisher_of_facsimile_original("11"),

	Repackager_of_prebound_edition("12"),

	Former_publisher("13");

	public final String code;

	private PublishingRoles(String code)
	{
		this.code = code;
	}

	private static PublishingRoles[] values = PublishingRoles.values();

	public static PublishingRoles fromCode(String code)
	{
		for (PublishingRoles item : values)
			if (item.code.equals(code))
				return item;
		return null;
	}
}
