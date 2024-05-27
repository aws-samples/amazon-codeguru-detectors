/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import play.filters.csrf.contentTypeBlacklist

// {fact rule=cross-site-request-forgery@v1.0 defects=1}
object CrossSiteRequestForgeryNoncompliant {
    // Noncompliant: Content-Type blacklist is not configured properly.
    contentTypeBlacklist = Seq(
    "text/plain",
    "multipart/form-data",
    "something/weird"
    )
}
// {/fact}
