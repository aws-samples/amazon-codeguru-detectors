/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=missing-default-in-switch@v1.0 defects=1}
#include <stdio.h>
#include <stdlib.h>

void missingDefaultInSwitchNoncompliant(char *data) {
    int result = security_check(data);

    // Noncompliant: `switch` does not have `default` statement.
    switch (result) {
    case FAIL:
        printf("Security check failed!\n");
        break;
    case PASS:
        printf("Security check passed.\n");
        break;
    }
}
// {/fact}