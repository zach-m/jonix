/*
 * Copyright (C) 2012-2022 Zach Melamed
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

import com.tectonica.jonix.onix3.Collection;
import com.tectonica.jonix.onix3.Contributor;
import com.tectonica.jonix.onix3.Imprint;
import com.tectonica.jonix.onix3.Price;
import com.tectonica.jonix.onix3.Product;
import com.tectonica.jonix.onix3.Publisher;
import com.tectonica.jonix.onix3.SalesRights;
import com.tectonica.jonix.onix3.SupplyDetail;
import com.tectonica.jonix.onix3.TextContent;
import com.tectonica.jonix.onix3.TitleDetail;
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

public class BaseFactory3 {

    public static final BaseFactory3 DEFAULT = new BaseFactory3();

    Function<Product, ? extends BaseInfo> baseInfoFactory = BaseInfo3::new;
    Function<Product, ? extends BaseDescription> baseDescriptionFactory = BaseDescription3::new;
    Function<Product, ? extends BasePublishingDetails> basePublishingDetailsFactory = BasePublishingDetails3::new;
    Function<Collection, ? extends BaseCollection> baseCollectionFactory = BaseCollection3::new;
    Function<Contributor, ? extends BaseContributor> baseContributorFactory = BaseContributor3::new;
    Function<Imprint, ? extends BaseImprint> baseImprintFactory = BaseImprint3::new;
    Function<Price, ? extends BasePrice> basePriceFactory = BasePrice3::new;
    Function<Publisher, ? extends BasePublisher> basePublisherFactory = BasePublisher3::new;
    Function<SalesRights, ? extends BaseSalesRights> baseSalesRightsFactory = BaseSalesRights3::new;
    Function<SupplyDetail, ? extends BaseSupplyDetail> baseSupplyDetailFactory = BaseSupplyDetail3::new;
    Function<TextContent, ? extends BaseText> baseTextFactory = BaseText3::new;
    Function<TitleDetail, ? extends BaseTitle> baseTitleFactory = BaseTitle3::new;

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

    public BaseFactory3 setBaseCollectionFactory(
        Function<Collection, ? extends BaseCollection> baseCollectionFactory) {
        this.baseCollectionFactory = baseCollectionFactory;
        return this;
    }

    public BaseFactory3 setBaseContributorFactory(
        Function<Contributor, ? extends BaseContributor> baseContributorFactory) {
        this.baseContributorFactory = baseContributorFactory;
        return this;
    }

    public BaseFactory3 setBaseImprintFactory(
        Function<Imprint, ? extends BaseImprint> baseImprintFactory) {
        this.baseImprintFactory = baseImprintFactory;
        return this;
    }

    public BaseFactory3 setBasePriceFactory(
        Function<Price, ? extends BasePrice> basePriceFactory) {
        this.basePriceFactory = basePriceFactory;
        return this;
    }

    public BaseFactory3 setBasePublisherFactory(
        Function<Publisher, ? extends BasePublisher> basePublisherFactory) {
        this.basePublisherFactory = basePublisherFactory;
        return this;
    }

    public BaseFactory3 setBaseSalesRightsFactory(
        Function<SalesRights, ? extends BaseSalesRights> baseSalesRightsFactory) {
        this.baseSalesRightsFactory = baseSalesRightsFactory;
        return this;
    }

    public BaseFactory3 setBaseSupplyDetailFactory(
        Function<SupplyDetail, ? extends BaseSupplyDetail> baseSupplyDetailFactory) {
        this.baseSupplyDetailFactory = baseSupplyDetailFactory;
        return this;
    }

    public BaseFactory3 setBaseTextFactory(
        Function<TextContent, ? extends BaseText> baseTextFactory) {
        this.baseTextFactory = baseTextFactory;
        return this;
    }

    public BaseFactory3 setBaseTitleFactory(
        Function<TitleDetail, ? extends BaseTitle> baseTitleFactory) {
        this.baseTitleFactory = baseTitleFactory;
        return this;
    }
}
