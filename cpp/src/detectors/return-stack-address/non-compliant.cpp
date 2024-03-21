/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=return-stack-address@v1.0 defects=1}
#include <stdlib.h>

int* returnStackAddressNoncompliant()
{
    int localVar = 42;
    // Noncompliant: Returning a stack address
    return &localVar;
}

// {/fact}