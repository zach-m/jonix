package com.tectonica.jonix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tectonica.jonix.OnixComposite.OnixDataCompositeWithKey;

public class ListOfOnixDataCompositeWithKey<C extends OnixDataCompositeWithKey<S, K>, S extends JonixKeyedStruct<K>, K extends Enum<K>>
		extends ListOfOnixDataComposite<C, S>
{
	private static final long serialVersionUID = 1L;

	public C findOrNull(K structKey)
	{
		for (C item : this)
		{
			if (item.structKey() == structKey)
				return item;
		}
		return null;
	}

	public List<C> find(Set<K> structKeys)
	{
		List<C> matches = new ArrayList<>();
		forEach(item -> {
			if (structKeys == null || structKeys.contains(item.structKey()))
				matches.add(item);
		});
		return matches;
	}

	@SuppressWarnings("unchecked")
	public List<C> find(K... structKeys)
	{
		return find(new HashSet<>(Arrays.asList(structKeys)));
	}

	public S findAsStructOrNull(K structKey)
	{
		for (C item : this)
		{
			if (item.structKey() == structKey)
				return item.asStruct();
		}
		return null;
	}

	public List<S> findAsStructs(Set<K> structKeys)
	{
		List<S> matches = new ArrayList<>();
		forEach(item -> {
			if (structKeys == null || structKeys.contains(item.structKey()))
				matches.add(item.asStruct());
		});
		return matches;
	}

	private static ListOfOnixDataCompositeWithKey<?, ?, ?> EMPTY = new ListOfOnixDataCompositeWithKey<>();

	@SuppressWarnings("unchecked")
	public static <C extends OnixDataCompositeWithKey<S, K>, S extends JonixKeyedStruct<K>, K extends Enum<K>> ListOfOnixDataCompositeWithKey<C, S, K> emptyKeyed()
	{
		return (ListOfOnixDataCompositeWithKey<C, S, K>) EMPTY;
	}
}