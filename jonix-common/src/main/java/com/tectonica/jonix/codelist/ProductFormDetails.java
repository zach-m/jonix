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

import java.util.HashMap;
import java.util.Map;

import com.tectonica.jonix.OnixCodelist;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 78</b>
 * <p>
 * Description: Product form detail
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">About ONIX Codelists</a>
 * @see <a
 *      href="http://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_32.html#codelist78">ONIX
 *      Codelist 78 in Reference Guide</a>
 */
public enum ProductFormDetails implements OnixCodelist
{
	/**
	 * CD 'red book' format
	 */
	CD_standard_audio_format("A101", "CD standard audio format"), //

	SACD_super_audio_format("A102", "SACD super audio format"), //

	/**
	 * MPEG-1/2 Audio Layer III file
	 */
	MP3_format("A103", "MP3 format"), //

	/**
	 * Waveform audio file
	 */
	WAV_format("A104", "WAV format"), //

	Real_Audio_format("A105", "Real Audio format"), //

	/**
	 * Windows Media Audio format
	 */
	WMA("A106", "WMA"), //

	/**
	 * Advanced Audio Coding format
	 */
	AAC("A107", "AAC"), //

	/**
	 * Vorbis audio format in the Ogg container
	 */
	Ogg_Vorbis("A108", "Ogg/Vorbis"), //

	/**
	 * Audio format proprietary to Audible.com
	 */
	Audible("A109", "Audible"), //

	/**
	 * Free lossless audio codec
	 */
	FLAC("A110", "FLAC"), //

	/**
	 * Audio Interchangeable File Format
	 */
	AIFF("A111", "AIFF"), //

	/**
	 * Apple Lossless Audio Codec
	 */
	ALAC("A112", "ALAC"), //

	/**
	 * Deprecated, as does not meet DAISY 2 standard. Use conventional audiobook codes instead
	 */
	DAISY_2_full_audio_with_title_only_no_navigation("A201", "DAISY 2: full audio with title only (no navigation)"), //

	DAISY_2_full_audio_with_navigation_no_text("A202", "DAISY 2: full audio with navigation (no text)"), //

	DAISY_2_full_audio_with_navigation_and_partial_text("A203", "DAISY 2: full audio with navigation and partial text"), //

	DAISY_2_full_audio_with_navigation_and_full_text("A204", "DAISY 2: full audio with navigation and full text"), //

	/**
	 * Reading systems may provide full audio via text-to-speech
	 */
	DAISY_2_full_text_with_navigation_and_partial_audio("A205", "DAISY 2: full text with navigation and partial audio"), //

	/**
	 * Reading systems may provide full audio via text-to-speech
	 */
	DAISY_2_full_text_with_navigation_and_no_audio("A206", "DAISY 2: full text with navigation and no audio"), //

	/**
	 * Deprecated, as does not meet DAISY 3 standard. Use conventional audiobook codes instead
	 */
	DAISY_3_full_audio_with_title_only_no_navigation("A207", "DAISY 3: full audio with title only (no navigation)"), //

	DAISY_3_full_audio_with_navigation_no_text("A208", "DAISY 3: full audio with navigation (no text)"), //

	DAISY_3_full_audio_with_navigation_and_partial_text("A209", "DAISY 3: full audio with navigation and partial text"), //

	DAISY_3_full_audio_with_navigation_and_full_text("A210", "DAISY 3: full audio with navigation and full text"), //

	/**
	 * Reading systems may provide full audio via text-to-speech
	 */
	DAISY_3_full_text_with_navigation_and_some_audio("A211", "DAISY 3: full text with navigation and some audio"), //

	/**
	 * Reading systems may provide full audio via text-to-speech
	 */
	DAISY_3_full_text_with_navigation_no_audio("A212", "DAISY 3: full text with navigation (no audio)"), //

	Standalone_audio("A301", "Standalone audio"), //

	/**
	 * Audio intended exclusively for use alongside a printed copy of the book. Most often a children's product.
	 * Normally contains instructions such as 'turn the page now' and other references to the printed item, and is
	 * usually sold packaged together with a printed copy
	 */
	Readalong_audio("A302", "Readalong audio"), //

	/**
	 * Audio intended for musical accompaniment, eg 'Music minus one', etc, often used for music learning. Includes
	 * singalong backing audio for musical learning or for Karaoke-style entertainment
	 */
	Playalong_audio("A303", "Playalong audio"), //

