/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=sensitive-cookie-without-http-only-flag@v1.0 defects=0}
// Compliant: The `httponly` attribute of cookies is set to `true`
fun compliant(value: String, response: HttpServletResponse) {
    val cookie: Cookie = Cookie("cookie", value)
    cookie.setSecure(true)
    cookie.setHttpOnly(true)
    response.addCookie(cookie)
}
// {/fact}
