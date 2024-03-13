/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-temporary-file-or-directory@v1.0 defects=0}
#include <fstream>

void insecureTemporaryFileOrDirectoryCompliant()
{
    char templateName[] = "fileXXXXXX";
    // Compliant: `mkstemp` creates a unique file and returns a file descriptor.
    int fileDescriptor = mkstemp(templateName);
    FILE* file = fdopen(fileDescriptor, "w");
    fprintf(file, "This is safe content.\n");
    fclose(file);
}
// {/fact}