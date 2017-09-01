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
import com.tectonica.jonix.ListOfOnixDataComposite;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixTitleElement;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Title detail composite</h1>
 * <p>
 * A repeatable group of data elements which together give the text of a title of a content item and specify its type.
 * Optional.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td>&lt;TitleDetail&gt;</td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td>&lt;titledetail&gt;</td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>0&#8230;n</td>
 * </tr>
 * </table>
 */
public class TitleDetail implements OnixSuperComposite, Serializable
{
	private static final long serialVersionUID = 1L;

	public static final String refname = "TitleDetail";
	public static final String shortname = "titledetail";

	/////////////////////////////////////////////////////////////////////////////////
	// ATTRIBUTES
	/////////////////////////////////////////////////////////////////////////////////

	/**
	 * (type: dt.DateOrDateTime)
	 */
	public String datestamp;

	public RecordSourceTypes sourcetype;

	public String sourcename;

	/////////////////////////////////////////////////////////////////////////////////
	// CONSTRUCTION
	/////////////////////////////////////////////////////////////////////////////////

	private boolean initialized;
	private final boolean exists;
	private final org.w3c.dom.Element element;
	public static final TitleDetail EMPTY = new TitleDetail();

	public TitleDetail()
	{
		exists = false;
		element = null;
		initialized = true; // so that no further processing will be done on this intentionally-empty object
	}

	public TitleDetail(org.w3c.dom.Element element)
	{
		exists = true;
		initialized = false;
		this.element = element;
	}

	private void initialize()
	{
		if (initialized)
			return;
		initialized = true;

		datestamp = JPU.getAttribute(element, "datestamp");
		sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
		sourcename = JPU.getAttribute(element, "sourcename");

		JPU.forElementsOf(element, e -> {
			final String name = e.getNodeName();
			if (name.equals(TitleType.refname) || name.equals(TitleType.shortname))
				titleType = new TitleType(e);
			else if (name.equals(TitleElement.refname) || name.equals(TitleElement.shortname))
				titleElements = JPU.addToList(titleElements, new TitleElement(e));
			else if (name.equals(TitleStatement.refname) || name.equals(TitleStatement.shortname))
				titleStatement = new TitleStatement(e);
		});
	}

	@Override
	public boolean exists()
	{
		return exists;
	}

	/////////////////////////////////////////////////////////////////////////////////
	// MEMBERS
	/////////////////////////////////////////////////////////////////////////////////

	private TitleType titleType = TitleType.EMPTY;

	/**
	 * (this field is required)
	 */
	public TitleType titleType()
	{
		initialize();
		return titleType;
	}

	private ListOfOnixDataComposite<TitleElement, JonixTitleElement> titleElements = ListOfOnixDataComposite.empty();

	/**
	 * (this list is required to contain at least one item)
	 */
	public ListOfOnixDataComposite<TitleElement, JonixTitleElement> titleElements()
	{
		initialize();
		return titleElements;
	}

	private TitleStatement titleStatement = TitleStatement.EMPTY;

	/**
	 * (this field is optional)
	 */
	public TitleStatement titleStatement()
	{
		initialize();
		return titleStatement;
	}
}
