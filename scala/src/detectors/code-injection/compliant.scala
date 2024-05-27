/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import org.springframework.expression.spel.standard.SpelExpressionParser

class CodeInjectionCompliant {
  val parser = new SpelExpressionParser()

  // {fact rule=code-injection@v1.0 defects=0}
  def compliant(untrustedInput: String): Unit = {
    val sanitizedInput = sanitizeInput(untrustedInput)
    // Compliant: Sanitized input is parsed as an expression.
    val expression = parser.parseExpression(sanitizedInput)
  }
  // {/fact}

}