/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-comparison@v1.0 defects=1}
#include <iostream>

int incorrectComparisonNoncompliant() {
    unsigned short uvar;

    // Noncompliant: unsigned varible can't be less than or equal to 0.
    if (uvar >= 0)
        return 1;

    return 0;
}
// {/fact}