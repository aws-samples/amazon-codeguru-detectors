/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-use-of-free@v1.0 defects=1}
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int incorrectUseOfFreeNonCompliant() {
    NAME *var;
    char buf[10];
    var = (NAME *)malloc(sizeof(struct name));
    free(var);
    // Noncompliant: Variable is used after free
    strcpy(buf, (char*)var);
    return 0;
}
// {/fact}