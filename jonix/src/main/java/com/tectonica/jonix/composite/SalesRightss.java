package com.tectonica.jonix.composite;

import java.io.Serializable;
import java.util.List;

import com.tectonica.jonix.JonixComposite;
import com.tectonica.jonix.JonixConsumer;
import com.tectonica.jonix.JonixUtils;
import com.tectonica.jonix.codelist.SalesRightsTypes;
import com.tectonica.jonix.resolve.JonixResolver;
import com.tectonica.jonix.resolve.ONIX;

public class SalesRightss extends JonixComposite<SalesRightss.SalesRights>
{
	private static final long serialVersionUID = 5407905354256998238L;

	public static class SalesRights implements Serializable
	{
		private static final long serialVersionUID = 5875193742978687813L;

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

	private transient SalesRights activeItem;

	@Override
	public JonixConsumer consume(Object o, Object parent, Object grandParent, JonixResolver resolver)
	{
		if (resolver.onixTypeOf(o) == ONIX.SalesRights)
		{
			add(activeItem = new SalesRights());
			return this;
		}

		if (resolver.onixTypeOf(parent) == ONIX.SalesRights)
		{
			switch (resolver.onixTypeOf(o))
			{
				case SalesRightsType:
					activeItem.salesRightsType = SalesRightsTypes.fromCode(JonixUtils.getValueAsStr(o));
					break;

				case RightsTerritory:
					activeItem.rightsTerritories = JonixUtils.enumValueToStringArray(o, true);
					break;

				case RightsCountry:
					activeItem.rightsCountries = JonixUtils.enumValueToStringArray(o, false);
					break;

				case RightsRegion:
					activeItem.rightsRegion = JonixUtils.getValueAsStr(o);
					break;

				default:
					break;
			}
		}

		return null;
	}
}
