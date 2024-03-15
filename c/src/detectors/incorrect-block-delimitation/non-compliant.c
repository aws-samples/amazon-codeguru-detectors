/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-block-delimitation@v1.0 defects=1}
#include <stdio.h>
#include <stdbool.h>

bool condition = true;
int incorrectBlockDelimitationNonCompliant()
{
  // Noncompliant: Actions performed outside block
  if (condition)
    firstActionInBlock();
    secondAction(); 
    thirdAction();
}
// {/fact}