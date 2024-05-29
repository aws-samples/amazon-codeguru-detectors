/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-connection@v1.0 defects=0}
// Compliant: Used suppaftp for connection
use suppaftp::FtpStream;

	 let mut ftp_stream = FtpStream::connect("example.com").unwrap();
	 ftp_stream.login("anonymous", "me@example.com").unwrap();
// {/fact}