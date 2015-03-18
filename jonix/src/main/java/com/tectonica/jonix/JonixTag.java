package com.tectonica.jonix;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

import com.tectonica.jonix.resolve.JonixResolver;

/**
 * This class extracts and retains the data stored in a raw, top-level ONIX object (i.e. Header or Product). During parsing of the ONIX
 * source, an instance of this class is created for each Header/Product, followed by invocation of {@link #process(Object)} where the
 * extraction of the data from the object actually occurs.
 * <p>
 * In order to support streamlined and as-general-as-possible extraction of data, this class retains a group of {@link JonixConsumer}s, each
 * specializes in "consuming" (i.e. extracting and retaining) a specific component (composite or element) of ONIX record.
 * 
 * @author Zach Melamed
 * 
 */
public class JonixTag
{
	protected JonixResolver resolver;

	public JonixTag(JonixResolver resolver)
	{
		if (resolver == null)
			throw new NullPointerException("product's resolver can't be null");
		this.resolver = resolver;
	}

	/**
	 * Performs the actual processing of the given ONIX top-level object (i.e. Header/Product). It is done by giving a chance to all the
	 * "consumers" registered
	 * in this {@link JonixTag} to peek at the ONIX object and decide whether to use it to populate its internal structure.
	 */
	public void process(Object onixTopLevelObject)
	{
		registerConsumers();
		consumeChildren(onixTopLevelObject, null, null);
	}

	protected List<JonixConsumer> rootConsumers = new LinkedList<JonixConsumer>();

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (JonixConsumer consumer : rootConsumers)
			consumer.printTo(sb);
		return sb.toString();
	}

	/**
	 * should return a short string identifying the tag, typically the title-name in a &lt;PRODUCT&gt; and the sender in a &lt;HEADER&gt;
	 */
	public String getLabel()
	{
		return getClass().getSimpleName();
	}

	/**
	 * Registers all the {@link JonixConsumer}s intended to take part in parsing this {@link JonixTag} (i.e. PRODUCT or HEADER). While this
	 * method may be overridden, its default behavior is pretty general - all the public members that implement {@link JonixConsumer}, in
	 * all the class hierarchy, will be registered.
	 */
	protected void registerConsumers()
	{
		if (rootConsumers.size() == 0) // typically, a given product is not processed twice, but just in case, we skip re-calculation
		{
			Field[] fields = getClass().getFields();
			for (Field field : fields)
			{
				field.setAccessible(true);
				try
				{
					Object member = field.get(this);
					if (member instanceof JonixConsumer)
						rootConsumers.add((JonixConsumer) member);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * This method takes a raw, JAXB-generated ONIX object, and looks for a consumer capable of consuming it (i.e. extracting values out of
	 * it and retaining them). It does so by starting at the top-level tag (Product or Header tags), iterating through its direct child-tags
	 * looking for consumer "interested" in them. Once a top-level child is assigned a consumer, this consumer may also consume this child's
	 * children, grandchildren, etc. This is a recursive process where each invocation of
	 * {@link JonixConsumer#consume(Object, Object, Object, JonixResolver)} may return either a null to terminate the drill-down or another
	 * {@link JonixConsumer} to consume the children of the current parent.
	 * 
	 * @param parent
	 * @param grandParent
	 * @param parentConsumer
	 */
	protected void consumeChildren(Object parent, Object grandParent, JonixConsumer parentConsumer)
	{
		List<Object> children = JonixUtils.getContent(parent);
		if (children != null)
		{
			for (Object child : children)
			{
				JonixConsumer childrenConsumer = null;
				if (parentConsumer == null) // i.e. top-level
				{
					// search for the first root consumer able to process this child object
					for (JonixConsumer candidate : rootConsumers)
					{
						childrenConsumer = candidate.consume(child, parent, grandParent, resolver);
						if (childrenConsumer != null)
							break;
					}
				}
				else
					childrenConsumer = parentConsumer.consume(child, parent, grandParent, resolver);

				if (childrenConsumer != null)
					consumeChildren(child, parent, childrenConsumer);
			}
		}
	}
}
