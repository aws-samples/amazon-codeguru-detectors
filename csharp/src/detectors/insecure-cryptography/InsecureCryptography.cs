using System;
using System.Security.Cryptography;

namespace Cryptography
{
    class InsecureCryptography
    {
        // {fact rule=insecure-cryptography@v1.0 defects=1}
        public void InsecureCryptographyNoncompliant()
        {
            Aes aeskey = Aes.Create();
            // Noncompliant: `ECB` is insecure encryption mode.
            aeskey.Mode = CipherMode.ECB;
            using var encryptor = aeskey.CreateEncryptor();
            byte[] msg = new byte[32];
            var cipherText = encryptor.TransformFinalBlock(msg, 0, msg.Length);
        }
        // {/fact}
        
        // {fact rule=insecure-cryptography@v1.0 defects=0}
        public void InsecureCryptographyCompliant()
        {
            Aes aeskey = Aes.Create();
            // Compliant: `CBC` is secure encryption mode.
            aeskey.Mode = CipherMode.CBC;
            using var encryptor = aeskey.CreateEncryptor();
            byte[] msg = new byte[32];
            var cipherText = encryptor.TransformFinalBlock(msg, 0, msg.Length);
        }
        // {/fact}
    }
}
