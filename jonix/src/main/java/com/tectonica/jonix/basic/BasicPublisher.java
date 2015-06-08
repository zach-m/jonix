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

import com.tectonica.jonix.codelist.PublishingRoles;

/**
 * Contains the essential information included in ONIX &lt;Publisher&gt;
 * <p>
 * NOTE: to access the information, read the (public final) fields directly. No getters() are included..
 * <p>
 * May be constructed from either a {@link com.tectonica.jonix.onix2.Publisher} or a
 * {@link com.tectonica.jonix.onix3.Publisher}.
 * 
 * @author Zach Melamed
 */
public class BasicPublisher implements Serializable
{
	private static final long serialVersionUID = 1L;

	public final PublishingRoles publishingRole;
	public final String publisherName;

	public BasicPublisher(com.tectonica.jonix.onix2.Publisher i)
	{
		publishingRole = i.getPublishingRoleValue();
		publisherName = i.getPublisherNameValue();
	}

	public BasicPublisher(com.tectonica.jonix.onix3.Publisher i)
	{
		publishingRole = i.getPublishingRoleValue();
		publisherName = i.getPublisherNameValue();
	}
}