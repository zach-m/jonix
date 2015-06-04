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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tectonica.jonix.codelist.AvailabilityStatuss;
import com.tectonica.jonix.codelist.SupplierRoles;
import com.tectonica.jonix.onix3.ProductSupply;

@SuppressWarnings("serial")
public class BasicSupplyDetail implements Serializable
{
	public final SupplierRoles supplierRole;
	public final String supplierName;
	public final String availability; // name of an enum, AvailabilityStatuss or ProductAvailabilitys
	public final List<BasicPrice> prices;

	public BasicSupplyDetail(SupplierRoles supplierRole, String supplierName, String availability, List<BasicPrice> prices)
	{
		this.supplierRole = supplierRole;
		this.supplierName = supplierName;
		this.availability = availability;
		this.prices = prices;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (BasicPrice price : prices)
			sb.append("\n    > ").append(price.toString());
		String supplierRoleStr = (supplierRole == null) ? null : supplierRole.name();
		return String.format("SupplyDetail [%s]: %s (%s) %s", supplierRoleStr, supplierName, availability, sb.toString());
	}

	public static List<BasicSupplyDetail> extractFrom(com.tectonica.jonix.onix2.Product product)
	{
		if (product.supplyDetails != null)
		{
			List<BasicSupplyDetail> result = new ArrayList<>();
			for (com.tectonica.jonix.onix2.SupplyDetail sd : product.supplyDetails)
			{
				final AvailabilityStatuss availabilityCode = sd.getAvailabilityCodeValue();
				// NOTE: AvailabilityStatuss is a required field, we essentially bury here a validation error
				final String availCodeAsStr = (availabilityCode == null) ? null : availabilityCode.name();
				result.add(new BasicSupplyDetail(sd.getSupplierRoleValue(), sd.getSupplierNameValue(), availCodeAsStr, BasicPrice.extractFrom(sd)));
			}
			return result;
		}
		return Collections.emptyList();
	}

	public static List<BasicSupplyDetail> extractFrom(com.tectonica.jonix.onix3.Product product)
	{
		if (product.productSupplys != null)
		{
			List<BasicSupplyDetail> result = new ArrayList<>();
			for (ProductSupply ps : product.productSupplys) // scanning all markets, maybe not good idea
			{
				for (com.tectonica.jonix.onix3.SupplyDetail sd : ps.supplyDetails)
					result.add(new BasicSupplyDetail(sd.supplier.getSupplierRoleValue(), sd.supplier.getSupplierNameValue(), sd
							.getProductAvailabilityValue().name(), BasicPrice.extractFrom(sd)));
			}
			return result;
		}
		return Collections.emptyList();
	}
}