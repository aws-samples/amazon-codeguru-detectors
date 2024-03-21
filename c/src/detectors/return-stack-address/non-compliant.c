/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=return-stack-address@v1.0 defects=1}
#include <stdio.h>
#include <stdlib.h>

// Noncompliant: Returning a stack address
int* returnStackAddressNonCompliant() {
    int localVar = 42;
    return &localVar;
}
// {/fact}