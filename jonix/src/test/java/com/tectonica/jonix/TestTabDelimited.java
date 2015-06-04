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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestTabDelimited
{
	@Before
	public void setUp() throws Exception
	{}

	@After
	public void tearDown() throws Exception
	{}

	@Test
	@Ignore
	public void test() throws FileNotFoundException
	{
		final String path = "../onix_samples/ONIX2/BK";

		final File file = new File(path);
		if (!file.exists())
			throw new RuntimeException("couldn't found " + file.getAbsolutePath());

		PrintStream outFile = new PrintStream("BK.tsv");

		Jonix.createBasicTabDelimitedExporter(outFile, null).scanFolder(path, ".xml");
	}
}
