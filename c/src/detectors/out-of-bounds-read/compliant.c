/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=out-of-bounds-read@v1.0 defects=0}
#include <stdio.h>
#include <string.h>
#include <stddef.h>
#include <stdlib.h>

int outOfBoundsReadCompliant() {
    int arr[5] = {1, 2, 3, 4, 5};
    int index = 2; // Choose a valid index within the array bounds
    // Compliant: Ensure index is within bounds before accessing the array
    if (index >= 0 && index < 5) {
        int value = arr[index];
        printf("Value: %d\n", value);
    } else {
        printf("Invalid index\n");
    }
    return 0;
}
// {/fact}