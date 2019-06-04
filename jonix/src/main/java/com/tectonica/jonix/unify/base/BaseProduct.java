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

package com.tectonica.jonix.unify.base;

import com.tectonica.jonix.common.OnixProduct;

import java.io.Serializable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Contains the essential information included in ONIX &lt;Product&gt;.
 * <p>
 * Provided as part of the 'base' suite of classes whose goal is to extract the most important information from an ONIX
 * source (be it ONIX2 or ONIX3) and make it available for other various uses (print in a tabular format, search, sort,
 * etc.). The classes of the 'base' suite bridge the gap between ONIX versions, and provide a unified view of the
 * content, allowing the user to write a version-agnostic code.
 * <p>
 * NOTE: to access the information, use the public fields directly. No getters() are included..
 *
 * @author Zach Melamed
 */
@SuppressWarnings("serial")
public abstract class BaseProduct implements Serializable {
    public transient OnixProduct onixProduct;

    public BaseInfo info;
    public BaseDescription description;
    public BasePublishingDetails publishingDetails;

    public BaseTitles titles;
    public BaseContributors contributors;
    public BaseCollections collections;
    public BaseSubjects subjects;
    public BaseTexts texts;
    public BasePublishers publishers;
    public BaseImprints imprints;
    public BaseSupplyDetails supplyDetails;
    public BaseSalesRightss salesRightss;

    public String getLabel() {
        return (titles.size() > 0) ? titles.get(0).titleText : info.recordReference;
    }

    @Override
    public String toString() {
        return Stream.concat(
            titles.stream().map(title -> String.format("%s='%s'", title.titleType, title.titleText)),
            info.productIds.stream().map(pid -> String.format("%s=%s", pid.productIDType, pid.idValue))
        ).collect(Collectors.joining(", ", "[", "]"));
    }
}
