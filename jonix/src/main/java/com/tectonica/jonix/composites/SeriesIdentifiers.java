package com.tectonica.jonix.composites;

import com.tectonica.jonix.codelists.SeriesIDTypes;

@SuppressWarnings("serial")
public class SeriesIdentifiers extends JonixBaseComposite<SeriesIdentifiers.SeriesIdentifier>
{
	public static class SeriesIdentifier
	{
		public final SeriesIDTypes seriesIDType;
		public final String idTypeName;
		public final String idValue;

		public SeriesIdentifier(SeriesIDTypes seriesIDType, String idTypeName, String idValue)
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

	public void setNewItem(String seriesIDTypeCode, String idTypeName, String idValue)
	{
		add(new SeriesIdentifier(SeriesIDTypes.fromCode(seriesIDTypeCode), idTypeName, idValue));
	}
}
