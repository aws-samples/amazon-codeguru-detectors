/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-buffer-access@v1.0 defects=0}
#include <cstring>
#include <stdio.h>

void insecureBufferAccessCompliant(char *string) {
    char buf[BUFSIZE];
    size_t length;
    // Compliant: `snprintf_s` ensures that the formatted string is no longer than the size of the buffer minus one (for the null terminator).
    length = snprintf_s(buf, BUFSIZE, "%s", string);
}
// {/fact}