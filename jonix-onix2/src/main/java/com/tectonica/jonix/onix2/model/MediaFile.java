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

package com.tectonica.jonix.onix2.model;

import com.tectonica.jonix.onix2.DU;
import com.tectonica.jonix.onix2.codelist.List138;
import com.tectonica.jonix.onix2.codelist.List14;
import com.tectonica.jonix.onix2.codelist.List3;
import com.tectonica.jonix.onix2.codelist.List34;
import com.tectonica.jonix.onix2.codelist.List74;

public class MediaFile
{
	public static final String refname = "MediaFile";
	public static final String shortname = "mediafile";

	public List34 textformat;
	public List14 textcase;
	public List74 language;
	public List138 transliteration;
	public String datestamp; // DateOrDateTime
	public List3 sourcetype;
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

		x.textformat = List34.byValue(DU.getAttribute(element, "textformat"));
		x.textcase = List14.byValue(DU.getAttribute(element, "textcase"));
		x.language = List74.byValue(DU.getAttribute(element, "language"));
		x.transliteration = List138.byValue(DU.getAttribute(element, "transliteration"));
		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equalsIgnoreCase(MediaFileTypeCode.refname) || name.equalsIgnoreCase(MediaFileTypeCode.shortname))
					x.mediaFileTypeCode = MediaFileTypeCode.fromDoc(element);
				else if (name.equalsIgnoreCase(MediaFileFormatCode.refname) || name.equalsIgnoreCase(MediaFileFormatCode.shortname))
					x.mediaFileFormatCode = MediaFileFormatCode.fromDoc(element);
				else if (name.equalsIgnoreCase(ImageResolution.refname) || name.equalsIgnoreCase(ImageResolution.shortname))
					x.imageResolution = ImageResolution.fromDoc(element);
				else if (name.equalsIgnoreCase(MediaFileLinkTypeCode.refname) || name.equalsIgnoreCase(MediaFileLinkTypeCode.shortname))
					x.mediaFileLinkTypeCode = MediaFileLinkTypeCode.fromDoc(element);
				else if (name.equalsIgnoreCase(MediaFileLink.refname) || name.equalsIgnoreCase(MediaFileLink.shortname))
					x.mediaFileLink = MediaFileLink.fromDoc(element);
				else if (name.equalsIgnoreCase(TextWithDownload.refname) || name.equalsIgnoreCase(TextWithDownload.shortname))
					x.textWithDownload = TextWithDownload.fromDoc(element);
				else if (name.equalsIgnoreCase(DownloadCaption.refname) || name.equalsIgnoreCase(DownloadCaption.shortname))
					x.downloadCaption = DownloadCaption.fromDoc(element);
				else if (name.equalsIgnoreCase(DownloadCredit.refname) || name.equalsIgnoreCase(DownloadCredit.shortname))
					x.downloadCredit = DownloadCredit.fromDoc(element);
				else if (name.equalsIgnoreCase(DownloadCopyrightNotice.refname) || name.equalsIgnoreCase(DownloadCopyrightNotice.shortname))
					x.downloadCopyrightNotice = DownloadCopyrightNotice.fromDoc(element);
				else if (name.equalsIgnoreCase(DownloadTerms.refname) || name.equalsIgnoreCase(DownloadTerms.shortname))
					x.downloadTerms = DownloadTerms.fromDoc(element);
				else if (name.equalsIgnoreCase(MediaFileDate.refname) || name.equalsIgnoreCase(MediaFileDate.shortname))
					x.mediaFileDate = MediaFileDate.fromDoc(element);
			}
		});

		return x;
	}
}
