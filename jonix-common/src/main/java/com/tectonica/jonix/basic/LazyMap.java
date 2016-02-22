package com.tectonica.jonix.basic;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("serial")
public abstract class LazyMap<K, V> implements Map<K, V>, Serializable
{
	private Map<K, V> map;

	abstract protected Map<K, V> initialize();

	private void ensure()
	{
		if (map == null)
			map = initialize();
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////

	private void writeObject(ObjectOutputStream out) throws IOException
	{
		ensure();
		out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
		in.defaultReadObject();
	}

	@Override
	public String toString()
	{
		ensure();
		return map.toString();
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public int size()
	{
		ensure();
		return map.size();
	}

	@Override
	public boolean isEmpty()
	{
		ensure();
		return map.isEmpty();
	}

	@Override
	public boolean containsKey(Object key)
	{
		ensure();
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value)
	{
		ensure();
		return map.containsValue(value);
	}

	@Override
	public V get(Object key)
	{
		ensure();
		return map.get(key);
	}

	@Override
	public V put(K key, V value)
	{
		ensure();
		return map.put(key, value);
	}

	@Override
	public V remove(Object key)
	{
		ensure();
		return map.remove(key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m)
	{
		ensure();
		map.putAll(m);
	}

	@Override
	public void clear()
	{
		ensure();
		map.clear();
	}

	@Override
	public Set<K> keySet()
	{
		ensure();
		return map.keySet();
	}

	@Override
	public Collection<V> values()
	{
		ensure();
		return map.values();
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet()
	{
		ensure();
		return map.entrySet();
	}
}
