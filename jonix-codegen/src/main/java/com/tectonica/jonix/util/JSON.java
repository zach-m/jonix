/*
 * Copyright (C) 2012 Zach Melamed
 * 
 * Latest version available online at https://github.com/zach-m/jonix
 * Contact me at zach@tectonica.co.il
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tectonica.jonix.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * add to your <code>pom.xml</code>:
 * 
 * <pre>
 * &lt;dependency&gt;
 *     &lt;groupId&gt;com.fasterxml.jackson.core&lt;/groupId&gt;
 *     &lt;artifactId&gt;jackson-databind&lt;/artifactId&gt;
 *     &lt;version&gt;2.3.2&lt;/version&gt;
 * &lt;/dependency&gt;
 * </pre>
 * 
 * @author Zach Melamed
 */
public class JSON
{
	private static ObjectMapper mapper = createPropsMapper(false);

	private static ObjectMapper createPropsMapper(boolean useProps)
	{
		ObjectMapper mapper = new ObjectMapper();

		if (useProps)
		{
			// limit to props only
			mapper.setVisibility(PropertyAccessor.FIELD, Visibility.NONE);
			mapper.setVisibility(PropertyAccessor.GETTER, Visibility.ANY);
			mapper.setVisibility(PropertyAccessor.SETTER, Visibility.ANY);
		}
		else
		{
			// limit to fields only
			mapper.setVisibility(PropertyAccessor.FIELD, Visibility.NON_PRIVATE);
			mapper.setVisibility(PropertyAccessor.GETTER, Visibility.PUBLIC_ONLY);
			mapper.setVisibility(PropertyAccessor.SETTER, Visibility.NONE);
		}

		// general configuration
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		mapper.setDateFormat(sdf);

		return mapper;
	}

	public static String toJson(Object o)
	{
		try
		{
			return mapper.writeValueAsString(o);
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}
