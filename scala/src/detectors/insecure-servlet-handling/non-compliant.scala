/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

class InsecureServletHandlingNoncompliant extends HttpServlet {

  @throws[ServletException]
  @throws[IOException]
  // {fact rule=insecure-servlet-handling@v1.0 defects=1}
  override protected def nonCompliant(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    useParameters(req)
    // Noncompliant: Unsanitized user input is used
    resp.getWriter.print("<!--" + req.getContentType + "-->")
    resp.getWriter.print("<!--" + req.getQueryString + "-->")
    val referrer = req.getHeader("Referer") //Should have a higher priority
    if (referrer != null && referrer.startsWith("http://company.ca")) {
      req.getHeader("Host")
      req.getHeader("User-Agent")
      req.getHeader("X-Requested-With")
    }
  }
  // {/fact}
}