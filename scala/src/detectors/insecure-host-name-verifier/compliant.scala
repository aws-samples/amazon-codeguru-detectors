/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import java.security.NoSuchAlgorithmException
import javax.net.ssl.SSLContext
import java.lang.reflect.Array


object InsecureHostNameVerifierCompliant {
    // {fact rule=insecure-host-name-verifier@v1.0 defects=0}
    def compliant(args: Array): Unit = {
        try {
            // Compliant: Use secure TLS protocol.
            val context1 = SSLContext.getInstance("TLS")
        } catch {
            case e: NoSuchAlgorithmException =>
            e.printStackTrace
        }
    }
    // {/fact}
}
