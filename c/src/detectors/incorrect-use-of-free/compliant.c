/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-use-of-free@v1.0 defects=0}
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int incorrectUseOfFreeCompliant() {
    NAME *var;
    char buf[10];
    var = (NAME *)malloc(sizeof(struct name));
    free(var);
    var = (NAME *)malloc(sizeof(struct name));
    // Compliant: Variable is used after memory reallocation
    var->func(var->myname);
    return 0;
}

// {/fact}