/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=incorrect-type-conversion@v1.0 defects=0}
// Compliant: Using `String.format(\"%02X\",...)` which does not creates a weak hash
fun compliant(password: String): String {
    val md: MessageDigest = MessageDigest.getInstance("SHA-1")
    val resultBytes: Array<Byte> = md.digest(password.getBytes("UTF-8"))

    var stringBuilder: StringBuilder = StringBuilder()
    for (b in resultBytes) {
        stringBuilder.append(String.format("%02X", b))
    }

    return stringBuilder.toString()
}
// {/fact}
