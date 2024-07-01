/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


// {fact rule=path-traversal@v1.0 defects=0}
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class PathTraversalCompliant {
  
  @throws[FileUploadException]
  override protected def doGet_compliant(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    val input = req.getParameter("input")
    val baseDir = "/some/fixed/base/directory"
    // Compliant: No HTTP request parameters are used to construct a file path.
    val file = new File(baseDir, "abs/path")
  }
}
// {/fact}