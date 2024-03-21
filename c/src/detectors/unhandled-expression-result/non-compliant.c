/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=unhandled-expression-result@v1.0 defects=1}
#include <stdio.h>

int unhandledExpressionResultNonCompliant(int a, int b) {
    int result = 0;
    // Noncompliant: Unnecessary operation, expression result is not handled by any veriable here
    a + b; 
    return result;
}
// {/fact}