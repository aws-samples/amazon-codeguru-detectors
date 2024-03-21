/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=unchecked-return-value@v1.0 defects=1}
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>
#include <sys/stat.h>

void uncheckedReturnValueNotCompliant() {
    const char* any_dir = "/any/";
    // Noncompliant: missing check of the return value
    chdir(any_dir); 
}

// {/fact}