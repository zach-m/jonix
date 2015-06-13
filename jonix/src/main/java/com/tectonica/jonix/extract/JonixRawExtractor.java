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

import org.w3c.dom.Element;

import com.tectonica.jonix.stream.JonixAbstractStreamer;
import com.tectonica.jonix.stream.JonixExtractor;
import com.tectonica.jonix.stream.JonixOnixVersion;

public abstract class JonixRawExtractor extends JonixExtractor
{
	protected void onOnix2Header(com.tectonica.jonix.onix2.Header header, JonixAbstractStreamer streamer)
	{}

	protected abstract void onOnix2Product(com.tectonica.jonix.onix2.Product product, JonixAbstractStreamer streamer);

	protected void onOnix3Header(com.tectonica.jonix.onix3.Header header, JonixAbstractStreamer streamer)
	{}

	protected abstract void onOnix3Product(com.tectonica.jonix.onix3.Product product, JonixAbstractStreamer streamer);

	// ///////////////////////////////////////////////////////////////////////////////

	@Override
	protected void onHeaderElement(Element domHeader, JonixAbstractStreamer streamer)
	{
		if (streamer.getSourceOnixVersion() == JonixOnixVersion.ONIX2)
			onOnix2Header(new com.tectonica.jonix.onix2.Header(domHeader), streamer);
		else
			// if (isOnix3)
			onOnix3Header(new com.tectonica.jonix.onix3.Header(domHeader), streamer);
	}

	@Override
	protected void onProductElement(Element domProduct, JonixAbstractStreamer streamer)
	{
		if (streamer.getSourceOnixVersion() == JonixOnixVersion.ONIX2)
			onOnix2Product(new com.tectonica.jonix.onix2.Product(domProduct), streamer);
		else
			// if (isOnix3)
			onOnix3Product(new com.tectonica.jonix.onix3.Product(domProduct), streamer);
	}
}
