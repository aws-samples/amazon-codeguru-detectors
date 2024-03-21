/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=missing-check-on-method-output@v1.0 defects=0}
#include <stdlib.h>

int missingCheckOnMethodOutputCompliant() {
    // Compliant: Validating `ptr` value.
    char *ptr = (char *)malloc(MEMSIZE);
    if (ptr == NULL) 
        return -1;
    
    // ...
    return 0;
}
// {/fact}