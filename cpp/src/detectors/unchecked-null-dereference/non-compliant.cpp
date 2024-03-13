/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=unchecked-null-dereference@v1.0 defects=1}
#include <stdio.h>

void uncheckedNullDereferenceNoncompliant() {
    int *ptr;
    // Noncompliant: Dereferencing uninitialized pointer
    int value = *ptr;
}
// {/fact}