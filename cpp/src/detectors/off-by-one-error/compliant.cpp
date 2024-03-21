/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=off-by-one-error@v1.0 defects=0}
#include <stdio.h>

void offByOneErrorCompliant() {

    int id_sequence[4]; // Increase array size to accommodate the additional element

    id_sequence[0] = 123;
    id_sequence[1] = 234;
    id_sequence[2] = 345;
    // Compliant: This is a valid index within the bounds of the array.
    id_sequence[3] = 456;
}
// {/fact}