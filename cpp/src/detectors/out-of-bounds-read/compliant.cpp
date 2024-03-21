/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=out-of-bounds-read@v1.0 defects=0}
#include <cstring>

void outOfBoundReadscompliant() {
   int MAX = 10;
   int array1[MAX];
   int  array2[MAX];
   // Compliant: Both arrays are of same data type.
   memcpy(array2, array1, sizeof(array2));
}

// {/fact}