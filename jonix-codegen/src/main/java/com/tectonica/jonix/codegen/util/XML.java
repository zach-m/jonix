package com.tectonica.jonix.codegen.util;

public class XML {
    public static String escape(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                case '\"':
                    sb.append("&quot;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                case '\'':
                    sb.append("&apos;");
                    break;
                case '\u2013': // replace Unicode dash with ascii
                    sb.append("-");
                    break;
                case '‘': // replace Unicode apostrophes with ascii
                case '’':
                case 'ʼ':
                case '❜':
                    sb.append("'");
                    break;

                default:
                    if (c > 0x7e) {
                        sb.append("&#" + ((int) c) + ";");
                    } else {
                        sb.append(c);
                    }
            }
        }
        return sb.toString();
    }
}