	/**
	 * Audio intended for language learning, which includes speech plus gaps intended to be filled by the listener
	 */
	Speakalong_audio("A304", "Speakalong audio"), //

	/**
	 * Audio synchronised to text within an e-publication, for example an EPUB3 with audio overlay. Synchronisation at
	 * least at paragraph level, and covering the full content
	 */
	Synchronised_audio("A305", "Synchronised audio"), //

	/**
	 * Includes &apos;stereo&apos; where channels are identical &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Mono("A410", "Mono"), //

	/**
	 * null &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Stereo("A420", "Stereo"), //

	/**
	 * Stereo plus low-frequency channel &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Stereo_2_1("A421", "Stereo 2.1"), //

	/**
	 * Five-channel audio (including low-frequency channel) &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Surround_4_1("A441", "Surround 4.1"), //

	/**
	 * Six-channel audio (including low-frequency channel) &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Surround_5_1("A451", "Surround 5.1"), //

	/**
	 * In North America, a category of paperback characterized partly by page size (typically 4&#188; x 7 1/8 inches)
	 * and partly by target market and terms of trade. Use with Product Form code BC
	 */
	Mass_market_rack("B101", "Mass market (rack) paperback"), //

	/**
	 * In North America, a category of paperback characterized partly by page size and partly by target market and terms
	 * of trade. AKA 'quality paperback', and including textbooks. Most paperback books sold in North America except
	 * 'mass-market' (B101) and 'tall rack' (B107) are correctly described with this code. Use with Product Form code BC
	 */
	Trade_paperback_US("B102", "Trade paperback (US)"), //

	/**
	 * In North America, a category of paperback characterized by page size and generally used for children's books; use
	 * with Product Form code BC. Note: was wrongly shown as B102 (duplicate entry) in Issue 3
	 */
	Digest_format_paperback("B103", "Digest format paperback"), //

	/**
	 * In UK, a category of paperback characterized by page size (normally 178 x 111 mm approx); use with Product Form
	 * code BC
	 */
	A_format_paperback("B104", "A-format paperback"), //

	/**
	 * In UK, a category of paperback characterized by page size (normally 198 x 129 mm approx); use with Product Form
	 * code BC
	 */
	B_format_paperback("B105", "B-format paperback"), //

	/**
	 * In UK, a category of paperback characterized partly by size (usually in traditional hardback dimensions), and
	 * often used for paperback originals; use with Product Form code BC (replaces 'C-format' from former List 8)
	 */
	Trade_paperback_UK("B106", "Trade paperback (UK)"), //

	/**
	 * In North America, a category of paperback characterised partly by page size and partly by target market and terms
	 * of trade; use with Product Form code BC
	 */
	Tall_rack_paperback_US("B107", "Tall rack paperback (US)"), //

	/**
	 * 210x148mm
	 */
	A5_size_Tankobon("B108", "A5 size Tankobon"), //

	/**
	 * Japanese B-series size, 257x182mm
	 */
	JIS_B5_size_Tankobon("B109", "JIS B5 size Tankobon"), //

	/**
	 * Japanese B-series size, 182x128mm
	 */
	JIS_B6_size_Tankobon("B110", "JIS B6 size Tankobon"), //

	/**
	 * 148x105mm
	 */
	A6_size_Bunko("B111", "A6 size Bunko"), //

	/**
	 * Japanese format, 182x103mm or 173x105mm
	 */
	B40_dori_Shinsho("B112", "B40-dori Shinsho"), //

	/**
	 * A Swedish, Norwegian, French paperback format, of no particular fixed size. Use with Product Form Code BC
	 */
	Pocket_Sweden_Norway_France("B113", "Pocket (Sweden, Norway, France)"), //

	/**
	 * A Swedish paperback format, use with Product Form Code BC
	 */
	Storpocket_Sweden("B114", "Storpocket (Sweden)"), //

	/**
	 * A Swedish hardback format, use with Product Form Code BB
	 */
	Kartonnage_Sweden("B115", "Kartonnage (Sweden)"), //

	/**
	 * A Swedish softback format, use with Product Form Code BC
	 */
	Flexband_Sweden("B116", "Flexband (Sweden)"), //

	/**
	 * A softback book in the format of a magazine, usually sold like a book. Use with Product Form code BC
	 */
	Mook_Bookazine("B117", "Mook / Bookazine"), //

