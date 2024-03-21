/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

// {fact rule=bitwise-operator-on-signed-operand@v1.0 defects=0}
#include <stdio.h>

int bitwiseOperatoronSignedOperandCompliant(unsigned int i) {
    // Compliant: Bitwise operator applied on unsigned operand. 
    return 1 << i;
}

// {/fact}