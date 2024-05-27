/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

import scala.scalajs.js

// {fact rule=jseval@v1.0 defects=0}
object JsevalCompliant {
  def compliant(param: Int) = {
    val result = param * 2
    // Compliant: User input is not used in `eval()`.
    js.eval("FooBar()")
  }
}
// {/fact}