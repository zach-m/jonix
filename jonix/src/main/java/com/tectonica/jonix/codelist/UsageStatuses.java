package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 146
 * 
 * @author Zach Melamed
 * 
 */
public enum UsageStatuses
{
	Permitted_unlimited("01"),

	/**
	 * Limit should be specified in <EpubUsageLimit>.
	 */
	Permitted_subject_to_limit("02"),

	Prohibited("03");

	public final String code;

	private UsageStatuses(String code)
	{
		this.code = code;
	}

	private static UsageStatuses[] values = UsageStatuses.values();
	public static UsageStatuses fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (UsageStatuses item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

