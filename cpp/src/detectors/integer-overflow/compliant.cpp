/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=integer-overflow@v1.0 defects=0}
#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>

void integerOverflowCompliant(int *ptr, size_t offset) {
    // Compliant: Safer pointer arithmetic with proper check
    if (offset <= SIZE_MAX / sizeof(int))
    {
        int *result = ptr + offset;
        // Use 'result'
    }
    else
    {
        fprintf(stderr, "Overflow detected in pointer arithmetic.\n");
    }
}
// {/fact}