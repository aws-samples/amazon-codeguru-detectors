using System.Web;
using System.Web.Mvc;

class Xss {
    public class CrossSiteScripting : Controller
    {
        // {fact rule=cross-site-scripting@v1.0 defects=1}
        [HttpGet]
        public string Get(string untrusted)
        {
            // Noncompliant: Directly use untrusted data from input
            return "value " + untrusted;
        }
        // {/fact}

        // {fact rule=cross-site-scripting@v1.0 defects=0}
        [HttpPost]
        [ValidateAntiForgeryToken]
        public string Post(string untrusted)
        {
            // Compliant: Encode untrusted data before use
            return "value " + HttpUtility.HtmlEncode(untrusted);
        }
        // {/fact}
    }
}

