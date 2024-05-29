/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=thread-safety-violation@v1.0 defects=1}
// Noncompliant: Using asynchronous contexts `std::fs` and `std::net`
use std::fs;

async fn write_to_file_blocking(file_path: &str, content: &str) {
	     task::spawn_blocking(move || {
	         fs::write(file_path, content).unwrap();
	     }).await.unwrap();
	 }
// {/fact}