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
 * Epublication type code
 */
public enum List10
{
	/**
	 * An epublication viewed as a unique package of content which may be converted into any of a number of different types for delivery to
	 * the consumer. This code is used when an ONIX <Product> record describes the content package and lists within the record the different
	 * forms in which it is available.
	 */
	Epublication__content_package_("000"), //

	/**
	 * An epublication delivered in a basic, unprotected, HTML format. Do NOT use for HTML-based formats which include DRM protection.
	 */
	HTML("001"), //

	/**
	 * An epublication delivered in a basic, unprotected, PDF format. Do NOT use for PDF-based formats which include DRM protection.
	 */
	PDF("002"), //

	/**
	 * An epublication delivered in PDF format, capable of being read in the standard Acrobat Reader, and protected by PDF-Merchant DRM
	 * features. (This format is no longer supported for new applications.).
	 */
	PDF_Merchant("003"), //

	/**
	 * An epublication delivered in an enhanced PDF format, using Adobe’s proprietary EBX DRM, capable of being read in the Adobe Ebook
	 * Reader software, on any platform which can support this software, which was formerly known as Glassbook.
	 */
	Adobe_Ebook_Reader("004"), //

	/**
	 * An epublication delivered in an unencrypted Microsoft .LIT format, capable of being read in the Microsoft Reader software at any
	 * level, on any platform which can support this software. (Level 3 differs from Level 1 only in that it embeds the name of the original
	 * purchaser.).
	 */
	Microsoft_Reader_Level_1_Level_3("005"), //

	/**
	 * An epublication delivered in the Microsoft .LIT format, with full encryption, capable of being read in the Microsoft Reader software
	 * at Level 5, on any platform which can support this software.
	 */
	Microsoft_Reader_Level_5("006"), //

	/**
	 * An epublication delivered in a proprietary HTML- or OEBF-based format, capable of being read only through subscription to the
	 * NetLibrary service.
	 */
	NetLibrary("007"), //

	/**
	 * An epublication delivered in a proprietary format through a web browser, capable of being read only through subscription to the
	 * MetaText service (the educational division of NetLibrary).
	 */
	MetaText("008"), //

	/**
	 * An epublication delivered in a proprietary PDF-based format, capable of being read only through subscription to the MightyWords
	 * service.
	 */
	MightyWords("009"), //

	/**
	 * An epublication delivered in a proprietary HTML-based format, capable of being read in reading software which may be used on handheld
	 * devices using the Palm OS or Pocket PC/Windows CE operating systems.
	 */
	eReader__AKA_Palm_Reader_("010"), //

	/**
	 * An epublication delivered in a proprietary format capable of being read in reading software which is specific to the Softbook
	 * hardware platform. Also capable of being read on the Softbook’s successor, the Gemstar REB 1200.
	 */
	Softbook("011"), //

	/**
	 * An epublication delivered in a proprietary .RB format, capable of being read in reading software which is specific to the RocketBook
	 * hardware platform. Also capable of being read on the RocketBook’s successor, the Gemstar REB 1100.
	 */
	RocketBook("012"), //

	/**
	 * An epublication delivered in a proprietary .RB format, capable of being read in reading software which is specific to the Gemstar REB
	 * 1100 hardware platform. Also capable of being read on the RocketBook with some loss of functionality.
	 */
	Gemstar_REB_1100("013"), //

	/**
	 * An epublication delivered in a proprietary format, capable of being read in reading software which is specific to the Gemstar REB
	 * 1200 hardware platform. Also capable of being read on the Softbook with some loss of functionality.
	 */
	Gemstar_REB_1200("014"), //

	/**
	 * An epublication delivered in Franklin’s proprietary HTML-based format, capable of being read in reading software which is specific to
	 * the Franklin eBookman platform.
	 */
	Franklin_eBookman("015"), //

	/**
	 * An epublication delivered in a proprietary XML-based format and available for online access only through subscription to the
	 * Books24x7 service.
	 */
	Books24x7("016"), //

	/**
	 * An epublication available through DigitalOwl proprietary packaging, distribution and DRM software, delivered in a variety of formats
	 * across a range of platforms.
	 */
	DigitalOwl("017"), //

	/**
	 * An epublication delivered in a proprietary HTML-based format, capable of being read in Handheldmed reader software on Palm OS,
	 * Windows, and EPOC/Psion handheld devices, available only through the Handheldmed service.
	 */
	Handheldmed("018"), //

	/**
	 * An epublication delivered in a proprietary ???-based format and available for download only through the WizeUp service.
	 */
	WizeUp("019"), //

	/**
	 * An epublication delivered in the proprietary TK3 format, capable of being read only in the TK3 reader software supplied by Night
	 * Kitchen Inc, on any platform which can support this software.
	 */
	TK3("020"), //

	/**
	 * An epublication delivered in an encrypted .RTF format, capable of being read only in the Litraweb Visor software, and available only
	 * from Litraweb.com.
	 */
	Litraweb("021"), //

