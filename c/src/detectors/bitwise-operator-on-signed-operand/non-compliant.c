/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=bitwise-operator-on-signed-operand@v1.0 defects=1}
#include <stdio.h>

int bitwiseOperatoronSignedOperandNonCompliant(int i) {
    // Noncompliant: Bitwise operator applied on signed operand.
    return 1 << i; // Noncompliant
}

// {/fact}