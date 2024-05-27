/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.security.NoSuchProviderException


object InsecureCryptographyNoncompliant {
    // {fact rule=insecure-cryptography@v1.0 defects=1}
    @throws[NoSuchProviderException]
    @throws[NoSuchAlgorithmException]
    def nonCompliant(): Unit = {
        // Noncompliant: Used insecure message digest algorithms.
        MessageDigest.getInstance("MD5", "SUN")
    }
    // {/fact}
}
