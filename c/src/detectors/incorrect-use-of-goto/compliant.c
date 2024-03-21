/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-use-of-goto@v1.0 defects=0}
#include <stdio.h>

int IncorrectUseofGotoCompliant()
{
    FILE *file = fopen("example.txt", "r");
    if (file == NULL) {
        perror("Error opening file");
        // Compliant: `goto` function is used inside conditional statements
        goto cleanup;
    }
    // File processing code here
    cleanup:
        if (file != NULL) {
            fclose(file);
        }
}
// {/fact}