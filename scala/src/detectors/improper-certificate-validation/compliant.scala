/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import javax.net.ssl._

object ImproperCertificateValidationCompliant {
  // {fact rule=improper-certificate-validation@v1.0 defects=0}
  def compliant(args: Array): Unit = {
    try {
      // Compliant: the default hostname verifier is used.
      val context2 = SSLContext.getInstance("TLS")
    } catch {
      case e: NoSuchAlgorithmException =>
        e.printStackTrace
    }
  }
  // {/fact}
}