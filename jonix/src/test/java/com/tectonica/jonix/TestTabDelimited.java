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

import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.tectonica.jonix.basic.BasicHeader;
import com.tectonica.jonix.basic.BasicProduct;
import com.tectonica.jonix.export.JonixTabDelimitedExporter;

public class TestTabDelimited
{
	private JonixTabDelimitedExporter<BasicHeader, BasicProduct> exporter;

	@Before
	public void setUp() throws Exception
	{
		PrintStream outFile = new PrintStream("Catalog.tsv");
		exporter = Jonix.createBasicTabDelimitedExporter(outFile);
	}

	@After
	public void tearDown() throws Exception
	{}

	@Test
	@Ignore
	// ignored by default. the sample files are not checked in to SCM
	public void exportVariousOnixSourcesIntoTSV() throws FileNotFoundException
	{
		exporter.readFolder("../onix_samples/ONIX3", ".onix"); // ONIX3 files
		exporter.readFolder("../onix_samples/ONIX2/BK", ".xml"); // ONIX2 files
		exporter.read("../onix_samples/ONIX2/SB_short.xml"); // short-references ONIX2 file
		exporter.read("../onix_samples/ONIX2/MY.xml"); // improper ONIX2 file (has some syntactic bugs)
	}
}
