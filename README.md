# ![jonix](JONIX.png)

Jonix is a commercial-grade open source Java library for extracting data from [ONIX for Books](https://www.editeur.org/83/Overview/) sources.

It comprises of various services for efficient processing of ONIX sources, emphasizing on:
- high-performance (speed and memory)
- fluent, intuitive and type-safe APIs
- extensibility

It is NOT a thin XML-processing wrapper, nor is it `XPath` in disguise. It was built from scratch specifically for 
ONIX files, and accordingly it gets updated whenever a new schema of ONIX is published (4 times a year).

### Recent Versions

| Maven Version     | Onix version | Codelist Issue |
| ----------------- | ------------ | -------------- |
| `2023-05`         | 3.1.00       | 61             |
| `2023-05-onix308` | 3.0.08       | 61             |
| `2023-04`         | 3.1.00       | 61             |
| `2023-01`         | 3.0.08       | 60             |
| `2022-11`         | 3.0.08       | 59             |
| `2022-08`         | 3.0.08       | 58             |

# Usage

API documentation can be found [here](https://zach-m.github.io/jonix).

## 1. Stable Release (from Central repository)

Maven
```xml
<dependency>
    <groupId>com.tectonica</groupId>
    <artifactId>jonix</artifactId>
    <version>2023-05</version>
</dependency>
```

Or, if you are NOT ready to switch to ONIX version `3.1`, use the latest `3.0` implementation:

```xml
<dependency>
    <groupId>com.tectonica</groupId>
    <artifactId>jonix</artifactId>
    <version>2023-05-onix308</version>
</dependency>
```

Gradle
```
implementation group: 'com.tectonica', name: 'jonix', version: '2023-05'
```

For other tools see <https://mvnrepository.com/artifact/com.tectonica/jonix/2023-05>

## 2. Latest Release (from latest source code)

To build locally from source:

```shell
# verify requirements: Maven-version >= 3.3.9  &&  JDK-version >= 9
mvn -version

# clone the repository
git clone https://github.com/zach-m/jonix.git

# build
cd jonix
mvn clean
mv -P release install
```

Once completed, Jonix should be available to use as a maven dependency on your local file system.

> NOTE: Make sure to point `pom.xml` of your local project to the Jonix coordinates of the version you just built 
> (highlighted here: https://github.com/zach-m/jonix/blob/master/pom.xml#L7).

# Quick Start

If you need to extract common fields from diversified ONIX sources (mixture of ONIX-2 and ONIX-3, `reference` and 
`short` format (see [here](https://www.editeur.org/74/FAQs/#q10))), the following example should help:

```java
Jonix.source(new File("/path/to/folder-with-onix-files"), "*.xml", false)
     .source(new File("/path/to/file-with-short-style-onix-2.xml"))
     .source(new File("/path/to/file-with-reference-style-onix-3.onx"))
     .onSourceStart(src -> {
         // after the <Header> of the current ONIX source has been processed, we take a look at the source properties
         System.out.printf(">> Opening %s (ONIX release %s)%n", src.sourceName(), src.onixRelease());
         src.header().map(Jonix::toBaseHeader)
             .ifPresent(header -> System.out.printf(">> Sent from: %s%n", header.senderName));
     })
     .onSourceEnd(src -> {
         // we finalize the processing of the ONIX source
         System.out.printf("<< Processed %d products (total %d) %n", src.productCount(), src.productGlobalCount());
     })
     .stream() // iterates over all the products contained in all ONIX sources
     .map(Jonix::toBaseProduct) // transforms any ONIX-2 or ONIX-3 product into a unified, version-agnostic, object
     .forEach(product -> {
         String ref = product.info.recordReference;
         String isbn13 = product.info.findProductId(ProductIdentifierTypes.ISBN_13);
         String title = product.titles.findTitleText(TitleTypes.Distinctive_title_book);
         List<String> authors = product.contributors.getDisplayNames(ContributorRoles.By_author);
 
         System.out.println("ref                 = " + ref);
         System.out.println("isbn13              = " + isbn13);
         System.out.println("title               = " + title);
         System.out.println("authors             = " + authors);
         System.out.println("--------------------------------------------------------------------------------");
     });
```

The example above uses the [BaseProduct](http://zach-m.github.io/jonix/jonix/com/tectonica/jonix/unify/base/BaseProduct.html)
class, which processes ONIX-2 and ONIX-3 sources differently, according to their schema, and stores the most common 
fields in its public fields, such as `info`, `description`, `subjects`, etc. 

If, however, you need a more complicated extraction, specific to your needs and your sources, you can avoid using this 
type of "common denominator" class, and process the raw fields by yourself, like that:

```java
Jonix.source(new File("/path/to/folder-with-mixed-onix-files"), "*.xml", false)
     .stream()
     .forEach(record -> {
         if (record.product.onixVersion() == OnixVersion.ONIX2) {
             com.tectonica.jonix.onix2.Product product = Jonix.toProduct2(record);
             // TODO: write ONIX-2 specific code
         } else {
             com.tectonica.jonix.onix3.Product product = Jonix.toProduct3(record);
             // TODO: write ONIX-3 specific code
         }
     });
```

Following is an example of how to process ALL ONIX-3 source, with some non-standard logic. In particular, the `authors`
are extracted in a more elaborate way compared to `BaseProduct.contributors`, and the `frontCoverImageLink` which 
doesn't exist at all in `BaseProduct` is extracted as part of the processing.

```java
Jonix.source(new File("/path/to/all-onix3-folder"), "*.xml", false)
     .onSourceStart(src -> {
         // safeguard: we skip ONIX-2 files
         if (src.onixVersion() == OnixVersion.ONIX2) {
             src.skipSource();
         }
     })
     .onSourceEnd(src -> {
         System.out.printf("<< Processed %d products from %s %n", src.productCount(), src.sourceName());
     })
     .stream() // iterate over the products contained in all ONIX sources
     .map(Jonix::toProduct3)
     .forEach(product -> {
         // take the information you need from the current product
         String ref = product.recordReference().value;
 
         String isbn13 = product.productIdentifiers().find(ProductIdentifierTypes.ISBN_13)
             .map(pi -> pi.idValue().value).orElse(null);
 
         String title = product.descriptiveDetail().titleDetails()
             .filter(td -> td.titleType().value == TitleTypes.Distinctive_title_book).firstOrEmpty()
             .titleElements().firstOrEmpty()
             .titleWithoutPrefix().value;
 
         List<String> authors = product.descriptiveDetail().contributors()
             .filter(c -> c.contributorRoles().values().contains(ContributorRoles.By_author))
             .stream()
             .map(c -> c.personName().value().orElse(
                       c.nameIdentifiers().find(NameIdentifierTypes.Proprietary)
                                          .map(ni -> ni.idTypeName().value).orElse("N/A")))
             .collect(Collectors.toList());
 
         String frontCoverImageLink = product.collateralDetail().supportingResources()
             .filter(sr -> sr.resourceContentType().value == ResourceContentTypes.Front_cover).firstOrEmpty()
             .resourceVersions().filter(rv -> rv.resourceForm().value == ResourceForms.Downloadable_file).first()
             .map(rv -> rv.resourceLinks().firstValueOrNull())
             .orElse(null);
 
         System.out.println("ref                 = " + ref);
         System.out.println("isbn13              = " + isbn13);
         System.out.println("title               = " + title);
         System.out.println("authors             = " + authors);
         System.out.println("frontCoverImageLink = " + frontCoverImageLink);
         System.out.println("--------------------------------------------------------------------------------");
     });
```

Additionally, if your project requires delicate handling of many ONIX fields, you may want to consider replacing the
`BaseProduct` class with your own version altogether. This will allow you, or your team members, to write simple, 
version-agnostic streaming scripts, like the one at the top of this section, leaving the extraction details outside of
the business logic.

This feature of Jonix is known as Custom Unification, and there are 3 examples included in the project:
- Extend the `BaseProduct` with some additional global fields, see [MyCustomBaseUnifier1](https://github.com/zach-m/jonix/blob/master/jonix/src/test/java/com/tectonica/jonix/external/MyCustomBaseUnifier1.java)
- Extend individual members and sub-members of `BaseProduct` (such as `description`, `title`, etc.), see [MyCustomBaseUnifier2](https://github.com/zach-m/jonix/blob/master/jonix/src/test/java/com/tectonica/jonix/external/MyCustomBaseUnifier2.java)
- Create a whole new replacement for `BaseProduct`, extracting only the fields you're interested in, see [MyCustomUnifier](https://github.com/zach-m/jonix/blob/master/jonix/src/test/java/com/tectonica/jonix/external/MyCustomUnifier.java)

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
([here](https://www.editeur.org/93/Release-3.0-Downloads/#Specifications) 
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

## High-level processing with Unification
 
One of Jonix's best facilities is the Unification framework, allowing to simplify the treatment in varied sources 
(Onix2 mixed with Onix3, _Reference_ mixed with _Short_) and eliminate some of the intricacies of XML handling. 
The method `streamUnified()` returns a Stream, but not of the low-level `JonixRecord`s. 
Instead, it streams out [BaseRecords](https://zach-m.github.io/jonix/jonix/com/tectonica/jonix/unify/BaseRecord.html), 
that contain [BaseProduct](https://zach-m.github.io/jonix/jonix/com/tectonica/jonix/unify/base/BaseProduct.html) - a typed 
and unified representation of the most essential data within typical ONIX source. 

The following example demonstrates extraction of some fundamental ONIX fields from an ONIX source of any version and 
type using `streamUnified()`:

> Note that calling `streamUnified()` is identical to `.stream().map(Jonix::toBaseProduct)` which we used above

```java
Set<PriceTypes> requestedPrices = JonixUtil.setOf(PriceTypes.RRP_including_tax, PriceTypes.RRP_excluding_tax);

JonixRecords records = Jonix.source(new File("/path/to/folder-with-onix-files"), "onix*.xml", false);

records.streamUnified()
    .map(rec -> rec.product)
    .forEach(product -> {
        String title = product.titles.findTitleText(TitleTypes.Distinctive_title_book);
        List<String> authors = product.contributors.getDisplayNames(ContributorRoles.By_author);
        List<BasePrice> prices = product.supplyDetails.findPrices(requestedPrices);
        List<String> priceLabels =
            prices.stream().map(bp -> bp.priceAmountAsStr + " " + bp.currencyCode.code).collect(Collectors.toList());
        System.out.printf("The book '%s' by %s costs: %s%n", title, authors, priceLabels);
    });
```
 
Another case is Unification of the raw `OnixHeader`, by using `Jonix.toBaseHeader()`, like that:

```java
// given a JonixRecords object
JonixRecords records = ...

// we can set use the 'SourceStart' event to print the ONIX Header information
records.onSourceStart(src -> {
    src.header().map(Jonix::toBaseHeader).ifPresent(baseHeader -> System.out.println(baseHeader));
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
