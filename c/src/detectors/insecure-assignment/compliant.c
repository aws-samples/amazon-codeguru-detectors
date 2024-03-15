/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-assignment@v1.0 defects=0}
#include <stdio.h>

void insecureAssignmentCompliant() {
    // Compliant: Assignment with getValue
    int x = getValue();
    if (x) {
      doSomething();
    }
}
// {/fact}