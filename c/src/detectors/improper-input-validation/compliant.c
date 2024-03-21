/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=improper-input-validation@v1.0 defects=0}
#include <stdio.h>
#include <string.h>

void improperInputValidationCompliant(const char* input) {
    char buffer[100]; // Assuming a maximum length of 100 characters

    printf("Enter input: ");
    scanf("%99s", buffer); // Limit input to 99 characters to leave space for null terminator

    if(strlen(buffer) > 99) {
        printf("Input exceeds maximum length\n");
        return;
    }
    // Compliant: Validated input is copied to the provided const char* input
    strcpy(input, buffer); 

    printf("You entered: %s\n", input);
}

// {/fact}