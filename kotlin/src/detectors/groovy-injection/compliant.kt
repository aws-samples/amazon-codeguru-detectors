/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=code-injection@v1.0 defects=0}
// Compliant: Pre-defined string gets executed as a code.
fun compliant() {
    val shell = GroovyShell()
    val script: String = request.getParameter("script")
    shell.evaluate("script")
}
// {/fact}
