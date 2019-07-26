# ![jonix](JONIX.png)

Commercial-grade library for extracting data from [ONIX for Books](https://www.editeur.org/11/Books) sources.

#### Release History:
- Version 9.0 (July 2019) support for Java 9 modules (Jigsaw), ONIX 3.0.06 and Codelist Issue 45
- Version 8.0.x (January 2018) starts relying on Java 8 support and offers completely overhauled fluent APIs
- Version 3.0 (June 2015) supports ONIX versions 2.1.03 and 3.0.02
- Version 3.1-rc1 (May 2016).

#### JavaDocs
API documentation can be found [here](https://zach-m.github.io/jonix).

# Usage

## 1. Stable Release (from Central repository)
Maven
```xml
<dependency>
    <groupId>com.tectonica</groupId>
    <artifactId>jonix</artifactId>
    <version>9.0</version>
</dependency>
```
Gradle
```
compile group: 'com.tectonica', name: 'jonix', version: '9.0'
```
For other tools see <https://mvnrepository.com/artifact/com.tectonica/jonix/9.0>

## 2. Latest Release (from latest source code)

```bash
mvn -version # REQUIRED: Maven-version >= 3.3.9  &&  JDK-version >= 9
git clone git@github.com:zach-m/jonix.git # or https://github.com/zach-m/jonix.git
cd jonix
mvn clean install
# in your project's pom.xml, use <version> 9.1-SNAPSHOT 
```

# Table of contents

- [Introduction](#introduction)
  - [Low-Level APIs](#low-level-apis)
  - [High-Level APIs](#high-level-apis)
- [Examples](#examples)
  - [Preparation](#preparation)
  - [Low-level iteration](#low-level-iteration)
  - [From iteration to streaming](#from-iteration-to-streaming)
  - [High-level processing with Unification](#high-level-processing-with-unification)
  - [Tabulation](#tabulation)
  
# Introduction

For many years, Jonix has been the only free Java library supporting ONIX extensively and reliably. Only lately, however, it was truly adapted for ONIX 3, and it will continue to adapt as the standard evolves. 
Jonix was designed with the following goals in mind:
* **Run fast**. Jonix 8 is more performant and memory efficient than even, taking lazy approach whenever possible
* **Simplify XML Processing**. Even though superficially ONIX is nothing more than an XML source, using it as-is to 
answer even basic questions (such as _What is the ISBN of the book whose title is ABC_) isn't something that XML 
frameworks are designed to do. ONIX is organized in a key-value fashion (mapping, for instance, ID-types to ID-values 
in each record), so finding out answers usually requires lookup operations. More on how Jonix simplifies XML can be 
found in following sections.
* **Modular**. Use only the parts of Jonix you need, not necessarily all modules.
* **Extensible**. The major classes in Jonix object model were designed for sub-classing and overriding.

Jonix provides various facilities to extract data out of ONIX sources (in the future it may also be able to generate 
ONIX files). They can be divided into two groups:

## Low-Level APIs

The most fundamental function in Jonix is to transform ONIX sources (containing XML content) into Java objects. 
When an ONIX source is being read, each record is transformed into a Java object (with many nested objects inside it), 
letting the user manipulate it without having to deal with the intricacies of the raw XML. 

With ONIX, dealing directly with the XML content could be quite complicated, for several reasons:

* the size of the source may be huge (ONIX files may contain thousands of records, easily weighing tens of MBs) 
* there are two major versions, generally known as _ONIX-2_ (deprecated) and _ONIX-3_ (current)
* each version has two sub-schemas - _Reference_ and _Short_ - see [here](https://www.editeur.org/74/faqs/#q10)
* there are many [Codelists](https://www.editeur.org/14/Code-Lists), whose exact spelling and meaning is crucial for data extraction 
* there are syntax rules, governing which tags are repeatable, which are mandatory, what's the relationship between them, etc.

Jonix provides solutions for all the above:

* **Source size** - Jonix is using [XmlChunker](https://zach-m.github.io/jonix/jonix.xml/com/tectonica/xmlchunk/XmlChunker.html) internally, which is a service capable of processing infinitely large ONIX sources by reading them chunk-by-chunk.
* **ONIX Versions** - All versions and all sub-schemas of ONIX are mapped to a corresponding set of Java classes.
* **Codelists** - Each ONIX Codelist is mapped to a Jonix `Enum`, all listed [here](https://zach-m.github.io/jonix/jonix.common/com/tectonica/jonix/common/codelist/package-summary.html). 
Note that even though each ONIX version defines its own set of Codelists, the corresponding `Enum`s in Jonix were unified 
to avoid confusion.
* **Schema Rules** - These are accounted for in Jonix in several ways:
	* ONIX Tags that can be repeated are represented as Java `Set`s or `List`s
	* Tags with special traits (is-mandatory, data format, etc.) have a corresponding Java-doc comment in their definition
	* Coherent and descriptive [data model](https://zach-m.github.io/jonix/jonix.common/com/tectonica/jonix/common/package-summary.html) 
	with several interfaces used to categorize ONIX tags as either 
	[Composite](https://zach-m.github.io/jonix/jonix.common/com/tectonica/jonix/common/OnixComposite.html), 
	[Element](https://zach-m.github.io/jonix/jonix.common/com/tectonica/jonix/common/OnixElement.html) or 
	[Flag](https://zach-m.github.io/jonix/jonix.common/com/tectonica/jonix/common/OnixFlag.html). 

> Classes in Jonix that represent ONIX tags are generated automatically from the official schema 
([here](https://www.editeur.org/93/Release-3.0-Downloads/#Schema%20defs) 
and [here](https://www.editeur.org/15/Archived-Previous-Releases/#2.1%20Downloads)). 
There are over 400 classes behind each ONIX version (2 and 3) and almost 200 enumerators representing the Codelists.

## High-Level APIs

On top of the low-level functions, Jonix offers array of services for data manipulation, including:

* **Unification**. This is one of the most powerful features in Jonix, which enables processing of **mixed** sources, 
i.e. a group of sources, where each may have a different ONIX version (2 or 3) and sub-schema (_Reference_ or _Short_). 
These sources will be transformed into a single, common, set of Java classes, on which version-agnostic operations can 
be made (such as writing into a database, sort, search, etc.).
* **Tabulation**. While ONIX records are organized as trees (i.e. XML records), it is sometimes easier to analyze them 
as if they were rows in a table. Flattening a tree into a plain list of columns can't be done without loss of generality, 
but with the proper knowledge of the ONIX content, it can be done at a reasonable compromise. Jonix offers a default 
tabulation scheme, which you can customize to your needs. For more information see the documentation for 
[Tabulation](https://zach-m.github.io/jonix/jonix/com/tectonica/jonix/tabulate/Tabulation.html)  
* **Bulk Processing**. Jonix provides methods for handling multiple ONIX sources, scattered in the file system.

# Examples

## Preparation

The main entry-point for processing ONIX content is [JonixRecords](https://zach-m.github.io/jonix/jonix/com/tectonica/jonix/JonixRecords.html) class.

The typical preparation steps for reading ONIX content are as follows:
1. Add one or more ONIX sources
2. Set the expected encoding of the sources (default is UTF-8)
3. Optionally, set event handlers to be fired during processing
4. Optionally, set key-value pairs, which will be accessible conveniently during processing

You can mix up sources of diverse versions and types:

```java
JonixRecords records = Jonix
     .source(new File("/path/to/folder-with-onix-files"), "*.xml", false)
     .source(new File("/path/to/file-with-short-style-onix-2.xml"))
     .source(new File("/path/to/file-with-reference-style-onix-3.onx"))
     .onSourceStart(src -> { // take a look at:
         // src.onixVersion()
         // src.header()
         // src.sourceName()
     })
     .onSourceEnd(src -> { // take a look at:
         // src.productsProcessedCount()
     })
     .configure("jonix.stream.failOnInvalidFile", Boolean.FALSE);
```
 
## Low-level iteration
 
`JonixRecords` is first and foremost an `Iterable` of [JonixRecord](https://zach-m.github.io/jonix/jonix/com/tectonica/jonix/JonixRecord.html) items.
Each of these items contain an ONIX Product and a link to the ONIX source from which it was read.
 
The exact concrete class that contain the ONIX Product depends on the ONIX Version of the source, and can be known
in advance, so for low-level processing, it is typical to do something like the following:

```java
for (JonixRecord record : records) {
    if (record.product instanceof com.tectonica.jonix.onix3.Product) {
        com.tectonica.jonix.onix3.Product product3 = (com.tectonica.jonix.onix3.Product) record.product;
        // TODO: process the Onix3 <Product>
    } else if (record.product instanceof com.tectonica.jonix.onix2.Product) {
        com.tectonica.jonix.onix2.Product product2 = (com.tectonica.jonix.onix2.Product) record.product;
        // TODO: process the Onix2 <Product>
    } else {
        throw new IllegalArgumentException();
    }
}
``` 

In the following code snippet, we pull the ISBN out of the ONIX Products along with some contributors information:

```java
for (JonixRecord record : records) {
    String isbn13;
    String personName = null;
    List<ContributorRoles> roles = null;
    if (record.product instanceof com.tectonica.jonix.onix2.Product) {
        com.tectonica.jonix.onix2.Product product2 = (com.tectonica.jonix.onix2.Product) record.product;
        isbn13 = product2.productIdentifiers()
            .find(ProductIdentifierTypes.ISBN_13)
            .map(pid -> pid.idValue().value)
            .orElse(null);
        List<com.tectonica.jonix.onix2.Contributor> contributors = product2.contributors();
        if (!contributors.isEmpty()) {
            com.tectonica.jonix.onix2.Contributor firstContributor = contributors.get(0);
            roles = firstContributor.contributorRoles().values();
            personName = firstContributor.personName().value;
        }
    } else if (record.product instanceof com.tectonica.jonix.onix3.Product) {
        com.tectonica.jonix.onix3.Product product3 = (com.tectonica.jonix.onix3.Product) record.product;
        isbn13 = product3.productIdentifiers()
            .find(ProductIdentifierTypes.ISBN_13)
            .map(pid -> pid.idValue().value)
            .orElse(null);
        List<com.tectonica.jonix.onix3.Contributor> contributors = product3.descriptiveDetail().contributors();
        if (!contributors.isEmpty()) {
            com.tectonica.jonix.onix3.Contributor firstContributor = contributors.get(0);
            roles = firstContributor.contributorRoles().values();
            personName = firstContributor.personName().value;
        }
    } else {
        throw new IllegalArgumentException();
    }
    System.out
        .println(String.format("Found ISBN %s, first person is %s, his roles: %s", isbn13, personName, roles));
}
```

## From iteration to streaming
 
It is sometime useful to invoke `stream()` and use the resulting `Stream` along with Java 8 Streaming APIs to achieve greater readability. The following examples retrieves the Onix3 Products from their sources and stores them in an in-memory List:

```java
import com.tectonica.jonix.onix3.Product;
...
List<Product> products3 = records.stream()
    .filter(rec -> rec.product instanceof Product)
    .map(rec -> (Product) rec.product)
    .collect(Collectors.toList());
```

## High-level processing with Unification
 
One of Jonix's best facilities is the Unification framework, allowing to simplify the treatment in varied sources 
(Onix2 mixed with Onix3, _Reference_ mixed with _Short_) and eliminate some of the intricacies of XML handling. 
The method `streamUnified()` returns a Stream, but not of the low-level `JonixRecord`s. 
Instead, it streams out [BaseRecords](https://zach-m.github.io/jonix/jonix/com/tectonica/jonix/unify/BaseRecord.html), 
that contain [BaseProduct](https://zach-m.github.io/jonix/jonix/com/tectonica/jonix/unify/base/BaseProduct.html) - a typed 
and unified representation of the most essential data within typical ONIX source. 

The following example demonstrates extraction of some fundamental ONIX fields from an ONIX source of any version and type:

```java
// the following is a set of the price-types we will look for in the ONIX records
Set<PriceTypes> requestedPrices = JonixUtil.setOf(PriceTypes.RRP_including_tax, PriceTypes.RRP_excluding_tax);

// we start going over the ONIX records, looking the Unified version of them
records.streamUnified()
    .map(rec -> rec.product)
    .forEach(product -> {
        String recordReference = product.info.recordReference;
        String isbn13 = product.info.findProductId(ProductIdentifierTypes.ISBN_13);
        String title = product.titles.findTitleText(TitleTypes.Distinctive_title_book);
        List<String> authors = product.contributors.getDisplayNames(ContributorRoles.By_author);
        List<BasePrice> prices = product.supplyDetails.findPrices(requestedPrices);
        List<String> priceLabels = prices.stream()
            .map(bp -> bp.priceAmountAsStr + " " + bp.currencyCode).collect(Collectors.toList());
        System.out.println(String.format("Found product ref. %s, ISBN='%s', Title='%s', authors=%s, prices=%s",
            recordReference, isbn13, title, authors, priceLabels));
    });
```
 
Unification can also be done explicitly (not via `streamUnified()`) using 
[JonixUnifier](https://zach-m.github.io/jonix/jonix/com/tectonica/jonix/unify/JonixUnifier.html). For example, here's how 
to manually transform a raw `OnixProduct` into a `BaseProduct`:

```java
void foo(JonixRecord record) {
    BaseProduct baseProduct = JonixUnifier.unifyProduct(record.product);
    // TODO: access the content of 'baseProduct'
}
```

Another case is Unification of the raw `OnixHeader`, by using `JonixUnifier.unifyHeader()`, like that:

```java
// given a JonixRecords object
JonixRecords records = ...

// we can set use the 'SourceStart' event to print the ONIX Header information
records.onSourceStart(src -> {
    src.header().map(JonixUnifier::unifyHeader).ifPresent(baseHeader -> System.out.println(baseHeader));
})
```

## Tabulation

Jonix provides generic framework to allow flattening and outputting ONIX Products into a table-like structure (suitable
for CSV or database export). Jonix offers a `Collector` that saves a stream into a CSV file:

```java
import static com.tectonica.jonix.tabulate.JonixDelimitedWriter.toDelimitedFile;

// prepare to read from various sources
JonixRecords records = Jonix
    .source(...)
    .onSourceStart(src -> ...)
    .onSourceEnd(src -> ...)
    .configure(...);

// save the most important fields of the streamed ONIX products into a CSV file
File targetFile = new File("/path/to/destination.csv");
int recordsWritten = records.streamUnified()
    .collect(toDelimitedFile(targetFile, ',', BaseTabulation.ALL));

// file is saved
System.out.println("Written " + recordsWritten + " records")
```

The procedure of how to define which fields to output and how are described in 
[Tabulation](https://zach-m.github.io/jonix/jonix/com/tectonica/jonix/tabulate/Tabulation.html) and in 
[FieldTabulator](https://zach-m.github.io/jonix/jonix/com/tectonica/jonix/tabulate/FieldTabulator.html)
