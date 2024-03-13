/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=out-of-bounds-write@v1.0 defects=1}
void outOfBoundWriteNoncompliant()
{
    // Declaring an array named id_sequence with a size of 3 integers
    int id_sequence[3] = {1, 2, 3};
    // Noncompliant: Attempting to assign a value to the fourth element.
    id_sequence[4] = 456;
}
// {/fact}