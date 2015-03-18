package com.tectonica.jonix.composites;

@SuppressWarnings("serial")
public class JonixComposite<T> extends JonixBaseComposite<T>
{
	protected T activeItem;
	
	private final Class<T> innerClass;
	
	protected JonixComposite(Class<T> innerClass)
	{
		this.innerClass = innerClass;
	}

	public void startNewItem()
	{
		try
		{
			activeItem = innerClass.newInstance();
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
		add(activeItem);
	}
	
	public T item()
	{
		return activeItem;
	}

//	public Item findItem(ProductIDTypes type)
//	{
//		for (Item item : items)
//			if (item.productIDType == type)
//				return item;
//
//		return null;
//	}
}