	/**
	 * Also called 'Flipback'. A softback book in a specially compact proprietary format with pages printed in landscape
	 * on very thin paper and bound along the long (top) edge - see www.dwarsligger.com
	 */
	Dwarsligger("B118", "Dwarsligger"), //

	/**
	 * Japanese format: 188x127mm
	 */
	_46_size("B119", "46 size"), //

	/**
	 * Japanese format
	 */
	_46_Henkei_size("B120", "46-Henkei size"), //

	/**
	 * 297x210mm
	 */
	A4("B121", "A4"), //

	/**
	 * Japanese format
	 */
	A4_Henkei_size("B122", "A4-Henkei size"), //

	/**
	 * Japanese format
	 */
	A5_Henkei_size("B123", "A5-Henkei size"), //

	/**
	 * Japanese format
	 */
	B5_Henkei_size("B124", "B5-Henkei size"), //

	/**
	 * Japanese format
	 */
	B6_Henkei_size("B125", "B6-Henkei size"), //

	/**
	 * 257x210mm
	 */
	AB_size("B126", "AB size"), //

	/**
	 * Japanese B-series size, 128x91mm
	 */
	JIS_B7_size("B127", "JIS B7 size"), //

	/**
	 * Japanese format, 218x152mm or 227x152mm
	 */
	Kiku_size("B128", "Kiku size"), //

	/**
	 * Japanese format
	 */
	Kiku_Henkei_size("B129", "Kiku-Henkei size"), //

	/**
	 * Japanese B-series size, 364x257mm
	 */
	JIS_B4_size("B130", "JIS B4 size"), //

	/**
	 * German paperback format, greater than 205mm high, with flaps. Use with Product form code BC
	 */
	Paperback_DE("B131", "Paperback (DE)"), //

	Coloring_join_the_dot_book("B201", "Coloring / join-the-dot book"), //

	Lift_the_flap_book("B202", "Lift-the-flap book"), //

	/**
	 * DEPRECATED because of ambiguity - use B210, B214 or B215 as appropriate
	 */
	Fuzzy_book("B203", "Fuzzy book"), //

	/**
	 * Note: was wrongly shown as B203 (duplicate entry) in Issue 3
	 */
	Miniature_book("B204", "Miniature book"), //

	Moving_picture_flicker_book("B205", "Moving picture / flicker book"), //

	Pop_up_book("B206", "Pop-up book"), //

	Scented_smelly_book("B207", "Scented / ‘smelly’ book"), //

	Sound_story_noisy_book("B208", "Sound story / ‘noisy’ book"), //

	Sticker_book("B209", "Sticker book"), //

	/**
	 * A book whose pages have a variety of textured inserts designed to stimulate tactile exploration: see also B214
	 * and B215
	 */
	Touch_and_feel_book("B210", "Touch-and-feel book"), //

	/**
	 * DEPRECATED - use B212 or B213 as appropriate
	 */
	Toy_die_cut_book("B211", "Toy / die-cut book"), //

	/**
	 * A book which is cut into a distinctive non-rectilinear shape and/or in which holes or shapes have been cut
	 * internally. ('Die-cut' is used here as a convenient shorthand, and does not imply strict limitation to a
	 * particular production process)
	 */
	Die_cut_book("B212", "Die-cut book"), //

	/**
	 * A book which is also a toy, or which incorporates a toy as an integral part. (Do not, however, use B213 for a
	 * multiple-item product which includes a book and a toy as separate items)
	 */
	Book_as_toy("B213", "Book-as-toy"), //

	/**
	 * A book whose cover has a soft textured finish, typically over board
	 */
	Soft_to_touch_book("B214", "Soft-to-touch book"), //

	/**
	 * A book with detachable felt pieces and textured pages on which they can be arranged
	 */
	Fuzzy_felt_book("B215", "Fuzzy-felt book"), //

	/**
	 * Children's picture book: use with applicable Product Form code
	 */
	Picture_book("B221", "Picture book"), //

	/**
	 * (aka 'Star' book). Tax treatment of products may differ from that of products with similar codes such as Book as
	 * toy or Pop-up book)
	 */
	_Carousel_book("B222", "‘Carousel’ book"), //

	/**
	 * Use with Product Form code BD
	 */
	Loose_leaf_sheets_and_binder("B301", "Loose leaf – sheets and binder"), //

