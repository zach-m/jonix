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
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.RecordSourceTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <h1>Record reference</h1>
 * <p>
 * For every product, you must choose a single record reference which will uniquely identify the Information record
 * which you send out about that product, and which will remain as its permanent identifier every time you send an
 * update. It doesn’t matter what reference you choose, provided that it is unique and permanent. This record reference
 * doesn’t identify the <em>product</em> – even though you may choose to use the ISBN or another product identifier as a
 * part or the whole of your record reference – it identifies <em>your information record about the product</em>, so
 * that the person to whom you are sending an update can match it with what you have previously sent. A good way of
 * generating references which are not part of a recognized product identification scheme but which can be guaranteed to
 * be unique is to prefix a product identifier with a reversed Internet domain name which is registered to your
 * organization (reversal prevents the record reference appearing to be a resolvable URL).
 * </p>
 * <p>
 * This field is mandatory and non-repeating.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Format</td>
 * <td>Variable-length, alphanumeric, suggested maximum length 100 characters</td>
 * </tr>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;RecordReference&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;a001&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * <tr>
 * <td>Example</td>
 * <td>&lt;a001&gt;com.xyzpublishers.onix.9780001234567&lt;/a001&gt;</td>
 * </tr>
 * </table>
 */
public class RecordReference implements OnixElement, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "RecordReference";
	public static final String shortname = "a001";

	// ///////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	// ///////////////////////////////////////////////////////////////////////////////
	// VALUE MEMBER
	// ///////////////////////////////////////////////////////////////////////////////

	/**
	 * Raw Format: Variable-length, alphanumeric, suggested maximum length 100 characters
	 * <p>
	 * (type: dt.NonEmptyString)
	 */
	public String value;

	// ///////////////////////////////////////////////////////////////////////////////
	// SERVICES
	// ///////////////////////////////////////////////////////////////////////////////

	public RecordReference()
	{}

	public RecordReference(org.w3c.dom.Element element)
	{
		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		value = JPU.getContentAsString(element);
	}
}
