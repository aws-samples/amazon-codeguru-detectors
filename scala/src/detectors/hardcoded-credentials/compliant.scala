/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import java.security.KeyStore

class HardcodedCredentialsCompliant {
  
    // {fact rule=hardcoded-credentials@v1.0 defects=0}
    @throws[Exception]
    def compliant(): Unit = {
        val passphrase = "secret".toCharArray
        val ks = KeyStore.getInstance("JKS")
        // Compliant: Hardcoded password is not used to load the keystore.
        ks.load(new FileInputStream("keystore"), PasswordCommon.getPassword)
    }
    // {/fact}
}