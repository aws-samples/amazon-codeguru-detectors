/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=file-system-access-toctou@v1.0 defects=0}
#include <stdio.h>
#include <pthread.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdlib.h>
#include <unistd.h>

pthread_mutex_t log_mutex;
// Compliant: Fix race condition using mutex
void fileSystemAccessToctouCompliant(char *msg) {
  pthread_mutex_lock(&log_mutex);
  FILE *fp = fopen("log.txt", "a");
  fprintf(fp, "%s\n", msg);
  fclose(fp);
  pthread_mutex_unlock(&log_mutex);
}
// {/fact}