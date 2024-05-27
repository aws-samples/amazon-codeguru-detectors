/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


// {fact rule=open-redirect@v1.0 defects=0}
class OpenRedirectCompliant extends HttpServlet {
    def compliant(resp: HttpServletResponse): Unit = {
    // Compliant: User input is not used to set `Location` in `HttpHeader`.
    resp.addHeader("Location", "/login.jsp")
  }
}
// {/fact}