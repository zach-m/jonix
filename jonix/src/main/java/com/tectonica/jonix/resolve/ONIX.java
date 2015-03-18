package com.tectonica.jonix.resolve;

/**
 * Master Enum, listing all ONIX types in all versions
 * 
 * @author Zach Melamed
 * 
 */
public enum ONIX
{
	/**
	 * A product is described by a group of data elements beginning with an XML label &lt;Product&gt; and ending with an XML label &lt;/Product&gt;. The entire
	 * group of data elements which is enclosed between these two labels constitutes an ONIX product record. The product record is the fundamental unit within
	 * an ONIX Product Information message. In almost every case, each product record describes an individually tradable item.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Product}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Product}<br/>
	 *        {@link org.editeur.onix.v30.references.Product}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Product}<br/>
	 */
	Product,

	/**
	 * For every product, you must choose a single number which will uniquely identify the Information record which you send out about that product, and which
	 * will remain as its permanent identifier every time you send an update. It doesn’t matter what number you choose, provided that it is unique and
	 * permanent. This number doesn’t really identify the product – even though you may choose to use the ISBN or another product identifier – it identifies
	 * your information record about the product, so that the person to whom you are sending an update can match it with what you have previously sent. A good
	 * way of generating numbers which are not part of a recognized product identification scheme but which can be guaranteed to be unique is to preface the
	 * number with an Internet domain name which is registered to your organisation.
	 * 
	 * @format
	 *         Variable-length, alphanumeric, suggested maximum length 32 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.RecordReference}<br/>
	 *        {@link org.editeur.onix.v21.shorts.A001}<br/>
	 *        {@link org.editeur.onix.v30.references.RecordReference}<br/>
	 *        {@link org.editeur.onix.v30.shorts.A001}<br/>
	 */
	RecordReference,

	/**
	 * An ONIX code which indicates the type of notification or update which you are sending. Mandatory and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 1
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.NotificationType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.A002}<br/>
	 *        {@link org.editeur.onix.v30.references.NotificationType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.A002}<br/>
	 */
	NotificationType,

	/**
	 * An ONIX code which indicates the reason why an ONIX record is being deleted. Optional and non-repeating; and may occur only when the
	 * &lt;NotificationType&gt; element carries the code value 05. Note that it refers to the reason why the record is being deleted, not the reason why a
	 * product has been “deleted” (in industries which use this terminology when a product is withdrawn).
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 2
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.DeletionCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.A198}<br/>
	 */
	DeletionCode,

	/**
	 * Free text which indicates the reason why an ONIX record is being deleted. Optional and non-repeating; and may occur only when the
	 * &lt;NotificationType&gt; element carries the code value 05. Note that it refers to the reason why the record is being deleted, not the reason why a
	 * product has been “deleted” (in industries which use this terminology when a product is withdrawn).
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.DeletionText}<br/>
	 *        {@link org.editeur.onix.v21.shorts.A199}<br/>
	 *        {@link org.editeur.onix.v30.references.DeletionText}<br/>
	 *        {@link org.editeur.onix.v30.shorts.A199}<br/>
	 */
	DeletionText,

	/**
	 * An ONIX code which indicates the type of source which has issued the ONIX record. Optional and non-repeating, independently of the occurrence of any
	 * other field.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 3
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.RecordSourceType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.A194}<br/>
	 *        {@link org.editeur.onix.v30.references.RecordSourceType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.A194}<br/>
	 */
	RecordSourceType,

	/**
	 * An ONIX code identifying the scheme from which the identifier in the &lt;RecordSourceIdentifier&gt; element is taken. Optional and non-repeating, but
	 * &lt;RecordSourceIdentifier&gt; must also be present if this field is present.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 44
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.RecordSourceIdentifierType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.A195}<br/>
	 */
	RecordSourceIdentifierType,

	/**
	 * An identifier for the party which issued the record, from the scheme specified in &lt;RecordSourceIdentifierType&gt;. Optional and non-repeating, but
	 * &lt;RecordSourceIdentifierType&gt; must also be present if this field is present.
	 * 
	 * @format
	 *         Defined by the identifier scheme specified in &lt;RecordSourceIdentifierType&gt;
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.RecordSourceIdentifier}<br/>
	 *        {@link org.editeur.onix.v21.shorts.A196}<br/>
	 *        {@link org.editeur.onix.v30.references.RecordSourceIdentifier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Recordsourceidentifier}<br/>
	 */
	RecordSourceIdentifier,

	/**
	 * The name of the party which issued the record, as free text. Optional and non-repeating, independently of the occurrence of any other field.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.RecordSourceName}<br/>
	 *        {@link org.editeur.onix.v21.shorts.A197}<br/>
	 *        {@link org.editeur.onix.v30.references.RecordSourceName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.A197}<br/>
	 */
	RecordSourceName,

	/**
	 * The 10-character International Standard Book Number, the recognized standard identifier for books and certain other non-serial publications up to 31
	 * December 2006. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 10 characters, all numeric except last character, which may be letter X. The last character is a check character calculated in
	 *         accordance with rules given at
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ISBN}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B004}<br/>
	 */
	ISBN,

	/**
	 * The cross-industry product code administered by EAN International and its member agencies worldwide, in association with UCC in the US. Optional and
	 * non-repeating. For books, an EAN number can be derived from a ten-character ISBN by (a) prefixing it with the three digits 978, (b) deleting the ISBN
	 * check character, and (c) attaching a new check digit calculated according to EAN rules.
	 * 
	 * @format
	 *         Fixed-length, 13 numeric digits. The last digit is a modulus-10 check digit calculated in accordance with the rules given at
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.EAN13}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B005}<br/>
	 */
	EAN13,

	/**
	 * Universal Product Code, the cross-industry product numbering and bar-coding system administered in the USA by the Uniform Code Council. Optional and
	 * non-repeating. In the US book trade, required for mass-market editions sold in supermarkets and other non-book-trade outlets.
	 * 
	 * @format
	 *         Fixed-length, 12 numeric digits. The last digit is a modulus-10 check digit. For more information see
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.UPC}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B006}<br/>
	 */
	UPC,

	/**
	 * A product code assigned by the publisher of a product, not taken from a recognized standard numbering scheme. Optional and non-repeating. To be used only
	 * when the product does not have a number from a recognized industry standard scheme (
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 35 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.PublisherProductNo}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B007}<br/>
	 */
	PublisherProductNo,

	/**
	 * International Standard Music Number, the recognized standard identifier for printed music. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, letter M followed by nine numeric digits, the last of which is a check character calculated according to rules given at
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ISMN}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B008}<br/>
	 */
	ISMN,

	/**
	 * Digital Object Identifier. The international identifier for intellectual property in the digital environment. See
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.DOI}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B009}<br/>
	 */
	DOI,

	/**
	 * A repeatable group of data elements which together define the identifier of a product in accordance with a specified scheme, allowing new types of
	 * product identifier to be included without defining additional data elements. In particular, the composite allows proprietary identifiers (SKUs) assigned
	 * by wholesalers or vendors to be sent as part of the ONIX record.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ProductIdentifier}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Productidentifier}<br/>
	 *        {@link org.editeur.onix.v30.references.ProductIdentifier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Productidentifier}<br/>
	 */
	ProductIdentifier,

	/**
	 * An ONIX code identifying the scheme from which the identifier in the &lt;IDValue&gt; element is taken. Mandatory in each occurrence of the
	 * &lt;ProductIdentifier&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 2 numeric digits
	 * @codelist
	 *           List 5
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ProductIDType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B221}<br/>
	 *        {@link org.editeur.onix.v30.references.ProductIDType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B221}<br/>
	 */
	ProductIDType,

	/**
	 * A name which identifies a proprietary identifier scheme when, and only when, the code in the &lt;ProductIDType&gt; element indicates a proprietary
	 * scheme,
	 * 
	 * @format
	 *         Free text, suggested maximum length 50 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.IDTypeName}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B233}<br/>
	 *        {@link org.editeur.onix.v30.references.IDTypeName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B233}<br/>
	 */
	IDTypeName,

	/**
	 * An identifier of the type specified in the &lt;ProductIDType&gt; element. Mandatory in each occurrence of the &lt;ProductIdentifier&gt; composite, and
	 * non-repeating.
	 * 
	 * @format
	 *         According to the identifier type specified in &lt;ProductIDType&gt;
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.IDValue}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B244}<br/>
	 *        {@link org.editeur.onix.v30.references.IDValue}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B244}<br/>
	 */
	IDValue,

	/**
	 * An ONIX code indicating whether a product is bar-coded. Optional, and repeatable if the product carries two or more barcodes from different schemes. The
	 * absence of this field does NOT mean that a product is not bar-coded.
	 * 
	 * @format
	 *         Fixed-length, 2 numeric digits
	 * @codelist
	 *           List 6
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Barcode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B246}<br/>
	 *        {@link org.editeur.onix.v30.references.Barcode}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Barcode}<br/>
	 */
	Barcode,

	/**
	 * 10-character International Standard Book Number of a former product which the current product replaces. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 10 characters, all numeric except last character, which may be letter X.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ReplacesISBN}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B010}<br/>
	 */
	ReplacesISBN,

	/**
	 * The EAN.UCC-13 article number of a former product which the current product replaces. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 13 numeric digits.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ReplacesEAN13}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B011}<br/>
	 */
	ReplacesEAN13,

	/**
	 * An ONIX code which indicates the primary form of the product. Mandatory and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two letters.
	 * @codelist
	 *           List 7
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ProductForm}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B012}<br/>
	 *        {@link org.editeur.onix.v30.references.ProductForm}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B012}<br/>
	 */
	ProductForm,

	/**
	 * An ONIX code which provides added detail of the medium and/or format of the product. Optional and repeatable.
	 * 
	 * @format
	 *         Fixed-length, four characters: one letter followed by three numeric digits
	 * @codelist
	 *           List 78
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ProductFormDetail}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B333}<br/>
	 *        {@link org.editeur.onix.v30.references.ProductFormDetail}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B333}<br/>
	 */
	ProductFormDetail,

	/**
	 * A repeatable group of data elements which together describe an aspect of product form that is too specific to be covered in the &lt;ProductForm&gt; and
	 * &lt;ProductFormDetail&gt; elements. Optional.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ProductFormFeature}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Productformfeature}<br/>
	 *        {@link org.editeur.onix.v30.references.ProductFormFeature}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Productformfeature}<br/>
	 */
	ProductFormFeature,

	/**
	 * An ONIX code which specifies the feature described by an instance of the &lt;ProductFormFeature&gt; composite,
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 79
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ProductFormFeatureType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B334}<br/>
	 *        {@link org.editeur.onix.v30.references.ProductFormFeatureType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B334}<br/>
	 */
	ProductFormFeatureType,

	/**
	 * A controlled value that describes a product form feature. Presence or absence of this element depends on the &lt;ProductFormFeatureType&gt;, since some
	 * product form features (
	 * 
	 * @format
	 *         Dependent on the scheme specified in &lt;ProductFormFeatureType&gt;
	 * @codelist
	 *           Dependent on the scheme specified in &lt;ProductFormFeatureType&gt;
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ProductFormFeatureValue}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B335}<br/>
	 *        {@link org.editeur.onix.v30.references.ProductFormFeatureValue}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B335}<br/>
	 */
	ProductFormFeatureValue,

	/**
	 * If the &lt;ProductFormFeatureType&gt; requires free text rather than a code value, or if the code in &lt;ProductFormFeatureValue&gt; does not adequately
	 * describe the feature, a short text description may be added. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ProductFormFeatureDescription}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B336}<br/>
	 *        {@link org.editeur.onix.v30.references.ProductFormFeatureDescription}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B336}<br/>
	 */
	ProductFormFeatureDescription,

	/**
	 * An ONIX code specifying more detail of the product format when the product is a book. Repeatable when two or more coded characteristics apply. This field
	 * is optional, but must only be included when the code in the &lt;ProductForm&gt; element begins with letter B.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 8
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.BookFormDetail}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B013}<br/>
	 */
	BookFormDetail,

	/**
	 * An ONIX code which indicates the type of packaging used for the product. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 80
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ProductPackaging}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B225}<br/>
	 *        {@link org.editeur.onix.v30.references.ProductPackaging}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B225}<br/>
	 */
	ProductPackaging,

	/**
	 * If product form codes do not adequately describe the product, a short text description may be added to give a more detailed specification of the product
	 * form. The field is optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 200 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ProductFormDescription}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B014}<br/>
	 *        {@link org.editeur.onix.v30.references.ProductFormDescription}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B014}<br/>
	 */
	ProductFormDescription,

	/**
	 * If the product is homogeneous (
	 * 
	 * @format
	 *         Variable-length integer, suggested maximum length 4 digits.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.NumberOfPieces}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B210}<br/>
	 */
	NumberOfPieces,

	/**
	 * An ONIX code which indicates a trade category which is somewhat related to but not properly an attribute of product form. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 12
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.TradeCategory}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B384}<br/>
	 *        {@link org.editeur.onix.v30.references.TradeCategory}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B384}<br/>
	 */
	TradeCategory,

	/**
	 * An ONIX code which indicates certain types of content which are closely related to but not strictly an attribute of product form,
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 81
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ProductContentType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B385}<br/>
	 *        {@link org.editeur.onix.v30.references.ProductContentType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B385}<br/>
	 */
	ProductContentType,

	/**
	 * A repeatable group of data elements which together describe an item which is part of or contained within the current product. The composite may be used
	 * to specify the item(s) and item quantity/ies carried in a dumpbin, or included in (eg) a classroom pack, or simply to state the product forms contained
	 * within a mixed media product, without specifying their identifiers or quantity. The composite is used only when the product form coding for the product
	 * as a whole indicates that the product includes two or more different items, or multiple copies of the same item.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ContainedItem}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Containeditem}<br/>
	 */
	ContainedItem,

	/**
	 * For filled dumpbins and counter packs, and for retail packs containing a number of copies of the same item, the number of copies of the specified item
	 * contained in the pack. &lt;ItemQuantity&gt; is used to state a quantity of identical items, when a pack contains either a quantity of a single item, or a
	 * quantity of each of two or more different items (
	 * 
	 * @format
	 *         Variable-length integer, maximum four digits
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ItemQuantity}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B015}<br/>
	 */
	ItemQuantity,

	/**
	 * A repeatable group of data elements which together define a product classification (NOT to be confused with a subject classification). The intended use
	 * is to enable national or international trade classifications (aka commodity codes) to be carried in an ONIX record.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ProductClassification}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Productclassification}<br/>
	 *        {@link org.editeur.onix.v30.references.ProductClassification}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Productclassification}<br/>
	 */
	ProductClassification,

	/**
	 * An ONIX code identifying the scheme from which the identifier in &lt;ProductClassificationCode&gt; is taken. Mandatory in any instance of the
	 * &lt;ProductClassification&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 2 numeric digits
	 * @codelist
	 *           List 9
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ProductClassificationType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B274}<br/>
	 *        {@link org.editeur.onix.v30.references.ProductClassificationType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B274}<br/>
	 */
	ProductClassificationType,

	/**
	 * A classification code from the scheme specified in &lt;ProductClassificationType&gt;. Mandatory in any instance of the &lt;ProductClassification&gt;
	 * composite, and non-repeating.
	 * 
	 * @format
	 *         According to the identifier type specified in &lt;ProductClassificationType&gt;
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ProductClassificationCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B275}<br/>
	 *        {@link org.editeur.onix.v30.references.ProductClassificationCode}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B275}<br/>
	 */
	ProductClassificationCode,

	/**
	 * The percentage of the unit value of the product that is assignable to a designated product classification. Optional and non-repeating. Used when a mixed
	 * product (
	 * 
	 * @format
	 *         Real decimal number in the range 0 to 100
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Percent}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B337}<br/>
	 *        {@link org.editeur.onix.v30.references.Percent}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B337}<br/>
	 */
	Percent,

	/**
	 * An ONIX code identifying the type of an epublication. This element is mandatory if and only if the &lt;ProductForm&gt; code for the product is DG; and
	 * non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 3 numeric digits
	 * @codelist
	 *           List 10
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.EpubType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B211}<br/>
	 */
	EpubType,

	/**
	 * A version number which applies to a specific epublication type. Optional and non-repeating, and can occur only if the &lt;EpubType&gt; field is present.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum 10 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.EpubTypeVersion}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B212}<br/>
	 */
	EpubTypeVersion,

	/**
	 * A free text description of an epublication type. Optional and non-repeating, and can occur only if the &lt;EpubType&gt; field is present.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum 200 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.EpubTypeDescription}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B213}<br/>
	 */
	EpubTypeDescription,

	/**
	 * An ONIX code identifying the underlying format of an epublication. Optional and non-repeating, and can occur only if the &lt;EpubType&gt; field is
	 * present. Note that where the epublication type is wholly defined by the delivery format, this element effectively duplicates the &lt;EpubType&gt; field.
	 * 
	 * @format
	 *         Fixed-length, 2 numeric digits
	 * @codelist
	 *           List 11
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.EpubFormat}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B214}<br/>
	 */
	EpubFormat,

	/**
	 * A version number which applies to an epublication format. Optional and non-repeating, and can occur only if the &lt;EpubFormat&gt; field is present.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum 10 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.EpubFormatVersion}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B215}<br/>
	 */
	EpubFormatVersion,

	/**
	 * A free text description of an epublication format. Optional and non-repeating, and can occur only if the &lt;EpubType&gt; field is present, but it does
	 * not require the presence of the &lt;EpubFormat&gt; field.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum 200 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.EpubFormatDescription}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B216}<br/>
	 */
	EpubFormatDescription,

	/**
	 * An ONIX code identifying the source file format of an epublication when shipped by a publisher to an intermediary for conversion to one or more forms of
	 * deliverable. Optional and non-repeating, and can occur only if the &lt;EpubType&gt; field is present.
	 * 
	 * @format
	 *         Fixed-length, 2 numeric digits
	 * @codelist
	 *           List 11
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.EpubSource}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B278}<br/>
	 */
	EpubSource,

	/**
	 * A version number which applies to an epublication source file format. Optional and non-repeating, and can occur only if the &lt;EpubSource&gt; field is
	 * present.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum 10 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.EpubSourceVersion}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B279}<br/>
	 */
	EpubSourceVersion,

	/**
	 * A free text description of an epublication source file format. Optional and non-repeating, and can occur only if the &lt;EpubType&gt; field is present,
	 * but it does not require the presence of the &lt;EpubSource&gt; field.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum 200 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.EpubSourceDescription}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B280}<br/>
	 */
	EpubSourceDescription,

	/**
	 * A free text description of features of a product which are specific to its appearance as a particular epublication type. Optional and non-repeatable, and
	 * can occur only if the &lt;EpubType&gt; field is present.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum 200 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.EpubTypeNote}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B277}<br/>
	 */
	EpubTypeNote,

	/**
	 * A repeatable group of data elements which together describe a series of which the product is part.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.Series}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Series}<br/>
	 */
	Series,

	/**
	 * International Standard Serial Number identifying a series of which the product forms part. ISSNs are the standard numbering scheme for journals, and most
	 * publishers’ book series are not eligible to be identified by an ISSN. ISSNs may be used, however, for established scholarly series such as Annual Reviews
	 * of… or Methods in… which are shelved in libraries as if they were journals. The field is optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, eight numeric digits, of which the last is a check digit; see
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.SeriesISSN}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B016}<br/>
	 */
	SeriesISSN,

	/**
	 * A code or mnemonic assigned by the publisher to designate a series (and therefore not guaranteed to be unique). Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 20 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.PublisherSeriesCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B017}<br/>
	 */
	PublisherSeriesCode,

	/**
	 * A repeatable group of data elements which together define an identifier of a series or subseries. The composite is optional, and may only repeat if two
	 * or more identifiers of different types are sent. It is not permissible to have two identifiers of the same type.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.SeriesIdentifier}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Seriesidentifier}<br/>
	 */
	SeriesIdentifier,

	/**
	 * An ONIX code identifying the scheme from which the identifier in the &lt;IDValue&gt; element is taken. Mandatory in each occurrence of the
	 * &lt;SeriesIdentifier&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 13
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.SeriesIDType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B273}<br/>
	 */
	SeriesIDType,

	/**
	 * The full title of the series, without abbreviation or abridgement. Non-repeating. Either the &lt;TitleOfSeries&gt; element or at least one occurrence of
	 * the &lt;Title&gt; composite must occur in each occurrence of the &lt;Series&gt; composite. The &lt;Title&gt; composite provides a more comprehensive
	 * representation of a series title, and allows alternative forms to be sent.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.TitleOfSeries}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B018}<br/>
	 */
	TitleOfSeries,

	/**
	 * A repeatable group of data elements which together give the text of a title, including a subtitle where applicable, and specify its type.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.Title}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Title}<br/>
	 */
	Title,

	/**
	 * A repeatable group of data elements which together describe a personal or corporate contributor to the series. The composite is optional in any
	 * occurrence the &lt;Series&gt; composite.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Contributor}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Contributor}<br/>
	 *        {@link org.editeur.onix.v30.references.Contributor}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Contributor}<br/>
	 */
	Contributor,

	/**
	 * The distinctive enumeration of a product within a series. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 20 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.NumberWithinSeries}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B019}<br/>
	 */
	NumberWithinSeries,

	/**
	 * Data element specifying the publication order of products within a series, when it is distinct from the &lt;NumberWithinSeries&gt; (
	 * 
	 * @format
	 *         Integer, up to four digits
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.PubSequenceNumberWithinSeries}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B222}<br/>
	 */
	PubSequenceNumberWithinSeries,

	/**
	 * The nominal year of an annual publication. May be entered as either a single year YYYY or a span of two consecutive years YYYY-YYYY. Optional and
	 * non-repeating.
	 * 
	 * @format
	 *         Either four numeric digits, or four numeric digits followed by hyphen followed by four numeric digits
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.YearOfAnnual}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B020}<br/>
	 *        {@link org.editeur.onix.v30.references.YearOfAnnual}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B020}<br/>
	 */
	YearOfAnnual,

	/**
	 * An empty element that provides a positive indication that a product does not belong to a series. Intended to be used in an ONIX accreditation scheme to
	 * confirm that series information is being consistently supplied in publisher ONIX feeds. Optional and non-repeating. Must only be sent in a record that
	 * has no instances of the &lt;Series&gt; composite.
	 * 
	 * @format
	 *         XML empty element
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.NoSeries}<br/>
	 *        {@link org.editeur.onix.v21.shorts.N338}<br/>
	 */
	NoSeries,

	/**
	 * A repeatable group of data elements which together describe a set of which the product is part.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.Set}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Set}<br/>
	 */
	Set,

	/**
	 * A 10-character ISBN identifying a set of which the product forms part. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 10 characters, all numeric except last character, which may be letter X
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ISBNOfSet}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B021}<br/>
	 */
	ISBNOfSet,

	/**
	 * EAN.UCC-13 article number identifying a set of which the product forms part. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 13 numeric digits
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.EAN13OfSet}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B022}<br/>
	 */
	EAN13OfSet,

	/**
	 * The full title of the set, without abbreviation or abridgement. Non-repeating. Either the &lt;TitleOfSet&gt; element or at least one occurrence of the
	 * &lt;Title&gt; composite must occur in each occurrence of the &lt;Set&gt; composite. The &lt;Title&gt; composite provides a more comprehensive
	 * representation of a set title, and allows alternative forms to be sent.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.TitleOfSet}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B023}<br/>
	 */
	TitleOfSet,

	/**
	 * The distinctive enumeration of a “subset” of which the product is a member, used only when a set is itself divided into two levels,
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 20 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.SetPartNumber}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B024}<br/>
	 */
	SetPartNumber,

	/**
	 * The title of a “subset” of which the product is a member, used only when a set is itself divided into two levels,
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.SetPartTitle}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B025}<br/>
	 */
	SetPartTitle,

	/**
	 * The distinctive enumeration of the product as an item within a set (or within a part of a set). Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 20 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ItemNumberWithinSet}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B026}<br/>
	 */
	ItemNumberWithinSet,

	/**
	 * A number which specifies the position of an item in a set within a multi-level hierarchy of such items. Numbering starts at the top level in the
	 * hierarchy, and the first item at the top level is numbered 1. Optional and non-repeating. The purpose of this element is to make it possible to describe
	 * structured sets in a normalized way, since enumeration carried as &lt;ItemNumberWithinSet&gt; may take a wide variety of forms.
	 * 
	 * @format
	 *         Variable-length string of integers, each successive integer being separated by a full stop, suggested maximum length 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.LevelSequenceNumber}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B284}<br/>
	 *        {@link org.editeur.onix.v30.references.LevelSequenceNumber}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B284}<br/>
	 */
	LevelSequenceNumber,

	/**
	 * The title which the product carries as an item within a set,
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.SetItemTitle}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B281}<br/>
	 */
	SetItemTitle,

	/**
	 * An ONIX code indicating the case in which the title elements are sent. The default is “unspecified”. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 14
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.TextCaseFlag}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B027}<br/>
	 */
	TextCaseFlag,

	/**
	 * The full text of the distinctive title of the product, without abbreviation or abridgement, but excluding the subtitle (if any). Where the title alone is
	 * not distinctive, elements may be taken from a set or series title and part number
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.DistinctiveTitle}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B028}<br/>
	 */
	DistinctiveTitle,

	/**
	 * Text at the beginning of the distinctive title of the product which is to be ignored for alphabetical sorting. Optional and non-repeating; can only be
	 * used if the &lt;TitleWithoutPrefix&gt; element is also present. These two elements may be used in combination in applications where it is necessary to
	 * distinguish an initial word or character string which is to be ignored for filing purposes,
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 20 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.TitlePrefix}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B030}<br/>
	 *        {@link org.editeur.onix.v30.references.TitlePrefix}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B030}<br/>
	 */
	TitlePrefix,

