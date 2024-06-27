/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


// {fact rule=untrusted-data-in-http-session@v1.0 defects=1}
class UntrustedDataInHttpSessionNoncompliant {
  
  def nonCompliant(req: HttpServletRequest): Unit = {
    val input = req.getParameter("input")
    // Noncompliant: Unsanitized user input is used inside `setAttribute` method.
    req.getSession.setAttribute(input, "true")
  }
}
// {/fact}