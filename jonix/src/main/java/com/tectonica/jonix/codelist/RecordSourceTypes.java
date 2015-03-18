package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 3
 * 
 * @author Zach Melamed
 * 
 */
public enum RecordSourceTypes
{
	Unspecified("00"),

	Publisher("01"),

	/**
	 * Use to designate a distributor providing warehousing and fulfillment for a publisher or for a publisher’s sales agent, as distinct from a wholesaler.
	 */
	Publishers_distributor("02"),

	Wholesaler("03"),

	/**
	 * Bibliographic data aggregator.
	 */
	Bibliographic_agency("04"),

	Library_bookseller("05"),

	/**
	 * Use for a publisher’s sales agent responsible for marketing the publisher’s products within a territory, as opposed to a publisher’s distributor who fulfills orders but does not market.
	 */
	Publishers_sales_agent("06"),

	/**
	 * Downstream provider of e-publication format conversion service (who might also be a distributor or retailer of the converted e-publication), supplying metadata on behalf of the publisher. The assigned ISBN is taken from the publisher’s ISBN prefix.
	 */
	Publishers_conversion_service_provider("07"),

	/**
	 * Downstream provider of e-publication format conversion service (who might also be a distributor or retailer of the converted e-publication), supplying metadata on behalf of the publisher. The assigned ISBN is taken from the service provider’s prefix (whether or not the service provider dedicates that prefix to a particular publisher).
	 */
	Conversion_service_provider("08"),

	ISBN_Registration_Agency("09"),

	ISTC_Registration_Agency("10");

	public final String code;

	private RecordSourceTypes(String code)
	{
		this.code = code;
	}

	private static RecordSourceTypes[] values = RecordSourceTypes.values();
	public static RecordSourceTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (RecordSourceTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

