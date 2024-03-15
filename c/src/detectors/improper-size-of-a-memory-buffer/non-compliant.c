/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=improper-size-of-a-memory-buffer@v1.0 defects=1}
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>

void improperSizeOfAMemoryBufferNonCompliant() {
   int fd;
   char buff[1024];
   char path[] = "Documents/example.txt";

   fd = open(path, O_RDONLY);

   int size = 1027;
   // Noncompliant: size argument exceeds the actual size of the buffer.
   read(fd, buff, size);

   printf("\n\n%s\n\n",buff);
}
// {/fact}