/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=string-equality@v1.0 defects=0}
#include <stddef.h>
#include <string.h>

char *s = "Hello";

int stringEqualityCompliant()
{
    // Compliant: Checking actual value using strcmp
    if (strcmp(s, "World") == 0) {
        return -1;
    }
return 0;
}
// {/fact}