package com.tectonica.jonix.composites;

import com.tectonica.jonix.codelists.SubjectSchemeIdentifiers;

@SuppressWarnings("serial")
public class Subjects extends JonixComposite<Subjects.Subject>
{
	public Subjects()
	{
		super(Subject.class);
	}

	public static class Subject
	{
		public SubjectSchemeIdentifiers subjectSchemeIdentifier;
		public String subjectCode;
		public String subjectHeadingText;

		@Override
		public String toString()
		{
			String subjectSchemeIdentifierStr = (subjectSchemeIdentifier == null) ? null : subjectSchemeIdentifier.name();
			return String.format(getClass().getSimpleName() + " [%s]: %s | %s", subjectSchemeIdentifierStr, subjectCode, subjectHeadingText);
		}
	}
}