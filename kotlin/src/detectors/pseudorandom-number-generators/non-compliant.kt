/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=weak-random-number-generation@v1.0 defects=1}
// Noncompliant: `Random()` is not a secure random number generator
fun noncompliant() {
    val random = Random() 
    val bytes = ByteArray(20)
    random.nextBytes(bytes)
}
// {/fact}
