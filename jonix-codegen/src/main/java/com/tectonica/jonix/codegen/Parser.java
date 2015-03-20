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

package com.tectonica.jonix.codegen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.tectonica.jonix.metadata.Multiplicity;
import com.tectonica.jonix.metadata.OnixAttribute;
import com.tectonica.jonix.metadata.OnixClass;
import com.tectonica.jonix.metadata.OnixConst;
import com.tectonica.jonix.metadata.OnixContentClass;
import com.tectonica.jonix.metadata.OnixContentClassMember;
import com.tectonica.jonix.metadata.OnixEnumValue;
import com.tectonica.jonix.metadata.OnixFlagClass;
import com.tectonica.jonix.metadata.OnixMetadata;
import com.tectonica.jonix.metadata.OnixSimpleType;
import com.tectonica.jonix.metadata.OnixValueClass;
import com.tectonica.jonix.metadata.OnixValueClassMember;
import com.tectonica.jonix.metadata.Primitive;
import com.tectonica.jonix.util.DOM;
import com.tectonica.jonix.util.DOM.ElementListener;

public class Parser
{
	public static class SchemaContext
	{
		private Set<String> spaceables;
		private Map<String, OnixSimpleType> simpleTypes = new HashMap<>();
		private Set<String> enumNames = new HashSet<>();
		private Map<String, Element> groupNodes = new HashMap<>();
		private Map<String, Element> attributeGroupNodes = new HashMap<>();
	}

	private final SchemaContext context = new SchemaContext();
	private final OnixMetadata meta = new OnixMetadata();

	public Parser(Set<String> spaceables)
	{
		context.spaceables = spaceables;
	}

	public OnixMetadata getMetadata()
	{
		return meta;
	}

