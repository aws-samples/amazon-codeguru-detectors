/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-use-memset@v1.0 defects=0}
#include <stdlib.h>

void insecureUseMemsetCompliant() {
    char *buffer = (char*)malloc(1024);
    // Compliant: `memset_s` overwrites memory securely.
    memset_s(buffer, 1024, 0, 1024);

    free(buffer);
}
// {/fact}