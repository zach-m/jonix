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

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DON'T EDIT MANUALLY
 */

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 78</b>
 * <p>
 * Description: Product form detail
 * 
 * @see <a href="http://www.editeur.org/14/code-lists">ONIX Codelists</a>
 */
public enum ProductFormDetails
{
	/**
	 * CD &#8216;red book&#8217; format
	 */
	CD_standard_audio_format("A101"), //

	SACD_super_audio_format("A102"), //

	/**
	 * MPEG-1/2 Audio Layer III file
	 */
	MP3_format("A103"), //

	/**
	 * Waveform audio file
	 */
	WAV_format("A104"), //

	Real_Audio_format("A105"), //

	/**
	 * Windows Media Audio format
	 */
	WMA("A106"), //

	/**
	 * Advanced Audio Coding format
	 */
	AAC("A107"), //

	/**
	 * Vorbis audio format in the Ogg container
	 */
	Ogg_Vorbis("A108"), //

	/**
	 * Audio format proprietary to Audible.com
	 */
	Audible("A109"), //

	/**
	 * Free lossless audio codec
	 */
	FLAC("A110"), //

	/**
	 * Audio Interchangeable File Format
	 */
	AIFF("A111"), //

	/**
	 * Apple Lossless Audio Codec
	 */
	ALAC("A112"), //

	/**
	 * Deprecated, as does not meet DAISY 2 standard. Use conventional audiobook codes instead
	 */
	DAISY_2_full_audio_with_title_only_no_navigation("A201"), //

	DAISY_2_full_audio_with_navigation_no_text("A202"), //

	DAISY_2_full_audio_with_navigation_and_partial_text("A203"), //

	DAISY_2_full_audio_with_navigation_and_full_text("A204"), //

	/**
	 * Reading systems may provide full audio via text-to-speech
	 */
	DAISY_2_full_text_with_navigation_and_partial_audio("A205"), //

	/**
	 * Reading systems may provide full audio via text-to-speech
	 */
	DAISY_2_full_text_with_navigation_and_no_audio("A206"), //

	/**
	 * Deprecated, as does not meet DAISY 3 standard. Use conventional audiobook codes instead
	 */
	DAISY_3_full_audio_with_title_only_no_navigation("A207"), //

	DAISY_3_full_audio_with_navigation_no_text("A208"), //

	DAISY_3_full_audio_with_navigation_and_partial_text("A209"), //

	DAISY_3_full_audio_with_navigation_and_full_text("A210"), //

	/**
	 * Reading systems may provide full audio via text-to-speech
	 */
	DAISY_3_full_text_with_navigation_and_some_audio("A211"), //

	/**
	 * Reading systems may provide full audio via text-to-speech
	 */
	DAISY_3_full_text_with_navigation_no_audio("A212"), //

	Standalone_audio("A301"), //

	/**
	 * Audio intended exclusively for use alongside a printed copy of the book. Most often a children&#8217;s product.
	 * Normally contains instructions such as &#8216;turn the page now&#8217; and other references to the printed item,
	 * and is usually sold packaged together with a printed copy
	 */
	Readalong_audio("A302"), //

	/**
	 * Audio intended for musical accompaniment, eg &#8216;Music minus one&#8217;, etc, often used for music learning.
	 * Includes singalong backing audio for musical learning or for Karaoke-style entertainment
	 */
	Playalong_audio("A303"), //

	/**
	 * Audio intended for language learning, which includes speech plus gaps intended to be filled by the listener
	 */
	Speakalong_audio("A304"), //

	/**
	 * Audio synchronised to text within an e-publication, for example an EPUB3 with audio overlay. Synchronisation at
	 * least at paragraph level, and covering the full content
	 */
	Synchronised_audio("A305"), //

	/**
	 * Includes &apos;stereo&apos; where channels are identical &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Mono("A410"), //

	/**
	 * null &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Stereo("A420"), //

	/**
	 * Stereo plus low-frequency channel &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Stereo_2_1("A421"), //

	/**
	 * Five-channel audio (including low-frequency channel) &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Surround_4_1("A441"), //

	/**
	 * Six-channel audio (including low-frequency channel) &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Surround_5_1("A451"), //

	/**
	 * In North America, a category of paperback characterized partly by page size (typically 4&#188; x 7 1/8 inches)
	 * and partly by target market and terms of trade. Use with Product Form code BC
	 */
	Mass_market_rack("B101"), //

