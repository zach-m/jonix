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

package com.tectonica.jonix.onix3;

import java.io.Serializable;
import com.tectonica.jonix.JPU;
import com.tectonica.jonix.OnixElement;
import com.tectonica.jonix.codelist.*;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * <h1>Stock quantity code type name</h1><p>A name that identifies a proprietary stock quantity coding scheme (<i>ie</i> a scheme which is not a standard and for which there is no individual ID type code). Must be used when, and only when the code in the &lt;StockQuantityCodeType&gt; element indicates a proprietary scheme, <i>eg</i> a wholesaler’s own code. Optional, and non-repeating.</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Variable length text, suggested maximum length 50 characters</td></tr><tr><td>Reference name</td><td><tt>&lt;StockQuantityCodeTypeName&gt;</tt></td></tr><tr><td>Short tag</td><td><tt>&lt;j296&gt;</tt></td></tr><tr><td>Cardinality</td><td>0&#8230;1</td></tr><tr><td>Attributes</td><td>language</td></tr><tr><td>Example</td><td><tt>&lt;j296&gt;IngramSQ&lt;/j296&gt;</tt></td></tr></table>
 * <p>&nbsp;</p>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;StockQuantityCoded&gt;</li>
 * </ul>
 * <p>&nbsp;</p>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Stock ⯈ StockQuantityCoded ⯈ StockQuantityCodeTypeName</li>
 * </ul>
 */
public class StockQuantityCodeTypeName implements OnixElement<String>, Serializable
{
   private static final long serialVersionUID = 1L;

   public static final String refname = "StockQuantityCodeTypeName";
   public static final String shortname = "j296";

   /////////////////////////////////////////////////////////////////////////////////
   // ATTRIBUTES
   /////////////////////////////////////////////////////////////////////////////////

   /**
    * (type: dt.DateOrDateTime)
    */
   public String datestamp;

   public RecordSourceTypes sourcetype;

   /**
    * (type: dt.NonEmptyString)
    */
   public String sourcename;

   public Languages language;

   /////////////////////////////////////////////////////////////////////////////////
   // VALUE MEMBER
   /////////////////////////////////////////////////////////////////////////////////

   /**
   * Raw Format: Variable length text, suggested maximum length 50 characters<p>
   * (type: dt.NonEmptyString)
   */
   public String value;

   /**
   * Internal API, use the {@link #value()} method or the {@link #value} field instead
   */
   @Override
   public String _value() {
      return value;
   }

   /////////////////////////////////////////////////////////////////////////////////
   // SERVICES
   /////////////////////////////////////////////////////////////////////////////////

   private final boolean exists;
   public static final StockQuantityCodeTypeName EMPTY = new StockQuantityCodeTypeName();

   public StockQuantityCodeTypeName() {
      exists = false;
   }

   public StockQuantityCodeTypeName(org.w3c.dom.Element element) {
      exists = true;
      datestamp = JPU.getAttribute(element, "datestamp");
      sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
      sourcename = JPU.getAttribute(element, "sourcename");
      language = Languages.byCode(JPU.getAttribute(element, "language"));

      value = JPU.getContentAsString(element);
   }

   /**
    * @return whether this tag (&lt;StockQuantityCodeTypeName&gt; or &lt;j296&gt;) is explicitly provided in the ONIX XML
    */
   @Override
   public boolean exists() {
      return exists;
   }
}
