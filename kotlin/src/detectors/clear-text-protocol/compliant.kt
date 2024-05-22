/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=insecure-connection@v1.0 defects=0}
// Compliant: Using clear-text protocols such as `ftps` which is secure
fun compliant() {
    val ftpsClient = FTPSClient(true);
}
// {/fact}
