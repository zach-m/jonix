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

package com.tectonica.jonix.common.codelist;

import com.tectonica.jonix.common.OnixCodelist;

import java.util.Map;
import java.util.HashMap;

/*
 * NOTE: THIS IS AN AUTO-GENERATED FILE, DO NOT EDIT MANUALLY
 */

/**
 * marker interface to assist in IDE navigation to code-list 17 (Contributor role code)
 */
interface CodeList17 {
}

/**
 * <code>Enum</code> that corresponds to ONIX <b>Codelist 17</b>
 * <p>
 * Description: Contributor role code
 *
 * @see <a href="https://www.editeur.org/14/Code-Lists/">About ONIX Codelists</a>
 * @see <a href=
 *      "https://www.editeur.org/files/ONIX%20for%20books%20-%20code%20lists/ONIX_BookProduct_Codelists_Issue_45.html#codelist17">ONIX
 *      Codelist 17 in Reference Guide</a>
 */
public enum ContributorRoles implements OnixCodelist, CodeList17 {
    /**
     * Author of a textual work
     */
    By_author("A01", "By (author)"),

    /**
     * With or as told to: 'ghost' or secondary author of a literary work (for clarity, should not be used for true
     * 'ghost' authors who are not credited on the book and whose existence is secret)
     */
    With("A02", "With"),

    /**
     * Writer of screenplay or script (film or video)
     */
    Screenplay_by("A03", "Screenplay by"),

    /**
     * Writer of libretto (opera): see also A31
     */
    Libretto_by("A04", "Libretto by"),

    /**
     * Author of lyrics (song): see also A31
     */
    Lyrics_by("A05", "Lyrics by"),

    /**
     * Composer of music
     */
    By_composer("A06", "By (composer)"),

    /**
     * Visual artist when named as the primary creator of, eg, a book of reproductions of artworks
     */
    By_artist("A07", "By (artist)"),

    /**
     * Photographer when named as the primary creator of, eg, a book of photographs
     */
    By_photographer("A08", "By (photographer)"),

    Created_by("A09", "Created by"),

    From_an_idea_by("A10", "From an idea by"),

    Designed_by("A11", "Designed by"),

    /**
     * Artist when named as the creator of artwork which illustrates a text, or the originator (sometimes 'penciller'
     * for collaborative art) of the artwork of a graphic novel or comic book
     */
    Illustrated_by("A12", "Illustrated by"),

    /**
     * Photographer when named as the creator of photographs which illustrate a text
     */
    Photographs_by("A13", "Photographs by"),

    /**
     * Author of text which accompanies art reproductions or photographs, or which is part of a graphic novel or comic
     * book
     */
    Text_by("A14", "Text by"),

    /**
     * Author of preface
     */
    Preface_by("A15", "Preface by"),

    /**
     * Author of prologue
     */
    Prologue_by("A16", "Prologue by"),

    /**
     * Author of summary
     */
    Summary_by("A17", "Summary by"),

    /**
     * Author of supplement
     */
    Supplement_by("A18", "Supplement by"),

    /**
     * Author of afterword
     */
    Afterword_by("A19", "Afterword by"),

    /**
     * Author of notes or annotations: see also A29
     */
    Notes_by("A20", "Notes by"),

    /**
     * Author of commentaries on the main text
     */
    Commentaries_by("A21", "Commentaries by"),

    /**
     * Author of epilogue
     */
    Epilogue_by("A22", "Epilogue by"),

    /**
     * Author of foreword
     */
    Foreword_by("A23", "Foreword by"),

    /**
     * Author of introduction: see also A29
     */
    Introduction_by("A24", "Introduction by"),

    /**
     * Author/compiler of footnotes
     */
    Footnotes_by("A25", "Footnotes by"),

    /**
     * Author of memoir accompanying main text
     */
    Memoir_by("A26", "Memoir by"),

    /**
     * Person who carried out experiments reported in the text
     */
    Experiments_by("A27", "Experiments by"),

    /**
     * Author of introduction and notes: see also A20 and A24
     */
    Introduction_and_notes_by("A29", "Introduction and notes by"),

    /**
     * Writer of computer programs ancillary to the text
     */
    Software_written_by("A30", "Software written by"),

    /**
     * Author of the textual content of a musical drama: see also A04 and A05
     */
    Book_and_lyrics_by("A31", "Book and lyrics by"),

    /**
     * Author of additional contributions to the text
     */
    Contributions_by("A32", "Contributions by"),

