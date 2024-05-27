/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import java.io.IOException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExternalAccessToFilesDirectoriesCompliant extends HttpServlet {
 
    // {fact rule=external-access-to-files-directories@v1.0 defects=0}
    @throws[IOException]
    def complaint(request: HttpServletRequest, response: HttpServletResponse): Unit = {
        try {
        val jspFile = request.getParameter("jspFile")
        val sanitizedPath = sanitizePath(jspFile)
        var requestDispatcher = request.getRequestDispatcher(sanitizedPath)
        // Compliant: Sanitizing the file path before using it with the RequestDispatcher.
        requestDispatcher.include(request, response)
        requestDispatcher = request.getSession.getServletContext.getRequestDispatcher(sanitizedPath)
        
        } catch {
        case e: Exception =>
            System.out.println(e)
        }
    }
    // {/fact}
}