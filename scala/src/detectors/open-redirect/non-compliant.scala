/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


// {fact rule=open-redirect@v1.0 defects=1}
class OpenRedirectNoncompliant extends HttpServlet {
    def nonCompliant(resp: HttpServletResponse, url: String): Unit = {
    // Noncompliant: Untrusted user input used in `resp.addHeader`.
    if (url != null)  resp.addHeader("Location", url)    
  }
}
// {/fact}