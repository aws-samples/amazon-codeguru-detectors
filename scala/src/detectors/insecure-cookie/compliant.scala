/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

class InsecureCookieCompliant {
    // {fact rule=insecure-cookie@v1.0 defects=0}
    def compliant(res: HttpServletResponse): Unit = {
        val cookie = new Cookie("key", "value")
        cookie.setSecure(true)
        cookie.setHttpOnly(true)
        // Compliant: MaxAge set to one week.
        cookie.setMaxAge(604800)
        res.addCookie(cookie)
    }
    // {/fact}
}