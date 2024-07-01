/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


import org.apache.commons.mail.SimpleEmail

object IncorrectCertificateHostnameVerificationNoncompliant {
    // {fact rule=incorrect-certificate-hostname-verification@v1.0 defects=1}
    @throws[Exception]
    def nonCompliant(): Unit = {
        val email = new SimpleEmail
        email.setHostName("smtp.googlemail.com")
        // Noncompliant: SSL is enabled without server identity check.
        email.setSSLOnConnect(true)
    }
    // {/fact}
}