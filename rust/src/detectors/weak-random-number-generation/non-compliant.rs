/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=weak-random-number-generation@v1.0 defects=1}
// Noncompliant: Weak random number generators `seed_from_u64`
    let mut rng = StdRng::seed_from_u64(42);
  	 for _ in 0..10 {
  	         let random_number: u32 = rng.gen();
  	 }
// {/fact}