/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-comparison@v1.0 defects=1}
#include <stdio.h>

int insecureComparisonNonCompliant(int a, int b) {
    int result = 0;
    // Noncompliant: Result is not stored
    a + b; 
    return result;
}
// {/fact}