/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=incorrect-conversion-of-numeric-types@v1.0 defects=0}

void incorrectConversionOfNumericTypesCompliant(int int_var) {
    // Compliant: A primitive is cast to a primitive of a same size.
    int char_var = int_var;
}
// {/fact}