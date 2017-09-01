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
import com.tectonica.jonix.OnixComposite.OnixSuperComposite;
import com.tectonica.jonix.codelist.RecordSourceTypes;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

public class Header implements OnixSuperComposite, Serializable {
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
    }

    private void initialize() {
        if (initialized) {
            return;
        }
        initialized = true;

        datestamp = JPU.getAttribute(element, "datestamp");
        sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
        sourcename = JPU.getAttribute(element, "sourcename");

        JPU.forElementsOf(element, e -> {
            final String name = e.getNodeName();
            if (name.equals(Sender.refname) || name.equals(Sender.shortname)) {
                sender = new Sender(e);
            } else if (name.equals(Addressee.refname) || name.equals(Addressee.shortname)) {
                addressees = JPU.addToList(addressees, new Addressee(e));
            } else if (name.equals(MessageNumber.refname) || name.equals(MessageNumber.shortname)) {
                messageNumber = new MessageNumber(e);
            } else if (name.equals(MessageRepeat.refname) || name.equals(MessageRepeat.shortname)) {
                messageRepeat = new MessageRepeat(e);
            } else if (name.equals(SentDateTime.refname) || name.equals(SentDateTime.shortname)) {
                sentDateTime = new SentDateTime(e);
            } else if (name.equals(MessageNote.refname) || name.equals(MessageNote.shortname)) {
                messageNotes = JPU.addToList(messageNotes, new MessageNote(e));
            } else if (name.equals(DefaultLanguageOfText.refname) || name.equals(DefaultLanguageOfText.shortname)) {
                defaultLanguageOfText = new DefaultLanguageOfText(e);
            } else if (name.equals(DefaultPriceType.refname) || name.equals(DefaultPriceType.shortname)) {
                defaultPriceType = new DefaultPriceType(e);
            } else if (name.equals(DefaultCurrencyCode.refname) || name.equals(DefaultCurrencyCode.shortname)) {
                defaultCurrencyCode = new DefaultCurrencyCode(e);
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
        initialize();
        return sender;
    }

    private List<Addressee> addressees = Collections.emptyList();

    /**
     * (this list may be empty)
     */
    public List<Addressee> addressees() {
        initialize();
        return addressees;
    }

    private MessageNumber messageNumber = MessageNumber.EMPTY;

    /**
     * (this field is optional)
     */
    public MessageNumber messageNumber() {
        initialize();
        return messageNumber;
    }

    private MessageRepeat messageRepeat = MessageRepeat.EMPTY;

    /**
     * (this field is optional)
     */
    public MessageRepeat messageRepeat() {
        initialize();
        return messageRepeat;
    }

    private SentDateTime sentDateTime = SentDateTime.EMPTY;

    /**
     * (this field is required)
     */
    public SentDateTime sentDateTime() {
        initialize();
        return sentDateTime;
    }

    private ListOfOnixElement<MessageNote, String> messageNotes = ListOfOnixElement.empty();

    /**
     * (this list may be empty)
     */
    public ListOfOnixElement<MessageNote, String> messageNotes() {
        initialize();
        return messageNotes;
    }

    private DefaultLanguageOfText defaultLanguageOfText = DefaultLanguageOfText.EMPTY;

    /**
     * (this field is optional)
     */
    public DefaultLanguageOfText defaultLanguageOfText() {
        initialize();
        return defaultLanguageOfText;
    }

    private DefaultPriceType defaultPriceType = DefaultPriceType.EMPTY;

    /**
     * (this field is optional)
     */
    public DefaultPriceType defaultPriceType() {
        initialize();
        return defaultPriceType;
    }

    private DefaultCurrencyCode defaultCurrencyCode = DefaultCurrencyCode.EMPTY;

    /**
     * (this field is optional)
     */
    public DefaultCurrencyCode defaultCurrencyCode() {
        initialize();
        return defaultCurrencyCode;
    }
}
