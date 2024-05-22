/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=code-injection@v1.0 defects=1}
// Noncompliant: User input gets executed as a code.
fun noncompliant() {
    val shell = GroovyShell()
    val script: String = request.getParameter("script")
    shell.evaluate(script)
}
// {/fact}
