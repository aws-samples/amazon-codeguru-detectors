/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-assignment@v1.0 defects=1}
#include <stdio.h>

void insecureAssignmentNonCompliant() {
  int x = 10;
  int y = 20;
  // Noncompliant: Assignment inside the condition
  if (x = 5) {
      // code block
  }
}
// {/fact}