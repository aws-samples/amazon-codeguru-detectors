/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=path-traversal@v1.0 defects=0}
// Compliant: Using safe input to access a file path
fun compliant(filename: String) {
    val file = File(filename)
    val lines = file.readLines()
    for (line in lines) {
        println(line)
    }
}
// {/fact}
