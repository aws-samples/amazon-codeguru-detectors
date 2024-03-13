/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=use-after-free@v1.0 defects=0}
#include <cstdlib>
#include <iostream>

void useAfterFreeCompliant() {
    int* arr = new int[5];
    // Compliant: Not accessing array after free
    free(arr);
}
// {/fact}