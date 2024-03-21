/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-use-strcat-fn@v1.0 defects=0}
#include <strings.h>

void insecureUseStrcatCompliant(char* src, char* dest, int dest_size) {
    // Compliant: No hardcoded length
    strncat(dest, src, dest_size - 1);
    dest[dest_size - 1] = '\0';
}
// {/fact}