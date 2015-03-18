package com.tectonica.jonix.codelists;

/**
 * List 33
 * 
 * @author Zach Melamed
 *
 */
public enum TextTypes
{
	Main_description("01"),

	Short_description("02"),

	Long_description("03"),

	Table_of_contents("04"),

	Review_quote_restricted_length("05"),

	Quote_from_review_of_previous_edition("06"),

	Review_text("07"),

	Review_quote("08"),

	Promotional_headline("09"),

	Previous_review_quote("10"),

	Author_comments("11"),

	Description_for_reader("12"),

	Biographical_note("13"),

	Description_for_Reading_Group_Guide("14"),

	Discussion_question_for_Reading_Group_Guide("15"),

	Competing_titles("16"),

	Flap_copy("17"),

	Back_cover_copy("18"),

	Feature("19"),

	New_feature("20"),

	Publishers_notice("21"),

	Index("22"),

	Excerpt_from_book("23"),

	First_chapter("24"),

	Description_for_sales_people("25"),

	Description_for_press_or_other_media("26"),

	Description_for_subsidiary_rights_department("27"),

	Description_for_teachers_or_educators("28"),

	Unpublished_endorsement("30"),

	Description_for_bookstore("31"),

	Description_for_library("32"),

	Introduction_or_preface("33"),

	Full_text("34"),

	Promotional_text("35"),

	Author_interview_or_QandA("40"),

	Reading_Group_Guide("41"),

	Commentary_or_discussion("42"),

	Short_description_for_series_or_set("43"),

	Long_description_for_series_or_set("44"),

	Country_of_final_manufacture("99");

	public final String code;

	private TextTypes(String code)
	{
		this.code = code;
	}

	private static TextTypes[] values = TextTypes.values();

	public static TextTypes fromCode(String code)
	{
		for (TextTypes item : values)
			if (item.code.equals(code))
				return item;
		return null;
	}
}
