/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=deadlock-and-lock-inconsistency@v1.0 defects=0}
#include <limits.h>
#include <pthread.h>
#include <stdio.h>

pthread_mutex_t lock;

void deadlockAndLockInconsistencyCompliant()
{
    // Compliant: This code dose not contains a potential deadlock or violate lock consistency due to incorrect lock ordering or nested locking.
    pthread_mutex_init(&lock, NULL); // initialize mutex first
    pthread_mutex_lock(&lock); // okay to lock now
    // critical section
    pthread_mutex_unlock(&lock);
}
// {/fact}