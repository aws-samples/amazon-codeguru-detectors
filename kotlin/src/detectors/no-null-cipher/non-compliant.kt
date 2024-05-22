/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-hashing@v1.0 defects=1}
// Noncompliant: Used `NullCipher`, which will not use any encryption.
fun noncompliant(plainText: String): Array<Byte> {
    val doNothingCipher: Cipher = NullCipher()
    val cipherText: Cipher = doNothingCihper.doFinal(plainText)
    return cipherText
}
// {/fact}
