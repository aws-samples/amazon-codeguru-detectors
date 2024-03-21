/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-order-setuid-setgid@v1.0 defects=0}
#include <stdio.h>
#include <unistd.h>

void incorrectOrderSetuidSetgidCompliant() {
    // Compliant: setgid() is called before setuid()
    setgid(getgid());
    setuid(getuid());
}
// {/fact}