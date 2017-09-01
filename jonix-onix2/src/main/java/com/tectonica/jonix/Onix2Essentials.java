package com.tectonica.jonix;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.tectonica.jonix.codelist.AudienceRangePrecisions;
import com.tectonica.jonix.codelist.AudienceRangeQualifiers;
import com.tectonica.jonix.codelist.Audiences;
import com.tectonica.jonix.codelist.ContributorRoles;
import com.tectonica.jonix.codelist.CurrencyCodes;
import com.tectonica.jonix.codelist.LanguageRoles;
import com.tectonica.jonix.codelist.MeasureTypes;
import com.tectonica.jonix.codelist.MeasureUnits;
import com.tectonica.jonix.codelist.OtherTextTypes;
import com.tectonica.jonix.codelist.PriceTypes;
import com.tectonica.jonix.codelist.ProductFormFeatureTypes;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.PublishingRoles;
import com.tectonica.jonix.codelist.TextFormats;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.onix2.AudienceRange;
import com.tectonica.jonix.onix2.Contributor;
import com.tectonica.jonix.onix2.ContributorRole;
import com.tectonica.jonix.onix2.Measure;
import com.tectonica.jonix.onix2.OtherText;
import com.tectonica.jonix.onix2.Price;
import com.tectonica.jonix.onix2.Product;
import com.tectonica.jonix.onix2.Publisher;
import com.tectonica.jonix.onix2.Series;
import com.tectonica.jonix.onix2.SupplyDetail;
import com.tectonica.jonix.struct.JonixLanguage;
import com.tectonica.jonix.struct.JonixOtherText;
import com.tectonica.jonix.struct.JonixProductFormFeature;
import com.tectonica.jonix.struct.JonixProductIdentifier;
import com.tectonica.jonix.struct.JonixTitle;

public class Onix2Essentials implements JonixEssentials
{
	private final Product product;

	public Onix2Essentials(Product product)
	{
		this.product = product;
	}

