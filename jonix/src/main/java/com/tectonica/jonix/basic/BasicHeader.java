package com.tectonica.jonix.basic;

import com.tectonica.jonix.JonixTag;
import com.tectonica.jonix.element.GenericStringElement;
import com.tectonica.jonix.resolve.JonixResolver;
import com.tectonica.jonix.resolve.ONIX;

/**
 * Container for an ONIX's <code>HEADER</code> tag, consisting of only the fields considered basic by Jonix. This object is being populated
 * very similarly to {@link BasicProduct}, but unlike the latter, it contains only Elements (no Composites at this stage)
 * <p>
 * Similarly to {@link BasicProduct}, here, too, getters and setters are not used, and members are directly accessible.
 * 
 * @author Zach Melamed
 * 
 */
public class BasicHeader extends JonixTag
{
	// elements
	public final GenericStringElement fromCompany = new GenericStringElement(ONIX.FromCompany);
	public final GenericStringElement fromPerson = new GenericStringElement(ONIX.FromPerson);
	public final GenericStringElement fromEmail = new GenericStringElement(ONIX.FromEmail);
	public final GenericStringElement toCompany = new GenericStringElement(ONIX.ToCompany);
	public final GenericStringElement sentDate = new GenericStringElement(ONIX.SentDate);

	public BasicHeader(JonixResolver resolver)
	{
		super(resolver);
	}
}
