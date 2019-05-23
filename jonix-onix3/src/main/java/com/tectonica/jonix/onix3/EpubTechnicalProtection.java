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
 * <h1>Digital product technical protection</h1><p>An ONIX code specifying whether a digital product has DRM or other technical protection features. Optional, and repeatable if a product has two or more kinds of protection (<i>ie</i> different parts of a product are protected in different ways).</p><table border='1' cellpadding='3'><tr><td>Format</td><td>Fixed length, two digits</td></tr><tr><td>Codelist</td><td>List 144</td></tr><tr><td>Reference name</td><td><tt>&lt;EpubTechnicalProtection&gt;</tt></td></tr><tr><td>Short tag</td><td><tt>&lt;x317&gt;</tt></td></tr><tr><td>Cardinality</td><td>0&#8230;n</td></tr><tr><td>Example</td><td><tt>&lt;x317&gt;03&lt;/x317&gt;</tt> (Has digital watermarking)</td></tr><tr><td>Notes</td><td>'Epub' ('e-publication') here and in other element names below refers to any digital product, and has no necessary link with the .epub file format developed by the IDPF</td></tr></table>
 * <p>&nbsp;</p>
 * This tag may be included in the following composites:
 * <ul>
 * <li>&lt;DescriptiveDetail&gt;</li>
 * <li>&lt;Price&gt;</li>
 * </ul>
 * <p>&nbsp;</p>
 * Possible placements within ONIX message:
 * <ul>
 * <li>ONIXMessage ⯈ Product ⯈ DescriptiveDetail ⯈ EpubTechnicalProtection</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Reissue ⯈ Price ⯈ EpubTechnicalProtection</li>
 * <li>ONIXMessage ⯈ Product ⯈ ProductSupply ⯈ SupplyDetail ⯈ Price ⯈ EpubTechnicalProtection</li>
 * </ul>
 */
public class EpubTechnicalProtection implements OnixElement<EpublicationTechnicalProtections>, Serializable
{
   private static final long serialVersionUID = 1L;

   public static final String refname = "EpubTechnicalProtection";
   public static final String shortname = "x317";

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

   /////////////////////////////////////////////////////////////////////////////////
   // VALUE MEMBER
   /////////////////////////////////////////////////////////////////////////////////

   public EpublicationTechnicalProtections value;

   /**
   * Internal API, use the {@link #value()} method or the {@link #value} field instead
   */
   @Override
   public EpublicationTechnicalProtections _value() {
      return value;
   }

   /////////////////////////////////////////////////////////////////////////////////
   // SERVICES
   /////////////////////////////////////////////////////////////////////////////////

   private final boolean exists;
   public static final EpubTechnicalProtection EMPTY = new EpubTechnicalProtection();

   public EpubTechnicalProtection() {
      exists = false;
   }

   public EpubTechnicalProtection(org.w3c.dom.Element element) {
      exists = true;
      datestamp = JPU.getAttribute(element, "datestamp");
      sourcetype = RecordSourceTypes.byCode(JPU.getAttribute(element, "sourcetype"));
      sourcename = JPU.getAttribute(element, "sourcename");

      value = EpublicationTechnicalProtections.byCode(JPU.getContentAsString(element));
   }

   /**
    * @return whether this tag (&lt;EpubTechnicalProtection&gt; or &lt;x317&gt;) is explicitly provided in the ONIX XML
    */
   @Override
   public boolean exists() {
      return exists;
   }
}
