/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=off-by-one-error@v1.0 defects=1}
#include <stdio.h>

void offByOneErrorNoncompliant() {
    int id_sequence[3];

    id_sequence[0] = 123;
    id_sequence[1] = 234;
    id_sequence[2] = 345;
    // Noncompliant: Attempting to access index 3 out of bound
    id_sequence[3] = 456;
}
// {/fact}