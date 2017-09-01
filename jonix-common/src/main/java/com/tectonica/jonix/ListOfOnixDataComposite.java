package com.tectonica.jonix;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.tectonica.jonix.OnixComposite.OnixDataComposite;

public class ListOfOnixDataComposite<C extends OnixDataComposite<S>, S extends JonixStruct> extends ArrayList<C>
{
	private static final long serialVersionUID = 1L;

	private List<S> cachedStructs = null;

	/**
	 * returns a list of the items inside this list, transformed into Jonix structs
	 * 
	 * @return a non-null, possibly empty, list of the structs
	 */
	public List<S> asStructs()
	{
		if (cachedStructs == null)
			return cachedStructs = structsInto(new ArrayList<>(this.size()));
		return cachedStructs;
	}

	public <L extends Collection<S>> L structsInto(L collection)
	{
		forEach(item -> collection.add(item.asStruct()));
		return collection;
	}

	public Optional<C> first()
	{
		return (size() == 0) ? Optional.empty() : Optional.of(get(0));
	}

	public Optional<S> firstAsStruct()
	{
		return first().map(i -> i.asStruct());
	}

	private static ListOfOnixDataComposite<OnixDataComposite<JonixStruct>, JonixStruct> EMPTY = new ListOfOnixDataComposite<>();

	@SuppressWarnings("unchecked")
	public static <C extends OnixDataComposite<S>, S extends JonixStruct> ListOfOnixDataComposite<C, S> empty()
	{
		return (ListOfOnixDataComposite<C, S>) EMPTY;
	}
}