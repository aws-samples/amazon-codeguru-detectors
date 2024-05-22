/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=improper-export-of-android-app-components@v1.0 defects=1}
// Noncompliant: Broadcasted intents are available to all applications
fun noncompliant(intent: Intent, context: Context,) {
    context.sendBroadcast(intent) 
}
// {/fact}
