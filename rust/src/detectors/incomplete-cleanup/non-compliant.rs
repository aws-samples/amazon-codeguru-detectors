/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=incomplete-cleanup@v1.0 defects=1}
// Noncompliant: Calling `unwrap()` will cause the program to panic immediately

use std::net::{TcpListener, TcpStream};

	 fn noncompliant() {
	     let listener = TcpListener::bind("127.0.0.1:8080").unwrap();
	 }
// {/fact}