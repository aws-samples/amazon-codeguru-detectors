/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=missing-authorization@v1.0 defects=1}
#include <stdio.h>
#include <stdlib.h>

void misingAuthorizationNonComplaint(char* filename) {
  // Noncompliant: Deleting the file without any validation
  remove(filename);
}
// {/fact}