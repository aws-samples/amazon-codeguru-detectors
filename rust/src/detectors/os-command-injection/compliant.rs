/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=os-command-injection@v1.0 defects=0}
// Compliant: string arguments instead of user input
    fn compliant2() {
	     let output = Command::new("ls")
	         .arg("-l")
	         .output()
	         .expect("failed to execute process");
	 }
// {/fact}