/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=deadlock-and-lock-inconsistency@v1.0 defects=1}
#include <limits.h>
#include <pthread.h>
#include <stdio.h>

void deadlockAndLockInconsistencyNonComplaint() {
    pthread_mutex_init(&lock, NULL);
    // Noncompliant: Lock never acquired
    pthread_mutex_unlock(&lock); 
}
// {/fact}