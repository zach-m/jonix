package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 161
 * 
 * @author Zach Melamed
 * 
 */
public enum ResourceForms
{
	/**
	 * A resource that may be accessed by a hyperlink. The current host (eg the ONIX sender, who may be the publisher) will provide ongoing hosting services for the resource for the active life of the product (or at least until the Until Date specified in <ContentDate>). The ONIX recipient may embed the URL in a consumer facing-website (eg as the src attribute in an <img> link), and need not host an independent copy of the resource.
	 */
	Linkable_resource("01"),

	/**
	 * A file that may be downloaded on demand for third-party use. The ONIX sender will host a copy of the resource until the specified Until Date, but only for the ONIX recipient’s direct use. The ONIX recipient should download a copy of the resource, and must host an independent copy of the resource if it is used on a consumer-facing website. Special attention should be paid to the ‘Last Updated’ <ContentDate> to ensure the independent copy of the resource is kept up to date.
	 */
	Downloadable_file("02"),

	/**
	 * An application which is supplied in a form which can be embedded into a third-party webpage. As type 02, except the resource contains active content such as JavaScript, Flash, etc.
	 */
	Embeddable_application("03");

	public final String code;

	private ResourceForms(String code)
	{
		this.code = code;
	}

	private static ResourceForms[] values = ResourceForms.values();
	public static ResourceForms fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ResourceForms item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

