/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=cross-site-scripting@v1.0 defects=1}
// Noncompliant: Using unsanitized external inputs which leads to XSS
fun noncompliant() {
    print("Enter your name:")
    val name = readLine()

    val writer = PrintWriter(System.out)
    writer.write("<p>Hello, $name!</p>")
}
// {/fact}