	/**
	 * Full text of the distinctive title of the product, without abbreviation or abridgement, and without the title prefix. Optional and non-repeating; can
	 * only be used if the &lt;TitlePrefix&gt; element is also present.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.TitleWithoutPrefix}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B031}<br/>
	 *        {@link org.editeur.onix.v30.references.TitleWithoutPrefix}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B031}<br/>
	 */
	TitleWithoutPrefix,

	/**
	 * The full text of the subtitle of the product, if any. “Subtitle” means any added words which appear with the title of the product and which amplify and
	 * explain the title, but which are not considered to be part of the distinctive title. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Subtitle}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B029}<br/>
	 *        {@link org.editeur.onix.v30.references.Subtitle}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B029}<br/>
	 */
	Subtitle,

	/**
	 * Title of a work from which the product is translated, without abbreviation or abridgement. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.TranslationOfTitle}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B032}<br/>
	 */
	TranslationOfTitle,

	/**
	 * A different title under which the work was previously published, without abbreviation or abridgement. Optional, and repeatable if the work has had more
	 * than one former title.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.FormerTitle}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B033}<br/>
	 */
	FormerTitle,

	/**
	 * An ONIX code indicating the type of a title. Mandatory in each occurrence of the &lt;Title&gt; composite, and non-repeating. Additional types of title
	 * can now be defined by adding code values without requiring a new ONIX release.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 15
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.TitleType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B202}<br/>
	 *        {@link org.editeur.onix.v30.references.TitleType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B202}<br/>
	 */
	TitleType,

	/**
	 * If the &lt;Title&gt; composite is used to carry an abbreviated title, the length to which the title is abbreviated may be indicated by giving the maximum
	 * number of characters (regardless of whether in each specific instance abbreviation has been required in order to meet this limit). The &lt;TitleType&gt;
	 * code should indicate the form of the title that has been abbreviated. Optional and non-repeating. If this element is present, the &lt;TitleText&gt;
	 * element must be used to carry the abbreviated form. [The option also exists to send an abbreviated title as a separate &lt;TitleType&gt; without using
	 * &lt;AbbreviatedLength&gt;, which is simpler, but less informative.]
	 * 
	 * @format
	 *         Variable-length integer, suggested maximum 3 digits
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.AbbreviatedLength}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B276}<br/>
	 */
	AbbreviatedLength,

	/**
	 * The text of the title specified by the &lt;TitleType&gt; code; and excluding the subtitle, if any. Optional and non-repeating: see text at the head of
	 * the &lt;Title&gt; composite for details of valid title text options. The &lt;TitleText&gt; element may carry any of the following ONIX attributes:
	 * textformat, language, transliteration, textcase.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.TitleText}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B203}<br/>
	 *        {@link org.editeur.onix.v30.references.TitleText}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B203}<br/>
	 */
	TitleText,

	/**
	 * A group of data elements which together define the identifier of a work which is manifested in the product described by an ONIX &lt;Product&gt; record.
	 * Optional and repeatable.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.WorkIdentifier}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Workidentifier}<br/>
	 *        {@link org.editeur.onix.v30.references.WorkIdentifier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Workidentifier}<br/>
	 */
	WorkIdentifier,

	/**
	 * An ONIX code identifying the scheme from which the identifier in &lt;IDValue&gt; is taken. Mandatory in each occurrence of the &lt;WorkIdentifier&gt;
	 * composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 2 numeric digits
	 * @codelist
	 *           List 16
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.WorkIDType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B201}<br/>
	 *        {@link org.editeur.onix.v30.references.WorkIDType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B201}<br/>
	 */
	WorkIDType,

	/**
	 * A repeatable group of data elements which together identify and provide pointers to a website which is related to the work identified in an occurrence of
	 * the &lt;WorkIdentifier&gt; composite.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Website}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Website}<br/>
	 *        {@link org.editeur.onix.v30.references.Website}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Website}<br/>
	 */
	Website,

	/**
	 * An ONIX code which identifies the role or purpose of the website which is linked through the &lt;WebsiteLink&gt; element. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 73
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.WebsiteRole}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B367}<br/>
	 *        {@link org.editeur.onix.v30.references.WebsiteRole}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B367}<br/>
	 */
	WebsiteRole,

	/**
	 * Free text describing the nature of the website which is linked through the &lt;WebsiteLink&gt; element. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters (XHTML is enabled in this element – see
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.WebsiteDescription}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B294}<br/>
	 *        {@link org.editeur.onix.v30.references.WebsiteDescription}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B294}<br/>
	 */
	WebsiteDescription,

	/**
	 * The URL for the website. Mandatory in each occurrence of the &lt;Website&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.WebsiteLink}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B295}<br/>
	 *        {@link org.editeur.onix.v30.references.WebsiteLink}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B295}<br/>
	 */
	WebsiteLink,

	/**
	 * An ONIX code identifying a thesis type, when the ONIX record describes an item which was originally presented as an academic thesis or dissertation.
	 * Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 2 numeric digits
	 * @codelist
	 *           List 72
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ThesisType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B368}<br/>
	 *        {@link org.editeur.onix.v30.references.ThesisType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B368}<br/>
	 */
	ThesisType,

	/**
	 * The name of an academic institution to which a thesis was presented. Optional and non-repeating, but if this element is present, &lt;ThesisType&gt; must
	 * also be present.
	 * 
	 * @format
	 *         Free text, suggested maximum length 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ThesisPresentedTo}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B369}<br/>
	 *        {@link org.editeur.onix.v30.references.ThesisPresentedTo}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B369}<br/>
	 */
	ThesisPresentedTo,

	/**
	 * The year in which a thesis was presented. Optional and non-repeating, but if this element is present, &lt;ThesisType&gt; must also be present.
	 * 
	 * @format
	 *         Fixed-length, four numeric digits
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ThesisYear}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B370}<br/>
	 *        {@link org.editeur.onix.v30.references.ThesisYear}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B370}<br/>
	 */
	ThesisYear,

	/**
	 * A number which specifies a single overall sequence of contributor names. Optional and non-repeating. There are two ways of approaching the sequencing of
	 * contributor names: by defining a single sequence across all contributors, which is the general ONIX practise; or by defining an individual sequence for
	 * each contributor role, using the element &lt;SequenceNumberWithinRole&gt; on the next page. Some applications require this more precise sequencing. Where
	 * it is not required, it is strongly recommended that each occurrence of the &lt;Contributor&gt; composite should carry an overall &lt;SequenceNumber&gt;.
	 * 
	 * @format
	 *         Variable-length integer, 1, 2, 3
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.SequenceNumber}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B034}<br/>
	 *        {@link org.editeur.onix.v30.references.SequenceNumber}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B034}<br/>
	 */
	SequenceNumber,

	/**
	 * An ONIX code indicating the role played by a person or corporate body in the creation of the product. Mandatory in each occurrence of a
	 * &lt;Contributor&gt; composite, and may be repeated if the same person or corporate body has more than one role in relation to the product. Note, however,
	 * that if the &lt;SequenceNumberWithinRole&gt; element is used to establish individual sequences of contributor names by role, the &lt;ContributorRole&gt;
	 * element must not be repeated. There must instead be separate occurrences of the &lt;Contributor&gt; composite if the same person has two or more roles.
	 * 
	 * @format
	 *         Fixed-length, one letter and two numeric digits
	 * @codelist
	 *           List 17
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ContributorRole}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B035}<br/>
	 *        {@link org.editeur.onix.v30.references.ContributorRole}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B035}<br/>
	 */
	ContributorRole,

	/**
	 * Used only when the &lt;ContributorRole&gt; code value is B06, B08 or B10 indicating a translator, to specify the language from which the translation was
	 * made. This makes it possible to specify a translator’s exact responsibility when a work involved translation from two or more languages. Optional and
	 * repeatable in the unlikely event that a single person has been responsible for translation from two or more languages.
	 * 
	 * @format
	 *         Fixed-length, three lower-case letters. Note that ISO 639 specifies that these codes should always be in lower-case.
	 * @codelist
	 *           ISO 639-2/B List 74
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.LanguageCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B252}<br/>
	 *        {@link org.editeur.onix.v30.references.LanguageCode}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B252}<br/>
	 */
	LanguageCode,

	/**
	 * A number which specifies the sequence of contributor names within a specified role, for applications which require this form of numbering. Optional and
	 * non-repeating.
	 * 
	 * @format
	 *         Variable-length integer, 1, 2, 3
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.SequenceNumberWithinRole}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B340}<br/>
	 */
	SequenceNumberWithinRole,

	/**
	 * The name of a person who contributed to the creation of the product, unstructured, and presented in normal order. Optional and non-repeating: see
	 * Group&nbsp;PR.8 introductory text for valid options.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.PersonName}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B036}<br/>
	 *        {@link org.editeur.onix.v30.references.PersonName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B036}<br/>
	 */
	PersonName,

	/**
	 * The name of a person who contributed to the creation of the product, presented in inverted order, with the element used for alphabetical sorting placed
	 * first. Optional and non-repeating: see Group&nbsp;PR.8 introductory text for valid options.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.PersonNameInverted}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B037}<br/>
	 *        {@link org.editeur.onix.v30.references.PersonNameInverted}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B037}<br/>
	 */
	PersonNameInverted,

	/**
	 * The first part of a structured name of a person who contributed to the creation of the product: qualifications and/or titles preceding a person’s names,
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.TitlesBeforeNames}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B038}<br/>
	 *        {@link org.editeur.onix.v30.references.TitlesBeforeNames}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B038}<br/>
	 */
	TitlesBeforeNames,

	/**
	 * The second part of a structured name of a person who contributed to the creation of the product: name(s) and/or initial(s) preceding a person’s key
	 * name(s),
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.NamesBeforeKey}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B039}<br/>
	 *        {@link org.editeur.onix.v30.references.NamesBeforeKey}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B039}<br/>
	 */
	NamesBeforeKey,

	/**
	 * The third part of a structured name of a person who contributed to the creation of the product: a prefix which precedes the key name(s) but which is not
	 * to be treated as part of the key name,
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.PrefixToKey}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B247}<br/>
	 *        {@link org.editeur.onix.v30.references.PrefixToKey}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B247}<br/>
	 */
	PrefixToKey,

	/**
	 * The fourth part of a structured name of a person who contributed to the creation of the product: key name(s),
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.KeyNames}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B040}<br/>
	 *        {@link org.editeur.onix.v30.references.KeyNames}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B040}<br/>
	 */
	KeyNames,

	/**
	 * The fifth part of a structured name of a person who contributed to the creation of the product: name suffix, or name(s) following a person’s key name(s),
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.NamesAfterKey}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B041}<br/>
	 *        {@link org.editeur.onix.v30.references.NamesAfterKey}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B041}<br/>
	 */
	NamesAfterKey,

	/**
	 * The sixth part of a structured name of a person who contributed to the creation of the product: a suffix following a person’s key name(s),
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.SuffixToKey}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B248}<br/>
	 *        {@link org.editeur.onix.v30.references.SuffixToKey}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B248}<br/>
	 */
	SuffixToKey,

	/**
	 * The seventh part of a structured name of a person who contributed to the creation of the product: qualifications and honors following a person’s names,
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.LettersAfterNames}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B042}<br/>
	 *        {@link org.editeur.onix.v30.references.LettersAfterNames}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B042}<br/>
	 */
	LettersAfterNames,

	/**
	 * The eighth part of a structured name of a person who contributed to the creation of the product: titles following a person’s names,
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.TitlesAfterNames}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B043}<br/>
	 *        {@link org.editeur.onix.v30.references.TitlesAfterNames}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B043}<br/>
	 */
	TitlesAfterNames,

	/**
	 * A repeatable group of data elements which together specify a party name identifier, used here to carry an identifier for a name given in an occurrence of
	 * the &lt;Contributor&gt; composite. Optional: see Group&nbsp;PR.8 introductory text for valid options.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.PersonNameIdentifier}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Personnameidentifier}<br/>
	 */
	PersonNameIdentifier,

	/**
	 * An ONIX code which identifies the scheme from which the value in the &lt;IDValue&gt; element is taken. Mandatory in each occurrence of the
	 * &lt;PersonNameIdentifier&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 101
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.PersonNameIDType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B390}<br/>
	 */
	PersonNameIDType,

	/**
	 * A repeatable group of data elements which together represent a personal name, and specify its type. The &lt;Name&gt; composite may be used to send
	 * alternate names for the same person,
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.Name}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Name}<br/>
	 */
	Name,

	/**
	 * An ONIX code indicating the type of the person name sent in an occurrence of the &lt;Name&gt; composite. Mandatory in each occurrence of the composite,
	 * and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 18
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.PersonNameType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B250}<br/>
	 */
	PersonNameType,

	/**
	 * A repeatable group of data elements which together specify a date associated with the person identified in an occurrence of the &lt;Contributor&gt;
	 * composite,
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.PersonDate}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Persondate}<br/>
	 */
	PersonDate,

	/**
	 * An ONIX code indicating the significance of the date in relation to the contributor name. Mandatory in each occurrence of the &lt;PersonDate&gt;
	 * composite.
	 * 
	 * @format
	 *         Fixed-length, three numeric digits
	 * @codelist
	 *           List 75
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.PersonDateRole}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B305}<br/>
	 */
	PersonDateRole,

	/**
	 * An ONIX code indicating the format in which the date is given in &lt;Date&gt;. Optional and non-repeating. When omitted, the format is assumed to be
	 * YYYYMMDD.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 55
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.DateFormat}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J260}<br/>
	 *        {@link org.editeur.onix.v30.references.DateFormat}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J260}<br/>
	 */
	DateFormat,

	/**
	 * The date specified in the &lt;PersonDateRole&gt; field. Mandatory in each occurrence of the &lt;PersonDate&gt; composite.
	 * 
	 * @format
	 *         As specified by the value in &lt;DateFormat&gt;: default YYYYMMDD
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Date}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B306}<br/>
	 *        {@link org.editeur.onix.v30.references.Date}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B306}<br/>
	 */
	Date,

	/**
	 * A professional position held by a contributor to the product at the time of its creation. Optional and non-repeating. May only occur with a person name,
	 * not with a corporate name.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ProfessionalPosition}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B045}<br/>
	 *        {@link org.editeur.onix.v30.references.ProfessionalPosition}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B045}<br/>
	 */
	ProfessionalPosition,

	/**
	 * An organisation to which a contributor to the product was affiliated at the time of its creation. Optional and non-repeating. May only occur with a
	 * person name, not with a corporate name.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Affiliation}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B046}<br/>
	 *        {@link org.editeur.onix.v30.references.Affiliation}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B046}<br/>
	 */
	Affiliation,

	/**
	 * A repeatable group of data elements which together identify a contributor’s professional position and/or affiliation, allowing multiple positions and
	 * affiliations to be specified.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ProfessionalAffiliation}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Professionalaffiliation}<br/>
	 *        {@link org.editeur.onix.v30.references.ProfessionalAffiliation}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Professionalaffiliation}<br/>
	 */
	ProfessionalAffiliation,

	/**
	 * The name of a corporate body which contributed to the creation of the product, unstructured. Optional and non-repeating: see Group&nbsp;PR.8 introductory
	 * text for valid options.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 200 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.CorporateName}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B047}<br/>
	 *        {@link org.editeur.onix.v30.references.CorporateName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B047}<br/>
	 */
	CorporateName,

	/**
	 * A biographical note about a contributor to the product. (See the &lt;OtherText&gt; composite in Group&nbsp;PR.15 for a biographical note covering all
	 * contributors to a product in a single text.) Optional and non-repeating. May occur with a person name or with a corporate name. A biographical note in
	 * ONIX should always contain the name of the person or body concerned, and it should always be presented as a piece of continuous text consisting of full
	 * sentences. Some recipients of ONIX data feeds will not accept text which has embedded URLs. A contributor website link can be sent using the
	 * &lt;Website&gt; composite on the next page.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 500 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.BiographicalNote}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B044}<br/>
	 *        {@link org.editeur.onix.v30.references.BiographicalNote}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B044}<br/>
	 */
	BiographicalNote,

	/**
	 * Brief text describing a contributor to the product, at the publisher’s discretion. Optional and non-repeating. It may be used with either a person or
	 * corporate name, to draw attention to any aspect of a contributor’s background which supports the promotion of the book.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 200 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ContributorDescription}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B048}<br/>
	 *        {@link org.editeur.onix.v30.references.ContributorDescription}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B048}<br/>
	 */
	ContributorDescription,

	/**
	 * An ONIX code allowing a positive indication to be given when authorship is unknown or anonymous, or when as a matter of editorial policy only a limited
	 * number of contributors are named. Optional and non-repeating: see Group&nbsp;PR.8 introductory text for valid options.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 19
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.UnnamedPersons}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B249}<br/>
	 *        {@link org.editeur.onix.v30.references.UnnamedPersons}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B249}<br/>
	 */
	UnnamedPersons,

	/**
	 * A code identifying a country with which a contributor is particularly associated, when this is significant for the marketing of a product. Optional and
	 * repeatable.
	 * 
	 * @format
	 *         Fixed-length, two letters. [Note that ISO 3166-1 specifies that country codes shall be sent as upper case only.]
	 * @codelist
	 *           ISO 3166-1 two-letter country codes
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.CountryCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B251}<br/>
	 *        {@link org.editeur.onix.v30.references.CountryCode}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B251}<br/>
	 */
	CountryCode,

	/**
	 * An ONIX code identifying a region with which a contributor is particularly associated, when this is significant for the marketing of a product. Optional
	 * and repeatable.
	 * 
	 * @format
	 *         Variable-length code, consisting of upper case letters with or without a hyphen, successive codes being separated by spaces. Suggested maximum
	 *         length 8 characters.
	 * @codelist
	 *           List 49
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.RegionCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B398}<br/>
	 *        {@link org.editeur.onix.v30.references.RegionCode}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B398}<br/>
	 */
	RegionCode,

	/**
	 * Free text showing how the authorship should be described in an online display, when a standard concatenation of individual contributor elements would not
	 * give a satisfactory presentation. When this field is sent, the receiver should use it to replace all name detail sent in the &lt;Contributor&gt;
	 * composite for display purposes only. It does not replace the &lt;BiographicalNote&gt; element. The individual name detail must also be sent in the
	 * &lt;Contributor&gt; composite for indexing and retrieval.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 1000 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ContributorStatement}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B049}<br/>
	 *        {@link org.editeur.onix.v30.references.ContributorStatement}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B049}<br/>
	 */
	ContributorStatement,

	/**
	 * An empty element that provides a positive indication that a product has no stated authorship. Intended to be used in an ONIX accreditation scheme to
	 * confirm that author information is being consistently supplied in publisher ONIX feeds. Optional and non-repeating. Must only be sent in a record that
	 * has no other elements from Group&nbsp;PR.8.
	 * 
	 * @format
	 *         XML empty element
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.NoContributor}<br/>
	 *        {@link org.editeur.onix.v21.shorts.N339}<br/>
	 *        {@link org.editeur.onix.v30.references.NoContributor}<br/>
	 *        {@link org.editeur.onix.v30.shorts.N339}<br/>
	 */
	NoContributor,

	/**
	 * Free text detailing all relevant information about a conference to which the product is related. If this element is sent, no other fields from
	 * Group&nbsp;PR.9 must be sent.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ConferenceDescription}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B050}<br/>
	 */
	ConferenceDescription,

	/**
	 * An ONIX code which indicates the relationship between the product and a conference to which it is related,
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 20
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ConferenceRole}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B051}<br/>
	 *        {@link org.editeur.onix.v30.references.ConferenceRole}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B051}<br/>
	 */
	ConferenceRole,

	/**
	 * The name of a conference or conference series to which the product is related. This element is mandatory unless the &lt;ConferenceDescription&gt; element
	 * or the &lt;Conference&gt; composite is used, and is non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 200 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ConferenceName}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B052}<br/>
	 *        {@link org.editeur.onix.v30.references.ConferenceName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B052}<br/>
	 */
	ConferenceName,

	/**
	 * The number of a conference to which the product is related, within a conference series. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length integer, suggested maximum length 4 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ConferenceNumber}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B053}<br/>
	 *        {@link org.editeur.onix.v30.references.ConferenceNumber}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B053}<br/>
	 */
	ConferenceNumber,

	/**
	 * The date of a conference to which the product is related. Optional and non-repeating.
	 * 
	 * @format
	 *         Date as year (YYYY) or month and year (YYYYMM).
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ConferenceDate}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B054}<br/>
	 *        {@link org.editeur.onix.v30.references.ConferenceDate}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B054}<br/>
	 */
	ConferenceDate,

	/**
	 * The place of a conference to which the product is related. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ConferencePlace}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B055}<br/>
	 *        {@link org.editeur.onix.v30.references.ConferencePlace}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B055}<br/>
	 */
	ConferencePlace,

	/**
	 * A group of data elements which together describe a conference to which the product is related. Repeatable if the product contains material from two or
	 * more conferences.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Conference}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Conference}<br/>
	 *        {@link org.editeur.onix.v30.references.Conference}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Conference}<br/>
	 */
	Conference,

	/**
	 * An acronym used as a short form of the name of a conference or conference series given in the &lt;ConferenceName&gt; element. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 20 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ConferenceAcronym}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B341}<br/>
	 *        {@link org.editeur.onix.v30.references.ConferenceAcronym}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B341}<br/>
	 */
	ConferenceAcronym,

	/**
	 * The thematic title of an individual conference in a series that has a series name in the &lt;ConferenceName&gt; element. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 200 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ConferenceTheme}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B342}<br/>
	 *        {@link org.editeur.onix.v30.references.ConferenceTheme}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B342}<br/>
	 */
	ConferenceTheme,

	/**
	 * A repeatable group of data elements which together identify a sponsor of a conference.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ConferenceSponsor}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Conferencesponsor}<br/>
	 *        {@link org.editeur.onix.v30.references.ConferenceSponsor}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Conferencesponsor}<br/>
	 */
	ConferenceSponsor,

	/**
	 * A repeatable group of data elements which together carry a coded identifier for a sponsor of a conference.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ConferenceSponsorIdentifier}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Conferencesponsoridentifier}<br/>
	 *        {@link org.editeur.onix.v30.references.ConferenceSponsorIdentifier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Conferencesponsoridentifier}<br/>
	 */
	ConferenceSponsorIdentifier,

	/**
	 * An ONIX code which identifies the scheme from which the value in the &lt;IDValue&gt; element is taken. Mandatory in each occurrence of the
	 * &lt;ConferenceSponsorIdentifier&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 44
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ConferenceSponsorIDType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B391}<br/>
	 *        {@link org.editeur.onix.v30.references.ConferenceSponsorIDType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B391}<br/>
	 */
	ConferenceSponsorIDType,

	/**
	 * An ONIX code, indicating the type of a version or edition. Optional, and repeatable if the product has characteristics of two or more types (
	 * 
	 * @format
	 *         Fixed-length, three upper-case letters
	 * @codelist
	 *           List 21
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.EditionTypeCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B056}<br/>
	 */
	EditionTypeCode,

	/**
	 * The number of a numbered edition. Optional and non-repeating. Normally sent only for the second and subsequent editions of a work, but by agreement
	 * between parties to an ONIX exchange a first edition may be explicitly numbered.
	 * 
	 * @format
	 *         Variable-length integer, suggested maximum length 4 digits.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.EditionNumber}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B057}<br/>
	 *        {@link org.editeur.onix.v30.references.EditionNumber}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B057}<br/>
	 */
	EditionNumber,

	/**
	 * The number of a numbered revision within an edition number. To be used only where a publisher uses such two-level numbering to indicate revisions which
	 * do not constitute a new edition under a new ISBN or other distinctive product identifier. Optional and non-repeating. If this field is used, an
	 * &lt;EditionNumber&gt; must also be present.
	 * 
	 * @format
	 *         Free form, suggested maximum length 20 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.EditionVersionNumber}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B217}<br/>
	 *        {@link org.editeur.onix.v30.references.EditionVersionNumber}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B217}<br/>
	 */
	EditionVersionNumber,

	/**
	 * A short free-text description of a version or edition. Optional and non-repeating. When used, the &lt;EditionStatement&gt; must carry a complete
	 * description of the nature of the edition,
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.EditionStatement}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B058}<br/>
	 *        {@link org.editeur.onix.v30.references.EditionStatement}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B058}<br/>
	 */
	EditionStatement,

	/**
	 * An empty element that provides a positive indication that a product does not carry any edition information. Intended to be used an ONIX accreditation
	 * scheme to confirm that edition information is being consistently supplied in publisher ONIX feeds. Optional and non-repeating. Must only be sent in a
	 * record that has no instances of any of the four preceding Edition elements.
	 * 
	 * @format
	 *         XML empty element
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.NoEdition}<br/>
	 *        {@link org.editeur.onix.v21.shorts.N386}<br/>
	 *        {@link org.editeur.onix.v30.references.NoEdition}<br/>
	 *        {@link org.editeur.onix.v30.shorts.N386}<br/>
	 */
	NoEdition,

	/**
	 * An optional, non-repeating, group of data elements which together describe features of the content of an edition of a religious text, and intended to
	 * meet the special needs of religious publishers and booksellers. The &lt;ReligiousText&gt; composite may carry either a &lt;Bible&gt; composite or a
	 * &lt;ReligiousTextID&gt; element accompanied by multiple repeats of the &lt;ReligiousTextFeature&gt; composite. This approach is adopted to enable other
	 * devotional texts to be included if need arises without requiring a new ONIX release.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ReligiousText}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Religioustext}<br/>
	 *        {@link org.editeur.onix.v30.references.ReligiousText}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Religioustext}<br/>
	 */
	ReligiousText,

	/**
	 * A group of data elements which together describe features of an edition of the Bible or of a selected Biblical text. Mandatory in each occurrence of the
	 * &lt;ReligiousText&gt; composite that does not include a &lt;ReligiousTextID&gt; element, and non-repeating.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Bible}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Bible}<br/>
	 *        {@link org.editeur.onix.v30.references.Bible}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Bible}<br/>
	 */
	Bible,

