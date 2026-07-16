/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=incomplete-cleanup@v1.0 defects=0}
// Compliant: `match` statement to handle the result of the `TcpListener::bind("127.0.0.1:8080")` operation

use std::net::{TcpListener, TcpStream};

    fn compliant() {
	     let listener = match TcpListener::bind("127.0.0.1:8080") {
	         Ok(listener) => listener,
	         Err(e) => {
	             eprintln!("Failed to bind: {}", e);
	             return;
	         }
	     };
	 }
// {/fact}