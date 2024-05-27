/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import java.security.KeyStore

class HardcodedCredentialsNoncompliant {
  
    // {fact rule=hardcoded-credentials@v1.0 defects=1}
    @throws[Exception]
    def nonCompliant(): Unit = {
        val passphrase = "secret".toCharArray
        val ks = KeyStore.getInstance("JKS")
        // Noncompliant: Hardcoded password is used to load the keystore.
        ks.load(new FileInputStream("keystore"), passphrase)
    }
    // {/fact}
}