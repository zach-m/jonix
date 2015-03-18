package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 97
 * 
 * @author Zach Melamed
 * 
 */
public enum BibleTextFeatures
{
	/**
	 * Words spoken by Christ are printed in red.
	 */
	Red_letter("RL");

	public final String code;

	private BibleTextFeatures(String code)
	{
		this.code = code;
	}

	private static BibleTextFeatures[] values = BibleTextFeatures.values();
	public static BibleTextFeatures fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (BibleTextFeatures item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

