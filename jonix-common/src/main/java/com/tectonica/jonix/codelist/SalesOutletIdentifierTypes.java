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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 102 (Sales outlet identifier type)
 */
interface CodeList102
{}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 102</b>
 * <p>
 * Description: Sales outlet identifier type
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist102">ONIX Codelist 102 in Reference Guide</a>
 */
public enum SalesOutletIdentifierTypes implements OnixCodelist, CodeList102
{
   /**
    * Proprietary list of retail and other end-user sales outlet IDs
    */
   Proprietary("01", "Proprietary"), //

   /**
    * DEPRECATED - use code 03
    */
   BIC_sales_outlet_ID_code("02", "BIC sales outlet ID code"), //

   /**
    * Use with ONIX retail and other end-user sales outlet IDs from List 139
    */
   ONIX_retail_sales_outlet_ID_code("03", "ONIX retail sales outlet ID code");

   public final String code;
   public final String description;

   private SalesOutletIdentifierTypes(String code, String description)
   {
      this.code = code;
      this.description = description;
   }

   @Override
   public String getCode()
   {
      return code;
   }

   @Override
   public String getDescription()
   {
      return description;
   }

   public static SalesOutletIdentifierTypes byCode(String code)
   {
      if (code == null || code.isEmpty())
         return null;
      for (SalesOutletIdentifierTypes e : values())
         if (e.code.equals(code))
            return e;
      return null;
   }
}
