/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=redundant-free-usage@v1.0 defects=1}
#include <stdlib.h>
#include <string.h>

int redundantFreeUsageNonCompliant(char *argv[]) {
    char *buf1;
    char *buf2;
    buf1 = (char *) malloc(sizeof(char) * 10);
    free(buf1);
    buf2 = (char *) malloc(sizeof(char) * 5);
    strncpy(buf2, argv[1], 1);
    // Noncompliant: Redundent use of `free` on buf1 without memory reallocation
    free(buf1);
    free(buf2);
}
// {/fact}