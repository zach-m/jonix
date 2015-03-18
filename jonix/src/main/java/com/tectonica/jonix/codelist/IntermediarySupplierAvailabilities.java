package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 63
 * 
 * @author Zach Melamed
 * 
 */
public enum IntermediarySupplierAvailabilities
{
;

	public final String code;

	private IntermediarySupplierAvailabilities(String code)
	{
		this.code = code;
	}

	private static IntermediarySupplierAvailabilities[] values = IntermediarySupplierAvailabilities.values();
	public static IntermediarySupplierAvailabilities fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (IntermediarySupplierAvailabilities item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

