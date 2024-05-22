/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=sensitive-cookie-without-http-only-flag@v1.0 defects=1}
// Noncompliant: The `httponly` attribute of cookies is set to `false`
fun noncompliant(value: String, response: HttpServletResponse) {
    val cookie: Cookie = Cookie("cookie", value)
    cookie.setHttpOnly(false)
    response.addCookie(cookie)
}
// {/fact}
