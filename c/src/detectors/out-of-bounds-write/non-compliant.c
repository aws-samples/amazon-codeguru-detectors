/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=out-of-bounds-write@v1.0 defects=1}
void outOfBoundsWriteNonCompliant(){
    // Declaring an array named id_sequence with a size of 3 integers
    int id_sequence[3];
    id_sequence[0] = 123;
    id_sequence[1] = 234; 
    id_sequence[2] = 345;
    // Noncompliant: Attempting to assign a value to the fourth element (out of bounds)
    id_sequence[3] = 456; 
}
// {/fact}