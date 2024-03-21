/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=unused-assigned-variables@v1.0 defects=0}
#include <stdio.h>

int unusedAssignedVariablesCompliant(int y) {
  // Compliant: no unnecessary assignment
  int x = 200; 
  return x + y;
}
// {/fact}