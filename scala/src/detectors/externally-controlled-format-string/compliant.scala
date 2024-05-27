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

class ExternallyControlledFormatStringCompliant extends HttpServlet {

    // {fact rule=externally-controlled-format-string@v1.0 defects=0}
    @throws[IOException]
    override def compliant(request: HttpServletRequest, response: HttpServletResponse): Unit = { // create a new formatter
        val buffer = new StringBuffer()
        val formatter = new Formatter(buffer, Locale.US)
        val input = request.getParameter("suffix")

        // Compliant: Unsanitized input is not concatenated to the format string.
        val format = "The customer: %s %s"
        formatter.format(format, "John", "Smith")
    }
    // {/fact}
}
