/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-file-permissions@v1.0 defects=1}
// Noncompliant: No permission check before file operation

    fn noncompliant() -> io::Result<()> {
         let dir_path = "/etc/";
         let file_name = "new_file.txt";
         let file_path = format!("{}{}", dir_path, file_name);
         let file = OpenOptions::new().write(true).create(true).open(file_path)?;
         if let Err(e) = writeln!(file, "Sensitive data!") {
             eprintln!("Error writing to file: {}", e);
         } else {
             println!("Data written successfully!");
         }
         Ok(())
    }

// {/fact}