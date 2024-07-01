/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=code-injection@v1.0 defects=0}
// Compliant: Pre-defined string gets executed as a expression.
fun compliant() {
    val input = "hardcoded-value"
    val jexl: JexlEngine = JexlBuilder().create()
    val expression: JexlExpression = jexl.createExpression(input)
    val context: JexlContext = MapContext()
    expression.evaluate(context)        
}
// {/fact}
