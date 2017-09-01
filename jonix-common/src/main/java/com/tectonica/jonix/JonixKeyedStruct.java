package com.tectonica.jonix;

public interface JonixKeyedStruct<K extends Enum<K>> extends JonixStruct
{
	K key();
}
