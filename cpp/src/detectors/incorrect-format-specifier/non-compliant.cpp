/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-format-specifier@v1.0 defects=1}
#include<cstdio>

int incorrectFormatSpecifierNoncompliant() {
    int number;
    // Noncompliant: Using `%f` instead of `%d` for an integer.
    scanf("%f", &number); 
    printf("Incorrect number: %d\n", number);
    return 0;
}
// {/fact}