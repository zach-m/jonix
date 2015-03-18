package com.tectonica.jonix.composite;

import java.io.Serializable;

import com.tectonica.jonix.JonixComposite;
import com.tectonica.jonix.JonixConsumer;
import com.tectonica.jonix.JonixUtils;
import com.tectonica.jonix.codelist.PriceTypes;
import com.tectonica.jonix.resolve.JonixResolver;
import com.tectonica.jonix.resolve.ONIX;

public class Prices extends JonixComposite<Prices.Price>
{
	private static final long serialVersionUID = 6242415582912568146L;

	public static class Price implements Serializable
	{
		private static final long serialVersionUID = -9052458161852043224L;

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

	private transient Price activeItem;

	@Override
	public JonixConsumer consume(Object o, Object parent, Object grandParent, JonixResolver resolver)
	{
		if (resolver.onixTypeOf(o) == ONIX.Price)
		{
			add(activeItem = new Price());
			return this;
		}

		if (resolver.onixTypeOf(parent) == ONIX.Price)
		{
			switch (resolver.onixTypeOf(o))
			{
				case PriceTypeCode:
					activeItem.priceType = PriceTypes.fromCode(JonixUtils.getValueAsStr(o));
					break;

				case PriceAmount:
					activeItem.priceAmount = JonixUtils.getValueAsStr(o);
					break;

				case CurrencyCode:
					activeItem.currencyCode = (String) JonixUtils.getProperty(o, "value", "name()");
					break;

				default:
					break;
			}
		}

		return null;
	}
}
