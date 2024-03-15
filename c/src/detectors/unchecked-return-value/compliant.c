/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=unchecked-return-value@v1.0 defects=0}
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>
#include <sys/stat.h>

void uncheckedReturnValueCompliant() { 
    const char* root_dir = "/jail/";
    // Compliant: Checking the return value
    if (chdir(root_dir) == -1) {
      exit(-1);
    }
    
}

// {/fact}