/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=unhandled-expression-result@v1.0 defects=1}
#include <stdio.h>

int insecureComparisonNonCompliant(int a, int b) {
    int result = 0;
    // Noncompliant: The result of the expression is not assigned to a variable.
    a + b; 
    return result;
}
// {/fact}