	/**
	 * An epublication delivered in a proprietary format, capable of being read in the MobiPocket software on PalmOS, WindowsCE /Pocket PC,
	 * Franklin eBookman, and EPOC32 handheld devices, available through the MobiPocket service. Includes Amazon Kindle formats up to and
	 * including version 7 – but prefer code 031 for version 7, and always use 031 for KF8.
	 */
	MobiPocket("022"), //

	/**
	 * An epublication delivered in the standard distribution format specified in the Open Ebook Publication Structure (OEBPS) format and
	 * capable of being read in any OEBPS-compliant reading system. Includes EPUB format up to and including version 2 – but prefer code 029
	 * for EPUB 2, and always use 029 for EPUB 3.
	 */
	Open_Ebook("023"), //

	/**
	 * An epublication delivered in a proprietary format, capable of being read in Town Compass DataViewer reader software on a Palm OS
	 * handheld device.
	 */
	Town_Compass_DataViewer("024"), //

	/**
	 * An epublication delivered in an openly available .TXT format, with ASCII or UTF-8 encoding, as used for example in Project Gutenberg.
	 */
	TXT("025"), //

	/**
	 * An epublication delivered as a self-executing file including its own reader software, and created with proprietary ExeBook
	 * Self-Publisher software.
	 */
	ExeBook("026"), //

	/**
	 * An epublication in a Sony proprietary format for use with the Sony Reader and LIBRIé reading devices.
	 */
	Sony_BBeB("027"), //

	VitalSource_Bookshelf("028"), //

	/**
	 * An epublication delivered using the Open Publication Structure / OPS Container Format standard of the International Digital
	 * Publishing Forum (IDPF). [This value was originally defined as ‘Adobe Digital Editions’, which is not an epublication format but a
	 * reader which supports PDF or EPUB (IDPF) formats. Since PDF is already covered by code 002, it was agreed, and announced to the ONIX
	 * listserv in September 2009, that code 029 should be refined to represent EPUB format.].
	 */
	EPUB("029"), //

	MyiLibrary("030"), //

	/**
	 * Amazon proprietary file format derived from Mobipocket format, used for Kindle devices and Kindle reader software.
	 */
	Kindle("031"), //

	/**
	 * An epublication made available by Google in association with a publisher; readable online on a browser-enabled device and offline on
	 * designated ebook readers.
	 */
	Google_Edition("032"), //

	/**
	 * An epublication in a proprietary format combining text and video content and available to be used online or as a downloadable
	 * application for a mobile device – see www.vook.com.
	 */
	Vook("033"), //

	/**
	 * An epublication in a proprietary format for use with DXReader software.
	 */
	DXReader("034"), //

	/**
	 * An epublication in a format proprietary to the Ebook Library service.
	 */
	EBL("035"), //

	/**
	 * An epublication in a format proprietary to the Ebrary service.
	 */
	Ebrary("036"), //

	/**
	 * An epublication in a proprietary format for use with iSilo software on various hardware platforms.
	 */
	iSilo("037"), //

	/**
	 * An epublication in a proprietary format for use with Plucker reader software on Palm and other handheld devices.
	 */
	Plucker("038"), //

	/**
	 * A format proprietary to the VitalSource service.
	 */
	VitalBook("039"), //

	/**
	 * Epublication packaged as an application for iOS (eg Apple iPhone, iPad etc) containing both executable code and content. Content can
	 * be described with <ProductContentType>.
	 */
	Book__app__for_iOS("040"), //

	/**
	 * Epublication packaged as an application for Android (eg Android phone or tablet) containing both executable code and content. Content
	 * can be described with <ProductContentType>.
	 */
	Android__app_("041"), //

	/**
	 * Epublication packaged as an application. Technical requirements such as target operating system and/or device should be provided in
	 * <EpubTypeNote>. Content can be described with <ProductContentType>.
	 */
	Other__app_("042"), //

	/**
	 * XML Paper Specification format [File extension .xps] for (eg) Blio.
	 */
	XPS("043"), //

	/**
	 * Apple’s iBook format (a proprietary extension of EPUB), can only be read on Apple iOS devices.
	 */
	iBook("044"), //

	/**
	 * Proprietary format based on EPUB used by Barnes and Noble for fixed-format e-books, readable on NOOK devices and Nook reader
	 * software.
	 */
	ePIB("045"), //

	/**
	 * Sharable Content Object Reference Model, standard content and packaging format for e-learning objects.
	 */
	SCORM("046"), //

	/**
	 * E-book Plus (proprietary Norwegian e-book format based on HTML5 documents packaged within a zipped .ebp file).
	 */
	EBP("047"), //

	/**
	 * Proprietary format based on PDF used by Barnes and Noble for fixed-format e-books, readable on some NOOK devices and Nook reader
	 * software.
	 */
	Page_Perfect("048"), //

	/**
	 * Product consists of parts in different formats.
	 */
	Multiple_formats("098"), //

	/**
	 * Unknown, or no code yet assigned for this format.
	 */
	Unspecified("099");

	public final String value;

	private List10(String value)
	{
		this.value = value;
	}

	private static Map<String, List10> map;

	private static Map<String, List10> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (List10 e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static List10 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
