/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=file-race-bad@v1.0 defects=0}
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <errno.h>
#include <sys/stat.h>

void fileRaceBadCompliant(const char *check_file) {
    // Compliant: File name is not used to do the file operations.
    FILE *fe = fopen(check_file, "wx");
    if (NULL == fe) {
        /* Handle error */
    }
    /* Write to file */
    if (fclose(fe) == EOF) {
        /* Handle error */
    }
}
// {/fact}