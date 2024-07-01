/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=server-side-request-forgery@v1.0 defects=0}
// Compliant: Pre-defined data passed to respondText().
fun compliant() {
    embeddedServer(Netty, port = 8080) {
        routing {
            post("/proxy/{url}") {
                val url = "<hardcoded_url>"
                if (url != null) {
                    val data = URL(url).readText()
                    call.respondText(data)
                }
            }
        }
    }.start(wait = true)
}
// {/fact}