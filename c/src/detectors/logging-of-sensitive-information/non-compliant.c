/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=logging-of-sensitive-information@v1.0 defects=1}
#include <stdio.h>

int loggingOfSensitiveInformationNonCompliant(int argc, char *argv[]) {
    // Noncompliant: Logging sensitive information
    printf(argv[1]);
    return 0;
}
// {/fact}