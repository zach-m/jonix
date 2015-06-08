package com.tectonica.jonix;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JonixUtil
{
	private static final Pattern timestampPattern = Pattern.compile("[^0-9]([0-9]{4,14})(?=[_\\.])");

	private static final String[] FORMATS = { "hhmm", "hhmmss", "yyyyMMdd", "yyyyMMddhhmm", "yyyyMMddhhmmss" };

	private static boolean[] FORMAT_HAS_DATE;
	private static boolean[] FORMAT_HAS_TIME;
	private static DateFormat[] PARSERS;
	static
	{
		PARSERS = new DateFormat[FORMATS.length];
		FORMAT_HAS_DATE = new boolean[FORMATS.length];
		FORMAT_HAS_TIME = new boolean[FORMATS.length];
		for (int i = 0; i < FORMATS.length; i++)
		{
			PARSERS[i] = new SimpleDateFormat(FORMATS[i]);
			FORMAT_HAS_DATE[i] = FORMATS[i].contains("yyyy");
			FORMAT_HAS_TIME[i] = FORMATS[i].contains("hh");
		}
	}

	/**
	 * Attempts to retrieve a time-stamp from a given file-name. Looks for the following constructs in the filename:
	 * <ul>
	 * <li> <code>hhmm</code>
	 * <li> <code>hhmmss</code>
	 * <li> <code>yyyyMMdd</code>
	 * <li> <code>yyyyMMddhhmm</code>
	 * <li> <code>yyyyMMddhhmmss</code>
	 * </ul>
	 * 
	 * @param fileName
	 *            the file-name from which to extract the time-stamp
	 * @return the extracted time-stamp, or null if such time-stamp couldn't be extracted
	 */
	public static Calendar extractTimstampFromOnixFileName(String fileName)
	{
		Matcher matcher = timestampPattern.matcher(fileName);
		Calendar aux = new GregorianCalendar();
		int yyyy = 0, MM = 0, dd = 0, hh = 0, mm = 0, ss = 0;
		while (matcher.find())
		{
			String value = matcher.group(1);
			for (int i = 0; i < FORMATS.length; i++)
			{
				if (value.length() == FORMATS[i].length())
				{
					Date timestamp = null;
					try
					{
						timestamp = PARSERS[i].parse(value);
					}
					catch (ParseException e)
					{
						continue;
					}
					aux.setTime(timestamp);
					if (FORMAT_HAS_DATE[i])
					{
						yyyy = aux.get(Calendar.YEAR);
						MM = aux.get(Calendar.MONTH);
						dd = aux.get(Calendar.DAY_OF_MONTH);
					}
					if (FORMAT_HAS_TIME[i])
					{
						hh = aux.get(Calendar.HOUR);
						mm = aux.get(Calendar.MINUTE);
						ss = aux.get(Calendar.SECOND);
					}
				}
			}
		}
		if (yyyy > 0)
			return new GregorianCalendar(yyyy, MM, dd, hh, mm, ss);
		return null;
	}

	public static <T extends Comparable<T>> int compare(T[] a, T[] b)
	{
		if (a == b)
			return 0;

		// arbitrary: two null arrays are considered 'equal'
		if (a == null && b == null)
			return 0;

		// arbitrary: non-null array is considered 'greater than' null array
		if (a == null)
			return -1; // "a < b"
		else if (b == null)
			return 1; // "a > b"

		// now the item-by-item comparison - the loop runs as long as items in both arrays are equal
		for (int i = 0;; i++)
		{
			// shorter array whose items are all equal to the first items of a longer array is considered 'less than'
			boolean pastA = (i == a.length);
			boolean pastB = (i == b.length);
			if (pastA && !pastB)
				return -1; // "a < b"
			else if (!pastA && pastB)
				return 1; // "a > b"
			else if (pastA && pastB)
				return 0; // "a = b", same length, all items equal

			T ai = a[i];
			T bi = b[i];
			if (ai == null && bi == null)
				continue; // again, two null items are assumed 'equal'

			// arbitrary: non-null item is considered 'greater than' null item
			if (ai == null)
				return -1; // "a < b"
			else if (bi == null)
				return 1; // "a > b"

			int comp = ai.compareTo(bi);
			if (comp != 0)
				return comp;
		}
	}

	private static final ObjectMapper mapper = createPropsMapper();

	private static ObjectMapper createPropsMapper()
	{
		ObjectMapper mapper = new ObjectMapper();

		// configure to use public fields only, consistent with Jonix design
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.PUBLIC_ONLY);
		mapper.setVisibility(PropertyAccessor.GETTER, Visibility.NONE);
		mapper.setVisibility(PropertyAccessor.SETTER, Visibility.NONE);

		// general configuration
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		mapper.setDateFormat(sdf);

		return mapper;
	}

	public static String toJson(Object o)
	{
		try
		{
			return mapper.writeValueAsString(o);
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}
