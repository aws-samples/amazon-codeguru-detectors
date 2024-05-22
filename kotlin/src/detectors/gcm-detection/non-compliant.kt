/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=reusing-nonce-key-in-encryption@v1.0 defects=1}
// Noncompliant: GCM Cipher with reused initialization vector is detected
fun noncompliant(clearText: String): String {
    val cipher: Cipher = Cipher.getInstance("AES/GCM/NoPadding")
    val keySpec: SecretKeySpec= SecretKeySpec(theKey.getEncoded(), "AES")
    val theBadIV: Array<Byte> = BAD_IV.getBytes()

    val gcmParameterSpec: GCMParameterSpec = GCMParameterSpec(GCM_TAG_LENGTH * 8, theIV)
    cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec)

    val cipherText: Array<Byte> = cipher.doFinal(clearText.getBytes())

    val encoded = base64.getEncoder().encodeToString(cipherText)
    return encoded
}
// {/fact}
