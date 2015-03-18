package com.tectonica.jonix;

import com.tectonica.jonix.resolve.JonixResolver;

/**
 * An interface assisting in processing top-level ONIX record (i.e. Header or Product) by {@link JonixTag}. The main method it uses is
 * {@link #consume(Object, Object, Object, JonixResolver)}. Each {@link JonixConsumer} implementation represents one type of composite or
 * element.
 * 
 * @author Zach Melamed
 * 
 */
public interface JonixConsumer
{
	/**
	 * This method is at the heart of {@link JonixConsumer}. It is called during the parsing process of an ONIX record by
	 * {@link JonixTag#consumeChildren(Object, Object, JonixConsumer)}, where the methodology is explained.
	 * <p>
	 * The method is passed a raw, JAXB-generated ONIX object, and should decide whether to "consume" it or not by peeking at it. Only one
	 * consumer may consume an ONIX object, and it signals to the caller that it wishes to consume it by returning a non-null value. This
	 * value is yet another {@link JonixConsumer} who will be passed the next level down the tree in order to consume the actual data. It
	 * can go down the tree as many levels as neede to consume the entire ONIX object.
	 */
	JonixConsumer consume(Object o, Object parent, Object grandParent, JonixResolver resolver);

	void printTo(StringBuilder sb);
}
