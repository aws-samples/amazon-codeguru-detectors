/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-cookie@v1.0 defects=1}
// Noncompliant:  The `setSecure` attribute of cookies is set to `false`
fun noncompliant() {
    var cookie: Cookie = Cookie("cookie", value)
    cookie.setSecure(false)
    cookie.setHttpOnly(false)
    response.addCookie(cookie)
}
// {/fact}
