/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=random-fd-exhaustion@v1.0 defects=0}
#include <fcntl.h>
#include <stdio.h>
#include <string.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>

int randomFdExhaustionCompliant() {
    int fd;
    int bytes_read;
    char buf[16];
    // Compliant: Limits the file descriptor use handling resource allocation
    fd = open("/dev/urandom", 0);
    memset(buf, 0, sizeof(buf));
    bytes_read = read(fd, buf, sizeof(buf));
    if (bytes_read != sizeof(buf)) {
        return -1;
    }
    return 0;
}
// {/fact}