	/**
	 * Use with Product Form code BD
	 */
	Loose_leaf_binder_only("B302", "Loose leaf – binder only"), //

	/**
	 * Use with Product Form code BD
	 */
	Loose_leaf_sheets_only("B303", "Loose leaf – sheets only"), //

	/**
	 * AKA stitched; for 'saddle-sewn', see code B310
	 */
	Sewn("B304", "Sewn"), //

	/**
	 * Including 'perfect bound', 'glued'
	 */
	Unsewn_adhesive_bound("B305", "Unsewn / adhesive bound"), //

	/**
	 * Strengthened cloth-over-boards binding intended for libraries: use with Product form code BB
	 */
	Library_binding("B306", "Library binding"), //

	/**
	 * Strengthened binding, not specifically intended for libraries
	 */
	Reinforced_binding("B307", "Reinforced binding"), //

	/**
	 * Must be accompanied by a code specifiying a material, eg 'half-bound real leather'
	 */
	Half_bound("B308", "Half bound"), //

	/**
	 * Must be accompanied by a code specifiying a material, eg 'quarter bound real leather'
	 */
	Quarter_bound("B309", "Quarter bound"), //

	/**
	 * AKA 'saddle-stitched' or 'wire-stitched'
	 */
	Saddle_sewn("B310", "Saddle-sewn"), //

	/**
	 * Round or oval plastic forms in a clamp-like configuration: use with Product Form code BE
	 */
	Comb_bound("B311", "Comb bound"), //

	/**
	 * Twin loop metal wire spine: use with Product Form code BE
	 */
	Wire_O("B312", "Wire-O"), //

	/**
	 * Cased over Coiled or Wire-O binding: use with Product Form code BE and Product Form Detail code B312 or B315
	 */
	Concealed_wire("B313", "Concealed wire"), //

	/**
	 * Spiral wire bound. Use with product form code BE. The default if a spiral binding type is not stated. Cf. Comb
	 * and Wire-O binding &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Coiled_wire_bound("B314", "Coiled wire bound"), //

	/**
	 * Hardcover binding intended for general consumers rather than libraries, use with Product form code BB. The
	 * default if a hardcover binding detail is not stated. cf. Library binding &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Trade_binding("B315", "Trade binding"), //

	/**
	 * Covers do not use a distinctive stock, but are the same as the body pages &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Self_cover("B400", "Self-cover"), //

	/**
	 * AKA fabric, linen over boards
	 */
	Cloth_over_boards("B401", "Cloth over boards"), //

	Paper_over_boards("B402", "Paper over boards"), //

	Leather_real("B403", "Leather, real"), //

	Leather_imitation("B404", "Leather, imitation"), //

	Leather_bonded("B405", "Leather, bonded"), //

	Vellum("B406", "Vellum"), //

	/**
	 * DEPRECATED - use new B412 or B413 as appropriate
	 */
	Plastic("B407", "Plastic"), //

	/**
	 * DEPRECATED - use new B412 or B414 as appropriate
	 */
	Vinyl("B408", "Vinyl"), //

	/**
	 * Cloth, not necessarily over boards - cf B401
	 */
	Cloth("B409", "Cloth"), //

	/**
	 * Spanish 'simil-tela'
	 */
	Imitation_cloth("B410", "Imitation cloth"), //

	Velvet("B411", "Velvet"), //

	/**
	 * AKA 'flexibound': use with Product Form code BC
	 */
	Flexible_plastic_vinyl_cover("B412", "Flexible plastic/vinyl cover"), //

	Plastic_covered("B413", "Plastic-covered"), //

	Vinyl_covered("B414", "Vinyl-covered"), //

	/**
	 * Book, laminating material unspecified: use L101 for 'whole product laminated', eg a laminated sheet map or
	 * wallchart
	 */
	Laminated_cover("B415", "Laminated cover"), //

	/**
	 * With card cover (like a typical paperback). As distinct from a self-cover or more elaborate binding
	 * &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Card_cover("B416", "Card cover"), //

	/**
	 * Type unspecified
	 */
	With_dust_jacket("B501", "With dust jacket"), //

	/**
	 * Used to distinguish from B503
	 */
	With_printed_dust_jacket("B502", "With printed dust jacket"), //

