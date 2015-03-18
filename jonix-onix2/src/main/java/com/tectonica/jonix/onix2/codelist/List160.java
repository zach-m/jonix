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

package com.tectonica.jonix.onix2.codelist;

/**
 * Resource feature type
 */
public enum List160
{
	/**
	 * Credit that must be displayed when a resource is used (eg ‘Photo Jerry Bauer’ or ‘© Magnum Photo’). Credit text should be carried in
	 * <FeatureNote>.
	 */
	Required_credit("01"), //

	/**
	 * Explanatory caption that may accompany a resource (eg use to identify an author in a photograph). Caption text should be carried in
	 * <FeatureNote>.
	 */
	Caption("02"), //

	/**
	 * Copyright holder of resource (indicative only, as the resource can be used without consultation). Copyright text should be carried in
	 * <FeatureNote>.
	 */
	Copyright_holder("03"), //

	/**
	 * Approximate length in minutes of an audio or video resource. <FeatureValue> should contain the length of time as an integer number of
	 * minutes.
	 */
	Length_in_minutes("04"), //

	/**
	 * Use to link resource to a contributor unambiguously, for example with Resource Content types 04, 11–14 from List 158, particularly
	 * where the product has more than a single contributor. <FeatureValue> contains the 16-digit ISNI.
	 */
	ISNI_of_resource_contributor("05");

	public final String value;

	private List160(String value)
	{
		this.value = value;
	}

	public static List160 byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (List160 e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
