/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-use-of-sizeof@v1.0 defects=0}
#include <stdlib.h>

void incorrectUseOfSizeofCompliant()
{
	double *foo;

	// Compliant: Used `sizeof(*foo)`.
	foo = (double *)malloc(sizeof(*foo));
}
// {/fact}