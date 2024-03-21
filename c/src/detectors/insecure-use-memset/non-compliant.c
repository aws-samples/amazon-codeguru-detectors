/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-use-memset@v1.0 defects=1}
#include <string.h>
#include <stdlib.h>

void insecureUseMemsetNonCompliant() {
    char *buffer = malloc(1024);
    // Noncompliant: Use of insecure function.
    memset(buffer, 0, 512);
    free(buffer);
}
// {/fact}