	/**
	 * An ONIX code indicating the content of an edition of the Bible or selected Biblical text, for example New Testament, Apocrypha, Pentateuch. Mandatory in
	 * each occurrence of the &lt;Bible&gt; composite, and repeatable so that a list such as Old Testament and Apocrypha can be expressed.
	 * 
	 * @format
	 *         Fixed-length, two letters
	 * @codelist
	 *           List 82
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.BibleContents}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B352}<br/>
	 *        {@link org.editeur.onix.v30.references.BibleContents}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B352}<br/>
	 */
	BibleContents,

	/**
	 * An ONIX code indicating the version of a Bible or selected Biblical text, for example King James, Jerusalem, New American Standard, Reina Valera.
	 * Mandatory in each occurrence of the &lt;Bible&gt; composite, and repeatable if a work includes text in two or more versions.
	 * 
	 * @format
	 *         Fixed-length, three letters
	 * @codelist
	 *           List 83
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.BibleVersion}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B353}<br/>
	 *        {@link org.editeur.onix.v30.references.BibleVersion}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B353}<br/>
	 */
	BibleVersion,

	/**
	 * An ONIX code identifying a particular study version of a Bible or selected Biblical text, for example Life Application. Optional and non-repeating. Some
	 * study Bibles are available in different editions based on different text versions.
	 * 
	 * @format
	 *         Fixed-length, three letters
	 * @codelist
	 *           List 84
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.StudyBibleType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B389}<br/>
	 *        {@link org.editeur.onix.v30.references.StudyBibleType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B389}<br/>
	 */
	StudyBibleType,

	/**
	 * An ONIX code indicating the purpose for which a Bible or selected Biblical text is intended, for example Family, Lectern/pulpit. Optional and repeatable.
	 * 
	 * @format
	 *         Fixed-length, two letters
	 * @codelist
	 *           List 85
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.BiblePurpose}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B354}<br/>
	 *        {@link org.editeur.onix.v30.references.BiblePurpose}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B354}<br/>
	 */
	BiblePurpose,

	/**
	 * An ONIX code indicating the way in which the content of a Bible or selected Biblical text is organized, for example Chronological, Chain reference.
	 * Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, three letters
	 * @codelist
	 *           List 86
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.BibleTextOrganization}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B355}<br/>
	 *        {@link org.editeur.onix.v30.references.BibleTextOrganization}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B355}<br/>
	 */
	BibleTextOrganization,

	/**
	 * An ONIX code indicating where references are located as part of the content of a Bible or selected Biblical text, for example Center column. Optional and
	 * non-repeating.
	 * 
	 * @format
	 *         Fixed-length, three letters
	 * @codelist
	 *           List 87
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.BibleReferenceLocation}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B356}<br/>
	 *        {@link org.editeur.onix.v30.references.BibleReferenceLocation}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B356}<br/>
	 */
	BibleReferenceLocation,

	/**
	 * An ONIX code specifying a feature of a Bible text not covered elsewhere,
	 * 
	 * @format
	 *         Fixed-length, two letters
	 * @codelist
	 *           List 97
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.BibleTextFeature}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B357}<br/>
	 *        {@link org.editeur.onix.v30.references.BibleTextFeature}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B357}<br/>
	 */
	BibleTextFeature,

	/**
	 * An ONIX code indicating a religious text other than the Bible. Mandatory in each occurrence of the &lt;ReligiousText&gt; composite that does not include
	 * a &lt;Bible&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 88
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ReligiousTextID}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B376}<br/>
	 */
	ReligiousTextID,

	/**
	 * A repeatable group of data elements which together specify and describe a feature of a religious text.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ReligiousTextFeature}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Religioustextfeature}<br/>
	 *        {@link org.editeur.onix.v30.references.ReligiousTextFeature}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Religioustextfeature}<br/>
	 */
	ReligiousTextFeature,

	/**
	 * An ONIX code specifying a feature described in the associated &lt;ReligiousTextFeatureCode&gt; element. Mandatory in each occurrence of the
	 * &lt;ReligiousTextFeature&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, to be confirmed
	 * @codelist
	 *           List 89
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ReligiousTextFeatureType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B358}<br/>
	 *        {@link org.editeur.onix.v30.references.ReligiousTextFeatureType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B358}<br/>
	 */
	ReligiousTextFeatureType,

	/**
	 * An ONIX code describing a feature specified in the associated &lt;ReligiousTextFeatureType&gt; element. Mandatory in each occurrence of the
	 * &lt;ReligiousTextFeature&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, to be confirmed
	 * @codelist
	 *           List 90
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ReligiousTextFeatureCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B359}<br/>
	 *        {@link org.editeur.onix.v30.references.ReligiousTextFeatureCode}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B359}<br/>
	 */
	ReligiousTextFeatureCode,

	/**
	 * Free text describing a feature that is not adequately defined by code values alone. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ReligiousTextFeatureDescription}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B360}<br/>
	 *        {@link org.editeur.onix.v30.references.ReligiousTextFeatureDescription}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B360}<br/>
	 */
	ReligiousTextFeatureDescription,

	/**
	 * A code indicating a language in which the text of the product is written: optional, and repeatable if the text is in two or more languages.
	 * 
	 * @format
	 *         Fixed-length, three lower-case letters. Note that ISO 639 specifies that these codes should always be in lower-case.
	 * @codelist
	 *           ISO 639-2/B List 74
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.LanguageOfText}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B059}<br/>
	 */
	LanguageOfText,

	/**
	 * A code indicating the language from which the text of the product was translated. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, three lower-case letters.
	 * @codelist
	 *           ISO 639-2/B List 74
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.OriginalLanguage}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B060}<br/>
	 */
	OriginalLanguage,

	/**
	 * A repeatable group of data elements which together represent a language, and specify its role and, where required, whether it is a country variant.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Language}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Language}<br/>
	 *        {@link org.editeur.onix.v30.references.Language}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Language}<br/>
	 */
	Language,

	/**
	 * An ONIX code indicating the “role” of a language in the context of the ONIX record. Mandatory in each occurrence of the &lt;Language&gt; composite, and
	 * non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 22
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.LanguageRole}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B253}<br/>
	 *        {@link org.editeur.onix.v30.references.LanguageRole}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B253}<br/>
	 */
	LanguageRole,

	/**
	 * An indication of the total number of pages in a book or other printed product. This is not intended to represent a precise count of numbered and
	 * unnumbered pages. It is usually sufficient to take the number from the last numbered page. If there are two or more separate numbering sequences (
	 * 
	 * @format
	 *         Variable length integer, suggested maximum length 6 digits.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.NumberOfPages}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B061}<br/>
	 *        {@link org.editeur.onix.v30.references.NumberOfPages}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B061}<br/>
	 */
	NumberOfPages,

	/**
	 * The number of pages numbered in roman numerals. The &lt;PagesRoman&gt; and &lt;PagesArabic&gt; elements together represent an alternative to
	 * &lt;NumberOfPages&gt; where there is a requirement to specify these numbering sequences separately. For most ONIX applications, however,
	 * &lt;NumberOfPages&gt; will be preferred. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable length alphabetic, suggested maximum length 10 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.PagesRoman}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B254}<br/>
	 */
	PagesRoman,

	/**
	 * The number of pages numbered in Arabic numerals. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable length numeric, suggested maximum length 6 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.PagesArabic}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B255}<br/>
	 */
	PagesArabic,

	/**
	 * A repeatable group of data elements which together describe an extent pertaining to the product.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Extent}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Extent}<br/>
	 *        {@link org.editeur.onix.v30.references.Extent}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Extent}<br/>
	 */
	Extent,

	/**
	 * An ONIX code which identifies the type of extent carried in the composite,
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 23
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ExtentType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B218}<br/>
	 *        {@link org.editeur.onix.v30.references.ExtentType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B218}<br/>
	 */
	ExtentType,

	/**
	 * The numeric value of the extent specified in &lt;ExtentType&gt;. Mandatory in each occurrence of the &lt;Extent&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Numeric, with decimal point where required, as specified in field PR.12.4
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ExtentValue}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B219}<br/>
	 *        {@link org.editeur.onix.v30.references.ExtentValue}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B219}<br/>
	 */
	ExtentValue,

	/**
	 * An ONIX code indicating the unit used for the &lt;ExtentValue&gt; and the format in which the value is presented. Mandatory in each occurrence of the
	 * &lt;Extent&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 24
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ExtentUnit}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B220}<br/>
	 *        {@link org.editeur.onix.v30.references.ExtentUnit}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B220}<br/>
	 */
	ExtentUnit,

	/**
	 * The total number of illustrations in a book or other printed product. The more informative free text field &lt;IllustrationsNote&gt; or the
	 * &lt;Illustrations&gt; composite are preferred, but where the sender of the product information maintains only a simple numeric field, the
	 * &lt;NumberOfIllustrations&gt; element may be used. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable length integer, suggested maximum length 6 digits.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.NumberOfIllustrations}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B125}<br/>
	 *        {@link org.editeur.onix.v30.references.NumberOfIllustrations}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B125}<br/>
	 */
	NumberOfIllustrations,

	/**
	 * For books or other text media only, this data element carries text stating the number and type of illustrations. The text may also include other content
	 * items,
	 * 
	 * @format
	 *         Variable length text, suggested maximum length 200 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.IllustrationsNote}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B062}<br/>
	 *        {@link org.editeur.onix.v30.references.IllustrationsNote}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B062}<br/>
	 */
	IllustrationsNote,

	/**
	 * A repeatable group of data elements which together specify the number of illustrations or other content items of a stated type which the product carries.
	 * Use of the &lt;Illustrations&gt; composite is optional.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.Illustrations}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Illustrations}<br/>
	 */
	Illustrations,

	/**
	 * An ONIX code which identifies the type of illustration or other content to which an occurrence of the composite refers. Mandatory in each occurrence of
	 * the &lt;Illustrations&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 25
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.IllustrationType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B256}<br/>
	 */
	IllustrationType,

	/**
	 * Text describing the type of illustration or other content to which an occurrence of the composite refers, when a code is insufficient. Optional and
	 * non-repeating. Required when &lt;IllustrationType&gt; carries the value 00.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.IllustrationTypeDescription}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B361}<br/>
	 */
	IllustrationTypeDescription,

	/**
	 * The number of illustrations or other content items of the type specified in &lt;IllustrationType&gt;. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length integer, suggested maximum length 6 digits.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Number}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B257}<br/>
	 *        {@link org.editeur.onix.v30.references.Number}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B257}<br/>
	 */
	Number,

	/**
	 * The scale of a map, expressed as a ratio 1:nnnnn; only the number nnnnn is carried in the data element, without spaces or punctuation. Optional, and
	 * repeatable if the product comprises maps with two or more different scales.
	 * 
	 * @format
	 *         Variable length integer, suggested maximum length 6 digits.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.MapScale}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B063}<br/>
	 *        {@link org.editeur.onix.v30.references.MapScale}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B063}<br/>
	 */
	MapScale,

	/**
	 * A BISAC subject category code which identifies the main subject of the product. Optional and non-repeating. Additional BISAC subject category codes may
	 * be sent using the &lt;Subject&gt; composite.
	 * 
	 * @format
	 *         Fixed-length, three upper-case letters and six numeric digits.
	 * @codelist
	 *           BISAC Subject Heading Codes. Please contact info@bisg.org for details, or check the BISG website at
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.BASICMainSubject}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B064}<br/>
	 */
	BASICMainSubject,

	/**
	 * A number identifying the version of the BISAC subject categories used in &lt;BASICMainSubject&gt;. Optional and non-repeating, and may only occur when
	 * &lt;BASICMainSubject&gt; is also present.
	 * 
	 * @format
	 *         Free form – in practise expected to be an integer or a decimal number such as “2.01”. Suggested maximum length 10 characters, for consistency
	 *         with other version number elements.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.BASICVersion}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B200}<br/>
	 */
	BASICVersion,

	/**
	 * A BIC subject category code which identifies the main subject of the product. Optional and non-repeating. Additional BIC subject category codes may be
	 * sent using the &lt;Subject&gt; composite.
	 * 
	 * @format
	 *         Variable-length alphanumeric, suggested maximum length 10 characters to allow for expansion.
	 * @codelist
	 *           BIC Subject Category Codes. Available for downloading from
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.BICMainSubject}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B065}<br/>
	 */
	BICMainSubject,

	/**
	 * A number identifying the version of the BIC subject category scheme used in &lt;BICMainSubject&gt;. Optional and non-repeating, and may only occur when
	 * &lt;BICMainSubject&gt; is also present.
	 * 
	 * @format
	 *         Free form – in practise expected to be an integer. Suggested maximum length 10 characters, for consistency with other version number elements.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.BICVersion}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B066}<br/>
	 */
	BICVersion,

	/**
	 * An optional and repeatable group of data elements which together describe a main subject classification or subject heading which is taken from a
	 * recognized scheme other than BISAC or BIC.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.MainSubject}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Mainsubject}<br/>
	 *        {@link org.editeur.onix.v30.references.MainSubject}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X425}<br/>
	 */
	MainSubject,

	/**
	 * An ONIX code which identifies a subject scheme which is designated for use in a &lt;MainSubject&gt; composite. Mandatory in each occurrence of the
	 * composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 26
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.MainSubjectSchemeIdentifier}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B191}<br/>
	 */
	MainSubjectSchemeIdentifier,

	/**
	 * A number which identifies a version or edition of the subject scheme specified in the associated &lt;MainSubjectSchemeIdentifier&gt; element. Optional
	 * and non-repeating.
	 * 
	 * @format
	 *         Free form. Suggested maximum length 10 characters, for consistency with other version number elements.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.SubjectSchemeVersion}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B068}<br/>
	 *        {@link org.editeur.onix.v30.references.SubjectSchemeVersion}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B068}<br/>
	 */
	SubjectSchemeVersion,

	/**
	 * A subject class or category code from the scheme specified in the &lt;MainSubjectSchemeIdentifier&gt; element. Either &lt;SubjectCode&gt; or
	 * &lt;SubjectHeadingText&gt; or both must be present in each occurrence of the &lt;MainSubject&gt; composite. Non-repeating.
	 * 
	 * @format
	 *         Variable-length, alphanumeric, suggested maximum length 20 characters.
	 * @codelist
	 *           The scheme specified in &lt;MainSubjectSchemeIdentifier&gt;
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.SubjectCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B069}<br/>
	 *        {@link org.editeur.onix.v30.references.SubjectCode}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B069}<br/>
	 */
	SubjectCode,

	/**
	 * The text of a heading taken from the scheme specified in the &lt;MainSubjectSchemeIdentifier&gt; element; or the text equivalent to the
	 * &lt;SubjectCode&gt; value, if both code and text are sent. Either &lt;SubjectCode&gt; or &lt;SubjectHeadingText&gt; or both must be present in each
	 * occurrence of the &lt;MainSubject&gt; composite. Non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.SubjectHeadingText}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B070}<br/>
	 *        {@link org.editeur.onix.v30.references.SubjectHeadingText}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B070}<br/>
	 */
	SubjectHeadingText,

	/**
	 * An optional and repeatable group of data elements which together describe a subject classification or subject heading which is additional to the BISAC,
	 * BIC or other main subject category.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Subject}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Subject}<br/>
	 *        {@link org.editeur.onix.v30.references.Subject}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Subject}<br/>
	 */
	Subject,

	/**
	 * An ONIX code which identifies the subject scheme which is used in an occurrence of the &lt;Subject&gt; composite. Mandatory in each occurrence of the
	 * composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 27
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.SubjectSchemeIdentifier}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B067}<br/>
	 *        {@link org.editeur.onix.v30.references.SubjectSchemeIdentifier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B067}<br/>
	 */
	SubjectSchemeIdentifier,

	/**
	 * A name identifying a proprietary subject scheme when &lt;SubjectSchemeIdentifier&gt; is coded “24”. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.SubjectSchemeName}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B171}<br/>
	 *        {@link org.editeur.onix.v30.references.SubjectSchemeName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B171}<br/>
	 */
	SubjectSchemeName,

	/**
	 * An optional and repeatable group of data elements which together represent the name of a person who is part of the subject of a product.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.PersonAsSubject}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Personassubject}<br/>
	 */
	PersonAsSubject,

	/**
	 * The name of a corporate body which is part of the subject of the product. Optional, and repeatable if more than one corporate body is involved.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum 200 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.CorporateBodyAsSubject}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B071}<br/>
	 */
	CorporateBodyAsSubject,

	/**
	 * The name of a place or region or geographical entity which is part of the subject of the product. Optional, and repeatable if the subject of the product
	 * includes more than one place.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum 100 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.PlaceAsSubject}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B072}<br/>
	 */
	PlaceAsSubject,

	/**
	 * An ONIX code, derived from BISAC and BIC lists, which identifies the broad audience or readership for whom a product is intended. Optional, and
	 * repeatable if the product is intended for two or more groups.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 28
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.AudienceCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B073}<br/>
	 *        {@link org.editeur.onix.v30.references.AudienceCode}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B073}<br/>
	 */
	AudienceCode,

	/**
	 * A repeatable group of data elements which together describe an audience to which the product is directed.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Audience}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Audience}<br/>
	 *        {@link org.editeur.onix.v30.references.Audience}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Audience}<br/>
	 */
	Audience,

	/**
	 * An ONIX code which identifies the scheme from which the code in &lt;AudienceCodeValue&gt; is taken. Mandatory in each occurrence of the &lt;Audience&gt;
	 * composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 29
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.AudienceCodeType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B204}<br/>
	 *        {@link org.editeur.onix.v30.references.AudienceCodeType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B204}<br/>
	 */
	AudienceCodeType,

	/**
	 * A name which identifies a proprietary audience code when the code in &lt;AudienceCodeType&gt; indicates a proprietary scheme,
	 * 
	 * @format
	 *         Free text, suggested maximum length 50 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.AudienceCodeTypeName}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B205}<br/>
	 *        {@link org.editeur.onix.v30.references.AudienceCodeTypeName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B205}<br/>
	 */
	AudienceCodeTypeName,

	/**
	 * A code value taken from the scheme specified in &lt;AudienceCodeType&gt;. Mandatory in each occurrence of the &lt;Audience&gt; composite, and
	 * non-repeating.
	 * 
	 * @format
	 *         Determined by the scheme specified in &lt;AudienceCodeType&gt;.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.AudienceCodeValue}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B206}<br/>
	 *        {@link org.editeur.onix.v30.references.AudienceCodeValue}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B206}<br/>
	 */
	AudienceCodeValue,

	/**
	 * A text element specifying a US school Grade or range of Grades, which should be entered strictly according to the conventions defined below. Optional and
	 * non-repeating.
	 * 
	 * @format
	 *         Variable length text, maximum 15 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.USSchoolGrade}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B189}<br/>
	 */
	USSchoolGrade,

	/**
	 * A text element specifying a target interest age of range of ages. which should be entered strictly according to the conventions defined below. Optional
	 * and non-repeating.
	 * 
	 * @format
	 *         Variable length text, maximum 15 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.InterestAge}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B190}<br/>
	 */
	InterestAge,

	/**
	 * An optional and repeatable group of data elements which together describe an audience or readership range for which a product is intended. The composite
	 * can carry a single value from, to, or exact, or a pair of values with an explicit from and to. See examples below.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.AudienceRange}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Audiencerange}<br/>
	 *        {@link org.editeur.onix.v30.references.AudienceRange}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Audiencerange}<br/>
	 */
	AudienceRange,

	/**
	 * An ONIX code specifying the attribute (age, school grade
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 30
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.AudienceRangeQualifier}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B074}<br/>
	 *        {@link org.editeur.onix.v30.references.AudienceRangeQualifier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B074}<br/>
	 */
	AudienceRangeQualifier,

	/**
	 * An ONIX code specifying the “precision” of the value in the &lt;AudienceRangeValue&gt; element which follows (From, To, Exact). Mandatory in each
	 * occurrence of the &lt;AudienceRange&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 31
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.AudienceRangePrecision}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B075}<br/>
	 *        {@link org.editeur.onix.v30.references.AudienceRangePrecision}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B075}<br/>
	 */
	AudienceRangePrecision,

	/**
	 * A value indicating an exact position within a range, or the upper or lower end of a range.
	 * 
	 * @format
	 *         Variable-length string, suggested maximum 10 characters. (This element was previously defined as a variable-length integer, but its definition is
	 *         extended in ONIX 2.1 to enable certain non-numeric values to be carried. For values that BISAC has defined for US school grades and pre-school
	 *         levels, see
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.AudienceRangeValue}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B076}<br/>
	 *        {@link org.editeur.onix.v30.references.AudienceRangeValue}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B076}<br/>
	 */
	AudienceRangeValue,

	/**
	 * Free text describing the audience for which a product is intended. Optional and non-repeating.
	 * 
	 * @format
	 *         Free text, suggested maximum length 1000 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.AudienceDescription}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B207}<br/>
	 *        {@link org.editeur.onix.v30.references.AudienceDescription}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B207}<br/>
	 */
	AudienceDescription,

	/**
	 * An optional and repeatable group of data elements which together describe the level of complexity of a text.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Complexity}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Complexity}<br/>
	 *        {@link org.editeur.onix.v30.references.Complexity}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Complexity}<br/>
	 */
	Complexity,

	/**
	 * An ONIX code specifying the scheme from which the value in &lt;ComplexityCode&gt; is taken.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 32
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ComplexitySchemeIdentifier}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B077}<br/>
	 *        {@link org.editeur.onix.v30.references.ComplexitySchemeIdentifier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B077}<br/>
	 */
	ComplexitySchemeIdentifier,

	/**
	 * A code specifying the level of complexity of a text.
	 * 
	 * @format
	 *         Variable-length, alphanumeric, suggested maximum length 20 characters.
	 * @codelist
	 *           The scheme specified in the &lt;ComplexitySchemeIdentifier&gt; element
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ComplexityCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B078}<br/>
	 *        {@link org.editeur.onix.v30.references.ComplexityCode}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B078}<br/>
	 */
	ComplexityCode,

	/**
	 * A brief descriptive paragraph about the product, length strictly limited to 350 characters. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, maximum 350 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.Annotation}<br/>
	 *        {@link org.editeur.onix.v21.shorts.D100}<br/>
	 */
	Annotation,

	/**
	 * Descriptive text about the product, audience unspecified. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum 2,000 characters (XHTML is enabled in this element – see
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.MainDescription}<br/>
	 *        {@link org.editeur.onix.v21.shorts.D101}<br/>
	 */
	MainDescription,

	/**
	 * An optional and repeatable group of data elements which together identify and either include, or provide pointers to, text related to the product.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.OtherText}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Othertext}<br/>
	 */
	OtherText,

	/**
	 * An ONIX code which identifies the type of text which is sent in the &lt;Text&gt; element, or referenced in the &lt;TextLink&gt; element. Mandatory in
	 * each occurrence of the &lt;OtherText&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two characters (initially allocated as 01, 02
	 * @codelist
	 *           List 33
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.TextTypeCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.D102}<br/>
	 */
	TextTypeCode,

	/**
	 * An ONIX code which identifies the format of text which is sent in the &lt;Text&gt; element, or referenced in the &lt;TextLink&gt; element. Optional and
	 * non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 34
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.TextFormat}<br/>
	 *        {@link org.editeur.onix.v21.shorts.D103}<br/>
	 */
	TextFormat,

	/**
	 * The text specified in the &lt;TextTypeCode&gt; element, if it is suitable to be sent in full as part of the ONIX record. Either the &lt;Text&gt; element
	 * or both of the &lt;TextLinkType&gt; and &lt;TextLink&gt; elements must be present in any occurrence of the &lt;OtherText&gt; composite. Non-repeating.
	 * 
	 * @format
	 *         Variable length text (XHTML is enabled in this element – see
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Text}<br/>
	 *        {@link org.editeur.onix.v21.shorts.D104}<br/>
	 *        {@link org.editeur.onix.v30.references.Text}<br/>
	 *        {@link org.editeur.onix.v30.shorts.D104}<br/>
	 */
	Text,

	/**
	 * An ONIX code which identifies the type of link which is given in the &lt;TextLink&gt; element.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 35
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.TextLinkType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.D105}<br/>
	 */
	TextLinkType,

	/**
	 * A link to the text item specified in the &lt;TextTypeCode&gt; element, using the link type specified in &lt;TextLinkType&gt;.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.TextLink}<br/>
	 *        {@link org.editeur.onix.v21.shorts.D106}<br/>
	 */
	TextLink,

	/**
	 * The name of the author of text sent in the &lt;Text&gt; element, or referenced in the &lt;TextLink&gt; element,
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.TextAuthor}<br/>
	 *        {@link org.editeur.onix.v21.shorts.D107}<br/>
	 *        {@link org.editeur.onix.v30.references.TextAuthor}<br/>
	 *        {@link org.editeur.onix.v30.shorts.D107}<br/>
	 */
	TextAuthor,

	/**
	 * The name of a company or corporate body responsible for the text sent in the &lt;Text&gt; element, or referenced in the &lt;TextLink&gt; element,
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 200 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.TextSourceCorporate}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B374}<br/>
	 *        {@link org.editeur.onix.v30.references.TextSourceCorporate}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B374}<br/>
	 */
	TextSourceCorporate,

	/**
	 * The title of a publication from which the text sent in the &lt;Text&gt; element, or referenced in the &lt;TextLink&gt; element, was taken,
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.TextSourceTitle}<br/>
	 *        {@link org.editeur.onix.v21.shorts.D108}<br/>
	 */
	TextSourceTitle,

	/**
	 * The date on which text sent in the &lt;Text&gt; element, or referenced in the &lt;TextLink&gt; element, was published. Optional and non-repeating.
	 * 
	 * @format
	 *         Date as four, six or eight digits (YYYY, YYYYMM, YYYYMMDD)
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.TextPublicationDate}<br/>
	 *        {@link org.editeur.onix.v21.shorts.D109}<br/>
	 */
	TextPublicationDate,

