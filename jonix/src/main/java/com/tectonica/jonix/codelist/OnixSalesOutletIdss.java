package com.tectonica.jonix.codelist;

/**
 * Enum that corresponds to Onix's CodeList 139
 * 
 * @author Zach Melamed
 * 
 */
public enum OnixSalesOutletIdss
{
	A_C_Moore("ACM"),

	AandP("AAP"),

	Albertsons("ALB"),

	Amazon("AMZ"),

	Angus_and_Robertson("ANR"),

	Anobii("ANB"),

	Apple("APC"),

	Asda("ASD"),

	Audible("AUD"),

	B_Dalton("BDL"),

	Barnes_and_Noble("BNO"),

	Bed_Bath_and_Beyond("BBB"),

	Best_Buy("BST"),

	Bilbary("BIL"),

	BJs_Wholesale_Club("BJW"),

	Blackwells("BLK"),

	Book_Club_Associates("BCA"),

	Bookish("BSH"),

	Bookpeople("BKP"),

	BooksAMillion("BKM"),

	Borders("BRD"),

	Borders_Books_Etc("BRB"),

	British_Bookshops("BRT"),

	Casa_del_Libro("CDL"),

	Christianbook_com("CHD"),

	Costco("CST"),

	Crate_and_Barrel("CRB"),

	CVS_Drug_Stores("CVS"),

	Dicks_Sporting_Goods("DSG"),

	Dymocks("DYM"),

	Early_Learning_Centre("ELC"),

	Eason("ESN"),

	Ebooks_Corp("EBC"),

	eChristian("ECH"),

	El_Corte_Ingl_s("ECI"),

	Elib_se("ELB"),

	Empik("EMP"),

	English_Heritage("ENH"),

	Fnac("FNC"),

	Frys_Electronics("FRY"),

	Gamestop("GMS"),

	Google_Books("GOO"),

	GoSpoken("GOS"),

	Hastings_Entertainment("HST"),

	HMV("HMV"),

	Home_Depot("HMD"),

	IndigoChapters("IND"),

	John_Smith_and_Son("JSM"),

	KMart("KMT"),

	KNFB_Blio("KNB"),

	Kno_Inc("KNO"),

	Kobo("KBO"),

	Koorong("KOO"),

	Kroger("KRG"),

	Lowes("LWE"),

	Marks_and_Spencer("MKS"),

	Matras("MAT"),

	/**
	 * Also known as Media World.
	 */
	Media_Markt_Saturn("MMS"),

	Microcenter("MCR"),

	Morrisons("MRR"),

	Mothercare("MTC"),

	National_Trust("NTR"),

	Office_Depot("OFD"),

	Office_Max("OFM"),

	OLF("OLF"),

	Past_Times("PST"),

	Pet_Smart("PTS"),

	Petco("PTC"),

	Play_com("PLY"),

	Pottery_Barn("PTB"),

	ReadCloud("RCL"),

	Restoration_Hardware("RST"),

	Rethink("RET"),

	Ritz_Camera("RTZ"),

	Safeway("SFW"),

	Sainsburys("SNS"),

	Selfridges("SLF"),

	Sony("SNY"),

	Staples("STP"),

	Target("TRG"),

	Tesco("TES"),

	Toys__R_Us("TSR"),

	TSO_The_Stationery_Office("TSO"),

	Virgin_Megastores("VRG"),

	W_H_Smith("WHS"),

	Waitrose("WTR"),

	WalMart("WLM"),

	Waterstones("WST"),

	Whitcouls("WHT"),

	Williams_Sonoma("WLS"),

	Woolworths("WLW"),

	/**
	 * Formerly Virgin Megastores (UK).
	 */
	Zavvi("ZVV"),

	/**
	 * Include retailer name in <SalesOutletName>.
	 */
	Other("ZZZ");

	public final String code;

	private OnixSalesOutletIdss(String code)
	{
		this.code = code;
	}

	private static OnixSalesOutletIdss[] values = OnixSalesOutletIdss.values();
	public static OnixSalesOutletIdss fromCode(String code)
	{
		if (code != null && !code.isEmpty())
			for (OnixSalesOutletIdss item : values)
				if (item.code.equals(code))
					return item;
		return null;
	}
}

