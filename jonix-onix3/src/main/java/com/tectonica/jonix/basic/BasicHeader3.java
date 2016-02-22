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

import java.util.ArrayList;
import java.util.List;

import com.tectonica.jonix.basic.BasicHeader;
import com.tectonica.jonix.onix3.Addressee;
import com.tectonica.jonix.onix3.Header;

/**
 * ONIX3 concrete implementation for {@link BasicHeader}
 * 
 * @author Zach Melamed
 */
public class BasicHeader3 extends BasicHeader
{
	private static final long serialVersionUID = 1L;

	public BasicHeader3(Header header)
	{
		fromCompany = header.sender.getSenderNameValue();
		fromPerson = header.sender.getContactNameValue();
		fromEmail = header.sender.getEmailAddressValue();
		toCompanies = extractToCompanies(header);
		sentDate = header.getSentDateTimeValue();
	}

	private List<String> extractToCompanies(Header header)
	{
		List<String> list = new ArrayList<>();
		if (header.addressees != null)
		{
			for (Addressee addressee : header.addressees)
			{
				String toCompany = addressee.getAddresseeNameValue();
				if (toCompany != null)
					list.add(toCompany);
			}
		}
		return list.size() > 0 ? list : null;
	}
}
