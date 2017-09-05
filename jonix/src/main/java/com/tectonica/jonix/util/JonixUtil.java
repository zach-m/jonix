package com.tectonica.jonix.util;

import repackaged.net.sourceforge.isbnhyphenappender.ISBNHyphenAppender;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JonixUtil {
    private static final Pattern timestampPattern = Pattern.compile("[^0-9]([0-9]{4,14})(?=[_\\.])");

    private static final String[] FORMATS = {"hhmm", "hhmmss", "yyyyMMdd", "yyyyMMddhhmm", "yyyyMMddhhmmss"};

    private static boolean[] FORMAT_HAS_DATE;
    private static boolean[] FORMAT_HAS_TIME;
    private static DateFormat[] PARSERS;

    static {
        PARSERS = new DateFormat[FORMATS.length];
        FORMAT_HAS_DATE = new boolean[FORMATS.length];
        FORMAT_HAS_TIME = new boolean[FORMATS.length];
        for (int i = 0; i < FORMATS.length; i++) {
            PARSERS[i] = new SimpleDateFormat(FORMATS[i]);
            FORMAT_HAS_DATE[i] = FORMATS[i].contains("yyyy");
            FORMAT_HAS_TIME[i] = FORMATS[i].contains("hh");
        }
    }

    /**
     * Attempts to retrieve a time-stamp from a given file-name. Looks for the following constructs in the filename:
     * <ul> <li><code>hhmm</code> <li><code>hhmmss</code> <li><code>yyyyMMdd</code> <li><code>yyyyMMddhhmm</code>
     * <li><code>yyyyMMddhhmmss</code> </ul>
     *
     * @param fileName the file-name from which to extract the time-stamp
     * @return the extracted time-stamp, or null if such time-stamp couldn't be extracted
     */
    public static Calendar extractTimstampFromFileName(String fileName) {
        Matcher matcher = timestampPattern.matcher(fileName);
        Calendar aux = new GregorianCalendar();
        int yyyy = 0;
        int MM = 0;
        int dd = 0;
        int hh = 0;
        int mm = 0;
        int ss = 0;
        while (matcher.find()) {
            String value = matcher.group(1);
            for (int i = 0; i < FORMATS.length; i++) {
                if (value.length() == FORMATS[i].length()) {
                    Date timestamp = null;
                    try {
                        timestamp = PARSERS[i].parse(value);
                    } catch (ParseException e) {
                        continue;
                    }
                    aux.setTime(timestamp);
                    if (FORMAT_HAS_DATE[i]) {
                        yyyy = aux.get(Calendar.YEAR);
                        MM = aux.get(Calendar.MONTH);
                        dd = aux.get(Calendar.DAY_OF_MONTH);
                    }
                    if (FORMAT_HAS_TIME[i]) {
                        hh = aux.get(Calendar.HOUR);
                        mm = aux.get(Calendar.MINUTE);
                        ss = aux.get(Calendar.SECOND);
                    }
                }
            }
        }
        if (yyyy > 0) {
            return new GregorianCalendar(yyyy, MM, dd, hh, mm, ss);
        }
        return null;
    }

    public static <T extends Comparable<T>> int compareArray(T[] a, T[] b) {
        if (a == b) {
            return 0;
        }

        // arbitrary: two null arrays are considered 'equal'
        if (a == null && b == null) {
            return 0;
        }

        // arbitrary: non-null array is considered 'greater than' null array
        if (a == null) {
            return -1; // "a < b"
        } else if (b == null) {
            return 1; // "a > b"
        }

        // now the item-by-item comparison - the loop runs as long as items in both arrays are equal
        for (int i = 0; ; i++) {
            // shorter array whose items are all equal to the first items of a longer array is considered 'less than'
            boolean pastA = (i == a.length);
            boolean pastB = (i == b.length);
            if (pastA && !pastB) {
                return -1; // "a < b"
            } else if (!pastA && pastB) {
                return 1; // "a > b"
            } else if (pastA && pastB) {
                return 0; // "a = b", same length, all items equal
            }

            T ai = a[i];
            T bi = b[i];
            if (ai == null && bi == null) {
                continue; // again, two null items are assumed 'equal'
            }

            // arbitrary: non-null item is considered 'greater than' null item
            if (ai == null) {
                return -1; // "a < b"
            } else if (bi == null) {
                return 1; // "a > b"
            }

            int comp = ai.compareTo(bi);
            if (comp != 0) {
                return comp;
            }
        }
    }

    /**
     * simple auxiliary function to be statically imported into your code when calling lookup services in the various
     * onix classes (that take a set as an input parameter)
     */
    @SafeVarargs
    public static <T> Set<T> setOf(T... items) {
        return new HashSet<>(Arrays.asList(items));
    }

    private static ISBNHyphenAppender hyphener = new ISBNHyphenAppender();

    public static String hyphenatedIsbn(String isbn) {
        if (isbn == null) {
            return null;
        }

        try {
            return hyphener.appendHyphenToISBN(isbn);
        } catch (UnsupportedOperationException uoe) {
            // fall back to a simplistic hyphenation
            // TODO: log warning?
            if (isbn.length() == 13) {
                return isbn.substring(0, 0 + 3) + "-" + isbn.substring(3, 3 + 1) + "-" + isbn.substring(4, 4 + 4) + "-"
                    + isbn.substring(8, 8 + 4) + "-" + isbn.substring(12, 12 + 1);
            }

            if (isbn.length() == 10) {
                return isbn.substring(0, 0 + 1) + "-" + isbn.substring(1, 1 + 4) + "-" + isbn.substring(5, 5 + 4) + "-"
                    + isbn.substring(9, 9 + 1);
            }

            // fall back to the original..
            return isbn;
        }
    }

    public static String contributorDisplayName(String personName, String personNameKey, String personNameBeforeKey,
                                                String personNameInverted, String corporateName) {
        if (personName != null) {
            return personName;
        }

        if (personNameKey != null) {
            if (personNameBeforeKey != null) {
                return personNameBeforeKey + " " + personNameKey;
            }
            return personNameKey;
        }

        if (personNameBeforeKey != null) {
            return personNameBeforeKey;
        }

        if (personNameInverted != null) {
            return personNameInverted;
        }

        return corporateName;
    }

    private static SimpleDateFormat yyyymmdd = new SimpleDateFormat("yyyyMMdd");

    public static Date parseYYYYMMDD(String s) {
        try {
            return (s == null) ? null : yyyymmdd.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
