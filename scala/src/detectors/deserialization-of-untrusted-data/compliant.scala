/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import org.apache.xmlrpc.client.XmlRpcClientConfigImpl

object DeserializationOfUntrustedDataCompliant {
    // {fact rule=deserialization-of-untrusted-data@v1.0 defects=0}
    def compliant(): Unit = {
        val clientCfg = new XmlRpcClientConfigImpl
        // Compliant: Disabled extensions within an Apache XML-RPC server.
        clientCfg.setEnabledForExtensions(false)
    }
    // {/fact}

}