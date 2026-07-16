/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=file-race-bad@v1.0 defects=1}
// Noncompliant: Use of `remove_dir_all` without validating symbolic links

fn vulnerable_remove_dir_all(dir_path: &str) {
	     if fs::metadata(dir_path).unwrap().is_dir() {
	         fs::remove_dir_all(dir_path).unwrap();
	     }
	 }
// {/fact}