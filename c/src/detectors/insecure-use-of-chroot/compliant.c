/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-use-of-chroot@v1.0 defects=0}
#include <stdio.h>
void insecureUseofChrootCompliant(){

    const char* root_dir = "/jail/";

    if(chdir(root_dir) == -1) {
      exit(-1);
    }
    // Compliant: the current dir is changed to the jail and the results of both functions are checked
    if(chroot(root_dir) == -1) {  
      exit(-1);
    }

}
// {/fact}