/*
 * Copyright (C) 2012-2022 Zach Melamed
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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 175 (Product form detail)
 */
interface CodeList175 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 175</b>
 * <p>
 * Description: Product form detail
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_58.html#codelist175">ONIX
 *      Codelist 175 in Reference Guide</a>
 */
public enum ProductFormDetails implements OnixCodelist, CodeList175 {
    /**
     * CD 'red book' format
     */
    CD_standard_audio_format("A101", "CD standard audio format"),

    SACD_super_audio_format("A102", "SACD super audio format"),

    /**
     * MPEG-1/2 Audio Layer III file
     */
    MP3_format("A103", "MP3 format"),

    WAV_format("A104", "WAV format"),

    Real_Audio_format("A105", "Real Audio format"),

    /**
     * Windows Media Audio format
     */
    WMA("A106", "WMA"),

    /**
     * Advanced Audio Coding format
     */
    AAC("A107", "AAC"),

    /**
     * Vorbis audio format in the Ogg container
     */
    Ogg_Vorbis("A108", "Ogg/Vorbis"),

    /**
     * Audio format proprietary to Audible.com
     */
    Audible("A109", "Audible"),

    /**
     * Free lossless audio codec
     */
    FLAC("A110", "FLAC"),

    /**
     * Audio Interchangeable File Format
     */
    AIFF("A111", "AIFF"),

    /**
     * Apple Lossless Audio Codec
     */
    ALAC("A112", "ALAC"),

    /**
     * Audiobook package format
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    W3C_Audiobook_format("A113", "W3C Audiobook format"),

    /**
     * Deprecated, as does not meet DAISY 2 standard. Use conventional audiobook codes instead
     */
    DAISY_2_full_audio_with_title_only_no_navigation("A201", "DAISY 2: full audio with title only (no navigation)"),

    DAISY_2_full_audio_with_navigation_no_text("A202", "DAISY 2: full audio with navigation (no text)"),

    DAISY_2_full_audio_with_navigation_and_partial_text("A203", "DAISY 2: full audio with navigation and partial text"),

    DAISY_2_full_audio_with_navigation_and_full_text("A204", "DAISY 2: full audio with navigation and full text"),

    /**
     * Reading systems may provide full audio via text-to-speech
     */
    DAISY_2_full_text_with_navigation_and_partial_audio("A205", "DAISY 2: full text with navigation and partial audio"),

    /**
     * Reading systems may provide full audio via text-to-speech
     */
    DAISY_2_full_text_with_navigation_and_no_audio("A206", "DAISY 2: full text with navigation and no audio"),

    /**
     * Deprecated, as does not meet DAISY 3 standard. Use conventional audiobook codes instead
     */
    DAISY_3_full_audio_with_title_only_no_navigation("A207", "DAISY 3: full audio with title only (no navigation)"),

    DAISY_3_full_audio_with_navigation_no_text("A208", "DAISY 3: full audio with navigation (no text)"),

    DAISY_3_full_audio_with_navigation_and_partial_text("A209", "DAISY 3: full audio with navigation and partial text"),

    DAISY_3_full_audio_with_navigation_and_full_text("A210", "DAISY 3: full audio with navigation and full text"),

    /**
     * Reading systems may provide full audio via text-to-speech
     */
    DAISY_3_full_text_with_navigation_and_partial_audio("A211", "DAISY 3: full text with navigation and partial audio"),

    /**
     * Reading systems may provide full audio via text-to-speech
     */
    DAISY_3_full_text_with_navigation_and_no_audio("A212", "DAISY 3: full text with navigation and no audio"),

    Standalone_audio("A301", "Standalone audio"),

    /**
     * Audio intended exclusively for use alongside a printed copy of the book. Most often a children's product.
     * Normally contains instructions such as 'turn the page now' and other references to the printed item, and is
     * usually sold packaged together with a printed copy
     */
    Readalong_audio("A302", "Readalong audio"),

    /**
     * Audio intended for musical accompaniment, eg 'Music minus one', etc, often used for music learning. Includes
     * singalong backing audio for musical learning or for Karaoke-style entertainment
     */
    Playalong_audio("A303", "Playalong audio"),

    /**
     * Audio intended for language learning, which includes speech plus gaps intended to be filled by the listener
     */
    Speakalong_audio("A304", "Speakalong audio"),

    /**
     * Audio synchronised to text within an e-publication, for example an EPUB3 with audio overlay. Synchronisation at
     * least at paragraph level, and covering the full content
     */
    Synchronised_audio("A305", "Synchronised audio"),

    /**
     * Incidental sounds added to the audiobook narration (eg background environmental sounds)
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Sound_effects("A310", "Sound effects"),

    /**
     * Incidental music added to the audiobook narration (eg to heighten atmosphere). Do not use where the music is a
     * primary part of the audio
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Background_music("A311", "Background music"),

    /**
     * Constant or average bit rate (eg of an mp3 or AAC audio file) 64kbits/second or more. Note the bit rate is the
     * total across all channels, not a per channel rate
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    _64kbits_s("A400", "64kbits/s"),

    /**
     * Constant or average bit rate 128bbits/second or more
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    _128kbits_s("A401", "128kbits/s"),

    /**
     * Jonix-Comment: Introduced in Onix3
     */
    _192kbits_s("A402", "192kbits/s"),

    /**
     * Jonix-Comment: Introduced in Onix3
     */
    _256kbits_s("A403", "256kbits/s"),

    /**
     * Jonix-Comment: Introduced in Onix3
     */
    _320kbits_s("A404", "320kbits/s"),

    /**
     * Includes 'stereo' where channels are identical
     */
    Mono("A410", "Mono"),

    /**
     * Includes 'joint stereo'
     */
    Stereo("A420", "Stereo"),

    /**
     * Stereo plus low-frequency channel
     */
    Stereo_2_1("A421", "Stereo 2.1"),

    /**
     * Five-channel audio (including low-frequency channel)
     */
    Surround_4_1("A441", "Surround 4.1"),

    /**
     * Six-channel audio (including low-frequency channel)
     */
    Surround_5_1("A451", "Surround 5.1"),

