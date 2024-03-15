/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=improper-size-of-a-memory-buffer@v1.0 defects=0}
int improperSizeOfAMemoryBufferCompliant()
{
    char array[10];
    initialize(array);
    // Compliant: size argument is same as the actual size of the buffer.
    char *pos = memchr(array, '@', sizeof(array)); 

    return 0;
}
// {/fact}