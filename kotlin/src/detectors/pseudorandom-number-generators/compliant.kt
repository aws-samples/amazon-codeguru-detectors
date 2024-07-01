/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=weak-random-number-generation@v1.0 defects=0}
// Compliant: Using `SecureRandom()` to generate random numbers
fun compliant() {
    val random = SecureRandom()
    val bytes = ByteArray(20)
    random.nextBytes(bytes)
}
// {/fact}
