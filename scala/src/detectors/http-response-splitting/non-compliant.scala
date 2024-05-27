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


class HttpResponseSplittingNoncompliant extends HttpServlet {

    // {fact rule=http-response-splitting@v1.0 defects=1}
    @throws[ServletException]
    @throws[IOException]
    override protected def nonCompliant(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
        val input = req.getParameter("input")
        val c = new Cookie("name", null)
        // Noncompliant: The cookie value is set to the unsanitized input parameter.
        c.setValue(input)
        c.setHttpOnly(true)
        c.setSecure(true)
        resp.addCookie(c)
    }
    // {/fact}
}