/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=out-of-bounds-read@v1.0 defects=1}
#include <stdio.h>
#include <string.h>
#include <stddef.h>
#include <stdlib.h>

int outOfBoundsReadNonCompliant() {
    int arr[5] = {1, 2, 3, 4, 5};
    int index = 5;
    // Noncompliant: Array indexing out of bounds
    int value = arr[index];
    printf("Value: %d\n", value);
    return 0;
}
// {/fact}