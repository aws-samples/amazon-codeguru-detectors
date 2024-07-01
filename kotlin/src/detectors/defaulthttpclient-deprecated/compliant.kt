/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=cryptographic-key-generator@v1.0 defects=0}
// Compliant: `DefaultHttpClient` is not used for setting up HTTP connection.
fun compliant() {
    val client: HttpClient = SystemDefaultHttpClient()
    val request: HttpGet = HttpGet("http://google.com")
    val response: HttpResponse= client.execute(request)
}
// {/fact}
