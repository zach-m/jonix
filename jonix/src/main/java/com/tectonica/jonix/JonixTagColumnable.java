package com.tectonica.jonix;

import com.tectonica.jonix.export.JonixUniqueExporter;
import com.tectonica.jonix.resolve.JonixResolver;

/**
 * Small extension to {@link JonixTag} applying only to PRODUCT tag (not HEADER). It provides the extra information needed by tab-delimited
 * exporters to render the PRODUCT as a table:
 * <ul>
 * <li>the default set of {@link JonixColumn}s to output (may be overridden by the user of the exporter)
 * <li>one particular {@link JonixColumn}, that constitutes an ID (a primary key, so to speak), needed by filtering services such as
 * {@link JonixUniqueExporter} (again, may be overridden)
 * </ul>
 * 
 * @author Zach Melamed
 * 
 */
public class JonixTagColumnable extends JonixTag
{
	public JonixTagColumnable(JonixResolver resolver)
	{
		super(resolver);
	}

	public <P extends JonixTagColumnable> JonixColumn<P>[] getDefaultColumns()
	{
		return null;
	}

	public <P extends JonixTagColumnable> JonixColumn<P> getDefaultIdColumn()
	{
		return null;
	}
}
