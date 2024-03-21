/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=file-race-bad@v1.0 defects=1}
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>
#include <errno.h>
#include <sys/stat.h>

void fileRaceBadNonCompliant()
{
	// Noncompliant: File name is used to do the file operations.
	int res = access("/tmp/userfile", R_OK);
	if (res != 0)
		printf("access");

	int fd = open("/tmp/userfile", O_RDONLY);
		// ...
}
// {/fact}