package com.tectonica.jonix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.onix2.AudienceRange;
import com.tectonica.jonix.onix2.Contributor;
import com.tectonica.jonix.onix2.ContributorRole;
import com.tectonica.jonix.onix2.Measure;
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
			List<Series> seriess = product.seriess;
			if (seriess != null && seriess.size() > 0)
			{
				// we pick the first (and normally the only) series tag
				Series series = seriess.get(0);
				if (fieldType == TextFields.TitleOfSeries)
					return series.getTitleOfSeriesValue();
				return series.getNumberWithinSeriesValue();
			}
			return null;

		case Language:
			JonixLanguage languageTag = product.findLanguage(LanguageRoles.Language_of_text);
			return (languageTag == null) ? null : languageTag.languageCode.description;

		case Audience:
			List<Audiences> audiences = product.getAudienceCodeValues();
			if (audiences != null && !audiences.isEmpty())
			{
				// we pick the first audience, as in practice it's very rare to see more than one
				return audiences.get(0).description;
			}
			return null;

		case PackQuantity:
			if (product.supplyDetails != null)
			{
				SupplyDetail supplyDetail = product.supplyDetails.get(0);
				return supplyDetail.getPackQuantityValue();
			}
			return null;

		case Annotation:
			JonixOtherText annotationTag = product.findOtherText(OtherTextTypes.Main_description);
			if (annotationTag == null)
				annotationTag = product.findOtherText(OtherTextTypes.Long_description);
			return (annotationTag == null) ? null : annotationTag.text;

		case BackCover:
			JonixOtherText backCoverTag = product.findOtherText(OtherTextTypes.Back_cover_copy);
			return (backCoverTag == null) ? null : backCoverTag.text;

		case BiographicalNote:
			JonixOtherText bioTag = product.findOtherText(OtherTextTypes.Biographical_note);
			return (bioTag == null) ? null : bioTag.text;

		case Endorsement:
			JonixOtherText endorsementTag = product.findOtherText(OtherTextTypes.Unpublished_endorsement);
			return (endorsementTag == null) ? null : endorsementTag.text;

		case NumOfPages:
			return product.getNumberOfPagesValue();

		case ShippingWeightLB:
			List<Measure> weight = findMeasures(product.measures, MeasureTypes.Unit_weight);
			if (!weight.isEmpty())
			{
				if (weight.get(0).getMeasureUnitCodeValue() == MeasureUnits.Ounces_US)
				{
					Double oz = JPU.convertStringToDouble(weight.get(0).getMeasurementValue());
					return String.valueOf(oz * 0.0625);
				}
				else
					return weight.get(0).getMeasurementValue(); // presumably, in Pounds_US
			}
			return null;

		case FontSize:
			JonixProductFormFeature textFontTag = product.findProductFormFeature(ProductFormFeatureTypes.Text_font);
			if (textFontTag != null && textFontTag.productFormFeatureDescriptions != null)
				return textFontTag.productFormFeatureDescriptions.get(0);
			return null;

		case Publisher:
			if (product.publishers != null)
			{
				Publisher candidatePublisher = null;
				// first we look for the main publisher by its role
				for (Publisher publisher : product.publishers)
				{
					PublishingRoles role = publisher.getPublishingRoleValue();
					if (role == PublishingRoles.Publisher)
						return publisher.getPublisherNameValue();
					if (role == null && candidatePublisher == null)
						candidatePublisher = publisher;
				}
				// if no designated publisher found, we return the first un-designated
				if (candidatePublisher != null)
					return candidatePublisher.getPublisherNameValue();
			}
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
			return Arrays.asList(new String[] { ageRange[0] == null ? null : ageRange[0].toString(),
					ageRange[1] == null ? null : ageRange[1].toString() });

		case Measurements:
			List<String> wht = new ArrayList<>();
			List<Measure> widthHeight = findMeasures(product.measures, MeasureTypes.Width, MeasureTypes.Height);
			if (widthHeight.size() == 2)
			{
				String mv0 = widthHeight.get(0).getMeasurementValue();
				String mv1 = widthHeight.get(1).getMeasurementValue();
				boolean mv0IsWidth = (widthHeight.get(0).getMeasureTypeCodeValue() == MeasureTypes.Width);
				wht.add(mv0IsWidth ? mv0 : mv1);
				wht.add(mv0IsWidth ? mv1 : mv0);

				List<Measure> thickness = findMeasures(product.measures, MeasureTypes.Thickness);
				if (!thickness.isEmpty())
				{
					wht.add(thickness.get(0).getMeasurementValue());
				}
			}
			return wht;
		}

		return null;
	}

	public List<Measure> findMeasures(List<Measure> measures, MeasureTypes... measureTypeCodes)
	{
		List<Measure> matches = new ArrayList<>();
		if (measures != null)
		{
			Set<MeasureTypes> measureTypeCodesSet = JonixUtil.setOf(measureTypeCodes);
			for (Measure x : measures)
			{
				if (measureTypeCodes == null || measureTypeCodesSet.contains(x.getMeasureTypeCodeValue()))
					matches.add(x);
			}
		}
		return matches;
	}

	private String getRetailPrice(CurrencyCodes currency, boolean includingTax)
	{
		if (product.supplyDetails != null)
		{
			SupplyDetail supplyDetail = product.supplyDetails.get(0);
			if (supplyDetail.prices != null)
			{
				for (Price price : supplyDetail.prices)
				{
					PriceTypes type = price.getPriceTypeCodeValue();
					boolean correctType = (includingTax && type == PriceTypes.RRP_including_tax)
							|| (!includingTax && type == PriceTypes.RRP_excluding_tax);
					if (correctType && (price.getCurrencyCodeValue() == currency))
						return price.getPriceAmountValue();
				}
			}
		}
		return null;
	}

	public String getProductIdentifier(ProductIdentifierTypes idType)
	{
		JonixProductIdentifier productIdentifier = product.findProductIdentifier(idType);
		return (productIdentifier == null) ? null : productIdentifier.idValue;
	}

	private String getTitle(TitleTypes titleType, boolean returnSubtitle)
	{
		JonixTitle titleTag = product.findTitle(titleType);
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
			if (product.contributors != null) // safety only. the ONIX standard requires at least one contributor
			{
				// copying is needed so that consequent sorting won't affect the original
				result = new ArrayList<>(product.contributors);
			}
		}
		else
		{
			// we perform a search according to the roles filter
			HashSet<ContributorRoles> rolesSet = new HashSet<>(Arrays.asList(requestedRoles));
			if (product.contributors != null)
			{
				for (Contributor contributor : product.contributors)
				{
					for (ContributorRole role : contributor.contributorRoles)
					{
						if (rolesSet.contains(role.value))
							result.add(contributor);
					}
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
			if (contributor.sequenceNumber != null)
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
				return Integer.compare(toInt(o1.getSequenceNumberValue()), toInt(o2.getSequenceNumberValue()));
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
			String displayName = JonixUtil.contributorDisplayName(c.getPersonNameValue(), c.getKeyNamesValue(),
					c.getNamesBeforeKeyValue(), c.getPersonNameInvertedValue(), c.getCorporateNameValue());
			result.add(displayName);
		}

		return result;
	}

	public static String[] getContributorNameParts(Contributor contributor)
	{
		String inverted = contributor.getPersonNameInvertedValue();
		if (inverted != null)
		{
			String[] splits = inverted.split(",");
			String[] names = new String[splits.length];
			for (int i = 0; i < splits.length; i++)
				names[i] = splits[splits.length - 1 - i].trim();
			return names;
		}

		String straight = contributor.getPersonNameValue();
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
		if (product.audienceRanges != null)
		{
			AudienceRange audienceRange = product.audienceRanges.get(0);
			AudienceRangeQualifiers qualifier = audienceRange.getAudienceRangeQualifierValue();
			if (qualifier == AudienceRangeQualifiers.Interest_age_years)
			{
				List<AudienceRangePrecisions> precisions = audienceRange.getAudienceRangePrecisionValues();
				List<String> values = audienceRange.getAudienceRangeValueValues();
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
}
