/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=redundant-free-usage@v1.0 defects=0}
#include <stdlib.h>
#include <string.h>

int redundantFreeUsageCompliant() {
    char *var = malloc(sizeof(char) * 10);
    free(var);
    var = malloc(sizeof(char) * 10);
    // Compliant: Use of free on variable after memory reallocation
    free(var);
    return 0;
}
// {/fact}