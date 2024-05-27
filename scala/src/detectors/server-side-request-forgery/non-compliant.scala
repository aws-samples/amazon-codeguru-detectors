/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


import java.io.IOException
import dispatch._
import Defaults._
import scala.io.{Codec, Source}
import scalaj.http.{Http, Token}

object ServerSideRequestForgeryNoncompliant {
     // {fact rule=server-side-request-forgery@v1.0 defects=1}
    def nonCompliant(request_url: String): Future[Unit] = {
        // Noncompliant: Potential server-side request forgery (SSRF) vulnerability as 'request_url' is controlled by user input.
        val req = url(request_url)
        val data = Http.default(req OK as.String)
        data
    }
    // {/fact}
}