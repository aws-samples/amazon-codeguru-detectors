/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=use-of-uninitialized-variable@v1.0 defects=1}
#include <stdio.h>

int useOfUninitializedVariableNonCompliant() {
  int x;  // x is not initialized
  // Noncompliant: x has grabage value
  return x + 10; 
}
// {/fact}