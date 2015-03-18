package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 54
 * 
 * @author Zach Melamed
 * 
 */
public enum AvailabilityStatuses
{
	/**
	 * Publication abandoned after having been announced.
	 */
	Cancelled("AB"),

	/**
	 * Apply direct to publisher, item not available to trade.
	 */
	Available_direct_from_publisher_only("AD"),

	/**
	 * Check with customer service.
	 */
	Availability_uncertain("CS"),

	/**
	 * Wholesaler or vendor only.
	 */
	No_longer_stocked_by_us("EX"),

	/**
	 * In-print and in stock.
	 */
	Available("IP"),

	/**
	 * May be accompanied by an estimated average time to supply.
	 */
	Manufactured_on_demand("MD"),

	/**
	 * MUST be accompanied by an expected availability date.
	 */
	Not_yet_published("NP"),

	/**
	 * Wholesaler or vendor only: MUST be accompanied by expected availability date.
	 */
	Newly_catalogued__not_yet_in_stock("NY"),

	/**
	 * This format is out of print, but another format is available: should be accompanied by an identifier for the alternative product.
	 */
	Other_format_available("OF"),

	/**
	 * No current plan to reprint.
	 */
	Out_of_stock_indefinitely("OI"),

	/**
	 * Discontinued, deleted from catalogue.
	 */
	Out_of_print("OP"),

	/**
	 * This edition is out of print, but a new edition has been or will soon be published: should be accompanied by an identifier for the new edition.
	 */
	Replaced_by_new_edition("OR"),

	/**
	 * Publication has been announced, and subsequently postponed with no new date.
	 */
	Publication_postponed_indefinitely("PP"),

	/**
	 * Supply of this item has been transferred to another publisher or distributor: should be accompanied by an identifier for the new supplier.
	 */
	Refer_to_another_supplier("RF"),

	Remaindered("RM"),

	/**
	 * MUST be accompanied by an expected availability date.
	 */
	Reprinting("RP"),

	/**
	 * Use instead of RP as a last resort, only if it is really impossible to give an expected availability date.
	 */
	Reprinting__undated("RU"),

	/**
	 * This item is not stocked but has to be specially ordered from a supplier (eg import item not stocked locally): may be accompanied by an estimated average time to supply.
	 */
	Special_order("TO"),

	/**
	 * Wholesaler or vendor only.
	 */
	Temporarily_out_of_stock_because_publisher_cannot_supply("TP"),

	/**
	 * MUST be accompanied by an expected availability date.
	 */
	Temporarily_unavailable("TU"),

	/**
	 * The item is out of stock but will be reissued under the same ISBN: MUST be accompanied by an expected availability date and by the reissue date in the <Reissue> composite. See notes on the <Reissue> composite for details on treatment of availability status during reissue.
	 */
	Unavailable__awaiting_reissue("UR"),

	/**
	 * MUST be accompanied by the remainder date.
	 */
	Will_be_remaindered_as_of_date("WR"),

	/**
	 * Typically, withdrawn indefinitely for legal reasons.
	 */
	Withdrawn_from_sale("WS");

	public final String code;

	private AvailabilityStatuses(String code)
	{
		this.code = code;
	}

	private static AvailabilityStatuses[] values = AvailabilityStatuses.values();
	public static AvailabilityStatuses fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (AvailabilityStatuses item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

