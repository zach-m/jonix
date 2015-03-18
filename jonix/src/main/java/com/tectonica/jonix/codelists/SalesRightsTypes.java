package com.tectonica.jonix.codelists;

/**
 * List 46
 * 
 * @author Zach Melamed
 *
 */
public enum SalesRightsTypes
{
	Sales_rights_unknown_or_unstated_for_any_reason("00"),

	For_unrestricted_sale_with_exclusive_rights_in_the_specified_countries_or_territories("01"),

	For_unrestricted_sale_with_non_exclusive_rights_in_the_specified_countries_or_territories("02"),

	Not_for_sale_in_the_specified_countries_or_territories_reason_unspecified("03"),

	Not_for_sale_in_the_specified_countries_but_publisher_holds_exclusive_rights_in_those_countries_or_territories("04"),

	Not_for_sale_in_the_specified_countries_publisher_holds_non_exclusive_rights_in_those_countries_or_territories("05"),

	Not_for_sale_in_the_specified_countries_because_publisher_does_not_hold_rights_in_those_countries_or_territories("06"),

	For_sale_with_exclusive_rights_in_the_specified_countries_or_territories_sales_restriction_applies("07"),

	For_sale_with_non_exclusive_rights_in_the_specified_countries_or_territories_sales_restriction_applies("08");

	public final String code;

	private SalesRightsTypes(String code)
	{
		this.code = code;
	}

	private static SalesRightsTypes[] values = SalesRightsTypes.values();

	public static SalesRightsTypes fromCode(String code)
	{
		for (SalesRightsTypes item : values)
			if (item.code.equals(code))
				return item;
		return null;
	}
}
