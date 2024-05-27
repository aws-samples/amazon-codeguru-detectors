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

object SmtpInjectionCompliant {
  @throws[Exception]
    // {fact rule=smtp-injection@v1.0 defects=0}
    def compliant(subject: String, header: String, session: Session): Unit = {
        val encodedHeader = URLEncoder.encode(header, "UTF-8")
        // Compliant: Encoder is used to encode the 'header', mitigating the risk of injection vulnerabilities.
        message.addHeader("X-Custom", encodedHeader)
    }
    // {/fact}
}