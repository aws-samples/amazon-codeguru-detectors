/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-conversion-of-numeric-types@v1.0 defects=1}

void incorrectConversionOfNumericTypesNoncompliant(int int_var) {
    // Noncompliant: A primitive is cast to a primitive of a smaller size.
    char char_var = int_var;
}
// {/fact}