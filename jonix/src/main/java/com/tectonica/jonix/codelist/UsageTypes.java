package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 145
 * 
 * @author Zach Melamed
 * 
 */
public enum UsageTypes
{
	/**
	 * Preview before purchase.
	 */
	Preview("01"),

	/**
	 * Print paper copy of extract.
	 */
	Print("02"),

	/**
	 * Make digital copy of extract.
	 */
	Copy___paste("03"),

	/**
	 * Share product across multiple concurrent devices.
	 */
	Share("04"),

	/**
	 * ‘Read aloud’ with text to speech functionality.
	 */
	Text_to_speech("05"),

	/**
	 * Lendable to other device owner or account holder, eg ‘Lend-to-a-friend’, library lending. The ‘primary’ copy becomes unusable while the secondary copy is ‘on loan’ unless a number of concurrent borrowers is also specified).
	 */
	Lend("06"),

	/**
	 * E-publication license is time limited. Use with 02 from List 146 and a number of days in <EpubUsageLimit>.
	 */
	Timelimited_license("07");

	public final String code;

	private UsageTypes(String code)
	{
		this.code = code;
	}

	private static UsageTypes[] values = UsageTypes.values();
	public static UsageTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (UsageTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

