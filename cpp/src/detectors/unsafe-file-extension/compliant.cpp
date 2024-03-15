/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=unsafe-file-extension@v1.0 defects=0}
#include <iostream>
#include <cstdio>
#include <fstream>

void unsafeFileExtensionCompliant() {
    // Compliant: `fopen` opens a file with safe extension
    FILE* fileFopen = fopen("example.txt", "r");
    if (fileFopen != nullptr) {
        std::cout << "File opened successfully using fopen." << std::endl;
        fclose(fileFopen);
    } else {
        std::cout << "Error: Failed to open the file using fopen." << std::endl;
    }
}

// {/fact}