/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import play.api.mvc.{Cookie => PlayCookie, _}
import javax.servlet.http.{Cookie => ServletCookie, HttpServletResponse}

class AvoidPersistentCookiesCompliant @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  // {fact rule=avoid-persistent-cookies@v1.0 defects=0}
  def compliant(res: HttpServletResponse, name: String, value: String, secure: Boolean = true, maxAge: Int = 60, httpOnly: Boolean = true): Unit = {
    val cookie = new Cookie("key", "value")
    // Compliant: Cookie `setSecure` method is set to true.
    cookie.setSecure(true)
    cookie.setMaxAge(60)
    cookie.setHttpOnly(true)
    res.addCookie(cookie)
  }
  // {/fact}

}