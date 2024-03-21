/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incomplete-cleanup@v1.0 defects=1}
#include <stdio.h>
#include <stdlib.h>

FILE *incompleteCleanupNonCompliant() {
    FILE *f;
    f = fopen("example.txt", "r");
    if (f == NULL) {
        perror("Failed to open file");
    }
    // Noncompliant: File not closed
    return f;
}
// {/fact}