	/**
	 * With translucent paper or plastic protective cover
	 */
	With_translucent_dust_cover("B503", "With translucent dust cover"), //

	/**
	 * For paperback with flaps
	 */
	With_flaps("B504", "With flaps"), //

	With_thumb_index("B505", "With thumb index"), //

	/**
	 * If the number of markers is significant, it can be stated as free text in &lt;ProductFormDescription&gt;
	 */
	With_ribbon_marker_s("B506", "With ribbon marker(s)"), //

	With_zip_fastener("B507", "With zip fastener"), //

	With_button_snap_fastener("B508", "With button snap fastener"), //

	/**
	 * AKA yapp edge?
	 */
	With_leather_edge_lining("B509", "With leather edge lining"), //

	/**
	 * With edge trimming such that the front edge is ragged, not neatly and squarely trimmed: AKA deckle edge, feather
	 * edge, uncut edge, rough cut
	 */
	Rough_front("B510", "Rough front"), //

	/**
	 * With one or more gatefold or foldout sections bound in
	 */
	With_foldout("B511", "With foldout"), //

	/**
	 * Pages include extra-wide margin specifically intended for hand-written annotations
	 */
	Wide_margin("B512", "Wide margin"), //

	/**
	 * Book with attached loop for fixing to baby stroller, cot, chair etc &lt;p&gt;NOTE: Introduced in Onix3
	 */
	With_fastening_strap("B513", "With fastening strap"), //

	/**
	 * With one or more pages perforated and intended to be torn out for use &lt;p&gt;NOTE: Introduced in Onix3
	 */
	With_perforated_pages("B514", "With perforated pages"), //

	/**
	 * A book in which half the content is printed upside-down, to be read the other way round. Also known as a
	 * 'flip-book', 'back-to-back', (fr.) 't&#234;te-b&#234;che' (usually an omnibus of two works)
	 */
	Turn_around_book("B601", "Turn-around book"), //

	/**
	 * Manga with pages and panels in the sequence of the original Japanese, but with Western text
	 */
	Unflipped_manga_format("B602", "Unflipped manga format"), //

	/**
	 * Text shows syllable breaks
	 */
	Syllabification("B610", "Syllabification"), //

	/**
	 * Single letters only. Was formerly identified as UK Braille Grade 1
	 */
	UK_Uncontracted_Braille("B701", "UK Uncontracted Braille"), //

	/**
	 * With some letter combinations. Was formerly identified as UK Braille Grade 2
	 */
	UK_Contracted_Braille("B702", "UK Contracted Braille"), //

	/**
	 * DEPRECATED- use B704/B705 as appropriate instead
	 */
	US_Braille("B703", "US Braille"), //

	US_Uncontracted_Braille("B704", "US Uncontracted Braille"), //

	US_Contracted_Braille("B705", "US Contracted Braille"), //

	Unified_English_Braille("B706", "Unified English Braille"), //

	/**
	 * Moon embossed alphabet, used by some print-impaired readers who have difficulties with Braille
	 */
	Moon("B707", "Moon"), //

	/**
	 * Includes RealVideo packaged within a .rm RealMedia container
	 */
	Real_Video_format("D101", "Real Video format"), //

	Quicktime_format("D102", "Quicktime format"), //

	AVI_format("D103", "AVI format"), //

	Windows_Media_Video_format("D104", "Windows Media Video format"), //

	MPEG_4("D105", "MPEG-4"), //

	/**
	 * Use with an applicable Product Form code D*; note that more detail of operating system requirements can be given
	 * in a Product Form Feature composite
	 */
	MS_DOS("D201", "MS-DOS"), //

	/**
	 * Use with an applicable Product Form code D*; see note on D201
	 */
	Windows("D202", "Windows"), //

	/**
	 * Use with an applicable Product Form code D*; see note on D201
	 */
	Macintosh("D203", "Macintosh"), //

	/**
	 * Use with an applicable Product Form code D*; see note on D201
	 */
	UNIX_LINUX("D204", "UNIX / LINUX"), //

	/**
	 * Use with an applicable Product Form code D*; see note on D201
	 */
	Other_operating_system_s("D205", "Other operating system(s)"), //

	/**
	 * Use with an applicable Product Form code D*; see note on D201
	 */
	Palm_OS("D206", "Palm OS"), //

	/**
	 * Use with an applicable Product Form code D*; see note on D201
	 */
	Windows_Mobile("D207", "Windows Mobile"), //

