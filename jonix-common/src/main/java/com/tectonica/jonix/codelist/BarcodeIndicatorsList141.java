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
 * marker interface to assist in IDE navigation to code-list 141 (Barcode indicator)
 */
interface CodeList141
{}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 141</b>
 * <p>
 * Description: Barcode indicator
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist141">ONIX Codelist 141 in Reference Guide</a>
 */
public enum BarcodeIndicatorsList141 implements OnixCodelist, CodeList141
{
   Not_barcoded("00", "Not barcoded"), //

   Barcoded_scheme_unspecified("01", "Barcoded, scheme unspecified"), //

   GTIN_13("02", "GTIN-13"), //

   GTIN_13_5_US_dollar_price_encoded("03", "GTIN-13+5 (US dollar price encoded)"), //

   GTIN_13_5_CAN_dollar_price_encoded("04", "GTIN-13+5 (CAN dollar price encoded)"), //

   GTIN_13_5_no_price_encoded("05", "GTIN-13+5 (no price encoded)"), //

   /**
    * AKA item/price
    */
   UPC_12_item_specific("06", "UPC-12 (item-specific)"), //

   /**
    * AKA item/price
    */
   UPC_12_5_item_specific("07", "UPC-12+5 (item-specific)"), //

   /**
    * AKA price/item
    */
   UPC_12_price_point("08", "UPC-12 (price-point)"), //

   /**
    * AKA price/item
    */
   UPC_12_5_price_point("09", "UPC-12+5 (price-point)");

   public final String code;
   public final String description;

   private BarcodeIndicatorsList141(String code, String description)
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

   private static volatile Map<String, BarcodeIndicatorsList141> map;

   private static Map<String, BarcodeIndicatorsList141> map()
   {
      Map<String, BarcodeIndicatorsList141> result = map;
      if (result == null)
      {
         synchronized(BarcodeIndicatorsList141.class)
         {
            result = map;
            if (result == null)
            {
               result = new HashMap<>();
               for (BarcodeIndicatorsList141 e : values())
                  result.put(e.code, e);
               map = result;
            }
         }
      }
      return result;
   }

   public static BarcodeIndicatorsList141 byCode(String code)
   {
      if (code == null || code.isEmpty())
         return null;
      return map().get(code);
   }
}
