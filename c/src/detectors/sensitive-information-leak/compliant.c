/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=sensitive-information-leak@v1.0 defects=0}
#include <stdio.h>
#include <stdlib.h>

void sensitiveInformationLeakCompliant() {
    // Compliant: check present before storing environment variables
    char* key = getenv("APP_KEY");
    if (key != NULL) {
        fprintf(stdout, "APP_KEY value: %s\n", key);
    }
}

// {/fact}