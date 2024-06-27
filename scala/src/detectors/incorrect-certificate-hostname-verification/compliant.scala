/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import org.apache.commons.mail.SimpleEmail

object IncorrectCertificateHostnameVerificationCompliant {
    // {fact rule=incorrect-certificate-hostname-verification@v1.0 defects=0}
    @throws[Exception]
    def compliant(): Unit = {
        val email = new SimpleEmail
        email.setHostName("smtp.googlemail.com")
        // Compliant: SSL is not enabled without server identity check.
        email.setSSLOnConnect(false)
    }
    // {/fact}
}