	@Override
	public String get(TextFields fieldType)
	{
		switch (fieldType)
		{
		case Isbn13:
			return getProductIdentifier(ProductIdentifierTypes.ISBN_13);

		case Isbn10:
			return getProductIdentifier(ProductIdentifierTypes.ISBN_10);

		case UPC:
			return getProductIdentifier(ProductIdentifierTypes.UPC);

		case Title:
		case Subtitle:
			return getTitle(TitleTypes.Distinctive_title_book, fieldType == TextFields.Subtitle);

		case TitleInOriginalLanguage:
		case SubtitleInOriginalLanguage:
			return getTitle(TitleTypes.Title_in_original_language, fieldType == TextFields.SubtitleInOriginalLanguage);

		case TitleOfSeries:
		case NumberWithinSeries:
			List<Series> seriess = product.seriess();
			if (!seriess.isEmpty())
			{
				// we pick the first (and normally the only) series tag
				Series series = seriess.get(0);
				if (fieldType == TextFields.TitleOfSeries)
					return series.titleOfSeries().value;
				return series.numberWithinSeries().value;
			}
			return null;

		case Language:
			JonixLanguage languageTag = product.languages().findAsStructOrNull(LanguageRoles.Language_of_text);
			return (languageTag == null) ? null : languageTag.languageCode.description;

		case Audience:
			// we pick the first audience, as in practice it's very rare to see more than one
			Audiences audience = product.audienceCodes().firstValueOrNull();
			if (audience != null)
				return (audience == null) ? null : audience.description;

		case PackQuantity:
			if (!product.supplyDetails().isEmpty())
				return product.supplyDetails().get(0).packQuantity().value;
			return null;

		case Annotation:
			JonixOtherText annotationTag = findOtherText(product, OtherTextTypes.Main_description);
			if (annotationTag == null)
				annotationTag = findOtherText(product, OtherTextTypes.Long_description);
			return (annotationTag == null) ? null : annotationTag.text;

		case BackCover:
			JonixOtherText backCoverTag = findOtherText(product, OtherTextTypes.Back_cover_copy);
			return (backCoverTag == null) ? null : backCoverTag.text;

		case BiographicalNote:
			JonixOtherText bioTag = findOtherText(product, OtherTextTypes.Biographical_note);
			return (bioTag == null) ? null : bioTag.text;

		case Endorsement:
			JonixOtherText endorsementTag = findOtherText(product, OtherTextTypes.Unpublished_endorsement);
			return (endorsementTag == null) ? null : endorsementTag.text;

		case NumOfPages:
			return product.numberOfPages().value;

		case ShippingWeightLB:
			List<Measure> weight = product.measures().find(MeasureTypes.Unit_weight);
			if (!weight.isEmpty())
			{
				if (weight.get(0).measureUnitCode().value == MeasureUnits.Ounces_US)
				{
					Double oz = JPU.convertStringToDouble(weight.get(0).measurement().value);
					return String.valueOf(oz * 0.0625);
				}
				else
					return weight.get(0).measurement().value; // presumably, in Pounds_US
			}
			return null;

		case FontSize:
			JonixProductFormFeature textFontTag = product.productFormFeatures()
					.findAsStructOrNull(ProductFormFeatureTypes.Text_font);
			if (textFontTag != null && textFontTag.productFormFeatureDescriptions != null)
				return textFontTag.productFormFeatureDescriptions.get(0);
			return null;

		case Publisher:
			Publisher candidatePublisher = null;
			for (Publisher publisher : product.publishers())
			{
				// first we look for the main publisher by its role
				PublishingRoles role = publisher.publishingRole().value;
				if (role == PublishingRoles.Publisher)
					return publisher.publisherName().value;
				if (role == null && candidatePublisher == null)
					candidatePublisher = publisher;
			}
			// if no designated publisher found, we return the first un-designated
			if (candidatePublisher != null)
				return candidatePublisher.publisherName().value;
			return null;

		case UsdRetailPriceIncTax:
		case UsdRetailPriceExcTax:
			boolean includingTax = (fieldType == TextFields.UsdRetailPriceIncTax);
			return getRetailPrice(CurrencyCodes.US_Dollar, includingTax);
		}

		return null;
	}

	/**
	 * NOTE: never returns a null, only empty lists
	 */
	@Override
	public List<String> get(ListFields fieldType)
	{
		switch (fieldType)
		{
		case Contributors:
			return getContributors();

		case Authors:
			return getContributors(ContributorRoles.By_author);

		case Editors:
			return getContributors(ContributorRoles.Edited_by);

		case AudienceAgeRange:
			Integer[] ageRange = getAudienceAgeRange();
			return Arrays
					.asList(new String[]
					{ ageRange[0] == null ? null : ageRange[0].toString(),
							ageRange[1] == null ? null : ageRange[1].toString() });

		case Measurements:
			List<String> wht = new ArrayList<>();
			List<Measure> widthHeight = product.measures().find(MeasureTypes.Width, MeasureTypes.Height);
			if (widthHeight.size() == 2)
			{
				String mv0 = widthHeight.get(0).measurement().value;
				String mv1 = widthHeight.get(1).measurement().value;
				boolean mv0IsWidth = (widthHeight.get(0).measureTypeCode().value == MeasureTypes.Width);
				wht.add(mv0IsWidth ? mv0 : mv1);
				wht.add(mv0IsWidth ? mv1 : mv0);

				List<Measure> thickness = product.measures().find(MeasureTypes.Thickness);
				if (!thickness.isEmpty())
					wht.add(thickness.get(0).measurement().value);
			}
			return wht;
		}

		return null;
	}

