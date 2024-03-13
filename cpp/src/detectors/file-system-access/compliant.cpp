/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=file-system-access@v1.0 defects=0}
#include <fstream>
#include <mutex>
#include <cstdio>

void fileSystemAccessCompliant(char* filename, char* content)
{
    std::mutex mtx;
	// Compliant: Using `std::unique_lock` for synchronization.
    std::unique_lock<std::mutex> lock(mtx);
    std::ofstream file(filename, std::ios::app);
    file << content << std::endl;
    file.close();
}
// {/fact}