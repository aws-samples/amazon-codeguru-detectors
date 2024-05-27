/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.security.NoSuchProviderException


object InsecureCryptographyCompliant {
    // {fact rule=insecure-cryptography@v1.0 defects=0}
    @throws[NoSuchProviderException]
    @throws[NoSuchAlgorithmException]
    def compliant(): Unit = {
        // Compliant: Used secure message digest algorithms.
        MessageDigest.getInstance("sha-384", "SUN")
    }
    // {/fact}
}
