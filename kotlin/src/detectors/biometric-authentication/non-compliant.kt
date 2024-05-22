/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=improper-authentication@v1.0 defects=1}
// Noncompliant: Not used the cryptographic operation with biometric authentication.
fun noncompliant() {
    val biometricPrompt: BiometricPrompt = BiometricPrompt(this, executor, callback)    
    biometricPrompt.authenticate(promptInfo)
}
// {/fact}
