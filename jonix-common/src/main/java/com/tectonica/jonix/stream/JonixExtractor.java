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

import java.io.InputStream;
import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

/**
 * An abstract base-class for an <b>extractor</b> - a listener for {@link JonixStreamer} processing the events it fires
 * as it parses an ONIX source. Subclasses are required to implement {@link #onHeaderElement(Element, JonixStreamer)}
 * and {@link #onProductElement(Element, JonixStreamer)}, but may also override the other protected methods.
 * <p>
 * Users of an extractor can specify where to send the log messages using {@link #setLogger(PrintStream)}.
 * <p>
 * NOTE: extractors may be reused over different streamers, if needed
 * 
 * @author Zach Melamed
 */
public abstract class JonixExtractor
{
	protected static final Logger LOG = LoggerFactory.getLogger(JonixExtractor.class);

	protected abstract void onHeaderElement(Element header, JonixStreamer streamer);

	protected abstract void onProductElement(Element product, JonixStreamer streamer);

	// /////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * return false here to skip this particular source
	 */
	protected boolean onBeforeSource(InputStream source, JonixStreamer streamer)
	{
		return true;
	}

	protected void onAfterSource(JonixStreamer streamer)
	{}
}
