/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.IOException

class CrossSiteScriptingNoncompliant {

    // {fact rule=cross-site-scripting@v1.0 defects=1}
    @throws[ServletException]
    @throws[IOException]
    protected def nonCompliant(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
        val input = req.getParameter("input")
        val map = req.getParameterMap
        val vals = req.getParameterValues("input2")
        val names = req.getParameterNames
        val contentType = req.getContentType
        val serverName = req.getServerName
        // Noncompliant: Server response uses potentially unsanitized data.
        resp.getWriter.write(input)
    }
    // {/fact}

}