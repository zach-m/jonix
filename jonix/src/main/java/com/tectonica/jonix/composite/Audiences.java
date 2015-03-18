package com.tectonica.jonix.composite;

import java.io.Serializable;

import com.tectonica.jonix.JonixComposite;
import com.tectonica.jonix.JonixConsumer;
import com.tectonica.jonix.JonixUtils;
import com.tectonica.jonix.codelist.AudienceCodeTypes;
import com.tectonica.jonix.codelist.AudienceCodes;
import com.tectonica.jonix.resolve.JonixResolver;
import com.tectonica.jonix.resolve.ONIX;

public class Audiences extends JonixComposite<Audiences.Audience>
{
	private static final long serialVersionUID = -1304790143558457014L;

	public static class Audience implements Serializable
	{
		private static final long serialVersionUID = 17308752263205814L;
		
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
			String audienceCodeValueStr = (audienceCodeType == AudienceCodeTypes.ONIX_audience_codes) ? AudienceCodes.fromCode(audienceCodeValue).name()
					: audienceCodeValue;
			return String.format("Audience [%s/%s]: %s", audienceCodeTypeStr, audienceCodeTypeName, audienceCodeValueStr);
		}
	}

	@Override
	public JonixConsumer consume(Object o, Object parent, Object grandParent, JonixResolver resolver)
	{
		if (resolver.onixTypeOf(o) == ONIX.Audience)
		{
			String audienceCodeTypeCode = (String) JonixUtils.getProperty(o, resolver.onixPropOf(ONIX.AudienceCodeType), "value");
			String audienceCodeTypeName = (String) JonixUtils.getProperty(o, resolver.onixPropOf(ONIX.AudienceCodeTypeName), "value");
			String audienceCodeValue = (String) JonixUtils.getProperty(o, resolver.onixPropOf(ONIX.AudienceCodeValue), "value");
			add(new Audience(AudienceCodeTypes.fromCode(audienceCodeTypeCode), audienceCodeTypeName, audienceCodeValue));
			return this;
		}
		
		return null;
	}
}