jonix-codegen
=

Utility library for generating source code for onix-processing classes directly from EDItEUR's schema  
 
 
## Structure of Onix Class

General structure is as follows:

	<xs:element name="OnixClassName">         --> element
	    <xs:complexType>                      --> complexTypeElem
	        <xs:...>                          --> contentElem
	        </xs:...>
	    </xs:complexType>
	</xs:element>

### Onix Elements

#### Case: `xs:simpleContent` with `xs:extension`

    <xs:element name="AgentRole">
        <xs:complexType>
            <xs:simpleContent>
                <xs:extension base="List69">
                    <xs:attribute name="refname">
                        <xs:simpleType>
                            <xs:restriction base="xs:token">
                                <xs:enumeration value="AgentRole"/>
                            </xs:restriction>
                        </xs:simpleType>
                    </xs:attribute>
                    <xs:attribute name="shortname">
                        <xs:simpleType>
                            <xs:restriction base="xs:token">
                                <xs:enumeration value="j402"/>
                            </xs:restriction>
                        </xs:simpleType>
                    </xs:attribute>
                    <xs:attributeGroup ref="generalAttributes"/>
                </xs:extension>
            </xs:simpleContent>
        </xs:complexType>
    </xs:element>

#### Case: `xs:complexContent` with `xs:extension` (Onix3 only)

    <xs:element name="BiographicalNote">
        <xs:complexType mixed="true">
            <xs:complexContent>
                <xs:extension base="Flow">
                    <xs:attribute name="refname">
                        <xs:simpleType>
                            <xs:restriction base="xs:token">
                                <xs:enumeration value="BiographicalNote"/>
                            </xs:restriction>
                        </xs:simpleType>
                    </xs:attribute>
                    <xs:attribute name="shortname">
                        <xs:simpleType>
                            <xs:restriction base="xs:token">
                                <xs:enumeration value="b044"/>
                            </xs:restriction>
                        </xs:simpleType>
                    </xs:attribute>
                    <xs:attributeGroup ref="generalAttributes"/>
                    <xs:attributeGroup ref="languageAttribute"/>
                    <xs:attributeGroup ref="textformatAttribute"/>
                </xs:extension>
            </xs:complexContent>
        </xs:complexType>
    </xs:element>

#### Case: (Onix2 only)

    <xs:element name="Annotation">
        <xs:complexType mixed="true">
            <xs:choice minOccurs="0" maxOccurs="unbounded">
                <xs:element ref="p"/>
                <xs:element ref="h1"/>
                <xs:element ref="h2"/>
                <xs:element ref="h3"/>
                ...
            </xs:choice>
            <xs:attribute name="refname" type="xs:NMTOKEN" fixed="Annotation"/>
            <xs:attribute name="shortname" type="xs:NMTOKEN" fixed="d100"/>
            <xs:attributeGroup ref="generalAttributes"/>
        </xs:complexType>
    </xs:element>

### Onix Composites

T.B.D

## Structure of Onix Types

Represented by an `<simpleType>` tag, with the following general structure:

	<xs:simpleType name="NAME">
	    <xs:annotation/>
	    <xs:restriction/> or <xs:union/> or <xs:list/> 
	</xs:simpleType>

Each such tag is represented by `OnixSimpleType` class.

### Examples of `xs:restriction` tags in ONIX `simpleType` tags

#### Case

	# CASE 1: in Structure schema
	<xs:simpleType name="dt.StrictPositiveDecimal">
		<xs:restriction base="xs:decimal">
			<xs:minExclusive value="0" />
		</xs:restriction>
	</xs:simpleType>

#### Case

	# CASE 1A: in Structure schema
	<xs:simpleType name="DateOrDateTime">
		<xs:restriction base="xs:string">
			<xs:pattern value="2\d\d\d(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-8])(([01][0-9]|2[0-3])[0-5][0-9][0-5][0-9])?"/>
			<xs:pattern value="2\d\d\d(0[13-9]|1[0-2])(29|30)(([01][0-9]|2[0-3])[0-5][0-9][0-5][0-9])?"/>
			<xs:pattern value="2\d\d\d(0[13578]|1[02])31(([01][0-9]|2[0-3])[0-5][0-9][0-5][0-9])?"/>
			<xs:pattern value="2[048](0[048]|[13579][26]|[2468][048])0229(([01][0-9]|2[0-3])[0-5][0-9][0-5][0-9])?"/>
			<xs:pattern value="2[1235679](0[48]|[13579][26]|[2468][048])0229(([01][0-9]|2[0-3])[0-5][0-9][0-5][0-9])?"/>
		</xs:restriction>
	</xs:simpleType>

#### Case

	# CASE 1B: in Structure schema
	<xs:simpleType name="List218">
		<xs:annotation>
			<xs:documentation source="ONIX Code List 218">License expression type</xs:documentation>
		</xs:annotation>
		<xs:restriction base="xs:string">
			<xs:enumeration value="01">
				<xs:annotation>
					<xs:documentation>Human readable</xs:documentation>
					<xs:documentation>Document (eg Word file, PDF or web page) Intended for the lay reader</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
			<xs:enumeration value="02">
				<xs:annotation>
					<xs:documentation>Professional readable</xs:documentation>
					<xs:documentation>Document (eg Word file, PDF or web page) Intended for the legal specialist reader</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
			<xs:enumeration value="10">
				<xs:annotation>
					<xs:documentation>ONIX-PL</xs:documentation>
					<xs:documentation/>
				</xs:annotation>
			</xs:enumeration>
		</xs:restriction>
	</xs:simpleType>

#### Case

	# CASE 2: in Codelist schema
	<xs:simpleType name="SourceTypeCode">
		<xs:restriction base="List3"/>
	</xs:simpleType>

#### Case

	# CASE 3: in Structure schema
	<xs:simpleType name="CountryCodeList">
		<xs:restriction>
			<xs:simpleType>
				<xs:list itemType="List91" />
			</xs:simpleType>
			<xs:minLength value="1" />
		</xs:restriction>
	</xs:simpleType>
