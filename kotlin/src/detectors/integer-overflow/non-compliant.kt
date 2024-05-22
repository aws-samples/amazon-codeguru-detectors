/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=integer-overflow@v1.0 defects=1}
// Noncompliant: Decrementing from Int.MIN_VALUE be cause integer overflow.
fun noncompliant() {
    var value: Int = Int.MIN_VALUE
    value--
    println("Decremented value: $value")
}
// {/fact}