/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import React from 'react';

// {fact rule=cross-site-scripting@v1.0 defects=1}
function nonCompliant(input) {
    // Noncompliant: Unsanitized input is used.
    const params = {href: input.a};
    return React.createElement("a", params);
}
// {/fact}
