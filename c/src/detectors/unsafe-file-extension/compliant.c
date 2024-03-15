/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=unsafe-file-extension@v1.0 defects=0}
#include <stdio.h>

void unsafeFileExtensionCompliant() {
    // Compliant: Safe extension used with fopen example
    FILE* fileFopen = fopen("example.txt", "r");
    if (fileFopen != NULL) {
        printf("File opened successfully using fopen.\n");
        fclose(fileFopen);
    } else {
        printf("Error: Failed to open the file using fopen.\n");
    }
}
// {/fact}