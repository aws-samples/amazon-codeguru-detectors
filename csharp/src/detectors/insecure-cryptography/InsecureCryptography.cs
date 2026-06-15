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
            // Compliant: AES-GCM provides authenticated encryption.
            byte[] key = new byte[32];
            RandomNumberGenerator.Fill(key);
            byte[] nonce = new byte[AesGcm.NonceByteSizes.MaxSize];
            RandomNumberGenerator.Fill(nonce);
            byte[] msg = new byte[32];
            byte[] cipherText = new byte[msg.Length];
            byte[] tag = new byte[AesGcm.TagByteSizes.MaxSize];

            using var aesGcm = new AesGcm(key, AesGcm.TagByteSizes.MaxSize);
            aesGcm.Encrypt(nonce, msg, cipherText, tag);
        }
        // {/fact}
    }
}
