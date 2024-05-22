/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-socket@v1.0 defects=1}
// Noncompliant: Unencrypted sockets are used
fun noncompliant() {
    // Prefer sockets from the SSLSocketFactory as they are encrypted
    val soc: Socket = Socket("www.google.com", 80)
    doGetRequest(soc)
}
// {/fact}
