/*
 *  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *  SPDX-License-Identifier: Apache-2.0
 */

 // {fact rule=incorrect-conversion-of-numeric-types@v1.0 defects=0}
 // Compliant: verify that the resulting rounded value
 fn try_floor_u64(value: f64) -> Option<u64> {
    let mut rug_float = rug::Float::with_val(53, value);
    rug_float = rug_float.floor();
    if rug_float >= 0.0 && rug_float <= u64::MAX as f64 {
        Some(rug_float.to_u64().unwrap()) 
    } else {
        None 
    }
}
 // {/fact}