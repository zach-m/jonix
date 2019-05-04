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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Parser {
    private static final Logger LOGGER = LoggerFactory.getLogger(Parser.class);

    public enum OnixVersion {
        Ver2_1_03, Ver3_0_06
    }

    public static class SchemaContext {
        private final OnixVersion onixVersion;

        SchemaContext(OnixVersion onixVersion) {
            this.onixVersion = onixVersion;
        }

        private Set<String> spaceables;
        private Set<String> enumNames = new HashSet<>();
        private Map<String, Element> groupNodes = new HashMap<>();
        private Map<String, Element> attributeGroupNodes = new HashMap<>();
    }

    private final SchemaContext context;
    private final OnixMetadata meta;

    public Parser(OnixVersion onixVersion, boolean isShort, Set<String> spaceables) {
        context = new SchemaContext(onixVersion);
        meta = new OnixMetadata(onixVersion, isShort);
        context.spaceables = spaceables;
    }

    public OnixMetadata getMetadata() {
        return meta;
    }

    public void analyzeSchema(Document xsdDoc) {
        // take the top-container from of the XSD file
        final Element schemaElem = (Element) xsdDoc.getElementsByTagName("xs:schema").item(0);

        // process auxiliary tags (SimpleTypes, Groups, AttributeGroups) that other tags will references later
        amendContext(schemaElem);

        // traverse top-level elements of the schema, looking for Onix classes
        DOM.forElementsOf(schemaElem, element -> {
            final String xsdTagName = element.getNodeName();
            switch (xsdTagName) {
                case "xs:element":
                    extractOnixClass(element);
                    break;
                case "xs:simpleType":
                case "xs:attributeGroup":
                case "xs:group":
                    // auxiliary tags, pre-handled in amendContext(), already exist in OnixMetadata or SchemaContext
                    break;
                case "xs:include":
                    String schemaLocation = element.getAttribute("schemaLocation");
                    if (schemaLocation.equals("ONIX_BookProduct_CodeLists.xsd") ||
                        schemaLocation.equals("ONIX_XHTML_Subset.xsd")) {
                        // TODO: make sure and exaplain the following comment
                        // we ignore these XSD includes, as we handle them separately
                        LOGGER.debug("NOTE: Ignoring known xs:include: " + schemaLocation);
                    } else {
                        throw new RuntimeException("Unexpected top-level xs:include " + schemaLocation);
                    }
                    break;
                default:
                    throw new RuntimeException("Unexpected top-level " + xsdTagName);
            }
        });
    }

    /**
     * Process primitive/auxiliary top-level tags (SimpleTypes, Groups, AttributeGroups) that Onix classes are composed
     * of. SimpleTypes are stored directly in {@link #meta}, as they already represent final types. Groups and
     * AttributeGroups, on the other hand, are stored intermediately in {@link #context}, and used later in parsing.
     */
    private void amendContext(final Element schemaElem) {
        processSimpleTypes(schemaElem);
        processGroups(schemaElem);
        processAttributeGroups(schemaElem);
    }

    private void processSimpleTypes(final Element schemaElem) {
        DOM.forElementsOf(schemaElem, "xs:simpleType", simpleTypeElem -> {
            final String simpleTypeName = simpleTypeElem.getAttribute("name");
            if (simpleTypeName.isEmpty()) {
                throw new RuntimeException("unnamed top-level xs:simpleType is unsupported");
            }

            OnixSimpleType simpleType = new OnixSimpleType();
            simpleType.name = simpleTypeElem.getAttribute("name");
            processSimpleType(simpleTypeElem, simpleType);
            if (simpleType.primitiveType == null) {
                throw new RuntimeException("erroneous processing of onixType " + simpleType);
            }

            if (simpleType.isEnum()) {
                simpleType.enumName = enumNameOf(simpleType);
                meta.onixEnums.put(simpleType.name, simpleType);
            } else {
                meta.onixTypes.put(simpleType.name, simpleType);
            }

            LOGGER.debug("processed simpleType: " + simpleType.name);
        });
    }

    private String enumNameOf(OnixSimpleType enumType) {
        if (enumType.enumAliasFor != null) {
            return meta.typeByName(enumType.enumAliasFor).enumName;
        }

        String enumName = enumJavaName(enumType.comment);
        if (!context.enumNames.add(enumName)) {
            enumName += enumType.name; // new code-list with the same name, we have to differentiate
        }
        return enumName;
    }

    /**
     * encodes the (free-text) comment of the code-list (i.e. its annotation from the XSD schema) into a proper Java
     * name for the enum representing that code-list.
     * <p>
     * The process is NOT guaranteed to be forward-compatible as it only deals with cases observed.
     * <p>
     * Examples: <ul> <li>Title type code --> <code>TitleTypes</code> <li>Product composition -->
     * <code>ProductCompositions</code> <li>Language code – based on ISO 639-2/B --> <code>LanguageCodes</code> </ul>
     */
    private String enumJavaName(String enumComment) {
        final String[] splits = enumComment.replaceAll("[^a-zA-Z0-9 /]+", "").replaceAll("[ /]{2,}", " ").toLowerCase()
            .split("[ /]");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splits.length; i++) {
            String split = splits[i];
            if (i == splits.length - 1 && (split.equals("code") || split.equals("codes"))) {
                break;
            }
            if ((i > 0 && i < splits.length - 1) && (split.equals("iso"))) {
                break;
            }
            if ((i > 0 && i < splits.length - 3) && (split.equals("based")) && (splits[i + 1].equals("on"))
                && (splits[i + 2].equals("iso"))) {
                break;
            }
            sb.append(Character.toUpperCase(split.charAt(0))).append(split.substring(1));
        }
        return sb.toString() + "s";
    }

    private void processSimpleType(Element simpleTypeElem, final OnixSimpleType simpleType) {
        DOM.forElementsOf(simpleTypeElem, new ElementListener() {
            @Override
            public void onElement(Element simpleTypeDefElem) {
                final String simpleTypeDefName = simpleTypeDefElem.getNodeName();

                switch (simpleTypeDefName) {
                    case "xs:restriction":
                        handleRestriction(simpleTypeDefElem);
                        break;
                    case "xs:annotation":
                        simpleType.comment = extractAnnotationText(simpleTypeDefElem);
                        break;
                    case "xs:union":
                        simpleType.primitiveType = Primitive.String; // we don't even bother..

                        break;
                    case "xs:list":
                        handleList(simpleTypeDefElem);
                        break;
                    default:
                        throw new RuntimeException("Unhandled case of " + simpleTypeDefName);
                }
            }

            /**
             * restriction can define a type by inheriting an existing one (primitive / non-primitive), or by defining a
             * new type
             */
            private void handleRestriction(Element restrictionElem) {
                // first we check the case of inheritance
                if (restrictionElem.hasAttribute("base")) {
                    final String baseType = restrictionElem.getAttribute("base");

                    // we handle the case of primitive-type
                    final Primitive primitiveType = Primitive.fromXsdToken(baseType);
                    if (primitiveType != null) {
                        simpleType.primitiveType = primitiveType;

                        // primitives (strings, actually) may have a pattern or a list of enumerated values
                        final Element patternElem = DOM.firstElemChild(restrictionElem, "xs:pattern");
                        if (patternElem != null) {
                            simpleType.comment = patternElem.getAttribute("value");
                        } else {
                            DOM.forElementsOf(restrictionElem, "xs:enumeration", enumerationElem -> {
                                final String value = enumerationElem.getAttribute("value");
                                final Element annotationElem = DOM.firstElemChild(enumerationElem, "xs:annotation");
                                String comment = extractAnnotationText(annotationElem);
                                if (comment == null) {
                                    throw new NullPointerException();
                                }
                                final int lineBreak = comment.indexOf("\n");
                                final String name;
                                final String description;
                                if (lineBreak < 0) {
                                    name = comment;
                                    description = null;
                                } else {
                                    name = comment.substring(0, lineBreak);
                                    description = comment.substring(lineBreak + "\n".length());
                                }
                                simpleType.add(OnixEnumValue.create(name, value, description));
                            });
                        }
                        return;
                    }

                    // if non-primitive, we lookup the inherited type and simply create an alias to it
                    final OnixSimpleType existing = meta.typeByName(baseType);
                    if (existing != null) {
                        if (restrictionElem.getChildNodes().getLength() > 0) {
                            throw new RuntimeException("Inheritance of non-privimive is limited to mere aliasing");
                        }
                        // we have a situation where one type simply "inherits" another type that's NOT xsd-primitive
                        simpleType.aliasFrom(existing);
                        return;
                    }

                    throw new RuntimeException("Unknown xs:restriction base: " + baseType);
                }

                // handle restriction that defines a new simpleType (rather than inheriting an existing xsd-type)
                final Element simpleTypeElemBelowRestriction = DOM.firstElemChild(restrictionElem, "xs:simpleType");
                if (simpleTypeElemBelowRestriction != null) {
                    processSimpleType(simpleTypeElemBelowRestriction, simpleType);
                    return;
                }

                throw new RuntimeException("Unhandled case of xs:restriction");
            }

            private String extractAnnotationText(Element annotationElem) {
                final StringBuilder sb = new StringBuilder();
                DOM.forElementsOf(annotationElem, "xs:documentation", documentationElem -> {
                    final String line = DOM.getChildText(documentationElem);
                    if (line != null && !line.isEmpty()) {
                        if (sb.length() != 0) {
                            sb.append("\n");
                        }
                        sb.append(line);
                    }
                });
                return sb.length() > 0 ? sb.toString() : null;
            }

            private void handleList(Element listElem) {
                final String itemType = listElem.getAttribute("itemType");
                if (itemType.isEmpty()) {
                    throw new RuntimeException("xs:list doesn't specify an itemType attribute");
                }

                OnixSimpleType existingType = meta.typeByName(itemType);
                if (existingType == null) {
                    throw new RuntimeException("Unknown type " + itemType);
                }

                simpleType.aliasFrom(existingType);
            }
        });

        patchSimpleType(simpleType); // fixes some errors from the XSD, if such exist
    }

    private void patchSimpleType(final OnixSimpleType simpleType) {
        // hack for "ROW" constant in country-codes (ISO 3166-1)
        if (simpleType.name.equals("List91")) {
            simpleType.enumValues.add(0, OnixEnumValue.create("Rest Of World", "ROW", "All unspecified countries"));
        }
    }

    private void processGroups(final Element schemaElem) {
        DOM.forElementsOf(schemaElem, "xs:group", groupElem -> {
            final String groupName = groupElem.getAttribute("name");
            if (groupName.isEmpty()) {
                throw new RuntimeException("unnamed top-level xs:group is unsupported");
            }
            context.groupNodes.put(groupName, groupElem);
            LOGGER.debug("processed group: {}", groupName);
        });
    }

    private void processAttributeGroups(final Element schemaElem) {
        DOM.forElementsOf(schemaElem, "xs:attributeGroup", attributeGroupElem -> {
            final String attributeGroupName = attributeGroupElem.getAttribute("name");
            if (attributeGroupName.isEmpty()) {
                throw new RuntimeException("unnamed top-level xs:attributeGroup is unsupported");
            }
            context.attributeGroupNodes.put(attributeGroupName, attributeGroupElem);
            LOGGER.debug("processed attributeGroup: " + attributeGroupName);
        });
    }

    /**
     *
     */
    private void extractOnixClass(Element element) {

        String onixTagName = element.getAttribute("name");
        if (onixTagName.isEmpty()) {
            throw new RuntimeException("unnamed top-level xs:element is unsupported");
        }

        //if (!onixTagName.equals("Annotation"))
        //    return;

        Element complexTypeElem;
        Element contentElem;
        String contentType = "";
        try {
            complexTypeElem = DOM.firstElemChild(element);
            if (!complexTypeElem.getNodeName().equals("xs:complexType")) {
                throw new RuntimeException("top-level xs:element is expected to be defined as a xs:complexType");
            }

            if (DOM.nextElemChild(complexTypeElem) != null) {
                throw new RuntimeException("top-level xs:element is expected contain exactly one xs:complexType");
            }

            // the basic structure is now validated (xs:element containing single xs:complexType)
            contentElem = DOM.firstElemChild(complexTypeElem);
            contentType = contentElem.getNodeName();

        } finally {
            LOGGER.debug("--- {} ({})", onixTagName, contentType);
        }

        // the first child of <xs:complexType> determines how to process it, there are 3 cases
        final boolean defineFromScratch =
            contentType.equals("xs:sequence") || contentType.equals("xs:choice") || contentType.equals("xs:group");
        final boolean defineByInheritance =
            contentType.equals("xs:simpleContent") || contentType.equals("xs:complexContent");
        final boolean defineFlag =
            contentType.equals("xs:attribute") || contentType.equals("xs:attributeGroup");

        final OnixClass onixClass;
        final Element attributesParentElem;

        if (defineFromScratch) { // first case (OnixComposite): content is "xs:sequence|xs:choice|xs:group"
            // special treatment for Onix2 Flow
            if (DOM.firstElemChild(contentElem, "xs:element", "ref", "p") != null) {
                final OnixElementMember member = OnixElementMember.create(OnixSimpleType.XHTML);
                final OnixElementDef onixElement = new OnixElementDef();
                onixElement.name = onixTagName;
                onixElement.valueMember = member;
                onixElement.isSpaceable = context.spaceables.contains(onixTagName);
                meta.onixElements.put(onixElement.name, onixElement);
                onixClass = onixElement;
            } else {
                final Map<String, OnixCompositeMember> members = new LinkedHashMap<>();
                if (contentType.equals("xs:group")) {
                    extractMembersFromGroup(contentElem, members);
                } else {
                    extractMembers(contentElem, members);
                }
                final OnixCompositeDef onixComposite = new OnixCompositeDef();
                onixComposite.name = onixTagName;
                onixComposite.members = new ArrayList<>(members.values());
                meta.onixComposites.put(onixComposite.name, onixComposite);
                onixClass = onixComposite;
            }
            attributesParentElem = complexTypeElem;

        } else if (defineByInheritance) { // second case (OnixElement): content is "xs:simpleContent|xs:complexContent"
            final Element extensionElem = DOM.firstElemChild(contentElem);

            // validate that we can deal with the provided inheritance
            if (!extensionElem.getNodeName().equals("xs:extension")) {
                throw new RuntimeException("expected xs:extension as first child of " + contentType + ", found: "
                    + extensionElem.getNodeName());
            }
            final String baseType = extensionElem.getAttribute("base");
            if (baseType.isEmpty()) {
                throw new RuntimeException("found xs:extension without base");
            }
            DOM.ensureTagNames(DOM.firstElemChild(extensionElem), Arrays.asList("xs:attribute", "xs:attributeGroup"));

            final boolean complex = contentType.equals("xs:complexContent");

            final OnixSimpleType simpleType;
            if (!complex) {
                simpleType = meta.typeByName(baseType);
                if (simpleType == null) {
                    throw new RuntimeException("Unknown type " + baseType);
                }
            } else {
                // special case for Onix3 Flow
                if (!baseType.equals("Flow")) {
                    throw new RuntimeException("found xs:extension with base type != Flow: " + baseType);
                }
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

        } else if (defineFlag) { // third case (OnixFlag): content is merely "xs:attribute|xs:attributeGroup"
            final OnixFlagDef onixFlagClass = new OnixFlagDef();
            onixFlagClass.name = onixTagName;
            meta.onixFlags.put(onixFlagClass.name, onixFlagClass);
            onixClass = onixFlagClass;
            attributesParentElem = complexTypeElem;

        } else {
            throw new RuntimeException(
                "first child of top-level xs:element's xs:complexType is expected to define a content. found: "
                    + contentType);
        }

        // other than attributes, we don't expect other information about the class we just created
        DOM.ensureTagNames(DOM.nextElemChild(contentElem), Arrays.asList("xs:attribute", "xs:attributeGroup"));
        extractAttributes(attributesParentElem, onixClass);
    }

    private void patchElement(final OnixElementDef onixElement) {
        if (context.onixVersion == OnixVersion.Ver2_1_03) {
            // patch for error in Onix2_rev03 XSD with regards to AgentIDType (listed as free text)
            if (onixElement.name.equals("AgentIDType") || onixElement.name.equals("j400")) {
                onixElement.valueMember = OnixElementMember.create(meta.onixEnums.get("List92"));
            } else if (onixElement.name.equals("MarketDateRole") || onixElement.name.equals("j408")) {
                // patch for error in Onix2_rev03 XSD with regards to MarketDateRole (listed as free text)
                // NOTE: the correct codelist is 67, but we use 163 (which extends 67) so that a common struct can be
                // created
                onixElement.valueMember = OnixElementMember.create(meta.onixEnums.get("List163"));
            }
        }
    }

    private void extractMembers(final Element sequenceOrChoiceElem,
                                final Map<String, OnixCompositeMember> members) {

        final Cardinality parentCardinality = Cardinality.of(sequenceOrChoiceElem.getAttribute("minOccurs"),
            sequenceOrChoiceElem.getAttribute("maxOccurs"));

        DOM.forElementsOf(sequenceOrChoiceElem, childElem -> {
            final String childType = childElem.getNodeName();
            switch (childType) {
                case "xs:sequence":
                case "xs:choice":
                    // recurse, looking for the elements
                    extractMembers(childElem, members);
                    break;
                case "xs:group":
                    // recurse, looking for the elements
                    extractMembersFromGroup(childElem, members); // recurse
                    break;
                case "xs:element":
                    final String className = childElem.getAttribute("ref");
                    if (className.isEmpty()) {
                        throw new RuntimeException("under content - xs:elemenet without ref found");
                    }
                    final boolean isUnderChoice = sequenceOrChoiceElem.getNodeName().equals("xs:choice");
                    final String minOccurs = isUnderChoice ? "0" : childElem.getAttribute("minOccurs");
                    final String maxOccurs = childElem.getAttribute("maxOccurs");
                    Cardinality cardinality = Cardinality.of(minOccurs, maxOccurs).mergeWith(parentCardinality);
                    final OnixCompositeMember existing = members.get(className);
                    if (existing == null) {
                        OnixCompositeMember onixCompositeMember = OnixCompositeMember.create(className, cardinality);
                        patchCompositeMember(onixCompositeMember);
                        members.put(className, onixCompositeMember);
                    } else {
                        // this is a case where a certain member is listed more than once in the specs of the parent
                        // element. this happens when the XSD allows several xs:choices, each with its own cardinality.
                        // for example, the Addressee composite requires AddresseeName child element, unless one or more
                        // AddresseeIdentifier children are provided, in which case the AddresseeName is optional.
                        // here we merge these two contradicting specs (required vs optional, single vs multiple) into
                        // the broadest one.
                        Cardinality previousCardinality = existing.cardinality;
                        existing.cardinality = previousCardinality.mergeWith(cardinality);
                        LOGGER.debug("merging cardinalities of member {} ({} + {} = {})",
                            className, previousCardinality, cardinality, existing.cardinality);
                        // TODO: when more than one xs:choice is given, a may require implicit merge.
                        //  For example, in the example above, AddresseeIdentifier should actually be regarded as
                        //  ZeroOrMore, rather than the explicit OneOrMore specified in one of the choices
                    }
                    break;
                default:
                    throw new RuntimeException("under content - node of invalid type found: " + childType);
            }
        });
    }

    private void extractMembersFromGroup(final Element groupElem,
                                         final Map<String, OnixCompositeMember> members) {
        String groupName = groupElem.getAttribute("ref");
        final Element groupDefElem = context.groupNodes.get(groupName);
        if (groupDefElem == null) {
            throw new RuntimeException("under content - couldn't find group " + groupName);
        }
        Element groupDefTopElem = DOM.firstElemChild(groupDefElem);
        if (groupDefTopElem == null) {
            throw new RuntimeException("group " + groupName + " is empty");
        }
        String groupTopElemType = groupDefTopElem.getTagName();
        if (!groupTopElemType.equals("xs:sequence") && !groupTopElemType.equals("xs:choice")) {
            throw new RuntimeException(
                "group " + groupName + " has unexpected top-element: " + groupTopElemType);
        }
        extractMembers(groupDefTopElem, members);
    }

    private void patchCompositeMember(OnixCompositeMember onixCompositeMember) {
        // in Onix's <AudienceRange> there are two members <AudienceRangePrecision> and <AudienceRangeValue>
        // with a very unique cardinality - they can appear once, twice or not at all. the XSD doesn't reflect that
        if (onixCompositeMember.className.equals("AudienceRangePrecision")
            || onixCompositeMember.className.equals("AudienceRangeValue")
            || onixCompositeMember.className.equals("b075") || onixCompositeMember.className.equals("b076")) {
            onixCompositeMember.cardinality = Cardinality.ZeroOrMore;
        }
    }

    private void extractAttributes(Element attributesParentElem, final OnixClass onixClass) {
        final ElementListener attributeWorker = attributeElem -> extractAttribute(attributeElem, onixClass);

        DOM.forElementsOf(attributesParentElem, "xs:attribute", attributeWorker);

        DOM.forElementsOf(attributesParentElem, "xs:attributeGroup", attributeGroupRefElem -> {
            final String ref = attributeGroupRefElem.getAttribute("ref");
            if (ref.isEmpty()) {
                throw new RuntimeException("xs:attributeGroup is specified without ref");
            }
            final Element attributeGroupElem = context.attributeGroupNodes.get(ref);
            if (attributeGroupElem == null) {
                throw new RuntimeException("no definition found for xs:attributeGroup ref=" + ref);
            }

            DOM.forElementsOf(attributeGroupElem, "xs:attribute", attributeWorker);
        });
    }

    private void extractAttribute(Element attributeElem, final OnixClass onixClass) {
        final String name = attributeElem.getAttribute("name");
        final String fixed = attributeElem.getAttribute("fixed");

        // case 1 - simplest possible const (using 'fixed')
        if (!fixed.isEmpty()) {
            onixClass.add(OnixConst.create(name, fixed));
            return;
        }

        // case 2 - nested const (using internal 'xs:enumeration')
        final Element simpleTypeElement = DOM.firstElemChild(attributeElem, "xs:simpleType");
        if (simpleTypeElement != null) {
            final Element restrictionElem = DOM.firstElemChild(simpleTypeElement, "xs:restriction");
            if (restrictionElem == null) {
                throw new RuntimeException();
            }

            final String base = restrictionElem.getAttribute("base");
            if (Primitive.fromXsdToken(base) != Primitive.String) {
                throw new RuntimeException();
            }

            final Element enumerationElem = DOM.firstElemChild(restrictionElem, "xs:enumeration");
            if (enumerationElem == null) {
                throw new RuntimeException();
            }

            final String value = enumerationElem.getAttribute("value");

            if (name.isEmpty() || value.isEmpty()) {
                throw new RuntimeException("Empty const attribute");
            }

            onixClass.add(OnixConst.create(name, value));
            return;
        }

        // case 3 - a true attribute
        final String baseType = attributeElem.hasAttribute("type") ? attributeElem.getAttribute("type") : "xs:string";
        final Primitive primitiveType = Primitive.fromXsdToken(baseType);
        if (primitiveType == null) {
            final OnixSimpleType simpleType = meta.typeByName(baseType);
            if (simpleType == null) {
                throw new RuntimeException("Couldn't find type " + baseType);
            }
            onixClass.add(OnixAttribute.create(name, simpleType));
        } else {
            onixClass.add(OnixAttribute.create(name, primitiveType));
        }
    }

    public void postAnalysis(String specHtml) {
        // we're traversing all composites, looking for those that are data-composites, i.e. that contain ONLY elements
        // and/or flags
        for (OnixCompositeDef composite : meta.getComposites()) {
            boolean isDataComposite = true;
            OnixStruct struct = new OnixStruct(composite);
            for (OnixCompositeMember member : composite.members) {
                member.onixClass = meta.classByName(member.className);
                if (member.onixClass == null) {
                    throw new NullPointerException("class " + member.className + " referenced by " + composite.name
                        + " wasn't found");
                }

                if (member.onixClass instanceof OnixElementDef) {
                    OnixSimpleType simpleType = ((OnixElementDef) member.onixClass).valueMember.simpleType;

                    boolean isKey = false;
                    if (simpleType.isEnum() && (member.cardinality == Cardinality.Required)) {
                        if (simpleType.enumName.endsWith("Types") || simpleType.enumName.endsWith("Roles")) {
                            if (struct.keyMember == null) {
                                // in rare-cases (e.g. OtherText) where there are several candidates we take the first
                                isKey = true;
                            }
                        }
                    }
                    if (isKey) {
                        struct.keyMember = new OnixStructMember(member);
                    } else {
                        struct.members.add(new OnixStructMember(member));
                    }
                } else if (member.onixClass instanceof OnixFlagDef) {
                    struct.members.add(new OnixStructMember(member));
                } else {
                    isDataComposite = false;
                    break;
                }
            }

            if (isDataComposite) {
                if (struct.members.size() == 0) {
                    throw new RuntimeException("Struct with no members - " + struct.containingComposite.name);
                }
                meta.jonixStructs.put(composite.name, struct);
            }
        }

        // attach documentation
        if (!meta.isShort) {
            try {
                for (OnixDoc onixDoc : OnixDocsParser.parse(specHtml)) {
                    OnixClass onixClass = meta.classByName(onixDoc.onixClassName);
                    if (onixClass == null) {
                        LOGGER.warn("No class for onixDoc: '{}'", onixDoc.onixClassName);
                    } else {
                        onixClass.onixDoc = onixDoc;
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
