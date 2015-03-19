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
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

/**
 * E-publication version number
 */
public enum EpublicationVersionNumbers
{
	/**
	 * Use only with <ProductFormDetail> codes E101 or E102.
	 */
	EPUB_2_0_1("101A"), //

	/**
	 * Use only with <ProductFormDetail> code E101.
	 */
	EPUB_3_0("101B"), //

	/**
	 * Use only with <ProductFormDetail> code E101.
	 */
	EPUB_3_0_1("101C"), //

	/**
	 * Use only with <ProductFormDetail> codes E116 or E127.
	 */
	Kindle_mobi_7("116A"), //

	/**
	 * Use only with <ProductFormDetail> code E116.
	 */
	Kindle_KF8("116B");

	public final String value;

	private EpublicationVersionNumbers(String value)
	{
		this.value = value;
	}

	public static EpublicationVersionNumbers byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (EpublicationVersionNumbers e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
