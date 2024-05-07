using System.Net.Security;
using System.Security.Cryptography.Xml;

namespace SensitiveInformation
{
    class SensitiveInformationLeak
    {
        // {fact rule=sensitive-information-leak@v1.0 defects=1}
        public void SensitiveInformationLeakNoncompliant()
        {
            string url = "http://api.example.com";
            string apiKey = "YOUR_API_KEY";
            using (HttpClient client = new HttpClient())
            {
                // Noncompliant: Send sensitive data over HTTP connection
                HttpResponseMessage response = client.GetAsync(url + "?api_key=" + apiKey).Result;
            }
        }
        // {/fact}
        
        // {fact rule=sensitive-information-leak@v1.0 defects=0}
        public void SensitiveInformationLeakCompliant()
        {
            string url = "http://api.example.com";
            string apiKey = "YOUR_API_KEY";
            using (HttpClient client = new HttpClient())
            {
                // Noncompliant: Do not send sensitive data over HTTP connection
                HttpResponseMessage response = client.GetAsync(url).Result;
            }
        }
        // {/fact}
    }
}

