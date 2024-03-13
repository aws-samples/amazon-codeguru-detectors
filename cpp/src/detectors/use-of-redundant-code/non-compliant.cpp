/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=use-of-redundant-code@v1.0 defects=1}
#include <stdlib.h>

int useOfRedundantCodeNoncompliant(bool b) {
    if (b)
    {
        Arr a;
        // Noncompliant: Unnecessary copy operation because it creates a copy of a conditionally based on the value of `b`.
        auto cpy = a;
    }
}
// {/fact}