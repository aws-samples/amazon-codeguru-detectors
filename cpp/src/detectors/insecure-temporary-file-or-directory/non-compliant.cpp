/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-temporary-file-or-directory@v1.0 defects=1}
#include <fstream>

void insecureTemporaryFileOrDirectoryNoncompliant()
{
    char templateName[] = "/tmp/fileXXXXXX";
	FILE* file = fopen(templateName, "w");
    // Noncompliant: Used insecure temporary file.
    mktemp(templateName);
    fprintf(file, "This is unsafe content.\n");
    fclose(file);
}

// {/fact}