/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


// {fact rule=open-redirect@v1.0 defects=1}
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class OpenRedirectNoncompliant extends HttpServlet {
    def nonCompliant(req: HttpServletRequest, res: HttpServletResponse): Unit = {
      val forwardedUrl = req.getHeader("Forwarded")
      if (forwardedUrl != null && !forwardedUrl.isEmpty) {
        // Noncompliant: Using user-controlled input in the Forwarded header for redirection
        res.sendRedirect(forwardedUrl)
      }
    }
}
// {/fact}