/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


import org.opensaml.xml.parse.BasicParserPool

class ImproperAuthenticationNoncompliant{

    // {fact rule=improper-authentication@v1.0 defects=1}
    def nonCompliant(): BasicParserPool = {
        val parserPool = new BasicParserPool
        // Noncompliant: Defining a method to create a parser pool with ignoreComments set to false.
        parserPool.setIgnoreComments(false)
        parserPool
    }
    // {/fact}

}