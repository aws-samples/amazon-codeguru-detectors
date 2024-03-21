/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=use-after-free@v1.0 defects=1}
#include <cstdlib>
#include <iostream>

void useAfterFreeNoncompliant() {
    int* arr = new int[5];
    free(arr);
    // Noncompliant: Accessing array after free
    std::cout << arr[0] << std::endl;
}
// {/fact}