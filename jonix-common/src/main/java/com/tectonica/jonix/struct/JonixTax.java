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

package com.tectonica.jonix.struct;

import java.io.Serializable;

import com.tectonica.jonix.codelist.TaxRateCodeds;
import com.tectonica.jonix.codelist.TaxTypes;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

@SuppressWarnings("serial")
public class JonixTax implements Serializable
{
	public TaxTypes taxType;

	public TaxRateCodeds taxRateCode;

	/**
	 * Raw Format: Variable length real number, with an explicit decimal point where required
	 * <p>
	 * (type: dt.PercentDecimal)
	 */
	public Double taxRatePercent;

	/**
	 * Raw Format: Variable length real number, with explicit decimal point when required, suggested maximum length 12
	 * characters
	 * <p>
	 * (type: dt.StrictPositiveDecimal)
	 */
	public Double taxableAmount;

	/**
	 * Raw Format: Variable length real number, with explicit decimal point when required, suggested maximum length 12
	 * characters
	 * <p>
	 * (type: dt.PositiveDecimal)
	 */
	public Double taxAmount;
}
