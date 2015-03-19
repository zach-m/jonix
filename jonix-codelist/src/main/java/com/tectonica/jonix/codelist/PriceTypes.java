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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * Price type code
 */
public enum PriceTypes
{
	/**
	 * RRP excluding any sales tax or value-added tax.
	 */
	RRP_excluding_tax("01"), //

	/**
	 * RRP including sales or value-added tax if applicable.
	 */
	RRP_including_tax("02"), //

	/**
	 * In countries where retail price maintenance applies by law to certain products: not used in USA.
	 */
	Fixed_retail_price_excluding_tax("03"), //

	/**
	 * In countries where retail price maintenance applies by law to certain products: not used in USA.
	 */
	Fixed_retail_price_including_tax("04"), //

	/**
	 * Unit price charged by supplier to reseller excluding any sales tax or value-added tax: goods for retail sale.
	 */
	Supplier_s_net_price_excluding_tax("05"), //

	/**
	 * Unit price charged by supplier to reseller / rental outlet, excluding any sales tax or value-added tax: goods for rental (used for
	 * video and DVD).
	 */
	Supplier_s_net_price_excluding_tax_rental_goods("06"), //

	/**
	 * Unit price charged by supplier to reseller including any sales tax or value-added tax if applicable: goods for retail sale.
	 */
	Supplier_s_net_price_including_tax("07"), //

	/**
	 * Unit price charged by supplier to a specified class of reseller excluding any sales tax or value-added tax: goods for retail sale
	 * (this value is for use only in countries, eg Finland, where trade practice requires two different net prices to be listed for
	 * different classes of resellers, and where national guidelines specify how the code should be used).
	 */
	Supplier_s_alternative_net_price_excluding_tax("08"), //

	/**
	 * Unit price charged by supplier to a specified class of reseller including any sales tax or value-added tax: goods for retail sale
	 * (this value is for use only in countries, eg Finland, where trade practice requires two different net prices to be listed for
	 * different classes of resellers, and where national guidelines specify how the code should be used).
	 */
	Supplier_s_alternative_net_price_including_tax("09"), //

	/**
	 * Special sale RRP excluding any sales tax or value-added tax. Note ‘special sales’ are sales where terms and conditions are different
	 * from normal trade sales, when for example products that are normally sold on a sale-or-return basis are sold on firm-sale terms,
	 * where a particular product is tailored for a specific retail outlet (often termed a ‘premium’ product), or where other specific
	 * conditions or qualiifications apply. Further details of the modified terms and conditions should be given in <PriceTypeDescription>.
	 */
	Special_sale_RRP_excluding_tax("11"), //

	/**
	 * Special sale RRP including sales or value-added tax if applicable.
	 */
	Special_sale_RRP_including_tax("12"), //

	/**
	 * In countries where retail price maintenance applies by law to certain products: not used in USA.
	 */
	Special_sale_fixed_retail_price_excluding_tax("13"), //

	/**
	 * In countries where retail price maintenance applies by law to certain products: not used in USA.
	 */
	Special_sale_fixed_retail_price_including_tax("14"), //

	/**
	 * Unit price charged by supplier to reseller for special sale excluding any sales tax or value-added tax.
	 */
	Supplier_s_net_price_for_special_sale_excluding_tax("15"), //

	/**
	 * Unit price charged by supplier to reseller for special sale including any sales tax or value-added tax.
	 */
	Supplier_s_net_price_for_special_sale_including_tax("17"), //

	/**
	 * Pre-publication RRP excluding any sales tax or value-added tax. Use where RRP for pre-orders is different from post-publication RRP.
	 */
	Pre_publication_RRP_excluding_tax("21"), //

	/**
	 * Pre-publication RRP including sales or value-added tax if applicable. Use where RRP for pre-orders is different from post-publication
	 * RRP.
	 */
	Pre_publication_RRP_including_tax("22"), //

	/**
	 * In countries where retail price maintenance applies by law to certain products: not used in USA.
	 */
	Pre_publication_fixed_retail_price_excluding_tax("23"), //

	/**
	 * In countries where retail price maintenance applies by law to certain products: not used in USA.
	 */
	Pre_publication_fixed_retail_price_including_tax("24"), //

	/**
	 * Unit price charged by supplier to reseller pre-publication excluding any sales tax or value-added tax.
	 */
	Supplier_s_pre_publication_net_price_excluding_tax("25"), //

	/**
	 * Unit price charged by supplier to reseller pre-publication including any sales tax or value-added tax.
	 */
	Supplier_s_pre_publication_net_price_including_tax("27"), //

	/**
	 * In the US, books are sometimes supplied on ‘freight-pass-through’ terms, where a price that is different from the RRP is used as the
	 * basis for calculating the supplier’s charge to a reseller. To make it clear when such terms are being invoked, code 31 is used
	 * instead of code 01 to indicate the RRP. Code 32 is used for the ‘billing price’.
	 */
	Freight_pass_through_RRP_excluding_tax("31"), //

	/**
	 * When freight-pass-through terms apply, the price on which the supplier’s charge to a reseller is calculated, ie the price to which
	 * trade discount terms are applied. See also code 31.
	 */
	Freight_pass_through_billing_price_excluding_tax("32"), //

	/**
	 * In countries where retail price maintenance applies by law to certain products, but the price is set by the importer or local sales
	 * agent, not the foreign publisher. In France, ‘prix catalogue éditeur étranger’.
	 * <p>
	 * NOTE: Introduced in Onix3
	 */
	Importer_s_Fixed_retail_price_excluding_tax("33"), //

	/**
	 * In countries where retail price maintenance applies by law to certain products, but the price is set by the importer or local sales
	 * agent, not the foreign publisher. In France, ‘prix catalogue éditeur étranger’.
	 * <p>
	 * NOTE: Introduced in Onix3
	 */
	Importer_s_Fixed_retail_price_including_tax("34"), //

	/**
	 * For a product supplied on agency terms, the retail price set by the publisher, excluding any sales tax or value-added tax.
	 */
	Publishers_retail_price_excluding_tax("41"), //

	/**
	 * For a product supplied on agency terms, the retail price set by the publisher, including sales or value-added tax if applicable.
	 */
	Publishers_retail_price_including_tax("42");

	public final String value;

	private PriceTypes(String value)
	{
		this.value = value;
	}

	private static Map<String, PriceTypes> map;

	private static Map<String, PriceTypes> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (PriceTypes e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static PriceTypes byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
