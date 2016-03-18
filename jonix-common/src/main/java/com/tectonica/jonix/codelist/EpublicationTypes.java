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

package com.tectonica.jonix.codelist;

import java.util.HashMap;
import java.util.Map;

import com.tectonica.jonix.OnixCodelist;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 10 (Epublication type code)
 */
interface CodeList10
{}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 10</b>
 * <p>
 * Description: Epublication type code
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist10">ONIX
 *      Codelist 10 in Reference Guide</a>
 */
public enum EpublicationTypes implements OnixCodelist, CodeList10
{
	/**
	 * An epublication viewed as a unique package of content which may be converted into any of a number of different
	 * types for delivery to the consumer. This code is used when an ONIX &lt;Product&gt; record describes the content
	 * package and lists within the record the different forms in which it is available
	 */
	Epublication_content_package_("000", "Epublication ‘content package’"), //

	/**
	 * An epublication delivered in a basic, unprotected, HTML format. Do NOT use for HTML-based formats which include
	 * DRM protection
	 */
	HTML("001", "HTML"), //

	/**
	 * An epublication delivered in a basic, unprotected, PDF format. Do NOT use for PDF-based formats which include DRM
	 * protection
	 */
	PDF("002", "PDF"), //

	/**
	 * An epublication delivered in PDF format, capable of being read in the standard Acrobat Reader, and protected by
	 * PDF-Merchant DRM features. (This format is no longer supported for new applications)
	 */
	PDF_Merchant("003", "PDF-Merchant"), //

	/**
	 * An epublication delivered in an enhanced PDF format, using Adobe's proprietary EBX DRM, capable of being read in
	 * the Adobe Ebook Reader software, on any platform which can support this software, which was formerly known as
	 * Glassbook
	 */
	Adobe_Ebook_Reader("004", "Adobe Ebook Reader"), //

	/**
	 * An epublication delivered in an unencrypted Microsoft .LIT format, capable of being read in the Microsoft Reader
	 * software at any level, on any platform which can support this software. (Level 3 differs from Level 1 only in
	 * that it embeds the name of the original purchaser)
	 */
	Microsoft_Reader_Level_1_Level_3("005", "Microsoft Reader Level 1/Level 3"), //

	/**
	 * An epublication delivered in the Microsoft .LIT format, with full encryption, capable of being read in the
	 * Microsoft Reader software at Level 5, on any platform which can support this software
	 */
	Microsoft_Reader_Level_5("006", "Microsoft Reader Level 5"), //

	/**
	 * An epublication delivered in a proprietary HTML- or OEBF-based format, capable of being read only through
	 * subscription to the NetLibrary service
	 */
	NetLibrary("007", "NetLibrary"), //

	/**
	 * An epublication delivered in a proprietary format through a web browser, capable of being read only through
	 * subscription to the MetaText service (the educational division of NetLibrary)
	 */
	MetaText("008", "MetaText"), //

	/**
	 * An epublication delivered in a proprietary PDF-based format, capable of being read only through subscription to
	 * the MightyWords service
	 */
	MightyWords("009", "MightyWords"), //

	/**
	 * An epublication delivered in a proprietary HTML-based format, capable of being read in reading software which may
	 * be used on handheld devices using the Palm OS or Pocket PC/Windows CE operating systems
	 */
	eReader_AKA_Palm_Reader("010", "eReader (AKA Palm Reader)"), //

	/**
	 * An epublication delivered in a proprietary format capable of being read in reading software which is specific to
	 * the Softbook hardware platform. Also capable of being read on the Softbook's successor, the Gemstar REB 1200
	 */
	Softbook("011", "Softbook"), //

	/**
	 * An epublication delivered in a proprietary .RB format, capable of being read in reading software which is
	 * specific to the RocketBook hardware platform. Also capable of being read on the RocketBook's successor, the
	 * Gemstar REB 1100
	 */
	RocketBook("012", "RocketBook"), //

	/**
	 * An epublication delivered in a proprietary .RB format, capable of being read in reading software which is
	 * specific to the Gemstar REB 1100 hardware platform. Also capable of being read on the RocketBook with some loss
	 * of functionality
	 */
	Gemstar_REB_1100("013", "Gemstar REB 1100"), //

