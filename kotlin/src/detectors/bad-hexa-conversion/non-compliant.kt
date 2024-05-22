/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=incorrect-type-conversion@v1.0 defects=1}
// Noncompliant: Using `Integer.toHexString()` which creates weak hash
fun noncompliant(password: String): String {
    val md: MessageDigest = MessageDigest.getInstance("SHA-1")
    val resultBytes: Array<Byte> = md.digest(password.getBytes("UTF-8"))

    var stringBuilder: StringBuilder = StringBuilder()
    for (b in resultBytes) {
        stringBuilder.append(Integer.toHexString(b and 0xFF))
    }

    return stringBuilder.toString()
}
// {/fact}
