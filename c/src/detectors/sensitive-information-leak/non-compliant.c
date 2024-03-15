/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=sensitive-information-leak@v1.0 defects=1}
#include <stdio.h>
#include <stdlib.h>

void sensitiveInformationLeakNonCompliant() {
    // Noncompliant: no check present before storing environment variables
    char* path = getenv("PATH");
    char *buffer;
    sprintf(buffer, "Cannot find exe on path: %s", path);
}

// {/fact}