/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=sensitive-information-leak@v1.0 defects=0}
#include <string.h>

void sensitiveInformationLeakCompliant(char *string)
{
    char buf[BUFSIZE];
    char fmt[] = "whatever";
    // Compliant: Used `snprintf` to ensure that the buffer buf has enough space to store the formatted string and prevent buffer overflow.
    snprintf(buf, BUFSIZE, "address: %s\n", string);
}

// {/fact}