    /**
     * Author of appendix
     */
    Appendix_by("A33", "Appendix by"),

    /**
     * Compiler of index
     */
    Index_by("A34", "Index by"),

    Drawings_by("A35", "Drawings by"),

    /**
     * Use also for the cover artist of a graphic novel or comic book if named separately
     */
    Cover_design_or_artwork_by("A36", "Cover design or artwork by"),

    /**
     * Responsible for preliminary work on which the work is based
     */
    Preliminary_work_by("A37", "Preliminary work by"),

    /**
     * Author of the first edition (usually of a standard work) who is not an author of the current edition
     */
    Original_author("A38", "Original author"),

    /**
     * Maps drawn or otherwise contributed by
     */
    Maps_by("A39", "Maps by"),

    /**
     * Use for secondary creators when separate persons are named as having respectively drawn and
     * inked/colored/finished artwork, eg for a graphic novel or comic book. Use with A12 for 'drawn by'. Use A40 for
     * 'finished by', but prefer more specific codes A46 to A48 instead of A40 unless the more specific secondary roles
     * are inappropriate, unclear or unavailable
     */
    Inked_or_colored_by("A40", "Inked or colored by"),

    /**
     * Designer or paper engineer of die-cuts, press-outs or of pop-ups in a pop-up book, who may be different from the
     * illustrator
     */
    Paper_engineering_by("A41", "Paper engineering by"),

    /**
     * Use where a standard work is being continued by somebody other than the original author
     */
    Continued_by("A42", "Continued by"),

    Interviewer("A43", "Interviewer"),

    Interviewee("A44", "Interviewee"),

    /**
     * Writer of dialogue, captions in a comic book (following an outline by the primary writer)
     */
    Comic_script_by("A45", "Comic script by"),

    /**
     * Renders final comic book line art based on work of the illustrator or penciller. Preferred to code A40
     */
    Inker("A46", "Inker"),

    /**
     * Provides comic book color art and effects. Preferred to code A40
     */
    Colorist("A47", "Colorist"),

    /**
     * Creates comic book text balloons and other text elements (where this is a distinct role from script writer and/or
     * illustrator)
     */
    Letterer("A48", "Letterer"),

    /**
     * Person or organization responsible for performing research on which the work is based. For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Research_by("A51", "Research by"),

    /**
     * Other type of primary creator not specified above
     */
    Other_primary_creator("A99", "Other primary creator"),

    Edited_by("B01", "Edited by"),

    Revised_by("B02", "Revised by"),

    Retold_by("B03", "Retold by"),

    Abridged_by("B04", "Abridged by"),

    Adapted_by("B05", "Adapted by"),

    Translated_by("B06", "Translated by"),

    As_told_by("B07", "As told by"),

    /**
     * This code applies where a translator has provided a commentary on issues relating to the translation. If the
     * translator has also provided a commentary on the work itself, codes B06 and A21 should be used
     */
    Translated_with_commentary_by("B08", "Translated with commentary by"),

    /**
     * Name of a series editor when the product belongs to a series
     */
    Series_edited_by("B09", "Series edited by"),

    Edited_and_translated_by("B10", "Edited and translated by"),

    Editor_in_chief("B11", "Editor-in-chief"),

    Guest_editor("B12", "Guest editor"),

    Volume_editor("B13", "Volume editor"),

    Editorial_board_member("B14", "Editorial board member"),

    Editorial_coordination_by("B15", "Editorial coordination by"),

    Managing_editor("B16", "Managing editor"),

    /**
     * Usually the founder editor of a serial publication: Begruendet von
     */
    Founded_by("B17", "Founded by"),

    Prepared_for_publication_by("B18", "Prepared for publication by"),

    Associate_editor("B19", "Associate editor"),

    /**
     * Use also for 'advisory editor', 'series advisor', 'editorial consultant' etc
     */
    Consultant_editor("B20", "Consultant editor"),

    General_editor("B21", "General editor"),

    Dramatized_by("B22", "Dramatized by"),

    /**
     * In Europe, an expert editor who takes responsibility for the legal content of a collaborative law volume
     */
    General_rapporteur("B23", "General rapporteur"),

    /**
     * An editor who is responsible for establishing the text used in an edition of a literary work, where this is
     * recognised as a distinctive role (in Spain, 'editor literario')
     */
    Literary_editor("B24", "Literary editor"),

    Arranged_by_music("B25", "Arranged by (music)"),

