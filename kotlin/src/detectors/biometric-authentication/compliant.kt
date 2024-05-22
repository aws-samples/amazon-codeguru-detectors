/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=improper-authentication@v1.0 defects=0}
// Compliant: Used the cryptographic operation with biometric authentication by using a CryptoObject
fun compliant() {
   val biometricPrompt: BiometricPrompt = BiometricPrompt(this, executor, callback)
    val cipher = getCipher()
    val secretKey = getSecretKey()
    cipher.init(Cipher.ENCRYPT_MODE, secretKey)
    biometricPrompt.authenticate(promptInfo,
    BiometricPrompt.CryptoObject(cipher))
}
// {/fact}