	/**
	 * In North America, a category of paperback characterized partly by page size and partly by target market and terms
	 * of trade. AKA &#8216;quality paperback&#8217;, and including textbooks. Most paperback books sold in North
	 * America except &#8216;mass-market&#8217; (B101) and &#8216;tall rack&#8217; (B107) are correctly described with
	 * this code. Use with Product Form code BC
	 */
	Trade_paperback_US("B102"), //

	/**
	 * In North America, a category of paperback characterized by page size and generally used for children&#8217;s
	 * books; use with Product Form code BC. Note: was wrongly shown as B102 (duplicate entry) in Issue 3
	 */
	Digest_format_paperback("B103"), //

	/**
	 * In UK, a category of paperback characterized by page size (normally 178 x 111 mm approx); use with Product Form
	 * code BC
	 */
	A_format_paperback("B104"), //

	/**
	 * In UK, a category of paperback characterized by page size (normally 198 x 129 mm approx); use with Product Form
	 * code BC
	 */
	B_format_paperback("B105"), //

	/**
	 * In UK, a category of paperback characterized partly by size (usually in traditional hardback dimensions), and
	 * often used for paperback originals; use with Product Form code BC (replaces &#8216;C-format&#8217; from former
	 * List 8)
	 */
	Trade_paperback_UK("B106"), //

	/**
	 * In North America, a category of paperback characterised partly by page size and partly by target market and terms
	 * of trade; use with Product Form code BC
	 */
	Tall_rack_paperback_US("B107"), //

	/**
	 * 210x148mm
	 */
	A5_size_Tankobon("B108"), //

	/**
	 * Japanese B-series size, 257x182mm
	 */
	JIS_B5_size_Tankobon("B109"), //

	/**
	 * Japanese B-series size, 182x128mm
	 */
	JIS_B6_size_Tankobon("B110"), //

	/**
	 * 148x105mm
	 */
	A6_size_Bunko("B111"), //

	/**
	 * Japanese format, 182x103mm or 173x105mm
	 */
	B40_dori_Shinsho("B112"), //

	/**
	 * A Swedish, Norwegian, French paperback format, of no particular fixed size. Use with Product Form Code BC
	 */
	Pocket_Sweden_Norway_France("B113"), //

	/**
	 * A Swedish paperback format, use with Product Form Code BC
	 */
	Storpocket_Sweden("B114"), //

	/**
	 * A Swedish hardback format, use with Product Form Code BB
	 */
	Kartonnage_Sweden("B115"), //

	/**
	 * A Swedish softback format, use with Product Form Code BC
	 */
	Flexband_Sweden("B116"), //

	/**
	 * A softback book in the format of a magazine, usually sold like a book. Use with Product Form code BC
	 */
	Mook_Bookazine("B117"), //

	/**
	 * Also called &#8216;Flipback&#8217;. A softback book in a specially compact proprietary format with pages printed
	 * in landscape on very thin paper and bound along the long (top) edge &#8211; see www.dwarsligger.com
	 */
	Dwarsligger("B118"), //

	/**
	 * Japanese format: 188x127mm
	 */
	_46_size("B119"), //

	/**
	 * Japanese format
	 */
	_46_Henkei_size("B120"), //

	/**
	 * 297x210mm
	 */
	A4("B121"), //

	/**
	 * Japanese format
	 */
	A4_Henkei_size("B122"), //

	/**
	 * Japanese format
	 */
	A5_Henkei_size("B123"), //

	/**
	 * Japanese format
	 */
	B5_Henkei_size("B124"), //

	/**
	 * Japanese format
	 */
	B6_Henkei_size("B125"), //

	/**
	 * 257x210mm
	 */
	AB_size("B126"), //

	/**
	 * Japanese B-series size, 128x91mm
	 */
	JIS_B7_size("B127"), //

	/**
	 * Japanese format, 218x152mm or 227x152mm
	 */
	Kiku_size("B128"), //

	/**
	 * Japanese format
	 */
	Kiku_Henkei_size("B129"), //

	/**
	 * Japanese B-series size, 364x257mm
	 */
	JIS_B4_size("B130"), //

