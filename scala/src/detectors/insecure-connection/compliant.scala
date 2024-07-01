/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import javax.net.ssl.SSLServerSocketFactory

object InsecureConnectionCompliant {
    // {fact rule=insecure-connection@v1.0 defects=0}
    @throws[IOException]
    private[this] def compliant(): Unit = {
        // Compliant: The connection is secure.
        val soc = SSLSocketFactory.getDefault.createSocket("www.google.com", 443)
        doGetRequest(soc)
    }
    // {/fact}
}