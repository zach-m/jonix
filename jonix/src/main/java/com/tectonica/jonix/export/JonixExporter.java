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

package com.tectonica.jonix.export;

import com.tectonica.jonix.unify.JonixUnifier;
import com.tectonica.jonix.extract.JonixUnifiedExtractor;
import com.tectonica.jonix.stream.JonixStreamer;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * A {@link JonixUnifiedExtractor} with additional 'out' member, intended as an output target for the extracted data.
 *
 * @author Zach Melamed
 */
public abstract class JonixExporter<H, P> extends JonixUnifiedExtractor<H, P> {
    @Override
    protected boolean onHeader(H header, JonixStreamer streamer) {
        LOG.info("-----------------------------------------------------------\n");
        LOG.info(header.toString());
        LOG.info("-----------------------------------------------------------\n");
        return true;
    }

    @Override
    protected boolean onProduct(P product, JonixStreamer streamer) {
        // show a log message about the product being successfully parsed
        LOG.info("retrieved product #{} - {}", streamer.getProductNo(), unifier.labelOf(product));
        return true;
    }

    // ///////////////////////////////////////////////////////////////////////////////

    public JonixExporter(JonixUnifier<H, P> unifier) {
        super(unifier);
    }

    protected PrintStream out = System.out;

    public JonixExporter<H, P> setOut(String fileName) {
        return setOut(fileName, "UTF-8");
    }

    /**
     * sets the output filename
     */
    public JonixExporter<H, P> setOut(String fileName, String encoding) {
        try {
            return setOut(new PrintStream(fileName, encoding));
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            LOG.error("Couldn't setOut to '" + fileName + "', encoding: " + encoding, e);
            throw new RuntimeException(e);
        }
    }

    public JonixExporter<H, P> setOut(PrintStream out) {
        this.out = (out == null) ? System.out : out;
        return this;
    }

    public PrintStream getOut() {
        return out;
    }

    @Override
    protected void onAfterSource(JonixStreamer streamer) {
        super.onAfterSource(streamer);
        out.flush();
    }
}
