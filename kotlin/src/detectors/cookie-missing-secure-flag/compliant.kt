/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-cookie@v1.0 defects=0}
// Compliant: The `setSecure` attribute of a cookie is set to `true`
fun compliant(@RequestParam value: String, response: HttpServletResponse) {
    var cookie: Cookie = Cookie("cookie", value)
    cookie.setSecure(true)
    cookie.setHttpOnly(true)
    response.addCookie(cookie)
}
// {/fact}
