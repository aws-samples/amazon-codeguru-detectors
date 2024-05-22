/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-hashing@v1.0 defects=0}
// Compliant: Using secure hashing algorithm
fun compliant(password: String): ByteArray {
    val shaDigest: MessageDigest = MessageDigest.getInstance("SHA-256")
    shaDigest.update(password.getBytes())
    val hashValue: ByteArray = shaDigest.digest()
    return hashValue
}
// {/fact}
