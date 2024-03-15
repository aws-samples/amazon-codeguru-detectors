/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incomplete-cleanup@v1.0 defects=0}
#include <stdio.h>
#include <stdlib.h>

FILE *incompleteCleanupCompliant() {
    FILE *f = fopen("example.txt", "r");
    if (f == NULL) {
        perror("Failed to open file");
    }
    // Compliant: File closed before returning
    fclose(f);
    return f;
}
// {/fact}
