package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 98
 * 
 * @author Zach Melamed
 * 
 */
public enum ProductFormFeatureValueBindingOrPageEdgeColors
{
	Black("BLK"),

	Blue("BLU"),

	Brown("BRN"),

	Burgundy_maroon("BUR"),

	Cream("CRE"),

	Fourcolor("FCO"),

	Fourcolor_and_spotcolor("FCS"),

	Gold("GLD"),

	Green("GRN"),

	Grey("GRY"),

	/**
	 * Use <ProductFormFeatureDescription> to add brief details if required.
	 */
	Multicolor("MUL"),

	Navy_Dark_blue("NAV"),

	Orange("ORG"),

	Pink("PNK"),

	Purple("PUR"),

	Red("RED"),

	Silver("SLV"),

	Tan("TAN"),

	White("WHI"),

	Yellow("YEL"),

	Other("ZZZ");

	public final String code;

	private ProductFormFeatureValueBindingOrPageEdgeColors(String code)
	{
		this.code = code;
	}

	private static ProductFormFeatureValueBindingOrPageEdgeColors[] values = ProductFormFeatureValueBindingOrPageEdgeColors.values();
	public static ProductFormFeatureValueBindingOrPageEdgeColors fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ProductFormFeatureValueBindingOrPageEdgeColors item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

