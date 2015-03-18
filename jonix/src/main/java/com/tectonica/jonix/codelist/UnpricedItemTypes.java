package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 57
 * 
 * @author Zach Melamed
 * 
 */
public enum UnpricedItemTypes
{
	Free_of_charge("01"),

	Price_to_be_announced("02"),

	Not_sold_separately("03"),

	/**
	 * May be used for books that do not carry a recommended retail price, when an ONIX file is “broadcast” rather than sent one-to-one to a single trading partner; or for digital products offered on subscription or with pricing which is too complex to specify in ONIX.
	 */
	Contact_supplier("04"),

	/**
	 * When a collection that is not sold as a set nevertheless has its own ONIX record.
	 */
	Not_sold_as_set("05");

	public final String code;

	private UnpricedItemTypes(String code)
	{
		this.code = code;
	}

	private static UnpricedItemTypes[] values = UnpricedItemTypes.values();
	public static UnpricedItemTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (UnpricedItemTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

