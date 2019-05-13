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

package com.tectonica.jonix.onix3;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.ListOfOnixDataComposite;
import com.tectonica.jonix.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.AvItemIdentifierTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixAVItemIdentifier;
import com.tectonica.jonix.struct.JonixTimeRun;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>AV item composite</h1><p>An optional group of data elements which are specific to audio or audiovisual (<i>ie</i>
 * time-based) content. Exactly one of either the &lt;AVItem&gt; composite or the similar &lt;TextItem&gt; composite
 * must occur in a &lt;ContentItem&gt; composite which describes a content item.</p><table border='1'
 * cellpadding='3'><tr><td>Reference name</td><td>&lt;AVItem&gt;</td></tr><tr><td>Short
 * tag</td><td>&lt;avitem&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr></table>
 */
public class AVItem implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "AVItem";
    public static final String shortname = "avitem";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    public RecordSourceTypes sourcetype;

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

    /////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;
    public static final AVItem EMPTY = new AVItem();

    public AVItem() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public AVItem(org.w3c.dom.Element element) {
        exists = true;
        initialized = false;
        this.element = element;
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
                case AVItemType.refname:
                case AVItemType.shortname:
                    avItemType = new AVItemType(e);
                    break;
                case AVItemIdentifier.refname:
                case AVItemIdentifier.shortname:
                    avItemIdentifiers = JPU.addToList(avItemIdentifiers, new AVItemIdentifier(e));
                    break;
                case TimeRun.refname:
                case TimeRun.shortname:
                    timeRuns = JPU.addToList(timeRuns, new TimeRun(e));
                    break;
                case AVDuration.refname:
                case AVDuration.shortname:
                    avDuration = new AVDuration(e);
                    break;
                default:
                    break;
            }
        });
    }

    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private AVItemType avItemType = AVItemType.EMPTY;

    /**
     * (this field is required)
     */
    public AVItemType avItemType() {
        _initialize();
        return avItemType;
    }

    private ListOfOnixDataCompositeWithKey<AVItemIdentifier, JonixAVItemIdentifier, AvItemIdentifierTypes>
        avItemIdentifiers = ListOfOnixDataCompositeWithKey.emptyKeyed();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataCompositeWithKey<AVItemIdentifier, JonixAVItemIdentifier, AvItemIdentifierTypes> avItemIdentifiers() {
        _initialize();
        return avItemIdentifiers;
    }

    private ListOfOnixDataComposite<TimeRun, JonixTimeRun> timeRuns = ListOfOnixDataComposite.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixDataComposite<TimeRun, JonixTimeRun> timeRuns() {
        _initialize();
        return timeRuns;
    }

    private AVDuration avDuration = AVDuration.EMPTY;

    /**
     * (this field is optional)
     */
    public AVDuration avDuration() {
        _initialize();
        return avDuration;
    }
}
