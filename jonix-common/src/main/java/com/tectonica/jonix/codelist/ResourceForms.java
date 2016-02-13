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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 161</b>
 * <p>
 * Description: Resource form
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum ResourceForms
{
	/**
	 * A resource that may be accessed by a hyperlink. The current host (eg the ONIX sender, who may be the publisher)
	 * will provide ongoing hosting services for the resource for the active life of the product (or at least until the
	 * Until Date specified in &lt;ContentDate&gt;). The ONIX recipient may embed the URL in a consumer facing-website
	 * (eg as the src attribute in an &lt;img&gt; link), and need not host an independent copy of the resource
	 */
	Linkable_resource("01", "Linkable resource"), //

	/**
	 * A file that may be downloaded on demand for third-party use. The ONIX sender will host a copy of the resource
	 * until the specified Until Date, but only for the ONIX recipient&#8217;s direct use. The ONIX recipient should
	 * download a copy of the resource, and must host an independent copy of the resource if it is used on a
	 * consumer-facing website. Special attention should be paid to the &#8216;Last Updated&#8217; &lt;ContentDate&gt;
	 * to ensure the independent copy of the resource is kept up to date
	 */
	Downloadable_file("02", "Downloadable file"), //

	/**
	 * An application which is supplied in a form which can be embedded into a third-party webpage. As type 02, except
	 * the resource contains active content such as JavaScript, Flash, etc
	 */
	Embeddable_application("03", "Embeddable application");

	public final String value;
	public final String label;

	private ResourceForms(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	public static ResourceForms byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (ResourceForms e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
