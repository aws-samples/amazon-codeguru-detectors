/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-buffer-access@v1.0 defects=1}
#include <cstring>
#include <stdio.h>

void insecureBufferAccessNoncompliant(char *string) {
    char buf[BUFSIZE];
    size_t length;

    // Noncompliant: `snprintf()`function returns the total length of the string they tried to create.
    length = snprintf(buf, BUFSIZE, "%s", string);
}
// {/fact}