    /**
     * In North America, a category of paperback characterized partly by page size (typically from 6&#190; up to
     * 7&#8539; x 4&#188; inches) and partly by target market and terms of trade. Use with Product Form code BC
     */
    Mass_market_rack("B101", "Mass market (rack) paperback"),

    /**
     * In North America, a category of paperback characterized partly by page size (larger than rack-sized) and partly
     * by target market and terms of trade. AKA 'quality paperback', and including textbooks. Most paperback books sold
     * in North America except 'mass-market' (B101) and 'tall rack' (B107) are correctly described with this code. Use
     * with Product Form code BC
     */
    Trade_paperback_US("B102", "Trade paperback (US)"),

    /**
     * In North America, a category of paperback characterized by page size (typically 7 x 5 inches) and generally used
     * for children's books; use with Product Form code BC. Note: was wrongly shown as B102 (duplicate entry) in Issue 3
     */
    Digest_format_paperback("B103", "Digest format paperback"),

    /**
     * In UK and IE, a category of paperback characterized by page size (normally 178 x 111 mm approx); use with Product
     * Form code BC
     */
    A_format_paperback("B104", "A-format paperback"),

    /**
     * In UK and IE, a category of paperback characterized by page size (normally 198 x 129 mm approx); use with Product
     * Form code BC
     */
    B_format_paperback("B105", "B-format paperback"),

    /**
     * In UK and IE, a category of paperback characterized largely by size (usually in traditional hardback dimensions),
     * and often used for paperback originals or retailer/travel/export-exclusives; use with Product Form code BC
     */
    Trade_paperback_UK("B106", "Trade paperback (UK)"),

    /**
     * In North America, a category of paperback characterised partly by page size (typically 7&#189; x 4&#188; inches)
     * and partly by target market and terms of trade; use with Product Form code BC
     */
    Tall_rack_paperback_US("B107", "Tall rack paperback (US)"),

    /**
     * Japanese A-series size, 210 x 148mm. A tankobon is a complete collected story originally published in serialised
     * form (eg in a magazine)
     */
    A5_size_Tankobon("B108", "A5 size Tankobon"),

    /**
     * Japanese B-series size, 257 x 182mm
     */
    JIS_B5_size_Tankobon("B109", "JIS B5 size Tankobon"),

    /**
     * Japanese B-series size, 182 x 128mm
     */
    JIS_B6_size_Tankobon("B110", "JIS B6 size Tankobon"),

    /**
     * Japanese A-series size, 148 x 105mm
     */
    A6_size_Bunko("B111", "A6 size Bunko"),

    /**
     * Japanese format, 182x103mm or 173x105mm
     */
    B40_dori_Shinsho("B112", "B40-dori Shinsho"),

    /**
     * A Swedish, Norwegian, French paperback format, of no particular fixed size. Use with Product Form Code BC
     */
    Pocket_Sweden_Norway_France("B113", "Pocket (Sweden, Norway, France)"),

    /**
     * A Swedish paperback format, use with Product Form Code BC. In Finnish, J&#228;ttipokkari
     */
    Storpocket_Sweden("B114", "Storpocket (Sweden)"),

    /**
     * A Swedish hardback format, use with Product Form Code BB
     */
    Kartonnage_Sweden("B115", "Kartonnage (Sweden)"),

    /**
     * A Swedish softback format, use with Product Form Code BC
     */
    Flexband_Sweden("B116", "Flexband (Sweden)"),

    /**
     * A softback book in the format of a magazine, usually sold like a book. Use with Product Form code BC
     */
    Mook_Bookazine("B117", "Mook / Bookazine"),

    /**
     * Also called 'Flipback'. A softback book in a specially compact proprietary format with pages printed in landscape
     * on very thin paper and bound along the long (top) edge (ie parallel with the lines of text). Use with Product
     * Form code BC - see www.dwarsligger.com
     */
    Dwarsligger("B118", "Dwarsligger"),

    /**
     * Japanese format, 188 x 127mm
     */
    _46_size("B119", "46 size"),

    /**
     * Japanese format, 188 x 127mm
     */
    _46_Henkei_size("B120", "46-Henkei size"),

    /**
     * 297 x 210mm
     */
    A4("B121", "A4"),

    /**
     * Japanese format, 297 x 210mm
     */
    A4_Henkei_size("B122", "A4-Henkei size"),

    /**
     * Japanese format, 210 x 146mm
     */
    A5_Henkei_size("B123", "A5-Henkei size"),

    /**
     * Japanese format, 257 x 182mm
     */
    B5_Henkei_size("B124", "B5-Henkei size"),

    /**
     * Japanese format, 182 x 128mm
     */
    B6_Henkei_size("B125", "B6-Henkei size"),

    /**
     * 257 x 210mm
     */
    AB_size("B126", "AB size"),

    /**
     * Japanese B-series size, 128 x 91mm
     */
    JIS_B7_size("B127", "JIS B7 size"),

    /**
     * Japanese format, 218 x 152mm or 227 x 152mm
     */
    Kiku_size("B128", "Kiku size"),

    /**
     * Japanese format
     */
    Kiku_Henkei_size("B129", "Kiku-Henkei size"),

    /**
     * Japanese B-series size, 364 x 257 mm
     */
    JIS_B4_size("B130", "JIS B4 size"),

    /**
     * German large paperback format, greater than about 205mm high, with flaps. Use with Product form code BC
     */
    Paperback_DE("B131", "Paperback (DE)"),

    /**
     * Spanish pocket paperback. Use with Product form code BC
     */
    Libro_de_bolsillo("B132", "Libro de bolsillo"),

    /**
     * German ,Taschenbuch', Italian &#171;Tascabile / Supertascabile&#187; pocket-sized format, usually less than about
     * 205mm high. Use with Product form code BB or BC
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Pocket_sized("B133", "Pocket-sized"),

    /**
     * 210 x 148mm
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    A5("B134", "A5"),

    /**
     * In North America, a category of paperback characterized partly by page size (typically 7&#8539; x 4&#190; inches)
     * and partly by target market and terms of trade. Use with Product Form code BC
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Mass_market_max_paperback("B135", "Mass market max paperback"),

    Coloring_join_the_dot_book("B201", "Coloring / join-the-dot book"),

    Lift_the_flap_book("B202", "Lift-the-flap book"),

    /**
     * Note: was wrongly shown as B203 (duplicate entry) in Issue 3
     */
    Miniature_book("B204", "Miniature book"),