	/**
	 * An epublication delivered in a proprietary format, capable of being read in reading software which is specific to
	 * the Gemstar REB 1200 hardware platform. Also capable of being read on the Softbook with some loss of
	 * functionality
	 */
	Gemstar_REB_1200("014", "Gemstar REB 1200"), //

	/**
	 * An epublication delivered in Franklin's proprietary HTML-based format, capable of being read in reading software
	 * which is specific to the Franklin eBookman platform
	 */
	Franklin_eBookman("015", "Franklin eBookman"), //

	/**
	 * An epublication delivered in a proprietary XML-based format and available for online access only through
	 * subscription to the Books24x7 service
	 */
	Books24x7("016", "Books24x7"), //

	/**
	 * An epublication available through DigitalOwl proprietary packaging, distribution and DRM software, delivered in a
	 * variety of formats across a range of platforms
	 */
	DigitalOwl("017", "DigitalOwl"), //

	/**
	 * An epublication delivered in a proprietary HTML-based format, capable of being read in Handheldmed reader
	 * software on Palm OS, Windows, and EPOC/Psion handheld devices, available only through the Handheldmed service
	 */
	Handheldmed("018", "Handheldmed"), //

	/**
	 * An epublication delivered in a proprietary ???-based format and available for download only through the WizeUp
	 * service
	 */
	WizeUp("019", "WizeUp"), //

	/**
	 * An epublication delivered in the proprietary TK3 format, capable of being read only in the TK3 reader software
	 * supplied by Night Kitchen Inc, on any platform which can support this software
	 */
	TK3("020", "TK3"), //

	/**
	 * An epublication delivered in an encrypted .RTF format, capable of being read only in the Litraweb Visor software,
	 * and available only from Litraweb.com
	 */
	Litraweb("021", "Litraweb"), //

	/**
	 * An epublication delivered in a proprietary format, capable of being read in the MobiPocket software on PalmOS,
	 * WindowsCE /Pocket PC, Franklin eBookman, and EPOC32 handheld devices, available through the MobiPocket service.
	 * Includes Amazon Kindle formats up to and including version 7 - but prefer code 031 for version 7, and always use
	 * 031 for KF8
	 */
	MobiPocket("022", "MobiPocket"), //

	/**
	 * An epublication delivered in the standard distribution format specified in the Open Ebook Publication Structure
	 * (OEBPS) format and capable of being read in any OEBPS-compliant reading system. Includes EPUB format up to and
	 * including version 2 - but prefer code 029 for EPUB 2, and always use 029 for EPUB 3
	 */
	Open_Ebook("023", "Open Ebook"), //

	/**
	 * An epublication delivered in a proprietary format, capable of being read in Town Compass DataViewer reader
	 * software on a Palm OS handheld device
	 */
	Town_Compass_DataViewer("024", "Town Compass DataViewer"), //

	/**
	 * An epublication delivered in an openly available .TXT format, with ASCII or UTF-8 encoding, as used for example
	 * in Project Gutenberg
	 */
	TXT("025", "TXT"), //

	/**
	 * An epublication delivered as a self-executing file including its own reader software, and created with
	 * proprietary ExeBook Self-Publisher software
	 */
	ExeBook("026", "ExeBook"), //

	/**
	 * An epublication in a Sony proprietary format for use with the Sony Reader and LIBRI&#233; reading devices
	 */
	Sony_BBeB("027", "Sony BBeB"), //

	VitalSource_Bookshelf("028", "VitalSource Bookshelf"), //

	/**
	 * An epublication delivered using the Open Publication Structure / OPS Container Format standard of the
	 * International Digital Publishing Forum (IDPF). [This value was originally defined as 'Adobe Digital Editions',
	 * which is not an epublication format but a reader which supports PDF or EPUB (IDPF) formats. Since PDF is already
	 * covered by code 002, it was agreed, and announced to the ONIX listserv in September 2009, that code 029 should be
	 * refined to represent EPUB format]
	 */
	EPUB("029", "EPUB"), //

	MyiLibrary("030", "MyiLibrary"), //

