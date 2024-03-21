/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=file-system-access-toctou@v1.0 defects=1}
#include <stdio.h>
#include <pthread.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdlib.h>
#include <unistd.h>

// Function to write a log message
// Has race condition without mutex!
void fileSystemAccessToctouNonCompliant(char *msg) {
  FILE *fp = fopen(filename, "a");
    if (fp == NULL) {
        perror("Error opening file");
        exit(EXIT_FAILURE);
    }

    // Introduce a sleep to create a window for the race condition
    sleep(1);

    // Noncompliant: Write the message to the file
    fprintf(fp, "%s\n", message);

    fclose(fp);
}
// {/fact}