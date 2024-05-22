/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=integer-overflow@v1.0 defects=0}
// Compliant: Use a guard to ensure no overflows occur
fun compliant(args: Array<String>) {
    run {
        val data = SecureRandom().nextInt()
        val scaled: Int
        scaled = if (data < Int.MAX_VALUE / 10) data * 10 else Int.MAX_VALUE
    }
}
// {/fact}