	/**
	 * Amazon proprietary file format derived from Mobipocket format, used for Kindle devices and Kindle reader software
	 */
	Kindle("031", "Kindle"), //

	/**
	 * An epublication made available by Google in association with a publisher; readable online on a browser-enabled
	 * device and offline on designated ebook readers
	 */
	Google_Edition("032", "Google Edition"), //

	/**
	 * An epublication in a proprietary format combining text and video content and available to be used online or as a
	 * downloadable application for a mobile device - see www.vook.com
	 */
	Vook("033", "Vook"), //

	/**
	 * An epublication in a proprietary format for use with DXReader software
	 */
	DXReader("034", "DXReader"), //

	/**
	 * An epublication in a format proprietary to the Ebook Library service
	 */
	EBL("035", "EBL"), //

	/**
	 * An epublication in a format proprietary to the Ebrary service
	 */
	Ebrary("036", "Ebrary"), //

	/**
	 * An epublication in a proprietary format for use with iSilo software on various hardware platforms
	 */
	iSilo("037", "iSilo"), //

	/**
	 * An epublication in a proprietary format for use with Plucker reader software on Palm and other handheld devices
	 */
	Plucker("038", "Plucker"), //

	/**
	 * A format proprietary to the VitalSource service
	 */
	VitalBook("039", "VitalBook"), //

	/**
	 * Epublication packaged as an application for iOS (eg Apple iPhone, iPad etc) containing both executable code and
	 * content. Content can be described with &lt;ProductContentType&gt;
	 */
	Book_app_for_iOS("040", "Book ‘app’ for iOS"), //

	/**
	 * Epublication packaged as an application for Android (eg Android phone or tablet) containing both executable code
	 * and content. Content can be described with &lt;ProductContentType&gt;
	 */
	Android_app_("041", "Android ‘app’"), //

	/**
	 * Epublication packaged as an application. Technical requirements such as target operating system and/or device
	 * should be provided in &lt;EpubTypeNote&gt;. Content can be described with &lt;ProductContentType&gt;
	 */
	Other_app_("042", "Other ‘app’"), //

	/**
	 * XML Paper Specification format [File extension .xps] for (eg) Blio
	 */
	XPS("043", "XPS"), //

	/**
	 * Apple's iBook format (a proprietary extension of EPUB), can only be read on Apple iOS devices
	 */
	iBook("044", "iBook"), //

	/**
	 * Proprietary format based on EPUB used by Barnes and Noble for fixed-format e-books, readable on NOOK devices and
	 * Nook reader software
	 */
	ePIB("045", "ePIB"), //

	/**
	 * Sharable Content Object Reference Model, standard content and packaging format for e-learning objects
	 */
	SCORM("046", "SCORM"), //

	/**
	 * E-book Plus (proprietary Norwegian e-book format based on HTML5 documents packaged within a zipped .ebp file)
	 */
	EBP("047", "EBP"), //

	/**
	 * Proprietary format based on PDF used by Barnes and Noble for fixed-format e-books, readable on some NOOK devices
	 * and Nook reader software &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Page_Perfect("048", "Page Perfect"), //

	/**
	 * Product consists of parts in different formats
	 */
	Multiple_formats("098", "Multiple formats"), //

	/**
	 * Unknown, or no code yet assigned for this format
	 */
	Unspecified("099", "Unspecified");

	public final String code;
	public final String description;

	private EpublicationTypes(String code, String description)
	{
		this.code = code;
		this.description = description;
	}

	@Override
	public String getCode()
	{
		return code;
	}

	@Override
	public String getDescription()
	{
		return description;
	}

	private static volatile Map<String, EpublicationTypes> map;

	private static Map<String, EpublicationTypes> map()
	{
		Map<String, EpublicationTypes> result = map;
		if (result == null)
		{
			synchronized (EpublicationTypes.class)
			{
				result = map;
				if (result == null)
				{
					result = new HashMap<>();
					for (EpublicationTypes e : values())
						result.put(e.code, e);
					map = result;
				}
			}
		}
		return result;
	}

	public static EpublicationTypes byCode(String code)
	{
		if (code == null || code.isEmpty())
			return null;
		return map().get(code);
	}
}
