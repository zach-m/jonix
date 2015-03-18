package com.tectonica.jonix.codelists;

/**
 * List 58
 * 
 * @author Zach Melamed
 *
 */
public enum PriceTypes
{
	RRP_excluding_tax("01"),

	RRP_including_tax("02"),

	Fixed_retail_price_excluding_tax("03"),

	Fixed_retail_price_including_tax("04"),

	Suppliers_net_price_excluding_tax("05"),

	Suppliers_net_price_excluding_tax_rental_goods("06"),

	Suppliers_net_price_including_tax("07"),

	Suppliers_alternative_net_price_excluding_tax("08"),

	Suppliers_alternative_net_price_including_tax("09"),

	Special_sale_RRP_excluding_tax("11"),

	Special_sale_RRP_including_tax("12"),

	Special_sale_fixed_retail_price_excluding_tax("13"),

	Special_sale_fixed_retail_price_including_tax("14"),

	Suppliers_net_price_for_special_sale_excluding_tax("15"),

	Suppliers_net_price_for_special_sale_including_tax("17"),

	Pre_publication_RRP_excluding_tax("21"),

	Pre_publication_RRP_including_tax("22"),

	Pre_publication_fixed_retail_price_excluding_tax("23"),

	Pre_publication_fixed_retail_price_including_tax("24"),

	Suppliers_pre_publication_net_price_excluding_tax("25"),

	Suppliers_pre_publication_net_price_including_tax("27"),

	Freight_pass_through_RRP_excluding_tax("31"),

	Freight_pass_through_billing_price_excluding_tax("32"),

	Publishers_retail_price_excluding_tax("41"),

	Publishers_retail_price_including_tax("42");

	public final String code;

	private PriceTypes(String code)
	{
		this.code = code;
	}

	private static PriceTypes[] values = PriceTypes.values();

	public static PriceTypes fromCode(String code)
	{
		for (PriceTypes item : values)
			if (item.code.equals(code))
				return item;
		return null;
	}
}
