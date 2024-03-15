/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=os-command-injection@v1.0 defects=1}
#include <stdio.h>
#include <unistd.h>
#include <string.h>

int osCommandInjectionNonCompliant(int argc, char **argv) {
    char cat[] = "cat ";
    char *command;
    size_t commandLength;

    commandLength = strlen(cat) + strlen(argv[1]) + 1;
    command = (char *) malloc(commandLength);
    strncpy(command, cat, commandLength);

    // Noncompliant: argv[1] is concatenated into command without validation
    strncat(command, argv[1], (commandLength - strlen(cat)) );

    // A potentially untrusted input is passed into `system` function
    system(command);
    return (0);
}
// {/fact}