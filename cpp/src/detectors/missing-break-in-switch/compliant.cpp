/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=missing-break-in-switch@v1.0 defects=0}
#include <stdio.h>

void missingBreakInSwitchCompliant(char *data) {
    int result = security_check(data);
    // Compliant: All cases have missing break or exit.
    switch (result) {
    case FAIL:
        printf("Security check failed!\n");
        exit(1);
    case PASS:
        printf("Security check passed.\n");
        break;
    default:
        printf("Unknown error (%d), exiting...\n", result);
        exit(1);
    }
}
// {/fact}