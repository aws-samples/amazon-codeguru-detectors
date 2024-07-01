/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=hardcoded-credentials@v1.0 defects=0}
// Compliant: Password is retrieved from environment variables.
fun compliant() {
    val username = System.getenv("SSH_USERNAME")
    val password = System.getenv("SSH_PASSWORD")
    val ssh = SSHClient()
    ssh.authPassword(username, password)
}
// {/fact}