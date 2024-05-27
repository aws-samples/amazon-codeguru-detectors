/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


import scala.scalajs.js

// {fact rule=jseval@v1.0 defects=1}
object JsevalNoncompliant {
  def nonCompliant(script: String) = {
    // Noncompliant: User input is used in `eval()`.
    js.eval(script)
  }
}
// {/fact}