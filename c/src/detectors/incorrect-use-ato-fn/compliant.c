/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-use-ato-fn@v1.0 defects=0}
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* endptr;
const char *buf = "";
int incorrectUseAtoFnCompliant()
{
    // Compliant: secure function used
    long num = strtol(buf, &endptr, 10);
    if(endptr == buf) {
        printf("Conversion failed\n");
        return 1;
    }
    printf("Converted number: %ld\n", num);
    return 0;
}
// {/fact}