	public void analyzeSchema(Document doc)
	{
		final Element schema = (Element) doc.getElementsByTagName("xs:schema").item(0);
		amendContext(schema);

		DOM.forElementsOf(schema, new ElementListener()
		{
			@Override
			public void onElement(Element element)
			{
				final String xsdTagName = element.getNodeName();
				if (xsdTagName.equals("xs:element"))
				{
					extractOnixClass(element);
				}
				else if (xsdTagName.equals("xs:simpleType") || xsdTagName.equals("xs:attributeGroup") || xsdTagName.equals("xs:group"))
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

	private void amendContext(final Element schema)
	{
		processSimpleTypes(schema);
		processGroups(schema);
		processAttributeGroups(schema);
	}

	private void processSimpleTypes(final Element schema)
	{
		final NodeList simpleTypes = schema.getElementsByTagName("xs:simpleType");
		for (int i = 0; i < simpleTypes.getLength(); i++)
		{
			Element simpleType = (Element) simpleTypes.item(i);
			if (simpleType.getParentNode() != schema)
				continue; // TODO: change getElementsByTagName to getChildElementsByTagName
			final String simpleTypeName = simpleType.getAttribute("name");
			if (simpleTypeName.isEmpty())
				throw new RuntimeException("unnamed top-level xs:simpleType is unsupported");

			OnixSimpleType onixSimpleType = new OnixSimpleType();
			onixSimpleType.name = simpleType.getAttribute("name");
			processSimpleType(simpleType, onixSimpleType);
			if (onixSimpleType.dataType == null)
				throw new RuntimeException("erroneous processing of onixType " + onixSimpleType);

			if (onixSimpleType.enumValues != null)
			{
				onixSimpleType.enumName = enumNameOf(onixSimpleType);
				meta.enums.add(onixSimpleType);
			}
			else
				meta.types.add(onixSimpleType);

			context.simpleTypes.put(onixSimpleType.name, onixSimpleType);
		}
	}

	private String enumNameOf(OnixSimpleType onixSimpleType)
	{
		if (onixSimpleType.aliasFor != null)
			return context.simpleTypes.get(onixSimpleType.aliasFor).enumName;

		String enumName = enumJavaName(onixSimpleType.comment);
		if (!context.enumNames.add(enumName))
			enumName += onixSimpleType.name;
		return enumName;
	}

	private String enumJavaName(String enumComment)
	{
		final String[] splits = enumComment.replaceAll("[^a-zA-Z0-9 /]+", "").replaceAll("[ /]{2,}", " ").split(" |/");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < splits.length; i++)
		{
			String split = splits[i].toLowerCase();
			if (i == splits.length - 1 && (split.equalsIgnoreCase("code") || split.equalsIgnoreCase("codes")))
				break;
			sb.append(Character.toUpperCase(split.charAt(0))).append(split.substring(1));
		}
		return sb.toString() + "s";
	}

	private void processSimpleType(Element simpleType, final OnixSimpleType onixSimpleType)
	{
		DOM.forElementsOf(simpleType, new ElementListener()
		{
			@Override
			public void onElement(Element simpleTypeDef)
			{
				final String simpleTypeDefName = simpleTypeDef.getNodeName();

				if (simpleTypeDefName.equals("xs:restriction"))
				{
					handleRestriction(simpleTypeDef);
				}

				else if (simpleTypeDefName.equals("xs:annotation"))
				{
					onixSimpleType.comment = extractAnnotationText(simpleTypeDef);
				}

				else if (simpleTypeDefName.equals("xs:union"))
				{
					onixSimpleType.dataType = Primitive.String; // we don't even bother..
				}

				else if (simpleTypeDefName.equals("xs:list"))
				{
					handleList(simpleTypeDef);
				}
				else
					throw new RuntimeException("Unhandled case of " + simpleTypeDefName);
			}

			/**
			 * restriction can define a type by inheriting an existing one (primitive / non-primitive), or be defining a new type
			 */
			private void handleRestriction(Element restriction)
			{
				// first we check the case of inheritance
				if (restriction.hasAttribute("base"))
				{
					final String baseType = restriction.getAttribute("base");

					// we handle the case of primitive-type
					final Primitive primitiveType = Primitive.fromXsdToken(baseType);
					if (primitiveType != null)
					{
						onixSimpleType.dataType = primitiveType;

						// primitives (strings, actually) may have a pattern or a list of enumerated values
						final Element pattern = DOM.firstElemChild(restriction, "xs:pattern");
						if (pattern != null)
						{
							onixSimpleType.comment = pattern.getAttribute("value");
						}
						else
						{
							DOM.forElementsOf(restriction, "xs:enumeration", new ElementListener()
							{
								@Override
								public void onElement(Element enumeration)
								{
									final String value = enumeration.getAttribute("value");
									final Element annotation = DOM.firstElemChild(enumeration, "xs:annotation");
									String comment = (annotation != null) ? extractAnnotationText(annotation) : null;
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
									onixSimpleType.add(OnixEnumValue.create(name, value, description));
								}
							});
						}
						return;
					}

					// if non-primitive, we lookup the inherited type and simply create an alias to it
					final OnixSimpleType existing = context.simpleTypes.get(baseType);
					if (existing != null)
					{
						if (restriction.getChildNodes().getLength() > 0)
							throw new RuntimeException("Inheritance of non-privimive is limited to mere aliasing");
						// we have a situation where one type simply "inherits" another type that's NOT xsd-primitive
						onixSimpleType.aliasFrom(existing);
						return;
					}

					throw new RuntimeException("Unknown xs:restriction base: " + baseType);
				}

				// handle restriction that defines a new simpleType (rather than inheriting an existing xsd-type)
				final Element simpleTypeBelowRestriction = DOM.firstElemChild(restriction, "xs:simpleType");
				if (simpleTypeBelowRestriction != null)
				{
					processSimpleType(simpleTypeBelowRestriction, onixSimpleType);
					return;
				}

				throw new RuntimeException("Unhandled case of xs:restriction");
			}

			private String extractAnnotationText(Element annotation)
			{
				final StringBuffer sb = new StringBuffer();
				DOM.forElementsOf(annotation, "xs:documentation", new ElementListener()
				{
					@Override
					public void onElement(Element documentation)
					{
						final String line = DOM.getChildText(documentation);
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

			private void handleList(Element list)
			{
				final String itemType = list.getAttribute("itemType");
				if (itemType.isEmpty())
					throw new RuntimeException("xs:list doesn't specify an itemType attribute");

				OnixSimpleType existingType = context.simpleTypes.get(itemType);
				if (existingType == null)
					throw new RuntimeException("Unknown type " + itemType);

				onixSimpleType.aliasFrom(existingType);
			}
		});
	}

	private void processGroups(final Element schema)
	{
		DOM.forElementsOf(schema, "xs:group", new ElementListener()
		{
			@Override
			public void onElement(Element group)
			{
				final String groupName = group.getAttribute("name");
				if (groupName.isEmpty())
					throw new RuntimeException("unnamed top-level xs:group is unsupported");
				context.groupNodes.put(groupName, group);
			}
		});
	}

	private void processAttributeGroups(final Element schema)
	{
		DOM.forElementsOf(schema, "xs:attributeGroup", new ElementListener()
		{
			@Override
			public void onElement(Element attributeGroup)
			{
				final String attributeGroupName = attributeGroup.getAttribute("name");
				if (attributeGroupName.isEmpty())
					throw new RuntimeException("unnamed top-level xs:attributeGroup is unsupported");
				context.attributeGroupNodes.put(attributeGroupName, attributeGroup);
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

		final Element complexType = DOM.firstElemChild(element);
		if (!complexType.getNodeName().equals("xs:complexType"))
			throw new RuntimeException("top-level xs:element is expected to be defined as a xs:complexType");

		if (DOM.nextElemChild(complexType) != null)
			throw new RuntimeException("top-level xs:element is expected contain exactly one xs:complexType");

		final Element content = DOM.firstElemChild(complexType);
		final String contentType = content.getNodeName();
		final boolean defineFromScratch = contentType.equals("xs:sequence") || contentType.equals("xs:choice");
		final boolean defineByInheritance = contentType.equals("xs:simpleContent") || contentType.equals("xs:complexContent");
		final boolean defineFlag = contentType.equals("xs:attribute") || contentType.equals("xs:attributeGroup");

		OnixClass onixClass = null;
		Element attributesParent = null;

		if (defineFromScratch)
		{
			// special case for Onix2 Flow
			if (DOM.firstElemChild(content, "xs:element", "ref", "p") != null)
			{
				final OnixValueClassMember member = OnixValueClassMember.create(OnixSimpleType.XHTML);
				final OnixValueClass onixValueClass = new OnixValueClass();
				onixValueClass.name = onixTagName;
				onixValueClass.valueMember = member;
				onixValueClass.isSpaceable = context.spaceables.contains(onixTagName);
				meta.valueClasses.add(onixValueClass);
				onixClass = onixValueClass;
				attributesParent = complexType;
			}
			else
			{
				final Map<String, OnixContentClassMember> members = new LinkedHashMap<>();
				extractClassFromSequencesAndChoices(content, members);
				final OnixContentClass onixContentClass = new OnixContentClass();
				onixContentClass.name = onixTagName;
				onixContentClass.members = new ArrayList<>(members.values());
				meta.contentClasses.add(onixContentClass);
				onixClass = onixContentClass;
				attributesParent = complexType;
			}
		}
		else if (defineByInheritance)
		{
			final Element extension = DOM.firstElemChild(content);

			// validate that we can deal with the provided inheritance
			if (!extension.getNodeName().equals("xs:extension"))
				throw new RuntimeException("expected xs:extension as first child of " + contentType + ", found: " + extension.getNodeName());
			final String baseType = extension.getAttribute("base");
			if (baseType.isEmpty())
				throw new RuntimeException("found xs:extension without base");
			DOM.ensureTagNames(DOM.firstElemChild(extension), Arrays.asList("xs:attribute", "xs:attributeGroup"));

			final boolean complex = contentType.equals("xs:complexContent");

			final OnixSimpleType simpleType;
			if (!complex)
			{
				simpleType = context.simpleTypes.get(baseType);
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

			final OnixValueClassMember member = OnixValueClassMember.create(simpleType);
			final OnixValueClass onixValueClass = new OnixValueClass();
			onixValueClass.name = onixTagName;
			onixValueClass.valueMember = member;
			onixValueClass.isSpaceable = context.spaceables.contains(onixTagName);
			meta.valueClasses.add(onixValueClass);
			onixClass = onixValueClass;
			attributesParent = extension;
		}
		else if (defineFlag)
		{
			final OnixFlagClass onixFlagClass = new OnixFlagClass();
			onixFlagClass.name = onixTagName;
			meta.flagClasses.add(onixFlagClass);
			onixClass = onixFlagClass;
			attributesParent = complexType;
		}
		else
			throw new RuntimeException("first child of top-level xs:element's xs:complexType is expected to define a content. found: "
					+ contentType);

		// other than attributes, we don't expect other information about the class we just created
		DOM.ensureTagNames(DOM.nextElemChild(content), Arrays.asList("xs:attribute", "xs:attributeGroup"));

		if (attributesParent != null)
			extractAttributes(attributesParent, onixClass);
	}

	private void extractClassFromSequencesAndChoices(final Element sequenceOrChoice, final Map<String, OnixContentClassMember> members)
	{
		final Multiplicity parentMultiplicity = Multiplicity.of(sequenceOrChoice.getAttribute("minOccurs"),
				sequenceOrChoice.getAttribute("maxOccurs"));

		DOM.forElementsOf(sequenceOrChoice, new ElementListener()
		{
			@Override
			public void onElement(Element child)
			{
				final String childType = child.getNodeName();
				if (childType.equals("xs:element"))
				{
					final String className = child.getAttribute("ref");
					if (className.isEmpty())
						throw new RuntimeException("under content - xs:elemenet without ref found");
					final boolean isUnderChoice = sequenceOrChoice.getNodeName().equals("xs:choice");
					final String minOccurs = isUnderChoice ? "0" : child.getAttribute("minOccurs");
					final String maxOccurs = child.getAttribute("maxOccurs");
					Multiplicity multiplicity = Multiplicity.of(minOccurs, maxOccurs).commonGroundsWith(parentMultiplicity);
					final OnixContentClassMember existing = members.get(className);
					if (existing == null)
						members.put(className, OnixContentClassMember.create(className, multiplicity));
					else
						existing.multiplicity = existing.multiplicity.commonGroundsWith(multiplicity);
				}
				else if (childType.equals("xs:sequence") || childType.equals("xs:choice"))
				{
					extractClassFromSequencesAndChoices(child, members);
				}
				else if (childType.equals("xs:group"))
				{
					final Element group = context.groupNodes.get(child.getAttribute("ref"));
					if (group == null)
						throw new RuntimeException("under content - couldn't find group");
					extractClassFromSequencesAndChoices(group, members);
				}
				else
					throw new RuntimeException("under content - node of invalid type found: " + childType);
			}
		});
	}

	private void extractAttributes(Element attributesParent, final OnixClass onixClass)
	{
		final ElementListener attributeWorker = new ElementListener()
		{
			@Override
			public void onElement(Element attribute)
			{
				extractAttribute(attribute, onixClass);
			}
		};

		DOM.forElementsOf(attributesParent, "xs:attribute", attributeWorker);

		DOM.forElementsOf(attributesParent, "xs:attributeGroup", new ElementListener()
		{
			@Override
			public void onElement(Element attributeGroupRef)
			{
				final String ref = attributeGroupRef.getAttribute("ref");
				if (ref.isEmpty())
					throw new RuntimeException("xs:attributeGroup is specified without ref");
				final Element attributeGroup = context.attributeGroupNodes.get(ref);
				if (attributeGroup == null)
					throw new RuntimeException("no definition found for xs:attributeGroup ref=" + ref);

				DOM.forElementsOf(attributeGroup, "xs:attribute", attributeWorker);
			}
		});
	}

	private void extractAttribute(Element attribute, final OnixClass onixClass)
	{
		final String name = attribute.getAttribute("name");
		final String fixed = attribute.getAttribute("fixed");

		// case 1 - simplest possible const (using 'fixed')
		if (!fixed.isEmpty())
		{
			onixClass.add(OnixConst.create(name, fixed));
			return;
		}

		// case 2 - nested const (using internal 'xs:enumeration')
		final Element simpleType = DOM.firstElemChild(attribute, "xs:simpleType");
		if (simpleType != null)
		{
			final Element restriction = DOM.firstElemChild(simpleType, "xs:restriction");
			if (restriction == null)
				throw new RuntimeException();

			final String base = restriction.getAttribute("base");
			if (Primitive.fromXsdToken(base) != Primitive.String)
				throw new RuntimeException();

			final Element enumeration = DOM.firstElemChild(restriction, "xs:enumeration");
			if (enumeration == null)
				throw new RuntimeException();

			final String value = enumeration.getAttribute("value");

			if (name.isEmpty() || value.isEmpty())
				throw new RuntimeException("Empty const attribute");

			onixClass.add(OnixConst.create(name, value));
			return;
		}

		// case 3 - a true attribute
		final Primitive dataType;
		final String onixSimpleTypeName;
		final String enumName;
		final String baseType = attribute.hasAttribute("type") ? attribute.getAttribute("type") : "xs:string";
		final Primitive primitiveType = Primitive.fromXsdToken(baseType);
		if (primitiveType == null)
		{
			final OnixSimpleType onixSimple = context.simpleTypes.get(baseType);
			if (onixSimple == null)
				throw new RuntimeException("Couldn't find type " + baseType);
			onixSimpleTypeName = onixSimple.name;
			enumName = onixSimple.enumName;
			dataType = onixSimple.dataType;
		}
		else
		{
			dataType = primitiveType;
			onixSimpleTypeName = null;
			enumName = null;
		}
		onixClass.add(OnixAttribute.create(name, dataType, onixSimpleTypeName, enumName));
	}
}
