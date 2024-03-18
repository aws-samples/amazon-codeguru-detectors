/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-use-of-goto@v1.0 defects=1}
#include <stdio.h>

int IncorrectUseofGotoNonCompliant()
{
    int n;
    // Noncompliant: `goto` function is recommended to use inside conditional statements to prevent unconditional jumps
    goto ONE;
    return 0;
ONE:
    printf("went to one\n");
    return 1;
}
// {/fact}