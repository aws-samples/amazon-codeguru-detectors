/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-use-of-chroot@v1.0 defects=1}
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>

void insecureUseofChrootNoncompliant(){

    const char* root_dir = "/jail/";
    // Noncompliant: No chdir before or after chroot, and missing check of return value
    chroot(root_dir); 
}
// {/fact}