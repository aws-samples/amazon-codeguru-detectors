/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-hashing@v1.0 defects=1}
// Noncompliant: Insecure hashing algorithm `Md2` used
   use md2::{Md2};
   let mut hasher = Md2::new();
// {/fact}