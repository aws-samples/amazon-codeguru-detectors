/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=improper-input-validation@v1.0 defects=1}
// Noncompliant: from_utf8_unchecked can cause invalid UTF-8 data

use std::str;

	 let input_bytes: &[u8] = b"Hello, world! \xF0";
	 fn process_input_unchecked(input_bytes: &[u8]) -> &str {
	     unsafe {
	         str::from_utf8_unchecked(input_bytes);
	     }
	 }
// {/fact}