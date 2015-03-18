package com.tectonica.jonix.codelists;

/**
 * List 54
 * 
 * @author Zach Melamed
 *
 */
public enum Availabilities
{
	Cancelled("AB"),

	Available_direct_from_publisher_only("AD"),

	Availability_uncertain("CS"),

	No_longer_stocked_by_us("EX"),

	Available("IP"),

	Manufactured_on_demand("MD"),

	Not_yet_published("NP"),

	Newly_catalogued_not_yet_in_stock("NY"),

	Other_format_available("OF"),

	Out_of_stock_indefinitely("OI"),

	Out_of_print("OP"),

	Replaced_by_new_edition("OR"),

	Publication_postponed_indefinitely("PP"),

	Refer_to_another_supplier("RF"),

	Remaindered("RM"),

	Reprinting("RP"),

	Reprinting_undated("RU"),

	Special_order("TO"),

	Temporarily_out_of_stock_because_publisher_cannot_supply("TP"),

	Temporarily_unavailable("TU"),

	Unavailable_awaiting_reissue("UR"),

	Will_be_remaindered_as_of_given_date("WR"),

	Withdrawn_from_sale("WS");

	public final String code;

	private Availabilities(String code)
	{
		this.code = code;
	}

	private static Availabilities[] values = Availabilities.values();

	public static Availabilities fromCode(String code)
	{
		for (Availabilities item : values)
			if (item.code.equals(code))
				return item;
		return null;
	}
}
