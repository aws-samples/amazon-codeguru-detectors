/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=unchecked-null-dereference@v1.0 defects=1}
#include <stdio.h>

void uncheckedNullDereferenceNoncompliant() {
    std::optional<int> opt;
    // Noncompliant: Accessing without checking if opt has value.
    int value = *opt;
    std::cout << "Value: " << value << std::endl;
    return 0;
}
// {/fact}