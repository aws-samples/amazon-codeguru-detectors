/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-use-strcat-fn@v1.0 defects=1}
#include <strings.h>

int DST_BUFFER_SIZE = 120;

void insecureUseStrcatNonCompliant(char* src, char* dst) {
    int n = DST_BUFFER_SIZE;
    if ((dst != NULL) && (src != NULL) && (strlen(dst)+strlen(src)+1 <= n)) {
        // Noncompliant: Does not affirm length
        strcat(dst, src);
        // Noncompliant: Hardcoded length passed
        strncat(dst, src, 100);
    }
}
// {/fact}