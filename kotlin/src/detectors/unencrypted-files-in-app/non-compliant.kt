/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=missing-encryption-of-sensitive-data@v1.0 defects=1}
// Noncompliant: Unencrypted file has been detected
fun noncompliant(password: String): String {
    val targetFile = File(activity.filesDir, "data.txt")
    targetFile.writeText(fileContent)  // Sensitive
}
// {/fact}
