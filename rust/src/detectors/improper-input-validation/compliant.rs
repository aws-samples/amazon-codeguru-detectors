/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=improper-input-validation@v1.0 defects=0}
// Compliant: Used `from_utf8` to get valid UTF-8 data

    let input_bytes: &[u8] = b"Hello, world!";

	 fn process_input(input_bytes: &[u8]) -> Result<&str, str::Utf8Error> {
	     let input_str = str::from_utf8(input_bytes)?;
	     Ok(input_str)
	 }
// {/fact}