/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


class InsufficientlyProtectedCredentialsNoncompliant {
  val secretKey = "foobar"
  // {fact rule=insufficiently-protected-credentials@v1.0 defects=1}
  def nonCompliant(token: String) = {
    val algo = JwtAlgorithm.HS256
    // Noncompliant: hardcoded JWT secret is used.
    JwtArgonaut.decodeJson(token, secretKey, algo)
  }
  // {/fact}
}