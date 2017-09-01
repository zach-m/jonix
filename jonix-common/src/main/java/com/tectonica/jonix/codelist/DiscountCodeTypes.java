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
 * marker interface to assist in IDE navigation to code-list 100 (Discount code type)
 */
interface CodeList100
{}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 100</b>
 * <p>
 * Description: Discount code type
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist100">ONIX Codelist 100 in Reference Guide</a>
 */
public enum DiscountCodeTypes implements OnixCodelist, CodeList100
{
   /**
    * UK publisher's or distributor's discount group code in a format specified by BIC to ensure uniqueness
    */
   BIC_discount_group_code("01", "BIC discount group code"), //

   /**
    * A publisher's or supplier's own code which identifies a trade discount category, the actual discount being set by trading partner agreement (applies to goods supplied on standard trade discounting terms)
    */
   Proprietary_discount_code("02", "Proprietary discount code"), //

   /**
    * Terms code used in the Netherlands book trade
    */
   Boeksoort("03", "Boeksoort"), //

   /**
    * Terms code used in German ONIX applications
    */
   German_terms_code("04", "German terms code"), //

   /**
    * A publisher's or supplier's own code which identifies a commission rate category, the actual commission rate being set by trading partner agreement (applies to goods supplied on agency terms)
    */
   Proprietary_commission_code("05", "Proprietary commission code"), //

   /**
    * UK publisher's or distributor's commission group code in format specified by BIC to ensure uniqueness. Format is identical to BIC discount group code, but indicates a commission rather than a discount (applies to goods supplied on agency terms)
    */
   BIC_commission_group_code("06", "BIC commission group code");

   public final String code;
   public final String description;

   private DiscountCodeTypes(String code, String description)
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

   public static DiscountCodeTypes byCode(String code)
   {
      if (code == null || code.isEmpty())
         return null;
      for (DiscountCodeTypes e : values())
         if (e.code.equals(code))
            return e;
      return null;
   }
}
