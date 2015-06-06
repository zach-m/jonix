package com.tectonica.jonix;

public interface JonixContext<H, P>
{
	H createFrom(com.tectonica.jonix.onix2.Header header);

	H createFrom(com.tectonica.jonix.onix3.Header header);

	P createFrom(com.tectonica.jonix.onix2.Product product);

	P createFrom(com.tectonica.jonix.onix3.Product product);

	String labelOf(P product);

	Object onixProductObjectOf(P product);

	JonixColumn<P>[] getDefaultColumns();

	JonixColumn<P> getDefaultIdColumn();
}
