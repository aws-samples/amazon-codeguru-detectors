/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=missing-default-in-switch@v1.0 defects=0}
#include <stdio.h>
#include <string.h>
#include <stdint.h>
#include <stdlib.h>
#include <stdarg.h>

void missingDefaultInSwitchCompliant(char *data)
{
    int result = security_check(data);

    // Compliant: Default is present
    switch (result) {
    case FAIL:
        printf("Security check failed!\n");
        exit(1);
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