    Moving_picture_flicker_book("B205", "Moving picture / flicker book"),

    Pop_up_book("B206", "Pop-up book"),

    Scented_smelly_book("B207", "Scented / ‘smelly’ book"),

    Sound_story_noisy_book("B208", "Sound story / ‘noisy’ book"),

    Sticker_book("B209", "Sticker book"),

    /**
     * A book whose pages have a variety of textured inserts designed to stimulate tactile exploration: see also B214
     * and B215
     */
    Touch_and_feel_book("B210", "Touch-and-feel book"),

    /**
     * A book which is cut into a distinctive non-rectilinear shape and/or in which holes or shapes have been cut
     * internally. ('Die-cut' is used here as a convenient shorthand, and does not imply strict limitation to a
     * particular production process)
     */
    Die_cut_book("B212", "Die-cut book"),

    /**
     * A book which is also a toy, or which incorporates a toy as an integral part. (Do not, however, use B213 for a
     * multiple-item product which includes a book and a toy as separate items)
     */
    Book_as_toy("B213", "Book-as-toy"),

    /**
     * A book whose cover has a soft textured finish, typically over board
     */
    Soft_to_touch_book("B214", "Soft-to-touch book"),

    /**
     * A book with detachable felt pieces and textured pages on which they can be arranged
     */
    Fuzzy_felt_book("B215", "Fuzzy-felt book"),

    /**
     * A book containing pages with die-cut or press-out pieces that can be used as a jigsaw, puzzle pieces, etc
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Press_out_puzzle_pieces("B216", "Press-out puzzle pieces"),

    /**
     * Children's picture book: use with applicable Product Form code
     */
    Picture_book("B221", "Picture book"),

    /**
     * (aka 'Star' book). Tax treatment of products may differ from that of products with similar codes such as Book as
     * toy or Pop-up book)
     */
    Carousel_book("B222", "‘Carousel’ book"),

    /**
     * A book with movable card 'tabs' within the pages. Pull a tab to reveal or animate part of a picture (distinct
     * from a 'lift-the-flap' book, where flaps simply reveal hidden pictures, and not a 'pop-up' book with 3D paper
     * engineering)
     */
    Pull_the_tab_book("B223", "Pull-the-tab book"),

    /**
     * Use with Product Form code BD, BN or PM
     */
    Loose_leaf_or_partwork_sheets_parts_and_binder_wallet("B301",
        "Loose leaf or partwork – sheets / parts and binder / wallet"),

    /**
     * Use with Product Form code BD, BN or PM
     */
    Loose_leaf_or_partwork_binder_wallet_only("B302", "Loose leaf or partwork – binder / wallet only"),

    /**
     * Use with Product Form code BD, BN or PM
     */
    Loose_leaf_or_partwork_sheets_parts_only("B303", "Loose leaf or partwork – sheets / parts only"),

    /**
     * AKA stitched; for 'saddle-sewn', see code B310
     */
    Sewn("B304", "Sewn"),

    /**
     * Including 'perfect bound', 'glued'
     */
    Unsewn_adhesive_bound("B305", "Unsewn / adhesive bound"),

    /**
     * Strengthened cloth-over-boards binding intended for libraries: use with Product form code BB
     */
    Library_binding("B306", "Library binding"),

    /**
     * Strengthened binding, not specifically intended for libraries: use with Product form code BB or BC
     */
    Reinforced_binding("B307", "Reinforced binding"),

    /**
     * Highest qualiy material used on spine and corners only. Must be accompanied by a code specifiying a material, eg
     * 'half-bound real leather'
     */
    Half_bound("B308", "Half bound"),

    /**
     * Highest qualiy material used on spine only. Must be accompanied by a code specifiying a material, eg 'quarter
     * bound real leather'
     */
    Quarter_bound("B309", "Quarter bound"),

    /**
     * AKA 'saddle-stitched' or 'wire-stitched'
     */
    Saddle_sewn("B310", "Saddle-sewn"),

    /**
     * Round or oval plastic forms in a clamp-like configuration: use with Product Form code BE
     */
    Comb_bound("B311", "Comb bound"),

    /**
     * Twin loop metal wire spine: use with Product Form code BE
     */
    Wire_O("B312", "Wire-O"),

    /**
     * Cased over Coiled or Wire-O binding: use with Product Form code BE and Product Form Detail code B312 or B314
     */
    Concealed_wire("B313", "Concealed wire"),

    /**
     * Spiral wire bound. Use with product form code BE. The default if a spiral binding type is not stated. Cf. Comb
     * and Wire-O binding
     */
    Coiled_wire_bound("B314", "Coiled wire bound"),

    /**
     * Hardcover binding intended for general consumers rather than libraries, use with Product form code BB. The
     * default if a hardcover binding detail is not stated. cf. Library binding
     */
    Trade_binding("B315", "Trade binding"),

    /**
     * Cover is attached to the book block along only one edge of the spine, allowing the cover to lay flat
     */
    Swiss_binding("B316", "Swiss binding"),

    /**
     * Refinement of perfect binding, with notches cut in the spine of the book block prior to glueing, to improve
     * adhesion and durability
     */
    Notched_binding("B317", "Notched binding"),

    /**
     * Hardcover or softcover where interior spreads lay flat across the spine
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Lay_flat_binding("B318", "Lay-flat binding"),

    /**
     * Covers do not use a distinctive stock, but are the same as the body pages
     */
    Self_covered("B400", "Self-covered"),

    /**
     * Cotton, linen or other woven fabric over boards. Use with &lt;ProductForm&gt; BB
     */
    Cloth_over_boards("B401", "Cloth over boards"),

    /**
     * Cellulose-based or similar non-woven material, which may be printed and may be embossed with an artificial cloth
     * or leather-like texture, over boards. Use with &lt;ProductForm&gt; BB
     */
    Paper_over_boards("B402", "Paper over boards"),

