/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


import org.apache.velocity.VelocityContext
import org.apache.velocity.app.Velocity
import java.io._

// {fact rule=template-injection@v1.0 defects=1}
class TemplateInjectionNoncompliant {
  @throws[FileNotFoundException]
  def nonCompliant(inputFile: String): Unit = {
    Velocity.init
    val context = new VelocityContext
    context.put("author", "Elliot A.")
    context.put("address", "217 E Broadway")
    context.put("phone", "555-1337")
    val file = new FileInputStream(inputFile)
    val swOut = new StringWriter
    // Noncompliant: User input is directly used in evaluating templates without proper validation or sanitization.
    Velocity.evaluate(context, swOut, "test", file.toString)
    val result = swOut.getBuffer.toString
    System.out.println(result)
  }
}
// {/fact}
