package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 143
 * 
 * @author Zach Melamed
 * 
 */
public enum UsCpsiaChokingHazardWarnings
{
	/**
	 * Required on applicable products sold in the US.
	 */
	WARNING__CHOKING_HAZARD___Small_parts___Not_for_children_under_3_yrs_("01"),

	/**
	 * Required on applicable products sold in the US.
	 */
	WARNING__CHOKING_HAZARD___Children_under_8_yrs__can_choke_or_suffocate_on_uninflated_or_broken_balloons__Adult_supervision_required___Keep_uninflated_balloons_from_children__Discard_broken_balloons_at_once_("02"),

	/**
	 * Required on applicable products sold in the US.
	 */
	WARNING__CHOKING_HAZARD___This_toy_is_a_small_ball___Not_for_children_under_3_yrs_("03"),

	/**
	 * Required on applicable products sold in the US.
	 */
	WARNING__CHOKING_HAZARD___Toy_contains_a_small_ball___Not_for_children_under_3_yrs_("04"),

	/**
	 * Required on applicable products sold in the US.
	 */
	WARNING__CHOKING_HAZARD___This_toy_is_a_marble___Not_for_children_under_3_yrs_("05"),

	/**
	 * Required on applicable products sold in the US.
	 */
	WARNING__CHOKING_HAZARD___Toy_contains_a_marble___Not_for_children_under_3_yrs_("06"),

	/**
	 * To be used when a supplier wishes to make a clear statement that no such warning is applicable to product.
	 */
	No_choking_hazard_warning_necessary("07");

	public final String code;

	private UsCpsiaChokingHazardWarnings(String code)
	{
		this.code = code;
	}

	private static UsCpsiaChokingHazardWarnings[] values = UsCpsiaChokingHazardWarnings.values();
	public static UsCpsiaChokingHazardWarnings fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (UsCpsiaChokingHazardWarnings item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

