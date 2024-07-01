/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=os-command-injection@v1.0 defects=0}
// Compliant: Hardcoded value is being passed to `exec`
fun compliant() {
    val directory = "hardcoded_value"

    val command = "ls -l " + directory
    val r: Runtime = Runtime.getRuntime()
    val process = r.exec(command)  
}
// {/fact}
