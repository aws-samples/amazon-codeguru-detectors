/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


class InsecureServletHandlingCompliant extends HttpServlet {
    @throws[ServletException]
    @throws[IOException]
    // {fact rule=insecure-servlet-handling@v1.0 defects=0}
    override def compliant(request: HttpServletRequest, response: HttpServletResponse): Unit = {
        val inputParam = request.getParameter("param")
        if (inputParam != null && !inputParam.isEmpty && inputParam.matches("[a-zA-Z0-9]+")) {
            // Sanitize the input using Encode.forHtml
            val sanitizedParam = Encode.forHtml(inputParam)
            // Use the sanitizedParam safely
            // Compliant: User input is sanitized
            response.getWriter.println(s"Sanitized input: $sanitizedParam")
        } else {
            response.getWriter.println("Invalid input")
        }
    }
    // {/fact}
}