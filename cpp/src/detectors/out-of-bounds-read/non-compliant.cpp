/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=out-of-bounds-read@v1.0 defects=1}
#include <cstring>

void outOfBoundReadsNoncompliant() {
   int MAX = 10;
   char array1[MAX];
   int  array2[MAX];
   // Noncompliant: The call to `memcpy()` reads memory from outside the allocated bounds of character array, which contains MAX elements of type char, while integer array contains MAX elements of type int.
   memcpy(array2, array1, sizeof(array2));
}
// {/fact}