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

package com.tectonica.jonix.metadata;

public enum Multiplicity
{
	Optional(true, true), //
	Required(false, true), //
	ZeroOrMore(true, false), //
	OneOrMore(false, false);

	final public boolean omittable;
	final public boolean singular;

	private Multiplicity(boolean omittable, boolean singular)
	{
		this.omittable = omittable;
		this.singular = singular;
	}

	private static Multiplicity of(boolean omittable, boolean singular)
	{
		for (Multiplicity multiplicity : values())
			if (multiplicity.omittable == omittable && multiplicity.singular == singular)
				return multiplicity;

		return null;
	}

	public static Multiplicity of(String minOccurs, String maxOccurs)
	{
		if (minOccurs == null || minOccurs.isEmpty())
			minOccurs = "1";
		if (maxOccurs == null || maxOccurs.isEmpty())
			maxOccurs = "1";

		final boolean omittable = "0".equals(minOccurs);
		final boolean singular = "1".equals(maxOccurs);
		final Multiplicity multiplicity = Multiplicity.of(omittable, singular);

		if (multiplicity == null)
			throw new RuntimeException("Internal error where minOccurs=" + minOccurs + ", and maxOccurs=" + maxOccurs);

		return multiplicity;
	}

	public Multiplicity commonGroundsWith(Multiplicity other)
	{
		if (other == null)
			return this;

		final boolean omittable = this.omittable || other.omittable;
		final boolean singular = this.singular && other.singular;
		final Multiplicity multiplicity = Multiplicity.of(omittable, singular);

		if (multiplicity == null)
			throw new RuntimeException("Internal error where omittable=" + omittable + ", and singular=" + singular);

		return multiplicity;
	}
}