package com.tectonica.jonix;

import com.tectonica.jonix.resolve.JonixResolver;
import com.tectonica.jonix.resolve.ONIX;

/**
 * Abstract base class representing an ONIX element, which, as opposed to {@link JonixComposite}, has only one occurrence within an ONIX
 * Product/Header. Subclasses, representing specific ONIX elements, are required to pass the {@link ONIX} type (an enum) that they
 * represent, and implement {@link #consume(Object)}, where they retain the value.
 * 
 * @author Zach Melamed
 * 
 * @param <T>
 *            The type of object that this implementation contains to retain the value of the element
 */
public abstract class JonixElement<T> implements JonixConsumer
{
	protected T value;

	protected final ONIX onix;

	public JonixElement(ONIX onix)
	{
		this.onix = onix;
	}

	@Override
	public JonixConsumer consume(Object o, Object parent, Object grandParent, JonixResolver resolver)
	{
		if (resolver.onixTypeOf(o) == onix)
		{
			value = consume(o);
			return this; // there's no way to signal to the caller that we want to consume but don't want further invocations. A bit
							// inefficient, but..
		}

		return null;
	}

	protected abstract T consume(Object o);

	public T getValue()
	{
		return value;
	}

	@Override
	public void printTo(StringBuilder sb)
	{
		if (value != null)
			sb.append(onix.name()).append(": ").append(value.toString()).append("\n");
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		printTo(sb);
		return sb.toString();
	}
}
