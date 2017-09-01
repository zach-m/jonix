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
 * marker interface to assist in IDE navigation to code-list 48 (Measure type code)
 */
interface CodeList48
{}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 48</b>
 * <p>
 * Description: Measure type code
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist48">ONIX Codelist 48 in Reference Guide</a>
 */
public enum MeasureTypes implements OnixCodelist, CodeList48
{
   /**
    * For a book, the spine height when standing on a shelf. For a folded map, the height when folded. In general, the height of a product in the form in which it is presented or packaged for retail sale
    */
   Height("01", "Height"), //

   /**
    * For a book, the horizontal dimension of the cover when standing upright. For a folded map, the width when folded. In general, the width of a product in the form in which it is presented or packaged for retail sale
    */
   Width("02", "Width"), //

   /**
    * For a book, the thickness of the spine. For a folded map, the thickness when folded. In general, the thickness or depth of a product in the form in which it is presented or packaged for retail sale
    */
   Thickness("03", "Thickness"), //

   /**
    * Not recommended for general use
    */
   Page_trim_height("04", "Page trim height"), //

   /**
    * Not recommended for general use
    */
   Page_trim_width("05", "Page trim width"), //

   Unit_weight("08", "Unit weight"), //

   /**
    * Of a globe, for example
    */
   Diameter_sphere("09", "Diameter (sphere)"), //

   /**
    * The height of a folded or rolled sheet map, poster etc when unfolded
    */
   Unfolded_unrolled_sheet_height("10", "Unfolded/unrolled sheet height"), //

   /**
    * The width of a folded or rolled sheet map, poster etc when unfolded
    */
   Unfolded_unrolled_sheet_width("11", "Unfolded/unrolled sheet width"), //

   /**
    * The diameter of the cross-section of a tube or cylinder, usually carrying a rolled sheet product. Use 01 'Height' for the height or length of the tube
    */
   Diameter_tube_or_cylinder("12", "Diameter (tube or cylinder)"), //

   /**
    * The length of a side of the cross-section of a long triangular or square package, usually carrying a rolled sheet product. Use 01 'Height' for the height or length of the package
    */
   Rolled_sheet_package_side_measure("13", "Rolled sheet package side measure");

   public final String code;
   public final String description;

   private MeasureTypes(String code, String description)
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

   private static volatile Map<String, MeasureTypes> map;

   private static Map<String, MeasureTypes> map()
   {
      Map<String, MeasureTypes> result = map;
      if (result == null)
      {
         synchronized(MeasureTypes.class)
         {
            result = map;
            if (result == null)
            {
               result = new HashMap<>();
               for (MeasureTypes e : values())
                  result.put(e.code, e);
               map = result;
            }
         }
      }
      return result;
   }

   public static MeasureTypes byCode(String code)
   {
      if (code == null || code.isEmpty())
         return null;
      return map().get(code);
   }
}
