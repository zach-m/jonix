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

package com.tectonica.jonix;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestJonixUtil
{
	@Before
	public void setUp() throws Exception
	{}

	@After
	public void tearDown() throws Exception
	{}

	private int compare(String[] a, String[] b)
	{
		int c1 = JonixUtil.compareArray(a, b);
		int c2 = JonixUtil.compareArray(b, a);
		Assert.assertEquals(c1, -c2);
//		String sign = (c1 < 0) ? " < " : ((c1 > 0) ? " > " : " = ");
//		System.out.println(Arrays.toString(a) + sign + Arrays.toString(b));
		return c1;
	}

	@Test
	public void testArrayCompare()
	{
		String[] a = new String[] { "a" };
		String[] ab = new String[] { "a", "b" };
		String[] ab2 = new String[] { "a", "b" };
		String[] ac = new String[] { "a", "c" };
		String[] a_b = new String[] { "a", null, "b" };
		String[] a_c = new String[] { "a", null, "c" };

		Assert.assertEquals(compare(ab, ac), -1);
		Assert.assertEquals(compare(ab, ab), 0);
		Assert.assertEquals(compare(ab, ab2), 0);
		Assert.assertEquals(compare(a, ac), -1);
		Assert.assertEquals(compare(null, a), -1);
		Assert.assertEquals(compare(a_b, ab), -1);
		Assert.assertEquals(compare(a_b, a_c), -1);
	}
}
