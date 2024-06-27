/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=reusing-nonce-key-in-encryption@v1.0 defects=1}
// Noncompliant: GCM Cipher with reused initialization vector `theInnerIV2` is detected.
fun noncompliant(clearText: String): String {
    val cipher1: Cipher = Cipher.getInstance("AES/GCM/NoPadding")
    val cipher2: Cipher = Cipher.getInstance("AES/GCM/NoPadding")
    val keySpec: SecretKeySpec = SecretKeySpec(theKey.getEncoded(), "AES")

    private val theInnerIV2: Array<Byte>

    val gcmParameterSpec: GCMParameterSpec = GCMParameterSpec(GCM_TAG_LENGTH * 8, theInnerIV2)
    cipher1.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec)
    val gcmParameterSpec: GCMParameterSpec = GCMParameterSpec(GCM_TAG_LENGTH * 8, theInnerIV2)
    cipher2.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec)

    val decoded: Array<Byte> = Base64.getDecoder().decode(cipherText)
    val decryptedText: Array<Byte> = cipher.doFinal(decoded)
    return String(decryptedText)
}
// {/fact}
