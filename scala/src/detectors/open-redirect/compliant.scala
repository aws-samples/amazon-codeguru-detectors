/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


// {fact rule=open-redirect@v1.0 defects=0}
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class OpenRedirectCompliant extends HttpServlet {
    def compliant(req: HttpServletRequest, res: HttpServletResponse): Unit = {
      val forwardedUrl = req.getHeader("Forwarded")
      if (forwardedUrl.getHost.contains("trusteddomain.com")) {
        // Compliant: The forwarded URL is validated before use.
        Redirect(validatedUrl)
      } else {
        BadRequest("Invalid URL")
      }
  }
}
// {/fact}