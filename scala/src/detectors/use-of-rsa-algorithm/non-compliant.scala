/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


import javax.crypto.Cipher

// {fact rule=use-of-rsa-algorithm@v1.0 defects=1}
class UseOfRSAAlgorithmNoncompliant {
    @throws[Exception]
    def nonCompliant(): Unit = {
        val cipher1 = null
        Cipher.getInstance(cipher1)
        val cipher2 = "RSA/NONE/NoPadding"
        // Noncompliant: Use of RSA Algorithm without OAEP.
        Cipher.getInstance(cipher2)
    }
}
// {/fact}