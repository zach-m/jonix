/*
 * Copyright (C) 2012 Zach Melamed
 * 
 * Latest version available online at https://github.com/zach-m/jonix
 * Contact me at zach@tectonica.co.il
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tectonica.jonix.codegen.generator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.tectonica.jonix.codegen.metadata.Cardinality;
import com.tectonica.jonix.codegen.metadata.OnixAttribute;
import com.tectonica.jonix.codegen.metadata.OnixClass;
import com.tectonica.jonix.codegen.metadata.OnixCompositeDef;
import com.tectonica.jonix.codegen.metadata.OnixCompositeMember;
import com.tectonica.jonix.codegen.metadata.OnixConst;
import com.tectonica.jonix.codegen.metadata.OnixDoc;
import com.tectonica.jonix.codegen.metadata.OnixElementDef;
import com.tectonica.jonix.codegen.metadata.OnixElementMember;
import com.tectonica.jonix.codegen.metadata.OnixEnumValue;
import com.tectonica.jonix.codegen.metadata.OnixFlagDef;
import com.tectonica.jonix.codegen.metadata.OnixMetadata;
import com.tectonica.jonix.codegen.metadata.OnixSimpleType;
import com.tectonica.jonix.codegen.metadata.OnixStruct;
import com.tectonica.jonix.codegen.metadata.OnixStructMember;
import com.tectonica.jonix.codegen.metadata.Primitive;
import com.tectonica.jonix.codegen.util.DOM;
import com.tectonica.jonix.codegen.util.DOM.ElementListener;

public class Parser
{
	public static enum OnixVersion
	{
		Ver2_1_03, Ver3_0_02
	}

	public static class SchemaContext
	{
		private final OnixVersion onixVersion;

		public SchemaContext(OnixVersion onixVersion)
		{
			this.onixVersion = onixVersion;
		}

		private Set<String> spaceables;
		private Set<String> enumNames = new HashSet<>();
		private Map<String, Element> groupNodes = new HashMap<>();
		private Map<String, Element> attributeGroupNodes = new HashMap<>();
	}

	private final SchemaContext context;
	private final OnixMetadata meta;

	public Parser(OnixVersion onixVersion, boolean isShort, Set<String> spaceables)
	{
		context = new SchemaContext(onixVersion);
		meta = new OnixMetadata(onixVersion, isShort);
		context.spaceables = spaceables;
	}

	public OnixMetadata getMetadata()
	{
		return meta;
	}

	public void analyzeSchema(Document doc)
	{
		final Element schemaElem = (Element) doc.getElementsByTagName("xs:schema").item(0);
		amendContext(schemaElem);

		DOM.forElementsOf(schemaElem, new ElementListener()
		{
			@Override
			public void onElement(Element element)
			{
				final String xsdTagName = element.getNodeName();
				if (xsdTagName.equals("xs:element"))
				{
					extractOnixClass(element);
				}
				else if (xsdTagName.equals("xs:simpleType") || xsdTagName.equals("xs:attributeGroup")
						|| xsdTagName.equals("xs:group"))
				{
					// handled in SchemaContext
				}
				else if (xsdTagName.equals("xs:include"))
				{
					// ignored
				}
				else
					throw new RuntimeException("Unexpected top-level " + xsdTagName);
			}
		});
	}

	private void amendContext(final Element schemaElem)
	{
		processSimpleTypes(schemaElem);
		processGroups(schemaElem);
		processAttributeGroups(schemaElem);
	}

	private void processSimpleTypes(final Element schemaElem)
	{
		DOM.forElementsOf(schemaElem, "xs:simpleType", new ElementListener()
		{
			@Override
			public void onElement(Element simpleTypeElem)
			{
				final String simpleTypeName = simpleTypeElem.getAttribute("name");
				if (simpleTypeName.isEmpty())
					throw new RuntimeException("unnamed top-level xs:simpleType is unsupported");

				OnixSimpleType simpleType = new OnixSimpleType();
				simpleType.name = simpleTypeElem.getAttribute("name");
				processSimpleType(simpleTypeElem, simpleType);
				if (simpleType.primitiveType == null)
					throw new RuntimeException("erroneous processing of onixType " + simpleType);

				if (simpleType.isEnum())
				{
					simpleType.enumName = enumNameOf(simpleType);
					meta.onixEnums.put(simpleType.name, simpleType);
				}
				else
					meta.onixTypes.put(simpleType.name, simpleType);
			}
		});
	}

	private String enumNameOf(OnixSimpleType enumType)
	{
		if (enumType.enumAliasFor != null)
			return meta.typeByName(enumType.enumAliasFor).enumName;

		String enumName = enumJavaName(enumType.comment);
		if (!context.enumNames.add(enumName))
			enumName += enumType.name; // new code-list with the same name, we have to differentiate
		return enumName;
	}

	/**
	 * encodes the (free-text) comment of the code-list (i.e. its annotation from the XSD schema) into a proper Java
	 * name for the enum representing that code-list.
	 * <p>
	 * The process is NOT guaranteed to be forward-compatible as it only deals with cases observed.
	 * <p>
	 * Examples:
	 * <ul>
	 * <li>Title type code --> <code>TitleTypes</code>
	 * <li>Product composition --> <code>ProductCompositions</code>
	 * <li>Language code – based on ISO 639-2/B --> <code>LanguageCodes</code>
	 * </ul>
	 */
	private String enumJavaName(String enumComment)
	{
		final String[] splits = enumComment.replaceAll("[^a-zA-Z0-9 /]+", "").replaceAll("[ /]{2,}", " ").toLowerCase()
				.split(" |/");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < splits.length; i++)
		{
			String split = splits[i];
			if (i == splits.length - 1 && (split.equals("code") || split.equals("codes")))
				break;
			if ((i > 0 && i < splits.length - 1) && (split.equals("iso")))
				break;
			if ((i > 0 && i < splits.length - 3) && (split.equals("based")) && (splits[i + 1].equals("on"))
					&& (splits[i + 2].equals("iso")))
				break;
			sb.append(Character.toUpperCase(split.charAt(0))).append(split.substring(1));
		}
		return sb.toString() + "s";
	}

	private void processSimpleType(Element simpleTypeElem, final OnixSimpleType simpleType)
	{
		DOM.forElementsOf(simpleTypeElem, new ElementListener()
		{
			@Override
			public void onElement(Element simpleTypeDefElem)
			{
				final String simpleTypeDefName = simpleTypeDefElem.getNodeName();

				if (simpleTypeDefName.equals("xs:restriction"))
				{
					handleRestriction(simpleTypeDefElem);
				}

				else if (simpleTypeDefName.equals("xs:annotation"))
				{
					simpleType.comment = extractAnnotationText(simpleTypeDefElem);
				}

				else if (simpleTypeDefName.equals("xs:union"))
				{
					simpleType.primitiveType = Primitive.String; // we don't even bother..
				}

				else if (simpleTypeDefName.equals("xs:list"))
				{
					handleList(simpleTypeDefElem);
				}
				else
					throw new RuntimeException("Unhandled case of " + simpleTypeDefName);
			}

			/**
			 * restriction can define a type by inheriting an existing one (primitive / non-primitive), or be defining a
			 * new type
			 */
			private void handleRestriction(Element restrictionElem)
			{
				// first we check the case of inheritance
				if (restrictionElem.hasAttribute("base"))
				{
					final String baseType = restrictionElem.getAttribute("base");

					// we handle the case of primitive-type
					final Primitive primitiveType = Primitive.fromXsdToken(baseType);
					if (primitiveType != null)
					{
						simpleType.primitiveType = primitiveType;

						// primitives (strings, actually) may have a pattern or a list of enumerated values
						final Element patternElem = DOM.firstElemChild(restrictionElem, "xs:pattern");
						if (patternElem != null)
						{
							simpleType.comment = patternElem.getAttribute("value");
						}
						else
						{
							DOM.forElementsOf(restrictionElem, "xs:enumeration", new ElementListener()
							{
								@Override
								public void onElement(Element enumerationElem)
								{
									final String value = enumerationElem.getAttribute("value");
									final Element annotationElem = DOM.firstElemChild(enumerationElem, "xs:annotation");
									String comment = (annotationElem != null) ? extractAnnotationText(annotationElem)
											: null;
									final int lineBreak = comment.indexOf("\n");
									final String name;
									final String description;
									if (lineBreak < 0)
									{
										name = comment;
										description = null;
									}
									else
									{
										name = comment.substring(0, lineBreak);
										description = comment.substring(lineBreak + "\n".length());
									}
									simpleType.add(OnixEnumValue.create(name, value, description));
								}
							});
						}
						return;
					}

					// if non-primitive, we lookup the inherited type and simply create an alias to it
					final OnixSimpleType existing = meta.typeByName(baseType);
					if (existing != null)
					{
						if (restrictionElem.getChildNodes().getLength() > 0)
							throw new RuntimeException("Inheritance of non-privimive is limited to mere aliasing");
						// we have a situation where one type simply "inherits" another type that's NOT xsd-primitive
						simpleType.aliasFrom(existing);
						return;
					}

					throw new RuntimeException("Unknown xs:restriction base: " + baseType);
				}

				// handle restriction that defines a new simpleType (rather than inheriting an existing xsd-type)
				final Element simpleTypeElemBelowRestriction = DOM.firstElemChild(restrictionElem, "xs:simpleType");
				if (simpleTypeElemBelowRestriction != null)
				{
					processSimpleType(simpleTypeElemBelowRestriction, simpleType);
					return;
				}

				throw new RuntimeException("Unhandled case of xs:restriction");
			}

			private String extractAnnotationText(Element annotationElem)
			{
				final StringBuffer sb = new StringBuffer();
				DOM.forElementsOf(annotationElem, "xs:documentation", new ElementListener()
				{
					@Override
					public void onElement(Element documentationElem)
					{
						final String line = DOM.getChildText(documentationElem);
						if (line != null && !line.isEmpty())
						{
							if (sb.length() != 0)
								sb.append("\n");
							sb.append(line);
						}
					}
				});
				return sb.length() > 0 ? sb.toString() : null;
			}

			private void handleList(Element listElem)
			{
				final String itemType = listElem.getAttribute("itemType");
				if (itemType.isEmpty())
					throw new RuntimeException("xs:list doesn't specify an itemType attribute");

				OnixSimpleType existingType = meta.typeByName(itemType);
				if (existingType == null)
					throw new RuntimeException("Unknown type " + itemType);

				simpleType.aliasFrom(existingType);
			}
		});

		patchSimpleType(simpleType); // fixes some errors from the XSD, if such exist
	}

	private void patchSimpleType(final OnixSimpleType simpleType)
	{
		// hack for "ROW" constant in country-codes (ISO 3166-1)
		if (simpleType.name.equals("List91"))
			simpleType.enumValues.add(0, OnixEnumValue.create("Rest Of World", "ROW", "All unspecified countries"));
	}

	private void processGroups(final Element schemaElem)
	{
		DOM.forElementsOf(schemaElem, "xs:group", new ElementListener()
		{
			@Override
			public void onElement(Element groupElem)
			{
				final String groupName = groupElem.getAttribute("name");
				if (groupName.isEmpty())
					throw new RuntimeException("unnamed top-level xs:group is unsupported");
				context.groupNodes.put(groupName, groupElem);
			}
		});
	}

	private void processAttributeGroups(final Element schemaElem)
	{
		DOM.forElementsOf(schemaElem, "xs:attributeGroup", new ElementListener()
		{
			@Override
			public void onElement(Element attributeGroupElem)
			{
				final String attributeGroupName = attributeGroupElem.getAttribute("name");
				if (attributeGroupName.isEmpty())
					throw new RuntimeException("unnamed top-level xs:attributeGroup is unsupported");
				context.attributeGroupNodes.put(attributeGroupName, attributeGroupElem);
			}
		});
	}

	private void extractOnixClass(Element element)
	{
		String onixTagName = element.getAttribute("name");
		if (onixTagName.isEmpty())
			throw new RuntimeException("unnamed top-level xs:element is unsupported");

//		System.out.println("--- " + onixTagName);

//		if (!onixTagName.equals("Annotation"))
//			return;

		final Element complexTypeElem = DOM.firstElemChild(element);
		if (!complexTypeElem.getNodeName().equals("xs:complexType"))
			throw new RuntimeException("top-level xs:element is expected to be defined as a xs:complexType");

		if (DOM.nextElemChild(complexTypeElem) != null)
			throw new RuntimeException("top-level xs:element is expected contain exactly one xs:complexType");

		final Element contentElem = DOM.firstElemChild(complexTypeElem);
		final String contentType = contentElem.getNodeName();
		final boolean defineFromScratch = contentType.equals("xs:sequence") || contentType.equals("xs:choice");
		final boolean defineByInheritance = contentType.equals("xs:simpleContent")
				|| contentType.equals("xs:complexContent");
		final boolean defineFlag = contentType.equals("xs:attribute") || contentType.equals("xs:attributeGroup");

		OnixClass onixClass = null;
		Element attributesParentElem = null;

		if (defineFromScratch)
		{
			// special case for Onix2 Flow
			if (DOM.firstElemChild(contentElem, "xs:element", "ref", "p") != null)
			{
				final OnixElementMember member = OnixElementMember.create(OnixSimpleType.XHTML);
				final OnixElementDef onixElement = new OnixElementDef();
				onixElement.name = onixTagName;
				onixElement.valueMember = member;
				onixElement.isSpaceable = context.spaceables.contains(onixTagName);
				meta.onixElements.put(onixElement.name, onixElement);
				onixClass = onixElement;
				attributesParentElem = complexTypeElem;
			}
			else
			{
				final Map<String, OnixCompositeMember> members = new LinkedHashMap<>();
				extractClassFromSequencesAndChoices(contentElem, members);
				final OnixCompositeDef onixComposite = new OnixCompositeDef();
				onixComposite.name = onixTagName;
				onixComposite.members = new ArrayList<>(members.values());
				meta.onixComposites.put(onixComposite.name, onixComposite);
				onixClass = onixComposite;
				attributesParentElem = complexTypeElem;
			}
		}
		else if (defineByInheritance)
		{
			final Element extensionElem = DOM.firstElemChild(contentElem);

			// validate that we can deal with the provided inheritance
			if (!extensionElem.getNodeName().equals("xs:extension"))
				throw new RuntimeException("expected xs:extension as first child of " + contentType + ", found: "
						+ extensionElem.getNodeName());
			final String baseType = extensionElem.getAttribute("base");
			if (baseType.isEmpty())
				throw new RuntimeException("found xs:extension without base");
			DOM.ensureTagNames(DOM.firstElemChild(extensionElem), Arrays.asList("xs:attribute", "xs:attributeGroup"));

			final boolean complex = contentType.equals("xs:complexContent");

			final OnixSimpleType simpleType;
			if (!complex)
			{
				simpleType = meta.typeByName(baseType);
				if (simpleType == null)
					throw new RuntimeException("Unknown type " + baseType);
			}
			else
			{
				// special case for Onix3 Flow
				if (!baseType.equals("Flow"))
					throw new RuntimeException("found xs:extension with base type != Flow: " + baseType);
				simpleType = OnixSimpleType.XHTML;
			}

			final OnixElementDef onixElement = new OnixElementDef();
			final OnixElementMember member = OnixElementMember.create(simpleType);
			onixElement.name = onixTagName;
			onixElement.valueMember = member;
			onixElement.isSpaceable = context.spaceables.contains(onixTagName);
			patchElement(onixElement); // fixes some errors from the XSD, if such exist
			meta.onixElements.put(onixElement.name, onixElement);
			onixClass = onixElement;
			attributesParentElem = extensionElem;
		}
		else if (defineFlag)
		{
			final OnixFlagDef onixFlagClass = new OnixFlagDef();
			onixFlagClass.name = onixTagName;
			meta.onixFlags.put(onixFlagClass.name, onixFlagClass);
			onixClass = onixFlagClass;
			attributesParentElem = complexTypeElem;
		}
		else
			throw new RuntimeException(
					"first child of top-level xs:element's xs:complexType is expected to define a content. found: "
							+ contentType);

		// other than attributes, we don't expect other information about the class we just created
		DOM.ensureTagNames(DOM.nextElemChild(contentElem), Arrays.asList("xs:attribute", "xs:attributeGroup"));

		if (attributesParentElem != null)
			extractAttributes(attributesParentElem, onixClass);
	}

	private void patchElement(final OnixElementDef onixElement)
	{
		if (context.onixVersion == OnixVersion.Ver2_1_03)
		{
			// patch for error in Onix2_rev03 XSD with regards to AgentIDType (listed as free text)
			if (onixElement.name.equals("AgentIDType") || onixElement.name.equals("j400"))
				onixElement.valueMember = OnixElementMember.create(meta.onixEnums.get("List92"));

			// patch for error in Onix2_rev03 XSD with regards to MarketDateRole (listed as free text)
			// NOTE: the correct codelist is 67, but we use 163 (which extends 67) so that a common struct can be
			// created
			else if (onixElement.name.equals("MarketDateRole") || onixElement.name.equals("j408"))
				onixElement.valueMember = OnixElementMember.create(meta.onixEnums.get("List163"));
		}
	}

	private void extractClassFromSequencesAndChoices(final Element sequenceOrChoiceElem,
			final Map<String, OnixCompositeMember> members)
	{
		final Cardinality parentCardinality = Cardinality.of(sequenceOrChoiceElem.getAttribute("minOccurs"),
				sequenceOrChoiceElem.getAttribute("maxOccurs"));

		DOM.forElementsOf(sequenceOrChoiceElem, new ElementListener()
		{
			@Override
			public void onElement(Element childElem)
			{
				final String childType = childElem.getNodeName();
				if (childType.equals("xs:element"))
				{
					final String className = childElem.getAttribute("ref");
					if (className.isEmpty())
						throw new RuntimeException("under content - xs:elemenet without ref found");
					final boolean isUnderChoice = sequenceOrChoiceElem.getNodeName().equals("xs:choice");
					final String minOccurs = isUnderChoice ? "0" : childElem.getAttribute("minOccurs");
					final String maxOccurs = childElem.getAttribute("maxOccurs");
					Cardinality cardinality = Cardinality.of(minOccurs, maxOccurs).mergeWith(parentCardinality);
					final OnixCompositeMember existing = members.get(className);
					if (existing == null)
					{
						OnixCompositeMember onixCompositeMember = OnixCompositeMember.create(className, cardinality);
						patchCompositeMember(onixCompositeMember);
						members.put(className, onixCompositeMember);
					}
					else
						existing.cardinality = existing.cardinality.mergeWith(cardinality);
				}
				else if (childType.equals("xs:sequence") || childType.equals("xs:choice"))
				{
					extractClassFromSequencesAndChoices(childElem, members);
				}
				else if (childType.equals("xs:group"))
				{
					final Element groupElem = context.groupNodes.get(childElem.getAttribute("ref"));
					if (groupElem == null)
						throw new RuntimeException("under content - couldn't find group");
					extractClassFromSequencesAndChoices(groupElem, members);
				}
				else
					throw new RuntimeException("under content - node of invalid type found: " + childType);
			}
		});
	}

	private void patchCompositeMember(OnixCompositeMember onixCompositeMember)
	{
		// in Onix's <AudienceRange> there are two members <AudienceRangePrecision> and <AudienceRangeValue>
		// with a very unique cardinality - they can appear once, twice or not at all. the XSD doesn't reflect that
		if (onixCompositeMember.className.equals("AudienceRangePrecision")
				|| onixCompositeMember.className.equals("AudienceRangeValue")
				|| onixCompositeMember.className.equals("b075") || onixCompositeMember.className.equals("b076"))
		{
			onixCompositeMember.cardinality = Cardinality.ZeroOrMore;
		}
	}

	private void extractAttributes(Element attributesParentElem, final OnixClass onixClass)
	{
		final ElementListener attributeWorker = new ElementListener()
		{
			@Override
			public void onElement(Element attributeElem)
			{
				extractAttribute(attributeElem, onixClass);
			}
		};

		DOM.forElementsOf(attributesParentElem, "xs:attribute", attributeWorker);

		DOM.forElementsOf(attributesParentElem, "xs:attributeGroup", new ElementListener()
		{
			@Override
			public void onElement(Element attributeGroupRefElem)
			{
				final String ref = attributeGroupRefElem.getAttribute("ref");
				if (ref.isEmpty())
					throw new RuntimeException("xs:attributeGroup is specified without ref");
				final Element attributeGroupElem = context.attributeGroupNodes.get(ref);
				if (attributeGroupElem == null)
					throw new RuntimeException("no definition found for xs:attributeGroup ref=" + ref);

				DOM.forElementsOf(attributeGroupElem, "xs:attribute", attributeWorker);
			}
		});
	}

	private void extractAttribute(Element attributeElem, final OnixClass onixClass)
	{
		final String name = attributeElem.getAttribute("name");
		final String fixed = attributeElem.getAttribute("fixed");

		// case 1 - simplest possible const (using 'fixed')
		if (!fixed.isEmpty())
		{
			onixClass.add(OnixConst.create(name, fixed));
			return;
		}

		// case 2 - nested const (using internal 'xs:enumeration')
		final Element simpleTypeElement = DOM.firstElemChild(attributeElem, "xs:simpleType");
		if (simpleTypeElement != null)
		{
			final Element restrictionElem = DOM.firstElemChild(simpleTypeElement, "xs:restriction");
			if (restrictionElem == null)
				throw new RuntimeException();

			final String base = restrictionElem.getAttribute("base");
			if (Primitive.fromXsdToken(base) != Primitive.String)
				throw new RuntimeException();

			final Element enumerationElem = DOM.firstElemChild(restrictionElem, "xs:enumeration");
			if (enumerationElem == null)
				throw new RuntimeException();

			final String value = enumerationElem.getAttribute("value");

			if (name.isEmpty() || value.isEmpty())
				throw new RuntimeException("Empty const attribute");

			onixClass.add(OnixConst.create(name, value));
			return;
		}

		// case 3 - a true attribute
		final String baseType = attributeElem.hasAttribute("type") ? attributeElem.getAttribute("type") : "xs:string";
		final Primitive primitiveType = Primitive.fromXsdToken(baseType);
		if (primitiveType == null)
		{
			final OnixSimpleType simpleType = meta.typeByName(baseType);
			if (simpleType == null)
				throw new RuntimeException("Couldn't find type " + baseType);
			onixClass.add(OnixAttribute.create(name, simpleType));
		}
		else
		{
			onixClass.add(OnixAttribute.create(name, primitiveType));
		}
	}

	public void postAnalysis(String specHtml)
	{
		// we're traversing all composites, looking for those that are data-composites, i.e. that contain ONLY elements
		// and/or flags
		for (OnixCompositeDef composite : meta.getComposites())
		{
			boolean isDataComposite = true;
			OnixStruct struct = new OnixStruct(composite);
			for (OnixCompositeMember member : composite.members)
			{
				member.onixClass = meta.classByName(member.className);
				if (member.onixClass == null)
					throw new NullPointerException("class " + member.className + " referenced by " + composite.name
							+ " wasn't found");

				if (member.onixClass instanceof OnixElementDef)
				{
					OnixSimpleType simpleType = ((OnixElementDef) member.onixClass).valueMember.simpleType;

					boolean isKey = false;
					if (simpleType.isEnum() && (member.cardinality == Cardinality.Required))
					{
						if (simpleType.enumName.endsWith("Types") || simpleType.enumName.endsWith("Roles"))
						{
							if (struct.keyMember == null) // in rare-cases (e.g. OtherText) where there are several
															// candidates we take the
															// first
								isKey = true;
						}
					}
					if (isKey)
						struct.keyMember = new OnixStructMember(member);
					else
						struct.members.add(new OnixStructMember(member));
				}
				else if (member.onixClass instanceof OnixFlagDef)
				{
					struct.members.add(new OnixStructMember(member));
				}
				else
				{
					isDataComposite = false;
					break;
				}
			}

			if (isDataComposite)
			{
				if (struct.members.size() == 0)
					throw new RuntimeException("Struct with no members - " + struct.containingComposite.name);
				meta.jonixStructs.put(composite.name, struct);
			}
//			else
//			{
//				meta.jonixIntfs.put(composite.name, composite);
//			}
		}

		// attach documentation
		if (!meta.isShort)
		{
			try
			{
				for (OnixDoc onixDoc : OnixDocsParser.parse(specHtml))
				{
					OnixClass onixClass = meta.classByName(onixDoc.onixClassName);
					if (onixClass == null)
						System.err.println("WARNING: no class for onixDoc: '" + onixDoc.onixClassName + "'");
					else
						onixClass.onixDoc = onixDoc;
				}
			}
			catch (IOException e)
			{
				throw new RuntimeException(e);
			}
		}
	}
}
