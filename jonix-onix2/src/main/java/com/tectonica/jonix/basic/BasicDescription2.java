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

package com.tectonica.jonix.basic;

import com.tectonica.jonix.JPU;
import com.tectonica.jonix.basic.BasicDescription;
import com.tectonica.jonix.codelist.ProductForms;
import com.tectonica.jonix.onix2.Product;

/**
 * ONIX2 concrete implementation for {@link BasicDescription}
 * 
 * @author Zach Melamed
 */
public class BasicDescription2 extends BasicDescription
{
	private static final long serialVersionUID = 1L;

	public BasicDescription2(Product product)
	{
		editionType = (product.editionTypeCodes == null) ? null : product.editionTypeCodes.get(0).value;
		editionNumber = JPU.convertStringToInteger(product.getEditionNumberValue());
		ProductForms productFormValue = product.getProductFormValue();
		productForm = (productFormValue == null) ? null : productFormValue.name();
		numberOfPages = product.getNumberOfPagesValue();
		languages = product.findLanguages(null); // TODO: lazy
		audiences = product.findAudiences(null); // TODO: lazy
	}

//	public BasicDescription2(com.tectonica.jonix.onix3.Product product)
//	{
//		com.tectonica.jonix.onix3.DescriptiveDetail dd = product.descriptiveDetail;
//		if (dd != null)
//		{
//			List<EditionTypes> editionTypes = dd.getEditionTypeValues();
//			editionType = (editionTypes == null) ? null : editionTypes.get(0);
//			editionNumber = dd.getEditionNumberValue();
//			ProductFormsList150 productFormValue = dd.getProductFormValue();
//			productForm = (productFormValue == null) ? null : productFormValue.name();
//			JonixExtent jNumberOfPages = dd.findExtent(ExtentTypes.Main_content_page_count);
//			numberOfPages = (jNumberOfPages == null) ? null : jNumberOfPages.extentValue.toString();
//			languages = dd.findLanguages(null);
//			audiences = dd.findAudiences(null);
//		}
//		else
//		{
//			editionType = null;
//			editionNumber = null;
//			productForm = null;
//			numberOfPages = null;
//			languages = Collections.emptyList();
//			audiences = Collections.emptyList();
//		}
//	}
}
