using System.Net.Http;

namespace SSRF
{
    class ServerSideRequestForgery
    {
        // {fact rule=server-side-request-forgery@v1.0 defects=1}
        public void ServerSideRequestForgeryNoncompliant(string hostname)
        {
            // Noncompliant: It is interacting with external network.
            Uri uri = new Uri(hostname);

            HttpClient client = new HttpClient();

            try
            {
                HttpResponseMessage res = client.GetAsync(uri).Result;
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e);
            }
        }
        // {/fact}
        
        // {fact rule=server-side-request-forgery@v1.0 defects=0}
        public void ServerSideRequestForgeryCompliant(string hostname)
        {
            // Compliant: It is passing raw string.
            Uri uri = new Uri("string");

            HttpClient client = new HttpClient();

            try
            {
                HttpResponseMessage res = client.GetAsync(uri).Result;
            }
            catch (Exception e)
            {
                System.Diagnostics.Debug.WriteLine(e);
            }
        }
        // {/fact}
    }
}