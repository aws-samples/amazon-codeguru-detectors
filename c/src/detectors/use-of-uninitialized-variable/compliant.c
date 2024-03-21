/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=use-of-uninitialized-variable@v1.0 defects=0}
#include <stdio.h>

int useOfUninitializedVariableCompliant(int flag, int b) {
  int a;
  if (flag) {
    a = b;
  } else {
    a = 10;
  }
  // Compliant: Variable is used
  return a; 
}
// {/fact}