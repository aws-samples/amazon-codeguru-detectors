/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


// {fact rule=use-of-insufficiently-random-values@v1.0 defects=0}
class UseOfInsufficientlyRandomValuesCompliant {

    def compliant() {
        val rand = new SecureRandom()
        val value = Array.ofDim[Byte](16)
        // Compliant: `Random` is not used here.
        rand.nextBytes(value)
        val result = value.map("%02x" format _).mkString
    }
 
}
// {/fact}