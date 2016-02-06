package com.tectonica.jonix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import com.tectonica.jonix.codelist.ContributorRoles;
import com.tectonica.jonix.codelist.ProductIdentifierTypes;
import com.tectonica.jonix.codelist.TitleTypes;
import com.tectonica.jonix.onix2.Contributor;
import com.tectonica.jonix.onix2.ContributorRole;
import com.tectonica.jonix.onix2.Product;
import com.tectonica.jonix.onix2.Series;
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
			// we pick the main ("distinctive") title of the book
			JonixTitle titleTag = product.findTitle(TitleTypes.Distinctive_title_book);
			if (titleTag != null)
			{
				if (fieldType == TextFields.Title)
					return titleTag.titleText;
				return titleTag.subtitle;
			}
			return null;

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
		}

		return null;
	}

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
		}

		return null;
	}

	public String getProductIdentifier(ProductIdentifierTypes idType)
	{
		JonixProductIdentifier productIdentifier = product.findProductIdentifier(idType);
		return (productIdentifier == null) ? null : productIdentifier.idValue;
	}

	public List<Contributor> findContributors(ContributorRoles... requestedRoles)
	{
		List<Contributor> result = new ArrayList<>();

		if (requestedRoles == null || requestedRoles.length == 0)
		{
			// even though the ONIX standard requires at least one contributor, we don't take chances here
			// and always return a non-null list
			return (product.contributors == null) ? result : product.contributors;
		}

		HashSet<ContributorRoles> rolesSet = new HashSet<>(Arrays.asList(requestedRoles));

		if (product.contributors != null)
		{
			boolean isSequenced = false;
			
			for (Contributor contributor : product.contributors)
			{
				if (!isSequenced)
					isSequenced = (contributor.sequenceNumber != null);
				for (ContributorRole role : contributor.contributorRoles)
				{
					if (rolesSet.contains(role.value))
						result.add(contributor);
				}
			}

			if (isSequenced)
				sortContributuresBySequence(result);
		}

		return result;
	}

	public static void sortContributuresBySequence(List<Contributor> contributors)
	{
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
					return Integer.MAX_VALUE;
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
					c.getNamesBeforeKeyValue(), c.getCorporateNameValue());
			result.add(displayName);
		}

		return result;
	}
}
