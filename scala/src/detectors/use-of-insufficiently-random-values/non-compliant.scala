/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


// {fact rule=use-of-insufficiently-random-values@v1.0 defects=1}
class UseOfInsufficientlyRandomValuesNoncompliant {

    def nonCompliant() {
        import scala.util.Random
        // Noncompliant: `Random` is used to generate random value.
        val result = Seq.fill(16)(Random.nextInt)
        return result.map("%02x" format _).mkString
    }
}
// {/fact}