/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import javax.ws.rs.Path
import javax.jws.WebService

@Path("/test")
@WebService
class InsecureJaxEndpointUsageNoncompliant {
    
    // {fact rule=insecure-jax-endpoint-usage@v1.0 defects=1}
    @Path("/hello1")
    def nonCompliant(user: String) = {
        val tainted = randomFunc(user)
        // Noncompliant: User input used in web services
        "Hello " + tainted
    }
    // {/fact}
}