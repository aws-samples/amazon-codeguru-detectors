/*
 *  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *  SPDX-License-Identifier: Apache-2.0
 */

 // {fact rule=incorrect-conversion-of-numeric-types@v1.0 defects=1}
 // Noncompliant: not verify that the resulting rounded value

 fn try_round_u64(value: f64) -> Option<u64> {
    Some(value.round() as u64)
}

 // {/fact}