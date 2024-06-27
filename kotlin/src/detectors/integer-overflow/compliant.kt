/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=integer-overflow@v1.0 defects=0}
// Compliant: A guard is used to ensure no overflows occur.
fun compliant() {
    var value: Int = Int.MIN_VALUE
    if(value > Int.MIN_VALUE) {
        value--
    } 
    else {
        println("Value is already at the minimum limit and cannot be decremented.")
    }
}
// {/fact}