    /**
     * Covered with leather created by tanning animal hide. May be 'full-grain' using the entire thickness of the hide,
     * 'top grain' using the outer layer of the hide, or 'split' using the inner layers of the hide. Split leather may
     * be embossed with an artificial grain or texture. Use with &lt;ProductForm&gt; BG, and if appropriate with codes
     * B308 or B309 (otherwise 'full-bound' is implied)
     */
    Leather_real("B403", "Leather, real"),

    /**
     * Covered with synthetic leather-like material - polymer or non-animal fibre over a textile backing, usually coated
     * and embossed with an artificial grain or texture. Leatherette, pleather etc. Use with &lt;ProductForm&gt; BB (or
     * BG if particularly high-quality), and if appropriate with codes B308 or B309 (otherwise 'full-bound' is implied)
     */
    Leather_imitation("B404", "Leather, imitation"),

    /**
     * Covered with leather reconstituted from a pulp made from shredded animal hide, layered on a fibre or textile
     * backing, coated and usually embossed with an artificial grain or texture. Use with &lt;ProductForm&gt; BG, and if
     * appropriate with codes B308 or B309 (otherwise 'full-bound' is implied)
     */
    Leather_bonded("B405", "Leather, bonded"),

    /**
     * Pages made with prepared but untanned animal skin (usually calf, occasionally goat or sheep). Includes parchment,
     * a thicker and less refined form of animal skin, but not 'paper vellum' or vegetable parchment made from synthetic
     * or plant fibres
     */
    Vellum("B406", "Vellum"),

    /**
     * Cloth, not necessarily over boards - cf B401
     */
    Cloth("B409", "Cloth"),

    /**
     * Spanish 'simil-tela'
     */
    Imitation_cloth("B410", "Imitation cloth"),

    Velvet("B411", "Velvet"),

    /**
     * AKA 'flexibound': use with Product Form code BC
     */
    Flexible_plastic_vinyl_cover("B412", "Flexible plastic/vinyl cover"),

    /**
     * Separate outer plastic cover, often transparent and allowing the cover to show through. Typically has pockets
     * into which the cover tucks. See also B412, where the cover itself is plastic or vinyl
     */
    Plastic_covered("B413", "Plastic-covered"),

    /**
     * Separate outer vinyl cover. See also B412, where the cover itself is plastic or vinyl
     */
    Vinyl_covered("B414", "Vinyl-covered"),

    /**
     * Book, laminating material unspecified, often termed PLC or PPC (printed laminated case, printed paper case) when
     * used with Product form BB. Use L101 for 'whole product laminated', eg a laminated sheet map or wallchart
     */
    Laminated_cover("B415", "Laminated cover"),

    /**
     * With card cover (like a typical paperback). As distinct from a self-cover or more elaborate binding
     */
    Card_cover("B416", "Card cover"),

    /**
     * Printed both inside and outside the front and/or back cover
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Duplex_printed_cover("B417", "Duplex-printed cover"),

    /**
     * Cover or jacket finish may merit special handling or packaging during distribution and fulfilment, for example
     * because of gloss varnish which may hold fingerprints or matt laminate liable to scuffing
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Delicate_cover_jacket_finish("B420", "Delicate cover / jacket finish"),

    /**
     * Type unspecified
     */
    With_dust_jacket("B501", "With dust jacket"),

    /**
     * Used to distinguish from B503
     */
    With_printed_dust_jacket("B502", "With printed dust jacket"),

    /**
     * With translucent paper or plastic protective cover
     */
    With_translucent_dust_cover("B503", "With translucent dust cover"),

    /**
     * For paperback with flaps
     */
    With_flaps("B504", "With flaps"),

    With_thumb_index("B505", "With thumb index"),

    /**
     * If the number of markers is significant, it can be stated as free text in &lt;ProductFormDescription&gt;
     */
    With_ribbon_marker_s("B506", "With ribbon marker(s)"),

    With_zip_fastener("B507", "With zip fastener"),

    With_button_snap_fastener("B508", "With button snap fastener"),

    /**
     * AKA yapp edge?
     */
    With_leather_edge_lining("B509", "With leather edge lining"),

    /**
     * With edge trimming such that the front edge is ragged, not neatly and squarely trimmed: AKA deckle edge, feather
     * edge, uncut edge, rough cut
     */
    Rough_front("B510", "Rough front"),

    /**
     * With one or more gatefold or foldout sections bound in
     */
    Foldout("B511", "Foldout"),

    /**
     * Pages include extra-wide margin specifically intended for hand-written annotations
     */
    Wide_margin("B512", "Wide margin"),

    /**
     * Book with attached loop for fixing to baby stroller, cot, chair etc
     */
    With_fastening_strap("B513", "With fastening strap"),

    /**
     * With one or more pages perforated and intended to be torn out for use
     */
    With_perforated_pages("B514", "With perforated pages"),

    /**
     * Printed on acid-free or alkaline buffered paper conforming with ISO 9706
     */
    Acid_free_paper("B515", "Acid-free paper"),

    /**
     * Printed on acid-free or alkaline buffered paper with a high cotton content, conforming with ISO 11108
     */
    Archival_paper("B516", "Archival paper"),

    /**
     * Strap acts as closure or as page marker
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    With_elasticated_strap("B517", "With elasticated strap"),

    /**
     * For example, holographic sticker such as the banderol used in the Turkish book trade
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    With_serialized_authenticity_token("B518", "With serialized authenticity token"),

    /**
     * Jacket in the form of a pamphlet or poster, specifically intended to be removed and read or used separately from
     * the book
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    With_dust_jacket_poster("B519", "With dust jacket poster"),

    /**
     * Usually die-cut rounding to foredge corners of cover (and/or to foredge page corners). See B212 for elaborate
     * die-cutting
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Rounded_corners("B520", "Rounded corners"),

    /**
     * A book in which half the content is printed upside-down, to be read the other way round. Also known as a
     * 'flip-book' or 't&#234;te-b&#234;che' (Fr) binding, it has two front covers and a single spine. Usually an
     * omnibus of two works
     */
    Turn_around_book("B601", "Turn-around book"),

