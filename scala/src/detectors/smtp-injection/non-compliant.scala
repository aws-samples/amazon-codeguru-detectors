/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


import javax.activation.FileDataSource
import javax.mail._
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage
import javax.servlet.http.HttpServletRequest
import java.net.URLEncoder
import java.util.Properties

object SmtpInjectionNoncompliant {
  @throws[Exception]
    // {fact rule=smtp-injection@v1.0 defects=1}
    def nonCompliant(req: HttpServletRequest, session: Session): Unit = {
        val message = new MimeMessage(session)
        // Noncompliant: 'subject' is constructed without proper validation or sanitation of input.
        message.setSubject(req.getParameter("subject")) // Potential injection
    }
    // {/fact}
}