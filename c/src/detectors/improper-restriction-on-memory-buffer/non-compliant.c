/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=improper-restriction-on-memory-buffer@v1.0 defects=1}
#include <stdio.h>
#include <string.h>

void improperRestrictionOnMemoryBufferNonCompliant() {
    char buffer[10];
    const char* data = "ThisIsALongString";
    // Noncompliant: Buffer overflow may occur no size check
    strcpy(buffer, data);
}
// {/fact}