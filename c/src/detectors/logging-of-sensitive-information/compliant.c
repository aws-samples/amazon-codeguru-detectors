/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=logging-of-sensitive-information@v1.0 defects=0}
#include <stdio.h>

void loggingOfSensitiveInformationCompliant(const char *data) {
    FILE *file = fopen("log.txt", "a");
    if (file != NULL) {
        // Redact sensitive information before logging
        char redactedData[strlen(data) + 1];
        strcpy(redactedData, data);
        // Compliant: Replace sensitive information with placeholders or tokens
        // For example, replace credit card numbers with "************"
        // Modify this based on the type of sensitive data
        redactCreditCardNumbers(redactedData); // Function to replace credit card numbers with ****

        fputs(redactedData, file);
        fputs("\n", file);
        fclose(file);
    }
}
// {/fact}