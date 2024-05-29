/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=inherently-dangerous-function@v1.0 defects=0}
// Compliant: attempts to prevent dereferencing a null pointer
unsafe fn compliant2() {
     let ptr: *const i32 = std::ptr::null();
     if !ptr.is_null() {
         let val = unsafe { *ptr };
     }
}
// {/fact}