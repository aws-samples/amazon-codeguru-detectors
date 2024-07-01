/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import java.security.NoSuchAlgorithmException
import javax.net.ssl.SSLContext
import java.lang.reflect.Array


object InsecureHostNameVerifierNoncompliant {
    // {fact rule=insecure-host-name-verifier@v1.0 defects=1}
    def nonCompliant(args: Array): Unit = {
        try {
            // Noncompliant: Use of deprecated `DefaultHttpClient` or `SSL` protocol may expose the application to known vulnerabilities and insecure communication.
            val context1 = SSLContext.getInstance("SSL")
        } catch {
            case e: NoSuchAlgorithmException =>
            e.printStackTrace
        }
    }
    // {/fact}
}