	/**
	 * The date from which text sent in the &lt;Text&gt; element, or referenced in the &lt;TextLink&gt; element, is intended to be used,
	 * 
	 * @format
	 *         Fixed-length, 8 numeric digits, YYYYMMDD
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.StartDate}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B324}<br/>
	 *        {@link org.editeur.onix.v30.references.StartDate}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B324}<br/>
	 */
	StartDate,

	/**
	 * The date until which text sent in the &lt;Text&gt; element, or referenced in the &lt;TextLink&gt; element, is intended to be used,
	 * 
	 * @format
	 *         Fixed-length, 8 numeric digits, YYYYMMDD
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.EndDate}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B325}<br/>
	 *        {@link org.editeur.onix.v30.references.EndDate}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B325}<br/>
	 */
	EndDate,

	/**
	 * A free text excerpt from a review. Optional and repeatable. At the end of the text of the quote, the authorship, source title, and date (if known) should
	 * always be included.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 500 characters (XHTML is enabled in this element – see
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ReviewQuote}<br/>
	 *        {@link org.editeur.onix.v21.shorts.E110}<br/>
	 */
	ReviewQuote,

	/**
	 * An ONIX code which specifies the image file format used for the front cover image. JPEG, GIF and TIF are supported. The data element group consisting of
	 * &lt;CoverImageFormatCode&gt;, &lt;CoverImageLinkTypeCode&gt;, and &lt;CoverImageLink&gt; is optional and non-repeating, but if any one of the three
	 * elements is present, all three must be present.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 36
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.CoverImageFormatCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.F111}<br/>
	 */
	CoverImageFormatCode,

	/**
	 * An ONIX code which identifies the type of link which is given in &lt;CoverImageLink&gt;.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 37
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.CoverImageLinkTypeCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.F112}<br/>
	 */
	CoverImageLinkTypeCode,

	/**
	 * A link to a front cover image file, using the link type specified in &lt;CoverImageLinkTypeCode&gt;.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.CoverImageLink}<br/>
	 *        {@link org.editeur.onix.v21.shorts.F113}<br/>
	 */
	CoverImageLink,

	/**
	 * A repeatable group of data elements which together identify and provide pointers to, an image, audio or video file related to the product.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.MediaFile}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Mediafile}<br/>
	 */
	MediaFile,

	/**
	 * An ONIX code which identifies the type of image/audio/video file which is linked by the &lt;MediaFileLink&gt; element. Mandatory in each occurrence of
	 * the &lt;MediaFile&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two characters (initially allocated as 01, 02
	 * @codelist
	 *           List 38
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.MediaFileTypeCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.F114}<br/>
	 */
	MediaFileTypeCode,

	/**
	 * An ONIX code which identifies the format of the image/audio/video file which is linked by the &lt;MediaFileLink&gt; element. For image files, JPEG, GIF
	 * and TIF are supported. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 39
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.MediaFileFormatCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.F115}<br/>
	 */
	MediaFileFormatCode,

	/**
	 * The resolution of an image file which is linked by the &lt;MediaFileLink&gt; element, expressed as dots or pixels per inch. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length integer, suggested maximum length 6 digits
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ImageResolution}<br/>
	 *        {@link org.editeur.onix.v21.shorts.F259}<br/>
	 */
	ImageResolution,

	/**
	 * An ONIX code which identifies the type of link which is given in the &lt;MediaFileLink&gt; element, for example a URL, DOI, filename
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 40
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.MediaFileLinkTypeCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.F116}<br/>
	 */
	MediaFileLinkTypeCode,

	/**
	 * A link to the image/audio/video file specified by the &lt;MediaFileTypeCode&gt;, using the link type specified by the &lt;MediaFileLinkTypeCode&gt;.
	 * Mandatory in each occurrence of the &lt;MediaFile&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.MediaFileLink}<br/>
	 *        {@link org.editeur.onix.v21.shorts.F117}<br/>
	 */
	MediaFileLink,

	/**
	 * Unstructured text associated with a file which is available for download, and intended to be displayed whenever the file content is used. Optional and
	 * non-repeating. Text may include credits, copyright notice,
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 1,000 characters (XHTML is enabled in this element – see
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.TextWithDownload}<br/>
	 *        {@link org.editeur.onix.v21.shorts.F118}<br/>
	 */
	TextWithDownload,

	/**
	 * Text of a caption associated with a download file, and intended to be displayed whenever the file content is used. Optional and non-repeating. The
	 * &lt;DownloadCaption&gt; element may be sent together with either or both of fields &lt;DownloadCredit&gt;, or &lt;DownloadCopyrightNotice&gt;.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 500 characters (XHTML is enabled in this element – see
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.DownloadCaption}<br/>
	 *        {@link org.editeur.onix.v21.shorts.F119}<br/>
	 */
	DownloadCaption,

	/**
	 * Text of a personal or corporate credit associated with a download file, and intended to be displayed whenever the file content is used. Optional and
	 * non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters (XHTML is enabled in this element – see
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.DownloadCredit}<br/>
	 *        {@link org.editeur.onix.v21.shorts.F120}<br/>
	 */
	DownloadCredit,

	/**
	 * Text of a copyright notice associated with a download file, and intended to be displayed whenever the file content is used. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters (XHTML is enabled in this element – see
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.DownloadCopyrightNotice}<br/>
	 *        {@link org.editeur.onix.v21.shorts.F121}<br/>
	 */
	DownloadCopyrightNotice,

	/**
	 * Text of any terms and conditions associated with a download file. Optional and non-repeating. This field may be sent alone, or with the
	 * &lt;TextWithDownload&gt; element, or with any combination of the &lt;DownloadCaption&gt;, &lt;DownloadCredit&gt;, and &lt;DownloadCopyrightNotice&gt;
	 * elements.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 500 characters (XHTML is enabled in this element – see
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.DownloadTerms}<br/>
	 *        {@link org.editeur.onix.v21.shorts.F122}<br/>
	 */
	DownloadTerms,

	/**
	 * The date when the image referenced by the &lt;MediaFileLink&gt; element was last changed. Optional and non-repeating. This element is intended to allow
	 * the receiver of an updated ONIX record to determine whether it is necessary to download a new copy of the file.
	 * 
	 * @format
	 *         Fixed-length, 8 numeric digits, YYYYMMDD
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.MediaFileDate}<br/>
	 *        {@link org.editeur.onix.v21.shorts.F373}<br/>
	 */
	MediaFileDate,

	/**
	 * An optional and repeatable group of data elements which together identify and provide pointers to a website which is related to the product.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ProductWebsite}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Productwebsite}<br/>
	 */
	ProductWebsite,

	/**
	 * Free text describing the nature of the website which is linked through &lt;ProductWebsiteLink&gt;. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters (XHTML is enabled in this element – see
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ProductWebsiteDescription}<br/>
	 *        {@link org.editeur.onix.v21.shorts.F170}<br/>
	 */
	ProductWebsiteDescription,

	/**
	 * A URL for a website carrying additional information related to the product, which is available to be viewed for promotional purposes. Mandatory in each
	 * occurrence of the &lt;ProductWebsite&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ProductWebsiteLink}<br/>
	 *        {@link org.editeur.onix.v21.shorts.F123}<br/>
	 */
	ProductWebsiteLink,

	/**
	 * Free text describing prizes or awards which the product has received. Optional and non-repeating. If this field is used, the &lt;Prize&lt; composite must
	 * not be used; and vice versa.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 500 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.PrizesDescription}<br/>
	 *        {@link org.editeur.onix.v21.shorts.G124}<br/>
	 */
	PrizesDescription,

	/**
	 * A repeatable group of data elements which together describe a prize or award won by the product.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Prize}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Prize}<br/>
	 *        {@link org.editeur.onix.v30.references.Prize}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Prize}<br/>
	 */
	Prize,

	/**
	 * The name of a prize or award which the product has received. Mandatory in each occurrence of the &lt;Prize&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.PrizeName}<br/>
	 *        {@link org.editeur.onix.v21.shorts.G126}<br/>
	 *        {@link org.editeur.onix.v30.references.PrizeName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.G126}<br/>
	 */
	PrizeName,

	/**
	 * The year in which a prize or award was given. Optional and non-repeating.
	 * 
	 * @format
	 *         Four digits, YYYY
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.PrizeYear}<br/>
	 *        {@link org.editeur.onix.v21.shorts.G127}<br/>
	 *        {@link org.editeur.onix.v30.references.PrizeYear}<br/>
	 *        {@link org.editeur.onix.v30.shorts.G127}<br/>
	 */
	PrizeYear,

	/**
	 * An ISO standard code identifying the country in which a prize or award is given. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two letters. [Note that ISO 3166-1 specifies that country codes shall be sent as upper case only.]
	 * @codelist
	 *           ISO 3166-1 two-letter country codes –
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.PrizeCountry}<br/>
	 *        {@link org.editeur.onix.v21.shorts.G128}<br/>
	 *        {@link org.editeur.onix.v30.references.PrizeCountry}<br/>
	 *        {@link org.editeur.onix.v30.shorts.G128}<br/>
	 */
	PrizeCountry,

	/**
	 * An ONIX code indicating the achievement of the product in relation to a prize or award,
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 41
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.PrizeCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.G129}<br/>
	 *        {@link org.editeur.onix.v30.references.PrizeCode}<br/>
	 *        {@link org.editeur.onix.v30.shorts.G129}<br/>
	 */
	PrizeCode,

	/**
	 * Free text listing members of the jury that awarded the prize. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 500 characters (XHTML is enabled in this element – see
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.PrizeJury}<br/>
	 *        {@link org.editeur.onix.v21.shorts.G343}<br/>
	 *        {@link org.editeur.onix.v30.references.PrizeJury}<br/>
	 *        {@link org.editeur.onix.v30.shorts.G343}<br/>
	 */
	PrizeJury,

	/**
	 * A repeatable group of data elements which together describe a content item within a product.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ContentItem}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Contentitem}<br/>
	 *        {@link org.editeur.onix.v30.references.ContentItem}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Contentitem}<br/>
	 */
	ContentItem,

	/**
	 * A group of data elements which are specific to text content. The composite must occur once and only once in a &lt;ContentItem&gt; composite which
	 * describes a text content item. (Similar composites are being defined for other media, and the occurrence of one of them will be mandatory in any
	 * &lt;ContentItem&gt; composite.)
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.TextItem}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Textitem}<br/>
	 *        {@link org.editeur.onix.v30.references.TextItem}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Textitem}<br/>
	 */
	TextItem,

	/**
	 * An ONIX code which identifies the nature of a text item. Mandatory in each occurrence of the &lt;TextItem&gt; composite, and non-repeatable.
	 * 
	 * @format
	 *         Fixed length, 2 numeric digits
	 * @codelist
	 *           List 42
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.TextItemType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B290}<br/>
	 *        {@link org.editeur.onix.v30.references.TextItemType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B290}<br/>
	 */
	TextItemType,

	/**
	 * A repeatable group of data elements which together define an identifier of a text item in accordance with a specified scheme. The composite is optional.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.TextItemIdentifier}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Textitemidentifier}<br/>
	 *        {@link org.editeur.onix.v30.references.TextItemIdentifier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Textitemidentifier}<br/>
	 */
	TextItemIdentifier,

	/**
	 * An ONIX code identifying the scheme from which the identifier in &lt;IDValue&gt; is taken. Mandatory in each occurrence of the &lt;TextItemIdentifier&gt;
	 * composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 2 numeric digits
	 * @codelist
	 *           List 43
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.TextItemIDType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B285}<br/>
	 *        {@link org.editeur.onix.v30.references.TextItemIDType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B285}<br/>
	 */
	TextItemIDType,

	/**
	 * The number of the page on which a text item begins in a paginated product. Optional and non-repeating; required when the text item is being referenced as
	 * part of a structured table of contents.
	 * 
	 * @format
	 *         Variable-length alphanumeric, suggested maximum length 20 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.FirstPageNumber}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B286}<br/>
	 *        {@link org.editeur.onix.v30.references.FirstPageNumber}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B286}<br/>
	 */
	FirstPageNumber,

	/**
	 * The number of the page on which a text item ends in a paginated product. Optional and non-repeating, and can occur only when &lt;FirstPageNumber&gt; is
	 * also present.
	 * 
	 * @format
	 *         Variable-length alphanumeric, suggested maximum length 20 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.LastPageNumber}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B287}<br/>
	 *        {@link org.editeur.onix.v30.references.LastPageNumber}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B287}<br/>
	 */
	LastPageNumber,

	/**
	 * A repeatable group of data elements which together define a run of contiguous pages on which a text item appears. The composite is optional, but may be
	 * repeated where the text item covers two or more separate page runs.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.PageRun}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Pagerun}<br/>
	 *        {@link org.editeur.onix.v30.references.PageRun}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Pagerun}<br/>
	 */
	PageRun,

	/**
	 * The generic name (if any) which is given in the product to the type of section which the content item represents,
	 * 
	 * @format
	 *         Variable-length alphanumeric, suggested maximum length 20 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ComponentTypeName}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B288}<br/>
	 *        {@link org.editeur.onix.v30.references.ComponentTypeName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B288}<br/>
	 */
	ComponentTypeName,

	/**
	 * The number (if any) which is given to the content item in the product, in the form (
	 * 
	 * @format
	 *         Variable-length alphanumeric, suggested maximum length 20 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ComponentNumber}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B289}<br/>
	 *        {@link org.editeur.onix.v30.references.ComponentNumber}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B289}<br/>
	 */
	ComponentNumber,

	/**
	 * An optional composite to carry contact information for a member of staff – likely in the publisher’s editorial, production, marketing, sales or publicity
	 * function, and with direct involvement with the product. Contact names are intended only for use within the trade. The composite is not repeatable.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.Contact}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Contact}<br/>
	 */
	Contact,

	/**
	 * The name of the organization represented by the contact, which should always be stated in a standard form – normally without Ltd, SA, Inc
	 * 
	 * @format
	 *         Variable length text, suggested maximum length 30 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ContactCompany}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B396}<br/>
	 */
	ContactCompany,

	/**
	 * Free text giving the name, department, phone number
	 * 
	 * @format
	 *         Variable length text, suggested maximum length 300 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ContactName}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B397}<br/>
	 *        {@link org.editeur.onix.v30.references.ContactName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X299}<br/>
	 */
	ContactName,

	/**
	 * E-mail address for the contact. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable length text, suggested maximum 100 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ContactEmail}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B399}<br/>
	 */
	ContactEmail,

	/**
	 * The full name of the imprint or brand under which the product is issued, as it appears on the title page of a book or in a corresponding position on a
	 * non-book product. Optional and non-repeating; and should not be used if the &lt;Imprint&gt; composite is used.
	 * 
	 * @format
	 *         Variable length text, suggested maximum length 100 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ImprintName}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B079}<br/>
	 *        {@link org.editeur.onix.v30.references.ImprintName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B079}<br/>
	 */
	ImprintName,

	/**
	 * A repeatable group of data elements which together identify an imprint or brand under which the product is marketed. The composite must carry either a
	 * name code or a name or both.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Imprint}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Imprint}<br/>
	 *        {@link org.editeur.onix.v30.references.Imprint}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Imprint}<br/>
	 */
	Imprint,

	/**
	 * An ONIX code which identifies the scheme from which the value in the &lt;NameCodeValue&gt; element is taken. Optional and non-repeating, but mandatory if
	 * the &lt;Imprint&gt; composite does not carry an &lt;ImprintName&gt;.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 44
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.NameCodeType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B241}<br/>
	 */
	NameCodeType,

	/**
	 * A name which identifies a proprietary name code when the code in &lt;NameCodeType&gt; indicates a proprietary scheme,
	 * 
	 * @format
	 *         Free text, suggested maximum length 50 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.NameCodeTypeName}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B242}<br/>
	 */
	NameCodeTypeName,

	/**
	 * A code value taken from the scheme specified in &lt;NameCodeType&gt;. Mandatory if and only if &lt;NameCodeType&gt; is present, and non-repeating.
	 * 
	 * @format
	 *         Determined by the scheme specified in &lt;NameCodeType&gt;
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.NameCodeValue}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B243}<br/>
	 */
	NameCodeValue,

	/**
	 * The full name of the publisher who issues the product, in the form in which the publisher wishes to be identified, and controlled by the publisher to
	 * maintain consistency across products. Optional and non-repeating; and should not be used if the &lt;Publisher&gt; composite is used. Except where they
	 * are essential to the recognized form of the name, it is recommended that suffixes denoting incorporation (“Co”, “Inc”, “Ltd”, “SA”, “GmbH”) should be
	 * omitted.
	 * 
	 * @format
	 *         Variable length text, suggested maximum length 100 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.PublisherName}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B081}<br/>
	 *        {@link org.editeur.onix.v30.references.PublisherName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B081}<br/>
	 */
	PublisherName,

	/**
	 * A repeatable group of data elements which together identify an entity which is associated with the publishing of a product. The composite will allow
	 * additional publishing roles to be introduced without adding new fields. Each occurrence of the composite must carry a publishing role code and either a
	 * name code or a name or both.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Publisher}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Publisher}<br/>
	 *        {@link org.editeur.onix.v30.references.Publisher}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Publisher}<br/>
	 */
	Publisher,

	/**
	 * An ONIX code which identifies a role played by an entity in the publishing of a product. Optional and non-repeating. The default if the element is
	 * omitted is “publisher”.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 45
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.PublishingRole}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B291}<br/>
	 *        {@link org.editeur.onix.v30.references.PublishingRole}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B291}<br/>
	 */
	PublishingRole,

	/**
	 * The name of a city or town associated with the imprint or publisher. Optional, and repeatable if the imprint carries two or more cities of publication.
	 * 
	 * @format
	 *         Free text, suggested maximum length 50 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.CityOfPublication}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B209}<br/>
	 *        {@link org.editeur.onix.v30.references.CityOfPublication}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B209}<br/>
	 */
	CityOfPublication,

	/**
	 * A code identifying the country where the product is issued. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two letters. [Note that ISO 3166-1 specifies that country codes shall be sent as upper case only.]
	 * @codelist
	 *           ISO 3166-1 two-letter country codes –
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.CountryOfPublication}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B083}<br/>
	 *        {@link org.editeur.onix.v30.references.CountryOfPublication}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B083}<br/>
	 */
	CountryOfPublication,

	/**
	 * The name of a co-publisher of the product, in the form in which the co-publisher wishes to be identified, and controlled to maintain consistency across
	 * products. Except where they are essential to the recognized form of the name, it is recommended that suffixes denoting incorporation (“Co”, “Inc”, “Ltd”,
	 * “SA”, “GmbH”) should be omitted. Optional, and repeatable if there are two or more co-publishers.
	 * 
	 * @format
	 *         Variable length text, suggested maximum length 100 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.CopublisherName}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B084}<br/>
	 */
	CopublisherName,

	/**
	 * The name of a sponsor of the product, in the form in which the sponsor wishes to be identified. Except where they are essential to the recognized form of
	 * the name, it is recommended that suffixes denoting incorporation (“Co”, “Inc”, “Ltd”, “SA”, “GmbH”) should be omitted. Optional, and repeatable if there
	 * are two or more sponsors.
	 * 
	 * @format
	 *         Variable length text, suggested maximum length 100 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.SponsorName}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B085}<br/>
	 */
	SponsorName,

	/**
	 * The name of the publisher of the original-language version of a translated work. Except where they are essential to the recognized form of the name, it
	 * is recommended that suffixes denoting incorporation (“Co”, “Inc”, “Ltd”, “SA”, “GmbH”) should be omitted. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable length text, suggested maximum length 100 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.OriginalPublisher}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B240}<br/>
	 */
	OriginalPublisher,

	/**
	 * An ONIX code which identifies the status of a published product. Optional and non-repeating,
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 64
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.PublishingStatus}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B394}<br/>
	 *        {@link org.editeur.onix.v30.references.PublishingStatus}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B394}<br/>
	 */
	PublishingStatus,

	/**
	 * Free text that describes the status of a published product, when the code in &lt;PublishingStatus&gt; is insufficient. Optional and non-repeating, but
	 * must be accompanied by the &lt;PublishingStatus&gt; element.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum 300 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.PublishingStatusNote}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B395}<br/>
	 *        {@link org.editeur.onix.v30.references.PublishingStatusNote}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B395}<br/>
	 */
	PublishingStatusNote,

	/**
	 * Date when information about the product can be issued to the general public. (Some publishers issue advance information under embargo.) Optional and
	 * non-repeating.
	 * 
	 * @format
	 *         Date as year, month, day (YYYYMMDD)
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.AnnouncementDate}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B086}<br/>
	 */
	AnnouncementDate,

	/**
	 * Date when information about the product can be issued to the book trade, while remaining embargoed for the general public. (Some publishers issue advance
	 * information under embargo.) Optional and non-repeating.
	 * 
	 * @format
	 *         Date as year, month, day (YYYYMMDD)
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.TradeAnnouncementDate}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B362}<br/>
	 */
	TradeAnnouncementDate,

	/**
	 * The date of first publication of this product in the home market of the publisher named in PR.19 (that is, under the current ISBN or other identifier, as
	 * distinct from the date of first publication of the work, which may be given in &lt;YearFirstPublished&gt; on the next page). In advance information, this
	 * will be an expected date, which should be replaced by the actual date of publication when known. The date should be given as precisely as possible, but
	 * in early notifications a month and year are sufficient; and for backlist titles the year of publication is sufficient.
	 * 
	 * @format
	 *         Four, six or eight numeric digits (YYYY, YYYYMM, or YYYYMMDD).
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.PublicationDate}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B003}<br/>
	 */
	PublicationDate,

	/**
	 * An optional and repeatable group of data elements which together represent a structured copyright statement for the product. Either a structured
	 * copyright statement or statements, or a copyright year in the separate &lt;CopyrightYear&gt; element which follows the composite, but not both, may be
	 * sent.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.CopyrightStatement}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Copyrightstatement}<br/>
	 *        {@link org.editeur.onix.v30.references.CopyrightStatement}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Copyrightstatement}<br/>
	 */
	CopyrightStatement,

	/**
	 * The copyright year as it appears in a copyright statement on the product. Mandatory in each occurrence of the &lt;CopyrightStatement&gt; composite, and
	 * repeatable if several years are listed.
	 * 
	 * @format
	 *         Date as year only (YYYY)
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.CopyrightYear}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B087}<br/>
	 *        {@link org.editeur.onix.v30.references.CopyrightYear}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B087}<br/>
	 */
	CopyrightYear,

	/**
	 * A repeatable group of data elements which together name a copyright owner. At least one occurrence is mandatory in each occurrence of the
	 * &lt;CopyrightStatement&gt; composite. Each occurrence of the &lt;CopyrightOwner&gt; composite must carry a single name (personal or corporate), or an
	 * identifier, or both.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.CopyrightOwner}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Copyrightowner}<br/>
	 *        {@link org.editeur.onix.v30.references.CopyrightOwner}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Copyrightowner}<br/>
	 */
	CopyrightOwner,

	/**
	 * A group of data elements which together represent a coded identification of a copyright owner. Optional, and non-repeating. May be sent either instead of
	 * or as well as a name.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.CopyrightOwnerIdentifier}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Copyrightowneridentifier}<br/>
	 *        {@link org.editeur.onix.v30.references.CopyrightOwnerIdentifier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Copyrightowneridentifier}<br/>
	 */
	CopyrightOwnerIdentifier,

	/**
	 * An ONIX code which identifies the scheme from which the value in the &lt;IDValue&gt; element is taken. Mandatory in each occurrence of the
	 * &lt;CopyrightOwnerIdentifier&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 44
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.CopyrightOwnerIDType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B392}<br/>
	 *        {@link org.editeur.onix.v30.references.CopyrightOwnerIDType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B392}<br/>
	 */
	CopyrightOwnerIDType,

	/**
	 * The year when the work first appeared in any language or edition, if different from the copyright year. Optional and non-repeating.
	 * 
	 * @format
	 *         Date as year only (YYYY)
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.YearFirstPublished}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B088}<br/>
	 */
	YearFirstPublished,

	/**
	 * A repeatable group of data elements which together identify territorial sales rights which a publisher chooses to exercise in a product. The
	 * &lt;SalesRights&gt; composite may occur once for each value of &lt;b089&gt;. See examples at the end of Group&nbsp;PR.21.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.SalesRights}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Salesrights}<br/>
	 *        {@link org.editeur.onix.v30.references.SalesRights}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Salesrights}<br/>
	 */
	SalesRights,

	/**
	 * An ONIX code which identifies the type of sales right or exclusion which applies in the territories which are associated with it. Mandatory in each
	 * occurrence of the &lt;SalesRights&gt;composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 46
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.SalesRightsType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B089}<br/>
	 *        {@link org.editeur.onix.v30.references.SalesRightsType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B089}<br/>
	 */
	SalesRightsType,

	/**
	 * One or more ISO standard codes identifying a country. Successive codes may be separated by spaces. Thus, a single occurrence of the element can carry an
	 * unlimited number of country codes, for countries that share the sales rights specified in &lt;SalesRightsType&gt;. For upwards compatibility, the element
	 * remains repeatable, so that multiple countries can also be listed as multiple occurrences of the whole element. At least one occurrence of
	 * &lt;RightsCountry&gt; or &lt;RightsTerritory&gt; or &lt;RightsRegion&gt; is mandatory in any occurrence of the&lt;SalesRights&gt; composite.
	 * 
	 * @format
	 *         One or more fixed-length codes, each with two upper case letters, successive codes being separated by spaces. Suggested maximum length 600
	 *         characters. [Note that ISO 3166-1 specifies that country codes shall be sent as upper case only.]
	 * @codelist
	 *           ISO 3166-1 two-letter country codes –
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.RightsCountry}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B090}<br/>
	 */
	RightsCountry,

	/**
	 * One or more ONIX codes identifying a territory which is not a country, but which is precisely defined in geographical terms,
	 * 
	 * @format
	 *         One or more variable-length codes, each consisting of upper case letters with or without a hyphen, successive codes being separated by spaces.
	 *         Suggested maximum length 100 characters.
	 * @codelist
	 *           List 49
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.RightsTerritory}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B388}<br/>
	 */
	RightsTerritory,

