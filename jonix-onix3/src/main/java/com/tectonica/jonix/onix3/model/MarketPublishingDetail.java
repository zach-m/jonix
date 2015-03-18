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

package com.tectonica.jonix.onix3.model;

import java.util.List;

import com.tectonica.jonix.onix3.DU;
import com.tectonica.jonix.onix3.codelist.List3;

public class MarketPublishingDetail
{
	public static final String refname = "MarketPublishingDetail";
	public static final String shortname = "marketpublishingdetail";

	public String datestamp; // dt.DateOrDateTime
	public List3 sourcetype;
	public String sourcename;

	public List<PublisherRepresentative> publisherRepresentatives; // ZeroOrMore
	public List<ProductContact> productContacts; // ZeroOrMore
	public MarketPublishingStatus marketPublishingStatus; // Required
	public List<MarketPublishingStatusNote> marketPublishingStatusNotes; // ZeroOrMore
	public List<MarketDate> marketDates; // ZeroOrMore
	public List<PromotionCampaign> promotionCampaigns; // ZeroOrMore
	public PromotionContact promotionContact; // Optional
	public List<InitialPrintRun> initialPrintRuns; // ZeroOrMore
	public List<ReprintDetail> reprintDetails; // ZeroOrMore
	public List<CopiesSold> copiesSolds; // ZeroOrMore
	public List<BookClubAdoption> bookClubAdoptions; // ZeroOrMore

	public static MarketPublishingDetail fromDoc(org.w3c.dom.Element element)
	{
		final MarketPublishingDetail x = new MarketPublishingDetail();

		x.datestamp = DU.getAttribute(element, "datestamp");
		x.sourcetype = List3.byValue(DU.getAttribute(element, "sourcetype"));
		x.sourcename = DU.getAttribute(element, "sourcename");

		DU.forElementsOf(element, new DU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equalsIgnoreCase(PublisherRepresentative.refname) || name.equalsIgnoreCase(PublisherRepresentative.shortname))
					x.publisherRepresentatives = DU.addToList(x.publisherRepresentatives, PublisherRepresentative.fromDoc(element));
				else if (name.equalsIgnoreCase(ProductContact.refname) || name.equalsIgnoreCase(ProductContact.shortname))
					x.productContacts = DU.addToList(x.productContacts, ProductContact.fromDoc(element));
				else if (name.equalsIgnoreCase(MarketPublishingStatus.refname) || name.equalsIgnoreCase(MarketPublishingStatus.shortname))
					x.marketPublishingStatus = MarketPublishingStatus.fromDoc(element);
				else if (name.equalsIgnoreCase(MarketPublishingStatusNote.refname)
						|| name.equalsIgnoreCase(MarketPublishingStatusNote.shortname))
					x.marketPublishingStatusNotes = DU.addToList(x.marketPublishingStatusNotes, MarketPublishingStatusNote.fromDoc(element));
				else if (name.equalsIgnoreCase(MarketDate.refname) || name.equalsIgnoreCase(MarketDate.shortname))
					x.marketDates = DU.addToList(x.marketDates, MarketDate.fromDoc(element));
				else if (name.equalsIgnoreCase(PromotionCampaign.refname) || name.equalsIgnoreCase(PromotionCampaign.shortname))
					x.promotionCampaigns = DU.addToList(x.promotionCampaigns, PromotionCampaign.fromDoc(element));
				else if (name.equalsIgnoreCase(PromotionContact.refname) || name.equalsIgnoreCase(PromotionContact.shortname))
					x.promotionContact = PromotionContact.fromDoc(element);
				else if (name.equalsIgnoreCase(InitialPrintRun.refname) || name.equalsIgnoreCase(InitialPrintRun.shortname))
					x.initialPrintRuns = DU.addToList(x.initialPrintRuns, InitialPrintRun.fromDoc(element));
				else if (name.equalsIgnoreCase(ReprintDetail.refname) || name.equalsIgnoreCase(ReprintDetail.shortname))
					x.reprintDetails = DU.addToList(x.reprintDetails, ReprintDetail.fromDoc(element));
				else if (name.equalsIgnoreCase(CopiesSold.refname) || name.equalsIgnoreCase(CopiesSold.shortname))
					x.copiesSolds = DU.addToList(x.copiesSolds, CopiesSold.fromDoc(element));
				else if (name.equalsIgnoreCase(BookClubAdoption.refname) || name.equalsIgnoreCase(BookClubAdoption.shortname))
					x.bookClubAdoptions = DU.addToList(x.bookClubAdoptions, BookClubAdoption.fromDoc(element));
			}
		});

		return x;
	}
}
