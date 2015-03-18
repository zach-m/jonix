package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 12
 * 
 * @author Zach Melamed
 * 
 */
public enum TradeCategories
{
	/**
	 * An edition from a UK publisher sold only in territories where exclusive rights are not held. Rights details should be carried in PR.21 (ONIX 2.1) OR P.21 (ONIX 3.0) as usual.
	 */
	UK_open_market_edition("01"),

	/**
	 * In UK, an edition intended primarily for airside sales in UK airports, though it may be available for sale in other territories where exclusive rights are not held. Rights details should be carried in PR.21 (ONIX 2.1) OR P.21 (ONIX 3.0) as usual.
	 */
	Airport_edition("02"),

	/**
	 * In Germany, a special printing sold at a lower price than the regular hardback.
	 */
	Sonderausgabe("03"),

	/**
	 * In countries where recognised as a distinct trade category, eg France ‘livre de poche’, Germany ‘Taschenbuch’, Italy ‘tascabile’, Spain ‘libro de bolsillo’.
	 */
	Pocket_paperback("04"),

	/**
	 * Edition produced solely for sale in designated export markets.
	 */
	International_edition_US("05"),

	/**
	 * Audio product sold in special durable packaging and with a replacement guarantee for the contained cassettes or CDs for a specified shelf-life.
	 */
	Library_audio_edition("06"),

	/**
	 * An edition from a US publisher sold only in territories where exclusive rights are not held. Rights details should be carried in PR.21 (ONIX 2.1) OR P.21 (ONIX 3.0) as usual.
	 */
	US_open_market_edition("07"),

	/**
	 * In France, a category of book that has a particular legal status, claimed by the publisher.
	 */
	Livre_scolaire__d_clar__par_l_diteur("08"),

	/**
	 * In France, a category of book that has a particular legal status, designated independently of the publisher.
	 */
	Livre_scolaire_non_sp_cifi_("09"),

	/**
	 * Edition published for sale only with a newspaper or periodical.
	 */
	Supplement_to_newspaper("10"),

	/**
	 * In Spain, a school textbook for which there is no fixed or suggested retail price and which is supplied by the publisher on terms individually agreed with the bookseller.
	 */
	Precio_libre_textbook("11"),

	/**
	 * For editions sold only through newsstands/newsagents.
	 */
	News_outlet_edition("12"),

	/**
	 * In the US and Canada, a book that is published primarily for use by students in school or college education as a basis for study. Textbooks published for the elementary and secondary school markets are generally purchased by school districts for the use of students. Textbooks published for the higher education market are generally adopted for use in particular classes by the instructors of those classes. Textbooks are usually not marketed to the general public, which distinguishes them from trade books. Note that trade books adopted for course use are not considered to be textbooks (though a specific education edition of a trade title may be).
	 */
	US_textbook("13");

	public final String code;

	private TradeCategories(String code)
	{
		this.code = code;
	}

	private static TradeCategories[] values = TradeCategories.values();
	public static TradeCategories fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (TradeCategories item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

