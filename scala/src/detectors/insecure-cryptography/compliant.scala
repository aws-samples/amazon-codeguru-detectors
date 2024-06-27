/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.security.NoSuchProviderException


object InsecureCryptographyCompliant {
    // {fact rule=insecure-cryptography@v1.0 defects=0}
    @throws[NoSuchAlgorithmException]
    @throws[NoSuchProviderException]
    def strongKeySizeWithProviderString = {
        val keyGen = KeyPairGenerator.getInstance("RSA", "BC")
        // Compliant:Key size is 2048 bits.
        keyGen.initialize(2048)
        keyGen.generateKeyPair
    }
    // {/fact}
}
