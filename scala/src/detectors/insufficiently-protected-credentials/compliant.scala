/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/


// {fact rule=insufficiently-protected-credentials@v1.0 defects=0}
class InsufficientlyProtectedCredentialsCompliant {
    def compliant(token: String) = {
    val algo = JwtAlgorithm.HS256
    // Compliant: `getSecretFromEnv` method used to get JWT secret.
    JwtArgonaut.decodeJson(token, getSecretFromEnv(), algo)
  }
}
// {/fact}