    /**
     * Manga with pages and panels in the sequence of the original Japanese, but with Western text
     */
    Unflipped_manga_format("B602", "Unflipped manga format"),

    /**
     * A book in which half the content is printed so as to be read from the other cover. All content is printed the
     * same way up. Also known as 'dos-&#224;-dos' (Fr) binding, it has two front covers and two spines. Usually an
     * omnibus of two works
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Back_to_back_book("B603", "Back-to-back book"),

    /**
     * Text shows syllable breaks
     */
    Syllabification("B610", "Syllabification"),

    /**
     * Single letters only. Was formerly identified as UK Braille Grade 1
     */
    UK_Uncontracted_Braille("B701", "UK Uncontracted Braille"),

    /**
     * With some letter combinations. Was formerly identified as UK Braille Grade 2
     */
    UK_Contracted_Braille("B702", "UK Contracted Braille"),

    /**
     * For US Braille, prefer codes B704 and B705 as appropriate
     */
    US_Braille("B703", "US Braille"),

    US_Uncontracted_Braille("B704", "US Uncontracted Braille"),

    US_Contracted_Braille("B705", "US Contracted Braille"),

    /**
     * For UEB, prefer codes B708 and B709 as appropriate
     */
    Unified_English_Braille("B706", "Unified English Braille"),

    /**
     * Moon embossed alphabet, used by some print-impaired readers who have difficulties with Braille
     */
    Moon("B707", "Moon"),

    Unified_English_Uncontracted_Braille("B708", "Unified English Uncontracted Braille"),

    Unified_English_Contracted_Braille("B709", "Unified English Contracted Braille"),

    /**
     * Proprietary RealNetworks format. Includes Real Video packaged within a .rm RealMedia container
     */
    Real_Video_format("D101", "Real Video format"),

    Quicktime_format("D102", "Quicktime format"),

    AVI_format("D103", "AVI format"),

    Windows_Media_Video_format("D104", "Windows Media Video format"),

    MPEG_4("D105", "MPEG-4"),

    /**
     * Use with an applicable Product Form code D*; note that more detail of operating system requirements can be given
     * in a Product Form Feature composite
     */
    MS_DOS("D201", "MS-DOS"),

    /**
     * Use with an applicable Product Form code D*; see note on D201
     */
    Windows("D202", "Windows"),

    /**
     * Use with an applicable Product Form code D*; see note on D201
     */
    Macintosh("D203", "Macintosh"),

    /**
     * Use with an applicable Product Form code D*; see note on D201
     */
    UNIX_LINUX("D204", "UNIX / LINUX"),

    /**
     * Use with an applicable Product Form code D*; see note on D201
     */
    Other_operating_system_s("D205", "Other operating system(s)"),

    /**
     * Use with an applicable Product Form code D*; see note on D201
     */
    Palm_OS("D206", "Palm OS"),

    /**
     * Use with an applicable Product Form code D*; see note on D201
     */
    Windows_Mobile("D207", "Windows Mobile"),

    /**
     * Use with Product Form code DB or DI as applicable
     */
    Microsoft_XBox("D301", "Microsoft XBox"),

    /**
     * Use with Product Form code DE or DB as applicable
     */
    Nintendo_Gameboy_Color("D302", "Nintendo Gameboy Color"),

    /**
     * Use with Product Form code DE or DB as applicable
     */
    Nintendo_Gameboy_Advanced("D303", "Nintendo Gameboy Advanced"),

    /**
     * Use with Product Form code DE or DB as applicable
     */
    Nintendo_Gameboy("D304", "Nintendo Gameboy"),

    /**
     * Use with Product Form code DE or DB as applicable
     */
    Nintendo_Gamecube("D305", "Nintendo Gamecube"),

    /**
     * Use with Product Form code DE or DB as applicable
     */
    Nintendo_64("D306", "Nintendo 64"),

    /**
     * Use with Product Form code DE or DB as applicable
     */
    Sega_Dreamcast("D307", "Sega Dreamcast"),

    /**
     * Use with Product Form code DE or DB as applicable
     */
    Sega_Genesis_Megadrive("D308", "Sega Genesis/Megadrive"),

    /**
     * Use with Product Form code DE or DB as applicable
     */
    Sega_Saturn("D309", "Sega Saturn"),

    /**
     * Use with Product Form code DB as applicable
     */
    Sony_PlayStation_1("D310", "Sony PlayStation 1"),

    /**
     * Use with Product Form code DB or DI as applicable
     */
    Sony_PlayStation_2("D311", "Sony PlayStation 2"),

    /**
     * Use with Product Form code DE as applicable
     */
    Nintendo_Dual_Screen("D312", "Nintendo Dual Screen"),

    /**
     * Use with Product Form code DB, DI, DO or E* as applicable
     */
    Sony_PlayStation_3("D313", "Sony PlayStation 3"),

    /**
     * Use with Product Form code DB, DI or VN as applicable
     */
    Microsoft_Xbox_360("D314", "Microsoft Xbox 360"),

    /**
     * Use with Product Form code DA or E* as applicable
     */
    Nintendo_Wii("D315", "Nintendo Wii"),

    /**
     * Use with Product Form code DL or VL as applicable
     */
    Sony_PlayStation_Portable_PSP("D316", "Sony PlayStation Portable (PSP)"),

    /**
     * Use with Product Form code DB, DI, DO or E* as applicable. DEPRECATED
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Sony_PlayStation_3_("D317", "Sony PlayStation 3"),

    /**
     * Use with Product Form code DB, DI, DO or E* as applicable
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Sony_PlayStation_4("D318", "Sony PlayStation 4"),

    /**
     * Use with Product Form code DA or E* as applicable
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Sony_PlayStation_Vita("D319", "Sony PlayStation Vita"),

    /**
     * Use with Product Form code DB, DI, DO or E* as applicable
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Microsoft_Xbox_One("D320", "Microsoft Xbox One"),

    /**
     * Use with Product Form code DE or DB as applicable
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Nintendo_Switch("D321", "Nintendo Switch"),

    /**
     * Use with Product Form code DE or DB as applicable
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Nintendo_Wii_U("D322", "Nintendo Wii U"),

    /**
     * Use with Product Form code DB, DI, DO or E* as applicable
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Sony_PlayStation_5("D323", "Sony PlayStation 5"),

    /**
     * Use with Product Form code DB, DI, DO or E* as applicable
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Microsoft_Xbox_Series_X_S("D324", "Microsoft Xbox Series X / S"),

    /**
     * No code allocated for this e-publication format yet
     */
    Other("E100", "Other"),

