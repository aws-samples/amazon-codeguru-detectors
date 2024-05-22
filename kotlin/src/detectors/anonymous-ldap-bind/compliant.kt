/*
*  Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
*  SPDX-License-Identifier: Apache-2.0
*/

// {fact rule=improper-authentication@v1.0 defects=0}
// Compliant: Enforcing authentication for LDAP statements
fun compliant(env: Environment): Void {
    env.put(Context.SECURITY_AUTHENTICATION, "simple")
    val ctx: DirContext = InitialDirContext(env)
}
// {/fact}
