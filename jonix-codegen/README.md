jonix-codegen
=

Utility library for generating source code for onix-processing classes directly from EDItEUR's schema  
 
 
Structure of of Onix class:

	<xs:element name="OnixClassName">         element
		<xs:complexType>                      complexTypeElem
			<xs:...>                          contentElem
			</xs:...>
		</xs:complexType>
	</xs:element>

Examples of `xs:restriction` tags in ONIX:

	# CASE 1: in Elements schema
	<xs:simpleType name="dt.StrictPositiveDecimal">
		<xs:restriction base="xs:decimal">
			<xs:minExclusive value="0" />
		</xs:restriction>
	</xs:simpleType>

	# CASE 1A: in Elements schema
	<xs:simpleType name="DateOrDateTime">
		<xs:restriction base="xs:string">
			<xs:pattern value="2\d\d\d(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-8])(([01][0-9]|2[0-3])[0-5][0-9][0-5][0-9])?"/>
			<xs:pattern value="2\d\d\d(0[13-9]|1[0-2])(29|30)(([01][0-9]|2[0-3])[0-5][0-9][0-5][0-9])?"/>
			<xs:pattern value="2\d\d\d(0[13578]|1[02])31(([01][0-9]|2[0-3])[0-5][0-9][0-5][0-9])?"/>
			<xs:pattern value="2[048](0[048]|[13579][26]|[2468][048])0229(([01][0-9]|2[0-3])[0-5][0-9][0-5][0-9])?"/>
			<xs:pattern value="2[1235679](0[48]|[13579][26]|[2468][048])0229(([01][0-9]|2[0-3])[0-5][0-9][0-5][0-9])?"/>
		</xs:restriction>
	</xs:simpleType>

	# CASE 1B: in Elements schema
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

	# CASE 2: in Codelist schema
	<xs:simpleType name="SourceTypeCode">
		<xs:restriction base="List3"/>
	</xs:simpleType>

	# CASE 3: in Elements schema
	<xs:simpleType name="CountryCodeList">
		<xs:restriction>
			<xs:simpleType>
				<xs:list itemType="List91" />
			</xs:simpleType>
			<xs:minLength value="1" />
		</xs:restriction>
	</xs:simpleType>
