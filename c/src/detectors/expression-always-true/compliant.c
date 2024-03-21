/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=expression-always-true@v1.0 defects=0}
#include <stdio.h>
#include <stdbool.h>

void expresionAlwaysTrueCompliant(bool flag)
{
 int age = 33;
  // Compliant: There is no direct use of boolean value 
  if (!flag || age>=19) { 
    firstActionInBlock();
  }
  else {
    secondAction(); 
  }
}
// {/fact}