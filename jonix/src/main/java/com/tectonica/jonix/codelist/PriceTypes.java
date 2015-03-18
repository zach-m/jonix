package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 58
 * 
 * @author Zach Melamed
 * 
 */
public enum PriceTypes
{
	/**
	 * RRP excluding any sales tax or value-added tax.
	 */
	RRP_excluding_tax("01"),

	/**
	 * RRP including sales or value-added tax if applicable.
	 */
	RRP_including_tax("02"),

	/**
	 * In countries where retail price maintenance applies by law to certain products: not used in USA.
	 */
	Fixed_retail_price_excluding_tax("03"),

	/**
	 * In countries where retail price maintenance applies by law to certain products: not used in USA.
	 */
	Fixed_retail_price_including_tax("04"),

	/**
	 * Unit price charged by supplier to reseller excluding any sales tax or value-added tax: goods for retail sale.
	 */
	Suppliers_net_price_excluding_tax("05"),

	/**
	 * Unit price charged by supplier to reseller / rental outlet, excluding any sales tax or value-added tax: goods for rental (used for video and DVD).
	 */
	Suppliers_net_price_excluding_tax__rental_goods("06"),

	/**
	 * Unit price charged by supplier to reseller including any sales tax or value-added tax if applicable: goods for retail sale.
	 */
	Suppliers_net_price_including_tax("07"),

	/**
	 * Unit price charged by supplier to a specified class of reseller excluding any sales tax or value-added tax: goods for retail sale (this value is for use only in countries, eg Finland, where trade practice requires two different net prices to be listed for different classes of resellers, and where national guidelines specify how the code should be used).
	 */
	Suppliers_alternative_net_price_excluding_tax("08"),

	/**
	 * Unit price charged by supplier to a specified class of reseller including any sales tax or value-added tax: goods for retail sale (this value is for use only in countries, eg Finland, where trade practice requires two different net prices to be listed for different classes of resellers, and where national guidelines specify how the code should be used).
	 */
	Suppliers_alternative_net_price_including_tax("09"),

	/**
	 * Special sale RRP excluding any sales tax or value-added tax. Note ‘special sales’ are sales where terms and conditions are different from normal trade sales, when for example products that are normally sold on a sale-or-return basis are sold on firm-sale terms, or where a particular product is tailored for a specific retail outlet (often termed a ‘premium’ product). Further details of the modified terms and conditioins should be given in <PriceTypeDescription>.
	 */
	Special_sale_RRP_excluding_tax("11"),

	/**
	 * Special sale RRP including sales or value-added tax if applicable.
	 */
	Special_sale_RRP_including_tax("12"),

	/**
	 * In countries where retail price maintenance applies by law to certain products: not used in USA.
	 */
	Special_sale_fixed_retail_price_excluding_tax("13"),

	/**
	 * In countries where retail price maintenance applies by law to certain products: not used in USA.
	 */
	Special_sale_fixed_retail_price_including_tax("14"),

	/**
	 * Unit price charged by supplier to reseller for special sale excluding any sales tax or value-added tax.
	 */
	Suppliers_net_price_for_special_sale_excluding_tax("15"),

	/**
	 * Unit price charged by supplier to reseller for special sale including any sales tax or value-added tax.
	 */
	Suppliers_net_price_for_special_sale_including_tax("17"),

	/**
	 * Pre-publication RRP excluding any sales tax or value-added tax.
	 */
	Prepublication_RRP_excluding_tax("21"),

	/**
	 * Pre-publication RRP including sales or value-added tax if applicable.
	 */
	Prepublication_RRP_including_tax("22"),

	/**
	 * In countries where retail price maintenance applies by law to certain products: not used in USA.
	 */
	Prepublication_fixed_retail_price_excluding_tax("23"),

	/**
	 * In countries where retail price maintenance applies by law to certain products: not used in USA.
	 */
	Prepublication_fixed_retail_price_including_tax("24"),

	/**
	 * Unit price charged by supplier to reseller pre-publication excluding any sales tax or value-added tax.
	 */
	Suppliers_prepublication_net_price_excluding_tax("25"),

	/**
	 * Unit price charged by supplier to reseller pre-publication including any sales tax or value-added tax.
	 */
	Suppliers_prepublication_net_price_including_tax("27"),

	/**
	 * In the US, books are sometimes supplied on ‘freight-pass-through’ terms, where a price that is different from the RRP is used as the basis for calculating the supplier’s charge to a reseller. To make it clear when such terms are being invoked, code 31 is used instead of code 01 to indicate the RRP. Code 32 is used for the ‘billing price’.
	 */
	Freightpassthrough_RRP_excluding_tax("31"),

	/**
	 * When freight-pass-through terms apply, the price on which the supplier’s charge to a reseller is calculated, ie the price to which trade discount terms are applied. See also code 31.
	 */
	Freightpassthrough_billing_price_excluding_tax("32"),

	/**
	 * For a product supplied on agency terms, the retail price set by the publisher, excluding any sales tax or value-added tax.
	 */
	Publishers_retail_price_excluding_tax("41"),

	/**
	 * For a product supplied on agency terms, the retail price set by the publisher, including sales or value-added tax if applicable.
	 */
	Publishers_retail_price_including_tax("42");

	public final String code;

	private PriceTypes(String code)
	{
		this.code = code;
	}

	private static PriceTypes[] values = PriceTypes.values();
	public static PriceTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (PriceTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

