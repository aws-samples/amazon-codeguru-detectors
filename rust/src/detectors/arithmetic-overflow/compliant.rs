/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=arithmetic-overflow@v1.0 defects=0}
// Compliant: Used `checked_add` for adding the numbers
    fn compliant() {
    	     let a: u32 = std::u32::MAX;
    	     let b: u32 = 1;
    	     let result = a.checked_add(b);
    	     match result {
    	         Some(val) => println!("Result: {}", val),
    	         None => println!("Addition overflowed"),
    }
// {/fact}