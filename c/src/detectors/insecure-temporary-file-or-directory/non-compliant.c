/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-temporary-file-or-directory@v1.0 defects=1}
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <string.h>
#include <unistd.h>

int insecureTemporaryFileorDirectoryNonCompliant(char *tempData) {
  // Noncompliant: Insecure function used
  char *path = tmpnam(NULL); 
  FILE* f = fopen(path, "w");
  fputs(tempData, f);
  fclose(f);
}
// {/fact}