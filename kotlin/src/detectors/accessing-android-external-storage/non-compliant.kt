/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=cleartext-storage-of-sensitive-information@v1.0 defects=1}
// Noncompliant: `context.getExternalFilesDir` returns absolute path to the directory on the primary shared/external storage device
fun noncompliant(context : Context) {
   context.getExternalFilesDir("filepath://")
}
// {/fact}