	private String getRetailPrice(CurrencyCodes currency, boolean includingTax)
	{
		if (!product.supplyDetails().isEmpty())
		{
			SupplyDetail supplyDetail = product.supplyDetails().get(0);
			for (Price price : supplyDetail.prices())
			{
				PriceTypes type = price.priceTypeCode().value;
				boolean correctType = (includingTax && type == PriceTypes.RRP_including_tax)
						|| (!includingTax && type == PriceTypes.RRP_excluding_tax);
				if (correctType && (price.currencyCode().value == currency))
					return price.priceAmount().value;
			}
		}
		return null;
	}

	public String getProductIdentifier(ProductIdentifierTypes idType)
	{
		JonixProductIdentifier productIdentifier = product.productIdentifiers().findAsStructOrNull(idType);
		return (productIdentifier == null) ? null : productIdentifier.idValue;
	}

	private String getTitle(TitleTypes titleType, boolean returnSubtitle)
	{
		JonixTitle titleTag = product.titles().findAsStructOrNull(titleType);
		if (titleTag != null)
		{
			if (returnSubtitle)
				return titleTag.subtitle;
			return titleTag.titleText;
		}
		return null;
	}

	public List<Contributor> findContributors(ContributorRoles... requestedRoles)
	{
		List<Contributor> result = new ArrayList<>();

		if (requestedRoles == null || requestedRoles.length == 0)
		{
			// if no filtering by role is required, we take all contributors and avoid unnecessary search
			// copying is needed so that consequent sorting won't affect the original
			result.addAll(product.contributors());
		}
		else
		{
			// we perform a search according to the roles filter
			Set<ContributorRoles> rolesSet = JonixUtil.setOf(requestedRoles);
			for (Contributor contributor : product.contributors())
			{
				for (ContributorRole role : contributor.contributorRoles())
				{
					if (rolesSet.contains(role.value))
						result.add(contributor);
				}
			}
		}

		sortContributuresBySequence(result);

		return result;
	}

	public static void sortContributuresBySequence(List<Contributor> contributors)
	{
		// run a quick test to see if the list is at all sequenced. If it is, then this loop should really stop after
		// one iteration. The only reason to run a loop (rather than examining the first item) is that we want to
		// support a hybrid, ill-posed sequencing, where only SOME of the items are sequenced
		boolean isSequenced = false;
		for (Contributor contributor : contributors)
		{
			if (contributor.sequenceNumber().exists())
			{
				isSequenced = true;
				break;
			}
		}

		if (!isSequenced)
			return;

		Collections.sort(contributors, new Comparator<Contributor>()
		{
			@Override
			public int compare(Contributor o1, Contributor o2)
			{
				return Integer.compare(toInt(o1.sequenceNumber().value), toInt(o2.sequenceNumber().value));
			}

			private int toInt(String s1)
			{
				try
				{
					return Integer.parseInt(s1);
				}
				catch (NumberFormatException nfe)
				{
					return Integer.MAX_VALUE; // i.e. unsequenced items in an hybrid list go to the end
				}
			}
		});
	}

	public List<String> getContributors(ContributorRoles... requestedRoles)
	{
		List<String> result = new ArrayList<>();

		for (Contributor c : findContributors(requestedRoles))
		{
			String displayName = JonixUtil.contributorDisplayName(c.personName().value, c.keyNames().value,
					c.namesBeforeKey().value, c.personNameInverted().value, c.corporateName().value);
			result.add(displayName);
		}

		return result;
	}

	public static String[] getContributorNameParts(Contributor contributor)
	{
		String inverted = contributor.personNameInverted().value;
		if (inverted != null)
		{
			String[] splits = inverted.split(",");
			String[] names = new String[splits.length];
			for (int i = 0; i < splits.length; i++)
				names[i] = splits[splits.length - 1 - i].trim();
			return names;
		}

		String straight = contributor.personName().value;
		if (straight != null)
		{
			String[] names = straight.split(" ");
			for (int i = 0; i < names.length; i++)
				names[i] = names[i].trim();
			return names;
		}

		return new String[0];
	}

