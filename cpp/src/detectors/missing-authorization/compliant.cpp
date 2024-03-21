/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=missing-authorization@v1.0 defects=0}
#include <stdio.h>

void missingAuthorizationCompliant() {
    // Compliant: Checks for a specific permission (DELETE_FILE) before deleting the file.
    if (user.hasPermission(DELETE_FILE))
    {
        deleteFile("important_document.txt");
    }
}
// {/fact}