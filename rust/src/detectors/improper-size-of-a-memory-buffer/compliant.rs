/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=improper-size-of-a-memory-buffer@v1.0 defects=0}
// Compliant: Buffer initialized with size

fn compliant(file_path: &str, buffer: &mut Vec<u8>) -> io::Result<()>{
	     let mut file = File::open(file_path)?;
	     let file_size = file.metadata()?.len() as usize;
	     buffer.reserve(file_size);
	     file.read_to_end(buffer)?;
	     Ok(())
	 }
// {/fact}