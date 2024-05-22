/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=cross-site-scripting@v1.0 defects=0}
// Compliant: Not using any unsanitized external inputs
fun compliant() {
    print("Enter your name:")
    val name = readLine()

    val writer = PrintWriter(System.out)
    writer.write("<p>Hello, name!</p>")
}
// {/fact}
