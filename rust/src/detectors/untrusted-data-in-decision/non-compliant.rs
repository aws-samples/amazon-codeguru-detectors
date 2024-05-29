/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=untrusted-data-in-decision@v1.0 defects=1}
// Noncompliant: Insecure due to the potential for arbitrary user input, non-existent file paths, and unreliable data
   use std::env;
   let args = env::args();
// {/fact}