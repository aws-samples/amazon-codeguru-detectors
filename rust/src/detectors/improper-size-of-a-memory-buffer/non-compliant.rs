/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=improper-size-of-a-memory-buffer@v1.0 defects=1}
// Noncompliant: Buffer is not initialized with size

use std::fs::File;
use std::io::{self,Read};

	 fn nonCompliant(file_path: &str, buffer: &mut Vec<u8>) -> io::Result<()>{
	     let mut file = File::open(file_path)?;
	     file.read_to_end(buffer)?;
	     Ok(())
	 }
// {/fact}