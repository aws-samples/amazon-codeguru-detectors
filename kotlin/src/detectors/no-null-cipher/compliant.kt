/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-hashing@v1.0 defects=0}
// Compliant: Avoided use of `NullCipher` while encrypting value
fun compliant(plainText: String): Void {
    val cipher: Cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
    val cipherText: Array<Byte> = cipher.doFinal(plainText)
    return cipherText
}
// {/fact}
