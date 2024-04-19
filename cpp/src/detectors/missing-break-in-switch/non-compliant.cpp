/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=missing-break-in-switch@v1.0 defects=1}
#include <stdio.h>

void missingBreakInSwitchNoncompliant(char *data) {
    int result = security_check(data);
    // Noncompliant: First case has missing break or exit.
    switch (result) {
        case FAIL:
            printf("Security check failed!\n");
        case PASS:
            printf("Security check passed.\n");
            break;
        default:
            printf("Unknown error (%d), exiting...\n", result);
            exit(1);
    }
}
// {/fact}