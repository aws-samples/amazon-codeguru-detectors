/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=out-of-bounds-write@v1.0 defects=0}
void outOfBoundWriteCompliant() {
    int arr[3] = {1, 2, 3};
    // Compliant: Accessing indices within array bounds
    for (int i = 0; i < 3; ++i)
    {
        arr[i] = i * 2;
    }
}
// {/fact}