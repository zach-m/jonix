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

import com.tectonica.jonix.codelist.TitleElementLevels;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT IT
 */

@SuppressWarnings("serial")
public class JonixTitleElement implements Serializable
{
	public Integer sequenceNumber; // dt.StrictPositiveInteger
	public TitleElementLevels titleElementLevel;
	public String partNumber; // dt.NonEmptyString
	public String yearOfAnnual; // dt.YearOrYearRange
	public String titlePrefix; // dt.NonEmptyString
	public boolean isNoPrefix; // optional flag
	public String titleWithoutPrefix; // dt.NonEmptyString
	public String titleText; // dt.NonEmptyString
	public String subtitle; // dt.NonEmptyString
}
