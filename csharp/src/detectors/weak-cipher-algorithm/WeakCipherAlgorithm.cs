using System.Security.Cryptography;
	 
	 class WeakCipherAlgorithm
	 {


        // {fact rule=impropercryptographicsignatureverification@v1.0 defects=1}
	     static void DES()
	     {
	         // Noncompliant: insecure cryptographic algorithms used
	         DES provider = System.Security.Cryptography.DES.Create();
         }
        // {/fact}

        // {fact rule=impropercryptographicsignatureverification@v1.0 defects=0}
	     public void CreateAes1() {
	 		// Compliant: secure cryptographic algorithms used
	 		var key = Aes.Create();
	 	}
        // {/fact}
	 }