/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=improper-verification-of-intent@v1.0 defects=0}
// Compliant: Intent receiver method is registered with a limiting broadcasting permission.
fun compliant(
    context: Context, receiver: BroadcastReceiver?,
    filter: IntentFilter?,
    broadcastPermission: String?,
    scheduler: Handler?,
    flags: Int
) {
    context.registerReceiver(receiver, filter, broadcastPermission, scheduler)
}
// {/fact}
