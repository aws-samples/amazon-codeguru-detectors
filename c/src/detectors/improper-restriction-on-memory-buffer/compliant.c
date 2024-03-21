/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=improper-restriction-on-memory-buffer@v1.0 defects=0}
#include <stdio.h>
#include <string.h>

void improperRestrictionOnMemoryBufferCompliant() {
    char buf[BUFSIZE];
    if (strlen(string) < BUFSIZE) {
        // Compliant: Check buffer size before copying
        memcpy(buf, string, BUFSIZE);
    }
}
// {/fact}