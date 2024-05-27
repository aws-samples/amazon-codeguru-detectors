/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


import javax.servlet.ServletException
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException


class HttpResponseSplittingCompliant extends HttpServlet {

    // {fact rule=http-response-splitting@v1.0 defects=0}
    @throws[ServletException]
    @throws[IOException]
    override protected def compliant(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
        val input = req.getParameter("input")
        val sanitized = org.apache.commons.text.StringEscapeUtils.unescapeJava(input)
        // Compliant: The cookie value is set to the sanitized input parameter.
        resp.setHeader("test3", sanitized)
    }
    // {/fact}
}