/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=multiple-locks@v1.0 defects=0}
#include <iostream>
#include <mutex>
using namespace std;

std::mutex mtx1;
std::mutex mtx2;

void multipleLocksCompliant() {
    // Compliant: Two mutexes mtx1 and mtx2 are acquired and released sequentially, ensuring that they are locked and unlocked correctly.
    mtx1.lock();
    mtx1.unlock();
    mtx2.lock();
    printf("f1");
    mtx2.unlock();
}
// {/fact}