	/**
	 * German paperback format, greater than 205mm high, with flaps. Use with Product form code BC
	 */
	Paperback_DE("B131"), //

	Coloring_join_the_dot_book("B201"), //

	Lift_the_flap_book("B202"), //

	/**
	 * DEPRECATED because of ambiguity &#8211; use B210, B214 or B215 as appropriate
	 */
	Fuzzy_book("B203"), //

	/**
	 * Note: was wrongly shown as B203 (duplicate entry) in Issue 3
	 */
	Miniature_book("B204"), //

	Moving_picture_flicker_book("B205"), //

	Pop_up_book("B206"), //

	Scented_smelly_book("B207"), //

	Sound_story_noisy_book("B208"), //

	Sticker_book("B209"), //

	/**
	 * A book whose pages have a variety of textured inserts designed to stimulate tactile exploration: see also B214
	 * and B215
	 */
	Touch_and_feel_book("B210"), //

	/**
	 * DEPRECATED &#8211; use B212 or B213 as appropriate
	 */
	Toy_die_cut_book("B211"), //

	/**
	 * A book which is cut into a distinctive non-rectilinear shape and/or in which holes or shapes have been cut
	 * internally. (&#8216;Die-cut&#8217; is used here as a convenient shorthand, and does not imply strict limitation
	 * to a particular production process)
	 */
	Die_cut_book("B212"), //

	/**
	 * A book which is also a toy, or which incorporates a toy as an integral part. (Do not, however, use B213 for a
	 * multiple-item product which includes a book and a toy as separate items)
	 */
	Book_as_toy("B213"), //

	/**
	 * A book whose cover has a soft textured finish, typically over board
	 */
	Soft_to_touch_book("B214"), //

	/**
	 * A book with detachable felt pieces and textured pages on which they can be arranged
	 */
	Fuzzy_felt_book("B215"), //

	/**
	 * Children&#8217;s picture book: use with applicable Product Form code
	 */
	Picture_book("B221"), //

	/**
	 * (aka &#8216;Star&#8217; book). Tax treatment of products may differ from that of products with similar codes such
	 * as Book as toy or Pop-up book)
	 */
	_Carousel_book("B222"), //

	/**
	 * Use with Product Form code BD
	 */
	Loose_leaf_sheets_and_binder("B301"), //

	/**
	 * Use with Product Form code BD
	 */
	Loose_leaf_binder_only("B302"), //

	/**
	 * Use with Product Form code BD
	 */
	Loose_leaf_sheets_only("B303"), //

	/**
	 * AKA stitched; for &#8216;saddle-sewn&#8217;, see code B310
	 */
	Sewn("B304"), //

	/**
	 * Including &#8216;perfect bound&#8217;, &#8216;glued&#8217;
	 */
	Unsewn_adhesive_bound("B305"), //

	/**
	 * Strengthened cloth-over-boards binding intended for libraries: use with Product form code BB
	 */
	Library_binding("B306"), //

	/**
	 * Strengthened binding, not specifically intended for libraries
	 */
	Reinforced_binding("B307"), //

	/**
	 * Must be accompanied by a code specifiying a material, eg &#8216;half-bound real leather&#8217;
	 */
	Half_bound("B308"), //

	/**
	 * Must be accompanied by a code specifiying a material, eg &#8216;quarter bound real leather&#8217;
	 */
	Quarter_bound("B309"), //

	/**
	 * AKA &#8216;saddle-stitched&#8217; or &#8216;wire-stitched&#8217;
	 */
	Saddle_sewn("B310"), //

	/**
	 * Round or oval plastic forms in a clamp-like configuration: use with Product Form code BE
	 */
	Comb_bound("B311"), //

	/**
	 * Twin loop metal wire spine: use with Product Form code BE
	 */
	Wire_O("B312"), //

	/**
	 * Cased over Coiled or Wire-O binding: use with Product Form code BE and Product Form Detail code B312 or B315
	 */
	Concealed_wire("B313"), //

	/**
	 * Spiral wire bound. Use with product form code BE. The default if a spiral binding type is not stated. Cf. Comb
	 * and Wire-O binding &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Coiled_wire_bound("B314"), //

	/**
	 * Hardcover binding intended for general consumers rather than libraries, use with Product form code BB. The
	 * default if a hardcover binding detail is not stated. cf. Library binding &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Trade_binding("B315"), //

	/**
	 * Covers do not use a distinctive stock, but are the same as the body pages &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Self_cover("B400"), //

	/**
	 * AKA fabric, linen over boards
	 */
	Cloth_over_boards("B401"), //

