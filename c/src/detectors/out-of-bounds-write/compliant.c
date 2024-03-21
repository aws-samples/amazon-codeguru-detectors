/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=out-of-bounds-write@v1.0 defects=0}
#include <stdio.h>

void outOfBoundsWriteCompliant(){

  // Compliant: Ensuring correct loop bounds
  int arr[3] = {1, 2, 3};
  for (int i = 0; i < 3; ++i) {
    arr[i] = i * 2; // Accessing indices within array bounds 
  }
}
// {/fact}