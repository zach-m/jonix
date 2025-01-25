/*
 * Copyright (C) 2012-2025 Zach Melamed
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

package com.tectonica.jonix.onix2;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;

import com.tectonica.jonix.common.*;
import com.tectonica.jonix.common.OnixComposite.*;
import com.tectonica.jonix.common.codelist.*;
import com.tectonica.jonix.common.struct.*;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Page run composite</h1>
 * <p>
 * A repeatable group of data elements which together define a run of contiguous pages on which a text item appears. The
 * composite is optional, but may be repeated where the text item covers two or more separate page runs.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;PageRun&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;pagerun&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link TextItem}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Product} ⯈ {@link ContentItem} ⯈ {@link TextItem} ⯈ {@link PageRun}</li>
 * </ul>
 *
 * @since Onix-2.1
 */
public class PageRun implements OnixDataComposite<JonixPageRun>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "PageRun";
    public static final String shortname = "pagerun";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    public TextFormats textformat;

    public TextCaseFlags textcase;

    public Languages language;

    public TransliterationSchemes transliteration;

    /**
     * (type: DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    public String sourcename;

    /////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final PageRun EMPTY = new PageRun();

    public PageRun() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public PageRun(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
        textformat = TextFormats.byCode(JPU.getAttribute(element, "textformat"));
        textcase = TextCaseFlags.byCode(JPU.getAttribute(element, "textcase"));
        language = Languages.byCode(JPU.getAttribute(element, "language"));
        transliteration = TransliterationSchemes.byCode(JPU.getAttribute(element, "transliteration"));
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");
    }

    @Override
    public void _initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            switch (name) {
                case FirstPageNumber.refname:
                case FirstPageNumber.shortname:
                    firstPageNumber = new FirstPageNumber(e);
                    break;
                case LastPageNumber.refname:
                case LastPageNumber.shortname:
                    lastPageNumber = new LastPageNumber(e);
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;PageRun&gt; or &lt;pagerun&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<PageRun> action) {
        if (exists) {
            action.accept(this);
        }
    }

    @Override
    public org.w3c.dom.Element getXmlElement() {
        return element;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private FirstPageNumber firstPageNumber = FirstPageNumber.EMPTY;

    /**
     * <p>
     * The number of the first page of a sequence of contiguous pages. Mandatory in each occurrence of the
     * &lt;PageRun&gt; composite, and non-repeating. Note that here and in the &lt;LastPageNumber&gt; element a page
     * “number” may be arabic, roman, or an alphanumeric string (<em>eg</em> L123).
     * </p>
     * JONIX adds: this field is required
     */
    public FirstPageNumber firstPageNumber() {
        _initialize();
        return firstPageNumber;
    }

    private LastPageNumber lastPageNumber = LastPageNumber.EMPTY;

    /**
     * <p>
     * The number of the last page of a sequence of contiguous pages (ignoring any blank verso which is left after the
     * last text page). This element is omitted if an item begins and ends on the same page; otherwise it should occur
     * once and only once in each occurrence of the &lt;PageRun&gt; composite.
     * </p>
     * JONIX adds: this field is optional
     */
    public LastPageNumber lastPageNumber() {
        _initialize();
        return lastPageNumber;
    }

    @Override
    public JonixPageRun asStruct() {
        _initialize();
        JonixPageRun struct = new JonixPageRun();
        struct.firstPageNumber = firstPageNumber.value;
        struct.lastPageNumber = lastPageNumber.value;
        return struct;
    }
}
