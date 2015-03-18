package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 49
 * 
 * @author Zach Melamed
 * 
 */
public enum Regions
{
	Australian_Capital_Territory("AU-CT"),

	New_South_Wales("AU-NS"),

	Northern_Territory("AU-NT"),

	Queensland("AU-QL"),

	South_Australia("AU-SA"),

	Tasmania("AU-TS"),

	Victoria("AU-VI"),

	Western_Australia("AU-WA"),

	Alberta("CA-AB"),

	British_Columbia("CA-BC"),

	Manitoba("CA-MB"),

	New_Brunswick("CA-NB"),

	Newfoundland_and_Labrador("CA-NL"),

	Nova_Scotia("CA-NS"),

	Northwest_Territories("CA-NT"),

	Nunavut("CA-NU"),

	Ontario("CA-ON"),

	Prince_Edward_Island("CA-PE"),

	Quebec("CA-QC"),

	Saskatchewan("CA-SK"),

	Yukon_Territory("CA-YT"),

	Canary_Islands("ES-CN"),

	/**
	 * Airside outlets at UK international airports only.
	 */
	UK_airside("GB-AIR"),

	/**
	 * All UK airports, including both airside and other outlets.
	 */
	UK_airports("GB-APS"),

	/**
	 * DEPRECATED, replaced by country codes GG – Guernsey, and JE – Jersey.
	 */
	Channel_Islands("GB-CHA"),

	England("GB-ENG"),

	/**
	 * UK excluding Northern Ireland.
	 */
	England__Wales__Scotland("GB-EWS"),

	/**
	 * DEPRECATED, replaced by country code IM – Isle of Man.
	 */
	Isle_of_Man("GB-IOM"),

	Northern_Ireland("GB-NIR"),

	Scotland("GB-SCT"),

	Wales("GB-WLS"),

	Alaska("US-AK"),

	Alabama("US-AL"),

	Arkansas("US-AR"),

	Arizona("US-AZ"),

	California("US-CA"),

	Colorado("US-CO"),

	Connecticut("US-CT"),

	District_of_Columbia("US-DC"),

	Delaware("US-DE"),

	Florida("US-FL"),

	Georgia("US-GA"),

	Hawaii("US-HI"),

	Iowa("US-IA"),

	Idaho("US-ID"),

	Illinois("US-IL"),

	Indiana("US-IN"),

	Kansas("US-KS"),

	Kentucky("US-KY"),

	Louisiana("US-LA"),

	Massachusetts("US-MA"),

	Maryland("US-MD"),

	Maine("US-ME"),

	Michigan("US-MI"),

	Minnesota("US-MN"),

	Missouri("US-MO"),

	Mississippi("US-MS"),

	Montana("US-MT"),

	North_Carolina("US-NC"),

	North_Dakota("US-ND"),

	Nebraska("US-NE"),

	New_Hampshire("US-NH"),

	New_Jersey("US-NJ"),

	New_Mexico("US-NM"),

	Nevada("US-NV"),

	New_York("US-NY"),

	Ohio("US-OH"),

	Oklahoma("US-OK"),

	Oregon("US-OR"),

	Pennsylvania("US-PA"),

	Rhode_Island("US-RI"),

	South_Carolina("US-SC"),

	South_Dakota("US-SD"),

	Tennessee("US-TN"),

	Texas("US-TX"),

	Utah("US-UT"),

	Virginia("US-VA"),

	Vermont("US-VT"),

	Washington("US-WA"),

	Wisconsin("US-WI"),

	West_Virginia("US-WV"),

	Wyoming("US-WY"),

	/**
	 * Countries geographically within continental Europe which use the Euro as their sole currency. At the time of writing, this is a synonym for “AT BE CY EE FI FR DE ES GR IE IT LU MT NL PT SI SK” (the official Eurozone 17), plus “AD MC SM VA ME” (other Euro-using countries in continental Europe). Note some other territories using the Euro, but outside continental Europe are excluded from this list, and may need to be specified separately. Only valid in ONIX 3, and only within P.26.
	 */
	Eurozone("ECZ"),

	/**
	 * World except as otherwise specified. NOT USED in ONIX 3.
	 */
	Rest_of_world("ROW"),

	World("WORLD");

	public final String code;

	private Regions(String code)
	{
		this.code = code;
	}

	private static Regions[] values = Regions.values();
	public static Regions fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (Regions item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

