/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=cross-site-scripting@v1.0 defects=0}
// Compliant: Disabled JavaScript support for WebViews
fun compliant() {
    val webView: WebView = findViewById(R.id.webview)
    webView.getSettings().setJavaScriptEnabled(false)
}
// {/fact}
