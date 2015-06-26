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

package com.tectonica.jonix.onix3;

import java.io.Serializable;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixComposite.OnixDataComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixBatchBonus;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class BatchBonus implements OnixDataComposite, Serializable
{
	public static final String refname = "BatchBonus";
	public static final String shortname = "batchbonus";

	public String datestamp; // dt.DateOrDateTime
	public RecordSourceTypes sourcetype;
	public String sourcename;

	public BatchQuantity batchQuantity; // Required
	public FreeQuantity freeQuantity; // Required

	public BatchBonus()
	{}

	public BatchBonus(org.w3c.dom.Element element)
	{
		this.datestamp = JPU.getAttribute(element, "datestamp");
		this.sourcetype = RecordSourceTypes.byValue(JPU.getAttribute(element, "sourcetype"));
		this.sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, new JPU.ElementListener()
		{
			@Override
			public void onElement(org.w3c.dom.Element element)
			{
				final String name = element.getNodeName();
				if (name.equals(BatchQuantity.refname) || name.equals(BatchQuantity.shortname))
					batchQuantity = new BatchQuantity(element);
				else if (name.equals(FreeQuantity.refname) || name.equals(FreeQuantity.shortname))
					freeQuantity = new FreeQuantity(element);
			}
		});
	}

	public Integer getBatchQuantityValue()
	{
		return (batchQuantity == null) ? null : batchQuantity.value;
	}

	public Integer getFreeQuantityValue()
	{
		return (freeQuantity == null) ? null : freeQuantity.value;
	}

	public JonixBatchBonus asJonixBatchBonus()
	{
		JonixBatchBonus x = new JonixBatchBonus();
		x.batchQuantity = getBatchQuantityValue();
		x.freeQuantity = getFreeQuantityValue();
		return x;
	}
}
