using System.Xml;

namespace XXEInjection
{
    class XmlExternalEntity
    {
        // {fact rule=xml-external-entity@v1.0 defects=1}
        public void XmlExternalEntityNoncompliant(string str)
        {
            XmlReaderSettings readersetting = new XmlReaderSettings();
            // Noncompliant: `DtdProcessing.Parse` enables DTD processing.
            readersetting.DtdProcessing = DtdProcessing.Parse;
            XmlReader reader = XmlReader.Create(new StringReader(str),readersetting);
            
            while (reader.Read())
            {
                Console.WriteLine(reader.Value);
            }
            Console.ReadLine();
        }
        // {/fact}
        
        // {fact rule=xml-external-entity@v1.0 defects=0}
        public void XmlExternalEntityCompliant(string str)
        {
            XmlReaderSettings readersetting = new XmlReaderSettings();
            // Compliant: `DtdProcessing.Ignore` disables DTD processing without warnings or exceptions.
            readersetting.DtdProcessing = DtdProcessing.Ignore;
            XmlReader reader = XmlReader.Create(new StringReader(str),readersetting);
            
            while (reader.Read())
            {
                Console.WriteLine(reader.Value);
            }
            Console.ReadLine();
        }
        // {/fact}
    }
}

