/*
 * Copyright (C) 2012-2024 Zach Melamed
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

package com.tectonica.jonix.unify.base.onix3;

import com.tectonica.jonix.common.codelist.Languages;
import com.tectonica.jonix.onix3.Text;
import com.tectonica.jonix.onix3.TextContent;
import com.tectonica.jonix.unify.base.BaseText;

/**
 * ONIX3 concrete implementation for {@link BaseText}
 *
 * @author Zach Melamed
 */
public class BaseText3 extends BaseText {
    private static final long serialVersionUID = 1L;

    public BaseText3(TextContent textContent) {
        extract(textContent, this);
    }

    public static void extract(TextContent textContent, BaseText dest) {
        dest.textType = textContent.textType().value;
        Text textElement = pickTextObject(textContent);
        if (textElement != null) { // invalid ONIX
            dest.textFormat = textElement.textformat;
            dest.text = textElement.value;
        }
    }

    /**
     * ONIX-3 requires at least one &lt;Text&gt; element, and allow more than one to provide translations in several
     * languages. This simplistic implementation simply prioritizes English.
     */
    private static Text pickTextObject(TextContent textContent) {
        if (!textContent.texts().isEmpty()) {
            for (Text text : textContent.texts()) {
                if (text.language == null || text.language == Languages.English) {
                    return text;
                }
            }
            return textContent.texts().get(0); // return the first element, regardless of its language
        }
        return null;
    }
}