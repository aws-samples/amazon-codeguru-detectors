/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=integer-overflow@v1.0 defects=1}
#include <stdlib.h>

void integerOverflowNoncompliant(int *ptr, size_t offset) {
    // Noncompliant: Perform pointer arithmetic without checking for potential integer overflow.
    int *result = ptr + offset;
}
// {/fact}