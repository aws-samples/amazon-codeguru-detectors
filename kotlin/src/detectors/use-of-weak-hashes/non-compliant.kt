/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-hashing@v1.0 defects=1}
// Noncompliant: Using weak hashing algorithm which is insecure
fun noncompliant(password: String): ByteArray {
    val md5Digest: MessageDigest = MessageDigest.getInstance("MD5")
    md5Digest.update(password.getBytes())
    val hashValue: ByteArray = md5Digest.digest()
    return hashValue
}
// {/fact}
