package com.tectonica.jonix.codelists;

/**
 * List 29
 * 
 * @author Zach Melamed
 *
 */
public enum AudienceCodeTypes
{
	ONIX_audience_codes("01"),
	
	Proprietary("02"),
	
	MPAA_rating("03"),
	
	BBFC_rating("04"),
	
	FSK_rating("05"),
	
	BTLF_audience_code("06"),
	
	Electre_audience_code("07"),
	
	ANELE_Tipo("08"),
	
	AVI("09"),
	
	USK_rating("10"),
	
	AWS("11"),
	
	Schulform("12"),
	
	Bundesland("13"),
	
	Ausbildungsberuf("14"),
	
	Suomalainen_kouluasteluokitus("15"),
	
	CBG_age_guidance("16"),
	
	Nielsen_Book_audience_code("17"),
	
	AVI_revised("18"),
	
	Lexile_measure("19"),
	
	Fry_Readability_score("20"),
	
	Japanese_Childrens_audience_code("21"),
	
	ONIX_Adult_audience_rating("22");
	
	public final String code;

	private AudienceCodeTypes(String code)
	{
		this.code = code;
	}

	private static AudienceCodeTypes[] values = AudienceCodeTypes.values();

	public static AudienceCodeTypes fromCode(String code)
	{
		for (AudienceCodeTypes item : values)
			if (item.code.equals(code))
				return item;
		return null;
	}

}
