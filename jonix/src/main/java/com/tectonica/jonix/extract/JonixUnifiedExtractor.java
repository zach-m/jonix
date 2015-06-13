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

package com.tectonica.jonix.extract;

import java.util.List;

import org.w3c.dom.Element;

import com.tectonica.jonix.JonixUnifier;
import com.tectonica.jonix.stream.JonixAbstractStreamer;
import com.tectonica.jonix.stream.JonixExtractor;
import com.tectonica.jonix.stream.JonixOnixVersion;

public abstract class JonixUnifiedExtractor<H, P> extends JonixExtractor
{
	protected void onHeader(H header, JonixAbstractStreamer streamer)
	{}

	protected abstract void onProduct(P product, JonixAbstractStreamer streamer);

	// ///////////////////////////////////////////////////////////////////////////////

	protected final JonixUnifier<H, P> unifier;
	protected Object rawOnixObject; // TODO: make private

	public JonixUnifiedExtractor(final JonixUnifier<H, P> unifier)
	{
		if (unifier == null)
			throw new NullPointerException("context is required");
		this.unifier = unifier;
	}

	@Override
	protected void onHeaderElement(Element domHeader, JonixAbstractStreamer streamer)
	{
		final H unifiedHeader;
		if (streamer.getSourceOnixVersion() == JonixOnixVersion.ONIX2)
		{
			com.tectonica.jonix.onix2.Header rawHeader2 = new com.tectonica.jonix.onix2.Header(domHeader);
			unifiedHeader = unifier.createFrom(rawHeader2);
		}
		else
		// if (isOnix3)
		{
			com.tectonica.jonix.onix3.Header rawHeader3 = new com.tectonica.jonix.onix3.Header(domHeader);
			unifiedHeader = unifier.createFrom(rawHeader3);
		}
		onHeader(unifiedHeader, streamer);
	}

	@Override
	protected void onProductElement(Element domProduct, JonixAbstractStreamer streamer)
	{
		final P unifiedProduct;
		if (streamer.getSourceOnixVersion() == JonixOnixVersion.ONIX2)
		{
			com.tectonica.jonix.onix2.Product rawProduct2 = new com.tectonica.jonix.onix2.Product(domProduct);
			unifiedProduct = unifier.createFrom(rawProduct2);
		}
		else
		// if (isOnix3)
		{
			com.tectonica.jonix.onix3.Product rawProduct3 = new com.tectonica.jonix.onix3.Product(domProduct);
			unifiedProduct = unifier.createFrom(rawProduct3);
		}
		onProduct(unifiedProduct, streamer);
	}

	@Override
	protected boolean onBeforeFileList(List<String> fileNames, JonixAbstractStreamer streamer)
	{
		log("Found " + fileNames.size() + " files..");
		return true;
	}

	@Override
	protected void onAfterFileList(List<String> processedFileNames, JonixAbstractStreamer streamer)
	{
		logf("** DONE, %d products extracted in total **\n", streamer.getProductNo());
	}

	@Override
	protected boolean onBeforeFile(String fileName, JonixAbstractStreamer streamer)
	{
		log("opening " + fileName + ".. ");
		return true;
	}
}
