/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

const DOMPurify = require('dompurify');

// {fact rule=cross-site-scripting@v1.0 defects=0}
function compliant(input) {
    // Compliant: Sanitized input is used.
    const sanitizedHref = DOMPurify.sanitize(input.a);
    const params = { href: sanitizedHref };
    return React.createElement("a", params);
}
// {/fact}
