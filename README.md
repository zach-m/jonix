# ![jonix](JONIX.png)

> NOTE: version `2023-05` presents the single most important leap for Jonix in a decade. The API has been revised and extended (slightly breaking backward compatibility), resulting in a more expressive and fluent syntax than ever.
> In particular, two powerful APIs, `.firstOrEmpty()` and `.filter()` were introduced for Lists of composites, eliminating many previously-unavoidable `null`/`exists()` checks.
> For streaming control (e.g. `Jonix.source()...stream()...`), the `JonixSource` passed by the framework now has `productCount()` and `productGlobalCount()`, as well as `skipSource()` to use inside `.onSourceStart()`. Additionally, the `JonixRecord` object passed by the stream, now supports `breakStream()` and `breakCurrentSource()`.
> The `JonixRecords` object now offers `scanHeaders()` for `Header`-only peek of the ONIX sources. It also has `failOnInvalidFile()` method to replace a configuration flag with the same name.
> For convenience, `pair()` was added to all Codelist Enums for ease of unification, and - for distinction between ONIX version 3.0 and 3.1 - `.onixRelease()` and `.onixVersion()` were added to top-level `Product` and `Header` classes. See newly-crafted examples below.

Jonix is a commercial-grade open source Java library for extracting data from [ONIX for Books](https://www.editeur.org/83/Overview/) sources.

It comprises of various services for efficient processing of ONIX sources, emphasizing:
- High-performance (speed and memory)
- Fluent, intuitive and type-safe APIs
- Extensibility

Jonix is NOT a thin XML-processing wrapper, nor is it `XPath` in disguise. It was built from scratch specifically for 
ONIX files, and accordingly it gets updated whenever a new schema of ONIX is published (4 times a year).

With Jonix, each ONIX element is represented by a dedicated Java class (code is auto-generated from the official schema),
providing type-safe access to the data stored in that element. The Java classes have a clear and intuitive API, where
methods never return `null`, while public fields (containing values at the terminal nodes) may.

Different ONIX elements play different roles. Some are simple data elements, containing a single value (and optionally some attributes),
others are "Composites", containing other elements (some of which may be composites by themselves), and others are merely flags.
The [Jonix Object Model](https://zach-m.github.io/jonix/jonix.common/com/tectonica/jonix/common/package-summary.html) makes
clear distinction betweem these types and offers different APIs for different types.

### Recent Versions

| Maven Version     | Onix version | Codelist Issue |
| ----------------- | ------------ | -------------- |
| `2023-05`         | 3.1.00       | 61             |
| `2023-05-onix308` | 3.0.08       | 61             |
| `2023-04`         | 3.1.00       | 61             |
| `2023-01`         | 3.0.08       | 60             |
| `2022-11`         | 3.0.08       | 59             |
| `2022-08`         | 3.0.08       | 58             |

API documentation for latest release can be found [here](https://zach-m.github.io/jonix).

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

## Version-agnostic extraction of common fields

If you need to extract common fields from sources of mixed ONIX variants (ONIX-2 alongside ONIX-3, `reference`
alongside `short` format (see [here](https://www.editeur.org/74/FAQs/#q10))), the following example should help:

```java
Jonix.source(new File("/path/to/folder-with-onix-files"), "*.xml", false)
     .source(new File("/path/to/file-with-short-style-onix-2.xml"))
     .source(new File("/path/to/file-with-reference-style-onix-3.onx"))
     .onSourceStart(src -> {
         // after the <Header> of current source was processed, we look at the source's properties
         System.out.printf(">> Opening %s (ONIX release %s)%n", src.sourceName(), src.onixRelease());
         src.header().map(Jonix::toBaseHeader)
             .ifPresent(header -> System.out.printf(">> Sent from: %s%n", header.senderName));
     })
     .onSourceEnd(src -> {
         // we finalize the processing of the ONIX source
         System.out.printf("<< Processed %d products (total %d) %n", 
	     src.productCount(), src.productGlobalCount());
     })
     .stream() // iterates over all the products contained in all ONIX sources
     .map(Jonix::toBaseProduct) // transforms ONIX-2/3 product into a unified version-agnostic object
     .forEach(product -> {
         String ref = product.info.recordReference;
         String isbn13 = product.info.findProductId(ProductIdentifierTypes.ISBN_13);
         String title = product.titles.findTitleText(TitleTypes.Distinctive_title_book);
         List<String> authors = product.contributors.getDisplayNames(ContributorRoles.By_author);
 
         System.out.println("ref                 = " + ref);
         System.out.println("isbn13              = " + isbn13);
         System.out.println("title               = " + title);
         System.out.println("authors             = " + authors);
         System.out.println("----------------------------------------------------------");
     });
```

## Version-specific extraction

The example above uses the [BaseProduct](http://zach-m.github.io/jonix/jonix/com/tectonica/jonix/unify/base/BaseProduct.html)
class, which processes ONIX-2 and ONIX-3 sources differently, each according to its schema, and extracts the most essential 
information into its public fields, such as `info`, `description`, `subjects`, etc. 

If, however, you need a more complicated extraction, specific to your needs and sources, this "one-size-fits-all" approach may
not be right for you. Instead, you may want to process the raw fields by yourself, as follows:

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

## Fluent APIs

Next example shows how to process a folder containing ALL ONIX-3 sources, with some non-standard logic.
In particular, the `authors` are extracted in a more elaborate way compared to `BaseProduct.contributors`, 
and the `frontCoverImageLink` which doesn't exist at all in `BaseProduct` is extracted here as well.

> Pay careful attention to the usage of `.firstOrEmpty()`, `orElse()` and `flatMap()`, espeically in the extraction of `title`, `authors` and `frontCoverImageLink`.
> They demostrate the Jonix fluent API, where if a certain element doesn't exist in the ONIX XML source (and certainly not its children elements),
> we still apply the same logic as if it does (counting on `null` terminal values if it doesn't). This syntax eliminates the need for cumbersone `if-else`
> blocks (testing for existence of elements), and leaves us with concise and clean expressions.

```java
Jonix.source(new File("/path/to/all-onix3-folder"), "*.xml", false)
     .onSourceStart(src -> {
         // safeguard: we skip non-ONIX-3 files
         if (src.onixVersion() != OnixVersion.ONIX3) {
             src.skipSource();
         }
     })
     .onSourceEnd(src -> {
         System.out.printf("<< Processed %d products from %s %n", src.productCount(), src.sourceName());
     })
     .stream() // iterate over the products contained in all ONIX sources
     .map(Jonix::toProduct3)
     .forEach(product -> {
         // take the requested information from the current product
         String ref = product.recordReference().value;
 
         String isbn13 = product.productIdentifiers()
	                        .find(ProductIdentifierTypes.ISBN_13)
				.map(pi -> pi.idValue().value)
				.orElse(null);
 
         String title = product.descriptiveDetail().titleDetails()
             .filter(td -> td.titleType().value == TitleTypes.Distinctive_title_book)
	     .firstOrEmpty()
             .titleElements()
	     .firstOrEmpty()
             .titleWithoutPrefix().value;
 
         List<String> authors = product.descriptiveDetail().contributors()
             .filter(c -> c.contributorRoles().values().contains(ContributorRoles.By_author))
             .stream()
             .map(c -> c.personName().value().orElse(
                       c.nameIdentifiers().find(NameIdentifierTypes.Proprietary)
                                          .flatMap(ni -> ni.idTypeName().value())
					  .orElse("N/A")))
             .collect(Collectors.toList());
 
         String frontCoverImageLink = product.collateralDetail().supportingResources()
             .filter(sr -> sr.resourceContentType().value == ResourceContentTypes.Front_cover)
	     .firstOrEmpty()
             .resourceVersions()
	     .filter(rv -> rv.resourceForm().value == ResourceForms.Downloadable_file)
	     .first()
             .map(rv -> rv.resourceLinks().firstValueOrNull())
             .orElse(null);
 
         System.out.println("ref                 = " + ref);
         System.out.println("isbn13              = " + isbn13);
         System.out.println("title               = " + title);
         System.out.println("authors             = " + authors);
         System.out.println("frontCoverImageLink = " + frontCoverImageLink);
         System.out.println("-----------------------------------------------------");
     });
```

## Custom Unification

If your project requires delicate handling of many ONIX fields, you may want to consider replacing the
`BaseProduct` class with your own version altogether. This will allow you, or your team members, to write simple, 
version-agnostic streaming scripts, like the one at the top of this section, leaving the extraction details separate
from the business logic.

This feature of Jonix is known as Custom Unification, and there are 3 examples included in the project:
- Extend the `BaseProduct` with some additional global fields, see [MyCustomBaseUnifier1](https://github.com/zach-m/jonix/blob/master/jonix/src/test/java/com/tectonica/jonix/external/MyCustomBaseUnifier1.java)
- Extend individual members and sub-members of `BaseProduct` (such as `description`, `title`, etc.), see [MyCustomBaseUnifier2](https://github.com/zach-m/jonix/blob/master/jonix/src/test/java/com/tectonica/jonix/external/MyCustomBaseUnifier2.java)
- Create a whole new replacement for `BaseProduct`, extracting only the fields you're interested in, see [MyCustomUnifier](https://github.com/zach-m/jonix/blob/master/jonix/src/test/java/com/tectonica/jonix/external/MyCustomUnifier.java)

## Streaming aids

The following example, for converting a list of ONIX files into CSV files, demonstrates several features:
- use of `store()` and `retrieve()` of the `JonixSource` to pass variables between event handlers on the same source (the `csv` object in this case)
- use of `breakStream()`, `productCount()` and `productGlobalCount()` to monitor and control the streaming progress
- use of Custom Unification of `MyProduct` with `MyUnifier` (see previous section)
- ideas for error handling, including `JonixJson.toJson()` and `recordReferenceOf()`

```java
public static void onixToCsv(List<String> fileNames) {
    Jonix.source(fileNames.stream().map(File::new).toList())
        .onSourceStart(source -> {
            String csvFileName = source.sourceName();
            System.out.println("Creating " + csvFileName + "..");
            final CsvWriter csv = new CsvWriter(csvFileName);
            csv.writeCsvHeader();
            source.store("csv", csv);
        })
        .onSourceEnd(source -> {
            final CsvWriter csv = source.retrieve("csv");
            csv.close();
            System.out.printf("Processed %d / %d products%n", 
	                      source.productCount(), source.productGlobalCount());
        })
        .stream()
        .forEach(rec -> {
            final OnixProduct product = rec.product;
            final CsvWriter csv = rec.source.retrieve("csv");
            try {
                MyProduct mp = JonixUnifier.unifyProduct(product, MyUnifier.unifier);
                csv.writeCsvLine(mp.toCsvColumns());
            } catch (Exception e) {
                // e.printStackTrace();
                // System.err.println(JonixJson.toJson(product));
                System.err.printf("ERROR in #REF [%s]: %s%n", 
		                  recordReferenceOf(product), e.getMessage());
                // don't re-throw, don't break source, just continue to the next product..
            }
            if (rec.source.productCount() == 50) {
                rec.breakStream();
            }
        });
}

public static String recordReferenceOf(OnixProduct product) {
    final String ref;
    if (product.onixVersion() == OnixVersion.ONIX2) {
        ref = Jonix.toProduct2(product).recordReference().value;
    } else if (product.onixVersion() == OnixVersion.ONIX3) {
        ref = Jonix.toProduct3(product).recordReference().value;
    } else {
        throw new RuntimeException("Unexpected type: " + product.getClass().getName());
    }
    return (ref == null) ? "N/A" : ref;
}
```

## Scanning headers

If prior to opening an ONIX file, its header needs to be examined, use `scanHeaders()`.
This is particularly useful when a bulk of ONIX files needs to be pre-scanned for display/sorting/filtering purposes.
The following example provides a simple function that returns the (unified) `BaseHeader` of any ONIX file name.
Can be easily extended to a support multiple files as input.

```java
public static BaseHeader headerOf(String onixFileName) {
    List<BaseHeader> holder = new ArrayList<>(1);
    Jonix.source(new File(onixFileName))
        .onSourceStart(src -> src.header().map(Jonix::toBaseHeader).ifPresent(holder::add))
        .scanHeaders();
    return holder.isEmpty() ? null : holder.get(0);
}
```

# Older Docs

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
> ([here](https://www.editeur.org/93/Release-3.0-Downloads/#Specifications) and [here](https://www.editeur.org/15/Archived-Previous-Releases/#2.1%20Downloads)). 
> There are over [500 classes](https://zach-m.github.io/jonix/jonix.onix3/com/tectonica/jonix/onix3/package-summary.html)
> for ONIX-3 (and over [430 classes](https://zach-m.github.io/jonix/jonix.onix2/com/tectonica/jonix/onix2/package-summary.html)
> for ONIX-2) and almost [200 enumerators](https://zach-m.github.io/jonix/jonix.common/com/tectonica/jonix/common/codelist/package-summary.html)
> representing the Codelists.

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
Set<PriceTypes> requestedPrices = JonixUtil.setOf(
    PriceTypes.RRP_including_tax, 
    PriceTypes.RRP_excluding_tax
);

JonixRecords records = Jonix.source(new File("/path/to/folder-with-onix-files"), "onix*.xml", false);

records.streamUnified()
    .map(rec -> rec.product)
    .forEach(product -> {
        String title = product.titles.findTitleText(TitleTypes.Distinctive_title_book);
        List<String> authors = product.contributors.getDisplayNames(ContributorRoles.By_author);
        List<BasePrice> prices = product.supplyDetails.findPrices(requestedPrices);
        List<String> priceLabels =
            prices.stream().map(bp -> bp.priceAmountAsStr + " " + bp.currencyCode.code)
	                   .collect(Collectors.toList());
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
