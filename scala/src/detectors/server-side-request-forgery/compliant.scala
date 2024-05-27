/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import java.io.IOException
import dispatch._
import Defaults._
import scala.io.{Codec, Source}
import scalaj.http.{Http, Token}

object ServerSideRequestForgeryCompliant {
     // {fact rule=server-side-request-forgery@v1.0 defects=0}
    def compliant(): Future[Unit] = {
        // Compliant: The code sends a request to a fixed, known URL, mitigating the risk of server-side request forgery (SSRF).
        val req = url("https://www.google.com")
        val data = Http.default(req OK as.String)
        data
    }
    // {/fact}
}