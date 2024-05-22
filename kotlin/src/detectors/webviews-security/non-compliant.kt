/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=cross-site-scripting@v1.0 defects=1}
// Noncompliant: Enabled JavaScript support for WebViews
fun noncompliant() {
    val webView: WebView = findViewById(R.id.webview)
    webView.getSettings().setJavaScriptEnabled(true) // Sensitive
}
// {/fact}
