/*
 * Copyright (C) 2012-2023 Zach Melamed
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

package com.tectonica.jonix.unify.base.onix2;

import com.tectonica.jonix.common.codelist.OtherTextTypes;
import com.tectonica.jonix.common.codelist.TextTypes;
import com.tectonica.jonix.onix2.OtherText;
import com.tectonica.jonix.unify.base.BaseText;

/**
 * ONIX2 concrete implementation for {@link BaseText}
 *
 * @author Zach Melamed
 */
public class BaseText2 extends BaseText {
    private static final long serialVersionUID = 1L;

    public BaseText2(OtherText otherText) {
        extract(otherText, this);
    }

    public static void extract(OtherText otherText, BaseText dest) {
        dest.textType = translate33to153(otherText.textTypeCode().value);
        dest.textFormat = otherText.textFormat().value;
        if (otherText.text() != null) {
            dest.text = otherText.text().value;
            if (dest.textFormat == null) {
                dest.textFormat = otherText.text().textformat;
            }
        }
    }

    /**
     * translation table from Onix2's Code-List-33 to Onix3's Code-List-153, based on page 8 in <a href=
     * "http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_10_Changes_for_3.0.pdf"
     * >this document from Editeur</a>
     */
    private static TextTypes translate33to153(OtherTextTypes o) {
        switch (o) {
            case Main_description:
                return TextTypes.Description;
            case Short_description_annotation:
                return TextTypes.Short_description_annotation;
            case Long_description:
                return TextTypes.Description;
            case Table_of_contents:
                return TextTypes.Table_of_contents;
            case Quote_from_review_of_previous_edition:
                return TextTypes.Review_quote_previous_edition;
            case Review_quote:
                return TextTypes.Review_quote;
            case Promotional_headline:
                return TextTypes.Promotional_headline;
            case Previous_review_quote:
                return TextTypes.Review_quote_previous_work;
            case Description_for_reader:
                return TextTypes.Description;
            case Biographical_note:
                return TextTypes.Biographical_note;
            case Competing_titles:
                return TextTypes.Description;
            case Flap_copy:
                return TextTypes.Primary_cover_copy;
            case Back_cover_copy:
                return TextTypes.Primary_cover_copy;
            case Feature:
                return TextTypes.Feature;
            case New_feature:
                return TextTypes.Feature;
            case Publishers_notice:
                return TextTypes.Publishers_notice;
            case Index:
                return TextTypes.Index;
            case Excerpt_from_book:
                return TextTypes.Excerpt;
            case Description_for_sales_people:
                return TextTypes.Description;
            case Description_for_press_or_other_media:
                return TextTypes.Description;
            case Description_for_teachers_educators:
                return TextTypes.Description;
            case Unpublished_endorsement:
                return TextTypes.Endorsement;
            case Description_for_bookstore:
                return TextTypes.Description;
            case Description_for_library:
                return TextTypes.Description;
            default:
                return null;
        }
    }
}