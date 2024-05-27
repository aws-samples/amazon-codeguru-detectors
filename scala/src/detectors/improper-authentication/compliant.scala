/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import org.opensaml.xml.parse.BasicParserPool

class ImproperAuthenticationCompliant{

    // {fact rule=improper-authentication@v1.0 defects=0}
    def compliant(): BasicParserPool = {
        val parserPool = new BasicParserPool
        // Compliant: Defining a method to create a parser pool with ignoreComments set to true.
        parserPool.setIgnoreComments(true)
        parserPool
    }
    // {/fact}

}