	/**
	 * Use with Product Form code DE or DB as applicable
	 */
	Microsoft_XBox("D301", "Microsoft XBox"), //

	/**
	 * Use with Product Form code DE or DB as applicable
	 */
	Nintendo_Gameboy_Color("D302", "Nintendo Gameboy Color"), //

	/**
	 * Use with Product Form code DE or DB as applicable
	 */
	Nintendo_Gameboy_Advanced("D303", "Nintendo Gameboy Advanced"), //

	/**
	 * Use with Product Form code DE or DB as applicable
	 */
	Nintendo_Gameboy("D304", "Nintendo Gameboy"), //

	/**
	 * Use with Product Form code DE or DB as applicable
	 */
	Nintendo_Gamecube("D305", "Nintendo Gamecube"), //

	/**
	 * Use with Product Form code DE or DB as applicable
	 */
	Nintendo_64("D306", "Nintendo 64"), //

	/**
	 * Use with Product Form code DE or DB as applicable
	 */
	Sega_Dreamcast("D307", "Sega Dreamcast"), //

	/**
	 * Use with Product Form code DE or DB as applicable
	 */
	Sega_Genesis_Megadrive("D308", "Sega Genesis/Megadrive"), //

	/**
	 * Use with Product Form code DE or DB as applicable
	 */
	Sega_Saturn("D309", "Sega Saturn"), //

	/**
	 * Use with Product Form code DE or DB as applicable
	 */
	Sony_PlayStation_1("D310", "Sony PlayStation 1"), //

	/**
	 * Use with Product Form code DE or DB as applicable
	 */
	Sony_PlayStation_2("D311", "Sony PlayStation 2"), //

	Nintendo_Dual_Screen("D312", "Nintendo Dual Screen"), //

	Sony_PlayStation_3("D313", "Sony PlayStation 3"), //

	Xbox_360("D314", "Xbox 360"), //

	Nintendo_Wii("D315", "Nintendo Wii"), //

	Sony_PlayStation_Portable_PSP("D316", "Sony PlayStation Portable (PSP)"), //

	/**
	 * Use where a particular e-publication type (specified in &lt;EpubType&gt;) has both reflowable and fixed-format
	 * variants
	 */
	Reflowable("E200", "Reflowable"), //

	/**
	 * Use where a particular e-publication type (specified in &lt;EpubType&gt;) has both reflowable and fixed-format
	 * variants
	 */
	Fixed_format("E201", "Fixed format"), //

	/**
	 * All e-publication resources are included within the e-publication package
	 */
	Readable_offline("E202", "Readable offline"), //

	/**
	 * E-publication requires a network connection to access some resources (eg an enhanced e-book where video clips are
	 * not stored within the e-publication 'package' itself, but are delivered via an internet connection)
	 */
	Requires_network_connection("E203", "Requires network connection"), //

	/**
	 * Resources (eg images) present in other editions have been removed from this product, eg due to rights issues
	 */
	Content_removed("E204", "Content removed"), //

	/**
	 * Use for fixed-format e-books optimised for landscape display. Also include an indication of the optimal screen
	 * aspect ratio
	 */
	Landscape("E210", "Landscape"), //

	/**
	 * Use for fixed-format e-books optimised for portrait display. Also include an indication of the optimal screen
	 * aspect ratio
	 */
	Portrait("E211", "Portrait"), //

	/**
	 * Use for fixed-format e-books optimised for displays with a 5:4 aspect ratio (eg 1280x1024 pixels etc, assuming
	 * square pixels). Note that aspect ratio codes are NOT specific to actual screen dimensions or pixel counts, but to
	 * the ratios between two dimensions or two pixel counts
	 */
	_5_4("E221", "5:4"), //

	/**
	 * Use for fixed-format e-books optimised for displays with a 4:3 aspect ratio (eg 800x600, 1024x768, 2048x1536
	 * pixels etc)
	 */
	_4_3("E222", "4:3"), //

	/**
	 * Use for fixed-format e-books optimised for displays with a 3:2 aspect ratio (eg 960x640, 3072x2048 pixels etc)
	 */
	_3_2("E223", "3:2"), //

	/**
	 * Use for fixed-format e-books optimised for displays with a 16:10 aspect ratio (eg 1440x900, 2560x1600 pixels etc)
	 */
	_16_10("E224", "16:10"), //

