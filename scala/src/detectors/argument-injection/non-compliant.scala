/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import org.apache.http.client.methods.HttpGet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class ArgumentInjectionNoncompliant extends HttpServlet {
    // {fact rule=argument-injection@v1.0 defects=1}
    override def nonComplaint(request: HttpServletRequest, response: HttpServletResponse): Unit = {
        try {
        val item = request.getParameter("item")

        // Noncompliant: Unsanitized input is used in the URL.
        val httpget2 = new HttpGet("http://host.com?param=" + item)
        }
    }
    // {/fact}
}