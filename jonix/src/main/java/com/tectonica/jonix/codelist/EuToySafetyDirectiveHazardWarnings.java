package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 184
 * 
 * @author Zach Melamed
 * 
 */
public enum EuToySafetyDirectiveHazardWarnings
{
	/**
	 * Use to provide positive indication that no warnings are applicable.
	 */
	No_warning("00"),

	Carries__CE_logo("01"),

	/**
	 * Use to specify age (in years, or years and months). Provide specific wording in <ProductFormFeatureDescription>.
	 */
	Carries_minimum_age_warning("02"),

	/**
	 * Carries logo, and must be accompanied by the default warning ‘Not suitable for children under 36 months’ (or its approved equivalent in a language other than English, as appropriate), unless specific wording is provided in <ProductFormFeatureDescription>. If specific alternative wording is carried in <ProductFormFeatureDescription>, this must be used in place of the default text.
	 */
	Carries_EU_Toy_Safety_Directive__Unsuitable_for_children_ages_0_3_warning_logo("03"),

	/**
	 * Exact text of warning must be included in <ProductFormFeatureDescription>.
	 */
	Carries_EU_Toy_Safety_Directive_hazard_warning("04"),

	/**
	 * Exact text (not in itself a warning) must be included in <ProductFormFeatureDescription>. May be used either without any warning, or as text additional to a warning. Note that if no warnings apply, code 00 can provide positive indication of this. Example use: “Suitable for all ages”.
	 */
	Carries_other_text_associated_with_toy_safety("05"),

	/**
	 * Material Safety Data Sheet (a document required by the EU Toy Safety Directive) available online, typically as a PDF file or similar. <ProductFormFeatureDescription> must carry the URL of the document.
	 */
	Material_Safety_Data_Sheet_available("06"),

	/**
	 * Declaration of Conformity (the document that backs up the CE mark) available online, typically as a PDF file or similar. <ProductFormFeatureDescription> must carry the URL of the document.
	 */
	Declaration_of_Conformity_available("07");

	public final String code;

	private EuToySafetyDirectiveHazardWarnings(String code)
	{
		this.code = code;
	}

	private static EuToySafetyDirectiveHazardWarnings[] values = EuToySafetyDirectiveHazardWarnings.values();
	public static EuToySafetyDirectiveHazardWarnings fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (EuToySafetyDirectiveHazardWarnings item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

