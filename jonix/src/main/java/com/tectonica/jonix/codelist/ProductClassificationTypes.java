package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 9
 * 
 * @author Zach Melamed
 * 
 */
public enum ProductClassificationTypes
{
	/**
	 * World Customs Organization Harmonized Commodity Coding and Description System.
	 */
	WCO_Harmonized_System("01"),

	/**
	 * UN Standard Product and Service Classification.
	 */
	UNSPSC("02"),

	/**
	 * UK Revenue and Customs classifications, based on the Harmonized System.
	 */
	HMRC("03"),

	/**
	 * German export trade classification, based on the Harmonised System.
	 */
	Warenverzeichnis_f_r_die_Au_enhandelsstatistik("04"),

	/**
	 * EU TARIC codes, an extended version of the Harmonized System.
	 */
	TARIC("05"),

	/**
	 * Centraal Boekhuis free classification field for publishers.
	 */
	Fondsgroep("06"),

	/**
	 * A product category (not a subject classification) assigned by the sender.
	 */
	Senders_product_category("07"),

	/**
	 * Product classification maintained by the Chinese General Administration of Press and Publication (http://www.gapp.gov.cn).
	 */
	GAPP_Product_Class("08"),

	/**
	 * Statistical Classification of Products by Activity in the European Economic Community, see http://ec.europa.eu/eurostat/ramon/nomenclatures/index.cfm?TargetUrl=LST_NOM_DTL&StrNom=CPA_2008. Up to six digits, with one or two periods. For example, printed children’s books are “58.11.13”.
	 */
	CPA("09");

	public final String code;

	private ProductClassificationTypes(String code)
	{
		this.code = code;
	}

	private static ProductClassificationTypes[] values = ProductClassificationTypes.values();
	public static ProductClassificationTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ProductClassificationTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

