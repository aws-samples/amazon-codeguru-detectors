/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=improper-input-validation@v1.0 defects=1}
#include <stdio.h>
#include <string.h>

void improperInputValidationNonCompliant(const char* username) {
    printf("Enter username: ");
    fgets(username, sizeof(username), stdin);
    // Noncompliant: Input validation is needed to prevent user input from exceeding the allocated memory for `username`.
    printf("Hello, %s!\n", username);
}

// {/fact}