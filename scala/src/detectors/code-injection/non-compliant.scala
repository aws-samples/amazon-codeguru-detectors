/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import org.springframework.expression.spel.standard.SpelExpressionParser

class CodeInjectionNoncompliant {
  val parser = new SpelExpressionParser()

  // {fact rule=code-injection@v1.0 defects=1}
  def nonCompliant(untrustedInput: String): Unit = {
    // Noncompliant: Untrusted input is parsed as an expression.
    val expression = parser.parseExpression(untrustedInput)
  }
  // {/fact}

}