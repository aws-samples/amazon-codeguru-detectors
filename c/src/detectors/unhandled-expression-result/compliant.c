/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=unhandled-expression-result@v1.0 defects=0}
#include <stdio.h>

int unhandledExpressionResultCompliant(int a, int b) {
    int result = 0;
    // Compliant: Expression result is handled by veriable
    result = a + b; 
    return result;
}
// {/fact}