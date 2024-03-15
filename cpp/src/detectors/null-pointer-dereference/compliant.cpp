/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=null-pointer-dereference@v1.0 defects=0}
#include <cstdlib>

int nullPointerDereferenceCompliant()
{
    int *ptr = NULL;
    // Compliant: Checking ptr value before dereferencing.
    if (ptr != NULL)
    {
        int value = *ptr;
    }
    
}
// {/fact}