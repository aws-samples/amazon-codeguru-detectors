/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=unused-assigned-variables@v1.0 defects=1}
#include <stdio.h>

int unusedAssignedVariablesNonCompliant(int y) {
  int x = 0;
  // Noncompliant: dead store
  x = 100; 
  x = 200;
  return x + y;
}
// {/fact}