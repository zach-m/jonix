package com.tectonica.jonix;

import java.util.LinkedList;

/**
 * Abstract base class representing an ONIX composite by implementing the {@link JonixConsumer} interface associated with this composite. An
 * ONIX composite is not comprised of a single object (as opposed to {@link JonixElement}), but of a list of objects (of the same type). For
 * example, an ONIX product may have several {@code ProductIdentifier}s (ISBN, URN, etc).
 * 
 * @author Zach Melamed
 * 
 * @param <T>
 *            The type of objects that this composite contains (in a List&lt;T&gt;). This type is typically implemented as an inner static class.
 */
public abstract class JonixComposite<T> extends LinkedList<T> implements JonixConsumer
{
	private static final long serialVersionUID = -2190267027648370747L;

	@Override
	public void printTo(StringBuilder sb)
	{
		for (T item : this)
			sb.append(item.toString()).append("\n");
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		printTo(sb);
		return sb.toString();
	}
}