    /**
     * The Open Publication Structure / OPS Container Format standard of the International Digital Publishing Forum
     * (IDPF) [File extension .epub]
     */
    EPUB("E101", "EPUB"),

    /**
     * The Open EBook format of the IDPF, a predecessor of the full EPUB format, still (2008) supported as part of the
     * latter [File extension .opf]. Includes EPUB format up to and including version 2 - but prefer code E101 for EPUB
     * 2, and always use code E101 for EPUB 3
     */
    OEB("E102", "OEB"),

    /**
     * Microsoft Word binary document format [File extension .doc]
     */
    DOC("E103", "DOC"),

    /**
     * Office Open XML / Microsoft Word XML document format (ISO/IEC 29500:2008) [File extension .docx]
     */
    DOCX("E104", "DOCX"),

    /**
     * HyperText Mark-up Language [File extension .html, .htm]
     */
    HTML("E105", "HTML"),

    /**
     * Open Document Format [File extension .odt]
     */
    ODF("E106", "ODF"),

    /**
     * Portable Document Format (ISO 32000-1:2008) [File extension .pdf]
     */
    PDF("E107", "PDF"),

    /**
     * PDF archiving format defined by ISO 19005-1:2005 [File extension .pdf]
     */
    PDF_A("E108", "PDF/A"),

    /**
     * Rich Text Format [File extension .rtf]
     */
    RTF("E109", "RTF"),

    /**
     * Standard Generalized Mark-up Language
     */
    SGML("E110", "SGML"),

    /**
     * A compressed text format mainly used on Psion handheld devices [File extension .tcr]
     */
    TCR("E111", "TCR"),

    /**
     * Text file format [File extension .txt]. Typically ASCII or Unicode UTF-8/16
     */
    TXT("E112", "TXT"),

    /**
     * Extensible Hypertext Markup Language [File extension .xhtml, .xht, .xml, .html, .htm]
     */
    XHTML("E113", "XHTML"),

    /**
     * A compressed text format mainly used on Palm handheld devices [File extension .pdb - see also E121, E125, E130]
     */
    zTXT("E114", "zTXT"),

    /**
     * XML Paper Specification format [File extension .xps]
     */
    XPS("E115", "XPS"),

    /**
     * A format proprietary to Amazon for use with its Kindle reading devices or software readers [File extensions .azw,
     * .mobi, .prc etc]. Prefer code E148 for Print Replica files
     */
    Amazon_Kindle("E116", "Amazon Kindle"),

    /**
     * A Sony proprietary format for use with the Sony Reader and LIBRI&#233; reading devices [File extension .lrf]
     */
    BBeB("E117", "BBeB"),

    /**
     * A proprietary format for use with DXReader software
     */
    DXReader("E118", "DXReader"),

    /**
     * A format proprietary to the Ebook Library service
     */
    EBL("E119", "EBL"),

    /**
     * A format proprietary to the Ebrary service
     */
    Ebrary("E120", "Ebrary"),

    /**
     * A proprietary format for use with eReader (AKA 'Palm Reader') software on various hardware platforms [File
     * extension .pdb - see also E114, E125, E130]
     */
    eReader("E121", "eReader"),

    /**
     * A proprietary format with its own reading system for Windows platforms [File extension .exe]
     */
    Exebook("E122", "Exebook"),

    /**
     * A proprietary format for use with the Franklin eBookman reader
     */
    Franklin_eBookman("E123", "Franklin eBookman"),

    /**
     * A proprietary format for use with the Gemstar Rocketbook reader [File extension .rb]
     */
    Gemstar_Rocketbook("E124", "Gemstar Rocketbook"),

    /**
     * A proprietary format for use with iSilo software on various hardware platforms [File extension .pdb - see also
     * E114, E121, E130]
     */
    iSilo("E125", "iSilo"),

    /**
     * A proprietary format for use with Microsoft Reader software on Windows and Pocket PC platforms [File extension
     * .lit]
     */
    Microsoft_Reader("E126", "Microsoft Reader"),

    /**
     * A proprietary format for use with Mobipocket software on various hardware platforms [File extensions .mobi,
     * .prc]. Includes Amazon Kindle formats up to and including version 7 - but prefer code E116 for version 7, and
     * always use E116 for KF8
     */
    Mobipocket("E127", "Mobipocket"),

    /**
     * A format proprietary to the MyiLibrary service
     */
    MyiLibrary("E128", "MyiLibrary"),

    /**
     * A format proprietary to the NetLibrary service
     */
    NetLibrary("E129", "NetLibrary"),

    /**
     * A proprietary format for use with Plucker reader software on Palm and other handheld devices [File extension .pdb
     * - see also E114, E121, E125]
     */
    Plucker("E130", "Plucker"),

    /**
     * A format proprietary to the VitalSource service
     */
    VitalBook("E131", "VitalBook"),

    /**
     * A proprietary digital product combining text and video content and available to be used online or as a
     * downloadable application for a mobile device - see www.vook.com
     */
    Vook("E132", "Vook"),

    /**
     * An epublication made available by Google in association with a publisher; readable online on a browser-enabled
     * device and offline on designated ebook readers
     */
    Google_Edition("E133", "Google Edition"),

    /**
     * Epublication packaged as application for iOS (eg Apple iPhone, iPad etc), containing both executable code and
     * content. Use &lt;ProductContentType&gt; to describe content, and &lt;ProductFormFeatureType&gt; to list detailed
     * technical requirements
     */
    Book_app_for_iOS("E134", "Book ‘app’ for iOS"),

    /**
     * Epublication packaged as application for Android (eg Android phone or tablet), containing both executable code
     * and content. Use &lt;ProductContentType&gt; to describe content, and &lt;ProductFormFeatureType&gt; to list
     * detailed technical requirements
     */
    Book_app_for_Android("E135", "Book ‘app’ for Android"),

