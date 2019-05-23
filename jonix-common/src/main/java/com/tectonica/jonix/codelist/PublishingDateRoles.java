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

package com.tectonica.jonix.codelist;

import com.tectonica.jonix.OnixCodelist;

import java.util.HashMap;
import java.util.Map;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 163 (Publishing date role)
 */
interface CodeList163 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 163</b>
 * <p>
 * Description: Publishing date role
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_45.html#codelist163">ONIX
 * Codelist 163 in Reference Guide</a>
 */
public enum PublishingDateRoles implements OnixCodelist, CodeList163 {
    /**
     * Nominal date of publication. This date is primarily used for planning, promotion and other business process
     * purposes, and is not necessarily the first date for retail sales or fulfillment of pre-orders. In the absence of
     * a sales embargo date, retail sales and pre-order fulfillment may begin as soon as stock is available to the
     * retailer
     */
    Publication_date("01", "Publication date"), //

    /**
     * If there is an embargo on retail sales (in the market) before a certain date, the date from which the embargo is
     * lifted and retail sales and fulfillment of pre-orders are permitted. In the absence of an embargo date, retail
     * sales and pre-order fulfillment may begin as soon as stock is available to the retailer
     */
    Sales_embargo_date("02", "Sales embargo date"), //

    /**
     * Date when a new product may be announced to the general public. In the absence of an announcement date, the
     * planned product may be announced to the public as soon as metadata is available
     */
    Public_announcement_date("09", "Public announcement date"), //

    /**
     * Date when a new product may be announced to the book trade only. In the absence of a trade announcement date, the
     * planned product may be announced to supply chain partners (but not necessarily made public) as soon as metadata
     * is available
     */
    Trade_announcement_date("10", "Trade announcement date"), //

    /**
     * Date when the work incorporated in a product was first published. For works in translation, see also Date of
     * first publication in original language (code 20)
     */
    Date_of_first_publication("11", "Date of first publication"), //

    /**
     * Date when a product was last reprinted
     */
    Last_reprint_date("12", "Last reprint date"), //

    /**
     * Date when a product was (or will be) declared out-of-print or deleted
     */
    Out_of_print_deletion_date("13", "Out-of-print / deletion date"), //

    /**
     * Date when a product was last reissued
     */
    Last_reissue_date("16", "Last reissue date"), //

    /**
     * Date of publication of a printed book which is the direct print counterpart to a digital product. The counterpart
     * product may be included in &lt;RelatedProduct&gt; using code 13
     */
    Publication_date_of_print_counterpart("19", "Publication date of print counterpart"), //

    /**
     * Date when the original language version of work incorporated in a product was first published (note, use only on
     * works in translation - see code 11 for first publication date in the translated language)
     */
    Date_of_first_publication_in_original_language("20", "Date of first publication in original language"), //

    /**
     * Date when a product will be reissued
     */
    Forthcoming_reissue_date("21", "Forthcoming reissue date"), //

    /**
     * Date when a product that has been temporary withdrawn from sale or recalled for any reason is expected to become
     * available again, eg after correction of quality or technical issues
     */
    Expected_availability_date_after_temporary_withdrawal("22",
        "Expected availability date after temporary withdrawal"), //

    /**
     * Date from which reviews of a product may be published eg in newspapers and magazines or online. Provided to the
     * book trade for information only: newspapers and magazines are not expected to be recipients of ONIX metadata
     */
    Review_embargo_date("23", "Review embargo date"), //

    /**
     * Latest date on which an order may be placed with the publisher for guaranteed delivery prior to the publication
     * date. May or may not be linked to a special reservation or pre-publication price
     */
    Publisher_s_reservation_order_deadline("25", "Publisher’s reservation order deadline"), //

    /**
     * Date when a product will be reprinted
     */
    Forthcoming_reprint_date("26", "Forthcoming reprint date"), //

    /**
     * Earliest date a retail 'preorder' can be placed (in the market), where this is distinct from the public
     * announcement date. In the absence of a preorder embargo, advance orders can be placed as soon as metadata is
     * available to the consumer (this would be the public announcement date, or in the absence of a public announcement
     * date, the earliest date metadata is available to the retailer)
     */
    Preorder_embargo_date("27", "Preorder embargo date"), //

    /**
     * Date of acquisition of product by new publisher (use with publishing roles 09 and 13)
     */
    Transfer_date("28", "Transfer date"), //

    /**
     * For an audiovisual work (eg on DVD)
     */
    Date_of_production("29", "Date of production"), //

    /**
     * For digital products that are available to end customers both as a download and streamed, the earliest date the
     * product can be made available on a stream, where the streamed version becomes available later than the download.
     * For the download, see code 02 if it is embargoed or code 01 if there is no embargo
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Streaming_embargo_date("30", "Streaming embargo date"), //

    /**
     * For digital products that are available to end customers both as purchases and as part of a subscription package,
     * the earliest date the product can be made available by subscription, where the product may not be included in a
     * subscription package until shome while after publication. For ordinary sales, see code 02 if there is a sales
     * embargo or code 01 if there is no embargo
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Subscription_embargo_date("31", "Subscription embargo date");

    public final String code;
    public final String description;

    PublishingDateRoles(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    private static volatile Map<String, PublishingDateRoles> map;

    private static Map<String, PublishingDateRoles> map() {
        Map<String, PublishingDateRoles> result = map;
        if (result == null) {
            synchronized (PublishingDateRoles.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (PublishingDateRoles e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static PublishingDateRoles byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
