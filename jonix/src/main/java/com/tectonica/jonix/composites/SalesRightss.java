package com.tectonica.jonix.composites;

import java.util.List;

import com.tectonica.jonix.codelists.SalesRightsTypes;

@SuppressWarnings("serial")
public class SalesRightss extends JonixComposite<SalesRightss.SalesRights>
{
	public SalesRightss()
	{
		super(SalesRights.class);
	}

	public static class SalesRights
	{
		public SalesRightsTypes salesRightsType;
		public List<String> rightsTerritories;
		public List<String> rightsCountries;
		public String rightsRegion;

		@Override
		public String toString()
		{
			StringBuilder sb = new StringBuilder();
			String salesRightsTypeStr = (salesRightsType == null) ? null : salesRightsType.name();
			sb.append("SalesRights [").append(salesRightsTypeStr).append("]:");
			if (rightsTerritories != null)
				sb.append("\n    > Territories: ").append(rightsTerritories.toString());
			if (rightsCountries != null)
				sb.append("\n    > Countries: ").append(rightsCountries.toString());
			if (rightsRegion != null)
				sb.append("\n    > Regions: ").append(rightsRegion.toString());
			return sb.toString();
		}
	}
}
