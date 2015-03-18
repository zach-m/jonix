package com.tectonica.jonix;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Auxiliary services to use primarily by Jonix classes, but also by its subclasses.
 * 
 * @author Zach Melamed
 * 
 */
public class JonixUtils
{
	private static boolean isFieldExists(Object onixObj, String fieldName)
	{
		if (onixObj == null)
			return false;

		try
		{
			onixObj.getClass().getDeclaredField(fieldName);
		}
		catch (NoSuchFieldException e)
		{
			return false;
		}
		return true;
	}

	private static Object getFieldValue(Object onixObj, String fieldName) throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException
	{
		if (onixObj == null)
			return null;

		Field field = onixObj.getClass().getDeclaredField(fieldName);
		field.setAccessible(true);
		return field.get(onixObj);
	}

	private static Object invokeMethodOf(Object onixObj, String methodName) throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException
	{
		if (onixObj == null)
			return null;

		return onixObj.getClass().getMethod(methodName).invoke(onixObj);
	}

	public static Object getProperty(Object onixObj, String... propertyPath)
	{
		try
		{
			for (String propertyName : propertyPath)
			{
				if (propertyName.endsWith("()"))
					onixObj = invokeMethodOf(onixObj, propertyName.substring(0, propertyName.length() - 2));
				else
					onixObj = getFieldValue(onixObj, propertyName);
			}
			return onixObj;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static String getValueAsStr(Object onixObj)
	{
		return (String) getProperty(onixObj, "value");
	}

	public static String getContentAsStr(Object onixObj)
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

	@SuppressWarnings("unchecked")
	public static List<Object> getContent(Object onixObj)
	{
		return isFieldExists(onixObj, "content") ? (List<Object>) getProperty(onixObj, "content") : null;
	}

	public static List<String> enumValueToStringArray(Object o, boolean returnValueProperty)
	{
		List<String> result = new ArrayList<String>();
		List<?> enumList = (List<?>) getProperty(o, "value");
		if (enumList != null)
			for (Object obj : enumList)
			{
				if (obj != null)
					result.add(returnValueProperty ? getValueAsStr(obj) : obj.toString());
				else
					// NOTE: maybe we need to warn - this is situation where an enum value in the file (for instance, country code) doesn't
					// conform to the ONIX
					// codelist as defined in the Xml Schema. the value "ROW" used as a country code is a known example
					;
			}
		return result;
	}

	public static String noBreaks(String s)
	{
		return (s == null || s.isEmpty()) ? s : s.replaceAll("\\t|\\n|\\r", " ");
	}

}
