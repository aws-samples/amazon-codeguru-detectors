/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=use-of-uninitialized-variable@v1.0 defects=1}
// Noncompliant: The `std::mem::uninitialized()` function was deprecated in Rust
  let value: i32 = std::mem::uninitialized();
// {/fact}