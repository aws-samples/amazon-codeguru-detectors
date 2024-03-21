/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=improper-input-validation@v1.0 defects=1}
#include <iostream>

void improperInputValidationNoncompliant()
{
    std::string userInput;
    std::cout << "Enter input: ";
    std::getline(std::cin, userInput);
    // Noncompliant: Use user input without validation.
    std::cout << " input is: " << userInput << std::endl;
}
// {/fact}