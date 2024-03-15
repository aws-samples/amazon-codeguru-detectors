/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=missing-default-in-switch@v1.0 defects=0}
#include <stdio.h>
#include <stdlib.h>

void missingDefaultInSwitchCompliant(char *data) {
    int result = security_check(data);

    // Compliant: `switch` has `default` statement.
    switch (result) {
    case FAIL:
        printf("Security check failed!\n");
        break;
    case PASS:
        printf("Security check passed.\n");
        break;
    default:
        printf("Unknown error (%d), exiting...\n", result);
        exit(1);
    }
}
// {/fact}