    /**
     * Epublication packaged as application, containing both executable code and content. Use where other 'app' codes
     * are not applicable. Technical requirements such as target operating system and/or device should be provided eg in
     * &lt;ProductFormFeatureType&gt;. Content type (text or text plus various 'enhancements') may be described with
     * &lt;ProductContentType&gt;
     */
    Book_app_for_other_operating_system("E136", "Book ‘app’ for other operating system"),

    /**
     * Founder Apabi's proprietary basic e-book format
     */
    CEB("E139", "CEB"),

    /**
     * Founder Apabi's proprietary XML e-book format
     */
    CEBX("E140", "CEBX"),

    /**
     * Apple's iBook format (a proprietary extension of EPUB), can only be read on Apple iOS devices
     */
    iBook("E141", "iBook"),

    /**
     * Proprietary format based on EPUB used by Barnes and Noble for fixed-format e-books, readable on NOOK devices and
     * Nook reader software
     */
    ePIB("E142", "ePIB"),

    /**
     * Sharable Content Object Reference Model, standard content and packaging format for e-learning objects
     */
    SCORM("E143", "SCORM"),

    /**
     * E-book Plus (proprietary Norwegian e-book format)
     */
    EBP("E144", "EBP"),

    /**
     * Proprietary format based on PDF used by Barnes and Noble for fixed-format e-books, readable on some NOOK devices
     * and Nook reader software
     */
    Page_Perfect("E145", "Page Perfect"),

    /**
     * (Braille-ready file) Electronic Braille file
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    BRF("E146", "BRF"),

    /**
     * Proprietary XML format for articles, see for example https://www.cairn.info/services-aux-editeurs.php
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Erudit("E147", "Erudit"),

    /**
     * A format proprietary to Amazon for use with its Kindle reading devices or software readers. Essentially a PDF
     * embedded within a KF8 format file
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Amazon_Kindle_Print_Replica("E148", "Amazon Kindle Print Replica"),

    /**
     * Format for comic books, consisting primarily of sequentially-named PNG or JPEG images in a zip container
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Comic_Book_Archive("E149", "Comic Book Archive"),

    /**
     * Use this and/or code E201 when a particular e-publication type (specified using codes E100 and upwards) has both
     * fixed format and reflowable variants, to indicate which option is included in this product
     */
    Reflowable("E200", "Reflowable"),

    /**
     * Use this and/or code E200 when a particular e-publication type (specified using codes E100 and upwards) has both
     * fixed format and reflowable variants, to indicate which option is included in this product
     */
    Fixed_format("E201", "Fixed format"),

    /**
     * All e-publication resources are included within the e-publication package
     */
    Readable_offline("E202", "Readable offline"),

    /**
     * E-publication requires a network connection to access some resources (eg an enhanced e-book where video clips are
     * not stored within the e-publication package itself, but are delivered via an internet connection)
     */
    Requires_network_connection("E203", "Requires network connection"),

    /**
     * Resources (eg images) present in other editions have been removed from this product, eg due to rights issues
     */
    Content_removed("E204", "Content removed"),

    /**
     * Use for fixed-format e-books optimised for landscape display. Also include an indication of the optimal screen
     * aspect ratio
     */
    Landscape("E210", "Landscape"),

    /**
     * Use for fixed-format e-books optimised for portrait display. Also include an indication of the optimal screen
     * aspect ratio
     */
    Portrait("E211", "Portrait"),

    /**
     * Use for fixed-format e-books optimised for a square display.
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Square("E212", "Square"),

    /**
     * (1.25:1) Use for fixed-format e-books optimised for displays with a 5:4 aspect ratio (eg 1280x1024 pixels etc,
     * assuming square pixels). Note that aspect ratio codes are NOT specific to actual screen dimensions or pixel
     * counts, but to the ratios between two dimensions or two pixel counts
     */
    _5_4("E221", "5:4"),

    /**
     * (1.33:1) Use for fixed-format e-books optimised for displays with a 4:3 aspect ratio (eg 800x600, 1024x768,
     * 2048x1536 pixels etc)
     */
    _4_3("E222", "4:3"),

    /**
     * (1.5:1) Use for fixed-format e-books optimised for displays with a 3:2 aspect ratio (eg 960x640, 3072x2048 pixels
     * etc)
     */
    _3_2("E223", "3:2"),

    /**
     * (1.6:1) Use for fixed-format e-books optimised for displays with a 16:10 aspect ratio (eg 1440x900, 2560x1600
     * pixels etc)
     */
    _16_10("E224", "16:10"),

    /**
     * (1.77:1) Use for fixed-format e-books optimised for displays with a 16:9 aspect ratio (eg 1024x576, 1920x1080,
     * 2048x1152 pixels etc)
     */
    _16_9("E225", "16:9"),

    /**
     * (2:1) Use for fixed-format e-books optimised for displays with an 18:9 aspect ratio (eg 2160x1080, 2880x1440
     * pixels etc)
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    _18_9("E226", "18:9"),

    /**
     * (2.37:1) Use for fixed-format e-books optimised for displays with an 21:9 (or 64:27) aspect ratio (eg 3840x1644
     * pixels etc)
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    _21_9("E227", "21:9"),

    /**
     * Whole product laminated (eg laminated map, fold-out chart, wallchart, etc): use B415 for book with laminated
     * cover
     */
    Laminated("L101", "Laminated"),

    /**
     * Large format. Use with Product Form code PC or PF
     */
    Desk_calendar_or_diary("P101", "Desk calendar or diary"),

    /**
     * Small format. Use with Product Form code PC or PF
     */
    Mini_calendar_or_pocket_diary("P102", "Mini calendar or pocket diary"),

    /**
     * Usually with time-of-day subdivisions (rather than just days). Use with Product Form code PC or PF
     */
    Engagement_calendar_or_Appointment_diary("P103", "Engagement calendar or Appointment diary"),

    /**
     * Eg tear-off calendars. Use with Product Form code PC
     */
    Day_by_day_calendar("P104", "Day by day calendar"),

    /**
     * Large single-sheet calendar intended for hanging. Use with Product Form code PC or PK
     */
    Poster_calendar("P105", "Poster calendar"),

