/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-comparison@v1.0 defects=1}
#include <stdio.h>

int incorrectComparisonNonCompliant() {
	unsigned short int uvar;

	// Noncompliant: This will always be true
	if (uvar >= 0)
		return 1;

	return 0;
}
// {/fact}