	Paper_over_boards("B402"), //

	Leather_real("B403"), //

	Leather_imitation("B404"), //

	Leather_bonded("B405"), //

	Vellum("B406"), //

	/**
	 * DEPRECATED &#8211; use new B412 or B413 as appropriate
	 */
	Plastic("B407"), //

	/**
	 * DEPRECATED &#8211; use new B412 or B414 as appropriate
	 */
	Vinyl("B408"), //

	/**
	 * Cloth, not necessarily over boards &#8211; cf B401
	 */
	Cloth("B409"), //

	/**
	 * Spanish &#8216;simil-tela&#8217;
	 */
	Imitation_cloth("B410"), //

	Velvet("B411"), //

	/**
	 * AKA &#8216;flexibound&#8217;: use with Product Form code BC
	 */
	Flexible_plastic_vinyl_cover("B412"), //

	Plastic_covered("B413"), //

	Vinyl_covered("B414"), //

	/**
	 * Book, laminating material unspecified: use L101 for &#8216;whole product laminated&#8217;, eg a laminated sheet
	 * map or wallchart
	 */
	Laminated_cover("B415"), //

	/**
	 * With card cover (like a typical paperback). As distinct from a self-cover or more elaborate binding
	 * &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Card_cover("B416"), //

	/**
	 * Type unspecified
	 */
	With_dust_jacket("B501"), //

	/**
	 * Used to distinguish from B503
	 */
	With_printed_dust_jacket("B502"), //

	/**
	 * With translucent paper or plastic protective cover
	 */
	With_translucent_dust_cover("B503"), //

	/**
	 * For paperback with flaps
	 */
	With_flaps("B504"), //

	With_thumb_index("B505"), //

	/**
	 * If the number of markers is significant, it can be stated as free text in &lt;ProductFormDescription&gt;
	 */
	With_ribbon_marker_s("B506"), //

	With_zip_fastener("B507"), //

	With_button_snap_fastener("B508"), //

	/**
	 * AKA yapp edge?
	 */
	With_leather_edge_lining("B509"), //

	/**
	 * With edge trimming such that the front edge is ragged, not neatly and squarely trimmed: AKA deckle edge, feather
	 * edge, uncut edge, rough cut
	 */
	Rough_front("B510"), //

	/**
	 * With one or more gatefold or foldout sections bound in
	 */
	With_foldout("B511"), //

	/**
	 * Pages include extra-wide margin specifically intended for hand-written annotations
	 */
	Wide_margin("B512"), //

	/**
	 * Book with attached loop for fixing to baby stroller, cot, chair etc &lt;p&gt;NOTE: Introduced in Onix3
	 */
	With_fastening_strap("B513"), //

	/**
	 * With one or more pages perforated and intended to be torn out for use &lt;p&gt;NOTE: Introduced in Onix3
	 */
	With_perforated_pages("B514"), //

	/**
	 * A book in which half the content is printed upside-down, to be read the other way round. Also known as a
	 * &#8216;flip-book&#8217;, &#8216;back-to-back&#8217;, (fr.) &#8216;t&#234;te-b&#234;che&#8217; (usually an omnibus
	 * of two works)
	 */
	Turn_around_book("B601"), //

	/**
	 * Manga with pages and panels in the sequence of the original Japanese, but with Western text
	 */
	Unflipped_manga_format("B602"), //

	/**
	 * Text shows syllable breaks
	 */
	Syllabification("B610"), //

	/**
	 * Single letters only. Was formerly identified as UK Braille Grade 1
	 */
	UK_Uncontracted_Braille("B701"), //

	/**
	 * With some letter combinations. Was formerly identified as UK Braille Grade 2
	 */
	UK_Contracted_Braille("B702"), //

	/**
	 * DEPRECATED- use B704/B705 as appropriate instead
	 */
	US_Braille("B703"), //

	US_Uncontracted_Braille("B704"), //

	US_Contracted_Braille("B705"), //

	Unified_English_Braille("B706"), //

