/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-block-delimitation@v1.0 defects=0}
#include <stdio.h>
#include <stdbool.h>

bool condition = true;
int incorrectBlockDelimitationCompliant()
{
   // Compliant: Actions performed within block
   if (condition) {
      firstActionInBlock();
      secondAction();  
      thirdAction();
   }
}
// {/fact}