/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=multiple-locks@v1.0 defects=1}
#include <iostream>
#include <mutex>
using namespace std;

std::mutex mtx1;
std::mutex mtx2;

void multipleLocksNoncompliant() {
    // Noncompliant: Attempts to acquire locks on mtx1 and mtx2 sequentially, which may lead to a deadlock scenario.
    mtx1.lock();
    mtx2.lock();
    printf("f1");
    mtx2.unlock();
    mtx1.unlock();
}
// {/fact}