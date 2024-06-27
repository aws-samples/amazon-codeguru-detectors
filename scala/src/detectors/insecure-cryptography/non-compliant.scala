/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.security.NoSuchProviderException


object InsecureCryptographyNoncompliant {
    // {fact rule=insecure-cryptography@v1.0 defects=1}
    @throws[NoSuchAlgorithmException]
    @throws[NoSuchProviderException]
    def weakKeySizeWithProviderString = {
        val keyGen = KeyPairGenerator.getInstance("RSA", "BC")
        // Noncompliant: A small key size makes the ciphertext vulnerable to brute force attacks.
        keyGen.initialize(1024)
        keyGen.generateKeyPair
    }
    // {/fact}
}