	/**
	 * An ONIX code identifying a territorial market which cannot be described in terms of ISO country codes. Optional, and repeatable for as many regions as
	 * share the sales rights specified in &lt;SalesRightsType&gt;.
	 * 
	 * @format
	 *         Fixed-length, three numeric digits.
	 * @codelist
	 *           List 47
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.RightsRegion}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B091}<br/>
	 */
	RightsRegion,

	/**
	 * A repeatable group of data elements which together identify a country or countries in which the product is not for sale, together with the ISBN and/or
	 * other product identifier and/or the name of the publisher of the same work in the specified country/ies.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.NotForSale}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Notforsale}<br/>
	 */
	NotForSale,

	/**
	 * A group of data elements which together identify a non-territorial sales restriction which a publisher applies to a product. Optional and repeatable.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.SalesRestriction}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Salesrestriction}<br/>
	 *        {@link org.editeur.onix.v30.references.SalesRestriction}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Salesrestriction}<br/>
	 */
	SalesRestriction,

	/**
	 * An ONIX code which identifies a non-territorial sales restriction. Mandatory in each occurrence of the &lt;SalesRestriction&gt; composite, and
	 * non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 71
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.SalesRestrictionType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B381}<br/>
	 *        {@link org.editeur.onix.v30.references.SalesRestrictionType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B381}<br/>
	 */
	SalesRestrictionType,

	/**
	 * An optional and repeatable group of data elements which together identify a sales outlet to which a restriction is linked. Each occurrence of the
	 * composite must include a &lt;SalesOutletIdentifier&gt; composite or a &lt;SalesOutletName&gt; or both.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.SalesOutlet}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Salesoutlet}<br/>
	 *        {@link org.editeur.onix.v30.references.SalesOutlet}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Salesoutlet}<br/>
	 */
	SalesOutlet,

	/**
	 * A group of data elements which together represent a coded identification of a person or organization, used here to identify a sales outlet. Non-repeating
	 * in this context.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.SalesOutletIdentifier}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Salesoutletidentifier}<br/>
	 *        {@link org.editeur.onix.v30.references.SalesOutletIdentifier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Salesoutletidentifier}<br/>
	 */
	SalesOutletIdentifier,

	/**
	 * An ONIX code which identifies the scheme from which the value in the &lt;IDValue&gt; element is taken. Mandatory in each occurrence of the
	 * &lt;SalesOutletIdentifier&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 102
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.SalesOutletIDType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B393}<br/>
	 *        {@link org.editeur.onix.v30.references.SalesOutletIDType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B393}<br/>
	 */
	SalesOutletIDType,

	/**
	 * The name of a wholesale or retail sales outlet to which a sales restriction is linked. Non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 200 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.SalesOutletName}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B382}<br/>
	 *        {@link org.editeur.onix.v30.references.SalesOutletName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B382}<br/>
	 */
	SalesOutletName,

	/**
	 * A free text field describing an “unspecified” restriction, or giving more explanation of a coded restriction type. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.SalesRestrictionDetail}<br/>
	 *        {@link org.editeur.onix.v21.shorts.B383}<br/>
	 */
	SalesRestrictionDetail,

	/**
	 * An optional and repeatable group of data elements which together identify a measurement and the units in which it is expressed.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Measure}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Measure}<br/>
	 *        {@link org.editeur.onix.v30.references.Measure}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Measure}<br/>
	 */
	Measure,

	/**
	 * An ONIX code indicating the dimension which is specified by an occurrence of the measure composite. Mandatory in each occurrence of the &lt;Measure&gt;
	 * composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 48
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.MeasureTypeCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.C093}<br/>
	 */
	MeasureTypeCode,

	/**
	 * The number which represents the dimension specified in &lt;MeasureTypeCode&gt; in the measure units specified in &lt;MeasureUnitCode&gt;. Mandatory in
	 * each occurrence of the &lt;Measure&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Variable length real number, with an explicit decimal point when required, suggested maximum length 6 characters including a decimal point.
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Measurement}<br/>
	 *        {@link org.editeur.onix.v21.shorts.C094}<br/>
	 *        {@link org.editeur.onix.v30.references.Measurement}<br/>
	 *        {@link org.editeur.onix.v30.shorts.C094}<br/>
	 */
	Measurement,

	/**
	 * An ONIX code indicating the measure unit in which dimensions are given. Mandatory in each occurrence of the &lt;Measure&gt; composite, and non-repeating.
	 * This element must follow the dimension to which the measure unit applies. See example below.
	 * 
	 * @format
	 *         Fixed-length, two letters
	 * @codelist
	 *           List 50
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.MeasureUnitCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.C095}<br/>
	 *        {@link org.editeur.onix.v30.references.MeasureUnitCode}<br/>
	 *        {@link org.editeur.onix.v30.shorts.C095}<br/>
	 */
	MeasureUnitCode,

	/**
	 * The overall height of the product: in the case of a book, the spine height, in the units specified in the message header, &lt;DefaultLinearUnit&gt;
	 * field, defined in the
	 * 
	 * @format
	 *         Variable length real number, with an explicit decimal point when required, suggested maximum length 6 characters including a decimal point.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.Height}<br/>
	 *        {@link org.editeur.onix.v21.shorts.C096}<br/>
	 */
	Height,

	/**
	 * The overall width of the product: in the case of a book, the cover or case width, in the units specified in the message header, &lt;DefaultLinearUnit&gt;
	 * field, defined in the
	 * 
	 * @format
	 *         Variable length real number, with an explicit decimal point when required, suggested maximum length 6 characters including a decimal point.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.Width}<br/>
	 *        {@link org.editeur.onix.v21.shorts.C097}<br/>
	 */
	Width,

	/**
	 * The overall thickness of the product: in the case of a book, the spine thickness, in the units specified in the message header, &lt;DefaultLinearUnit&gt;
	 * field, defined in the
	 * 
	 * @format
	 *         Variable length real number, with an explicit decimal point when required, suggested maximum length 6 characters including a decimal point.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.Thickness}<br/>
	 *        {@link org.editeur.onix.v21.shorts.C098}<br/>
	 */
	Thickness,

	/**
	 * The weight of a single unit of the product, in the units specified in the message header, &lt;DefaultWeightUnit&gt; field, defined in the
	 * 
	 * @format
	 *         Variable length real number, with an explicit decimal point when required, suggested maximum length 6 characters including a decimal point.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.Weight}<br/>
	 *        {@link org.editeur.onix.v21.shorts.C099}<br/>
	 */
	Weight,

	/**
	 * Where a legacy system has no structured data for product dimensions, but has a free text statement, this field allows such a statement to be sent.
	 * However, this practise is deprecated: structured information is always greatly to be preferred. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable length text, suggested maximum length 100 characters.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.Dimensions}<br/>
	 *        {@link org.editeur.onix.v21.shorts.C258}<br/>
	 */
	Dimensions,

	/**
	 * International Standard Book Number identifying a new product which replaces the current product. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 10 characters, all numeric except last character, which may be letter X.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ReplacedByISBN}<br/>
	 *        {@link org.editeur.onix.v21.shorts.H130}<br/>
	 */
	ReplacedByISBN,

	/**
	 * The EAN-13 article number of a new product which replaces the current product. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 13 numeric digits.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ReplacedByEAN13}<br/>
	 *        {@link org.editeur.onix.v21.shorts.H131}<br/>
	 */
	ReplacedByEAN13,

	/**
	 * International Standard Book Number identifying an alternative format in which the product is available. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 10 characters, all numeric except last character, which may be letter X.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.AlternativeFormatISBN}<br/>
	 *        {@link org.editeur.onix.v21.shorts.H132}<br/>
	 */
	AlternativeFormatISBN,

	/**
	 * EAN-13 article number identifying an alternative format in which the product is available. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 13 numeric digits.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.AlternativeFormatEAN13}<br/>
	 *        {@link org.editeur.onix.v21.shorts.H133}<br/>
	 */
	AlternativeFormatEAN13,

	/**
	 * International Standard Book Number identifying another product which is available and which the publisher suggests as an alternative. This element is
	 * used when the suggested alternative is neither a direct successor (new edition) nor the same product in an alternative format. Optional and
	 * non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 10 characters, all numeric except last character, which may be letter X.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.AlternativeProductISBN}<br/>
	 *        {@link org.editeur.onix.v21.shorts.H163}<br/>
	 */
	AlternativeProductISBN,

	/**
	 * EAN-13 article number identifying another product which is available and which the publisher suggests as an alternative. This element is used when the
	 * suggested alternative is neither a direct successor (new edition) nor the same product in an alternative format. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 13 numeric digits.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.AlternativeProductEAN13}<br/>
	 *        {@link org.editeur.onix.v21.shorts.H164}<br/>
	 */
	AlternativeProductEAN13,

	/**
	 * A repeatable group of data elements which together describe a product which has a specified relationship to the product which is described in the ONIX
	 * record. Although for reasons of upwards compatibility the composite includes individual fields for ISBN and EAN-13 number, use of the nested
	 * &lt;ProductIdentifier&gt; composite is to be preferred, since it allows any recognized identifier scheme (
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.RelatedProduct}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Relatedproduct}<br/>
	 *        {@link org.editeur.onix.v30.references.RelatedProduct}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Relatedproduct}<br/>
	 */
	RelatedProduct,

	/**
	 * An ONIX code which identifies the nature of the relationship between two products,
	 * 
	 * @format
	 *         Fixed length, two numeric digits
	 * @codelist
	 *           List 51
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.RelationCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.H208}<br/>
	 */
	RelationCode,

	/**
	 * The date on which the publisher put the current product out-of-print. Optional and non-repeating.
	 * 
	 * @format
	 *         Date as year, month, day (YYYYMMDD)
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.OutOfPrintDate}<br/>
	 *        {@link org.editeur.onix.v21.shorts.H134}<br/>
	 */
	OutOfPrintDate,

	/**
	 * A repeatable group of data elements which together give details of a trade supply source and the product price and availability from that source.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.SupplyDetail}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Supplydetail}<br/>
	 *        {@link org.editeur.onix.v30.references.SupplyDetail}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Supplydetail}<br/>
	 */
	SupplyDetail,

	/**
	 * An EAN-13 location number identifying a supply source from which the product may be ordered by a trade customer. Now also known as an “EAN-UCC Global
	 * Location Number” or GLN. Optional, but each occurrence of the &lt;SupplyDetail&gt; composite must carry either at least one supplier identifier, or a
	 * &lt;SupplierName&gt;.
	 * 
	 * @format
	 *         Fixed-length, thirteen numeric digits, of which the last is a check digit.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.SupplierEANLocationNumber}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J135}<br/>
	 */
	SupplierEANLocationNumber,

	/**
	 * The book trade Standard Address Number that identifies the supplier with whom trade orders for the product should be placed. Used in the US and UK.
	 * Optional, but each occurrence of the &lt;SupplyDetail&gt; composite must carry either at least one supplier identifier, or a &lt;SupplierName&gt;.
	 * 
	 * @format
	 *         Fixed-length, seven characters. The first six are numeric digits, and the seventh is a check character which may be a numeric digit or letter X.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.SupplierSAN}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J136}<br/>
	 */
	SupplierSAN,

	/**
	 * A repeatable group of data elements which together define the identifier of a supplier in accordance with a specified scheme, and allowing different
	 * types of supplier identifier to be included without defining additional data elements. Optional, but each occurrence of the &lt;SupplyDetail&gt;
	 * composite must carry either at least one supplier identifier, or a &lt;SupplierName&gt;.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.SupplierIdentifier}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Supplieridentifier}<br/>
	 *        {@link org.editeur.onix.v30.references.SupplierIdentifier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Supplieridentifier}<br/>
	 */
	SupplierIdentifier,

	/**
	 * An ONIX code identifying the scheme from which the identifier in the &lt;IDValue&gt; element is taken. Mandatory in each occurrence of the
	 * &lt;SupplierIdentifier&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 2 numeric digits
	 * @codelist
	 *           List 92
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.SupplierIDType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J345}<br/>
	 *        {@link org.editeur.onix.v30.references.SupplierIDType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J345}<br/>
	 */
	SupplierIDType,

	/**
	 * The name of a supply source from which the product may be ordered by a trade customer. Optional and non-repeating; required if no supplier identifier is
	 * sent.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.SupplierName}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J137}<br/>
	 *        {@link org.editeur.onix.v30.references.SupplierName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J137}<br/>
	 */
	SupplierName,

	/**
	 * A telephone number of a supply source from which the product may be ordered by a trade customer. Optional and repeatable.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 20 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.TelephoneNumber}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J270}<br/>
	 *        {@link org.editeur.onix.v30.references.TelephoneNumber}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J270}<br/>
	 */
	TelephoneNumber,

	/**
	 * A fax number of a supply source from which the product may be ordered by a trade customer. Optional and repeatable.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 20 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.FaxNumber}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J271}<br/>
	 *        {@link org.editeur.onix.v30.references.FaxNumber}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J271}<br/>
	 */
	FaxNumber,

	/**
	 * An email address for a supply source from which the product may be ordered by a trade customer. Optional and repeatable.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.EmailAddress}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J272}<br/>
	 *        {@link org.editeur.onix.v30.references.EmailAddress}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J272}<br/>
	 */
	EmailAddress,

	/**
	 * An ONIX code identifying the role of a supplier in relation to the product,
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 93
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.SupplierRole}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J292}<br/>
	 *        {@link org.editeur.onix.v30.references.SupplierRole}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J292}<br/>
	 */
	SupplierRole,

	/**
	 * One or more ISO standard codes identifying a country for which the supplier holds distribution rights for the product. Successive codes may be separated
	 * by spaces. Thus, a single occurrence of the element can carry an unlimited number of country codes. For upwards compatibility, the element remains
	 * repeatable, so that multiple countries can be listed as multiple occurrences of the whole element. Optional and repeatable.
	 * 
	 * @format
	 *         One or more fixed-length codes, each with two upper case letters, successive codes being separated by spaces. Suggested maximum length 600
	 *         characters. [Note that ISO 3166-1 specifies that country codes shall be sent as upper case only.]
	 * @codelist
	 *           ISO 3166-1 two-letter country codes –
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.SupplyToCountry}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J138}<br/>
	 */
	SupplyToCountry,

	/**
	 * One or more ONIX codes identifying a territory which is not a country, but which is precisely defined in geographical terms,
	 * 
	 * @format
	 *         One or more variable-length codes, each consisting of upper case letters with or without a hyphen, successive codes being separated by spaces.
	 *         Suggested maximum length 100 characters.
	 * @codelist
	 *           List 49
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.SupplyToTerritory}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J397}<br/>
	 */
	SupplyToTerritory,

	/**
	 * An ONIX code for a region to which the supplier is able to supply. A full code list is yet to be defined. A provisional coding, for UK use only, is given
	 * for Open Market supply.
	 * 
	 * @format
	 *         Fixed-length, three numeric digits
	 * @codelist
	 *           List 52
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.SupplyToRegion}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J139}<br/>
	 */
	SupplyToRegion,

	/**
	 * One or more ISO standard codes identifying a country which is excluded from a territory specified in &lt;SupplyToTerritory&gt;. Successive codes may be
	 * separated by spaces. Thus, a single occurrence of the element can carry an unlimited number of country codes. For upwards compatibility, the element
	 * remains repeatable, so that multiple countries can be listed as multiple occurrences of the whole element. Optional and repeatable.
	 * 
	 * @format
	 *         One or more fixed-length codes, each with two upper case letters, successive codes being separated by spaces. Suggested maximum length 300
	 *         characters. [Note that ISO 3166-1 specifies that country codes shall be sent as upper case only.]
	 * @codelist
	 *           ISO 3166-1 two-letter country codes –
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.SupplyToCountryExcluded}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J140}<br/>
	 */
	SupplyToCountryExcluded,

	/**
	 * A free text field describing a non-geographical restriction of the market covered by a distributor or other supplier. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.SupplyRestrictionDetail}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J399}<br/>
	 */
	SupplyRestrictionDetail,

	/**
	 * An ONIX code identifying the scheme from which the returns conditions code in &lt;ReturnsCode&gt; is taken. Optional and non-repeating, but this field
	 * must be present if &lt;ReturnsCode&gt; is present.
	 * 
	 * @format
	 *         Fixed-length, 2 numeric digits
	 * @codelist
	 *           List 53
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ReturnsCodeType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J268}<br/>
	 *        {@link org.editeur.onix.v30.references.ReturnsCodeType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J268}<br/>
	 */
	ReturnsCodeType,

	/**
	 * A returns conditions code from the scheme specified in &lt;ReturnsCodeType&gt;. Optional and non-repeating, but this field must be present if
	 * &lt;ReturnsCodeType&gt; is present.
	 * 
	 * @format
	 *         According to the scheme specified in &lt;ReturnsCodeType&gt;: for values defined by BISAC for US use, see
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ReturnsCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J269}<br/>
	 *        {@link org.editeur.onix.v30.references.ReturnsCode}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J269}<br/>
	 */
	ReturnsCode,

	/**
	 * The last date for returns, when the supplier has placed a time limit on returns from retailers. Typically this occurs when the publisher has made the
	 * product out-of-print. Optional and non-repeating.
	 * 
	 * @format
	 *         Date as year, month, day (YYYYMMDD)
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.LastDateForReturns}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J387}<br/>
	 */
	LastDateForReturns,

	/**
	 * An ONIX code indicating the availability of a product. Each occurrence of the &lt;SupplyDetail&gt; composite must carry either &lt;AvailabilityCode&gt;
	 * or &lt;ProductAvailability&gt;, or both, but &lt;ProductAvailability&gt; is now strongly preferred. Non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two letters
	 * @codelist
	 *           List 54
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.AvailabilityCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J141}<br/>
	 */
	AvailabilityCode,

	/**
	 * An ONIX code indicating the availability of a product from a supplier. This element has been added as a preferred successor to the
	 * &lt;AvailabilityCode&gt; element, and is intended to be used both by publishers (who should also include the new &lt;PublishingStatus&gt; element in
	 * PR.20) and by intermediary suppliers (who may also include &lt;PublishingStatus&gt; if they are in a position to do so. Each occurrence of the
	 * &lt;SupplyDetail&gt; composite must carry either &lt;AvailabilityCode&gt; or &lt;ProductAvailability&gt;, or both. The element is non-repeating.
	 * Recommended practise is in future to use this new element, and, where possible and appropriate, to include the &lt;PublishingStatus&gt; element in PR.20.
	 * It is likely that the &lt;AvailabilityCode&gt; element will be “deprecated” in due course in a future release.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 65
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ProductAvailability}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J396}<br/>
	 *        {@link org.editeur.onix.v30.references.ProductAvailability}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J396}<br/>
	 */
	ProductAvailability,

	/**
	 * An ONIX code indicating the availability of a product from an intermediary supplier. This element was added in preparation for an expected revision of
	 * availability status coding, but in the event will not now be generally used. The element is being used as an interim measure by the Australian ONIX group
	 * to carry local availability status, but will be replaced on completion of the revised code lists. The element will be withdrawn from the ONIX format in a
	 * future release.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 63
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.IntermediaryAvailabilityCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J348}<br/>
	 */
	IntermediaryAvailabilityCode,

	/**
	 * A group of data elements which together specify a new supply source to which orders are referred. Use only when the code in &lt;ProductAvailability&gt;
	 * or &lt;AvailabilityCode&gt; indicates “no longer available from us, refer to new supplier”. Only one occurrence of the composite is permitted in this
	 * context.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.NewSupplier}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Newsupplier}<br/>
	 *        {@link org.editeur.onix.v30.references.NewSupplier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Newsupplier}<br/>
	 */
	NewSupplier,

	/**
	 * If the product is not currently available, the date on which shipping from the supplier to retailers is expected to begin or resume. Optional and
	 * non-repeating; required with certain code values in the &lt;AvailabilityCode&gt; element. The format is as specified in the &lt;DateFormat&gt; field. The
	 * default format is YYYYMMDD,
	 * 
	 * @format
	 *         Date as year, month, day (YYYYMMDD) or as specified in &lt;DateFormat&gt;
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ExpectedShipDate}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J142}<br/>
	 */
	ExpectedShipDate,

	/**
	 * The date when a new product can be placed on sale by retailers in the market served by the supplier. Optional and non-repeating.
	 * 
	 * @format
	 *         Date as year, month, day (YYYYMMDD)
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.OnSaleDate}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J143}<br/>
	 */
	OnSaleDate,

	/**
	 * The expected average number of days from receipt of order to despatch (for items “manufactured on demand” or “only to order”). Optional and
	 * non-repeating.
	 * 
	 * @format
	 *         Variable-length integer, one or two digits only
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.OrderTime}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J144}<br/>
	 *        {@link org.editeur.onix.v30.references.OrderTime}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J144}<br/>
	 */
	OrderTime,

	/**
	 * A repeatable group of data elements which together specify a quantity of stock and, where a supplier has more than one warehouse, a supplier location.
	 * Optional.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Stock}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Stock}<br/>
	 *        {@link org.editeur.onix.v30.references.Stock}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Stock}<br/>
	 */
	Stock,

	/**
	 * A group of data elements which together define the identifier of a stock location in accordance with a specified scheme, and allowing different types of
	 * location identifier to be supported without defining additional data elements. Optional and non-repeating.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.LocationIdentifier}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Locationidentifier}<br/>
	 *        {@link org.editeur.onix.v30.references.LocationIdentifier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Locationidentifier}<br/>
	 */
	LocationIdentifier,

	/**
	 * An ONIX code identifying the scheme from which the identifier in the &lt;IDValue&gt; element is taken. Mandatory in each occurrence of the
	 * &lt;LocationIdentifier&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 2 numeric digits
	 * @codelist
	 *           List 92
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.LocationIDType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J377}<br/>
	 *        {@link org.editeur.onix.v30.references.LocationIDType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J377}<br/>
	 */
	LocationIDType,

	/**
	 * The name of a stock location. Optional and non-repeating.
	 * 
	 * @format
	 *         Free text, suggested maximum length 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.LocationName}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J349}<br/>
	 *        {@link org.editeur.onix.v30.references.LocationName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J349}<br/>
	 */
	LocationName,

	/**
	 * A group of data elements which together specify coded stock level without stating the exact quantity of stock. Either &lt;StockQuantityCoded&gt; or
	 * &lt;OnHand&gt; is mandatory in each occurrence of the &lt;Stock&gt; composite, even if the onhand quantity is zero. Non-repeating.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.StockQuantityCoded}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Stockquantitycoded}<br/>
	 *        {@link org.editeur.onix.v30.references.StockQuantityCoded}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Stockquantitycoded}<br/>
	 */
	StockQuantityCoded,

	/**
	 * An ONIX code identifying the scheme from which the value in the &lt;StockQuantityCode&gt; element is taken. Mandatory in each occurrence of the
	 * &lt;StockQuantityCoded&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 2 numeric digits
	 * @codelist
	 *           List 70
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.StockQuantityCodeType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J293}<br/>
	 *        {@link org.editeur.onix.v30.references.StockQuantityCodeType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J293}<br/>
	 */
	StockQuantityCodeType,

	/**
	 * A name that identifies a proprietary stock quantity coding scheme when the code in the &lt;StockQuantityCodeType&gt; element indicates a proprietary
	 * scheme,
	 * 
	 * @format
	 *         Free text, suggested maximum length 50 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.StockQuantityCodeTypeName}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J296}<br/>
	 *        {@link org.editeur.onix.v30.references.StockQuantityCodeTypeName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J296}<br/>
	 */
	StockQuantityCodeTypeName,

	/**
	 * A code value taken from the scheme specified in the &lt;StockQuantityCodeType&gt; element. Mandatory in each occurrence of the &lt;StockQuantityCoded&gt;
	 * composite, and non-repeating.
	 * 
	 * @format
	 *         According to the scheme specified in &lt;StockQuantityCodeType&gt;
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.StockQuantityCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J297}<br/>
	 *        {@link org.editeur.onix.v30.references.StockQuantityCode}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J297}<br/>
	 */
	StockQuantityCode,

	/**
	 * The quantity of stock on hand. Either &lt;StockQuantityCoded&gt; or &lt;OnHand&gt; is mandatory in each occurrence of the &lt;Stock&gt; composite, even
	 * if the onhand quantity is zero. Non-repeating.
	 * 
	 * @format
	 *         Variable-length integer, suggested maximum length 7 digits
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.OnHand}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J350}<br/>
	 *        {@link org.editeur.onix.v30.references.OnHand}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J350}<br/>
	 */
	OnHand,

	/**
	 * The quantity of stock on order. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length integer, suggested maximum length 7 digits
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.OnOrder}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J351}<br/>
	 *        {@link org.editeur.onix.v30.references.OnOrder}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J351}<br/>
	 */
	OnOrder,

	/**
	 * The quantity of stock on order which is already committed to meet backorders. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length integer, suggested maximum length 7 digits
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.CBO}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J375}<br/>
	 *        {@link org.editeur.onix.v30.references.CBO}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J375}<br/>
	 */
	CBO,

	/**
	 * A repeatable group of data elements which together specify details of a stock shipment currently awaited, normally from overseas. Optional.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.OnOrderDetail}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Onorderdetail}<br/>
	 *        {@link org.editeur.onix.v30.references.OnOrderDetail}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Onorderdetail}<br/>
	 */
	OnOrderDetail,

	/**
	 * The date on which a stock shipment is expected. Mandatory in each occurrence of the &lt;OnOrderDetail&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 8 numeric digits, YYYYMMDD
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ExpectedDate}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J302}<br/>
	 *        {@link org.editeur.onix.v30.references.ExpectedDate}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J302}<br/>
	 */
	ExpectedDate,

	/**
	 * The quantity in each carton or binder’s pack in stock currently held by the supplier. (This element is placed in Group&nbsp;PR.24 since it cannot be
	 * assumed that pack quantities will be the same for stock held at different suppliers.)
	 * 
	 * @format
	 *         Variable-length integer, suggested maximum length four digits
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.PackQuantity}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J145}<br/>
	 *        {@link org.editeur.onix.v30.references.PackQuantity}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J145}<br/>
	 */
	PackQuantity,

