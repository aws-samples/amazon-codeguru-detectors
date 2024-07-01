/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import javax.ws.rs.Path
import javax.jws.WebService

@Path("/test")
@WebService
class InsecureJaxEndpointUsageCompliant {

    // {fact rule=insecure-jax-endpoint-usage@v1.0 defects=0}
    @Path("/hello2")
    def compliant(user: String) = {
        // Compliant: Sanitized user input used in web services
        val sanitized = StringEscapeUtils.unescapeJava(user)
        "Hello " + sanitized
    }
    // {/fact}
}