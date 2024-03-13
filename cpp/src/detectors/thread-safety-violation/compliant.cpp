/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=thread-safety-violation@v1.0 defects=0}
int threadSafetyViolationCompliant()
{

    UserManager userManager;
    // Compliant: Initialization of objects in same translation units.
    userManager.processUser();

    return 0;
}
// {/fact}
