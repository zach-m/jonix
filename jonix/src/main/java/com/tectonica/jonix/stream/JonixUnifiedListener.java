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

package com.tectonica.jonix.stream;

import java.util.List;

import com.tectonica.jonix.JonixContext;

public abstract class JonixUnifiedListener<H, P> extends JonixRawListener
{
	protected void onHeader(H header)
	{}

	protected abstract void onProduct(P product);

	protected final JonixContext<H, P> context;
	protected Object rawOnixObject; // TODO: make private

	public JonixUnifiedListener(final JonixContext<H, P> context)
	{
		if (context == null)
			throw new NullPointerException("context is required");
		this.context = context;
	}

	@Override
	protected void onOnix2Header(com.tectonica.jonix.onix2.Header header)
	{
		rawOnixObject = header;
		onHeader(context.createFrom(header));
	}

	@Override
	protected void onOnix2Product(com.tectonica.jonix.onix2.Product product)
	{
		rawOnixObject = product;
		onProduct(context.createFrom(product));
	}

	@Override
	protected void onOnix3Header(com.tectonica.jonix.onix3.Header header)
	{
		rawOnixObject = header;
		onHeader(context.createFrom(header));
	}

	@Override
	protected void onOnix3Product(com.tectonica.jonix.onix3.Product product)
	{
		rawOnixObject = product;
		onProduct(context.createFrom(product));
	}
	
	@Override
	protected boolean onBeforeFileList(List<String> fileNames)
	{
		log.println("Found " + fileNames.size() + " files..");
		return true;
	}

	@Override
	protected void onAfterFileList(List<String> processedFileNames)
	{
		log.printf("** DONE, %d products exported so far **\n", productNo);
	}

	@Override
	protected boolean onBeforeFile(String fileName)
	{
		log.println("opening " + fileName + ".. ");
		return true;
	}
}
