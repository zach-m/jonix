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

import java.util.Map;
import java.util.HashMap;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 71 (Sales restriction type code)
 */
interface CodeList71
{}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 71</b>
 * <p>
 * Description: Sales restriction type code
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist71">ONIX Codelist 71 in Reference Guide</a>
 */
public enum SalesRestrictionTypes implements OnixCodelist, CodeList71
{
   /**
    * Restriction must be described in &lt;SalesRestrictionDetail&gt; (ONIX 2.1) or &lt;SalesRestrictionNote&gt; (ONIX 3.0)
    */
   Unspecified_see_text("00", "Unspecified – see text"), //

   /**
    * For sale only through designated retailer. Retailer must be identified or named in an instance of the &lt;SalesOutlet&gt; composite. Use only when it is not possible to assign the more explicit code 04 or 05
    */
   Retailer_exclusive_own_brand("01", "Retailer exclusive / own brand"), //

   /**
    * For editions sold only though office supplies wholesalers. Retailer(s) and/or distributor(s) may be identified or named in an instance of the &lt;SalesOutlet&gt; composite
    */
   Office_supplies_edition("02", "Office supplies edition"), //

   /**
    * For an ISBN that is assigned for a publisher's internal purposes
    */
   Internal_publisher_use_only_do_not_list("03", "Internal publisher use only: do not list"), //

   /**
    * For sale only through designated retailer, though not under retailer's own brand/imprint. Retailer must be identified or named in an instance of the &lt;SalesOutlet&gt; composite
    */
   Retailer_exclusive("04", "Retailer exclusive"), //

   /**
    * For sale only through designated retailer under retailer's own brand/imprint. Retailer must be identified or named in an instance of the &lt;SalesOutlet&gt; composite
    */
   Retailer_own_brand("05", "Retailer own brand"), //

   /**
    * For sale to libraries only; not for sale through retail trade
    */
   Library_edition("06", "Library edition"), //

   /**
    * For sale directly to schools only; not for sale through retail trade
    */
   Schools_only_edition("07", "Schools only edition"), //

   /**
    * Indexed for the German market - in Deutschland indiziert
    */
   Indiziert("08", "Indiziert"), //

   /**
    * Expected to apply in particular to digital products for consumer sale where the publisher does not permit the product to be supplied to libraries who provide an ebook loan service
    */
   Not_for_sale_to_libraries("09", "Not for sale to libraries"), //

   /**
    * For editions sold only through newsstands/newsagents
    */
   News_outlet_edition("10", "News outlet edition"), //

   /**
    * Not for sale through designated retailer. Retailer must be identified or named in an instance of the &lt;SalesOutlet&gt; composite
    */
   Retailer_exception("11", "Retailer exception"), //

   /**
    * Not for sale to organisations or services offering consumers subscription access to a library of books
&lt;p&gt;NOTE: Introduced in Onix3
    */
   Not_for_sale_to_subscription_services("12", "Not for sale to subscription services"), //

   /**
    * Restricted to organisations or services offering consumers subscription access to a library of books
&lt;p&gt;NOTE: Introduced in Onix3
    */
   Subscription_services_only("13", "Subscription services only");

   public final String code;
   public final String description;

   private SalesRestrictionTypes(String code, String description)
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

   private static volatile Map<String, SalesRestrictionTypes> map;

   private static Map<String, SalesRestrictionTypes> map()
   {
      Map<String, SalesRestrictionTypes> result = map;
      if (result == null)
      {
         synchronized(SalesRestrictionTypes.class)
         {
            result = map;
            if (result == null)
            {
               result = new HashMap<>();
               for (SalesRestrictionTypes e : values())
                  result.put(e.code, e);
               map = result;
            }
         }
      }
      return result;
   }

   public static SalesRestrictionTypes byCode(String code)
   {
      if (code == null || code.isEmpty())
         return null;
      return map().get(code);
   }
}
