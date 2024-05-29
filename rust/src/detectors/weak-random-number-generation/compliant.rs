/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=weak-random-number-generation@v1.0 defects=0}
// Compliant: Secure random number generators
    let key = ring::aead::LessSafeKey::new(unbound_key);
	let rng = ring::rand::SystemRandom::new();
// {/fact}