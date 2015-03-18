/*
 * Copyright (C) 2012 Zach Melamed
 * 
 * Latest version available online at https://github.com/zach-m/jonix
 * Contact me at zach@tectonica.co.il
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tectonica.jonix.onix3.codelist;

import java.util.HashMap;
import java.util.Map;

/**
 * ONIX sales outlet IDs
 */
public enum List139
{
	A_C_Moore("ACM"), //

	AandP("AAP"), //

	Albertson_s("ALB"), //

	Amazon("AMZ"), //

	Angus_and_Robertson("ANR"), //

	Anobii("ANB"), //

	Apple("APC"), //

	Asda("ASD"), //

	Audible("AUD"), //

	B_Dalton("BDL"), //

	Barnes_and_Noble("BNO"), //

	Bed_Bath_and_Beyond("BBB"), //

	Best_Buy("BST"), //

	Bilbary("BIL"), //

	BJ_s_Wholesale_Club("BJW"), //

	Blackwell_s("BLK"), //

	Book_Club_Associates("BCA"), //

	Bookish("BSH"), //

	Bookpeople("BKP"), //

	Books_A_Million("BKM"), //

	Borders("BRD"), //

	Borders_Books_Etc("BRB"), //

	British_Bookshops("BRT"), //

	Casa_del_Libro("CDL"), //

	Christianbook_com("CHD"), //

	Copia("COP"), //

	Costco("CST"), //

	Crate_and_Barrel("CRB"), //

	CVS_Drug_Stores("CVS"), //

	Cyberlibris("CYB"), //

	De_Marque("DEM"), //

	Dick_s_Sporting_Goods("DSG"), //

	Dilicom("DIL"), //

	Dymocks("DYM"), //

	Early_Learning_Centre("ELC"), //

	Eason("ESN"), //

	Ebooks_Corp("EBC"), //

	eChristian("ECH"), //

	El_Corte_Ingl_s("ECI"), //

	Electre("ELE"), //

	Elib_se("ELB"), //

	Empik("EMP"), //

	English_Heritage("ENH"), //

	E_Pagine("EPA"), //

	FeedBooks("FDB"), //

	FlipKart("FLP"), //

	Fnac("FNC"), //

	Follett("FOL"), //

	Fry_s_Electronics("FRY"), //

	Gamestop("GMS"), //

	Google_Books("GOO"), //

	/**
	 * Formerly GoSpoken/Mobcast
	 */
	Blinkbox("GOS"), //

	Hastings_Entertainment("HST"), //

	HMV("HMV"), //

	Home_Depot("HMD"), //

	Immat_riel_fr("IMM"), //

	Indigo_Chapters("IND"), //

	Izneo("IZN"), //

	John_Smith_and_Son("JSM"), //

	K_Mart("KMT"), //

	KNFB_Blio("KNB"), //

	Kno_Inc("KNO"), //

	Kobo("KBO"), //

	Koorong("KOO"), //

	Kroger("KRG"), //

	Lowe_s("LWE"), //

	Marks_and_Spencer("MKS"), //

	Matras("MAT"), //

	/**
	 * Also known as Media World.
	 */
	Media_Markt_Saturn("MMS"), //

	Microcenter("MCR"), //

	Morrisons("MRR"), //

	Mothercare("MTC"), //

	MyBoox("MYB"), //

	National_Trust("NTR"), //

	Numilog("NUM"), //

	Office_Depot("OFD"), //

	Office_Max("OFM"), //

	OLF("OLF"), //

	OverDrive("OVD"), //

	Past_Times("PST"), //

	Pet_Smart("PTS"), //

	Petco("PTC"), //

	Play_com("PLY"), //

	Pottery_Barn("PTB"), //

	Readbooks("RDB"), //

	ReadCloud("RCL"), //

	Restoration_Hardware("RST"), //

	Rethink("RET"), //

	Ritz_Camera("RTZ"), //

	Safeway("SFW"), //

	Sainsbury_s("SNS"), //

	Selfridges("SLF"), //

	Skoobe("SKB"), //

	SmashWords("SMW"), //

	Sony("SNY"), //

	Staples("STP"), //

	The_Ebook_Alternative("TEA"), //

	Target("TRG"), //

	Tesco("TES"), //

	Toys__R__Us("TSR"), //

	TSO__The_Stationery_Office_("TSO"), //

	Txtr("TXR"), //

	Virgin_Megastores("VRG"), //

	W_H_Smith("WHS"), //

	Waitrose("WTR"), //

	Wal_Mart("WLM"), //

	Waterstone_s("WST"), //

	Whitcoul_s("WHT"), //

	Williams_Sonoma("WLS"), //

	Woolworths("WLW"), //

	/**
	 * Formerly Virgin Megastores (UK).
	 */
	Zavvi("ZVV"), //

	/**
	 * Include retailer name in <SalesOutletName>.
	 */
	Other("ZZZ");

	public final String value;

	private List139(String value)
	{
		this.value = value;
	}

	private static Map<String, List139> map;

	private static Map<String, List139> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List139 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List139 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
