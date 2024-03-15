/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=use-of-redundant-code@v1.0 defects=0}
#include <stdlib.h>

int useOfRedundantCodeCompliant(bool b) {
    if (b)
    {
        Arr a;
        auto cpy = a;
        // Compliant: Modification ensures that the copy operation is necessary, as the copied instance `cpy` is used independently of the original instance `a`.
        cpy.arr[0] = 8;
    }
}
// {/fact}