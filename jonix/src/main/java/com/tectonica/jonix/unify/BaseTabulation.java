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

package com.tectonica.jonix.unify;

import com.tectonica.jonix.tabulate.Tabulation;

import static com.tectonica.jonix.unify.BaseFieldTabulator.Author;
import static com.tectonica.jonix.unify.BaseFieldTabulator.BIC;
import static com.tectonica.jonix.unify.BaseFieldTabulator.BISAC;
import static com.tectonica.jonix.unify.BaseFieldTabulator.Description;
import static com.tectonica.jonix.unify.BaseFieldTabulator.Dewey;
import static com.tectonica.jonix.unify.BaseFieldTabulator.Editor;
import static com.tectonica.jonix.unify.BaseFieldTabulator.ISBN13;
import static com.tectonica.jonix.unify.BaseFieldTabulator.Keywords;
import static com.tectonica.jonix.unify.BaseFieldTabulator.Language;
import static com.tectonica.jonix.unify.BaseFieldTabulator.NumOfPages;
import static com.tectonica.jonix.unify.BaseFieldTabulator.PriceAmount;
import static com.tectonica.jonix.unify.BaseFieldTabulator.PublicationDate;
import static com.tectonica.jonix.unify.BaseFieldTabulator.Publisher;
import static com.tectonica.jonix.unify.BaseFieldTabulator.SalesAllowedIn;
import static com.tectonica.jonix.unify.BaseFieldTabulator.SalesBannedIn;
import static com.tectonica.jonix.unify.BaseFieldTabulator.SeriesTitle;
import static com.tectonica.jonix.unify.BaseFieldTabulator.ShortDescription;
import static com.tectonica.jonix.unify.BaseFieldTabulator.Title;

/**
 * @author Zach Melamed
 * @since 1/21/2018
 */
public class BaseTabulation {

    public static final Tabulation<BaseRecord> ALL = Tabulation.<BaseRecord>create()
        .add(ISBN13.tabulator())
        .add(Title.tabulator())
        .add(SeriesTitle.tabulator())
        .add(Author.tabulator(3))
        .add(Editor.tabulator(2))
        .add(Language.tabulator())
        .add(NumOfPages.tabulator())
        .add(Publisher.tabulator())
        .add(PublicationDate.tabulator())
        .add(Dewey.tabulator())
        .add(BISAC.tabulator(5))
        .add(BIC.tabulator(5))
        .add(Keywords.tabulator())
        .add(PriceAmount.tabulator(3))
        .add(SalesAllowedIn.tabulator(3))
        .add(SalesBannedIn.tabulator(3))
        .add(Description.tabulator())
        .add(ShortDescription.tabulator());

    public static final Tabulation<BaseRecord> BASIC = Tabulation.<BaseRecord>create()
        .add(ISBN13.tabulator())
        .add(Title.tabulator())
        .add(SeriesTitle.tabulator())
        .add(Author.tabulator(3))
        .add(Language.tabulator())
        .add(Publisher.tabulator())
        .add(PublicationDate.tabulator())
        .add(ShortDescription.tabulator());
}
