package com.tectonica.jonix;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JonixUtils
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
}
