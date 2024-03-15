/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=path-traversal@v1.0 defects=1}
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void pathTraversalNonComplaint(int argc, char *argv[]) {
  char filename[100];

  strcpy(filename, argv[1]);
  // Noncompliant: user input is used to construct file path
  FILE *fp = fopen(filename, "r");
  if(fp == NULL) {
    printf("Error opening file\n");
    return 1;
  }
  // Read file contents
  fclose(fp);
}
// {/fact}