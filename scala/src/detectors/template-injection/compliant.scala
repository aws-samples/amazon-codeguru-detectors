/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


import java.io.IOException
import java.io.StringWriter
import java.util.HashMap

import com.mitchellbosecke.pebble.PebbleEngine
import com.mitchellbosecke.pebble.template.PebbleTemplate

// {fact rule=template-injection@v1.0 defects=0}
class TemplateInjectionCompliant {
  @throws[IOException]
  def compliant(inputFile: String): String = {
    val engine = new PebbleEngine.Builder().build
    var compiledTemplate: PebbleTemplate = null
    val context = new HashMap[String, Object]
    context.put("name", "Shivam")
    val writer = new StringWriter
    try {
      // Compliant: User input is not directly used in any code.
      compiledTemplate.evaluate(writer, context)
    } catch {
      case e: Exception =>
        e.printStackTrace()
        throw new IOException("Error while evaluating template", e)
    }
    writer.toString
  }
}
// {/fact}
