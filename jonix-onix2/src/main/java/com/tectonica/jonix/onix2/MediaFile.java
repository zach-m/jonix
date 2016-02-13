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

package com.tectonica.jonix.onix2;

import java.io.Serializable;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.ImageAudioVideoFileFormats;
import com.tectonica.jonix.codelist.ImageAudioVideoFileLinkTypes;
import com.tectonica.jonix.codelist.ImageAudioVideoFileTypes;
import com.tectonica.jonix.codelist.LanguageCodes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TransliterationSchemes;
import com.tectonica.jonix.struct.JonixMediaFile;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class MediaFile implements OnixDataComposite, Serializable
{
	public static final String refname = "MediaFile";
	public static final String shortname = "mediafile";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	public TextFormats textformat;

	public TextCaseFlags textcase;

	public LanguageCodes language;

	public TransliterationSchemes transliteration;

	/**
	 * (type: DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	// ///////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (this field is required)
	 */
	public MediaFileTypeCode mediaFileTypeCode;

	/**
	 * (this field is optional)
	 */
	public MediaFileFormatCode mediaFileFormatCode;

	/**
	 * (this field is optional)
	 */
	public ImageResolution imageResolution;

	/**
	 * (this field is required)
	 */
	public MediaFileLinkTypeCode mediaFileLinkTypeCode;

	/**
	 * (this field is required)
	 */
	public MediaFileLink mediaFileLink;

	/**
	 * (this field is optional)
	 */
	public TextWithDownload textWithDownload;

	/**
	 * (this field is required)
	 */
	public DownloadCaption downloadCaption;

	/**
	 * (this field is optional)
	 */
	public DownloadCredit downloadCredit;

	/**
	 * (this field is optional)
	 */
	public DownloadCopyrightNotice downloadCopyrightNotice;

	/**
	 * (this field is optional)
	 */
	public DownloadTerms downloadTerms;

	/**
	 * (this field is optional)
	 */
	public MediaFileDate mediaFileDate;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public MediaFile()
	{}

	public MediaFile(org.w3c.dom.Element element)
	{
		textformat = TextFormats.byValue(JPU.getAttribute(element, "textformat"));
		textcase = TextCaseFlags.byValue(JPU.getAttribute(element, "textcase"));
		language = LanguageCodes.byValue(JPU.getAttribute(element, "language"));
		transliteration = TransliterationSchemes.byValue(JPU.getAttribute(element, "transliteration"));
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(MediaFileTypeCode.refname) || name.equals(MediaFileTypeCode.shortname))
					mediaFileTypeCode = new MediaFileTypeCode(element);
				else if (name.equals(MediaFileFormatCode.refname) || name.equals(MediaFileFormatCode.shortname))
					mediaFileFormatCode = new MediaFileFormatCode(element);
				else if (name.equals(ImageResolution.refname) || name.equals(ImageResolution.shortname))
					imageResolution = new ImageResolution(element);
				else if (name.equals(MediaFileLinkTypeCode.refname) || name.equals(MediaFileLinkTypeCode.shortname))
					mediaFileLinkTypeCode = new MediaFileLinkTypeCode(element);
				else if (name.equals(MediaFileLink.refname) || name.equals(MediaFileLink.shortname))
					mediaFileLink = new MediaFileLink(element);
				else if (name.equals(TextWithDownload.refname) || name.equals(TextWithDownload.shortname))
					textWithDownload = new TextWithDownload(element);
				else if (name.equals(DownloadCaption.refname) || name.equals(DownloadCaption.shortname))
					downloadCaption = new DownloadCaption(element);
				else if (name.equals(DownloadCredit.refname) || name.equals(DownloadCredit.shortname))
					downloadCredit = new DownloadCredit(element);
				else if (name.equals(DownloadCopyrightNotice.refname) || name.equals(DownloadCopyrightNotice.shortname))
					downloadCopyrightNotice = new DownloadCopyrightNotice(element);
				else if (name.equals(DownloadTerms.refname) || name.equals(DownloadTerms.shortname))
					downloadTerms = new DownloadTerms(element);
				else if (name.equals(MediaFileDate.refname) || name.equals(MediaFileDate.shortname))
					mediaFileDate = new MediaFileDate(element);
			}
		});
	}

	public ImageAudioVideoFileTypes getMediaFileTypeCodeValue()
	{
		return (mediaFileTypeCode == null) ? null : mediaFileTypeCode.value;
	}

	public ImageAudioVideoFileFormats getMediaFileFormatCodeValue()
	{
		return (mediaFileFormatCode == null) ? null : mediaFileFormatCode.value;
	}

	public String getImageResolutionValue()
	{
		return (imageResolution == null) ? null : imageResolution.value;
	}

	public ImageAudioVideoFileLinkTypes getMediaFileLinkTypeCodeValue()
	{
		return (mediaFileLinkTypeCode == null) ? null : mediaFileLinkTypeCode.value;
	}

	public String getMediaFileLinkValue()
	{
		return (mediaFileLink == null) ? null : mediaFileLink.value;
	}

	public String getTextWithDownloadValue()
	{
		return (textWithDownload == null) ? null : textWithDownload.value;
	}

	public String getDownloadCaptionValue()
	{
		return (downloadCaption == null) ? null : downloadCaption.value;
	}

	public String getDownloadCreditValue()
	{
		return (downloadCredit == null) ? null : downloadCredit.value;
	}

	public String getDownloadCopyrightNoticeValue()
	{
		return (downloadCopyrightNotice == null) ? null : downloadCopyrightNotice.value;
	}

	public String getDownloadTermsValue()
	{
		return (downloadTerms == null) ? null : downloadTerms.value;
	}

	public String getMediaFileDateValue()
	{
		return (mediaFileDate == null) ? null : mediaFileDate.value;
	}

	public JonixMediaFile asJonixMediaFile()
	{
		JonixMediaFile x = new JonixMediaFile();
		x.mediaFileTypeCode = getMediaFileTypeCodeValue();
		x.mediaFileFormatCode = getMediaFileFormatCodeValue();
		x.imageResolution = getImageResolutionValue();
		x.mediaFileLinkTypeCode = getMediaFileLinkTypeCodeValue();
		x.mediaFileLink = getMediaFileLinkValue();
		x.textWithDownload = getTextWithDownloadValue();
		x.downloadCaption = getDownloadCaptionValue();
		x.downloadCredit = getDownloadCreditValue();
		x.downloadCopyrightNotice = getDownloadCopyrightNoticeValue();
		x.downloadTerms = getDownloadTermsValue();
		x.mediaFileDate = getMediaFileDateValue();
		return x;
	}
}
