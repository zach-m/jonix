package com.tectonica.jonix.composite;

import java.io.Serializable;

import com.tectonica.jonix.JonixComposite;
import com.tectonica.jonix.JonixConsumer;
import com.tectonica.jonix.JonixUtils;
import com.tectonica.jonix.codelist.SeriesIdTypes;
import com.tectonica.jonix.resolve.JonixResolver;
import com.tectonica.jonix.resolve.ONIX;

public class SeriesIdentifiers extends JonixComposite<SeriesIdentifiers.SeriesIdentifier>
{
	private static final long serialVersionUID = -4320979047077731665L;

	public static class SeriesIdentifier implements Serializable
	{
		private static final long serialVersionUID = -6655540999966337426L;
		
		public final SeriesIdTypes seriesIDType;
		public final String idTypeName;
		public final String idValue;

		public SeriesIdentifier(SeriesIdTypes seriesIDType, String idTypeName, String idValue)
		{
			this.seriesIDType = seriesIDType;
			this.idTypeName = idTypeName;
			this.idValue = idValue;
		}

		@Override
		public String toString()
		{
			return String.format("SeriesIdentifier [%s/%s]: %s", (seriesIDType == null) ? null : seriesIDType.name(), idTypeName, idValue);
		}
	}

	@Override
	public JonixConsumer consume(Object o, Object parent, Object grandParent, JonixResolver resolver)
	{
		if (resolver.onixTypeOf(o) == ONIX.SeriesIdentifier)
		{
			String seriesIDTypeCode = (String) JonixUtils.getProperty(o, resolver.onixPropOf(ONIX.SeriesIDType), "value");
			String idTypeName = (String) JonixUtils.getProperty(o, resolver.onixPropOf(ONIX.IDTypeName), "value");
			String idValue = (String) JonixUtils.getProperty(o, resolver.onixPropOf(ONIX.IDValue), "value");
			add(new SeriesIdentifier(SeriesIdTypes.fromCode(seriesIDTypeCode), idTypeName, idValue));
			return this;
		}
		
		return null;
	}
}
