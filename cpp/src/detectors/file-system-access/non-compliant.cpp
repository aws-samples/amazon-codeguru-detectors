/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=file-system-access@v1.0 defects=1}
#include <fstream>
#include <mutex>
#include <cstdio>


void fileSystemAccessNoncompliant(char* filename)
{
    std::ifstream fileIn(filename);
    std::string data;
    fileIn >> data;
    std::ofstream fileOut(filename, std::ios::app);
    // Noncompliant: Simultaneous read and write without proper synchronization.
    fileOut << "New data appended: " << data << std::endl;
    fileOut.close();
    fileIn.close();
}

// {/fact}