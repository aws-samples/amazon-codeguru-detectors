/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=insecure-use-gets-fn@v1.0 defects=0}
#include <stdio.h>
#include <string.h>

int insecureUseGetsFnCompliant() {
    char buf[10];
    printf("Enter text: ");
    // Compliant: Secure funcion used with specifying size limit
    fgets(buf, sizeof(buf), stdin); 
    return 0;
}
// {/fact}