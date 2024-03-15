/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-use-of-sizeof@v1.0 defects=0}
#include<stdio.h>
#include <stddef.h>
#include <stdlib.h>

void incorrectUseofSizeofCompliant()
{
  int *ptr;
  // Compliant: Correct use of sizeof to get the size of type and not the size of pointer
  size_t size = sizeof(*ptr);
}
// {/fact}