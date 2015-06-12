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

import org.w3c.dom.Element;

import com.tectonica.jonix.stream.JonixListener;

public abstract class JonixRawListener extends JonixListener
{
	protected void onOnix2Header(com.tectonica.jonix.onix2.Header header)
	{}

	protected abstract void onOnix2Product(com.tectonica.jonix.onix2.Product product);

	protected void onOnix3Header(com.tectonica.jonix.onix3.Header header)
	{}

	protected abstract void onOnix3Product(com.tectonica.jonix.onix3.Product product);

	@Override
	protected void onHeaderElement(Element header)
	{
		if (onix2)
		{
			com.tectonica.jonix.onix2.Header h2 = new com.tectonica.jonix.onix2.Header(header);
			onOnix2Header(h2);
		}
		else
		// if (isOnix3)
		{
			com.tectonica.jonix.onix3.Header h3 = new com.tectonica.jonix.onix3.Header(header);
			onOnix3Header(h3);
		}
	}

	@Override
	protected void onProductElement(Element product)
	{
		if (onix2)
		{
			com.tectonica.jonix.onix2.Product p2 = new com.tectonica.jonix.onix2.Product(product);
			onOnix2Product(p2);
		}
		else
		// if (isOnix3)
		{
			com.tectonica.jonix.onix3.Product p3 = new com.tectonica.jonix.onix3.Product(product);
			onOnix3Product(p3);
		}
	}
}
