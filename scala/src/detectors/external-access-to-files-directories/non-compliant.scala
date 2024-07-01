/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import java.io.IOException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ExternalAccessToFilesDirectoriesNoncompliant extends HttpServlet {
 
    // {fact rule=external-access-to-files-directories@v1.0 defects=1}
    @throws[IOException]
    def nonComplaint(request: HttpServletRequest, response: HttpServletResponse): Unit = {
        try {
        val jspFile = request.getParameter("jspFile")
        var requestDispatcher = request.getRequestDispatcher(jspFile)
        // Noncompliant: Granting access to file to unauthorized users.
        requestDispatcher.include(request, response)
        requestDispatcher = request.getSession.getServletContext.getRequestDispatcher(jspFile)
        
        } catch {
        case e: Exception =>
            System.out.println(e)
        }
    }
    // {/fact}
}