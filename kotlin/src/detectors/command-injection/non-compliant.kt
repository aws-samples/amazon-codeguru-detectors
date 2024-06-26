/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=os-command-injection@v1.0 defects=1}
// Noncompliant: User input is being passed to `exec`
fun noncompliant() {
    print("Enter your input:")
    val input = readLine()

    val command = "echo Hello, $input"
    val process = Runtime.getRuntime().exec(String.format("The value is: %s", command))
}
// {/fact}
