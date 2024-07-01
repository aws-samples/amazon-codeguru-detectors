/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=cryptographic-key-generator@v1.0 defects=1}
// Noncompliant: `DefaultHttpClient` is used for setting up HTTP connection.
fun noncompliant() {
    val client: HttpClient = DefaultHttpClient()
    val request: HttpGet = HttpGet("http://google.com")
    val response: HttpResponse= client.execute(request)
}
// {/fact}
