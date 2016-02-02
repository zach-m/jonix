![jonix](JONIX.png)
=

Commercial-grade library for extracting data from [ONIX](http://www.editeur.org/83/Overview) sources.

Version 3.0 has been released on June 26, 2015. It supports ONIX versions 2.1.03 and 3.0.02.

API documentation can be found [here](http://zach-m.github.io/jonix).

# Introduction

For several years now, Jonix has been the only free Java library supporting ONIX extensively and reliably. Only lately, however, it was truly adapted for ONIX 3, and it will continue to adapt as the standard evolves. Jonix was designed with the following goals in mind:

* **Run fast**. Jonix 3 is more performant and memory efficient than even
* **Simplify XML Processing**. Even though superficially ONIX is nothing but an XML source, using it as-is to answer even basic questions (such as _What is the ISBN of the book whose title is ABC_) isn't something that XML frameworks are designed to do. ONIX is organized in a key-value fashion (mapping, for instance, ID-types to ID-values in each record), so finding out answers usually requires lookup operations. More on how Jonix simplifies XML can be found in the next section.
* **Modular**. Use only the parts of Jonix you need, not necessarily all modules.
* **Extensible**. The major classes in Jonix were designed for sub-classing and overriding.

Jonix provides various facilities to extract data out of ONIX sources (in the future it may also be able to generate ONIX files). They can be divided into two groups:

## Low-Level APIs: XML-to-Java

The most fundamental function in Jonix is to transform ONIX sources (containing XML content) into Java objects. When an ONIX source is being read, each record is transformed into a Java object (with many nested objects inside it), letting the user manipulate it without having to deal with the intricacies of the raw XML. 

With ONIX, dealing directly with the XML content could be quite complicated, for several reasons:

* the size of the source may be huge (ONIX files may contain thousands of records, easily weighing tens of MBs) 
* there are two major versions, generally known as _ONIX-2_ and _ONIX-3_
* each version has two sub-schemas - _Reference_ and _Short_ - see [here](http://www.editeur.org/74/faqs/#q10)
* there are many [Codelists](http://www.editeur.org/14/Code-Lists) , whose exact spelling and meaning is crucial for data extraction 
* there are syntax rules, governing which tags are repeatable, which are mandatory, what's the relationship between them, etc.

Jonix provides solutions for all the above:

* **Source size** - Jonix is using [XmlChunker](http://zach-m.github.io/jonix/com/tectonica/xmlchunk/XmlChunker.html), which is an internal service capable of processing infinitely large ONIX sources by reading them chunk-by-chunk.
* **ONIX Versions** - All versions and all sub-schemas of ONIX are mapped to a corresponding set of Java classes.
* **Codelists** - Each ONIX codelist is mapped to a Jonix `Enum`, all listed [here](http://zach-m.github.io/jonix/com/tectonica/jonix/codelist/package-summary.html). Note that even though each ONIX version defines its own set of Codelists, the corresponding `Enum`s in Jonix were unified to avoid confusion.
* **Schema Rules** - These are accounted for in Jonix in several ways:
	* Tags that can be repeated are represented as Java `Set`s or `List`s
	* Tags with special traits (is mandatory, data format, etc.) have a corresponding comment in their definition
	* Special interfaces are used to categorize tags as either [Composite](http://zach-m.github.io/jonix/com/tectonica/jonix/OnixComposite.html) , [Element](http://zach-m.github.io/jonix/com/tectonica/jonix/OnixElement.html) or [Flag](http://zach-m.github.io/jonix/com/tectonica/jonix/OnixFlag.html). 

> Classes in Jonix that represent ONIX tags are generated automatically from the official schema ([here](http://www.editeur.org/93/Release-3.0-Downloads/#Schema%20defs) and [here](http://www.editeur.org/15/Archived-Previous-Releases/#2.1%20Downloads)). There are over 400 classes behind each ONIX version (2 and 3) and almost 200 enumerators representing the Codelists.

## High-Level APIs: Scan, Extract, Unify, Export

On top of the low-level functions, Jonix offers assorted services for data manipulation, including:

* **Unification**. This is one of the most powerful features in Jonix, which enables processing of **mixed** sources, i.e. a group of sources, where each may have a different ONIX version (2 or 3) and sub-schema (_Reference_ or _Short_). These sources will be transformed into a single, common, set of Java classes, on which version-agnostic operations can be made (such as writing into a database, sort, search, etc.).
* **Tabulation**. While ONIX records are organized as trees (i.e. XML records), it is sometimes easier to analyze them as if they were rows in a table. Presenting a tree as a plain list of columns can't be done without loss of generality, but with the proper knowledge of the ONIX content, it can be done at a reasonable compromise. Jonix offers a default tabulation scheme, which you can override to your needs. For more information see the documentation for [JonixColumn](http://zach-m.github.io/jonix/com/tectonica/jonix/JonixColumn.html)  
* **Bulk Processing**. Jonix provides methods for handling multiple ONIX sources, scattered in the file system.

Some built-in implementations in Jonix include:

* The [Basic suite](http://zach-m.github.io/jonix/com/tectonica/jonix/basic/package-summary.html) of unification classes
* Converters of ONIX to [Tab-Delimited](http://zach-m.github.io/jonix/com/tectonica/jonix/export/JonixTabDelimitedExporter.html) and [JSON](http://zach-m.github.io/jonix/com/tectonica/jonix/export/JonixJsonExporter.html) formats
* [Duplicate records filter](http://zach-m.github.io/jonix/com/tectonica/jonix/extract/JonixUniqueExtractor.html), which is very useful when scanning a bulk of ONIX sources, where a single book may appear more than once, with only the latest record is desired.  

# Concepts and Terminology

_(Work in progress..)_

Main concepts of the Jonix framework are:

* **Raw vs Unified**
* **Streamer** - see [here](http://zach-m.github.io/jonix/com/tectonica/jonix/stream/JonixStreamer.html)
* **Extractor** - see [here](http://zach-m.github.io/jonix/com/tectonica/jonix/stream/JonixExtractor.html) 
* **Exporter** - see [here](http://zach-m.github.io/jonix/com/tectonica/jonix/export/JonixExporter.html) 
* **Struct** - see [here](http://zach-m.github.io/jonix/com/tectonica/jonix/struct/package-summary.html)

# Packaging

_(Work in progress..)_

Use the following package if you need nothing but raw support in ONIX-2 sources: 

	<dependency>
		<groupId>com.tectonica</groupId>
		<artifactId>jonix-onix2</artifactId>
		<version>3.0</version>
	</dependency>

Use the following package if you need nothing but raw support in ONIX-3 sources: 

	<dependency>
		<groupId>com.tectonica</groupId>
		<artifactId>jonix-onix3</artifactId>
		<version>3.0</version>
	</dependency>

Use the following package if you need Jonix full support: 

	<dependency>
		<groupId>com.tectonica</groupId>
		<artifactId>jonix</artifactId>
		<version>3.0</version>
	</dependency>

# Examples

_(Work in progress..)_

# Previous Releases
Jonix 3 is not compatible with Jonix 1 or 2, that were hosted on _Google Code_ before it was discontinued.

It now offers a thinner, simpler and clearer interface, and it is no longer builds on the foundations of [JAXB](https://jaxb.java.net/), which was the root cause for the awkwardness of some of the APIs in those old versions. Moreover, JAXB made it difficult to extend Jonix by sub-classing its existing classes. All these are no longer an issue in Jonix 3, so hopefully porting would quickly justify the effort.    
