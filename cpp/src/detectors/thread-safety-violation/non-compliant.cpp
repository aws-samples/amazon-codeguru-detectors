/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=thread-safety-violation@v1.0 defects=1}
static UserManager userManager;

int threadSafetyViolationNoncompliant()
{
	// Noncompliant: Initialization of global objects is not guaranteed across translation units.
    userManager.processUser();

    return 0;
}

// {/fact}