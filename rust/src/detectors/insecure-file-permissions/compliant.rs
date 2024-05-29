/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-file-permissions@v1.0 defects=0}
// Compliant: Permission check added before file operations

    fn compliant() -> io::Result<()> {
         let file_path = PathBuf::from("example.txt");
         if !file_path.exists() || file_path.metadata()?.permissions().mode() & 0o222 != 0 {
            //ok: rust-account-writable-check
             let file = OpenOptions::new().write(true).create(true).open(&file_path)?;
             if let Err(e) = writeln!(file, "This is some data.") {
                 eprintln!("Error writing to file: {}", e);
             } else {
                 println!("Data written successfully!");
             }
         } else {
             eprintln!("Error: You do not have permission to write to the file at {:?}", file_path);
         }
         Ok(())
	}
// {/fact}