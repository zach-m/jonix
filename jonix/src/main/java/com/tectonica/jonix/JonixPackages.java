package com.tectonica.jonix;

import com.tectonica.jonix.mappers.IHeaderMapper;
import com.tectonica.jonix.mappers.IProductMapper;

/**
 * Enum of the ONIX packages supported by Jonix. each package corresponds to an ONIX Xml schema, which is the basis for the correct parsing of an ONIX file.
 * an ONIX file created using the v3.0 schema can't be processed with v2.0 schema and vice verse. also, an ONIX file encoded with SHORT tags can't be processed
 * with a REFERENCE schema.
 * 
 * @author Zach Melamed
 * 
 */
public enum JonixPackages
{
	/**
	 * ONIX v2.1 with REFERENCE tags
	 */
	v21_Reference("org.editeur.onix.v21.references", "http://www.editeur.org/onix/2.1/reference", new com.tectonica.jonix.mappers.v21.references.ProductMapper(),
			new com.tectonica.jonix.mappers.v21.references.HeaderMapper()),

	/**
	 * ONIX v2.1 with SHORT tags
	 */
	v21_Short("org.editeur.onix.v21.shorts", "http://www.editeur.org/onix/2.1/short", new com.tectonica.jonix.mappers.v21.shorts.ProductMapper(),
			new com.tectonica.jonix.mappers.v21.shorts.HeaderMapper()),

	/**
	 * ONIX v3.0 with REFERENCE tags - <b>Unsupported yet</b>
	 */
	v30_Reference("org.editeur.onix.v30.references", "http://ns.editeur.org/onix/3.0/reference", null, null),

	/**
	 * ONIX v3.0 with SHORT tags - <b>Unsupported yet</b>
	 */
	v30_Short("org.editeur.onix.v30.shorts", "http://ns.editeur.org/onix/3.0/short", null, null);

	public final String onixPackage;
	public final String onixNameSpace;
	public final IProductMapper productMapper;
	public final IHeaderMapper headerMapper;

	private JonixPackages(String onixPackage, String onixNameSpace, IProductMapper productMapper, IHeaderMapper headerMapper)
	{
		this.onixPackage = onixPackage;
		this.onixNameSpace = onixNameSpace;
		this.productMapper = productMapper;
		this.headerMapper = headerMapper;
	}
}
