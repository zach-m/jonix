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

package com.tectonica.jonix.basic;

import java.util.HashSet;

import com.tectonica.jonix.onix2.Contributor;

/**
 * ONIX2 concrete implementation for {@link BasicContributor}
 * 
 * @author Zach Melamed
 */
public class BasicContributor2 extends BasicContributor
{
	private static final long serialVersionUID = 1L;

	public BasicContributor2(Contributor c)
	{
		contributorRoles = new HashSet<>(c.getContributorRoleValues());
		sequenceNumber = c.getSequenceNumberValue();
		personName = c.getPersonNameValue();
		personNameKey = c.getKeyNamesValue();
		personNameBeforeKey = c.getNamesBeforeKeyValue();
		personNameInverted = c.getPersonNameInvertedValue();
		corporateName = c.getCorporateNameValue();
		biographicalNote = c.getBiographicalNoteValue();
	}
}