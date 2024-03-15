/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-buffer-access@v1.0 defects=0}
#include <stdio.h>
#include <string.h>

void insecureBufferAccessCompliant(char* src, char* dest, int dest_size) {
  if (strlen(src) < dest_size) {
    // Compliant: Bounds checking
    strcat(dest, src);
  }
}
// {/fact}