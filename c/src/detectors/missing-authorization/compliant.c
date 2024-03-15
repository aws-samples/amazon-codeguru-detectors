/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=missing-authorization@v1.0 defects=0}
#include <stdio.h>

void misingAuthorizationComplaint(char* filename, char* user) {

  // Compliant: Check if user has delete permission
  if(checkPermissions(user, filename) == TRUE) {
    remove(filename);
  }
}
// {/fact}