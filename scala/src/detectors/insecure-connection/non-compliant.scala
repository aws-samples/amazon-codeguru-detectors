/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import java.net.Socket

object InsecureConnectionNoncompliant {
    // {fact rule=insecure-connection@v1.0 defects=1}
    @throws[IOException]
    private[this] def nonCompliant(): Unit = {
        // Noncompliant: The connection is not secure.
        val soc = new Socket("www.google.com", 80)
        doGetRequest(soc)
    }
    // {/fact}
}