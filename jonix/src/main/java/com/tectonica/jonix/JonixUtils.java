package com.tectonica.jonix;

import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class JonixUtils
{
	@SuppressWarnings("unchecked")
	public static List<Object> getContent(Object onixObj)
	{
		return (List<Object>) invoke(onixObj, "getContent");
	}

	public static interface OnixObjectHandler
	{
		public boolean handleOnixObject(Object onixObj, Object parentOnixObj, Object grandParentOnixObj, int depth);
	}

	public static void forEach(Object onixRootObj, Object parentOnixObj, boolean recursive, int rootDepth, OnixObjectHandler handler)
	{
		List<Object> list = getContent(onixRootObj);
		if (list != null)
		{
			rootDepth++;
			for (Object obj : list)
			{
				boolean drillDown = handler.handleOnixObject(obj, onixRootObj, parentOnixObj, rootDepth);
				if (recursive && drillDown)
					forEach(obj, onixRootObj, recursive, rootDepth, handler);
			}
		}
	}

	public static void print(Object onixObj, final PrintStream out)
	{
		forEach(onixObj, null, true, 0, new OnixObjectHandler()
		{
			@Override
			public boolean handleOnixObject(Object onixObj, Object parentOnixObj, Object grandParentOnixObj, int depth)
			{
				Object value = invoke(onixObj, "getValue");
				String valueStr = (value != null) ? String.format(" [%s (%s)]", value.toString(), value.getClass().getSimpleName()) : "";
				String spacer = (depth == 0) ? "" : new String(new char[depth]).replace("\0", "  ");
				out.println(spacer + onixObj.getClass().getSimpleName() + valueStr);
				return true;
			}
		});
	}

	private static Object invoke(Object o, String methodName)
	{
		Object retVal = null;
		try
		{
			Method method = o.getClass().getMethod(methodName, (Class[]) null);
			retVal = method.invoke(o, (Object[]) null);
		}
		catch (Exception e)
		{
		}
		return retVal;
	}

	public static String contentToString(Object onixObj)
	{
		List<Object> content = getContent(onixObj);
		if (content != null)
		{
			StringBuffer sb = new StringBuffer();
			for (Object obj : content)
				if (obj != null)
					sb.append(obj.toString());
			return sb.toString();

		}
		return null;
	}

	public static List<String> enumListToStringArray(List<? extends Object> enumList, boolean returnValueField)
	{
		List<String> result = new LinkedList<String>();
		for (Object obj : enumList)
			if (obj != null)
				result.add(returnValueField ? invoke(obj, "value").toString() : obj.toString());
			else
				// NOTE: maybe we need to warn - this is situation where an enum value in the file (for instance, country code) doesn't conform to the ONIX
				// codelist as defined in the Xml Schema. the value "ROW" used as a country code is a known example
				;
		return result;
	}

	@SuppressWarnings("rawtypes")
	public static Object[] getChildren(Object onixObj, Class[] childrenClass)
	{
		Object[] result = new Object[childrenClass.length];
		List<Object> list = getContent(onixObj);
		if (list != null)
		{
			for (Object obj : list)
			{
				for (int i = 0; i < childrenClass.length; i++)
				{
					if (obj.getClass() == childrenClass[i])
					{
						result[i] = obj; // invoke(obj, "getValue")
						break;
					}
				}
			}
		}
		return result;
	}
}
