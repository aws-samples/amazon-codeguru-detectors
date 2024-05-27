/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import javax.servlet.http.HttpServletRequest
import java.util.logging._

class CrlfInjectionNoncompliant {
  
  // {fact rule=crlf-injection@v1.0 defects=1}
  def nonCompliant(req: HttpServletRequest): Unit = {
    val tainted = req.getParameter("test")
    val logger = Logger.getLogger(classOf[Nothing].getName)
    logger.setLevel(Level.ALL)
    val handler = new ConsoleHandler
    handler.setLevel(Level.ALL)
    logger.addHandler(handler)
    // Noncompliant: Untrusted data is passed to a logging method.
    logger.config(tainted)
  }
  // {/fact}
}