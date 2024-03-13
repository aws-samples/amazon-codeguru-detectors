/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=unchecked-null-dereference@v1.0 defects=0}
#include <stdio.h>

void uncheckedNullDereferenceCompliant() {
    int *ptr = NULL;
    // Compliant: Checking for NULL before dereferencing
    if (ptr != NULL)
    {
        int value = *ptr;
    }
}
// {/fact}