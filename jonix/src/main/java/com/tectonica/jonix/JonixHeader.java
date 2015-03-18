package com.tectonica.jonix;

import com.tectonica.jonix.mappers.IHeaderMapper;

/**
 * Container for an ONIX's <code>HEADER</code> tag, consisting of only the fields considered important by Jonix. This object is being populated by a
 * package-dependent implementation of {@link IHeaderMapper}. Unlike {@link JonixProduct}, the class' members are all Elements (no Composites at this stage),
 * and are represented by Java primitives. However, similarly to {@link JonixProduct}, here, too, getters and setters are not used, and members are accessible
 * directly.
 * 
 * @author Zach Melamed
 * 
 */
public class JonixHeader
{
	// elements
	public String fromCompany;
	public String fromPerson;
	public String fromEmail;
	public String toCompany;
	public String sentDate;

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		appendElements(sb);
		return sb.toString();
	}

	private void appendElements(StringBuilder sb)
	{
		if (fromCompany != null)
			sb.append("FromCompany: ").append(fromCompany).append("\n");
		if (fromPerson != null)
			sb.append("FromPerson: ").append(fromPerson).append("\n");
		if (fromEmail != null)
			sb.append("FromEmail: ").append(fromEmail).append("\n");
		if (toCompany != null)
			sb.append("ToCompany: ").append(toCompany).append("\n");
		if (sentDate != null)
			sb.append("SentDate: ").append(sentDate).append("\n");
	}
}
