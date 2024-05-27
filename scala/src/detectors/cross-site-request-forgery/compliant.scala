/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import play.filters.csrf.contentTypeBlacklist

// {fact rule=cross-site-request-forgery@v1.0 defects=0}
object CrossSiteRequestForgeryCompliant {
    // Compliant: Content-Type blacklist is configured properly.
    contentTypeBlacklist = Seq(
    "application/x-www-form-urlencoded",
    "multipart/form-data",
    "text/plain"
    )
}
// {/fact}
