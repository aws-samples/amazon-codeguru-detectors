/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=unchecked-null-dereference@v1.0 defects=0}
#include <stdio.h>

void uncheckedNullDereferenceCompliant() {
    std::optional<int> opt;
    // Compliant: Checking if optional has value before accessing.
    if (opt.has_value())
    {
        int value = *opt;
        std::cout << "Value: " << value << std::endl;
    }
    else
    {
        std::cout << "Optional does not have value." << std::endl;
    }
    return 0;
}
// {/fact}