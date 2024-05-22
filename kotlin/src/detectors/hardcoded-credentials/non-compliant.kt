/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=hardcoded-credentials@v1.0 defects=1}
// Noncompliant: Password is hardcoded
fun noncompliant() {
    val username = "admin"
    val password = "password123"
    val ssh = SSHClient()
    ssh.authPassword(username, password)
}
// {/fact}