/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=improper-authentication@v1.0 defects=1}
#include <stdio.h>
#include <string.h>

// Hardcoded weak password
#define PASSWORD "1234"

// Login function
void improperAuthenticationNonCompliant(char* password) {
    // Noncompliant: Authentication missing
    if(strcmp(password, PASSWORD) == 0) {
        printf("Access granted\n");
    } else {
        printf("Access denied\n");
    }
}
// {/fact}