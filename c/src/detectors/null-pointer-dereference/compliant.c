/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=null-pointer-dereference@v1.0 defects=0}
#include <stdio.h>
#include <stdlib.h>
#include <stddef.h>
#include <string.h>
#include <assert.h>

void NullPointerDereferenceCompliant()
{
    int *ptr = NULL;
    // Compliant: Checking for NULL before dereferencing
    if (ptr != NULL)
    {
        int value = *ptr;
    }
}
// {/fact}