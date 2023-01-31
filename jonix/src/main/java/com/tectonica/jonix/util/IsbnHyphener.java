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

package com.tectonica.jonix.util;

import repackaged.net.sourceforge.isbnhyphenappender.ISBNHyphenAppender;

public class IsbnHyphener {
    private static final ISBNHyphenAppender hyphener = new ISBNHyphenAppender();

    public static String hyphenatedIsbn(String isbn) {
        if (isbn == null) {
            return null;
        }

        try {
            return hyphener.appendHyphenToISBN(isbn);
        } catch (UnsupportedOperationException uoe) {
            // fall back to a simplistic hyphenation
            // TODO: log warning?
            if (isbn.length() == 13) {
                return isbn.substring(0, 0 + 3) + "-" + isbn.substring(3, 3 + 1) + "-" + isbn.substring(4, 4 + 4) + "-"
                    + isbn.substring(8, 8 + 4) + "-" + isbn.substring(12, 12 + 1);
            }

            if (isbn.length() == 10) {
                return isbn.substring(0, 0 + 1) + "-" + isbn.substring(1, 1 + 4) + "-" + isbn.substring(5, 5 + 4) + "-"
                    + isbn.substring(9, 9 + 1);
            }

            // fall back to the original..
            return isbn;
        }
    }
}
