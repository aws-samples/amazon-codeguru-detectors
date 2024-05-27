/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import org.owasp.encoder.Encode
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException

class CrossSiteScriptingCompliant {

    // {fact rule=cross-site-scripting@v1.0 defects=0}
    @throws[ServletException]
    @throws[IOException]
    protected def compliant(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
        val input = req.getParameter("input")
        val map = req.getParameterMap
        val vals = req.getParameterValues("input2")
        val names = req.getParameterNames
        val contentType = req.getContentType
        val serverName = req.getServerName
        // Compliant: Unsanitized input is encoded.
        resp.getWriter.write(Encode.forHtml(input))
    }
    // {/fact}

}