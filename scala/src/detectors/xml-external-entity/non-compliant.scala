/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


// {fact rule=xml-external-entity@v1.0 defects=1}
class XmlExternalEntityNoncompliant {

  def nonCompliant(file: File) = {
    // Noncompliant: XML parsing is not performed with appropriate configurations to disable external entity resolution.
    val docBuilderFactory = DocumentBuilderFactory.newInstance()
    val docBuilder = docBuilderFactory.newDocumentBuilder()
    val doc = docBuilder.parse(file)
    doc.getDocumentElement().normalize()
    val foobarList = doc.getElementsByTagName("Foobar")
    foobarList
  }
}
// {/fact}
