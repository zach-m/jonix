/*
 * Copyright (C) 2012-2025 Zach Melamed
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

package com.tectonica.jonix.common.codelist;

import com.tectonica.jonix.common.OnixCodelist;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 48 (Measure type)
 */
interface CodeList48 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 48</b>
 * <p>
 * Description: Measure type
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href="https://ns.editeur.org/onix/en/">ONIX online Codelist browser</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_68.html#codelist48">ONIX
 *      Codelist 48 in Reference Guide</a>
 */
public enum MeasureTypes implements OnixCodelist, CodeList48 {
    /**
     * For a book, the overall height when standing on a shelf. For a folded map, the height when folded. For packaged
     * products, the height of the retail packaging, and for trade-only products, the height of the trade packaging. In
     * general, the height of a product in the form in which it is presented or packaged for retail sale
     */
    Height("01", "Height"),

    /**
     * For a book, the overall horizontal dimension of the cover when standing upright. For a folded map, the width when
     * folded. For packaged products, the width of the retail packaging, and for trade-only products, the width of the
     * trade packaging. In general, the width of a product in the form in which it is presented or packaged for retail
     * sale
     */
    Width("02", "Width"),

    /**
     * For a book, the overall thickness of the spine. For a folded map, the thickness when folded. For packaged
     * products, the depth of the retail packaging, and for trade-only products, the depth of the trade packaging. In
     * general, the thickness or depth of a product in the form in which it is presented or packaged for retail sale
     */
    Thickness("03", "Thickness"),

    /**
     * Overall height (code 01) is preferred for general use, as it includes the board overhang for hardbacks
     */
    Page_trim_height("04", "Page trim height"),

    /**
     * Overall width (code 02) is preferred for general use, as it includes the board overhang and spine thickness for
     * hardbacks
     */
    Page_trim_width("05", "Page trim width"),

    /**
     * The volume of the product, including any retail packaging. Note the &lt;MeasureUnit&gt; is interpreted as a
     * volumetric unit - for example code cm = cubic centimetres (ie millilitres), and code oz = (US) fluid ounces. Only
     * for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Unit_volume("06", "Unit volume"),

    /**
     * Volume of the internal (fluid) contents of a product (eg of paint in a can). Note the &lt;MeasureUnit&gt; is
     * interpreted as a volumetric unit - for example code cm = cubic centimetres (ie millilitres), and code oz = (US)
     * fluid ounces. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Unit_capacity("07", "Unit capacity"),

    /**
     * The overall weight of the product, including any retail packaging
     */
    Unit_weight("08", "Unit weight"),

    /**
     * Of a globe, for example
     */
    Diameter_sphere("09", "Diameter (sphere)"),

    /**
     * The height of a folded or rolled sheet map, poster etc when unfolded
     */
    Unfolded_unrolled_sheet_height("10", "Unfolded/unrolled sheet height"),

    /**
     * The width of a folded or rolled sheet map, poster etc when unfolded
     */
    Unfolded_unrolled_sheet_width("11", "Unfolded/unrolled sheet width"),

    /**
     * The diameter of the cross-section of a tube or cylinder, usually carrying a rolled sheet product. Use 01 'Height'
     * for the height or length of the tube
     */
    Diameter_tube_or_cylinder("12", "Diameter (tube or cylinder)"),

    /**
     * The length of a side of the cross-section of a long triangular or square package, usually carrying a rolled sheet
     * product. Use 01 'Height' for the height or length of the package
     */
    Rolled_sheet_package_side_measure("13", "Rolled sheet package side measure"),