	/**
	 * Moon embossed alphabet, used by some print-impaired readers who have difficulties with Braille
	 */
	Moon("B707"), //

	/**
	 * Includes RealVideo packaged within a .rm RealMedia container
	 */
	Real_Video_format("D101"), //

	Quicktime_format("D102"), //

	AVI_format("D103"), //

	Windows_Media_Video_format("D104"), //

	MPEG_4("D105"), //

	/**
	 * Use with an applicable Product Form code D*; note that more detail of operating system requirements can be given
	 * in a Product Form Feature composite
	 */
	MS_DOS("D201"), //

	/**
	 * Use with an applicable Product Form code D*; see note on D201
	 */
	Windows("D202"), //

	/**
	 * Use with an applicable Product Form code D*; see note on D201
	 */
	Macintosh("D203"), //

	/**
	 * Use with an applicable Product Form code D*; see note on D201
	 */
	UNIX_LINUX("D204"), //

	/**
	 * Use with an applicable Product Form code D*; see note on D201
	 */
	Other_operating_system_s("D205"), //

	/**
	 * Use with an applicable Product Form code D*; see note on D201
	 */
	Palm_OS("D206"), //

	/**
	 * Use with an applicable Product Form code D*; see note on D201
	 */
	Windows_Mobile("D207"), //

	/**
	 * Use with Product Form code DE or DB as applicable
	 */
	Microsoft_XBox("D301"), //

	/**
	 * Use with Product Form code DE or DB as applicable
	 */
	Nintendo_Gameboy_Color("D302"), //

	/**
	 * Use with Product Form code DE or DB as applicable
	 */
	Nintendo_Gameboy_Advanced("D303"), //

	/**
	 * Use with Product Form code DE or DB as applicable
	 */
	Nintendo_Gameboy("D304"), //

	/**
	 * Use with Product Form code DE or DB as applicable
	 */
	Nintendo_Gamecube("D305"), //

	/**
	 * Use with Product Form code DE or DB as applicable
	 */
	Nintendo_64("D306"), //

	/**
	 * Use with Product Form code DE or DB as applicable
	 */
	Sega_Dreamcast("D307"), //

	/**
	 * Use with Product Form code DE or DB as applicable
	 */
	Sega_Genesis_Megadrive("D308"), //

	/**
	 * Use with Product Form code DE or DB as applicable
	 */
	Sega_Saturn("D309"), //

	/**
	 * Use with Product Form code DE or DB as applicable
	 */
	Sony_PlayStation_1("D310"), //

	/**
	 * Use with Product Form code DE or DB as applicable
	 */
	Sony_PlayStation_2("D311"), //

	Nintendo_Dual_Screen("D312"), //

	Sony_PlayStation_3("D313"), //

	Xbox_360("D314"), //

	Nintendo_Wii("D315"), //

	Sony_PlayStation_Portable_PSP("D316"), //

	/**
	 * Use where a particular e-publication type (specified in &lt;EpubType&gt;) has both reflowable and fixed-format
	 * variants
	 */
	Reflowable("E200"), //

	/**
	 * Use where a particular e-publication type (specified in &lt;EpubType&gt;) has both reflowable and fixed-format
	 * variants
	 */
	Fixed_format("E201"), //

	/**
	 * All e-publication resources are included within the e-publication package
	 */
	Readable_offline("E202"), //

	/**
	 * E-publication requires a network connection to access some resources (eg an enhanced e-book where video clips are
	 * not stored within the e-publication &#8216;package&#8217; itself, but are delivered via an internet connection)
	 */
	Requires_network_connection("E203"), //

	/**
	 * Resources (eg images) present in other editions have been removed from this product, eg due to rights issues
	 */
	Content_removed("E204"), //

	/**
	 * Use for fixed-format e-books optimised for landscape display. Also include an indication of the optimal screen
	 * aspect ratio
	 */
	Landscape("E210"), //

	/**
	 * Use for fixed-format e-books optimised for portrait display. Also include an indication of the optimal screen
	 * aspect ratio
	 */
	Portrait("E211"), //

	/**
	 * Use for fixed-format e-books optimised for displays with a 5:4 aspect ratio (eg 1280x1024 pixels etc, assuming
	 * square pixels). Note that aspect ratio codes are NOT specific to actual screen dimensions or pixel counts, but to
	 * the ratios between two dimensions or two pixel counts
	 */
	_5_4("E221"), //

