package com.tectonica.jonix.codegen.util;

public class XML
{
	public static String escape(String s)
	{
		if (s == null)
			return null;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			switch (c)
			{
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
			default:
				if (c > 0x7e)
					sb.append("&#" + ((int) c) + ";");
				else
					sb.append(c);
			}
		}
		return sb.toString();
	}
}