    /**
     * As height, but of the product without packaging (use only for products supplied in retail packaging, must also
     * supply overall size when packaged using code 01). Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Unpackaged_height("14", "Unpackaged height"),

    /**
     * As width, but of the product without packaging (use only for products supplied in retail packaging, must also
     * supply overall size when packaged using code 02). Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Unpackaged_width("15", "Unpackaged width"),

    /**
     * As thickness, but of the product without packaging (use only for products supplied in retail packaging, must also
     * supply overall size when packaged using code 03). Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Unpackaged_thickness("16", "Unpackaged thickness"),

    /**
     * Weight of batteries built-in, pre-installed or supplied with the product. Details of the batteries should be
     * provided using &lt;ProductFormFeature&gt;. A per-battery unit weight may be calculated from the number of
     * batteries if required. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Total_battery_weight("17", "Total battery weight"),

    /**
     * Mass or equivalent mass of elemental Lithium within the batteries built-in, pre-installed or supplied with the
     * product (eg a Lithium Iron phosphate battery with 160g of cathode material would have a total of around 7g of
     * Lithium). Details of the batteries must be provided using ProductFormFeature. A per-battery unit mass of Lithium
     * may be calculated from the number of batteries if required. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Total_weight_of_Lithium("18", "Total weight of Lithium"),

    /**
     * For use where product or part of product requires assembly, for example the size of a completed kit, puzzle or
     * assembled display piece. The assembled dimensions may be larger than the product size as supplied. Use only when
     * the unassembled dimensions as supplied (including any retail or trade packaging) are also provided using codes
     * 01, 02 and 03. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Assembled_length("19", "Assembled length"),

    /**
     * JONIX adds: Not included in Onix2
     */
    Assembled_width("20", "Assembled width"),

    /**
     * JONIX adds: Not included in Onix2
     */
    Assembled_height("21", "Assembled height"),

    /**
     * Overall unit weight (code 08) is preferred for general use, as it includes the weight of any packaging. Use
     * Unpackaged unit weight only for products supplied in retail packaging, and must also supply overall unit weight.
     * Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Unpackaged_unit_weight("22", "Unpackaged unit weight"),

    /**
     * Includes packaging. See &lt;PackQuantity&gt; for number of copies of the product per pack, and used only when
     * dimensions of individual copies (codes 01, 02, 03) AND &lt;PackQuantity&gt; are supplied. Note that neither
     * orders nor deliveries have to be aligned with multiples of the pack quantity, but such orders and deliveries may
     * be more convenient to handle. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Carton_length("23", "Carton length"),

    /**
     * JONIX adds: Not included in Onix2
     */
    Carton_width("24", "Carton width"),

    /**
     * JONIX adds: Not included in Onix2
     */
    Carton_height("25", "Carton height"),

    /**
     * Includes the weight of product(s) within the carton. See &lt;PackQuantity&gt; for number of copies per pack, and
     * used only when the weight of individual copies (code 08) AND &lt;PackQuantity&gt; are supplied. Only for use in
     * ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Carton_weight("26", "Carton weight"),

    /**
     * Includes pallet and packaging. See &lt;PalletQuantity&gt; for number of copies of the product per pallet, and
     * used only when dimensions of individual copies (codes 01, 02, 03) AND &lt;PalletQuantity&gt; are supplied. Note
     * that neither orders nor deliveries have to be aligned with multiples of the pallet quantity, but such orders and
     * deliveries may be more convenient to handle. Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Pallet_length("27", "Pallet length"),

    /**
     * JONIX adds: Not included in Onix2
     */
    Pallet_width("28", "Pallet width"),

    /**
     * JONIX adds: Not included in Onix2
     */
    Pallet_height("29", "Pallet height"),

    /**
     * Includes the weight of product(s) and cartons stacked on the pallet. See &lt;PalletQuantity&gt; for the number of
     * copies per pallet, and used only when the weight of individual copies (code 08) AND &lt;PalletQuantity&gt; are
     * supplied.Only for use in ONIX 3.0 or later
     * <p>
     * JONIX adds: Not included in Onix2
     */
    Pallet_weight("30", "Pallet weight");

    public final String code;
    public final String description;

    MeasureTypes(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }

    private static volatile Map<String, MeasureTypes> map;

    private static Map<String, MeasureTypes> map() {
        Map<String, MeasureTypes> result = map;
        if (result == null) {
            synchronized (MeasureTypes.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (MeasureTypes e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static MeasureTypes byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }

    public static Optional<MeasureTypes> byCodeOptional(String code) {
        return Optional.ofNullable(byCode(code));
    }

    public static String codeToDesciption(String code) {
        return byCodeOptional(code).map(c -> c.description).orElse(null);
    }
}
