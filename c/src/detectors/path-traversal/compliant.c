/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=path-traversal@v1.0 defects=0}
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void pathTraversalComplaint() {
    const char* zip_filename = "example.zip";
    const char* output_dir = "output";

    size_t len = strlen(zip_filename);
    // Compliant: checking if the provided zip_filename ends with the ".zip" extension and if the output_dir exists before calling the extract_all_files function 
    if ((len < 4 || strcmp(zip_filename + len - 4, ".zip") == 0) && (access(output_dir, F_OK) == 0)) {
        extract_all_files(zip_filename, output_dir);
    }
}
// {/fact}