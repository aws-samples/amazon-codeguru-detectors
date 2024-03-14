/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-comparison@v1.0 defects=0}
#include <iostream>

int incorrectComparisonCompliant() {
    unsigned short uvar;

    // Compliant: No comparision.
    return 0;
}
// {/fact}