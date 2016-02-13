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

package com.tectonica.jonix.codelist;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 224</b>
 * <p>
 * Description: Status detail type severity &lt;p&gt;NOTE: Introduced in Onix3
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum StatusDetailTypeSeveritys
{
	/**
	 * Use ONLY if the message severity cannot be determined (eg with a legacy system unable to provide detailed error
	 * codes)
	 */
	Unclassifiable("U"), //

	/**
	 * For information only, provided to encourage the ONIX data supplier to improve the quality of their data (eg
	 * provision of a non-mandatory data element that is currently missing, better conformity with best practice, etc)
	 */
	Info("I"), //

	/**
	 * Request for clarification or further detail of the meaning of the data provided
	 */
	Query("Q"), //

	/**
	 * The ONIX data has been accepted as provided, but there may be issues in the way it is supplied
	 */
	Warning("W"), //

	/**
	 * Some data in an ONIX data element or message structure caused an error due to not meeting the requirements of the
	 * standard. The data in question has been rejected, but processing of the remaining elements in the record (or the
	 * remain records in the message, if used within &lt;MessageStatusDetail&gt;) has continued
	 */
	Error("E"), //

	/**
	 * Some data in an ONIX data element or message structure caused an unrecoverable error due to not meeting the
	 * requirements of the standard. The entire ONIX record has been rejected (or the entire message, if used within
	 * &lt;MessageStatusDetail&gt;)
	 */
	Fatal_error("F");

	public final String value;

	private StatusDetailTypeSeveritys(String value)
	{
		this.value = value;
	}

	public static StatusDetailTypeSeveritys byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (StatusDetailTypeSeveritys e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
