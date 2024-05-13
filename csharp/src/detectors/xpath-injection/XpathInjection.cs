using System;
using System.Web;
using System.Xml;
using System.Xml.Linq;
using System.Xml.Schema;
using System.Xml.XPath;
class XPathInjection
{
    // {fact rule=mass-assignment@v1.0 defects=1}
    public List<Knowledge> Search(string input)
    {
        List<Knowledge> searchResult = new List<Knowledge>();
        var webRoot = _env.WebRootPath;
        var file = System.IO.Path.Combine(webRoot,"Knowledgebase.xml");
        
        XmlDocument XmlDoc = new XmlDocument();
        XmlDoc.Load(file);    
        
        XPathNavigator nav = XmlDoc.CreateNavigator();
        // Noncompliant: Improper input validation and sanitization.
        XPathExpression expr = nav.Compile(@"//knowledge[tags[contains(text(),'" + input + "')] and sensitivity/text() ='Public']");
    }
    // {/fact}

    // {fact rule=mass-assignment@v1.0 defects=0}
    public List<Knowledge> Search(string input)
    {
        List<Knowledge> searchResult = new List<Knowledge>();
        var webRoot = _env.WebRootPath;
        var file = System.IO.Path.Combine(webRoot,"Knowledgebase.xml");
        
        XmlDocument XmlDoc = new XmlDocument();
        XmlDoc.Load(file);    
        
        XPathNavigator nav = XmlDoc.CreateNavigator();
        // Compliant:proper input validation and sanitization.
        XPathExpression expr = nav.Compile(@"//knowledge[tags[contains(text(),'keyword')] and sensitivity/text() ='Public']");
        
        var matchedNodes = nav.Select(expr);
    }
    // {/fact}
}