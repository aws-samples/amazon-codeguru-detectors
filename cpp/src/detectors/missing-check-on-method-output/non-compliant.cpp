/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=missing-check-on-method-output@v1.0 defects=1}
#include <stdlib.h>

void missingCheckOnMethodOutputNoncompliant() {
    // Noncompliant: No validation for `ptr` value
    char *ptr = (char *)malloc(MEMSIZE);
}
// {/fact}