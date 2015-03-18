package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 79
 * 
 * @author Zach Melamed
 * 
 */
public enum ProductFormFeatureTypes
{
	/**
	 * For Product Form Feature values see code list 98.
	 */
	Color_of_cover("01"),

	/**
	 * For Product Form Feature values see code list 98.
	 */
	Color_of_page_edge("02"),

	/**
	 * The principal font used for body text, when this is a significant aspect of product description, eg for some Bibles, and for large print product. The accompanying Product Form Feature Description is text specifying font size and, if desired, typeface.
	 */
	Text_font("03"),

	/**
	 * For Product Form Feature values see code list 99.
	 */
	Special_cover_material("04"),

	/**
	 * For Product Form Feature values see code list 76.
	 */
	DVD_region("05"),

	/**
	 * A computer or handheld device operating system required to use a digital product, with version detail if applicable. The accompanying Product Form Feature Value is a code from List 176. Version detail, when applicable, is carried in Product Form Feature Description.
	 */
	Operating_system_requirements("06"),

	/**
	 * Other system requirements for a digital product, described by free text in Product Form Feature Description.
	 */
	Other_system_requirements("07"),

	/**
	 * Indicates compatibility with proprietary ‘point and listen’ devices such as Ting Pen (http://www.ting.eu) or the iSmart Touch and Read Pen. These devices scan invisible codes specially printed on the page to identify the book and position of the word, and the word is then read aloud by the device. The name of the compatible device (or range of devices) should be given in <ProductFormFeatureDescription>.
	 */
	_Point_and_listen_device_compatibility("08"),

	/**
	 * For <ProductFormFeatureValue> codes, see Codelist 196.
	 */
	Epublication_accessibility_detail("09"),

	/**
	 * For versioned e-book file format (or in some cases, device) – for example EPUB 2 and EPUB 3. <ProductFormFeatureValue> should contain the version number. Use only with ONIX 3.0 – in ONIX 2.1, use <EpubTypeVersion> instead.
	 */
	Epublication_format_version("10"),

	/**
	 * DEPRECATED – use code 12 and List 143.
	 */
	CPSIA_choking_hazard_warning("11"),

	/**
	 * Choking hazard warning required by US Consumer Product Safety Improvement Act (CPSIA) of 2008. Required, when applicable, for products sold in the US. The Product Form Feature Value is a code from List 143. Further explanation may be given in Product Form Feature Description.
	 */
	CPSIA_choking_hazard_warning_("12"),

	/**
	 * Product carries hazard warning required by EU Toy Safety Directive. The Product Form Feature value is a code from List 184, and (for some codes) the exact wording of the warning may be given in Product Form Feature Description.
	 */
	EU_Toy_Safety_Hazard_Warning("13"),

	/**
	 * Product does not carry FSC or PEFC logo. The Product Form Feature Value and Description elements are not used. The product may, however, still carry a claimed Pre- and Post-Consumer Waste (PCW) content (type code 37) in a separate repeat of the Product Form Feature composite.
	 */
	Not_FSC_or_PEFC_certified("30"),

	/**
	 * Product carries FSC logo (Pure, 100%). <ProductFormFeatureValue> is the Certification number (ie either a Chain Of Custody (COC) number or a Trademark License number) printed on the book. Format: Chain of Custody number is two to five letters-COC-six digits (the digits should include leading zeros if necessary), eg “AB-COC-001234” or “ABCDE-COC-123456”; Trademark License number is C followed by six digits, eg “C005678” (this would normally be prefixed by ‘FSC®’ when displayed). By definition, a product certified Pure does not contain Pre- and Post-Consumer-Waste (PCW), so type code 31 can only occur on its own. Certification numbers may be checked at ‘http://info.fsc.org/’.
	 */
	FSC_certified___pure("31"),

	/**
	 * Product carries FSC logo (Mixed sources, Mix). <ProductFormFeatureValue> is the Certification number (ie either a Chain Of Custody (COC) number or a Trademark License number) printed on the book. Format: Chain of Custody number is two to five letters-COC-six digits (the digits should include leading zeros if necessary), eg “AB-COC-001234” or “ABCDE-COC-123456”; Trademark License number is C followed by six digits, eg “C005678” (this would normally be prefixed by ‘FSC®’ when displayed). May be accompanied by a Pre- and Post-Consumer-Waste (PCW) percentage value, to be reported in another instance of <ProductFormFeature> with type code 36. Certification numbers may be checked at http://info.fsc.org/
	 */
	FSC_certified___mixed_sources("32"),

	/**
	 * Product carries FSC logo (Recycled). <ProductFormFeatureValue> is the Certification number (ie either a Chain Of Custody (COC) number or a Trademark License number) printed on the book. Format: Chain of Custody number is two to five letters-COC-six digits (the digits should include leading zeroes if necessary), eg “AB-COC-001234” or “ABCDE-COC-123456”; Trademark License number is C followed by six digits, eg “C005678” (this would normally be prefixed by ‘FSC®’ when displayed). Should be accompanied by a Pre- and Post-Consumer-Waste (PCW) percentage value, to be reported in another instance of <ProductFormFeature> with type code 36. Certification numbers may be checked at‘ http://info.fsc.org/’.
	 */
	FSC_certified___recycled("33"),

	/**
	 * Product carries PEFC logo (certified). <ProductFormFeatureValue> is the Chain Of Custody (COC) number printed on the book. May be accompanied by a Post-Consumer Waste (PCW) percentage value, to be reported in another instance of <ProductFormFeature> with type code 36.
	 */
	PEFC_certified("34"),

	/**
	 * Product carries PEFC logo (recycled). <ProductFormFeatureValue> is the Chain Of Custody (COC) number printed on the book. Should be accompanied by a Post-Consumer-Waste (PCW) percentage value, to be reported in another instance of <ProductFormFeature> with type code 36.
	 */
	PEFC_recycled("35"),

	/**
	 * The percentage of recycled Pre- and Post-Consumer-Waste (PCW) used in a product where the composition is certified by FSC or PEFC. <ProductFormFeatureValue> is an integer. May occur together with type code 32, 33, 34 or 35.
	 */
	FSC_or_PEFC_certified_Pre_and_PostConsumer_Waste_PCW_percentage("36"),

	/**
	 * The percentage of recycled Pre- and Post-Consumer Waste (PCW) claimed to be used in a product where the composition is not certified by FSC or PEFC. <Product FormFeatureValue> is an integer. <ProductFormFeatureDescription> may carry free text supporting the claim. Must be accompanied by type code 30.
	 */
	Claimed_Pre_and_PostConsumer_Waste_PCW_percentage("37"),

	/**
	 * Product made from paper produced using environmentally-conscious technology. <ProductFormFeatureDescription> may carry free text with a more detailed statement.
	 */
	Paper_produced_by__green_technology("40");

	public final String code;

	private ProductFormFeatureTypes(String code)
	{
		this.code = code;
	}

	private static ProductFormFeatureTypes[] values = ProductFormFeatureTypes.values();
	public static ProductFormFeatureTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ProductFormFeatureTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

