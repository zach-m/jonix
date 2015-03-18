package com.tectonica.jonix.composites;

import com.tectonica.jonix.codelists.AudienceCodeTypes;
import com.tectonica.jonix.codelists.AudienceCodeValues;

@SuppressWarnings("serial")
public class Audiences extends JonixBaseComposite<Audiences.Audience>
{
	public static class Audience
	{
		public final AudienceCodeTypes audienceCodeType;
		public final String audienceCodeTypeName;
		public final String audienceCodeValue;

		public Audience(AudienceCodeTypes audienceCodeType, String audienceCodeTypeName, String audienceCodeValue)
		{
			this.audienceCodeType = audienceCodeType;
			this.audienceCodeTypeName = audienceCodeTypeName;
			this.audienceCodeValue = audienceCodeValue;
		}

		@Override
		public String toString()
		{
			String audienceCodeTypeStr = (audienceCodeType == null) ? null : audienceCodeType.name();
			String audienceCodeValueStr = (audienceCodeType == AudienceCodeTypes.ONIX_audience_codes) ? AudienceCodeValues.fromCode(audienceCodeValue).name()
					: audienceCodeValue;
			return String.format("Audience [%s/%s]: %s", audienceCodeTypeStr, audienceCodeTypeName, audienceCodeValueStr);
		}
	}

	public void setNewItem(String audienceCodeTypeCode, String audienceCodeTypeName, String audienceCodeValue)
	{
		add(new Audience(AudienceCodeTypes.fromCode(audienceCodeTypeCode), audienceCodeTypeName, audienceCodeValue));
	}
}