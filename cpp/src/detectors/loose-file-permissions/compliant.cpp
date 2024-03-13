/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=loose-file-permissions@v1.0 defects=0}
#include <stdio.h>

void looseFilePermissionsCompliant() {
    // Compliant: `S_IRWXU | S_IRWXG` will grant read, write, and execute permissions to the owner and group to this newly created file.
    open("myfile.txt", O_CREAT, S_IRWXU | S_IRWXG);
}
// {/fact}