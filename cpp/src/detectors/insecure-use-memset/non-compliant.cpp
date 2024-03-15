/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-use-memset@v1.0 defects=1}
#include <stdlib.h>
#include <string.h>

void insecureUseMemsetNoncompliant() {
    char *buffer = (char*)malloc(1024);
    // Noncompliant: Calling `memset()` method can leave sensitive information behind.
    memset(buffer, 0, 512);

    free(buffer);
}
// {/fact}