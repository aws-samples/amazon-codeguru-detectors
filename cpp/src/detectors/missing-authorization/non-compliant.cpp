/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=missing-authorization@v1.0 defects=1}
#include <stdio.h>

void missingAuthorizationNoncompliant() {
    // Noncompliant: Deletes a file if the user is an admin without checking specific permission.
    if (user.isAdmin())
    {
        deleteFile("important_document.txt");
    }
}
// {/fact}