package com.tectonica.jonix;

/**
 * An interface representing a piece of data extractable from a ONIX PRODUCT, such as ISBN, Author, etc. These columns don't necessarily
 * exist as separate entities in an ONIX record, and may require some lookup (for instance, ISBN is just one type of Product-Id, which may
 * and may not exist in the ONIX record). This interface makes it easy for a Product implementation to provide a method syntactically
 * equivalent to <code>product.getISBN();</code>.
 * <p>
 * In addition to performing the extraction of the required data from the ONIX PRODUCT, this interface facilitates standard transformation
 * of the PRODUCT (which is a complex, tree-based structure) into a tabular, array-based structure. For example, an Author is an ONIX item
 * (composite) to which this interface may dictate to allocate 3 columns (indicated by {@link #getRepetitions()}). The reason is that we
 * expect this item to show up several times in a multi-author title. We want to define a <b>set</b> amount of columns per ONIX item is to
 * maintain a tabular structure of the output. In doing so we may lose some data (e.g. the 4th author) and/or receive a fairly sparse output
 * (i.e. with many blanks), but this is a toll we have to bear when converting an XML format into table.
 * <p>
 * The extraction of data from an ONIX record is to be implemented in {@link #extractTo(String[], JonixTag)}, which received a pre-allocated
 * array of Strings for the result. It's an array and not a single String because a column may consist of several values ("sub-columns").
 * For instance, a dimension of a book has three values: the dimension type (Height, Width, etc), the value itself (3.25, etc.) and the unit
 * (inch, cm, etc.). The size of the array to be filled by {@link #extractTo(String[], JonixTag)} is determined by the size of the array
 * returned from {@link #getSubColumnNames()}, which returns header names for the columns, used in formatting scenarios.
 * 
 * @author Zach Melamed
 * 
 * @param <P>
 *            The {@link JonixTag} representing the product from which this column is to be extracted
 */
public interface JonixColumn<P extends JonixTag>
{
	int getRepetitions();

	String[] getSubColumnNames();

	boolean extractTo(String[] fieldData, P product);
}
