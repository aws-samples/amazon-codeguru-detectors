/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=throw-exception-with-trace@v1.0 defects=1}
// Noncompliant: The `expect` method on a `Result` type to extract the value from an `Ok
    fn noncompliant() {
	     let result: Result<i32, &str> = Ok(42);
	     let value = result.expect("Error occurred");
	     println!("Value: {}", value);
	 }
// {/fact}