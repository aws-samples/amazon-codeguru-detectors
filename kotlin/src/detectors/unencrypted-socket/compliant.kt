/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-socket@v1.0 defects=0}
// Compliant: Encrypted sockets are used
fun compliant() {
    val soc:Socket = SSLSocketFactory.getDefault().createSocket("www.google.com", 443)
    doGetRequest(soc)
}
// {/fact}
