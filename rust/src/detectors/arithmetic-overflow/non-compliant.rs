/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=arithmetic-overflow@v1.0 defects=1}
// Noncompliant: Operator used to airthmatic operation
	 fn noncompliant() {
              let a: u32 = std::u32::MAX;
              let b: u32 = 1;
              let result = a + b;
              println!("Result: {}", result);
            }
// {/fact}