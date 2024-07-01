/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

// {fact rule=path-traversal@v1.0 defects=1}
class PathTraversalNoncompliant {
    
    @throws[FileUploadException]
    override protected def doGet_compliant(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
        val input = req.getParameter("input")
        
        // Noncompliant: Utilizes an unsanitized HTTP request parameter to form a file path.
        val file = new File(input, "abs/path")
    }
}
// {/fact}