package main

import (
	"fmt"
	"github.com/lestrrat-go/libxml2/parser"
)

// {fact rule=xml-external-entity@v1.0 defects=1}
func xmlExternalEntityNoncompliant() {
	const xmlData = "<!DOCTYPE d [<!ENTITY e SYSTEM \"file:///etc/passwd\">]><t>&e;</t>"
	// Noncompliant: `XMLParseNoEnt` is enabled.
	xmlParser := parser.New(parser.XMLParseNoEnt)
	parsedDoc, err := xmlParser.ParseString(xmlData)
	if err != nil {
		fmt.Println(err)
		return
	}
	fmt.Println("XML document successfully parsed!")
	fmt.Println(parsedDoc)
}
// {/fact}

// {fact rule=xml-external-entity@v1.0 defects=0}
func xmlExternalEntityCompliant() {
	const xmlData = "<!DOCTYPE d [<!ENTITY e SYSTEM \"file:///etc/passwd\">]><t>&e;</t>"
	// Compliant: `XMLParseNoEnt` is not enabled.
	xmlParser := parser.New()
	parsedDoc, err := xmlParser.ParseString(xmlData)
	if err != nil {
		fmt.Println(err)
		return
	}
	fmt.Println("XML document successfully parsed!")
	fmt.Println(parsedDoc)
}
// {/fact}
