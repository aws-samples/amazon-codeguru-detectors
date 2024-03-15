/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=unsafe-file-extension@v1.0 defects=1}
#include <iostream>
#include <cstdio>
#include <fstream>

void unsafeFileExtensionNoncompliant() {
    // Noncompliant: `fopen` opens a file with unsafe extension
    FILE* fileFopen = fopen("example.bat", "rb");
    if (fileFopen != nullptr) {
        std::cout << "File opened successfully using fopen." << std::endl;
        fclose(fileFopen);
    } else {
        std::cout << "Error: Failed to open the file using fopen." << std::endl;
    }
}
// {/fact}