/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=string-equality@v1.0 defects=1}
#include <stddef.h>
#include <string.h>

int stringEqualityNonCompliant()
{
    char *s = "Hello";
    // Noncompliant: Checking strin pointer instead of value
    if (s == "World") {

        return -1;
    }
return 0;
}
// {/fact}