	/**
	 * Use for fixed-format e-books optimised for displays with a 4:3 aspect ratio (eg 800x600, 1024x768, 2048x1536
	 * pixels etc)
	 */
	_4_3("E222"), //

	/**
	 * Use for fixed-format e-books optimised for displays with a 3:2 aspect ratio (eg 960x640, 3072x2048 pixels etc)
	 */
	_3_2("E223"), //

	/**
	 * Use for fixed-format e-books optimised for displays with a 16:10 aspect ratio (eg 1440x900, 2560x1600 pixels etc)
	 */
	_16_10("E224"), //

	/**
	 * Use for fixed-format e-books optimised for displays with a 16:9 aspect ratio (eg 1024x576, 1920x1080, 2048x1152
	 * pixels etc)
	 */
	_16_9("E225"), //

	/**
	 * Whole product laminated (eg laminated map, fold-out chart, wallchart, etc): use B415 for book with laminated
	 * cover
	 */
	Laminated("L101"), //

	/**
	 * Use with Product Form code PC
	 */
	Desk_calendar("P101"), //

	/**
	 * Use with Product Form code PC
	 */
	Mini_calendar("P102"), //

	/**
	 * Use with Product Form code PC
	 */
	Engagement_calendar("P103"), //

	/**
	 * Use with Product Form code PC
	 */
	Day_by_day_calendar("P104"), //

	/**
	 * Use with Product Form code PC
	 */
	Poster_calendar("P105"), //

	/**
	 * Use with Product Form code PC
	 */
	Wall_calendar("P106"), //

	/**
	 * Use with Product Form code PC
	 */
	Perpetual_calendar("P107"), //

	/**
	 * Use with Product Form code PC
	 */
	Advent_calendar("P108"), //

	/**
	 * Use with Product Form code PC
	 */
	Bookmark_calendar("P109"), //

	/**
	 * Use with Product Form code PC
	 */
	Student_calendar("P110"), //

	/**
	 * Use with Product Form code PC
	 */
	Project_calendar("P111"), //

	/**
	 * Use with Product Form code PC
	 */
	Almanac_calendar("P112"), //

	/**
	 * A calendar that is not one of the types specified elsewhere: use with Product Form code PC
	 */
	Other_calendar("P113"), //

	/**
	 * A product that is associated with or ancillary to a calendar or organiser, eg a deskstand for a calendar, or an
	 * insert for an organiser: use with Product Form code PC or PS
	 */
	Other_calendar_or_organiser_product("P114"), //

	/**
	 * Kamishibai / Cantastoria cards &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Picture_story_cards("P120"), //

	/**
	 * Stationery item in hardback book format
	 */
	Hardback_stationery("P201"), //

	/**
	 * Stationery item in paperback/softback book format
	 */
	Paperback_softback_stationery("P202"), //

	/**
	 * Stationery item in spiral-bound book format
	 */
	Spiral_bound_stationery("P203"), //

	/**
	 * Stationery item in leather-bound book format, or other fine binding
	 */
	Leather_fine_binding_stationery("P204"), //

	/**
	 * For map, poster, wallchart etc &lt;p&gt;NOTE: Introduced in Onix3
	 */
	With_hanging_strips("P301"), //

	/**
	 * TV standard for video or DVD
	 */
	PAL("V201"), //

	/**
	 * TV standard for video or DVD
	 */
	NTSC("V202"), //

	/**
	 * TV standard for video or DVD
	 */
	SECAM("V203"), //

	/**
	 * Licensed for use in domestic contexts only &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Home_use("V220"), //

	/**
	 * Licensed for use in education &lt;p&gt;NOTE: Introduced in Onix3
	 */
	Classroom_use("V221");

	public final String value;

	private ProductFormDetails(String value)
	{
		this.value = value;
	}

	private static Map<String, ProductFormDetails> map;

	private static Map<String, ProductFormDetails> map()
	{
		if (map == null)
		{
			map = new HashMap<>();
			for (ProductFormDetails e : values())
				map.put(e.value, e);
		}
		return map;
	}

	public static ProductFormDetails byValue(String value)
	{
		if (value == null || value.isEmpty())
			return null;
		return map().get(value);
	}
}
