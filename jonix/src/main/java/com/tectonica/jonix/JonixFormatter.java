package com.tectonica.jonix;

import com.tectonica.jonix.basic.BasicColumn;
import com.tectonica.jonix.basic.BasicProduct;

/**
 * A helper class for generating a tab-delimited output out of a {@link JonixTag} object. It offers statically methods only. The exact composition of output
 * is defined by the Enum {@link BasicColumn} (which columns to output), and the class {@link BasicExtractor} (how to extract these columns from the data).
 * 
 * @author Zach Melamed
 * 
 */
public class JonixFormatter
{
	/**
	 * turns a {@link BasicProduct} object into a jagged-array of Strings, whose amount of rows and columns are defined by {@link BasicColumn}
	 */
	public static <P extends JonixTag> String[][] productAsStringMatrix(P product, JonixColumn<P>[] columns)
	{
		// prepare the resulting jagged-array of values
		String[][] prodMatrix = new String[columns.length][];

		// populate it by extracting information from the 'product' object
		for (int i = 0; i < columns.length; i++)
		{
			JonixColumn<P> column = columns[i];
			column.extractTo(prodMatrix[i] = allocateMem(column), product);
		}
		return prodMatrix;
	}

	/**
	 * turns a {@link BasicProduct} object into a tab-delimited string, whose columns are defined by {@link BasicColumn}
	 */
	public static <P extends JonixTag> String productAsTabDelimitedString(P product, JonixColumn<P>[] columns)
	{
		String[][] prodMatrix = productAsStringMatrix(product, columns);

		// generate the tab-delimited row of text from the jagged-array
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < prodMatrix.length; i++)
		{
			for (int j = 0; j < prodMatrix[i].length; j++)
			{
				String item = prodMatrix[i][j];
				if (item == null)
					sb.append("");
				else
					sb.append(item.replaceAll("\\t|\\n|\\r", " "));
				sb.append("\t");
			}
		}
		return sb.toString();
	}

	/**
	 * generates a tab-delimited string, representing the <b>headers</b> of the columns, as defined by {@link BasicColumn}
	 */
	public static <P extends JonixTag> String headerAsTabDelimitedString(JonixColumn<P>[] columns)
	{
		StringBuilder sb = new StringBuilder();
		for (JonixColumn<P> column : columns)
		{
			int repetition = column.getRepetitions();
			for (int i = 0; i < repetition; i++)
			{
				String[] subColumnNames = column.getSubColumnNames();
				for (int j = 0; j < subColumnNames.length; j++)
				{
					sb.append(subColumnNames[j]);
					if (repetition > 1)
						sb.append(".").append(i + 1);
					sb.append("\t");
				}
			}
		}
		return sb.toString();
	}
	
	public static <P extends JonixTag> String[] allocateMem(JonixColumn<P> column)
	{
		return new String[column.getRepetitions() * column.getSubColumnNames().length];
	}
}
