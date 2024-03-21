/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=os-command-injection@v1.0 defects=0}
#include <stdio.h>
#include <unistd.h>
#include <string.h>

int osCommandInjectionCompliant(int argc, char** argv) {
    char cat[] = "cat ";
    char *command;
    size_t commandLength;

    commandLength = strlen(cat) + 1;
    command = (char *) malloc(commandLength);
    strncpy(command, cat, commandLength);

    // Compliant: The (hardcoded) cat command will be executed
    system(command);
    return (0);
}
// {/fact}