    /**
     * Large calendar intended for hanging, usually one page per month. Use with Product Form code PC
     */
    Wall_calendar("P106", "Wall calendar"),

    /**
     * Usually undated. Use with Product Form code PC or PF
     */
    Perpetual_calendar_or_diary("P107", "Perpetual calendar or diary"),

    /**
     * Use with Product Form code PC
     */
    Advent_calendar("P108", "Advent calendar"),

    /**
     * Use with Product Form code PC or PT
     */
    Bookmark_calendar("P109", "Bookmark calendar"),

    /**
     * Mid-year diary, start and end aligned with the academic year. Use with Product Form code PC or PF
     */
    Student_or_Academic_calendar_or_diary("P110", "Student or Academic calendar or diary"),

    /**
     * Use with Product Form code PC
     */
    Project_calendar("P111", "Project calendar"),

    /**
     * Use with Product Form code PC
     */
    Almanac_calendar("P112", "Almanac calendar"),

    /**
     * A calendar, diary or organiser that is not one of the types specified elsewhere: use with Product Form code PC,
     * PF or PS
     */
    Other_calendar_diary_or_organiser("P113", "Other calendar, diary or organiser"),

    /**
     * A product that is associated with or ancillary to a calendar or organiser, eg a deskstand for a calendar, or an
     * insert for an organiser: use with Product Form code PC or PS
     */
    Other_calendar_or_organiser_product("P114", "Other calendar or organiser product"),

    /**
     * Wall or poster calendar with entries for each family member. Use with Product Form code PC or PK
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Family_planner("P115", "Family planner"),

    /**
     * Calendar sheets detachable (usually perforated) and intended for mailing as postcards. Use with Product Form code
     * PC
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Postcard_calendar("P116", "Postcard calendar"),

    /**
     * Kamishibai / Cantastoria cards
     */
    Picture_story_cards("P120", "Picture story cards"),

    /**
     * For use to specify letter, word, image (etc) recognition cards for teaching reading or other classroom use. Use
     * with Product form code PD
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Flash_cards("P121", "Flash cards"),

    /**
     * Quick reference cards, revision cards, recipe cards etc. Use with Product form code PD
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Reference_cards("P122", "Reference cards"),

    /**
     * For use to specify cards and card decks for gaming, collecting and trading etc. Use also for divination cards.
     * Use with Product form codes PD
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Recreation_cards("P123", "Recreation cards"),

    /**
     * And postcard packs / books. Use with Product form code PJ
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Postcards("P124", "Postcards"),

    /**
     * And greeting card packs. Use with Product form code PJ
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Greeting_cards("P125", "Greeting cards"),

    /**
     * Physical cards which carry an intrinsic value, or which are intended to have value added to them, that may be
     * redeemed later. For example book token cards, gift cards. Note value additions and redemption may be in a
     * physical store or online
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Gift_cards("P126", "Gift cards"),

    /**
     * Blank certificate, award or achievement cards. Use with Product form code PD
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Certificate_cards("P127", "Certificate cards"),

    /**
     * Stationery item in hardback book format
     */
    Hardback_stationery("P201", "Hardback (stationery)"),

    /**
     * Stationery item in paperback/softback book format
     */
    Paperback_softback_stationery("P202", "Paperback / softback (stationery)"),

    /**
     * Stationery item in spiral-bound book format
     */
    Spiral_bound_stationery("P203", "Spiral bound (stationery)"),

    /**
     * Stationery item in leather-bound book format, or other fine binding
     */
    Leather_fine_binding_stationery("P204", "Leather / fine binding (stationery)"),

    /**
     * For wall map, poster, wallchart etc
     */
    With_hanging_strips("P301", "With hanging strips"),

    /**
     * Content is printed single-sided (for wallcharts and hanging maps, calendars, etc)
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Single_sided("P305", "Single-sided"),

    /**
     * Content is printed double-sided (for wallcharts and hanging maps, calendars, etc, where double-sided may not
     * always be expected)
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Double_sided("P306", "Double-sided"),

    /**
     * SD TV standard for video or DVD
     */
    PAL("V201", "PAL"),

    /**
     * SD TV standard for video or DVD
     */
    NTSC("V202", "NTSC"),

    /**
     * SD TV standard for video or DVD
     */
    SECAM("V203", "SECAM"),

    /**
     * Up to 2K resolution (1920 or 2048 pixels wide) eg for Blu-Ray
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    HD("V205", "HD"),

    /**
     * Up to 4K resolution (3840 or 4096 pixels wide) eg for Ultra HD Blu-Ray
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    UHD("V206", "UHD"),

    /**
     * Eg for Blu-ray 3D
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    _3D_video("V207", "3D video"),

    /**
     * Licensed for use in domestic contexts only
     */
    Home_use("V220", "Home use"),

    /**
     * Licensed for use in education
     */
    Classroom_use("V221", "Classroom use"),

    /**
     * Primary material composition (eg of kit or puzzle pieces, of gameplay tokens or tiles) is wood or has wooden
     * pieces/parts
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Wooden("Z101", "Wooden"),

    /**
     * Plastic or plastic pieces/parts
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Plastic("Z102", "Plastic"),

    /**
     * Card or board pieces/parts
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Board("Z103", "Board"),

    /**
     * Puzzle assembles into a 3D object
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    _3D_puzzle("Z111", "3D puzzle"),

    /**
     * Toy makes a noise. See B208 for noisy books
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Noisy_kit_puzzle_toy("Z112", "Noisy kit / puzzle / toy"),

    /**
     * Including finger / hand puppets, marionettes
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Puppet("Z113", "Puppet"),

    /**
     * Designed and sized for the very young, or those with visual impairments, limited motor skills, dementia etc
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Extra_large_pieces("Z121", "Extra large pieces");

    public final String code;
    public final String description;

    ProductFormDetails(String code, String description) {
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

    private static volatile Map<String, ProductFormDetails> map;

    private static Map<String, ProductFormDetails> map() {
        Map<String, ProductFormDetails> result = map;
        if (result == null) {
            synchronized (ProductFormDetails.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ProductFormDetails e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ProductFormDetails byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
