/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import javax.el._
import javax.faces.context.FacesContext


class ElInjectionNoncompliant {
    // {fact rule=el-injection@v1.0 defects=1}
    def nonCompliant(expression: String) = {
        val context = FacesContext.getCurrentInstance
        val expressionFactory = context.getApplication.getExpressionFactory
        val elContext = context.getELContext
        // Noncompliant: User input is directly used in creating or evaluating EL expression.
        val vex = expressionFactory.createValueExpression(elContext, expression, classOf[Nothing])
        vex.getValue(elContext).asInstanceOf[Nothing]
    }
    // {/fact}
}
