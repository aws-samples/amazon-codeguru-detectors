/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import java.util.Formatter
import java.util.Locale
import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServlet

class ExternallyControlledFormatStringNoncompliant extends HttpServlet {

    // {fact rule=externally-controlled-format-string@v1.0 defects=1}
    @throws[IOException]
    override def nonCompliant(request: HttpServletRequest, response: HttpServletResponse): Unit = { // create a new formatter
        val buffer = new StringBuffer()
        val formatter = new Formatter(buffer, Locale.US)
        val input = request.getParameter("suffix")

        // Noncompliant: Unsanitized input is concatenated to the format string.
        val format = "The customer: %s %s" + input
    }
    // {/fact}
}
