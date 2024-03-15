/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=pointer-subtraction@v1.0 defects=0}
#include <string.h>

void pointerSubtractionCompliant(char *tmp, char *ptr1, char *ptr2)
{
    // Compliant: No subtraction one pointer from another.
    memcpy(tmp, ptr1, 2);
}
// {/fact}