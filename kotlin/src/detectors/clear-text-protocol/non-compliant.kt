/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-connection@v1.0 defects=1}
// Noncompliant: Using clear-text protocols such as `ftp` which is insecure
fun noncompliant() {
    val ftpClient = FTPClient(); // Sensitive
}
// {/fact}
