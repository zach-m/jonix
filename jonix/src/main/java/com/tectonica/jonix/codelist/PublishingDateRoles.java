package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 163
 * 
 * @author Zach Melamed
 * 
 */
public enum PublishingDateRoles
{
	/**
	 * Nominal date of publication.
	 */
	Publication_date("01"),

	/**
	 * If there is an embargo on retail sales in this market before a certain date, the date from which the embargo is lifted and retail sales are permitted.
	 */
	Embargo_date("02"),

	/**
	 * Date when a new product may be announced to the general public.
	 */
	Public_announcement_date("09"),

	/**
	 * Date when a new product may be announced for trade only.
	 */
	Trade_announcement_date("10"),

	/**
	 * Date when the work incorporated in a product was first published.
	 */
	Date_of_first_publication("11"),

	/**
	 * Date when a product was last reprinted.
	 */
	Last_reprint_date("12"),

	/**
	 * Date when a product was (or will be) declared out-of-print or deleted.
	 */
	Outofprint___deletion_date("13"),

	/**
	 * Date when a product was last reissued.
	 */
	Last_reissue_date("16"),

	/**
	 * Date of publication of a printed book which is the print counterpart to a digital edition.
	 */
	Publication_date_of_print_counterpart("19"),

	/**
	 * Year when the original language version of work incorporated in a product was first published (note, use only when different from code 11).
	 */
	Date_of_first_publication_in_original_language("20"),

	/**
	 * Date when a product will be reissued.
	 */
	Forthcoming_reissue_date("21"),

	/**
	 * Date when a product that has been temporary withdrawn from sale or recalled for any reason is expected to become available again, eg after correction of quality or technical issues.
	 */
	Expected_availability_date_after_temporary_withdrawal("22"),

	/**
	 * Date from which reviews of a product may be published eg in newspapers and magazines or online. Provided to the book trade for information only: newspapers and magazines are not expected to be recipients of ONIX metadata.
	 */
	Review_embargo_date("23"),

	/**
	 * Latest date on which an order may be placed with the publisher for guaranteed delivery prior to the publication date. May or may not be linked to a special reservation or pre-publication price.
	 */
	Publishers_reservation_order_deadline("25"),

	/**
	 * Date when a product will be reprinted.
	 */
	Forthcoming_reprint_date("26");

	public final String code;

	private PublishingDateRoles(String code)
	{
		this.code = code;
	}

	private static PublishingDateRoles[] values = PublishingDateRoles.values();
	public static PublishingDateRoles fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (PublishingDateRoles item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

