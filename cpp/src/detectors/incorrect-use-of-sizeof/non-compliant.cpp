/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-use-of-sizeof@v1.0 defects=1}
#include <stdlib.h>

void incorrectUseOfSizeofNoncompliant()
{
	double *foo;

	// Noncompliant: Used `sizeof(foo)` on a malloced pointer type.
	foo = (double *)malloc(sizeof(foo));
}

// {/fact}