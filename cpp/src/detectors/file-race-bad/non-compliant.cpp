/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=file-race-bad@v1.0 defects=1}

void fileRaceBadNoncompliant()
{
    // Noncompliant: `access` is used to check the state of resource before using it.
    int res = access("/tmp/userfile", R_OK);
    if (res != 0)
        printf("access");
    
    int fd = open("/tmp/userfile", O_RDONLY);
}

// {/fact}