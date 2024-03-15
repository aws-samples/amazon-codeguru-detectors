/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=random-fd-exhaustion@v1.0 defects=1}

#include <fcntl.h>
#include <stdio.h>
#include <string.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>

int randomFdExhaustionNonCompliant() {
    int fd;
    char buf[16];
    // Noncompliant: Does not handle resource allocation
    fd = open("/dev/urandom", 0);
    memset(buf, 0, sizeof(buf));
    read(fd, buf, sizeof(buf));
    return 0;
}
// {/fact}