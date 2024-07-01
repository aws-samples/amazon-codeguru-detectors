/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=code-injection@v1.0 defects=1}
// Noncompliant: User input gets executed as a expression.
fun noncompliant() {
    val input = request.getParameter("expr")
    val jexl: JexlEngine = JexlBuilder().create()
    val expression: JexlExpression = jexl.createExpression(input)
    val context: JexlContext = MapContext()
    expression.evaluate(context)
}
// {/fact}