	/**
	 * Used with &lt;AudienceRestrictionNote&gt; where within a particular market there is an additional restriction on sale, imposed either by the publisher (
	 * 
	 * @format
	 *         Provisional: fixed-length, single letter
	 * @codelist
	 *           List 56
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.AudienceRestrictionFlag}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J146}<br/>
	 */
	AudienceRestrictionFlag,

	/**
	 * Free text describing a non-territorial restriction on supply, only when &lt;AudienceRestrictionFlag&gt; is present. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, maximum 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.AudienceRestrictionNote}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J147}<br/>
	 */
	AudienceRestrictionNote,

	/**
	 * An ONIX code which specifies a reason why a price amount is not sent.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 57
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.UnpricedItemType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J192}<br/>
	 *        {@link org.editeur.onix.v30.references.UnpricedItemType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J192}<br/>
	 */
	UnpricedItemType,

	/**
	 * The amount of a unit price. This price amount element , outside of the &lt;Price&gt; composite, may be used if and only if a default price type and
	 * currency have been specified in the message header, and only one price is to be given.
	 * 
	 * @format
	 *         Variable length real number, with explicit decimal point when required, suggested maximum length 12 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.PriceAmount}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J151}<br/>
	 *        {@link org.editeur.onix.v30.references.PriceAmount}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J151}<br/>
	 */
	PriceAmount,

	/**
	 * A repeatable group of data elements which together specify a unit price.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Price}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Price}<br/>
	 *        {@link org.editeur.onix.v30.references.Price}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Price}<br/>
	 */
	Price,

	/**
	 * An ONIX code indicating the type of the price in the &lt;PriceAmount&gt; field within the &lt;Price&gt; composite. Optional, provided that a
	 * &lt;DefaultPriceTypeCode&gt; has been specified in the message header, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 58
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.PriceTypeCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J148}<br/>
	 */
	PriceTypeCode,

	/**
	 * An ONIX code which further specifies the type of price,
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 59
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.PriceQualifier}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J261}<br/>
	 *        {@link org.editeur.onix.v30.references.PriceQualifier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J261}<br/>
	 */
	PriceQualifier,

	/**
	 * Free text which further describes the price type. Optional and non-repeating. In the Netherlands, when the &lt;PriceQualifier&gt; code identifies a
	 * “voucher price”, the &lt;PriceTypeDescription&gt; should give the “EAN action number” that identifies the offer.
	 * 
	 * @format
	 *         Text, suggested maximum length 200 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.PriceTypeDescription}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J262}<br/>
	 *        {@link org.editeur.onix.v30.references.PriceTypeDescription}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J262}<br/>
	 */
	PriceTypeDescription,

	/**
	 * An ONIX code indicating the unit of product which is the basis for the price carried in an occurrence of the &lt;Price&gt; composite. Optional and
	 * non-repeating. Where the price applies to a copy of the whole product, this field is normally omitted.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 60
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.PricePer}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J239}<br/>
	 *        {@link org.editeur.onix.v30.references.PricePer}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J239}<br/>
	 */
	PricePer,

	/**
	 * The minimum number of copies which must be ordered to obtain the price carried in an occurrence of the &lt;Price&gt; composite. Optional and
	 * non-repeating. If the field is present, the price is a quantity price. If the field is omitted, the price applies to a single unit.
	 * 
	 * @format
	 *         Variable-length integer, suggested maximum length 4 digits
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.MinimumOrderQuantity}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J263}<br/>
	 *        {@link org.editeur.onix.v30.references.MinimumOrderQuantity}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J263}<br/>
	 */
	MinimumOrderQuantity,

	/**
	 * A repeatable group of data elements which together specify a batch bonus,
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.BatchBonus}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Batchbonus}<br/>
	 *        {@link org.editeur.onix.v30.references.BatchBonus}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Batchbonus}<br/>
	 */
	BatchBonus,

	/**
	 * The number of copies which must be ordered to obtain the free copies specified in &lt;FreeQuantity&gt;. Mandatory in each occurrence of the
	 * &lt;BatchBonus&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Variable-length integer, suggested maximum length 4 digits
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.BatchQuantity}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J264}<br/>
	 *        {@link org.editeur.onix.v30.references.BatchQuantity}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J264}<br/>
	 */
	BatchQuantity,

	/**
	 * The number of free copies which will be supplied with an order for the batch quantity specified in the &lt;BatchQuantity&gt; field. Mandatory in each
	 * occurrence of the &lt;BatchBonus&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Variable-length integer, suggested maximum length 4 digits
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.FreeQuantity}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J265}<br/>
	 *        {@link org.editeur.onix.v30.references.FreeQuantity}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J265}<br/>
	 */
	FreeQuantity,

	/**
	 * Text indicating the class of trade to which the price carried in an occurrence of the &lt;Price&gt; composite is applicable,
	 * 
	 * @format
	 *         Text, suggested maximum length 50 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ClassOfTrade}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J149}<br/>
	 */
	ClassOfTrade,

	/**
	 * A BIC code indicating the supplier’s discount group to which the price carried in an occurrence of the &lt;Price&gt; composite belongs. This code does
	 * not identify an absolute rate of discount, but it allows a bookseller to derive the actual discount by reference to a look-up table provided separately
	 * by the supplier.
	 * 
	 * @format
	 *         Fixed-length, 8 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.BICDiscountGroupCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J150}<br/>
	 */
	BICDiscountGroupCode,

	/**
	 * A repeatable group of data elements which together define a discount code from a specified scheme, and allowing different discount code schemes to be
	 * supported without defining additional data elements. Optional.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.DiscountCoded}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Discountcoded}<br/>
	 *        {@link org.editeur.onix.v30.references.DiscountCoded}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Discountcoded}<br/>
	 */
	DiscountCoded,

	/**
	 * An ONIX code identifying the scheme from which the value in the &lt;DiscountCode&gt; element is taken. Mandatory in each occurrence of the
	 * &lt;DiscountCoded&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 2 numeric digits
	 * @codelist
	 *           List 100
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.DiscountCodeType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J363}<br/>
	 *        {@link org.editeur.onix.v30.references.DiscountCodeType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J363}<br/>
	 */
	DiscountCodeType,

	/**
	 * A name which identifies a proprietary discount code when the code in the &lt;DiscountCodeType&gt; element indicates a proprietary scheme,
	 * 
	 * @format
	 *         Free text, suggested maximum length 50 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.DiscountCodeTypeName}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J378}<br/>
	 *        {@link org.editeur.onix.v30.references.DiscountCodeTypeName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J378}<br/>
	 */
	DiscountCodeTypeName,

	/**
	 * A discount code from the scheme specified in the &lt;DiscountCodeType&gt; element. Mandatory in each occurrence of the &lt;DiscountCoded&gt; composite,
	 * and non-repeating.
	 * 
	 * @format
	 *         According to the scheme specified in &lt;DiscountCodeType&gt;
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.DiscountCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J364}<br/>
	 *        {@link org.editeur.onix.v30.references.DiscountCode}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J364}<br/>
	 */
	DiscountCode,

	/**
	 * The supplier’s discount percentage applicable to the price carried in an occurrence of the &lt;Price&gt; composite. Optional and non-repeating. Use only
	 * when an ONIX message is sent within the context of a specific trading relationship.
	 * 
	 * @format
	 *         Variable-length numeric, including decimal point if required, suggested maximum length 6 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.DiscountPercent}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J267}<br/>
	 *        {@link org.editeur.onix.v30.references.DiscountPercent}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J267}<br/>
	 */
	DiscountPercent,

	/**
	 * An ONIX code which specifies the status of a price. Optional and non-repeating. If the field is omitted, the default “unspecified” will apply.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 61
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.PriceStatus}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J266}<br/>
	 *        {@link org.editeur.onix.v30.references.PriceStatus}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J266}<br/>
	 */
	PriceStatus,

	/**
	 * An ISO standard code identifying the currency in which a price is given in &lt;PriceAmount&gt;, unless it is the default currency for the exchange.
	 * Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, three letters
	 * @codelist
	 *           ISO 4217 currency codes –
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.CurrencyCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J152}<br/>
	 *        {@link org.editeur.onix.v30.references.CurrencyCode}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J152}<br/>
	 */
	CurrencyCode,

	/**
	 * One or more ONIX codes identifying a territory, other than a country, in which the price given in &lt;PriceAmount&gt; applies. Successive codes may be
	 * separated by spaces. Thus the element can carry an unlimited number of territory codes. Optional and non-repeating.
	 * 
	 * @format
	 *         One or more variable-length codes, each consisting of upper case letters with or without a hyphen, successive codes being separated by spaces.
	 *         Suggested maximum length 100 characters.
	 * @codelist
	 *           List 49
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Territory}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J303}<br/>
	 *        {@link org.editeur.onix.v30.references.Territory}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Territory}<br/>
	 */
	Territory,

	/**
	 * One or more ISO standard codes identifying a country which is excluded from a territory specified in &lt;Territory&gt;. Successive codes may be separated
	 * by spaces. Thus, a single occurrence of the element can carry an unlimited number of country codes. Optional and non-repeating.
	 * 
	 * @format
	 *         One or more fixed-length codes, each with two upper case letters, successive codes being separated by spaces. Suggested maximum length 300
	 *         characters. [Note that ISO 3166-1 specifies that country codes shall be sent as upper case only.]
	 * @codelist
	 *           ISO 3166-1 two-letter country codes –
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.CountryExcluded}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J304}<br/>
	 */
	CountryExcluded,

	/**
	 * One or more ONIX codes identifying a territory, which is excluded from a country specified in &lt;CountryCode&gt; or from a territory specified in
	 * &lt;Territory&gt;. Successive codes may be separated by spaces. Thus the element can carry an unlimited number of territory codes. Optional and
	 * non-repeating.
	 * 
	 * @format
	 *         One or more variable-length codes, each consisting of upper case letters with or without a hyphen, successive codes being separated by spaces.
	 *         Suggested maximum length 100 characters.
	 * @codelist
	 *           List 49
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.TerritoryExcluded}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J308}<br/>
	 */
	TerritoryExcluded,

	/**
	 * A code which specifies a value added tax rate applying to the whole of the price, or to the amount of the price which is specified in
	 * &lt;TaxableAmount1&gt; if present. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, one letter.
	 * @codelist
	 *           List 62
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.TaxRateCode1}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J153}<br/>
	 */
	TaxRateCode1,

	/**
	 * A tax rate expressed numerically as a percentage. See notes on &lt;TaxRateCode1&gt;.
	 * 
	 * @format
	 *         Variable length real number, with an explicit decimal point where required.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.TaxRatePercent1}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J154}<br/>
	 */
	TaxRatePercent1,

	/**
	 * The amount of the unit price of the product, excluding tax, which is taxable at the rate specified by &lt;TaxRateCode1&gt; and/or
	 * &lt;TaxRatePercent1&gt;. This may be the whole of the unit price before tax, if the item carries tax at the same rate on the whole price; or part of the
	 * unit price in the case of a mixed tax rate product. See notes on &lt;TaxRateCode1&gt;.
	 * 
	 * @format
	 *         Variable length real number, with an explicit decimal point where required.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.TaxableAmount1}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J155}<br/>
	 */
	TaxableAmount1,

	/**
	 * The amount of tax chargeable at the rate specified by &lt;TaxRateCode1&gt; and/or &lt;TaxRatePercent1&gt;. See notes on &lt;TaxRateCode1&gt;.
	 * 
	 * @format
	 *         Variable length real number, with an explicit decimal point where required.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.TaxAmount1}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J156}<br/>
	 */
	TaxAmount1,

	/**
	 * A code which specifies a value added tax rate applying to the amount of the price which is specified in &lt;TaxableAmount2&gt;. See notes on
	 * &lt;TaxRateCode1&gt;.
	 * 
	 * @format
	 *         Fixed-length, one letter.
	 * @codelist
	 *           List 62
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.TaxRateCode2}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J157}<br/>
	 */
	TaxRateCode2,

	/**
	 * A tax rate expressed numerically as a percentage. See notes on &lt;TaxRateCode1&gt;.
	 * 
	 * @format
	 *         Variable length real number, with an explicit decimal point where required.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.TaxRatePercent2}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J158}<br/>
	 */
	TaxRatePercent2,

	/**
	 * The amount of the unit price of the product, excluding tax, which is taxable at the rate specified by &lt;TaxRateCode2&gt; and/or
	 * &lt;TaxRatePercent2&gt;. This may be the whole of the unit price before tax, if the item carries tax at the same rate on the whole price; or part of the
	 * unit price in the case of a mixed tax rate product. See notes on &lt;TaxRateCode1&gt;.
	 * 
	 * @format
	 *         Variable length real number, with an explicit decimal point where required.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.TaxableAmount2}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J159}<br/>
	 */
	TaxableAmount2,

	/**
	 * The amount of tax chargeable at the rate specified by &lt;TaxRateCode2&gt; and/or &lt;TaxRatePercent2&gt;. See notes on &lt;TaxRateCode1&gt;.
	 * 
	 * @format
	 *         Variable length real number, with an explicit decimal point where required.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.TaxAmount2}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J160}<br/>
	 */
	TaxAmount2,

	/**
	 * The date from which a price becomes effective. Optional and non-repeating.
	 * 
	 * @format
	 *         Date as year, month, day (YYYYMMDD)
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.PriceEffectiveFrom}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J161}<br/>
	 */
	PriceEffectiveFrom,

	/**
	 * The date until which a price remains effective. Optional and non-repeating.
	 * 
	 * @format
	 *         Date as year, month, day (YYYYMMDD)
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.PriceEffectiveUntil}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J162}<br/>
	 */
	PriceEffectiveUntil,

	/**
	 * A group of data elements which together specify that a product is to be reissued within the market to which the &lt;SupplyDetail&gt; composite applies.
	 * Optional and non-repeating. The &lt;Reissue&gt; composite is used only when the publisher intends to re-launch the product under the same ISBN. There are
	 * two possible cases:
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Reissue}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Reissue}<br/>
	 *        {@link org.editeur.onix.v30.references.Reissue}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Reissue}<br/>
	 */
	Reissue,

	/**
	 * The date on which the product will be reissued, or (after reissue) the date when it was last reissued. Mandatory in each occurrence of the
	 * &lt;Reissue&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Date as year, month, day (YYYYMMDD)
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ReissueDate}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J365}<br/>
	 *        {@link org.editeur.onix.v30.references.ReissueDate}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J365}<br/>
	 */
	ReissueDate,

	/**
	 * Text explaining the nature of the reissue. Optional and non-repeating.
	 * 
	 * @format
	 *         Free text, suggested maximum length 500 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ReissueDescription}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J366}<br/>
	 *        {@link org.editeur.onix.v30.references.ReissueDescription}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J366}<br/>
	 */
	ReissueDescription,

	/**
	 * A group of data elements which together specify a territorial market and the identity of a sales agent or local publisher responsible for marketing the
	 * product therein. Optional and repeatable.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.MarketRepresentation}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Marketrepresentation}<br/>
	 */
	MarketRepresentation,

	/**
	 * A group of data elements together defining the identifier of an agent or local publisher in accordance with a specified scheme. Optional, but each
	 * occurrence of the &lt;MarketRepresentation&gt; composite must carry either at least one agent identifier, or an &lt;AgentName&gt;. Repeatable only if two
	 * or more identifiers are sent using different schemes.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.AgentIdentifier}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Agentidentifier}<br/>
	 *        {@link org.editeur.onix.v30.references.AgentIdentifier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Agentidentifier}<br/>
	 */
	AgentIdentifier,

	/**
	 * An ONIX code identifying the scheme from which the identifier in the &lt;IDValue&gt; element is taken. Mandatory in each occurrence of the
	 * &lt;AgentIdentifier&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, 2 numeric digits
	 * @codelist
	 *           List 92
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.AgentIDType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J400}<br/>
	 *        {@link org.editeur.onix.v30.references.AgentIDType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J400}<br/>
	 */
	AgentIDType,

	/**
	 * The name of an agent or local publisher. Optional and non-repeating; required if no agent identifier is sent in an occurrence of the
	 * &lt;MarketRepresentation&gt; composite.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.AgentName}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J401}<br/>
	 *        {@link org.editeur.onix.v30.references.AgentName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J401}<br/>
	 */
	AgentName,

	/**
	 * An ONIX code identifying the role of an agent in relation to the product in the specified market,
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 69
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.AgentRole}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J402}<br/>
	 *        {@link org.editeur.onix.v30.references.AgentRole}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J402}<br/>
	 */
	AgentRole,

	/**
	 * One or more ISO standard codes identifying a country in which the agent or local publisher markets the product. Successive codes are separated by spaces.
	 * Thus, a single occurrence of the element can carry an unlimited number of country codes. Optional, but each occurrence of the
	 * &lt;MarketRepresentation&gt; composite must carry either an occurrence of &lt;MarketCountry&gt; or an occurrence of &lt;MarketTerritory&gt;, to specify
	 * the market concerned. Non-repeating.
	 * 
	 * @format
	 *         One or more fixed-length codes, each with two upper case letters, successive codes being separated by spaces. Suggested maximum length 600
	 *         characters. [Note that ISO 3166-1 specifies that country codes shall be sent as upper case only.]
	 * @codelist
	 *           ISO 3166-1 two-letter country codes –
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.MarketCountry}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J403}<br/>
	 */
	MarketCountry,

	/**
	 * One or more ONIX codes identifying a territory which is not a country, but which is precisely defined in geographical terms,
	 * 
	 * @format
	 *         One or more variable-length codes, each consisting of upper case letters with or without a hyphen, successive codes being separated by spaces.
	 *         Suggested maximum length 100 characters.
	 * @codelist
	 *           List 49
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.MarketTerritory}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J404}<br/>
	 */
	MarketTerritory,

	/**
	 * One or more ISO standard codes identifying a country which is excluded from a territory specified in &lt;MarketTerritory&gt;. Successive codes are
	 * separated by spaces. Thus, a single occurrence of the element can carry an unlimited number of country codes. Optional and non-repeating.
	 * 
	 * @format
	 *         One or more fixed-length codes, each with two upper case letters, successive codes being separated by spaces. Suggested maximum length 300
	 *         characters. [Note that ISO 3166-1 specifies that country codes shall be sent as upper case only.]
	 * @codelist
	 *           ISO 3166-1 two-letter country codes –
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.MarketCountryExcluded}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J405}<br/>
	 */
	MarketCountryExcluded,

	/**
	 * A free text field describing a non-geographical restriction of the market covered by a sales agent or local publisher. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.MarketRestrictionDetail}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J406}<br/>
	 */
	MarketRestrictionDetail,

	/**
	 * An ONIX code which identifies the status of a published product in the market defined in an occurrence of the &lt;MarketRepresentation&gt; composite.
	 * Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 68
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.MarketPublishingStatus}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J407}<br/>
	 *        {@link org.editeur.onix.v30.references.MarketPublishingStatus}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J407}<br/>
	 */
	MarketPublishingStatus,

	/**
	 * A repeatable group of data elements which together specify a date associated with the publishing status of the product in the market identified in an
	 * occurrence of the &lt;MarketRepresentation&gt; composite,
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.MarketDate}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Marketdate}<br/>
	 *        {@link org.editeur.onix.v30.references.MarketDate}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Marketdate}<br/>
	 */
	MarketDate,

	/**
	 * An ONIX code indicating the significance of the date. Mandatory in each occurrence of the &lt;MarketDate&gt; composite.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 67
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.MarketDateRole}<br/>
	 *        {@link org.editeur.onix.v21.shorts.J408}<br/>
	 *        {@link org.editeur.onix.v30.references.MarketDateRole}<br/>
	 *        {@link org.editeur.onix.v30.shorts.J408}<br/>
	 */
	MarketDateRole,

	/**
	 * Free text describing the promotion and adverting campaign for the product. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 1,000 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.PromotionCampaign}<br/>
	 *        {@link org.editeur.onix.v21.shorts.K165}<br/>
	 *        {@link org.editeur.onix.v30.references.PromotionCampaign}<br/>
	 *        {@link org.editeur.onix.v30.shorts.K165}<br/>
	 */
	PromotionCampaign,

	/**
	 * Free text giving the name, department, phone number, email address
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.PromotionContact}<br/>
	 *        {@link org.editeur.onix.v21.shorts.K166}<br/>
	 *        {@link org.editeur.onix.v30.references.PromotionContact}<br/>
	 *        {@link org.editeur.onix.v30.shorts.K166}<br/>
	 */
	PromotionContact,

	/**
	 * In advance information about a new book, free text detailing the number of copies which will be printed and any related aspects of the initial publishing
	 * effort. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 200 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.InitialPrintRun}<br/>
	 *        {@link org.editeur.onix.v21.shorts.K167}<br/>
	 *        {@link org.editeur.onix.v30.references.InitialPrintRun}<br/>
	 *        {@link org.editeur.onix.v30.shorts.K167}<br/>
	 */
	InitialPrintRun,

	/**
	 * Free text used to give details of the reprint history as part of the promotion of a book. Optional, and repeatable to give information about successive
	 * reprintings.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 200 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.ReprintDetail}<br/>
	 *        {@link org.editeur.onix.v21.shorts.K309}<br/>
	 *        {@link org.editeur.onix.v30.references.ReprintDetail}<br/>
	 *        {@link org.editeur.onix.v30.shorts.K309}<br/>
	 */
	ReprintDetail,

	/**
	 * Free text detailing the number of copies already sold,
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 200 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.CopiesSold}<br/>
	 *        {@link org.editeur.onix.v21.shorts.K168}<br/>
	 *        {@link org.editeur.onix.v30.references.CopiesSold}<br/>
	 *        {@link org.editeur.onix.v30.shorts.K168}<br/>
	 */
	CopiesSold,

	/**
	 * Free text describing the adoption of the product as a book club selection. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 200 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.BookClubAdoption}<br/>
	 *        {@link org.editeur.onix.v21.shorts.K169}<br/>
	 *        {@link org.editeur.onix.v30.references.BookClubAdoption}<br/>
	 *        {@link org.editeur.onix.v30.shorts.K169}<br/>
	 */
	BookClubAdoption,

	/**
	 * A group of data elements which together constitute a message header. The elements may alternatively be sent without being grouped into a composite, but
	 * the composite approach is recommended since it makes it easier to maintain a standard header “package” to drop into any new ONIX Product Information
	 * Message.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.Header}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Header}<br/>
	 *        {@link org.editeur.onix.v30.references.Header}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Header}<br/>
	 */
	Header,

	/**
	 * An EAN location number which identifies the sender of an ONIX message. Optional and non-repeating; but either the &lt;FromCompany&gt; element or a sender
	 * identifier using one or more elements from MH.1 to MH.5 must be included.
	 * 
	 * @format
	 *         Fixed-length, thirteen numeric digits, of which the last is a check digit.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.FromEANNumber}<br/>
	 *        {@link org.editeur.onix.v21.shorts.M172}<br/>
	 */
	FromEANNumber,

	/**
	 * A US book trade Standard Address Number which identifies the sender of an ONIX message. Optional and non-repeating; but either the &lt;FromCompany&gt;
	 * element or a sender identifier using one or more elements from MH.1 to MH.5 must be included.
	 * 
	 * @format
	 *         Fixed-length, seven characters. The first six are numeric digits, and the seventh is a check character which may be a numeric digit or letter X.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.FromSAN}<br/>
	 *        {@link org.editeur.onix.v21.shorts.M173}<br/>
	 */
	FromSAN,

	/**
	 * A group of data elements which together define the identifier of the sender within a specified namespace, used here to allow different party identifiers
	 * to be included without defining additional data elements. In particular the composite allows a proprietary identifier to be used by mutual agreement
	 * between parties to an exchange. The composite is optional and repeatable; but either the &lt;FromCompany&gt; element or a sender identifier using one or
	 * more elements from MH.1 to MH.5 must be included.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.SenderIdentifier}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Senderidentifier}<br/>
	 *        {@link org.editeur.onix.v30.references.SenderIdentifier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Senderidentifier}<br/>
	 */
	SenderIdentifier,

	/**
	 * An ONIX code identifying the namespace from which the identifier in the &lt;IDValue&gt; element is taken. Mandatory in any occurrence of the
	 * &lt;SenderIdentifier&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 44
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.SenderIDType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.M379}<br/>
	 *        {@link org.editeur.onix.v30.references.SenderIDType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.M379}<br/>
	 */
	SenderIDType,

	/**
	 * The name of the sender organization, which should always be stated in a standard form agreed with the addressee. Optional and non-repeating; but either
	 * the &lt;FromCompany&gt; element or a sender identifier using one or more elements from MH.1 to MH.5 must be included.
	 * 
	 * @format
	 *         Variable-length ASCII text, suggested maximum 30 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.FromCompany}<br/>
	 *        {@link org.editeur.onix.v21.shorts.M174}<br/>
	 */
	FromCompany,

	/**
	 * Free text giving the name, department, phone number,
	 * 
	 * @format
	 *         Variable-length ASCII text, suggested maximum 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.FromPerson}<br/>
	 *        {@link org.editeur.onix.v21.shorts.M175}<br/>
	 */
	FromPerson,

	/**
	 * A text field giving the email address for a contact person in the sender organization who is responsible for the content of the message. Optional and
	 * non-repeating.
	 * 
	 * @format
	 *         Variable-length ASCII text, suggested maximum 100 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.FromEmail}<br/>
	 *        {@link org.editeur.onix.v21.shorts.M283}<br/>
	 */
	FromEmail,

	/**
	 * An EAN location number which identifies the addressee of an ONIX message. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, thirteen numeric digits, of which the last is a check digit.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ToEANNumber}<br/>
	 *        {@link org.editeur.onix.v21.shorts.M176}<br/>
	 */
	ToEANNumber,

