/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletResponse

class InsecureCorsPolicyNoncompliant extends HttpServlet {
    // {fact rule=insecure-cors-policy@v1.0 defects=1}
    def nonCompliant(resp: HttpServletResponse): Unit = {
        // Noncompliant: Overly permissive Cross-domain requests accepted.
        resp.addHeader("Access-Control-Allow-Origin", "*")
    }
    // {/fact}
}