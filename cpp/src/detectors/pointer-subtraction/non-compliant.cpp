/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=pointer-subtraction@v1.0 defects=1}
#include <string.h>

void pointerSubtractionNoncompliant(char *tmp, char *ptr1, char *ptr2)
{
    // Noncompliant: Subtraction one pointer from another.
    memcpy(tmp, ptr1, (ptr2 - ptr1) - 1);
}

// {/fact}
