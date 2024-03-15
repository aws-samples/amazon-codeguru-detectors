/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=expression-always-true@v1.0 defects=1}
#include <stdio.h>
#include <stdbool.h>

void expressionAlwaysTrueNonCompliant()
{
  bool x = false;
  // Noncompliant: Boolean value assigned to variable used in expression
  if (!x || con) { 
    firstActionInBlock();
  }
  else {
    secondAction(); // never executed
  }
}
// {/fact}