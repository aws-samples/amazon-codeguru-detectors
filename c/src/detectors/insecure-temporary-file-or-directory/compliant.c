/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-temporary-file-or-directory@v1.0 defects=0}
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <string.h>
#include <unistd.h>

int insecureTemporaryFileorDirectoryCompliant(char *tempData) {
  // Compliant: The file will be opened in "wb+" mode, and will be automatically removed on normal program exit
  FILE* f = tmpfile(); 
  fputs(tempData, f);
  fclose(f);
  return 0;
}
// {/fact}