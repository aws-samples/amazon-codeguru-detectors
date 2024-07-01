/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import org.apache.xmlrpc.client.XmlRpcClientConfigImpl

object DeserializationOfUntrustedDataNoncompliant {
    // {fact rule=deserialization-of-untrusted-data@v1.0 defects=1}
    def nonCompliant(): Unit = {
        val clientCfg = new XmlRpcClientConfigImpl
        // Noncompliant: Enabled extensions within an Apache XML-RPC server.
        clientCfg.setEnabledForExtensions(true)
    }
    // {/fact}

}