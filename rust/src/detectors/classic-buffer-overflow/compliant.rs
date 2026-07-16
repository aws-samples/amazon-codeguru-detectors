/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=classic-buffer-overflow@v1.0 defects=0}
// Compliant: The `to_le_bytes` method to convert a `u32` integer to a byte array
    fn compliant2() {
	     let num: u32 = 12345;
	     let bytes: [u8; 4] = num.to_le_bytes();
	     println!("{:?}", bytes);
	 }
// {/fact}