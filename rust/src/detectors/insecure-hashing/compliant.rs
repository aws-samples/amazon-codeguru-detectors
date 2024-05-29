/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-hashing@v1.0 defects=0}
// Compliant: Secure hashing algorithm SHA256 used
   use sha256::{Sha256};
   let mut hasher = Sha256::new();
// {/fact}