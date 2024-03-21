/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=sensitive-information-leak@v1.0 defects=1}
#include <string.h>

void sensitiveInformationLeakNoncompliant(char *string)
{
    char buf[BUFSIZE];
    char fmt[] = "whatever";
    // Noncompliant: `printf` statement that prints the address of the local variable buf.
    printf("address: %p\n", buf);
}

// {/fact}