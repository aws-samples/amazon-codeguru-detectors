/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=weak-random-number-generation@v1.0 defects=1}
#include <stdio.h>
#include <stdlib.h>

enum { len = 12 };

void weakRandomNumberGenerationNoncompliant(void) {
    char id[len];
	int r;
	int num;

    // Noncompliant: `rand()` is insecure to generate random numbers.
    r = rand();
	num = snprintf(id, len, "ID%-d", r);
}
// {/fact}