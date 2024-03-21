/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-buffer-access@v1.0 defects=1}
#include <stdio.h>
#include <string.h>

int DST_BUFFER_SIZE = 120;

int insecureBufferAccessNonCompliant() {
    char str[DST_BUFFER_SIZE];
    // Noncompliant: use of scanf function 
    scanf("%s", str);
    printf("%s", str);
    return 0;
}
// {/fact}