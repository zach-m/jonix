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
import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;
import com.tectonica.jonix.codelist.LicenseExpressionTypes;
import com.tectonica.jonix.codelist.RecordSourceTypes;
import com.tectonica.jonix.struct.JonixEpubLicenseExpression;

import java.io.Serializable;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Digital product license expression</h1><p>An optional and repeatable composite that carries details of a link to
 * an expression of the license terms, which may be in human-readable or machine-readable form. Repeatable when there is
 * more than one expression of the license.</p><table border='1' cellpadding='3'><tr><td>Reference
 * name</td><td>&lt;EpubLicenseExpression&gt;</td></tr><tr><td>Short tag</td><td>&lt;epublicenseexpression&gt;</td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr></table>
 */
public class EpubLicenseExpression
    implements OnixDataCompositeWithKey<JonixEpubLicenseExpression, LicenseExpressionTypes>, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "EpubLicenseExpression";
    public static final String shortname = "epublicenseexpression";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * (type: dt.DateOrDateTime)
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
    public static final EpubLicenseExpression EMPTY = new EpubLicenseExpression();

    public EpubLicenseExpression() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public EpubLicenseExpression(org.w3c.dom.Element element) {
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
                case EpubLicenseExpressionType.refname:
                case EpubLicenseExpressionType.shortname:
                    epubLicenseExpressionType = new EpubLicenseExpressionType(e);
                    break;
                case EpubLicenseExpressionTypeName.refname:
                case EpubLicenseExpressionTypeName.shortname:
                    epubLicenseExpressionTypeName = new EpubLicenseExpressionTypeName(e);
                    break;
                case EpubLicenseExpressionLink.refname:
                case EpubLicenseExpressionLink.shortname:
                    epubLicenseExpressionLink = new EpubLicenseExpressionLink(e);
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

    private EpubLicenseExpressionType epubLicenseExpressionType = EpubLicenseExpressionType.EMPTY;

    /**
     * (this field is required)
     */
    public EpubLicenseExpressionType epubLicenseExpressionType() {
        _initialize();
        return epubLicenseExpressionType;
    }

    private EpubLicenseExpressionTypeName epubLicenseExpressionTypeName = EpubLicenseExpressionTypeName.EMPTY;

    /**
     * (this field is optional)
     */
    public EpubLicenseExpressionTypeName epubLicenseExpressionTypeName() {
        _initialize();
        return epubLicenseExpressionTypeName;
    }

    private EpubLicenseExpressionLink epubLicenseExpressionLink = EpubLicenseExpressionLink.EMPTY;

    /**
     * (this field is required)
     */
    public EpubLicenseExpressionLink epubLicenseExpressionLink() {
        _initialize();
        return epubLicenseExpressionLink;
    }

    @Override
    public JonixEpubLicenseExpression asStruct() {
        _initialize();
        JonixEpubLicenseExpression struct = new JonixEpubLicenseExpression();
        struct.epubLicenseExpressionType = epubLicenseExpressionType.value;
        struct.epubLicenseExpressionTypeName = epubLicenseExpressionTypeName.value;
        struct.epubLicenseExpressionLink = epubLicenseExpressionLink.value;
        return struct;
    }

    @Override
    public LicenseExpressionTypes structKey() {
        return epubLicenseExpressionType().value;
    }
}
