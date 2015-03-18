package com.tectonica.jonix.codelists;

/**
 * List 17
 * 
 * @author Zach Melamed
 *
 */
public enum ContributorRoles
{
	By("A01"),

	Edited_by("B01"),

	With("A02"),

	Screenplay_by("A03"),

	Libretto_by("A04"),

	Lyrics_by("A05"),

	By_composer("A06"),

	By_artist("A07"),

	By_photographer("A08"),

	Created_by("A09"),

	From_an_idea_by("A10"),

	Designed_by("A11"),

	Illustrated_by("A12"),

	Photographs_by("A13"),

	Text_by("A14"),

	Preface_by("A15"),

	Prologue_by("A16"),

	Summary_by("A17"),

	Supplement_by("A18"),

	Afterword_by("A19"),

	Notes_by("A20"),

	Commentaries_by("A21"),

	Epilogue_by("A22"),

	Foreword_by("A23"),

	Introduction_by("A24"),

	Footnotes_by("A25"),

	Memoir_by("A26"),

	Experiments_by("A27"),

	Introduction_and_notes_by("A29"),

	Software_written_by("A30"),

	Book_and_lyrics_by("A31"),

	Contributions_by("A32"),

	Appendix_by("A33"),

	Index_by("A34"),

	Drawings_by("A35"),

	Cover_design_or_artwork_by("A36"),

	Preliminary_work_by("A37"),

	Original_author("A38"),

	Maps_by("A39"),

	Inked_or_colored_by("A40"),

	Pop_ups_by("A41"),

	Continued_by("A42"),

	Interviewer("A43"),

	Interviewee("A44"),

	Other_primary_creator("A99"),

	Revised_by("B02"),

	Retold_by("B03"),

	Abridged_by("B04"),

	Adapted_by("B05"),

	Translated_by("B06"),

	As_told_by("B07"),

	Translated_with_commentary_by("B08"),

	Series_edited_by("B09"),

	Edited_and_translated_by("B10"),

	Editor_in_chief("B11"),

	Guest_editor("B12"),

	Volume_editor("B13"),

	Editorial_board_member("B14"),

	Editorial_coordination_by("B15"),

	Managing_editor("B16"),

	Founded_by("B17"),

	Prepared_for_publication_by("B18"),

	Associate_editor("B19"),

	Consultant_editor("B20"),

	General_editor("B21"),

	Dramatized_by("B22"),

	General_rapporteur("B23"),

	Literary_editor("B24"),

	Arranged_by_music("B25"),

	Technical_editor("B26"),

	Other_adaptation_by("B99"),

	Compiled_by("C01"),

	Selected_by("C02"),

	Other_compilation_by("C99"),

	Producer("D01"),

	Director("D02"),

	Conductor("D03"),

	Other_direction_by("D99"),

	Actor("E01"),

	Dancer("E02"),

	Narrator("E03"),

	Commentator("E04"),

	Vocal_soloist("E05"),

	Instrumental_soloist("E06"),

	Read_by("E07"),

	Performed_by_orchestra_band_ensemble("E08"),

	Speaker("E09"),

	Performed_by("E99"),

	Filmed_or_photographed_by("F01"),

	Other_recording_by("F99"),

	Assisted_by("Z01"),

	Other("Z99");

	public final String code;

	private ContributorRoles(String code)
	{
		this.code = code;
	}

	private static ContributorRoles[] values = ContributorRoles.values();

	public static ContributorRoles fromCode(String code)
	{
		for (ContributorRoles item : values)
			if (item.code.equals(code))
				return item;
		return null;
	}
}