	/**
	 * Use for fixed-format e-books optimised for displays with a 16:9 aspect ratio (eg 1024x576, 1920x1080, 2048x1152
	 * pixels etc)
	 */
	_16_9("E225", "16:9"), //

	/**
	 * Whole product laminated (eg laminated map, fold-out chart, wallchart, etc): use B415 for book with laminated
	 * cover
	 */
	Laminated("L101", "Laminated"), //

	/**
	 * Use with Product Form code PC
	 */
	Desk_calendar("P101", "Desk calendar"), //

	/**
	 * Use with Product Form code PC
	 */
	Mini_calendar("P102", "Mini calendar"), //

	/**
	 * Use with Product Form code PC
	 */
	Engagement_calendar("P103", "Engagement calendar"), //

	/**
	 * Use with Product Form code PC
	 */
	Day_by_day_calendar("P104", "Day by day calendar"), //

	/**
	 * Use with Product Form code PC
	 */
	Poster_calendar("P105", "Poster calendar"), //

	/**
	 * Use with Product Form code PC
	 */
	Wall_calendar("P106", "Wall calendar"), //

	/**
	 * Use with Product Form code PC
	 */
	Perpetual_calendar("P107", "Perpetual calendar"), //

	/**
	 * Use with Product Form code PC
	 */
	Advent_calendar("P108", "Advent calendar"), //

	/**
	 * Use with Product Form code PC
	 */
	Bookmark_calendar("P109", "Bookmark calendar"), //

	/**
	 * Use with Product Form code PC
	 */
	Student_calendar("P110", "Student calendar"), //

	/**
	 * Use with Product Form code PC
	 */
	Project_calendar("P111", "Project calendar"), //

	/**
	 * Use with Product Form code PC
	 */
	Almanac_calendar("P112", "Almanac calendar"), //

	/**
	 * A calendar that is not one of the types specified elsewhere: use with Product Form code PC
	 */
	Other_calendar("P113", "Other calendar"), //

	/**
	 * A product that is associated with or ancillary to a calendar or organiser, eg a deskstand for a calendar, or an
	 * insert for an organiser: use with Product Form code PC or PS
	 */
	Other_calendar_or_organiser_product("P114", "Other calendar or organiser product"), //

	/**
	 * Kamishibai / Cantastoria cards &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Picture_story_cards("P120", "Picture story cards"), //

	/**
	 * Stationery item in hardback book format
	 */
	Hardback_stationery("P201", "Hardback (stationery)"), //

	/**
	 * Stationery item in paperback/softback book format
	 */
	Paperback_softback_stationery("P202", "Paperback / softback (stationery)"), //

	/**
	 * Stationery item in spiral-bound book format
	 */
	Spiral_bound_stationery("P203", "Spiral bound (stationery)"), //

	/**
	 * Stationery item in leather-bound book format, or other fine binding
	 */
	Leather_fine_binding_stationery("P204", "Leather / fine binding (stationery)"), //

	/**
	 * For map, poster, wallchart etc &lt;p&gt;NOTE: Introduced in Onix3
	 */
	With_hanging_strips("P301", "With hanging strips"), //

	/**
	 * TV standard for video or DVD
	 */
	PAL("V201", "PAL"), //

	/**
	 * TV standard for video or DVD
	 */
	NTSC("V202", "NTSC"), //

	/**
	 * TV standard for video or DVD
	 */
	SECAM("V203", "SECAM"), //

	/**
	 * Licensed for use in domestic contexts only &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Home_use("V220", "Home use"), //

	/**
	 * Licensed for use in education &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Classroom_use("V221", "Classroom use");

	public final String code;
	public final String description;

	private ProductFormDetails(String code, String description)
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

	private static volatile Map<String, ProductFormDetails> map;

	private static Map<String, ProductFormDetails> map()
	{
		Map<String, ProductFormDetails> result = map;
		if (result == null)
		{
			synchronized (ProductFormDetails.class)
			{
				result = map;
				if (result == null)
				{
					result = new HashMap<>();
					for (ProductFormDetails e : values())
						result.put(e.code, e);
					map = result;
				}
			}
		}
		return result;
	}

	public static ProductFormDetails byCode(String code)
	{
		if (code == null || code.isEmpty())
			return null;
		return map().get(code);
	}
}
