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

package com.tectonica.jonix.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tectonica.jonix.codelist.PublishingRoles;

@SuppressWarnings("serial")
public class BasicPublisher implements Serializable
{
	public final PublishingRoles publishingRole;
	public final String publisherName;

	public BasicPublisher(PublishingRoles publishingRole, String publisherName)
	{
		this.publishingRole = publishingRole;
		this.publisherName = publisherName;
	}

	@Override
	public String toString()
	{
		String publishingRoleStr = (publishingRole == null) ? null : publishingRole.name();
		return String.format("Publisher [%s]: %s", publishingRoleStr, publisherName);
	}

	public static List<BasicPublisher> extractFrom(com.tectonica.jonix.onix2.Product product)
	{
		if (product.publishers != null)
		{
			List<BasicPublisher> result = new ArrayList<>();
			for (com.tectonica.jonix.onix2.Publisher i : product.publishers)
				result.add(new BasicPublisher(i.getPublishingRoleValue(), i.getPublisherNameValue()));
			return result;
		}
		return Collections.emptyList();
	}

	public static List<BasicPublisher> extractFrom(com.tectonica.jonix.onix3.Product product)
	{
		if (product.publishingDetail.publishers != null)
		{
			List<BasicPublisher> result = new ArrayList<>();
			for (com.tectonica.jonix.onix3.Publisher i : product.publishingDetail.publishers)
				result.add(new BasicPublisher(i.getPublishingRoleValue(), i.getPublisherNameValue()));
			return result;
		}
		return Collections.emptyList();
	}
}