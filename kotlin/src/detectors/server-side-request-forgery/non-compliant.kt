/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=server-side-request-forgery@v1.0 defects=1}
// Noncompliant: User input data passed to respondText().
fun noncompliant() {
    embeddedServer(Netty, port = 8080) {
        routing {
            post("/proxy/{url}") {
                val url = call.request.queryParameters["url"]
                if (url != null) {
                    val data = URL(url).readText()
                    call.respondText(data)
                }
            }
        }
    }.start(wait = true)
}
// {/fact}