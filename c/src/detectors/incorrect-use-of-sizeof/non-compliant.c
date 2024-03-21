/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-use-of-sizeof@v1.0 defects=1}
#include <stdio.h>
#include <stddef.h>
#include <stdlib.h>

void incorrectUseofSizeofNonCompliant()
{
  int *data;
  // Noncompliant: Incorrect usage of sizeof
  size_t const dataSize = sizeof data / sizeof(int); 
}
// {/fact}
