package com.tectonica.jonix.codelists;

/**
 * Lists 26 and 27, which are the same
 * 
 * @author Zach Melamed
 *
 */
public enum SubjectSchemeIdentifiers
{
	Dewey("01"),

	Abridged_Dewey("02"),

	LC_classification("03"),

	LC_subject_heading("04"),

	NLM_classification("05"),

	MeSH_heading("06"),

	NAL_subject_heading("07"),

	AAT("08"),

	UDC("09"),

	BISAC_Subject_Heading("10"),

	BISAC_region_code("11"),

	BIC_subject_category("12"),

	BIC_geographical_qualifier("13"),

	BIC_language_qualifier_language_as_subject("14"),

	BIC_time_period_qualifier("15"),

	BIC_educational_purpose_qualifier("16"),

	BIC_reading_level_and_special_interest_qualifier("17"),

	DDC_Sachgruppen_der_Deutschen_Nationalbibliografie("18"),

	LC_fiction_genre_heading("19"),

	Keywords("20"),

	BIC_childrens_book_marketing_category("21"),

	BISAC_Merchandising_Theme("22"),

	Publishers_own_category_code("23"),

	Proprietary_subject_scheme("24"),

	Tabla_de_materias_ISBN("25"),

	Warengruppen_Systematik_des_deutschen_Buchhandels("26"),

	SWD("27"),

	Themes_Electre("28"),

	CLIL("29"),

	DNB_Sachgruppen("30"),

	NUGI("31"),

	NUR("32"),

	ECPA_Christian_Book_Category("33"),

	SISO("34"),

	Korean_Decimal_Classification_KDC("35"),

	DDC_Deutsch_22("36"),

	Bokgrupper("37"),

	Varegrupper("38"),

	Laereplaner("39"),

	Nippon_Decimal_Classification("40"),

	BSQ("41"),

	ANELE_Materias("42"),

	Skolefag("43"),

	Videregaende("44"),

	Undervisningsmateriell("45"),

	Norsk_DDK("46"),

	Varugrupper("47"),

	SAB("48"),

	Laromedel("49"),

	Forhandsbeskrivning("50"),

	Spanish_ISBN_UDC_subset("51"),

	ECI_subject_categories("52"),

	Soggetto_CCE("53"),

	Qualificatore_geografico_CCE("54"),

	Qualificatore_di_lingua_CCE("55"),

	Qualificatore_di_periodo_storico_CCE("56"),

	Qualificatore_di_livello_scolastico_CCE("57"),

	Qualificatore_di_eta_di_lettura_CCE("58"),

	VdS_Bildungsmedien_Facher("59"),

	Fagkoder("60"),

	JEL_classification("61"),

	CSH("62"),

	RVM("63"),

	YSA("64"),

	Allars("65"),

	YKL("66"),

	MUSA("67"),

	CILLA("68"),

	Kaunokki("69"),

	Bella("70"),

	YSO("71"),

	Paikkatieto_ontologia("72"),

	Suomalainen_kirja_alan_luokitus("73"),

	Sears("74"),

	BIC_E4L("75"),

	CSR("76"),

	Suomalainen_oppiaineluokitus("77"),

	Japanese_book_trade_C_Code("78"),

	Japanese_book_trade_Genre_Code("79"),

	Fiktiivisen_aineiston_lisaluokitus("80"),

	Postal_code("85"),

	GeoNames_ID("86"),

	NewBooks_Subject_Classification("87"),

	GND("91");

	public final String code;

	private SubjectSchemeIdentifiers(String code)
	{
		this.code = code;
	}

	private static SubjectSchemeIdentifiers[] values = SubjectSchemeIdentifiers.values();

	public static SubjectSchemeIdentifiers fromCode(String code)
	{
		for (SubjectSchemeIdentifiers item : values)
			if (item.code.equals(code))
				return item;
		return null;
	}
}
