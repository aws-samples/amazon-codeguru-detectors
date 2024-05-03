using System.Net;

namespace Credentials
{
    class HardcodedCredentials
    {
        // {fact rule=hardcoded-credentials@v1.0 defects=1}
        public void HardcodedCredentialsNoncompliant()
        {
            string data;
            data = "7e5tc4s3";
            if (data != null)
            {
                // Noncompliant: Hardcoded data used as password in `NetworkCredential()`.
                NetworkCredential credentials = new NetworkCredential("user", data, "domain");
                Console.WriteLine(credentials.ToString());
            }
        }
        // {/fact}
        
        // {fact rule=hardcoded-credentials@v1.0 defects=0}
        public void HardcodedCredentialsCompliant()
        {
            string data;
            data = "";
            // Compliant: Read data from the console using `ReadLine()` used it in `NetworkCredential()`.
            try
            {
                data = Console.ReadLine();
            }
            catch (IOException exceptIO)
            {
                Console.WriteLine($"Error with stream reading {exceptIO}");
            }
            if (data != null)
            {
                NetworkCredential credentials = new NetworkCredential("user", data, "domain");
                Console.WriteLine(credentials.ToString());
            }
        }
        // {/fact}
    }
}

