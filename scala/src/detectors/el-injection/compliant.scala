/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import javax.el._
import javax.faces.context.FacesContext


class ElInjectionCompliant {
    // {fact rule=el-injection@v1.0 defects=0}
    def compliant(expression: String) = {
        val context = FacesContext.getCurrentInstance
        val expressionFactory = context.getApplication.getExpressionFactory
        val elContext = context.getELContext
        // Compliant: User input is not directly used in creating or evaluating EL expression.
        val vex = expressionFactory.createValueExpression(elContext, "#{bean.property}", classOf[String])
        vex.getValue(elContext).asInstanceOf[Nothing]
    }
    // {/fact}
}
