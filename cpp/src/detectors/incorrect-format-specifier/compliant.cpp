/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-format-specifier@v1.0 defects=0}
#include<cstdio>

int incorrectFormatSpecifierCompliant() {
    int number;
    // Compliant: Using `%d` for an integer.
    scanf("%d", &number); 
    printf("Correct number: %d\n", number);
    return 0;
}
// {/fact}