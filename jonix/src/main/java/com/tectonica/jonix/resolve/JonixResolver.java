package com.tectonica.jonix.resolve;

import java.util.HashMap;
import java.util.Map;

import org.editeur.onix.v21.references.ProductIdentifier;

/**
 * A base-class for dictionary, translating between an {@link ONIX} type and its corresponding ONIX class, and vice verse. The ONIX class in this instance is a
 * JAXB-generated class representing an ONIX tag, as defined in EDItEUR's XML schema. These ONIX classes are stored under the package
 * <code>org.editeur.onix</code>.
 * <p>
 * This class itself has no translation data. Only its subclasses perform meaningful translations.
 * 
 * @author Zach Melamed
 * 
 */
public class JonixResolver
{
	/**
	 * a simple implementation of bidirectional {@link Map}. No need to drag in Guava's <code>BiMap</code> just for this one class.
	 */
	protected static class BiMap
	{
		private Map<Class<?>, ONIX> classToOnix = new HashMap<Class<?>, ONIX>();
		private Map<ONIX, Class<?>> onixToClass = new HashMap<ONIX, Class<?>>();

		public void put(Class<?> cls, ONIX onix)
		{
			classToOnix.put(cls, onix);
			onixToClass.put(onix, cls);
		}

		public ONIX get(Class<?> cls)
		{
			return classToOnix.get(cls);
		}

		public Class<?> get(ONIX onix)
		{
			return onixToClass.get(onix);
		}
	}

	protected BiMap map = new BiMap();

	public ONIX onixTypeOf(Object o)
	{
		return map.get(o.getClass());
	}

	public Class<?> classOf(ONIX o)
	{
		return map.get(o);
	}

	/**
	 * Uses the class name of an ONIX object in an attempt to guess the property name it would have in its parent object (only relevant when it is parsed by
	 * JAXB as a property rather than a child tag).
	 * <p>
	 * For example, a <code>ProductIdentifier</code> tag looks as follows in ONIX:
	 * 
	 * <pre>
	 * &lt;ProductIdentifier&gt;
	 * 	&lt;ProductIDType&gt;02&lt;/ProductIDType&gt;
	 * 	&lt;IDValue&gt;0816016356&lt;/IDValue&gt;
	 * &lt;/ProductIdentifier&gt;
	 * </pre>
	 * 
	 * This record is turned into a {@link ProductIdentifier} object by JAXB, that has several properties, including <code>productIDType</code> and
	 * <code>idValue</code>, both of which are also JAXB-generated ONIX classes, named <code>ProductIDType</code> and <code>IDValue</code>, respectively. The
	 * easiest way to address these two property without hard-coding their names, is to derive it from their class name, which is not entirely trivial, as done
	 * by this method.
	 */
	public String onixPropOf(ONIX o)
	{
		String name = classOf(o).getSimpleName();

		// find the first lower-case character
		int i = 0;
		for (; i < name.length(); i++)
			if (Character.isLowerCase(name.charAt(i)))
				break;

		// "Text" --> "text"
		if (i == 0)
			return name;

		// "TextFormat" --> "textFormat"
		if (i == 1)
			return name.substring(0, 1).toLowerCase() + name.substring(1);

		// "IDTypeName" --> "idTypeName"
		return name.substring(0, i - 1).toLowerCase() + name.substring(i - 1);
	}
}
