/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=divide-by-zero@v1.0 defects=0}
struct OptionalInt divideByZeroCompliant(int a, int b) {
    struct OptionalInt result;

    if ((b == 0) || ((a == INT_MIN) && (b == -1))) {
        result.has_value = 0; // Indicates failure
        return result;
    }
    
    result.has_value = 1;
    // Compliant: Checking if the denominator is zero before dividing to avoid division by zero errors
    result.value = a / b; 
    return result; // Check correctly prevents divide-by-zero and signed integer overflows
}
// {/fact}