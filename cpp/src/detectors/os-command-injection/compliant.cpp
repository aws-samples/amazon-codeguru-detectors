/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=os-command-injection@v1.0 defects=0}
#include <iostream>

int osCommandInjectionCompliant() {
    std::string filename;
    std::cout << "Enter a filename: ";
    std::cin >> filename;

    if (isValid(filename)) {
        std::string command = "ls " + filename;
        // Compliant: Validating the use input before passing into `system` method.
        system(command.c_str());
    }

    return 0;
}
// {/fact}