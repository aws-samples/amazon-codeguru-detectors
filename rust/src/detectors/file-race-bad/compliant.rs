/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=file-race-bad@v1.0 defects=0}
// Compliant: Validated symbolic links before removing
fn safe_remove_dir_all(dir_path: &str) {
	     if let Ok(metadata) = fs::symlink_metadata(dir_path) {
	         if metadata.file_type().is_dir() {
	             unix_fs::symlink_metadata(dir_path).map(|metadata| {
	                 if metadata.file_type().is_symlink() {
	                     fs::remove_file(dir_path).unwrap();
	                 }
	             }).unwrap();
	             fs::remove_dir_all(dir_path).unwrap();
	         }
	    }
	 }
// {/fact}