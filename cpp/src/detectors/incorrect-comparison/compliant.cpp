/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-comparison@v1.0 defects=0}
#include <iostream>

int incorrectComparisonCompliant() {
    size_t uvar;

    // Compliant: Comparing against 0 is fine for `size_t` types variable.
    if (uvar == 0)
        return 1;

    return 0;
}
// {/fact}