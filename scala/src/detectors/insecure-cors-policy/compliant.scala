/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletResponse

class InsecureCorsPolicyCompliant extends HttpServlet {
    // {fact rule=insecure-cors-policy@v1.0 defects=0}
    def compliant(resp: HttpServletResponse): Unit = {
        // Compliant: CORS policy is set to allow all origins.
        resp.addHeader("Access-Control-Allow-Origin", "http://example.com")
    }
    // {/fact}
}
