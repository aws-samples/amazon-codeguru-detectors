/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-comparison@v1.0 defects=0}
#include <stdio.h>

int incorrectComparisonCompliant()
{
	size_t uvar;

	// Compliant: Avoiding comparison that can lead to unexpected behaviour
	return 0;
}
// {/fact}