	/**
	 * A US book trade Standard Address Number which identifies the addressee of an ONIX message. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, seven characters. The first six are numeric digits, and the seventh is a check character which may be a numeric digit or letter X.
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ToSAN}<br/>
	 *        {@link org.editeur.onix.v21.shorts.M177}<br/>
	 */
	ToSAN,

	/**
	 * A group of data elements which together define the identifier of the addressee within a specified namespace, used here to allow different party
	 * identifiers to be included without defining additional data elements. In particular the composite allows a proprietary identifier to be used by mutual
	 * agreement between parties to an exchange. The composite is optional and repeatable.
	 * 
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.AddresseeIdentifier}<br/>
	 *        {@link org.editeur.onix.v21.shorts.Addresseeidentifier}<br/>
	 *        {@link org.editeur.onix.v30.references.AddresseeIdentifier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Addresseeidentifier}<br/>
	 */
	AddresseeIdentifier,

	/**
	 * An ONIX code identifying the namespace from which the identifier in the &lt;IDValue&gt; element is taken. Mandatory in any occurrence of the
	 * &lt;AddresseeIdentifier&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits
	 * @codelist
	 *           List 44
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.AddresseeIDType}<br/>
	 *        {@link org.editeur.onix.v21.shorts.M380}<br/>
	 *        {@link org.editeur.onix.v30.references.AddresseeIDType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.M380}<br/>
	 */
	AddresseeIDType,

	/**
	 * The name of the addressee organization, which should always be stated in a standard form agreed with the addressee. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length ASCII text, suggested maximum 30 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ToCompany}<br/>
	 *        {@link org.editeur.onix.v21.shorts.M178}<br/>
	 */
	ToCompany,

	/**
	 * Free text giving the name, department
	 * 
	 * @format
	 *         Variable-length ASCII text, suggested maximum 300 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.ToPerson}<br/>
	 *        {@link org.editeur.onix.v21.shorts.M179}<br/>
	 */
	ToPerson,

	/**
	 * A sequence number of the messages in a series sent between trading partners, to enable the receiver to check against gaps and duplicates. Optional and
	 * non-repeating.
	 * 
	 * @format
	 *         Variable-length integer,
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.MessageNumber}<br/>
	 *        {@link org.editeur.onix.v21.shorts.M180}<br/>
	 *        {@link org.editeur.onix.v30.references.MessageNumber}<br/>
	 *        {@link org.editeur.onix.v30.shorts.M180}<br/>
	 */
	MessageNumber,

	/**
	 * A number which distinguishes any repeat transmissions of a message. If this element is used, the original is numbered 1 and repeats are numbered 2, 3
	 * 
	 * @format
	 *         Variable-length integer
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.MessageRepeat}<br/>
	 *        {@link org.editeur.onix.v21.shorts.M181}<br/>
	 *        {@link org.editeur.onix.v30.references.MessageRepeat}<br/>
	 *        {@link org.editeur.onix.v30.shorts.M181}<br/>
	 */
	MessageRepeat,

	/**
	 * The date on which the message is sent. Optionally, the time may be added, using the 24-hour clock. Mandatory and non-repeating.
	 * 
	 * @format
	 *         Eight or twelve numeric digits only (YYYYMMDD or YYYYMMDDHHMM)
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.SentDate}<br/>
	 *        {@link org.editeur.onix.v21.shorts.M182}<br/>
	 */
	SentDate,

	/**
	 * Free text giving additional information about the message. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length ASCII text, suggested maximum 500 characters
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.MessageNote}<br/>
	 *        {@link org.editeur.onix.v21.shorts.M183}<br/>
	 *        {@link org.editeur.onix.v30.references.MessageNote}<br/>
	 *        {@link org.editeur.onix.v30.shorts.M183}<br/>
	 */
	MessageNote,

	/**
	 * An ISO standard code indicating the default language which is assumed for the text of products listed in the message, unless explicitly stated otherwise
	 * by sending a “language of text” element in the product record. This default will be assumed for all product records which do not specify a language in
	 * Group PR.11. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, three letters.
	 * @codelist
	 *           List 74
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.DefaultLanguageOfText}<br/>
	 *        {@link org.editeur.onix.v21.shorts.M184}<br/>
	 *        {@link org.editeur.onix.v30.references.DefaultLanguageOfText}<br/>
	 *        {@link org.editeur.onix.v30.shorts.M184}<br/>
	 */
	DefaultLanguageOfText,

	/**
	 * An ONIX code indicating the default price type which is assumed for prices listed in the message, unless explicitly stated otherwise in a &lt;Price&gt;
	 * composite in the product record. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two numeric digits.
	 * @codelist
	 *           List 58
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.DefaultPriceTypeCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.M185}<br/>
	 */
	DefaultPriceTypeCode,

	/**
	 * An ISO standard code indicating the currency which is assumed for prices listed in the message, unless explicitly stated otherwise in a &lt;Price&gt;
	 * composite in the product record. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, three letters.
	 * @codelist
	 *           List 96
	 * @version
	 *          2.1.04, April 2011
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v21.references.DefaultCurrencyCode}<br/>
	 *        {@link org.editeur.onix.v21.shorts.M186}<br/>
	 *        {@link org.editeur.onix.v30.references.DefaultCurrencyCode}<br/>
	 *        {@link org.editeur.onix.v30.shorts.M186}<br/>
	 */
	DefaultCurrencyCode,

	/**
	 * A code indicating the default unit which is assumed for linear measurements listed in the message, unless otherwise specified in the product record.
	 * 
	 * @format
	 *         Fixed-length, two letters.
	 * @codelist
	 *           List 94
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.DefaultLinearUnit}<br/>
	 *        {@link org.editeur.onix.v21.shorts.M187}<br/>
	 */
	DefaultLinearUnit,

	/**
	 * A code indicating the default unit which is assumed for weights listed in the message, unless otherwise specified in the product record.
	 * 
	 * @format
	 *         Fixed-length, two letters.
	 * @codelist
	 *           List 95
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.DefaultWeightUnit}<br/>
	 *        {@link org.editeur.onix.v21.shorts.M188}<br/>
	 */
	DefaultWeightUnit,

	/**
	 * Free text indicating the class of trade which is assumed for prices given in the message, unless explicitly stated otherwise specified in &lt;j149&gt;.
	 * For example: Institutional, General trade, Wholesale distributor, which may be represented by a suitable code or abbreviation agreed between trading
	 * partners. otherwise specified in the product record. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable length ASCII text, suggested maximum length 50 characters
	 * @version
	 *          2.1.04, April 2011
	 * @links
	 *        {@link org.editeur.onix.v21.references.DefaultClassOfTrade}<br/>
	 *        {@link org.editeur.onix.v21.shorts.M193}<br/>
	 */
	DefaultClassOfTrade,

	/**
	 * A group of data elements which together specify the sender of an ONIX for Books message. Mandatory in any ONIX for Books message, and non-repeating.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.Sender}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Sender}<br/>
	 */
	Sender,

	/**
	 * The name of the sender organization, which should always be stated in a standard form agreed with the addressee. Optional and non-repeating; but
	 * 
	 * @format
	 *         Variable-length text, suggested maximum 50 characters
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.SenderName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X298}<br/>
	 */
	SenderName,

	/**
	 * A group of data elements which together specify the addressee of an ONIX for Books message. Optional, and repeatable if there are several addressees.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.Addressee}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Addressee}<br/>
	 */
	Addressee,

	/**
	 * The name of the addressee organization, which should always be stated in a standard form agreed with the addressee. Optional and non-repeating; but
	 * 
	 * @format
	 *         Variable-length text, suggested maximum 50 characters
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.AddresseeName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X300}<br/>
	 */
	AddresseeName,

	/**
	 * The date on which the message is sent. Optionally, the time may be added, using the 24-hour clock, with an explicit indication of the time zone if
	 * required, in a format based on ISO 8601. Mandatory and non-repeating.
	 * 
	 * @format
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.SentDateTime}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X307}<br/>
	 */
	SentDateTime,

	/**
	 * An ONIX code indicating the default price type which is assumed for prices listed in the message, unless explicitly stated otherwise in a &lt;Price&gt;
	 * composite in the product record. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 58
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.DefaultPriceType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X310}<br/>
	 */
	DefaultPriceType,

	/**
	 * An ONIX code identifying the scheme from which the identifier in the &lt;IDValue&gt; element is taken. Mandatory in each occurrence of the
	 * &lt;RecordSourceIdentifier&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 44
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.RecordSourceIDType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X311}<br/>
	 */
	RecordSourceIDType,

	/**
	 * An ONIX code indicating whether, and in what form, a barcode is carried on a product. Mandatory in any instance of the &lt;Barcode&gt; composite, and
	 * non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 141
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.BarcodeType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X312}<br/>
	 */
	BarcodeType,

	/**
	 * An ONIX code indicating a position on a product; in this case, the position in which a barcode appears. Required if the &lt;BarcodeType&gt; element
	 * indicates that the barcode appears on the product, even if the position is ‘unknown’. Omitted if the &lt;BarcodeType&gt; element specifies that the
	 * product does not carry a barcode. Non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 142
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PositionOnProduct}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X313}<br/>
	 */
	PositionOnProduct,

	/**
	 * The descriptive detail block covers data element Groups P.3 to P.13, all of which are essentially part of the factual description of the form and content
	 * of a product. The block as a whole is non-repeating. It is mandatory in any &lt;Product&gt; record unless the &lt;NotificationType&gt; in Group&nbsp;P.1
	 * indicates that the record is an update notice which carries only those blocks in which changes have occurred.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.DescriptiveDetail}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Descriptivedetail}<br/>
	 */
	DescriptiveDetail,

	/**
	 * An ONIX code which indicates whether a product consists of a single item or multiple items. Mandatory in an occurrence of &lt;DescriptiveDetail&gt;, and
	 * non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 2
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ProductComposition}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X314}<br/>
	 */
	ProductComposition,

	/**
	 * An ONIX code which indicates the primary or only content type included in a product. The element is intended to be used in particular for digital
	 * products, when the sender wishes to make it clear that one of a number of content types (
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 81
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PrimaryContentType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X416}<br/>
	 */
	PrimaryContentType,

	/**
	 * An ONIX code indicating the dimension which is specified by an occurrence of the measure composite. Mandatory in each occurrence of the &lt;Measure&gt;
	 * composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 48
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.MeasureType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X315}<br/>
	 */
	MeasureType,

	/**
	 * An ISO code identifying the country of manufacture of a single-item product, or of a multiple-item product when all items are manufactured in the same
	 * country. This information is needed in some countries to meet regulatory requirements. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two letters. Note that ISO 3166-1 specifies that country codes shall be sent as upper case only
	 * @codelist
	 *           ISO 3166-1 two-letter country codes, see
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.CountryOfManufacture}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X316}<br/>
	 */
	CountryOfManufacture,

	/**
	 * An ONIX code specifying whether a digital product has DRM or other technical protection features. Optional and repeatable, if a product has two or more
	 * kinds of protection.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 144
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.EpubTechnicalProtection}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X317}<br/>
	 */
	EpubTechnicalProtection,

	/**
	 * An optional and repeatable group of data elements which together describe a usage constraint on a digital product (or the absence of such a constraint),
	 * whether enforced by DRM technical protection, inherent in the platform used, or specified by license agreement.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.EpubUsageConstraint}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Epubusageconstraint}<br/>
	 */
	EpubUsageConstraint,

	/**
	 * An ONIX code specifying a usage of a digital product. Mandatory in each occurrence of the &lt;EpubUsageConstraint&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed length, two digits
	 * @codelist
	 *           List 145
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.EpubUsageType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X318}<br/>
	 */
	EpubUsageType,

	/**
	 * An ONIX code specifying the status of a usage of a digital product,
	 * 
	 * @format
	 *         Fixed length, two digits
	 * @codelist
	 *           List 146
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.EpubUsageStatus}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X319}<br/>
	 */
	EpubUsageStatus,

	/**
	 * An optional and repeatable group of data elements which together specify a quantitative limit on a particular type of usage of a digital product.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.EpubUsageLimit}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Epubusagelimit}<br/>
	 */
	EpubUsageLimit,

	/**
	 * A numeric value representing the maximum permitted quantity of a particular type of usage. Mandatory in each occurrence of the &lt;EpubUsageLimit&gt;
	 * composite, and non-repeating.
	 * 
	 * @format
	 *         Variable length, decimal number
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.Quantity}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X320}<br/>
	 */
	Quantity,

	/**
	 * An ONIX code for a unit in which a permitted usage quantity is stated. Mandatory in each occurrence of the &lt;EpubUsageLimit&gt; composite, and
	 * non-repeating.
	 * 
	 * @format
	 *         Fixed length, two digits
	 * @codelist
	 *           List 147
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.EpubUsageUnit}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X321}<br/>
	 */
	EpubUsageUnit,

	/**
	 * A repeatable group of data elements which together describe an item which is part of or contained within a multiple-item product or a trade pack. The
	 * composite must be used with all multiple-item products to specify (for example) the item(s) and item quantities included in a multi-volume set, a filled
	 * dumpbin, or a classroom pack. In other cases, where parts are not individually identified, it is used to state the product form(s) and the quantity or
	 * quantities of each form contained within the product.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ProductPart}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Productpart}<br/>
	 */
	ProductPart,

	/**
	 * An empty element that allows a sender to identify a product part as the ‘primary’ part of a multiple-item product. For example, in a ‘book and toy’ or
	 * ‘book and DVD’ product, the book may be regarded as the primary part. Optional and non-repeating.
	 * 
	 * @format
	 *         XML empty element
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PrimaryPart}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X457}<br/>
	 */
	PrimaryPart,

	/**
	 * When product parts are listed as a specified number of
	 * 
	 * @format
	 *         Variable-length integer, maximum four digits
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.NumberOfItemsOfThisForm}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X322}<br/>
	 */
	NumberOfItemsOfThisForm,

	/**
	 * When product parts are listed as a specified number of copies of a single item, usually identified by a &lt;ProductIdentifier&gt;, &lt;NumberOfCopies&gt;
	 * must be used to specify the quantity, even if the number is ‘1’. It must be used when a multiple-item product or pack contains (a) a quantity of a single
	 * item; or (b) one of each of several different items (as in a multi-volume set); or (c) one or more of each of several different items (as in a dumpbin
	 * carrying copies of two different books, or a classroom pack containing a teacher’s text and twenty student texts). Consequently the element is mandatory,
	 * and non-repeating, in an occurrence of the &lt;ProductPart&gt; composite if &lt;NumberOfItemsOfThisForm&gt; is not present. It is normally accompanied by
	 * a &lt;ProductIdentifier&gt;; but in exceptional circumstances, if the sender’s system is unable to provide an identifier at this level, it may be sent
	 * with product form coding and without an ID.
	 * 
	 * @format
	 *         Variable-length integer, maximum four digits
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.NumberOfCopies}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X323}<br/>
	 */
	NumberOfCopies,

	/**
	 * A repeatable group of data elements which carry attributes of a collection of which the product is part. The composite is optional.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.Collection}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Collection}<br/>
	 */
	Collection,

	/**
	 * An ONIX code indicating the type of a collection: publisher collection, ascribed collection, or unspecified. Mandatory in each occurrence of the
	 * &lt;Collection&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length text, two digits
	 * @codelist
	 *           List 148
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.CollectionType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X329}<br/>
	 */
	CollectionType,

	/**
	 * If the &lt;CollectionType&gt; code indicates an ascribed collection (
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 50 characters
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.SourceName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X330}<br/>
	 */
	SourceName,

	/**
	 * A repeatable group of data elements which together define an identifier of a bibliographic collection. The composite is optional, and may only repeat if
	 * two or more identifiers of different types are sent. It is not permissible to have two identifiers of the same type.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.CollectionIdentifier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Collectionidentifier}<br/>
	 */
	CollectionIdentifier,

	/**
	 * An ONIX code identifying a scheme from which an identifier in the &lt;IDValue&gt; element is taken. Mandatory in each occurrence of the
	 * &lt;CollectionIdentifier&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length text, two digits
	 * @codelist
	 *           List 13
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.CollectionIDType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X344}<br/>
	 */
	CollectionIDType,

	/**
	 * An optional and repeatable group of data elements which indicates some ordinal position of a product within a collection. Different ordinal positions may
	 * be specified using separate repeats of the composite – for example, a product may be published first while also being third in narrative order within a
	 * collection.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.CollectionSequence}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Collectionsequence}<br/>
	 */
	CollectionSequence,

	/**
	 * An ONIX code identifying the type of ordering used for the product’s sequence number within the collection. Mandatory and non-repeating within the
	 * &lt;CollectionSequence&gt; composite.
	 * 
	 * @format
	 *         Fixed length text, two digits
	 * @codelist
	 *           List 197
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.CollectionSequenceType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X479}<br/>
	 */
	CollectionSequenceType,

	/**
	 * A name which describes a proprietary order used for the product’s sequence number within the collection. Must be included when, and only when, the code
	 * in the &lt;CollectionSequenceType&gt; field indicates a proprietary scheme. Optional and non-repeating.
	 * 
	 * @format
	 *         Variable length text, suggested maximum length 50 characters
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.CollectionSequenceTypeName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X480}<br/>
	 */
	CollectionSequenceTypeName,

	/**
	 * A number which specifies the ordinal position of the product in a collection. The ordinal position may be a simple number (1st, 2nd, 3rd
	 * 
	 * @format
	 *         Variable-length string of one or more integers, each successive integer being separated by a period character, suggested maximum length 100
	 *         characters
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.CollectionSequenceNumber}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X481}<br/>
	 */
	CollectionSequenceNumber,

	/**
	 * A repeatable group of data elements which together give the text of a collection title and specify its type. Optional, but the composite is required
	 * unless the collection title is carried in full, and word-for-word, as an integral part of the product title in P.6, in which case it should not be
	 * repeated in P.5.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.TitleDetail}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Titledetail}<br/>
	 */
	TitleDetail,

	/**
	 * A repeatable group of data elements which together represent an element of a collection title. At least one title element is mandatory in each occurrence
	 * of the &lt;TitleDetail&gt; composite. An instance of the &lt;TitleElement&gt; composite must include at least one of: &lt;PartNumber&gt;;
	 * &lt;YearOfAnnual&gt;; &lt;TitleText&gt;, or &lt;TitlePrefix&gt; together with &lt;TitleWithoutPrefix&gt;. In other words it
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.TitleElement}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Titleelement}<br/>
	 */
	TitleElement,

	/**
	 * An ONIX code indicating the level of a title element: collection level, subcollection level, or product level. Mandatory in each occurrence of the
	 * &lt;TitleElement&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length text, two digits
	 * @codelist
	 *           List 149
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.TitleElementLevel}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X409}<br/>
	 */
	TitleElementLevel,

	/**
	 * When a title element includes a part designation within a larger whole (
	 * 
	 * @format
	 *         Variable-length text, suggested maximum 20 characters
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PartNumber}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X410}<br/>
	 */
	PartNumber,

	/**
	 * Free text showing how the collection title should be presented in any display, particularly when a standard concatenation of individual title elements
	 * from Group&nbsp;P.5 (in the order specified by the &lt;SequenceNumber&gt; data elements) would not give a satisfactory result. Optional and
	 * non-repeating. When this field is sent, the recipient should use it to replace all collection title detail sent in Group&nbsp;P.5 for display purposes
	 * only. The individual collection title element detail must also be sent, for indexing and retrieval.
	 * 
	 * @format
	 *         Variable length text, suggested maximum length 1000 characters. XHTML is enabled in this element – see
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.TitleStatement}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X478}<br/>
	 */
	TitleStatement,

	/**
	 * An empty element that provides a positive indication that a product does not belong to a collection (or ‘series’). This element is intended to be used in
	 * an ONIX accreditation scheme to confirm that collection information is being consistently supplied in publisher ONIX feeds. Optional and non-repeating.
	 * Must only be sent in a record that has no instances of the &lt;Collection&gt; composite
	 * 
	 * @format
	 *         XML empty element
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.NoCollection}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X411}<br/>
	 */
	NoCollection,

	/**
	 * Used only when the &lt;ContributorRole&gt; code value is B06, B08 or B10 indicating a translator, to specify the source language from which the
	 * translation was made. This element makes it possible to specify a translator’s exact responsibility when a work involves translation from two or more
	 * languages. Optional and repeatable in the event that a single person has been responsible for translation from two or more languages.
	 * 
	 * @format
	 *         Fixed-length, three lower-case letters. Note that ISO 639 specifies that these codes should always be in lower-case
	 * @codelist
	 *           ISO 639-2/B
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.FromLanguage}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X412}<br/>
	 */
	FromLanguage,

	/**
	 * Used only when the &lt;ContributorRole&gt; code value is B06, B08 or B10 indicating a translator, to specify the target language into which the
	 * translation was made. This element makes it possible to specify a translator’s exact responsibility when a work involves translation into two or more
	 * languages. Optional and repeatable in the event that a single person has been responsible for translation to two or more languages.
	 * 
	 * @format
	 *         Fixed-length, three lower-case letters. Note that ISO 639 specifies that these codes should always be in lower-case
	 * @codelist
	 *           ISO 639-2/B
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ToLanguage}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X413}<br/>
	 */
	ToLanguage,

	/**
	 * An ONIX code indicating the type of a primary name. Optional, and non-repeating. If omitted, the default is ‘unspecified’.
	 * 
	 * @format
	 *         Fixed length, two digits
	 * @codelist
	 *           List 18
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.NameType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X414}<br/>
	 */
	NameType,

	/**
	 * A repeatable group of data elements which together specify a name identifier, used here to carry an identifier for a person or organization name given in
	 * an occurrence of the &lt;Contributor&gt; composite. Optional: see Group&nbsp;P.7 introductory text for valid options.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.NameIdentifier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Nameidentifier}<br/>
	 */
	NameIdentifier,

	/**
	 * An ONIX code which identifies the scheme from which the value in the &lt;IDValue&gt; element is taken. Mandatory in each occurrence of the
	 * &lt;NameIdentifier&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed length, two digits
	 * @codelist
	 *           List 44
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.NameIDType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X415}<br/>
	 */
	NameIDType,

	/**
	 * The name of a corporate body which contributed to the creation of the product, presented in inverted order, with the element used for alphabetical
	 * sorting placed first. Optional and non-repeating: see Group&nbsp;P.7 introductory text for valid options.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 200 characters
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.CorporateNameInverted}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X443}<br/>
	 */
	CorporateNameInverted,

	/**
	 * A repeatable group of data elements which together represent an alternative name of a contributor, and specify its type. The &lt;AlternativeName&gt;
	 * composite is optional. It may be used to send a pseudonym as well as a real name, where both names are on the product,
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.AlternativeName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Alternativename}<br/>
	 */
	AlternativeName,

	/**
	 * A repeatable group of data elements which together specify a date associated with the person or organization identified in an occurrence of the
	 * &lt;Contributor&gt; composite,
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ContributorDate}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Contributordate}<br/>
	 */
	ContributorDate,

	/**
	 * An ONIX code indicating the significance of the date in relation to the contributor name. Mandatory in each occurrence of the &lt;ContributorDate&gt;
	 * composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 177
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ContributorDateRole}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X417}<br/>
	 */
	ContributorDateRole,

	/**
	 * An optional and repeatable group of data elements which together identify a geographical location with which a contributor is associated, used to support
	 * ‘local interest’ promotions.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ContributorPlace}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Contributorplace}<br/>
	 */
	ContributorPlace,

	/**
	 * An ONIX code identifying the relationship between a contributor and a geographical location. Mandatory in each occurrence of &lt;ContributorPlace&gt; and
	 * non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 151
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ContributorPlaceRelator}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X418}<br/>
	 */
	ContributorPlaceRelator,

	/**
	 * An ONIX code, indicating the type of a version or edition. Optional, and repeatable if the product has characteristics of two or more types (
	 * 
	 * @format
	 *         Fixed-length, three upper-case letters
	 * @codelist
	 *           List 21
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.EditionType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X419}<br/>
	 */
	EditionType,

	/**
	 * An ONIX code indicating a religious text other than the Bible. Mandatory in each occurrence of the &lt;ReligiousText&gt; composite that does
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 88
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ReligiousTextIdentifier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.B376}<br/>
	 */
	ReligiousTextIdentifier,

	/**
	 * A code identifying the script in which the language is represented. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, four letters. Note that ISO 15924 specifies that script codes shall be sent as one upper case followed by three lower case letters
	 * @codelist
	 *           ISO 15924 four-letter script codes
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ScriptCode}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X420}<br/>
	 */
	ScriptCode,

	/**
	 * The value of the extent expressed in Roman numerals. Optional, and non-repeating. Used only for page runs which are numbered in Roman.
	 * 
	 * @format
	 *         Letters forming a valid Roman numeral
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ExtentValueRoman}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X421}<br/>
	 */
	ExtentValueRoman,

	/**
	 * An ONIX code indicating whether a book or other textual (usually printed) product has illustrations. The more informative free text field
	 * &lt;IllustrationsNote&gt; and/or the &lt;AncillaryContent&gt; composite are strongly preferred. This element has been added specifically to cater for a
	 * situation where a sender of product information maintains only a yes/no flag, and it should not otherwise be used. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 152
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.Illustrated}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X422}<br/>
	 */
	Illustrated,

	/**
	 * A repeatable group of data elements which together specify the number of illustrations or other content items of a stated type which the product carries.
	 * Use of the &lt;AncillaryContent&gt; composite is optional.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.AncillaryContent}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Ancillarycontent}<br/>
	 */
	AncillaryContent,

	/**
	 * An ONIX code which identifies the type of illustration or other content to which an occurrence of the composite refers. Mandatory in each occurrence of
	 * the &lt;AncillaryContent&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 25
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.AncillaryContentType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X423}<br/>
	 */
	AncillaryContentType,

	/**
	 * Text describing the type of illustration or other content to which an occurrence of the composite refers, when a code is insufficient. Optional and
	 * repeatable. Required when &lt;AncillaryContentType&gt; carries the value 00. The
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters. XHTML is enabled in this element – see
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.AncillaryContentDescription}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X424}<br/>
	 */
	AncillaryContentDescription,

