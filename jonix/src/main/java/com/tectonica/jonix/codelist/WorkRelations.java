package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 164
 * 
 * @author Zach Melamed
 * 
 */
public enum WorkRelations
{
	/**
	 * Product X is or includes a manifestation of work Y.
	 */
	Manifestation_of("01"),

	/**
	 * Product X is or includes a manifestation of a work derived from related work Y in one or more of the ways specified in ISTC rules. This relation type is intended to enable products with a common ‘parent’ work to be linked without specifying the precise nature of their derivation.
	 */
	Derived_from("02"),

	/**
	 * Product X is a manifestation of a work from which related work Y is derived in one or more of the ways specified in ISTC rules (reciprocal of code 02).
	 */
	Related_work_is_derived_from_this("03"),

	/**
	 * Product X is a manifestation of a work in the same collection as related work Y.
	 */
	Other_work_in_same_collection("04"),

	/**
	 * Product X is a manifestation of a work by the same contributor(s) as related work Y.
	 */
	Other_work_by_same_contributor("05");

	public final String code;

	private WorkRelations(String code)
	{
		this.code = code;
	}

	private static WorkRelations[] values = WorkRelations.values();
	public static WorkRelations fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (WorkRelations item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

