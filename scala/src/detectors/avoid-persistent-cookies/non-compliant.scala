/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import play.api.mvc.{Cookie => PlayCookie, _}
import javax.servlet.http.{Cookie => ServletCookie, HttpServletResponse}

class AvoidPersistentCookiesNoncompliant @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  // {fact rule=avoid-persistent-cookies@v1.0 defects=1}
  def nonCompliant(res: HttpServletResponse, name: String, value: String, secure: Boolean = true, maxAge: Int = 60, httpOnly: Boolean = true): Unit = {
    val cookie = new Cookie("key", "value")
    // Noncompliant: Cookie `setSecure` method is set to false.
    cookie.setSecure(false)
    cookie.setMaxAge(60)
    cookie.setHttpOnly(true)
    res.addCookie(cookie)
  }
  // {/fact}

}