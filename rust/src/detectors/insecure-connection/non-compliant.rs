/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-connection@v1.0 defects=1}

use ftp::{FtpError, FtpStream};
use std::{io::Cursor, str};
// Noncompliant: ftp crate is not maintained any more
	 let mut ftp_stream = FtpStream::connect((addr, 21)).unwrap();
	 let _ = ftp_stream.login("Doe", "mumble").unwrap();
// {/fact}