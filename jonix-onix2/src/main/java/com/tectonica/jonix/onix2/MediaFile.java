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

import com.tectonica.jonix.DU;
import com.tectonica.jonix.codelist.ImageAudioVideoFileFormatCodes;
import com.tectonica.jonix.codelist.ImageAudioVideoFileLinkTypes;
import com.tectonica.jonix.codelist.ImageAudioVideoFileTypeCodes;
import com.tectonica.jonix.codelist.LanguageCodeIso6392Bs;
import com.tectonica.jonix.codelist.RecordSourceTypeCodes;
import com.tectonica.jonix.codelist.TextCaseFlags;
import com.tectonica.jonix.codelist.TextFormatCodes;
import com.tectonica.jonix.codelist.TransliterationSchemeCodes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

public class MediaFile
{
	public static final String refname = "MediaFile";
	public static final String shortname = "mediafile";

	public TextFormatCodes textformat;
	public TextCaseFlags textcase;
	public LanguageCodeIso6392Bs language;
	public TransliterationSchemeCodes transliteration;
	public String datestamp; // DateOrDateTime
	public RecordSourceTypeCodes sourcetype;
	public String sourcename;

	public MediaFileTypeCode mediaFileTypeCode; // Required
	public MediaFileFormatCode mediaFileFormatCode; // Optional
	public ImageResolution imageResolution; // Optional
	public MediaFileLinkTypeCode mediaFileLinkTypeCode; // Required
	public MediaFileLink mediaFileLink; // Required
	public TextWithDownload textWithDownload; // Optional
	public DownloadCaption downloadCaption; // Required
	public DownloadCredit downloadCredit; // Optional
	public DownloadCopyrightNotice downloadCopyrightNotice; // Optional
	public DownloadTerms downloadTerms; // Optional
	public MediaFileDate mediaFileDate; // Optional

	public static MediaFile fromDoc(org.w3c.dom.Element element)
	{
		final MediaFile x = new MediaFile();

		x.textformat = TextFormatCodes.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = TextCaseFlags.byValue(DU.getAttribute(element, "textcase"));
		x.language = LanguageCodeIso6392Bs.byValue(DU.getAttribute(element, "language"));
		x.transliteration = TransliterationSchemeCodes.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = RecordSourceTypeCodes.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(MediaFileTypeCode.refname) || name.equals(MediaFileTypeCode.shortname))
					x.mediaFileTypeCode = MediaFileTypeCode.fromDoc(element);
				else if (name.equals(MediaFileFormatCode.refname) || name.equals(MediaFileFormatCode.shortname))
					x.mediaFileFormatCode = MediaFileFormatCode.fromDoc(element);
				else if (name.equals(ImageResolution.refname) || name.equals(ImageResolution.shortname))
					x.imageResolution = ImageResolution.fromDoc(element);
				else if (name.equals(MediaFileLinkTypeCode.refname) || name.equals(MediaFileLinkTypeCode.shortname))
					x.mediaFileLinkTypeCode = MediaFileLinkTypeCode.fromDoc(element);
				else if (name.equals(MediaFileLink.refname) || name.equals(MediaFileLink.shortname))
					x.mediaFileLink = MediaFileLink.fromDoc(element);
				else if (name.equals(TextWithDownload.refname) || name.equals(TextWithDownload.shortname))
					x.textWithDownload = TextWithDownload.fromDoc(element);
				else if (name.equals(DownloadCaption.refname) || name.equals(DownloadCaption.shortname))
					x.downloadCaption = DownloadCaption.fromDoc(element);
				else if (name.equals(DownloadCredit.refname) || name.equals(DownloadCredit.shortname))
					x.downloadCredit = DownloadCredit.fromDoc(element);
				else if (name.equals(DownloadCopyrightNotice.refname) || name.equals(DownloadCopyrightNotice.shortname))
					x.downloadCopyrightNotice = DownloadCopyrightNotice.fromDoc(element);
				else if (name.equals(DownloadTerms.refname) || name.equals(DownloadTerms.shortname))
					x.downloadTerms = DownloadTerms.fromDoc(element);
				else if (name.equals(MediaFileDate.refname) || name.equals(MediaFileDate.shortname))
					x.mediaFileDate = MediaFileDate.fromDoc(element);
			}
		});

		return x;
	}

	public ImageAudioVideoFileTypeCodes getMediaFileTypeCodeValue()
	{
		return (mediaFileTypeCode == null) ? null : mediaFileTypeCode.value;
	}

	public ImageAudioVideoFileFormatCodes getMediaFileFormatCodeValue()
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
}