	/**
	 * An optional and repeatable group of data elements which together represent the name of a person or organization that is part of the subject of a product.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.NameAsSubject}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Nameassubject}<br/>
	 */
	NameAsSubject,

	/**
	 * The collateral detail block covers data element Groups P.14 to P.17, all of which are primarily concerned with information and/or resources which in one
	 * way or another support the marketing of the product. The block as a whole is non-repeating. It is not mandatory within the &lt;Product&gt; record, nor
	 * are any of the individual sections mandatory within an occurrence of the block.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.CollateralDetail}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Collateraldetail}<br/>
	 */
	CollateralDetail,

	/**
	 * An optional and repeatable group of data elements which together carry text related to the product.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.TextContent}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Textcontent}<br/>
	 */
	TextContent,

	/**
	 * An ONIX code which identifies the type of text which is sent in the &lt;Text&gt; element. Mandatory in each occurrence of the &lt;TextContent&gt;
	 * composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 153
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.TextType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X426}<br/>
	 */
	TextType,

	/**
	 * An ONIX code which identifies the audience for which the &lt;Text&gt; element is intended. Mandatory in each occurrence of the &lt;TextContent&gt;
	 * composite, and repeatable.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 154
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ContentAudience}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X427}<br/>
	 */
	ContentAudience,

	/**
	 * The title of a publication from which the text sent in the &lt;Text&gt; element was taken,
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.SourceTitle}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X428}<br/>
	 */
	SourceTitle,

	/**
	 * An optional and repeatable group of data elements which together specify a date associated with the text carried in an occurrence of the
	 * &lt;TextContent&gt; composite,
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ContentDate}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Contentdate}<br/>
	 */
	ContentDate,

	/**
	 * An ONIX code indicating the significance of the date in relation to the text content. Mandatory in each occurrence of the &lt;ContentDate&gt; composite,
	 * and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 155
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ContentDateRole}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X429}<br/>
	 */
	ContentDateRole,

	/**
	 * An optional and repeatable group of data elements which together describe a piece of cited content.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.CitedContent}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Citedcontent}<br/>
	 */
	CitedContent,

	/**
	 * An ONIX code indicating the type of content which is being cited. Mandatory in each occurrence of the &lt;CitedContent&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 156
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.CitedContentType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X430}<br/>
	 */
	CitedContentType,

	/**
	 * An ONIX code indicating the type of source from which the cited material originated,
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 157
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.SourceType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X431}<br/>
	 */
	SourceType,

	/**
	 * The name of a bestseller list, when the &lt;CitedContent&gt; composite is used to refer to a position which a product has reached on such a list.
	 * Optional and non-repeating.
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 100 characters
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ListName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X432}<br/>
	 */
	ListName,

	/**
	 * The position that a product has reached on a bestseller list specified in &lt;ListName&gt;. Optional and non-repeating. The &lt;ListName&gt; element must
	 * also be present if &lt;PositionOnList&gt; is included.
	 * 
	 * @format
	 *         Variable-length integer, suggested maximum 3 characters
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PositionOnList}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X433}<br/>
	 */
	PositionOnList,

	/**
	 * A free text note giving any additional information about cited content, for example a detailed volume, issue and page reference to content cited from a
	 * periodical. Optional and repeatable when the text is provided in multiple languages. The
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters. XHTML is enabled in this element – see
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.CitationNote}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X434}<br/>
	 */
	CitationNote,

	/**
	 * A URI which provides a link to cited content which is accessible in digital form. Optional, and repeatable if the resource can be linked in more than one
	 * way,
	 * 
	 * @format
	 *         Uniform Resource Identifier, expressed in full URI syntax in accordance with W3C standards
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ResourceLink}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X435}<br/>
	 */
	ResourceLink,

	/**
	 * An optional and repeatable group of data elements which together describe a supporting resource.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.SupportingResource}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Supportingresource}<br/>
	 */
	SupportingResource,

	/**
	 * An ONIX code indicating the type of content carried in a supporting resource. Mandatory in each occurrence of the &lt;SupportingResource&gt; composite,
	 * and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 158
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ResourceContentType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X436}<br/>
	 */
	ResourceContentType,

	/**
	 * An ONIX code indicating the mode of the supporting resource,
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 159
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ResourceMode}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X437}<br/>
	 */
	ResourceMode,

	/**
	 * A repeatable group of data elements which together describe a feature of a supporting resource which is common to all versions in which the resource is
	 * offered. Optional.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ResourceFeature}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Resourcefeature}<br/>
	 */
	ResourceFeature,

	/**
	 * An ONIX code which specifies the feature described by an instance of the &lt;ResourceFeature&gt; composite. Mandatory in each occurrence of the
	 * composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 160
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ResourceFeatureType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X438}<br/>
	 */
	ResourceFeatureType,

	/**
	 * A controlled value that describes a resource feature. Presence or absence of this element depends on the &lt;ResourceFeatureType&gt;, since some features
	 * may not require an accompanying value, while others may require free text in &lt;FeatureNote&gt;; and others may have both code and free text.
	 * Non-repeating.
	 * 
	 * @format
	 *         Dependent on the scheme specified in &lt;ResourceFeatureType&gt;
	 * @codelist
	 *           Dependent on the scheme specified in &lt;ResourceFeatureType&gt;
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.FeatureValue}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X439}<br/>
	 */
	FeatureValue,

	/**
	 * If the &lt;ResourceFeatureType&gt; requires free text rather than a code value, or if the code in &lt;FeatureValue&gt; does not adequately describe the
	 * feature, a short text note may be added. Optional and repeatable when the note is provided in multiple languages. The
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters. XHTML is enabled in this element – see
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.FeatureNote}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X440}<br/>
	 */
	FeatureNote,

	/**
	 * A repeatable group of data elements which together describe a version of a supporting resource, for example a particular format of a cover image. At
	 * least one instance is mandatory in each occurrence of the &lt;SupportingResource&gt; composite.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ResourceVersion}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Resourceversion}<br/>
	 */
	ResourceVersion,

	/**
	 * An ONIX code indicating the form of a version of a supporting resource. Mandatory in each occurrence of the &lt;ResourceVersion&gt; composite, and
	 * non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 161
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ResourceForm}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X441}<br/>
	 */
	ResourceForm,

	/**
	 * A repeatable group of data elements which together describe a feature of a supporting resource which is specific to a version in which the resource is
	 * offered. Formally optional, but it is unlikely that a supporting resource version could be adequately described without specifying some of its features.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ResourceVersionFeature}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Resourceversionfeature}<br/>
	 */
	ResourceVersionFeature,

	/**
	 * An ONIX code which specifies a feature described by an instance of the &lt;ResourceVersionFeature&gt; composite. Mandatory in each occurrence of the
	 * composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 162
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ResourceVersionFeatureType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X442}<br/>
	 */
	ResourceVersionFeatureType,

	/**
	 * The content detail block comprises the single data element Group&nbsp;P.18. The block as a whole is non-repeating. It is not mandatory within the
	 * &lt;Product&gt; record, and is used only when there is a requirement to describe individual chapters or parts within a product in a fully structured way.
	 * The more usual ONIX practice is to send a table of contents as text, possibly in XHTML, in Group&nbsp;P.14.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ContentDetail}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Contentdetail}<br/>
	 */
	ContentDetail,

	/**
	 * A group of data elements which together describe a work which has a specified relationship to a content item. Optional and repeatable.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.RelatedWork}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Relatedwork}<br/>
	 */
	RelatedWork,

	/**
	 * The publishing detail block covers data element Groups P.19 to P.21, carrying information on the publisher(s), ‘global’ publishing status, and rights
	 * attaching to a product. The block as a whole is non-repeating. It is mandatory in any &lt;Product&gt; record unless the &lt;NotificationType&gt; in
	 * Group&nbsp;P.1 indicates that the record is an update notice which carries only those blocks in which changes have occurred.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PublishingDetail}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Publishingdetail}<br/>
	 */
	PublishingDetail,

	/**
	 * A group of data elements which together define the identifier of an imprint name. Optional and repeatable, but mandatory if the &lt;Imprint&gt; composite
	 * does not carry an &lt;ImprintName&gt;.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ImprintIdentifier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Imprintidentifier}<br/>
	 */
	ImprintIdentifier,

	/**
	 * An ONIX code which identifies the scheme from which the value in the &lt;IDValue&gt; element is taken. Mandatory in each occurrence of the
	 * &lt;ImprintIdentifier&gt; composite.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 44
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ImprintIDType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X445}<br/>
	 */
	ImprintIDType,

	/**
	 * A group of data elements which together define the identifier of a publisher name. Optional and repeatable, but mandatory if the &lt;Publisher&gt;
	 * composite does not carry a &lt;PublisherName&gt;.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PublisherIdentifier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Publisheridentifier}<br/>
	 */
	PublisherIdentifier,

	/**
	 * An ONIX code which identifies the scheme from which the value in the &lt;IDValue&gt; element is taken. Mandatory in each occurrence of the
	 * &lt;PublisherIdentifier&gt; composite.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 44
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PublisherIDType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X447}<br/>
	 */
	PublisherIDType,

	/**
	 * A group of data elements which together specify an organization (which may or may not be the publisher) responsible for dealing with enquiries related to
	 * the product.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ProductContact}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Productcontact}<br/>
	 */
	ProductContact,

	/**
	 * An ONIX code which identifies the role played by the product contact in relation to the product – for example answering enquiries related to sales or to
	 * promotion.
	 * 
	 * @format
	 *         Fixed length, two digits
	 * @codelist
	 *           List 198
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ProductContactRole}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X482}<br/>
	 */
	ProductContactRole,

	/**
	 * A group of data elements which together define an identifier of the product contact. The composite is optional, and repeatable if more than one
	 * identifier of different types is sent; but
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ProductContactIdentifier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Productcontactidentifier}<br/>
	 */
	ProductContactIdentifier,

	/**
	 * An ONIX code identifying a scheme from which an identifier in the &lt;IDValue&gt; element is taken. Mandatory in each occurrence of the
	 * &lt;ProductContactIdentifier&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed length, two digits
	 * @codelist
	 *           List 44
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ProductContactIDType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X483}<br/>
	 */
	ProductContactIDType,

	/**
	 * The name of the product contact organization, which should always be stated in a standard form. Optional and non-repeating; but
	 * 
	 * @format
	 *         Variable-length text, suggested maximum 50 characters
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ProductContactName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X484}<br/>
	 */
	ProductContactName,

	/**
	 * A repeatable group of data elements which together specify a date associated with the publishing of the product. Optional, but a date of publication
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PublishingDate}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Publishingdate}<br/>
	 */
	PublishingDate,

	/**
	 * An ONIX code indicating the significance of the date,
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 163
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PublishingDateRole}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X448}<br/>
	 */
	PublishingDateRole,

	/**
	 * The number of the most recent reprint (or current ‘impression number’) of the product. Optional and non-repeating. This element is used only in certain
	 * countries where there is a legal requirement to record reprints.
	 * 
	 * @format
	 *         Integer, suggested maximum three digits
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.LatestReprintNumber}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X446}<br/>
	 */
	LatestReprintNumber,

	/**
	 * One or more ISO standard codes identifying countries included in the territory. Successive codes must be separated by spaces. Optional and non-repeating,
	 * but either &lt;CountriesIncluded&gt; or &lt;RegionsIncluded&gt; is mandatory in each occurrence of the &lt;Territory&gt; composite.
	 * 
	 * @format
	 *         One or more fixed-length codes, each with two upper case letters, successive codes being separated by spaces. Suggested maximum length 600
	 *         characters. Note that ISO 3166-1 specifies that country codes shall be sent as upper case only
	 * @codelist
	 *           ISO 3166-1 two-letter country codes
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.CountriesIncluded}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X449}<br/>
	 */
	CountriesIncluded,

	/**
	 * One or more ONIX codes identifying regions included in the territory. A region is an area which is not a country, but which is precisely defined in
	 * geographical terms,
	 * 
	 * @format
	 *         One or more variable-length codes, each consisting of upper case letters with or without a hyphen, successive codes being separated by spaces.
	 *         Suggested maximum length 100 characters
	 * @codelist
	 *           List 49
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.RegionsIncluded}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X450}<br/>
	 */
	RegionsIncluded,

	/**
	 * One or more ISO standard codes identifying countries excluded from the territory. Successive codes must be separated by spaces. Optional and
	 * non-repeating, and can only occur if the &lt;RegionsIncluded&gt; element is also present and includes a supra-national region code (such as ‘World’).
	 * 
	 * @format
	 *         One or more fixed-length codes, each with two upper case letters, successive codes being separated by spaces. Suggested maximum length 600
	 *         characters. Note that ISO 3166-1 specifies that country codes shall be sent as upper case only
	 * @codelist
	 *           ISO 3166-1 two-letter country codes
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.CountriesExcluded}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X451}<br/>
	 */
	CountriesExcluded,

	/**
	 * One or more ONIX codes identifying regions excluded from the territory. Successive codes must be separated by spaces. Optional and non-repeating, and can
	 * only occur if the &lt;CountriesIncluded&gt; element is also present, or if &lt;RegionsIncluded&gt; is present and includes a supra-national region code
	 * (such as ‘World’).
	 * 
	 * @format
	 *         One or more variable-length codes, each consisting of upper case letters with or without a hyphen, successive codes being separated by spaces.
	 *         Suggested maximum length 100 characters
	 * @codelist
	 *           List 49
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.RegionsExcluded}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X452}<br/>
	 */
	RegionsExcluded,

	/**
	 * An ONIX code describing the sales rights applicable in territories not specifically associated with a sales right within an occurrence of the
	 * &lt;SalesRights&gt; composite. Optional, but required in all cases where a sales rights type is not associated with the region ‘WORLD’, and in all cases
	 * where a sales rights type is associated with ‘WORLD’ but with exclusions that are not themselves associated with a sales rights type. Not repeatable.
	 * Note the value ‘00’ should be used to indicate where sales rights are genuinely unknown, or are unstated for any reason – in this case, data recipients
	 * must not assume anything about the rights that are applicable.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 46
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ROWSalesRightsType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X456}<br/>
	 */
	ROWSalesRightsType,

	/**
	 * A free text field describing an ‘unspecified’ restriction, or giving more explanation of a coded restriction type. Optional and repeatable. The
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 300 characters. XHTML is enabled in this element – see
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.SalesRestrictionNote}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X453}<br/>
	 */
	SalesRestrictionNote,

	/**
	 * The related material block covers data element Groups P.22 and P.23, providing links to related works and related products. The block as a whole is
	 * optional and non-repeating.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.RelatedMaterial}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Relatedmaterial}<br/>
	 */
	RelatedMaterial,

	/**
	 * An ONIX code which identifies the nature of the relationship between a product and a work. Mandatory in each occurrence of the &lt;RelatedWork&gt;
	 * composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 164
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.WorkRelationCode}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X454}<br/>
	 */
	WorkRelationCode,

	/**
	 * An ONIX code which identifies the nature of the relationship between two products,
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 51
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ProductRelationCode}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X455}<br/>
	 */
	ProductRelationCode,

	/**
	 * The product supply block covers data element Groups P.24 to P.26, specifying a market, the publishing status of the product in that market, and the
	 * supply arrangements for the product in that market. The block is repeatable to describe multiple markets. At least one occurrence is expected in a
	 * &lt;Product&gt; record unless the &lt;NotificationType&gt; in Group&nbsp;P.1 indicates that the record is an update notice which carries only those
	 * blocks in which changes have occurred.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ProductSupply}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Productsupply}<br/>
	 */
	ProductSupply,

	/**
	 * A repeatable group of data elements which together give details of a geographical territory and any non-geographical sales restrictions that apply within
	 * it. Optional in terms of the schema definitions, but required in most ONIX applications.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.Market}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Market}<br/>
	 */
	Market,

	/**
	 * A group of data elements which together give details of the publishing status of a product within a specified market. Optional and non-repeating within
	 * an occurrence of the &lt;ProductSupply&gt; block.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.MarketPublishingDetail}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Marketpublishingdetail}<br/>
	 */
	MarketPublishingDetail,

	/**
	 * A repeatable group of data elements which together identify a publisher representative in a specified market. Optional, and repeated only if the
	 * publisher has two or more representatives.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PublisherRepresentative}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Publisherrepresentative}<br/>
	 */
	PublisherRepresentative,

	/**
	 * Free text that describes the status of a product in a specified market, when the code in &lt;MarketPublishingStatus&gt; is insufficient. Optional and
	 * repeatable, but must be accompanied by the &lt;MarketPublishingStatus&gt; element. The
	 * 
	 * @format
	 *         Variable-length text, suggested maximum 300 characters. XHTML is enabled in this element – see
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.MarketPublishingStatusNote}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X406}<br/>
	 */
	MarketPublishingStatusNote,

	/**
	 * A group of data elements which together define a supplier. Mandatory in each occurrence of the &lt;SupplyDetail&gt; composite, and not repeatable.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.Supplier}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Supplier}<br/>
	 */
	Supplier,

	/**
	 * An optional and repeatable group of data elements which together allow a supplier to send coded data of a specified type, using its own coding schemes.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.SupplierOwnCoding}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Supplierowncoding}<br/>
	 */
	SupplierOwnCoding,

	/**
	 * An ONIX code identifying the type of a supplier own code. Mandatory in each occurrence of the &lt;SupplierOwnCoding&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 165
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.SupplierCodeType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X458}<br/>
	 */
	SupplierCodeType,

	/**
	 * A supplier-defined code of the type specified in the &lt;SupplierCodeType&gt; element. Mandatory in each occurrence of the &lt;SupplierOwnCoding&gt;
	 * composite, and non-repeating.
	 * 
	 * @format
	 *         According to the supplier’s own format for the code type specified in &lt;SupplierCodeType&gt;
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.SupplierCodeValue}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X459}<br/>
	 */
	SupplierCodeValue,

	/**
	 * An optional and repeatable group of data elements which together allow returns conditions to be specified in coded form.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ReturnsConditions}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Returnsconditions}<br/>
	 */
	ReturnsConditions,

	/**
	 * A name which identifies a proprietary returns code scheme. Must be used when, and only when, the code in the &lt;ReturnsCodeType&gt; element indicates a
	 * proprietary scheme,
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 50 characters
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ReturnsCodeTypeName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X460}<br/>
	 */
	ReturnsCodeTypeName,

	/**
	 * An optional and repeatable group of data elements which together specify a date associated with the supply status of the product,
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.SupplyDate}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Supplydate}<br/>
	 */
	SupplyDate,

	/**
	 * An ONIX code indicating the significance of the date. Mandatory in each occurrence of the &lt;SupplyDate&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 166
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.SupplyDateRole}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X461}<br/>
	 */
	SupplyDateRole,

	/**
	 * An ONIX code indicating the type of the price in the &lt;PriceAmount&gt; field within the &lt;Price&gt; composite. Optional, provided that a
	 * &lt;DefaultPriceType&gt; has been specified in the message header, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 58
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PriceType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X462}<br/>
	 */
	PriceType,

	/**
	 * A repeatable group of data elements which together specify a condition relating to a price.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PriceCondition}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Pricecondition}<br/>
	 */
	PriceCondition,

	/**
	 * An ONIX code identifying a type of price condition. Mandatory in each occurrence of the &lt;PriceCondition&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 167
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PriceConditionType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X463}<br/>
	 */
	PriceConditionType,

	/**
	 * An optional and repeatable group of data elements which together specify a price condition quantity, for example a minimum number of copies, or a period
	 * of time for which updates are supplied or must be purchased.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PriceConditionQuantity}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Priceconditionquantity}<br/>
	 */
	PriceConditionQuantity,

	/**
	 * An ONIX code identifying a type of price condition quantity. Mandatory in each occurrence of the &lt;PriceConditionQuantity&gt; composite, and
	 * non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 168
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PriceConditionQuantityType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X464}<br/>
	 */
	PriceConditionQuantityType,

	/**
	 * An ONIX code value specifying the unit in which a price condition quantity is stated. Mandatory in each occurrence of the &lt;PriceConditionQuantity&gt;
	 * composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 169
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.QuantityUnit}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X466}<br/>
	 */
	QuantityUnit,

	/**
	 * A repeatable group of data elements which together define a discount either as a percentage or as an absolute amount. Optional. Used only when an ONIX
	 * message is sent within the context of a specific trading relationship.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.Discount}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Discount}<br/>
	 */
	Discount,

	/**
	 * An ONIX code identifying a discount type or reason. Optional, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 170
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.DiscountType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X467}<br/>
	 */
	DiscountType,

	/**
	 * A discount expressed as an absolute amount. Optional and non-repeating; but either &lt;DiscountPercent&gt; or &lt;DiscountAmount&gt; or both must be
	 * present in each occurrence of the &lt;Discount&gt; composite.
	 * 
	 * @format
	 *         Variable length real number, with explicit decimal point when required, suggested maximum length 12 characters
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.DiscountAmount}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X469}<br/>
	 */
	DiscountAmount,

	/**
	 * An optional group of data elements to carry a price that is expressed as one of a discrete set of price points, tiers or bands, rather than actual
	 * currency amounts. Each occurrence of the &lt;Price&gt; composite must include either a &lt;PriceAmount&gt; or a &lt;PriceCoded&gt; composite.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PriceCoded}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Pricecoded}<br/>
	 */
	PriceCoded,

	/**
	 * An ONIX code identifying the scheme from which the value in the &lt;PriceCode&gt; element is taken. Mandatory in an occurrence of the &lt;PriceCoded&gt;
	 * composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 179
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PriceCodeType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X465}<br/>
	 */
	PriceCodeType,

	/**
	 * A name which identifies a proprietary price code type. Must be used when, and only when the code in the &lt;PriceCodeType&gt; element indicates a
	 * proprietary scheme,
	 * 
	 * @format
	 *         Variable-length text, suggested maximum length 50 characters
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PriceCodeTypeName}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X477}<br/>
	 */
	PriceCodeTypeName,

	/**
	 * A price code from the scheme specified in the &lt;PriceCodeType&gt; element. Mandatory in each occurrence of the &lt;PriceCoded&gt; composite, and
	 * non-repeating.
	 * 
	 * @format
	 *         According to the scheme specified in &lt;PriceCodeType&gt;
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PriceCode}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X468}<br/>
	 */
	PriceCode,

	/**
	 * A repeatable group of data elements which together specify tax applicable to a price. Optional. For items to which two different taxes or tax rates apply
	 * (
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.Tax}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Tax}<br/>
	 */
	Tax,

	/**
	 * An ONIX code identifying a tax type,
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 171
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.TaxType}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X470}<br/>
	 */
	TaxType,

	/**
	 * An ONIX code which specifies a tax rate. Optional and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, one letter
	 * @codelist
	 *           List 62
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.TaxRateCode}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X471}<br/>
	 */
	TaxRateCode,

	/**
	 * A tax rate expressed numerically as a percentage. Optional and non-repeating; but either &lt;TaxRatePercent&gt; or &lt;TaxAmount&gt; or both must be
	 * present in each occurrence of the &lt;Tax&gt; composite.
	 * 
	 * @format
	 *         Variable length real number, with an explicit decimal point where required
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.TaxRatePercent}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X472}<br/>
	 */
	TaxRatePercent,

	/**
	 * The amount of the unit price of the product, excluding tax, which is taxable at the rate specified in an occurrence of the &lt;Tax&gt; composite.
	 * Optional and non-repeating; but required if tax is charged on part of the price. Omission of this element implies that tax is charged on the full amount
	 * of the price.
	 * 
	 * @format
	 *         Variable length real number, with explicit decimal point when required, suggested maximum length 12 characters
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.TaxableAmount}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X473}<br/>
	 */
	TaxableAmount,

	/**
	 * The amount of tax chargeable at the rate specified in an occurrence of the &lt;Tax&gt; composite. Optional and non-repeating; but either
	 * &lt;TaxRatePercent&gt; or &lt;TaxAmount&gt; or both must be present in each occurrence of the &lt;Tax&gt; composite.
	 * 
	 * @format
	 *         Variable length real number, with explicit decimal point when required, suggested maximum length 12 characters
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.TaxAmount}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X474}<br/>
	 */
	TaxAmount,

	/**
	 * An ONIX code identifying a currency zone in which the price stated in an occurrence of the &lt;Price&gt; composite is applicable. Optional and
	 * non-repeating. Deprecated – use Country or Region codes instead.
	 * 
	 * @format
	 *         Fixed-length, three letters
	 * @codelist
	 *           List 172
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.CurrencyZone}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X475}<br/>
	 */
	CurrencyZone,

	/**
	 * Optional and repeatable group of data elements that together define a price for a directly comparable product, to facilitate supply of price data to
	 * retailers who do not receive a full ONIX record for that comparable product. This is primarily intended for use within a &lt;Product&gt; record for a
	 * digital product, to provide a price for a comparable physical product.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.ComparisonProductPrice}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Comparisonproductprice}<br/>
	 */
	ComparisonProductPrice,

	/**
	 * An optional and repeatable group of data elements which together specify a date associated with a price.
	 * 
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PriceDate}<br/>
	 *        {@link org.editeur.onix.v30.shorts.Pricedate}<br/>
	 */
	PriceDate,

	/**
	 * An ONIX code indicating the significance of the date. Mandatory in each occurrence of the &lt;PriceDate&gt; composite, and non-repeating.
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 173
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PriceDateRole}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X476}<br/>
	 */
	PriceDateRole,

	/**
	 * An ONIX code indicating whether the price in a &lt;Price&gt; composite is printed on the product. Optional and non-repeating. Omission of this element
	 * must
	 * 
	 * @format
	 *         Fixed-length, two digits
	 * @codelist
	 *           List 174
	 * @version
	 *          3.0.01, January 2012
	 * @links
	 *        {@link org.editeur.onix.v30.references.PrintedOnProduct}<br/>
	 *        {@link org.editeur.onix.v30.shorts.X301}<br/>
	 */
	PrintedOnProduct
}
