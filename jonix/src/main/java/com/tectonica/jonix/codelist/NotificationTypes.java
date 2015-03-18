package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 1
 * 
 * @author Zach Melamed
 * 
 */
public enum NotificationTypes
{
	/**
	 * Use for a complete record issued earlier than approximately six months before publication.
	 */
	Early_notification("01"),

	/**
	 * Use for a complete record issued to confirm advance information approximately six months before publication; or for a complete record issued after that date and before information has been confirmed from the book-in-hand.
	 */
	Advance_notification_confirmed("02"),

	/**
	 * Use for a complete record issued to confirm advance information at or just before actual publication date; or for a complete record issued at any later date.
	 */
	Notification_confirmed_on_publication("03"),

	/**
	 * In ONIX 3.0 only, use when sending a ‘block update’ record. In previous ONIX releases, ONIX updating has generally been by complete record replacement using code 03, and code 04 is not used.
	 */
	Update_partial("04"),

	/**
	 * Use when sending an instruction to delete a record which was previously issued. Note that a Delete instruction should NOT be used when a product is cancelled, put out of print, or otherwise withdrawn from sale: this should be handled as a change of Publishing status, leaving the receiver to decide whether to retain or delete the record. A Delete instruction is only used when there is a particular reason to withdraw a record completely, eg because it was issued in error.
	 */
	Delete("05"),

	/**
	 * Notice of sale of a product, from one publisher to another: sent by the publisher disposing of the product.
	 */
	Notice_of_sale("08"),

	/**
	 * Notice of acquisition of a product, by one publisher from another: sent by the acquiring publisher.
	 */
	Notice_of_acquisition("09"),

	/**
	 * ONIX Books 2.1 supply update – <SupplyDetail> only (not used in ONIX 3.0).
	 */
	Update___SupplyDetail_only("12"),

	/**
	 * ONIX Books 2.1 supply update – <MarketRepresentation> only (not used in ONIX 3.0).
	 */
	Update___MarketRepresentation_only("13"),

	/**
	 * ONIX Books 2.1 supply update – both <SupplyDetail> and <MarketRepresentation> (not used in ONIX 3.0).
	 */
	Update___SupplyDetail_and_MarketRepresentation("14");

	public final String code;

	private NotificationTypes(String code)
	{
		this.code = code;
	}

	private static NotificationTypes[] values = NotificationTypes.values();
	public static NotificationTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (NotificationTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

