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
import com.tectonica.jonix.ListOfOnixElement;
import com.tectonica.jonix.OnixHeader;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

public class Header implements OnixHeader, Serializable {
    private static final long serialVersionUID = 1L;

    public static final String refname = "Header";
    public static final String shortname = "header";

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
    public static final Header EMPTY = new Header();

    public Header() {
        exists = false;
        element = null;
        initialized = true; // so that no further processing will be done on this intentionally-empty object
    }

    public Header(org.w3c.dom.Element element) {
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
                case Sender.refname:
                case Sender.shortname:
                    sender = new Sender(e);
                    break;
                case Addressee.refname:
                case Addressee.shortname:
                    addressees = JPU.addToList(addressees, new Addressee(e));
                    break;
                case MessageNumber.refname:
                case MessageNumber.shortname:
                    messageNumber = new MessageNumber(e);
                    break;
                case MessageRepeat.refname:
                case MessageRepeat.shortname:
                    messageRepeat = new MessageRepeat(e);
                    break;
                case SentDateTime.refname:
                case SentDateTime.shortname:
                    sentDateTime = new SentDateTime(e);
                    break;
                case MessageNote.refname:
                case MessageNote.shortname:
                    messageNotes = JPU.addToList(messageNotes, new MessageNote(e));
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

    private Sender sender = Sender.EMPTY;

    /**
     * (this field is required)
     */
    public Sender sender() {
        _initialize();
        return sender;
    }

    private List<Addressee> addressees = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<Addressee> addressees() {
        _initialize();
        return addressees;
    }

    private MessageNumber messageNumber = MessageNumber.EMPTY;

    /**
     * (this field is optional)
     */
    public MessageNumber messageNumber() {
        _initialize();
        return messageNumber;
    }

    private MessageRepeat messageRepeat = MessageRepeat.EMPTY;

    /**
     * (this field is optional)
     */
    public MessageRepeat messageRepeat() {
        _initialize();
        return messageRepeat;
    }

    private SentDateTime sentDateTime = SentDateTime.EMPTY;

    /**
     * (this field is required)
     */
    public SentDateTime sentDateTime() {
        _initialize();
        return sentDateTime;
    }

    private ListOfOnixElement<MessageNote, String> messageNotes = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<MessageNote, String> messageNotes() {
        _initialize();
        return messageNotes;
    }

    private DefaultLanguageOfText defaultLanguageOfText = DefaultLanguageOfText.EMPTY;

    /**
     * (this field is optional)
     */
    public DefaultLanguageOfText defaultLanguageOfText() {
        _initialize();
        return defaultLanguageOfText;
    }

    private DefaultPriceType defaultPriceType = DefaultPriceType.EMPTY;

    /**
     * (this field is optional)
     */
    public DefaultPriceType defaultPriceType() {
        _initialize();
        return defaultPriceType;
    }

    private DefaultCurrencyCode defaultCurrencyCode = DefaultCurrencyCode.EMPTY;

    /**
     * (this field is optional)
     */
    public DefaultCurrencyCode defaultCurrencyCode() {
        _initialize();
        return defaultCurrencyCode;
    }
}
