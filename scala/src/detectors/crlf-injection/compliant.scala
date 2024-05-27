/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import javax.servlet.http.HttpServletRequest
import java.util.logging._

class CrlfInjectionCompliant {
  
  // {fact rule=crlf-injection@v1.0 defects=0}
  def compliant(req: HttpServletRequest): Unit = {
    val tainted = req.getParameter("test")
    val logger = Logger.getLogger(classOf[Nothing].getName)
    logger.setLevel(Level.ALL)
    val handler = new ConsoleHandler
    handler.setLevel(Level.ALL)
    logger.addHandler(handler)
    val sanitizedTainted = tainted.replaceAll("[\\r\\n]+", "")
    // Compliant: Untrusted data is sanitized before logging.
    logger.config(sanitizedTainted)
  }
  // {/fact}
}