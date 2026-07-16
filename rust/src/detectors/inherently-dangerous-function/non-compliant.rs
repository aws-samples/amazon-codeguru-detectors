/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=inherently-dangerous-function@v1.0 defects=1}
// Noncompliant: A raw null pointer without pointing to any valid memory location.
unsafe fn noncompliant() {
    let ptr: *const i32 = std::ptr::null();
    let val = unsafe { *ptr };
}
// {/fact}