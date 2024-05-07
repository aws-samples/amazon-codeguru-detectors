// {fact rule=xml-external-entity@v1.0 defects=1}
import libxmljs from "libxmljs"
import fs from 'fs'

function xmlExternalEntityNoncompliant() {
    const xml = fs.readFileSync("foo.xml")
    // Noncompliant: sets `noent` to true which enables the parsing of external entities.
    const xmlDoc = libxmljs.parseXml(xml, { noent: true, noblanks: true })
}
// {/fact}


// {fact rule=xml-external-entity@v1.0 defects=0}
import libxmljs from "libxmljs"
import fs from 'fs'

function xmlExternalEntityCompliant() {
    const xml = fs.readFileSync("foo.xml")
    // Compliant: parsing of external entities is disabled by default.
    const xmlDoc = libxmljs.parseXml(xml, { noblanks: true })
}
// {/fact}
