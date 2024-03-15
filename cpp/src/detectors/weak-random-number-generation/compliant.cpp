/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=weak-random-number-generation@v1.0 defects=0}
#include <stdio.h>
#include <stdlib.h>

enum { len = 12 };

void weakRandomNumberGenerationCompliant() {
    char id[len];
	int r;
	int num;

    // Compliant: `random()` is secure to generate random numbers.
    r = random();
	num = snprintf(id, len, "ID%-d", r);
}
// {/fact}