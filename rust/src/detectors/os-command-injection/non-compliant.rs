/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=os-command-injection@v1.0 defects=1}
// Noncompliant: User input without proper validation
    fn noncompliant() {
    	     println!("Enter a command:");
    	     let mut input = String::new();
    	     io::stdin().read_line(&mut input).expect("Failed to read input");
    	     let output = Command::new("sh")
    	       .arg("-c")
    	       .arg(input.trim())
    	       .output()
    	       .expect("failed to execute process");
    	 }
// {/fact}