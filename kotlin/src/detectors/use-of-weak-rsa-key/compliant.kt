/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=cryptographic-key-generator@v1.0 defects=0}
// Compliant: The key 2048 is secure key length.
fun compliant() {
    val keyGen = KeyPairGenerator.getInstance("RSA")
    keyGen.initialize(2048);
}
// {/fact}
