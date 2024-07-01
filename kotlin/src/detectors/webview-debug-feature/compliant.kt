/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=detect-activated-debug-feature@v1.0 defects=0}
// Compliant: The Debug feature should not be enabled or overridden.
fun compliant() {
   WebView.setWebContentsDebuggingEnabled(false)
}
// {/fact}
