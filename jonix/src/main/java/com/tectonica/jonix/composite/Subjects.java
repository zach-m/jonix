package com.tectonica.jonix.composite;

import java.io.Serializable;

import com.tectonica.jonix.JonixComposite;
import com.tectonica.jonix.JonixConsumer;
import com.tectonica.jonix.JonixUtils;
import com.tectonica.jonix.codelist.SubjectSchemeIds;
import com.tectonica.jonix.resolve.JonixResolver;
import com.tectonica.jonix.resolve.ONIX;

public class Subjects extends JonixComposite<Subjects.Subject>
{
	private static final long serialVersionUID = 8209028777493822147L;

	public static class Subject implements Serializable
	{
		private static final long serialVersionUID = 3191421951274940079L;

		public SubjectSchemeIds subjectSchemeIdentifier;
		public String subjectCode;
		public String subjectHeadingText;

		public Subject()
		{}

		public Subject(SubjectSchemeIds subjectSchemeIdentifier, String subjectCode)
		{
			this.subjectSchemeIdentifier = subjectSchemeIdentifier;
			this.subjectCode = subjectCode;
		}

		@Override
		public String toString()
		{
			String subjectSchemeIdentifierStr = (subjectSchemeIdentifier == null) ? null : subjectSchemeIdentifier.name();
			return String.format(getClass().getSimpleName() + " [%s]: %s | %s", subjectSchemeIdentifierStr, subjectCode, subjectHeadingText);
		}
	}

	private transient Subject activeItem;

	@Override
	public JonixConsumer consume(Object o, Object parent, Object grandParent, JonixResolver resolver)
	{
		ONIX typeOf = resolver.onixTypeOf(o);
		if (typeOf == ONIX.Subject || typeOf == ONIX.MainSubject)
		{
			add(activeItem = new Subject());
			return this;
		}

		ONIX typeOfParent = resolver.onixTypeOf(parent);
		if (typeOfParent == ONIX.Subject || typeOfParent == ONIX.MainSubject)
		{
			switch (typeOf)
			{
				case SubjectSchemeIdentifier:
				case MainSubjectSchemeIdentifier:
					activeItem.subjectSchemeIdentifier = SubjectSchemeIds.fromCode(JonixUtils.getValueAsStr(o));
					break;

				case SubjectCode:
					activeItem.subjectCode = JonixUtils.getValueAsStr(o); //JonixSvc.noBreaks(JonixSvc.getValueFrom(o));
					break;

				case SubjectHeadingText:
					activeItem.subjectHeadingText = JonixUtils.getValueAsStr(o); //JonixSvc.noBreaks(JonixSvc.getValueFrom(o));
					break;

				default:
					break;
			}
		}

		return null;
	}
}