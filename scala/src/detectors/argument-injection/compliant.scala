/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import org.apache.http.client.methods.HttpGet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.net.URLEncoder


class ArgumentInjectionCompliant extends HttpServlet {
    // {fact rule=argument-injection@v1.0 defects=0}
    override def complaint(request: HttpServletRequest, response: HttpServletResponse): Unit = {
        try {
        val item = request.getParameter("item")

        // Compliant: `URLEncoder.encode` is used to encode user input.
        val httpget2 = new HttpGet("http://host.com?param=" + URLEncoder.encode(item))
        }
    }
    // {/fact}
}