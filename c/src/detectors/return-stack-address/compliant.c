/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=return-stack-address@v1.0 defects=0}
#include <stdio.h>
#include <stdlib.h>

// Compliant: Returning a heap-allocated address
int* returnStackAddressCompliant() {
    int* ptr = (int*)malloc(sizeof(int));
    *ptr = 42;
    return ptr;
}
// {/fact}