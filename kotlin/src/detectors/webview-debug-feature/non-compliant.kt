/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=detect-activated-debug-feature@v1.0 defects=1}
// Noncompliant: The Debug feature should not be enabled or overridden.
fun noncompliant() {
    WebView.setWebContentsDebuggingEnabled(true)
}
// {/fact}
