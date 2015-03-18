package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 5
 * 
 * @author Zach Melamed
 * 
 */
public enum ProductIdTypes
{
	/**
	 * For example, a publisher’s or wholesaler’s product number.
	 */
	Proprietary("01"),

	/**
	 * International Standard Book Number, pre-2007, unhyphenated (10 characters) – now DEPRECATED in ONIX for Books, except where providing historical information for compatibility with legacy systems. It should only be used in relation to products published before 2007 – when ISBN-13 superseded it – and should never be used as the ONLY identifier (it should always be accompanied by the correct GTIN-13 / ISBN-13).
	 */
	ISBN10("02"),

	/**
	 * GS1 Global Trade Item Number, formerly known as EAN article number (13 digits).
	 */
	GTIN13("03"),

	/**
	 * UPC product number (12 digits).
	 */
	UPC("04"),

	/**
	 * International Standard Music Number (M plus nine digits). Pre-2008 – now DEPRECATED in ONIX for Books, except where providing historical information for compatibility with legacy systems. It should only be used in relation to products published before 2008 – when ISMN-13 superseded it – and should never be used as the ONLY identifier (it should always be accompanied by the correct ISMN-13).
	 */
	ISMN10("05"),

	/**
	 * Digital Object Identifier (variable length and character set).
	 */
	DOI("06"),

	/**
	 * Library of Congress Control Number (12 characters, alphanumeric).
	 */
	LCCN("13"),

	/**
	 * GS1 Global Trade Item Number (14 digits).
	 */
	GTIN14("14"),

	/**
	 * International Standard Book Number, from 2007, unhyphenated (13 digits starting 978 or 9791–9799).
	 */
	ISBN13("15"),

	/**
	 * The number assigned to a publication as part of a national legal deposit process.
	 */
	Legal_deposit_number("17"),

	/**
	 * Uniform Resource Name: note that in trade applications an ISBN must be sent as a GTIN-13 and, where required, as an ISBN-13 – it should not be sent as a URN.
	 */
	URN("22"),

	/**
	 * A unique number assigned to a bibliographic item by OCLC.
	 */
	OCLC_number("23"),

	/**
	 * An ISBN-13 assigned by a co-publisher. The ‘main’ ISBN sent with ID type code 03 and/or 15 should always be the ISBN that is used for ordering from the supplier identified in Supply Detail. However, ISBN rules allow a co-published title to carry more than one ISBN. The co-publisher should be identified in an instance of the <Publisher> composite, with the applicable <PublishingRole> code.
	 */
	Copublishers_ISBN13("24"),

	/**
	 * International Standard Music Number, from 2008 (13-digit number starting 9790).
	 */
	ISMN13("25"),

	/**
	 * Actionable ISBN, in fact a special DOI incorporating the ISBN-13 within the DOI syntax. Begins ‘10.978.’ or ‘10.979.’ and includes a / character between the registrant element (publisher prefix) and publication element of the ISBN, eg 10.978.000/1234567. Note the ISBN-A should always be accompanied by the ISBN itself, using codes 03 and/or 15.
	 */
	ISBNA("26"),

	/**
	 * E-publication identifier controlled by JPOIID’s Committee for Research and Management of Electronic Publishing Codes.
	 */
	JP_ecode("27"),

	/**
	 * Unique number assigned by the Chinese Online Library Cataloging Center (see http://olcc.nlc.gov.cn).
	 */
	OLCC_number("28");

	public final String code;

	private ProductIdTypes(String code)
	{
		this.code = code;
	}

	private static ProductIdTypes[] values = ProductIdTypes.values();
	public static ProductIdTypes fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (ProductIdTypes item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