	public Integer[] getAudienceAgeRange()
	{
		Integer[] ageRange = new Integer[] { null, null };
		if (!product.audienceRanges().isEmpty())
		{
			AudienceRange audienceRange = product.audienceRanges().get(0);
			AudienceRangeQualifiers qualifier = audienceRange.audienceRangeQualifier().value;
			if (qualifier == AudienceRangeQualifiers.Interest_age_years)
			{
				List<AudienceRangePrecisions> precisions = audienceRange.audienceRangePrecisions().values();
				List<String> values = audienceRange.audienceRangeValues().values();
				if (precisions.size() != values.size())
				{
					// TODO: invalid ONIX
				}
				else
				{
					for (int i = 0; i < precisions.size(); i++)
					{
						Integer value = Integer.valueOf(values.get(i));
						switch (precisions.get(i))
						{
						case From:
							ageRange[0] = value;
							break;

						case To:
							ageRange[1] = value;
							break;

						case Exact:
							ageRange[0] = value;
							ageRange[1] = value;
							break;
						}
					}
				}
			}
		}
		return ageRange;
	}

	public JonixOtherText findOtherText(Product product, OtherTextTypes textTypeCode)
	{
		for (OtherText x : product.otherTexts())
		{
			if (x.textTypeCode().value == textTypeCode)
			{
				JonixOtherText jonixOtherText = x.asStruct();
				if ((jonixOtherText.textFormat == null) && (x.text().exists()))
				{
					jonixOtherText.textFormat = x.text().textformat;
					if ((jonixOtherText.textFormat == TextFormats.XHTML)
							|| (jonixOtherText.textFormat == TextFormats.XML)
							|| (jonixOtherText.textFormat == TextFormats.HTML))
					{
						try
						{
							jonixOtherText.text = unescape(jonixOtherText.text);
						}
						catch (XMLStreamException e)
						{
							// ignore
						}
					}
				}
				return jonixOtherText;
			}
		}
		return null;
	}

	private static final XMLInputFactory inputFactory;

	static
	{
		inputFactory = XMLInputFactory.newInstance();

		// no need to validate, or even try to access, the remote DTD file
		inputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, Boolean.FALSE);

		// no need to validate internal entities - this is important because ONIX files are designed to contain HTML
		// sections inside them. these sections may include entities (such as '&nbsp;') that aren't XML-compatible
		inputFactory.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, false);
	}

	public static String unescape(String escaped) throws XMLStreamException
	{
		XMLStreamReader reader = inputFactory.createXMLStreamReader(new StringReader("<xml>" + escaped + "</xml>"));
		StringWriter sw = new StringWriter(escaped.length());
		while (reader.hasNext())
		{
			reader.next();
			if (reader.hasText())
				sw.append(reader.getText());
		}
		return sw.toString();
	}

//	public static void main(String[] args) throws XMLStreamException
//	{
//		String escaped = "&lt;p&gt;&lt;strong&gt;Lydia Brownback&lt;/strong&gt; (MAR, Westminster Theological Seminary) is the author of several books and a speaker at women&amp;rsquo;s conferences internationally. When time allows, Lydia blogs at lydiabrownback.com. She has served as director of editorial for Crossway&amp;rsquo;s Book Division; writer-in-residence for Reverend Alistair Begg; and broadcast media manager for Alliance of Confessing Evangelicals, where she produced&amp;nbsp;&lt;em&gt;The Bible Study Hour&lt;/em&gt;&amp;nbsp;radio program with James Montgomery Boice. Some of Lydia's books include the On-the-Go Devotional series as well as&amp;nbsp;&lt;em&gt;A Woman's Wisdom: How the Book of Proverbs Speaks to Everything&lt;/em&gt;.&lt;/p&gt;";
//		String unescaped = unescape(escaped);
//		System.out.println(unescaped);
//		unescaped = unescape(unescaped);
//		System.out.println(unescaped);
//	}
}
