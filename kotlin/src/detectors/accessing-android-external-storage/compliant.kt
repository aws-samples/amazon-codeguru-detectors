/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=cleartext-storage-of-sensitive-information@v1.0 defects=0}
// Compliant: `context.getExternalFilesDir` is not from Context object
fun compliant(context : ContextOther) {
   context.getExternalFilesDir("filepath")
}
// {/fact}
