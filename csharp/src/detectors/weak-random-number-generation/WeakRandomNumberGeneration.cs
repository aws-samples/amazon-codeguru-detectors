using System.Security.Cryptography;

namespace Cryptography
{
    class WeakRandomNumberGeneration
    {
        // {fact rule=weak-random-number-generation@v1.0 defects=1}
        public void WeakRandomNumberGenerationNoncompliant()
        {
            var randomnumber = new System.Random();
            byte[] key = new byte[16];
            randomnumber.NextBytes(key);
            // Noncompliant: An insecure random number generator (RNG) is used to create cryptographic key.
            var c = new AesGcm(key);
        }
        // {/fact}
        
        // {fact rule=weak-random-number-generation@v1.0 defects=0}
        public void WeakRandomNumberGenerationCompliant()
        {
            var randomnumber = System.Security.Cryptography.RandomNumberGenerator.Create();
            byte[] key = new byte[16];
            randomnumber.GetBytes(key);
            // Compliant: Secure random number generator (RNG) is used to create cryptographic key.
            var c = new AesGcm(key);
        }
        // {/fact}
    }
}
