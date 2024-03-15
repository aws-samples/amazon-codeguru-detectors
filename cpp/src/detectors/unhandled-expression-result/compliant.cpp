/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=unhandled-expression-result@v1.0 defects=0}
#include <stdio.h>

int insecureComparisonCompliant(int a, int b) {
    int result = 0;
    // Compliant: The result of the expression is assigned to a variable.
    result = a + b; 
    return result;
}
// {/fact}