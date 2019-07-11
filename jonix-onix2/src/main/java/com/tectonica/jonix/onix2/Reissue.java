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

package com.tectonica.jonix.onix2;

import com.tectonica.jonix.common.JPU;
import com.tectonica.jonix.common.ListOfOnixDataCompositeWithKey;
import com.tectonica.jonix.common.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.common.codelist.ImageAudioVideoFileTypes;
import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.common.codelist.RecordSourceTypes;
import com.tectonica.jonix.common.codelist.TextCaseFlags;
import com.tectonica.jonix.common.codelist.TextFormats;
import com.tectonica.jonix.common.codelist.TransliterationSchemes;
import com.tectonica.jonix.common.struct.JonixMediaFile;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Reissue composite</h1>
 * <p>
 * A group of data elements which together specify that a product is to be reissued within the market to which the
 * &lt;SupplyDetail&gt; composite applies. Optional and non-repeating. The &lt;Reissue&gt; composite is used only when
 * the publisher intends to re-launch the product under the same ISBN. There are two possible cases:
 * </p>
 * <ol style="list-style-type: lower-alpha">
 * <li>When the product is unavailable during the period immediately before reissue. In this case, the
 * &lt;AvailabilityCode&gt; should carry the value UR for “unavailable, awaiting reissue”, and the ONIX record can be
 * updated to describe the reissued product as soon as details can be made available</li>
 * <li>When the product is still available during the period up to the reissue date. In this case, the ONIX record
 * should continue to describe the existing product and the &lt;AvailabilityCode&gt; value should remain IP right up to
 * the reissue date. At that date, the record should be updated to describe the reissued product, with the
 * &lt;AvailabilityCode&gt; value remaining IP.</li>
 * </ol>
 * <p>
 * After reissue, it is recommended that the &lt;Reissue&gt; composite should be retained as a permanent element of the
 * ONIX record, carrying only the &lt;ReissueDate&gt; element, which will then indicate “date last reissued”.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Reissue&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;reissue&gt;</tt></td>
 * </tr>
 * </table>
 * <p/>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link SupplyDetail}&gt;</li>
 * </ul>
 * <p/>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link ONIXMessage} ⯈ {@link Product} ⯈ {@link SupplyDetail} ⯈ {@link Reissue}</li>
 * </ul>
 *
 * @since Onix-2.1
 */
public class Reissue implements OnixSuperComposite, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Reissue";
    public static final String shortname = "reissue";

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
    public static final Reissue EMPTY = new Reissue();

    public Reissue() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Reissue(org.w3c.dom.Element element) {
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
                case ReissueDate.refname:
                case ReissueDate.shortname:
                    reissueDate = new ReissueDate(e);
                    break;
                case ReissueDescription.refname:
                case ReissueDescription.shortname:
                    reissueDescription = new ReissueDescription(e);
                    break;
                case Price.refname:
                case Price.shortname:
                    prices = JPU.addToList(prices, new Price(e));
                    break;
                case MediaFile.refname:
                case MediaFile.shortname:
                    mediaFiles = JPU.addToList(mediaFiles, new MediaFile(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Reissue&gt; or &lt;reissue&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MEMBERS
    /////////////////////////////////////////////////////////////////////////////////

    private ReissueDate reissueDate = ReissueDate.EMPTY;

    /**
     * <p>
     * The date on which the product will be reissued, or (after reissue) the date when it was last reissued. Mandatory
     * in each occurrence of the &lt;Reissue&gt; composite, and non-repeating.
     * </p>
     * Jonix-Comment: this field is required
     */
    public ReissueDate reissueDate() {
        _initialize();
        return reissueDate;
    }

    private ReissueDescription reissueDescription = ReissueDescription.EMPTY;

    /**
     * <p>
     * Text explaining the nature of the reissue. Optional and non-repeating.
     * </p>
     * Jonix-Comment: this field is optional
     */
    public ReissueDescription reissueDescription() {
        _initialize();
        return reissueDescription;
    }

    private List<Price> prices = Collections.emptyList();

    /**
     * <p>
     * A optional and repeatable group of data elements which together specify a unit price, used here to indicate a
     * price that will apply when the product is reissued. <strong>Please see above, within Group&nbsp;PR.24, for
     * details.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public List<Price> prices() {
        _initialize();
        return prices;
    }

    private ListOfOnixDataCompositeWithKey<MediaFile, JonixMediaFile, ImageAudioVideoFileTypes> mediaFiles = ListOfOnixDataCompositeWithKey
        .emptyKeyed();

    /**
     * <p>
     * An optional and repeatable group of data elements which together identify and provide pointers to an image, audio
     * or video file, used here to indicate that there is a new cover or jacket image for a reissue. <strong>Please see
     * Group&nbsp;PR.16 for details.</strong>
     * </p>
     * Jonix-Comment: this list may be empty
     */
    public ListOfOnixDataCompositeWithKey<MediaFile, JonixMediaFile, ImageAudioVideoFileTypes> mediaFiles() {
        _initialize();
        return mediaFiles;
    }
}
