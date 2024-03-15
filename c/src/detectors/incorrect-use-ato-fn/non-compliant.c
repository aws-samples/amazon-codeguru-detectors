/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-use-ato-fn@v1.0 defects=1}
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

const char *buf = "";
void incorrectUseAtoFnNonCompliant()
{
    // Noncompliant: Insecure function used
    int i = atoi(buf);
    printf("Converted integer: %d\n", i);
}
// {/fact}