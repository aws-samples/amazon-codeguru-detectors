/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=cryptographic-key-generator@v1.0 defects=1}
// Noncompliant: The key 256 is not secure key length.
fun noncompliant() {
    val keyGen: KeyPairGenerator = KeyPairGenerator.getInstance("RSA")
    keyGen.initialize(256)
}
// {/fact}
