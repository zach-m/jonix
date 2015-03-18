package com.tectonica.jonix.codelists;

/**
 * List 1
 * 
 * @author Zach Melamed
 *
 */
public enum NotificationTypes
{
	Early_notification("01"),

	Advance_notification_confirmed("02"),

	Notification_confirmed_on_publication("03"),

	Update_partial("04"),

	Delete("05"),

	Notice_of_sale("08"),

	Notice_of_acquisition("09"),

	Update_SupplyDetail_only("12"),

	Update_MarketRepresentation_only("13"),

	Update_SupplyDetail_and_MarketRepresentation("14");

	public final String code;

	private NotificationTypes(String code)
	{
		this.code = code;
	}

	private static NotificationTypes[] values = NotificationTypes.values();

	public static NotificationTypes fromCode(String code)
	{
		for (NotificationTypes item : values)
			if (item.code.equals(code))
				return item;
		return null;
	}
}
