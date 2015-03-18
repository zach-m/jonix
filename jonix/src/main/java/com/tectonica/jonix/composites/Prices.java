package com.tectonica.jonix.composites;

import com.tectonica.jonix.codelists.PriceTypes;

@SuppressWarnings("serial")
public class Prices extends JonixComposite<Prices.Price>
{
	public Prices()
	{
		super(Price.class);
	}
	
	public static class Price
	{
		public PriceTypes priceType;
		public String priceAmount;
		public String currencyCode;
		
		@Override
		public String toString()
		{
			String prictTypeStr = (priceType == null) ? null : priceType.name();
			return String.format("Price [%s]: %s %s", prictTypeStr, priceAmount, currencyCode);
		}
	}
}
