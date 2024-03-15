/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=improper-authentication@v1.0 defects=0}
#include <stdio.h>
#include <string.h>
#define EXPECTED_HASH "$2y$10$8jKvuXVgC0cq2nPRw2XpCeUUiYrtguxna1xnmV4a88pQM/Pz3OxEi"

void improperAuthenticationCompliant(char* password) {
    // Hash the input password
    char hashed_input[100];
    // Use BCrypt to hash input
    bcrypt_hash(hashed_input, password);

    // Compliant: Validate hash against expected
    if(strcmp(hashed_input, EXPECTED_HASH) == 0) {
        printf("Access granted\n");
    } else {
        printf("Access denied\n");
    }

}
// {/fact}