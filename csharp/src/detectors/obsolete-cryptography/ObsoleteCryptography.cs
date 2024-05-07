using System.Security.Cryptography.X509Certificates;

namespace Cryptography
{
    class ObsoleteCryptography
    {
        // {fact rule=obsolete-cryptography@v1.0 defects=1}
        public void ObsoleteCryptographyNoncompliant()
        {
            X509Certificate2 certificate = new X509Certificate2();
            // Noncompliant: `X509Certificate2.PrivateKey` is obsolete.
            var privatekey = certificate.PrivateKey;
        }
        // {/fact}
        
        // {fact rule=obsolete-cryptography@v1.0 defects=0}
        public void ObsoleteCryptographyCompliant()
        {
            X509Certificate2 certificate = new X509Certificate2();
            // Compliant: `X509Certificate2.GetRSAPrivateKey()` is safe.
            var privatekey = certificate.GetRSAPrivateKey();
        }
        // {/fact}
    }
}
