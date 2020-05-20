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

package com.tectonica.jonix.unify.base.onix2;

import com.tectonica.jonix.onix2.Contributor;
import com.tectonica.jonix.onix2.Imprint;
import com.tectonica.jonix.onix2.OtherText;
import com.tectonica.jonix.onix2.Price;
import com.tectonica.jonix.onix2.Product;
import com.tectonica.jonix.onix2.Publisher;
import com.tectonica.jonix.onix2.SalesRights;
import com.tectonica.jonix.onix2.Series;
import com.tectonica.jonix.onix2.SupplyDetail;
import com.tectonica.jonix.onix2.Title;
import com.tectonica.jonix.unify.base.BaseCollection;
import com.tectonica.jonix.unify.base.BaseContributor;
import com.tectonica.jonix.unify.base.BaseDescription;
import com.tectonica.jonix.unify.base.BaseImprint;
import com.tectonica.jonix.unify.base.BaseInfo;
import com.tectonica.jonix.unify.base.BasePrice;
import com.tectonica.jonix.unify.base.BasePublisher;
import com.tectonica.jonix.unify.base.BasePublishingDetails;
import com.tectonica.jonix.unify.base.BaseSalesRights;
import com.tectonica.jonix.unify.base.BaseSupplyDetail;
import com.tectonica.jonix.unify.base.BaseText;
import com.tectonica.jonix.unify.base.BaseTitle;

import java.util.function.Function;

public class BaseFactory2 {

    public static final BaseFactory2 DEFAULT = new BaseFactory2();

    Function<Product, ? extends BaseInfo> baseInfoFactory = BaseInfo2::new;
    Function<Product, ? extends BaseDescription> baseDescriptionFactory = BaseDescription2::new;
    Function<Product, ? extends BasePublishingDetails> basePublishingDetailsFactory = BasePublishingDetails2::new;
    Function<Series, ? extends BaseCollection> baseCollectionFactory = BaseCollection2::new;
    Function<Contributor, ? extends BaseContributor> baseContributorFactory = BaseContributor2::new;
    Function<Imprint, ? extends BaseImprint> baseImprintFactory = BaseImprint2::new;
    Function<Price, ? extends BasePrice> basePriceFactory = BasePrice2::new;
    Function<Publisher, ? extends BasePublisher> basePublisherFactory = BasePublisher2::new;
    Function<SalesRights, ? extends BaseSalesRights> baseSalesRightsFactory = BaseSalesRights2::new;
    Function<SupplyDetail, ? extends BaseSupplyDetail> baseSupplyDetailFactory = BaseSupplyDetail2::new;
    Function<OtherText, ? extends BaseText> baseTextFactory = BaseText2::new;
    Function<Title, ? extends BaseTitle> baseTitleFactory = BaseTitle2::new;

    public void setBaseInfoFactory(
        Function<Product, ? extends BaseInfo> baseInfoFactory) {
        this.baseInfoFactory = baseInfoFactory;
    }

    public void setBaseDescriptionFactory(
        Function<Product, ? extends BaseDescription> baseDescriptionFactory) {
        this.baseDescriptionFactory = baseDescriptionFactory;
    }

    public void setBasePublishingDetailsFactory(
        Function<Product, ? extends BasePublishingDetails> basePublishingDetailsFactory) {
        this.basePublishingDetailsFactory = basePublishingDetailsFactory;
    }

    public BaseFactory2 setBaseCollectionFactory(
        Function<Series, ? extends BaseCollection> baseCollectionFactory) {
        this.baseCollectionFactory = baseCollectionFactory;
        return this;
    }

    public BaseFactory2 setBaseContributorFactory(
        Function<Contributor, ? extends BaseContributor> baseContributorFactory) {
        this.baseContributorFactory = baseContributorFactory;
        return this;
    }

    public BaseFactory2 setBaseImprintFactory(
        Function<Imprint, ? extends BaseImprint> baseImprintFactory) {
        this.baseImprintFactory = baseImprintFactory;
        return this;
    }

    public BaseFactory2 setBasePriceFactory(
        Function<Price, ? extends BasePrice> basePriceFactory) {
        this.basePriceFactory = basePriceFactory;
        return this;
    }

    public BaseFactory2 setBasePublisherFactory(
        Function<Publisher, ? extends BasePublisher> basePublisherFactory) {
        this.basePublisherFactory = basePublisherFactory;
        return this;
    }

    public BaseFactory2 setBaseSalesRightsFactory(
        Function<SalesRights, ? extends BaseSalesRights> baseSalesRightsFactory) {
        this.baseSalesRightsFactory = baseSalesRightsFactory;
        return this;
    }

    public BaseFactory2 setBaseSupplyDetailFactory(
        Function<SupplyDetail, ? extends BaseSupplyDetail> baseSupplyDetailFactory) {
        this.baseSupplyDetailFactory = baseSupplyDetailFactory;
        return this;
    }

    public BaseFactory2 setBaseTextFactory(
        Function<OtherText, ? extends BaseText> baseTextFactory) {
        this.baseTextFactory = baseTextFactory;
        return this;
    }

    public BaseFactory2 setBaseTitleFactory(
        Function<Title, ? extends BaseTitle> baseTitleFactory) {
        this.baseTitleFactory = baseTitleFactory;
        return this;
    }
}
