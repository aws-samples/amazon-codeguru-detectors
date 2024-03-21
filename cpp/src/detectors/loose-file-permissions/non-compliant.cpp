/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=loose-file-permissions@v1.0 defects=1}
#include <stdio.h>

void looseFilePermissionsNoncompliant() {
    // Noncompliant: `S_IRWXU | S_IRWXG | S_IRWXO` will grant read, write, and execute permissions to the owner, group, and others to this newly created file.
    open("myfile.txt", O_CREAT, S_IRWXU | S_IRWXG | S_IRWXO);
}
// {/fact}