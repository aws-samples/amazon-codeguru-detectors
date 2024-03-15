/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=file-race-bad@v1.0 defects=0}

void fileRaceBadCompliant()
{
    // Compliant: The state of the resource hasn’t been checked prior to use.
    FILE *fe = fopen(check_file, "wx");
    if (NULL == fe) {
        /* Handle error */
    }
    
    if (fclose(fe) == EOF) {
        /* Handle error */
    }
}

// {/fact}