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

import java.util.Collection;

import com.tectonica.jonix.JonixContext;

public class JonixInMemListener<H, P> extends JonixUnifiedListener<H, P>
{
	protected Collection<P> output;

	public JonixInMemListener(JonixContext<H, P> context, Collection<P> output)
	{
		super(context);
		if (output == null)
			throw new NullPointerException();
		this.output = output;
	}

	@Override
	public void onProduct(P product)
	{
		output.add(product);
	}
}
