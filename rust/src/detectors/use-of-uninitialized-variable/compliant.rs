/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=use-of-uninitialized-variable@v1.0 defects=0}
// Compliant: `MaybeUninit` and following proper initialization procedures within an `unsafe` block
use std::mem::MaybeUninit;

   fn compliant() {
   	     let mut value = MaybeUninit::<i32>::uninit();
   	     unsafe {
   	         value.as_mut_ptr().write(0);
   	         let value = value.assume_init();
   	         println!("Value: {}", value);
   	     }
   }
// {/fact}