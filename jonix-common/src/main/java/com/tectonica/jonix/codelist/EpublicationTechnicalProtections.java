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
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 144</b>
 * <p>
 * Description: E-publication technical protection
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist144">ONIX
 *      Codelist 144 in Reference Guide</a>
 */
public enum EpublicationTechnicalProtections
{
	/**
	 * Has no technical protection
	 */
	None("00", "None"), //

	/**
	 * Has DRM protection
	 */
	DRM("01", "DRM"), //

	/**
	 * Has digital watermarking
	 */
	Digital_watermarking("02", "Digital watermarking"), //

	/**
	 * Has DRM protection applied by the Adobe CS4 Content Server Package or by the Adobe ADEPT hosted service
	 */
	Adobe_DRM("03", "Adobe DRM"), //

	/**
	 * FairPlay&#8217; DRM protection applied via Apple proprietary online store
	 */
	Apple_DRM("04", "Apple DRM"), //

	/**
	 * Has OMA v2 DRM protection applied, as used to protect some mobile phone content
	 */
	OMA_DRM("05", "OMA DRM");

	public final String value;
	public final String label;

	private EpublicationTechnicalProtections(String value, String label)
	{
		this.value = value;
		this.label = label;
	}

	public static EpublicationTechnicalProtections byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		for (EpublicationTechnicalProtections e : values())
			if (e.value.equals(value))
				return e;
		return null;
	}
}
