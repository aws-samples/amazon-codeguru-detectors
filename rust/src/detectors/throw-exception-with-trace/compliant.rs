/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=throw-exception-with-trace@v1.0 defects=0}
// Compliant: `match` expression to handle `Result` values

    fn compliant() {
	     let result: Result<i32, &str> = Ok(42);
	     match result {
	         Ok(value) => {
	             println!("Value: {}", value);
	         }
	         Err(error_message) => {
	             eprintln!("Error occurred: {}", error_message);
	         }
	}
// {/fact}