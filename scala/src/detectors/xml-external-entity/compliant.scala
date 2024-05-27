/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


// {fact rule=xml-external-entity@v1.0 defects=0}
class XmlExternalEntityCompliant {

    def compliant(file: File) = {
        // Compliant: External entitites are disabled when parsing the XML file.
        val docBuilderFactory = DocumentBuilderFactory.newInstance()
        val docBuilder = docBuilderFactory.newDocumentBuilder()
        docBuilder.setXIncludeAware(true)
        docBuilder.setNamespaceAware(true)

        docBuilder.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true)
        docBuilder.setFeature("http://xml.org/sax/features/external-general-entities", false)
        docBuilder.setFeature("http://xml.org/sax/features/external-parameter-entities", false)

        val doc = docBuilder.parse(file)
        doc.getDocumentElement().normalize()
        val foobarList = doc.getElementsByTagName("Foobar")
        foobarList
    }
}
// {/fact}