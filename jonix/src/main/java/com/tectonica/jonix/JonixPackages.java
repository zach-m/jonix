package com.tectonica.jonix;

import com.tectonica.jonix.resolve.JonixResolver;

/**
 * Enum of the ONIX packages supported by Jonix. each package corresponds to an ONIX Xml schema, which is the basis for the correct parsing of an ONIX file.
 * an ONIX file created using the v3.0 schema can't be processed with v2.0 schema and vice verse. Also, an ONIX file encoded with SHORT tags can't be processed
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
	v21_Reference("org.editeur.onix.v21.references", "http://www.editeur.org/onix/2.1/reference", new com.tectonica.jonix.resolve.JonixResolver_v21_reference()),

	/**
	 * ONIX v2.1 with SHORT tags
	 */
	v21_Short("org.editeur.onix.v21.shorts", "http://www.editeur.org/onix/2.1/short", new com.tectonica.jonix.resolve.JonixResolver_v21_short()),

	/**
	 * ONIX v3.0 with REFERENCE tags - <b>Unsupported yet</b>
	 */
	v30_Reference("org.editeur.onix.v30.references", "http://ns.editeur.org/onix/3.0/reference", new com.tectonica.jonix.resolve.JonixResolver_v30_reference()),

	/**
	 * ONIX v3.0 with SHORT tags - <b>Unsupported yet</b>
	 */
	v30_Short("org.editeur.onix.v30.shorts", "http://ns.editeur.org/onix/3.0/short", new com.tectonica.jonix.resolve.JonixResolver_v30_short());

	public final String onixPackage;
	public final String onixNameSpace;
	public final JonixResolver resolver;

	private JonixPackages(String onixPackage, String onixNameSpace, JonixResolver resolver)
	{
		this.onixPackage = onixPackage;
		this.onixNameSpace = onixNameSpace;
		this.resolver = resolver;
	}
}
