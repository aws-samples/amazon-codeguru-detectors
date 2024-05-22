/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=improper-export-of-android-app-components@v1.0 defects=0}
// Compliant: Access to broadcasting intents should be limited
fun compliant(intent: Intent, context: Context, broadcastPermission: String) {
    context.sendBroadcast(intent, broadcastPermission) 
}
// {/fact}
