/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-use-memset@v1.0 defects=0}
#include <string.h>
#include <stdlib.h>
#include <sys/_types/_errno_t.h>

void insecureUseMemsetCompliant() {
    char *buffer = malloc(1024);
    // Compliant: Use of secure function.
    errno_t res = memset_s(buffer, 1024, 0, 1024);
    free(buffer);
}
// {/fact}