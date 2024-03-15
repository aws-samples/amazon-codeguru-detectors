/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-order-setuid-setgid@v1.0 defects=1}
#include <unistd.h>

void incorrectOrderSetuidSetgidNoncompliant()
{
    // Noncompliant: `setgid()` is called after `setuid()`.
    setuid(getuid());
    setgid(getgid());
}

// {/fact}