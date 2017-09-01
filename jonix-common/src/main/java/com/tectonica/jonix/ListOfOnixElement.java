package com.tectonica.jonix;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListOfOnixElement<E extends OnixElement<V>, V> extends ArrayList<E>
{
	private static final long serialVersionUID = 1L;

	private List<V> cachedValues = null;

	/**
	 * returns a list of the values within the elements of this list (as opposed to the elements themselves, each of
	 * which also contains attributes, which are usually not interesting)
	 * 
	 * @return a non-null, possibly empty, list of the values
	 */
	public List<V> values()
	{
		if (cachedValues == null)
			return cachedValues = valuesInto(new ArrayList<>());
		return cachedValues;
	}

	public <C extends Collection<V>> C valuesInto(C collection)
	{
		forEach(item -> collection.add(item._value()));
		return collection;
	}

	public V firstValueOrNull()
	{
		if (size() == 0)
			return null;
		return get(0)._value();
	}

	private static ListOfOnixElement<OnixElement<Object>, Object> EMPTY = new ListOfOnixElement<>();

	@SuppressWarnings("unchecked")
	public static <X extends OnixElement<Y>, Y> ListOfOnixElement<X, Y> empty()
	{
		return (ListOfOnixElement<X, Y>) EMPTY;
	}
}