/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=unsafe-file-extension@v1.0 defects=1}
#include <stdio.h>

void unsafeFileExtensionNonCompliant() {
    // Noncompliant: Unsafe file extension used with fopen
    FILE* fileFopen = fopen("example.bat", "rb");
    if (fileFopen != NULL) {
        printf("File opened successfully using fopen.\n");
        fclose(fileFopen);
    } else {
        printf("Error: Failed to open the file using fopen.\n");
    }
}
// {/fact}