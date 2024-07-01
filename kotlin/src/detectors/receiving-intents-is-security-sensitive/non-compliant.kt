/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=improper-verification-of-intent@v1.0 defects=1}
// Noncompliant: Intent receiver method is registered without specifying any broadcast permission
fun noncompliant(
    context: Context, receiver: BroadcastReceiver?,
    filter: IntentFilter?,
    scheduler: Handler?,
    flags: Int
) {
    context.registerReceiver(receiver, filter) // Sensitive

    context.registerReceiver(receiver, filter, flags) // Sensitive

}
// {/fact}
