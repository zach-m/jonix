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

package com.tectonica.jonix.onix3;

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
 * <h1>Header composite</h1>
 * <p>
 * A group of data elements which together constitute a message header. Mandatory in any ONIX for Books message, and
 * non-repeating. In ONIX&nbsp;3.0, a number of redundant elements have been deleted, and the Sender and Addressee
 * structures and the name and format of the &lt;SentDateTime&gt; element have been made consistent with other current
 * ONIX formats.
 * </p>
 * <table border='1' cellpadding='3'>
 * <tr>
 * <td>Reference name</td>
 * <td><tt>&lt;Header&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Short tag</td>
 * <td><tt>&lt;header&gt;</tt></td>
 * </tr>
 * <tr>
 * <td>Cardinality</td>
 * <td>1</td>
 * </tr>
 * </table>
 * <p/>
 * Technical notes about &lt;Header&gt; from the schema author:
 *
 * Container for message metadata &#9679; Modified cardinality of &lt;MessageNote&gt; at revision 3.0.1
 *
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;{@link ONIXMessage}&gt;</li>
 * </ul>
 * Possible placements within ONIX message:
 * <ul>
 * <li>{@link Header}</li>
 * </ul>
 */
public class Header implements OnixHeader, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Header";
    public static final String shortname = "header";

    /////////////////////////////////////////////////////////////////////////////////
    // ATTRIBUTES
    /////////////////////////////////////////////////////////////////////////////////

    private final OnixVersion onixVersion;
    private final String onixRelease;

    /**
     * (type: dt.DateOrDateTime)
     */
    public String datestamp;

    /**
     * (type: dt.NonEmptyString)
     */
    public String sourcename;

    public RecordSourceTypes sourcetype;

    /////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTION
    /////////////////////////////////////////////////////////////////////////////////

    private boolean initialized;
    private final boolean exists;
    private final org.w3c.dom.Element element;

    /**
     * This constructor is for backward compatibility. For future proofing, it's recommended to use the other
     * constructor, passing onixRelease label.
     */
    public Header(org.w3c.dom.Element element) {
        this(element, null);
    }

    public Header(org.w3c.dom.Element element, String onixRelease) {
        exists = true;
        initialized = false;
        this.element = element;
        this.onixVersion = OnixVersion.ONIX3;
        this.onixRelease = onixRelease;
        datestamp = JPU.getAttribute(element, "datestamp");
        sourcename = JPU.getAttribute(element, "sourcename");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
    }

    @Override
    public OnixVersion onixVersion() {
        return onixVersion;
    }

    @Override
    public String onixRelease() {
        return onixRelease;
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
                case Sender.refname:
                case Sender.shortname:
                    sender = new Sender(e);
                    break;
                case SentDateTime.refname:
                case SentDateTime.shortname:
                    sentDateTime = new SentDateTime(e);
                    break;
                case MessageNumber.refname:
                case MessageNumber.shortname:
                    messageNumber = new MessageNumber(e);
                    break;
                case MessageRepeat.refname:
                case MessageRepeat.shortname:
                    messageRepeat = new MessageRepeat(e);
                    break;
                case DefaultLanguageOfText.refname:
                case DefaultLanguageOfText.shortname:
                    defaultLanguageOfText = new DefaultLanguageOfText(e);
                    break;
                case DefaultPriceType.refname:
                case DefaultPriceType.shortname:
                    defaultPriceType = new DefaultPriceType(e);
                    break;
                case DefaultCurrencyCode.refname:
                case DefaultCurrencyCode.shortname:
                    defaultCurrencyCode = new DefaultCurrencyCode(e);
                    break;
                case Addressee.refname:
                case Addressee.shortname:
                    addressees = JPU.addToList(addressees, new Addressee(e));
                    break;
                case MessageNote.refname:
                case MessageNote.shortname:
                    messageNotes = JPU.addToList(messageNotes, new MessageNote(e));
                    break;
                default:
                    break;
            }
        });
    }

    /**
     * @return whether this tag (&lt;Header&gt; or &lt;header&gt;) is explicitly provided in the ONIX XML
     */
    @Override
    public boolean exists() {
        return exists;
    }

    public void ifExists(Consumer<Header> action) {
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

    private Sender sender = Sender.EMPTY;

    /**
     * <p>
     * A group of data elements which together specify the sender of an ONIX for Books message. Mandatory in any ONIX
     * for Books message, and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public Sender sender() {
        _initialize();
        return sender;
    }

    private SentDateTime sentDateTime = SentDateTime.EMPTY;

    /**
     * <p>
     * The date on which the message is sent. Optionally, the time may be added, using the 24-hour clock, with an
     * explicit indication of the time zone if required, in a format based on ISO 8601. Mandatory and non-repeating.
     * </p>
     * JONIX adds: this field is required
     */
    public SentDateTime sentDateTime() {
        _initialize();
        return sentDateTime;
    }

    private MessageNumber messageNumber = MessageNumber.EMPTY;

    /**
     * <p>
     * A monotonic sequence number of the messages in a series sent between trading partners, to enable the receiver to
     * check against gaps and duplicates. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public MessageNumber messageNumber() {
        _initialize();
        return messageNumber;
    }

    private MessageRepeat messageRepeat = MessageRepeat.EMPTY;

    /**
     * <p>
     * A number which distinguishes any repeat transmissions of a message. If this element is used, the original is
     * numbered 1 and repeats are numbered 2, 3 <i>etc</i>. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public MessageRepeat messageRepeat() {
        _initialize();
        return messageRepeat;
    }

    private DefaultLanguageOfText defaultLanguageOfText = DefaultLanguageOfText.EMPTY;

    /**
     * <p>
     * An ISO standard code indicating the default language which is assumed for the text of products listed in the
     * message, unless explicitly stated otherwise by sending a ‘language of text’ element in the product record. This
     * default will be assumed for all product records which do not specify a language in Group&nbsp;P.10. Optional and
     * non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public DefaultLanguageOfText defaultLanguageOfText() {
        _initialize();
        return defaultLanguageOfText;
    }

    private DefaultPriceType defaultPriceType = DefaultPriceType.EMPTY;

    /**
     * <p>
     * An ONIX code indicating the default price type which is assumed for prices listed in the message, unless
     * explicitly stated otherwise in a &lt;Price&gt; composite in the product record. Optional and non-repeating.
     * </p>
     * JONIX adds: this field is optional
     */
    public DefaultPriceType defaultPriceType() {
        _initialize();
        return defaultPriceType;
    }

    private DefaultCurrencyCode defaultCurrencyCode = DefaultCurrencyCode.EMPTY;

    /**
     * <p>
     * An ISO standard code indicating the currency which is assumed for prices listed in the message, unless explicitly
     * stated otherwise in a &lt;Price&gt; composite in a product record. Optional and non-repeating. All ONIX messages
     * must include an explicit statement of the currency used for any prices. To avoid any possible ambiguity, it is
     * strongly recommended that the currency should be repeated in the &lt;Price&gt; composite for each individual
     * price.
     * </p>
     * JONIX adds: this field is optional
     */
    public DefaultCurrencyCode defaultCurrencyCode() {
        _initialize();
        return defaultCurrencyCode;
    }

    private ListOfOnixComposite<Addressee> addressees = JPU.emptyListOfOnixComposite(Addressee.class);

    /**
     * <p>
     * A group of data elements which together specify the addressee of an ONIX for Books message. Optional, and
     * repeatable if there are several addressees.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixComposite<Addressee> addressees() {
        _initialize();
        return addressees;
    }

    private ListOfOnixElement<MessageNote, String> messageNotes = ListOfOnixElement.empty();

    /**
     * <p>
     * Free text giving additional information about the message. Optional, and repeatable in order to provide a note in
     * multiple languages. The <i>language</i> attribute is optional for a single instance of &lt;MessageNote&gt;, but
     * must be included in each instance if &lt;MessageNote&gt; is repeated.
     * </p>
     * JONIX adds: this list may be empty
     */
    public ListOfOnixElement<MessageNote, String> messageNotes() {
        _initialize();
        return messageNotes;
    }
}
