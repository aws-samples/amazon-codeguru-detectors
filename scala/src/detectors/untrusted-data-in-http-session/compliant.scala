/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


// {fact rule=untrusted-data-in-http-session@v1.0 defects=0}
class UntrustedDataInHttpSessionCompliant {
    
    def compliant(req: HttpServletRequest, input: String): Unit = {
        if ("enable".equals(input)) req.getSession.setAttribute("user", "true")
        // Compliant: Unsanitized user input is not used inside `setAttribute` method.
        else req.getSession.setAttribute("user", "false")
  }
}
// {/fact}