    /**
     * Responsible for the technical accuracy and language, may also be involved in coordinating and preparing technical
     * material for publication
     */
    Technical_editor("B26", "Technical editor"),

    Thesis_advisor_or_supervisor("B27", "Thesis advisor or supervisor"),

    Thesis_examiner("B28", "Thesis examiner"),

    /**
     * Responsible overall for the scientific content of the publication
     */
    Scientific_editor("B29", "Scientific editor"),

    /**
     * For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Historical_advisor("B30", "Historical advisor"),

    /**
     * Editor of the first edition (usually of a standard work) who is not an editor of the current edition. For use in
     * ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Original_editor("B31", "Original editor"),

    /**
     * Other type of adaptation or editing not specified above
     */
    Other_adaptation_by("B99", "Other adaptation by"),

    /**
     * For puzzles, directories, statistics, etc
     */
    Compiled_by("C01", "Compiled by"),

    /**
     * For textual material (eg for an anthology)
     */
    Selected_by("C02", "Selected by"),

    /**
     * Eg for a collection of photographs etc
     */
    Non_text_material_selected_by("C03", "Non-text material selected by"),

    /**
     * Eg for an exhibition
     */
    Curated_by("C04", "Curated by"),

    /**
     * Other type of compilation not specified above
     */
    Other_compilation_by("C99", "Other compilation by"),

    Producer("D01", "Producer"),

    Director("D02", "Director"),

    /**
     * Conductor of a musical performance
     */
    Conductor("D03", "Conductor"),

    /**
     * Of a dance performance. For use in ONIX 3.0 only
     * <p>
     * Jonix-Comment: Introduced in Onix3
     */
    Choreographer("D04", "Choreographer"),

    /**
     * Other type of direction not specified above
     */
    Other_direction_by("D99", "Other direction by"),

    /**
     * Performer in a dramatized production (including a voice actor in an audio production)
     */
    Actor("E01", "Actor"),

    Dancer("E02", "Dancer"),

    /**
     * Where the narrator is a character in a dramatized production (including a voice actor in an audio production).
     * For the 'narrator' of a non-dramatized audiobook, see code E07
     */
    Narrator("E03", "Narrator"),

    Commentator("E04", "Commentator"),

    /**
     * Singer etc
     */
    Vocal_soloist("E05", "Vocal soloist"),

    Instrumental_soloist("E06", "Instrumental soloist"),

    /**
     * Reader of recorded text, as in an audiobook
     */
    Read_by("E07", "Read by"),

    /**
     * Name of a musical group in a performing role
     */
    Performed_by_orchestra_band_ensemble("E08", "Performed by (orchestra, band, ensemble)"),

    /**
     * Of a speech, lecture etc
     */
    Speaker("E09", "Speaker"),

    /**
     * Introduces and links other contributors and material, eg within a documentary
     */
    Presenter("E10", "Presenter"),

    /**
     * Other type of performer not specified above: use for a recorded performance which does not fit a category above,
     * eg a performance by a stand-up comedian
     */
    Performed_by("E99", "Performed by"),

    /**
     * Cinematographer, etc
     */
    Filmed_photographed_by("F01", "Filmed/photographed by"),

    Editor_film_or_video("F02", "Editor (film or video)"),

    /**
     * Other type of recording not specified above
     */
    Other_recording_by("F99", "Other recording by"),

    /**
     * May be associated with any contributor role, and placement should therefore be controlled by contributor sequence
     * numbering
     */
    Assisted_by("Z01", "Assisted by"),

    Honored_dedicated_to("Z02", "Honored/dedicated to"),

    /**
     * For use ONLY with 'et al' or 'Various' within &lt;UnnamedPersons&gt;, where the roles of the multiple
     * contributors vary
     */
    _Various_roles("Z98", "(Various roles)"),

    /**
     * Other creative responsibility not falling within A to F above
     */
    Other("Z99", "Other");

    public final String code;
    public final String description;

    ContributorRoles(String code, String description) {
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

    private static volatile Map<String, ContributorRoles> map;

    private static Map<String, ContributorRoles> map() {
        Map<String, ContributorRoles> result = map;
        if (result == null) {
            synchronized (ContributorRoles.class) {
                result = map;
                if (result == null) {
                    result = new HashMap<>();
                    for (ContributorRoles e : values()) {
                        result.put(e.code, e);
                    }
                    map = result;
                }
            }
        }
        return result;
    }

    public static ContributorRoles byCode(String code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        return map().get(code);
    }
}
